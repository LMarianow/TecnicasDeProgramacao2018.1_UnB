package oberon.expression

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestDivExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "an division expressions"

  it should "return value 2 in Div(IntValue(10), IntValue(5))" in {
    val val5  = IntValue(5)
    val val10 = IntValue(10)
    val div   = new DivExpression(val10, val5) 

    div.eval() should be (IntValue(2)) 
  }

  it should "lead to an exception in Div(IntValue(5), BoolValue(False))" in {
    val val5 = IntValue(5)
    val valf = BoolValue(false)
    val div = new DivExpression(val5, valf)

   // add.eval() should be (IntValue(5))
  }
}
