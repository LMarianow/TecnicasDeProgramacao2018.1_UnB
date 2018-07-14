package oberon.expression

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestMultiExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "an multiplication expressions"

  it should "return value 50 in Multi(IntValue(5), IntValue(10))" in {
    val val5  = IntValue(5)
    val val10 = IntValue(10)
    val multi   = new MultiExpression(val5, val10) 

    multi.eval() should be (IntValue(50)) 
  }

  it should "lead to an exception in Multi(IntValue(5), BoolValue(False))" in {
    val val5 = IntValue(5)
    val valf = BoolValue(false)
    val multi = new MultiExpression(val5, valf)

   // add.eval() should be (IntValue(5))
  }
}
