package oberon

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

import oberon.command._
import oberon.expression._
import oberon.Environment._

class TestProcedureCommand extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter 
{

  behavior of "an declaration of a procedure"

  before 
  {
    clear()
  }

  it should "be resultado == IntValue(2) in return Procedure 'soma' " in 
  {
    val a1 = new VarDeclaration("resultado")
	val a2 = new AddExpression(new VarRef("x"), new VarRef("y"))
	val a3 = new Assignment("resultado",a2)
	val a4 = new ProcedureDeclaration("soma", List(("x", TInt()), ("y", TInt())), a3)

	val b1 = new ProcedureCommand("soma", List(IntValue(1), IntValue(1)))
    a1.run()
    b1.run()

	lookup("resultado") should be (Some(IntValue(2)))

  }

  it should "be resultado == IntValue(10) in return Procedure 'subtracao' " in 
  {
    val a1 = new VarDeclaration("resultado")
	val a2 = new SubExpression(new VarRef("x"), new VarRef("y"))
	val a3 = new Assignment("resultado",a2)
	val a4 = new ProcedureDeclaration("subtracao", List(("x", TInt()), ("y", TInt())), a3)

	val b1 = new ProcedureCommand("subtracao", List(IntValue(15), IntValue(5)))
    a1.run()
    b1.run()

	lookup("resultado") should be (Some(IntValue(10)))

  }
  
}