package oberon.expression

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestSubExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "an sub expressions"

  it should "return value 5 in Sub(IntValue(10), IntValue(5))" in {
    val val5  = IntValue(5)
    val val10 = IntValue(10)
    val sub   = new SubExpression(val10, val5) 

    sub.eval() should be (IntValue(5)) 
  }

  it should "lead to an exception in Sub(IntValue(5), BoolValue(False))" in {
    val val5 = IntValue(5)
    val valf = BoolValue(false)
    val sub = new SubExpression(val5, valf)

   // add.eval() should be (IntValue(5))
  }
}
