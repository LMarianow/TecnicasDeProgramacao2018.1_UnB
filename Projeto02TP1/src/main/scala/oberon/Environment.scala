package oberon


import scala.collection.mutable.Stack
import scala.collection.mutable.Map
import scala.collection.mutable.HashMap

import oberon.command._
import oberon.expression._

object Environment {
  // a stack for mapping values
  var stack = new Stack[Map[String, Value]] ()
  // defines the scope of a function
  var defineFunction = new HashMap[String, FunctionDeclaration] ()
  // defines the scope of a procedure
  var defineProcedure = new HashMap[String, ProcedureDeclaration] ()

  def push() {
    stack.push(new HashMap[String, Value]())
  }

  def pop() {
    stack.pop()
  }

  def lookArgs(): Iterable[String] ={
    return stack.top.keySet
  }

  def map(id: String, value: Value) {
    if(stack.isEmpty) {
      push()
    }
	//last = global variables
    // verifies if there are any global variables in the scope, and adds the global variable to
    // the scope
	if(stack.last.contains(id)) stack.last += (id -> value)
    else stack.top += (id -> value) 
  }
    // returns the top element of the stack by it's id, if there is any element
  def lookup(id: String) : Option[Value] =
    if(stack.isEmpty) None else Some(stack.top(id))

  def clear() : Unit = { stack.clear() }

  def lookupFuncDef(id: String) : FunctionDeclaration = defineFunction(id) //
   
  def lookupProcDef(id: String) : ProcedureDeclaration = defineProcedure(id) //
}
