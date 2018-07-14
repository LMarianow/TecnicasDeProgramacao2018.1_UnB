package oberon.expression

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestModExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "a module expression"

  it should "return value 1 in ModExpression(IntValue(9), IntValue(8))" in {
    val val1  = IntValue(9)
    val val2  = IntValue(8)
    val module   = new ModExpression(val1, val2) 

    module.eval() should be (IntValue(1)) 
  }

  it should "return value 0 in ModExpression(IntValue(4), IntValue(2))" in {
    val val3  = IntValue(4)
    val val4 = IntValue(2)
    val module   = new ModExpression(val3, val4) 

    module.eval() should be (IntValue(0)) 
  }
}