package oberon.command

import oberon.command._
import oberon.expression._
import oberon.Environment._

import oberon.visitor.Visitable
import oberon.visitor.Visitor

class ProcedureCommand(val nome: String, val arguments: List[Expression]) extends Command {
  
  override
  def run() : Unit = {
    
    val defineProc = lookupProcDef(nome)
  
    push()
    for (i <- 0 until arguments.size) {

      val(variable, tipo) = defineProc.arguments(i)

      new Assignment(variable, arguments(i)).run()
    }
    
    defineProc.command.run()
    pop()

  }
  override
    def checa_tipo_comando() : Boolean = {

    // defines the scope by the function name
    val defineProc = lookupProcDef(nome)

    for (i <- 0 until arguments.size) {
      val(variable, tipo) = defineProc.arguments(i)
      if (tipo != arguments(i).calculateType()) false
    }
    true
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }
}