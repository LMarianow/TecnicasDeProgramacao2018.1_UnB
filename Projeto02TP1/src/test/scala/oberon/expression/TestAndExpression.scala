package oberon.expression

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestAndExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "an and expression"

  it should "return value false in And(BoolValue(true), BoolValue(false))" in {
    val valt = BoolValue(true)
    val valf = BoolValue(false)  
    val and  = new AndExpression(valt, valf)

    and.eval() should be (BoolValue(false)) 
  }
  it should "return value true in And(BoolValue(true), BoolValue(true))" in {
    val valt = BoolValue(true)
    val valt1 = BoolValue(true)  
    val and   = new AndExpression(valt, valt1)

    and.eval() should be (BoolValue(true)) 
  }
  it should "return value false in And(BoolValue(false), BoolValue(false))" in {
    val valf = BoolValue(false)
    val valf1 = BoolValue(false)  
    val and   = new AndExpression(valf, valf1)

    and.eval() should be (BoolValue(false)) 
  }


}