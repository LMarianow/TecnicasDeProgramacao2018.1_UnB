/*package oberon.expression

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestNotEqExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "an not equal expression"

  it should "return value true in Not(BoolValue(true), BoolValue(false))" in {
    val valt = BoolValue(true)
    val valf = BoolValue(false)  
    val not   = new NotEqExpression(valt, valf)

    not.eval() should be (BoolValue(true)) 
  }
  it should "return value false in Not(BoolValue(true), BoolValue(true))" in {
    val valt = BoolValue(true)
    val valt1 = BoolValue(true)  
    val not   = new NotEqExpression(valt, valt1)

    not.eval() should be (BoolValue(false)) 
  }
  it should "return value true in Not(BoolValue(false), BoolValue(false))" in {
    val valf = BoolValue(false)
    val valf1 = BoolValue(false)  
    val not   = new NotEqExpression(valf, valf1)

    not.eval() should be (BoolValue(false)) 
  }

}*/