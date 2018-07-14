package oberon.expression

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestOrExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "an or expression"

  it should "return value true in Or(BoolValue(true), BoolValue(false))" in {
    val valt = BoolValue(true)
    val valf = BoolValue(false)  
    val or   = new OrExpression(valt, valf)

    or.eval() should be (BoolValue(true)) 
  }
  it should "return value true in Or(BoolValue(true), BoolValue(true))" in {
    val valt = BoolValue(true)
    val valt1 = BoolValue(true)  
    val or   = new OrExpression(valt, valt1)

    or.eval() should be (BoolValue(true)) 
  }
  it should "return value false in Or(BoolValue(false), BoolValue(false))" in {
    val valf = BoolValue(false)
    val valf1 = BoolValue(false)  
    val or   = new OrExpression(valf, valf1)

    or.eval() should be (BoolValue(false)) 
  }


}