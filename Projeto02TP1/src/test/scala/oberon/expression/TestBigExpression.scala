package oberon.expression

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestBigExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "an bigger expression"

  it should "return value false in Big(IntValue(5), Add(IntValue(3), IntValue(2)))" in {
    val val5 = IntValue(5)
    val val3 = IntValue(3)
    val val2 = IntValue(2)  
    val add  = new AddExpression(val3, val2) 
    val big  = new BigExpression(val5, add)

    big.eval() should be (BoolValue(false)) 
  }

  it should "return value false in Big(IntValue(5), Add(IntValue(3), IntValue(3)))" in {
    val val5 = IntValue(5)
    val val3 = IntValue(3)
    val add  = new AddExpression(val3, val3) 
    val big  = new BigExpression(val5, add)

    big.eval() should be (BoolValue(false)) 
  }

  it should "return value true in Big(Add(IntValue(3), IntValue(3)), IntValue(5))" in {
    val val5 = IntValue(5)
    val val3 = IntValue(3)
    val add  = new AddExpression(val3, val3) 
    val big  = new BigExpression(add, val5)

    big.eval() should be (BoolValue(true)) 
  }


}