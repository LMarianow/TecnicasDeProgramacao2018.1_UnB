package oberon.command

import oberon.Environment._
import oberon.expression._

import oberon.visitor.Visitable
import oberon.visitor.Visitor

trait Command extends Visitable{
  def run() : Unit 
  def checa_tipo_comando() : Boolean
}

class BlockCommand(val cmds: List[Command]) extends Command {

  override
  def run() : Unit = {
    cmds.foreach(c => c.run())
  }
  override
  def checa_tipo_comando() : Boolean = cmds.forall(c => c.checa_tipo_comando())

  override def accept(v : Visitor) {
    v.visit(this) 
  }
}

case class Return(val expression: Expression) extends Command {

  override
  def run() : Unit = { }
  
   // o checa_tipo_comando() deve ser feito com base no tipo de saida da funcao
  override 
  def accept(v : Visitor): Unit = v.visit(this)
  override
  def checa_tipo_comando(): Boolean = expression.typeCheck()
}

class Assignment(val id: String, val expression: Expression) extends Command {

  override
  def run() : Unit = {
    map(id, expression.eval())
  }

  override
  def checa_tipo_comando() : Boolean = expression.typeCheck()

  override def accept(v : Visitor) {
    v.visit(this) 
  }
}

class While(val cond: Expression, val command: Command) extends Command {
  override
  def run() : Unit = {
    val v = cond.eval.asInstanceOf[BoolValue]

    v match {
      case BoolValue(true) => { command.run(); this.run(); }
      case _               => { } 
    }
  }


  def checa_tipo_comando() : Boolean = cond.calculateType() == TBool() && command.checa_tipo_comando()

  override def accept(v : Visitor) {
    v.visit(this) 
  }
}


class If_Then(val condicao: Expression , val If: Command ) extends Command
{
  override
  def run(): Unit =
  {
    val analise = condicao.eval.asInstanceOf[BoolValue]

    analise match 
    {
      case BoolValue(true) => { If.run(); }
      case BoolValue(false) => { } 
    } 
  }
  override
  def checa_tipo_comando() : Boolean = If.checa_tipo_comando() 

  override
  def accept(v : Visitor) {
    v.visit(this)
  }
}

class If_Then_Else (val condicao:Expression , val If:Command , val Else: Command) extends Command
{
  override
  def run(): Unit =
  {
    val analise = condicao.eval.asInstanceOf[BoolValue]

    analise match 
    {
      case BoolValue(true) => {If.run() ; }
      case BoolValue(false) => { Else.run() ; } 
    }
      
  }
  override
  def checa_tipo_comando() : Boolean =  condicao.calculateType() == TBool() && If.checa_tipo_comando() && Else.checa_tipo_comando()

  override
  def accept(v : Visitor) {
    v.visit(this)
  }

}

class For (val condicao: Expression , val If: Command , val incrementador: Command , val command: Command) extends Command 
{
  If.run()

  override
  def run(): Unit =  
  {
    val analise = condicao.eval.asInstanceOf[BoolValue]
    analise match 
    {
      case BoolValue(true) => {command.run(); incrementador.run(); this.run();}
      case _               => { }  

    }
  }

   override
   def checa_tipo_comando() : Boolean = condicao.calculateType() == TBool() && command.checa_tipo_comando()

  override def accept(v : Visitor) {
    v.visit(this) 
  } 
}

class Print(val exp: Expression) extends Command 
{
  override
  def run() : Unit = 
  {
    print(exp.eval())
  }

   override
  def checa_tipo_comando() : Boolean = true

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}


