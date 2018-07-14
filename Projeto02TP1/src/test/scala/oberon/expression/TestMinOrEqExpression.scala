package oberon.expression

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestMinOrEqExpression extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "an minor or equal expression"

  it should "return value true in MinOrEq(IntValue(5), Add(IntValue(3), IntValue(2)))" in {
    val val5 = IntValue(5)
    val val3 = IntValue(3)
    val val2 = IntValue(2)  
    val add  = new AddExpression(val3, val2) 
    val minoreq  = new MinOrEqExpression(val5, add)

    minoreq.eval() should be (BoolValue(true)) 
  }

  it should "return value true in MinOrEq(IntValue(5), Add(IntValue(3), IntValue(3)))" in {
    val val5 = IntValue(5)
    val val3 = IntValue(3)
    val add  = new AddExpression(val3, val3) 
    val minoreq  = new MinOrEqExpression(val5, add)

    minoreq.eval() should be (BoolValue(true)) 
  }

  it should "return value false in MinOrEq(Add(IntValue(3), IntValue(3)), IntValue(5))" in {
    val val5 = IntValue(5)
    val val3 = IntValue(3)
    val add  = new AddExpression(val3, val3) 
    val minoreq  = new MinOrEqExpression(add, val5)

    minoreq.eval() should be (BoolValue(false)) 
  }


}