package oberon.visitor
import oberon.expression._
import oberon.command._
import oberon.{_}
trait Visitable { 
def accept(v : Visitor) : Unit 
 } 
trait Visitor { 
def visit (e:ProcedureCommand) : Unit
def visit (e:ProcedureDeclaration) : Unit
def visit (e:IntValue) : Unit
def visit (e:AddExpression) : Unit
def visit (e:For) : Unit
def visit (e:FunctionExpression) : Unit
def visit (e:FunctionDeclaration) : Unit
def visit (e:BoolValue) : Unit
def visit (e:SubExpression) : Unit
def visit (e:Print) : Unit
def visit (e:Undefined) : Unit
def visit (e:MultiExpression) : Unit
def visit (e:If_Then) : Unit
def visit (e:DivExpression) : Unit
def visit (e:If_Then_Else) : Unit
def visit (e:ModExpression) : Unit
def visit (e:While) : Unit
def visit (e:NotEqExpression) : Unit
def visit (e:BlockCommand) : Unit
def visit (e:MinExpression) : Unit
def visit (e:VarRef) : Unit
def visit (e:BigExpression) : Unit
def visit (e:VarDeclaration) : Unit
def visit (e:OberonProgram) : Unit
def visit (e:BigOrEqExpression) : Unit
def visit (e:Assignment) : Unit
def visit (e:MinOrEqExpression) : Unit
def visit (e:Return) : Unit
def visit (e:OrExpression) : Unit
def visit (e:AndExpression) : Unit
def visit (e:EqExpression) : Unit
def visit (e:NotExpression) : Unit
}
// e ---> expression c ---> command Trocar por exp e com sei la resolver isso