package oberon.expression

import oberon.Environment._
import oberon.command.{_}
import oberon.expression._
import oberon.visitor.Visitor

class VarRef(val id: String) extends Expression { // Realiza a pesquisa na pilha o valor daquela string que vc passou 
  
  override
  def eval() : Value = lookup(id) match {
    case Some(v) => v
    case _       => Undefined()   
  }

   override
  def calculateType() : Type = lookup(id) match {
    case Some(v) => v.calculateType()
    case _       => TUndefined()  
  }

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}
