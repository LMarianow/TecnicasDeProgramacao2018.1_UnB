package oberon

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


import oberon.command._
import oberon.expression._
import oberon.Environment._

class TestFunctionExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter 
{

  behavior of "an declaration of a function"

  before 
  {
    clear()
  }

  it should "be func == IntValue(6) in return function call 'soma' " in 
  {
	val a1 = new AddExpression(new VarRef("x"), new VarRef("y"))
    val a2 = new FunctionDeclaration(TInt(), "soma", List(("x", TInt()), ("y", TInt())), Return(a1))

	val func = new FunctionExpression("soma", List(IntValue(3), IntValue(3)))
	
	func.eval() should be (IntValue(6))
  }

  it should "be func == IntValue(8) in return function call 'subtracao' " in 
  {
	val a1 = new SubExpression(new VarRef("x"), new VarRef("y"))
    val a2 = new FunctionDeclaration(TInt(), "subtracao", List(("x", TInt()), ("y", TInt())), Return(a1))

    val func = new FunctionExpression("subtracao", List(IntValue(14), IntValue(6)))

    func.eval() shouldBe IntValue(8)
  }

}