package oberon.visitor

import oberon.Environment._
import oberon.expression._
import oberon.command._
import oberon.{_}
import oberon.visitor

// O PrettyPrinter fornece uma capacidade para estruturas de dados arbitrárias,ou seja, embeleza a impressão 

class PrettyPrinter extends Visitor {
  var str = ""

  def visit(e: Undefined)     : Unit = { str = "undefined" } 

  def visit(e: IntValue)      : Unit = { str = e.value.toString }

  def visit(e: BoolValue)     : Unit = { str = e.value.toString }

  def visit(e: AddExpression) : Unit = {
    val (l, r) = visitBinExp(e)
    str = "(" + l + " + " + r + ")" 
  }

   def visit(e: SubExpression) : Unit = {
    val (l, r) = visitBinExp(e)
    str = "(" + l + " - " + r + ")"
  }

  def visit(e: DivExpression) : Unit = {
    val (l, r) = visitBinExp(e)
    str = "(" + l + " / " + r + ")"
  }

  def visit(e: ModExpression) : Unit = {
    val (l, r) = visitBinExp(e)
    str = "(" + l + " % " + r + ")"
  }

  def visit(e: MultiExpression) : Unit = {
    val (l, r) = visitBinExp(e)
    str = "(" + l + " * " + r + ")"
  }

  def visit(e: MinExpression)  : Unit = {
    val (l, r) = visitBinExp(e)
    str = "(" + l + " < " + r + ")"
  }

  def visit(e: EqExpression)  : Unit = {
    val (l, r) = visitBinExp(e)
    str = "(" + l + " == " + r + ")"
  }

  def visit(e: MinOrEqExpression) : Unit = {
    val (l, r) = visitBinExp(e)
    str = "(" + l + " <= " + r + ")"
  }

  def visit(e: BigExpression) : Unit = {
    val (l, r) = visitBinExp(e)
    str = "(" + l + " > " + r + ")"
  }

  def visit(e: BigOrEqExpression) : Unit = {
    val (l, r) = visitBinExp(e)
    str = "(" + l + " >= " + r + ")"
  }

  def visit(e: AndExpression)  : Unit = {
    val (l, r) = visitBinExp(e)
    str = "(" + l + " && " + r + ")"
  }

  def visit(e: OrExpression)  : Unit = {
    val (l, r) = visitBinExp(e)
    str = "(" + l + " || " + r + ")"
  }

  def visit(e: NotExpression)  : Unit = {
    val (l, r) = visitBinExp(e)
    str = "( !" + l +  ")"
  }
  def visit(e: NotEqExpression)  : Unit = {
    val (l, r) = visitBinExp(e)
    str = "(" + l + " != " + r + ")"
  }
  def visit(e: PrettyPrinter)  : Unit = {
    
  }

  def visit(e: VarRef): Unit = { str = e.id } 
  
  def visit(c: BlockCommand)  : Unit = {
    str = "\nBloco_de_Comando\n"
    c.cmds.foreach{
      str += "COMMAND"+(_).accept(this)+"\n"
    }
  }

   def visit(c: Assignment): Unit = { 
    val exp = visitExp(c.expression)
    str = "var " + c.id + " = " + exp
  } 

  def visit(c: Return): Unit = {
    val exp = visitExp(c.expression)
    str = "return " + exp
  }



  def visit(c: If_Then): Unit = {
    val cond = visitExp(c.condicao.asInstanceOf[BinExpression])
    val command = visitCommand(c.If)

    str = "if" +  cond  + "{" + command + "}"
  }

   def visit(c: If_Then_Else): Unit = 
   {
    val cond = visitExp(c.condicao.asInstanceOf[BinExpression])
    val command1 = visitCommand(c.If)
    val command2 = visitCommand(c.Else)

    str = "if" + cond + "{" + command1 + "}" + "\n" + "else" + "{" + command2 + "}"
  }

   def visit(c: While): Unit = 
   { 
      val cond = visitExp(c.cond)
      val cmds = visitCommand(c.command)
      
      str = "while" + cond + "\n" + "{"  + cmds + "}" 
   }

  def visit(c: For): Unit = 
   { 
      val cond = visitExp(c.condicao)
      val if1 = visitCommand(c.If)
      val incrementa = visitCommand(c.incrementador)
      val comando = visitCommand(c.command)
      
      str = "For {" + comando + if1 + incrementa + "}" 
   }
  
  def visit(d: ProcedureCommand)     : Unit = { 
  
	val define = lookupProcDef(d.nome)
    var strArgs = ""
    val command = visitCommand(define.command)

    for(i <- 0 until define.arguments.size-1) {
      strArgs += define.arguments(i)._1 + ","
    }

    strArgs += define.arguments(define.arguments.size-1)._1

    str = "function" + define.nome + "(" + strArgs + ")" + "{" + command + "}"
  }


  def visit(c: ProcedureDeclaration)     : Unit = { 
  
	var strArgs = ""
    val command = visitCommand(c.command)

    for(i <- 0 until c.arguments.size-1) {
      strArgs += c.arguments(i)._1 + ","
    }

    strArgs += c.arguments(c.arguments.size-1)._1

    str = "procedure" + c.nome + "(" + strArgs + ")" + "{" + command + "}"
  }

  def visit(e: FunctionExpression) : Unit = 
  { 
    val define = lookupFuncDef(e.nome)
    var strArgs = ""
    val command = visitCommand(define.command)

    for(i <- 0 until define.arguments.size-1) {
      strArgs += define.arguments(i)._1 + ","
    }

    strArgs += define.arguments(define.arguments.size-1)._1

    str = "function" + define.nome + "(" + strArgs + ")" + "{" + command + "}"
  }

  def visit(d: FunctionDeclaration) : Unit = { 
	
	var strArgs = ""
    val command = visitCommand(d.command)

    for(i <- 0 until d.arguments.size-1) {
      strArgs += d.arguments(i)._1 + ","
    }
    strArgs += d.arguments(d.arguments.size-1)._1

    str = "function" + d.nome + "(" + strArgs + ")" + "{" + command + "}"
  }

  def visit(c: VarDeclaration): Unit = { }
  def visit(c: Print)         : Unit = { }
  def visit(c: OberonProgram) : Unit = { }

  private def visitBinExp(e: BinExpression) : (String, String) = {
    e.lhs.accept(this)
    val l = str

    e.rhs.accept(this)
    val r = str

    return (l, r) 
  }

   private def visitCommand(c: Command): String = {
    c.accept(this)
    val cmd = str

    return cmd 
  }

   private def visitExp(e: Expression): String = {
    e.accept(this)
    val exp = str

    return exp 
  }
}