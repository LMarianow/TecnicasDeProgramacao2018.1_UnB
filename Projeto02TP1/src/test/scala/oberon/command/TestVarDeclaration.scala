package oberon

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

import oberon.command._
import oberon.expression._
import oberon.Environment._

class TestVarDeclaration extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "a var declaration"

  before {
    clear()
  }

  it should "be able to declare a variable and infer Undefined" in { 

    val assignment = new VarDeclaration("x")

    assignment.run()

    lookup("x") should be (Some(Undefined()))
  }
}