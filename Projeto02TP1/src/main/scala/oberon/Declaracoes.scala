package oberon

import oberon.Environment._
import oberon.expression._
import oberon.command._

import oberon.visitor.Visitable
import oberon.visitor.Visitor

class VarDeclaration(val id: String) extends Visitable 
{
  def run() : Unit = {
    map(id, Undefined())
  }

  def checa_tipo_comando() : Boolean = true

  override def accept(v : Visitor) {
    v.visit(this) 
  } 
}

class FunctionDeclaration(val tipo: Type, val nome: String, val arguments: List[(String, Type)], val command: Command) extends Visitable {
  // defines the scope of the function
  defineFunction += (nome -> this)

	override 
	def accept(v : Visitor) {
    v.visit(this) 
  } 

}

class ProcedureDeclaration(val nome: String, val arguments: List[(String, Type)], val command: Command) {
  defineProcedure += (nome -> this)
}


