package oberon.command

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

import oberon.Environment._
import oberon.expression._

class TestIfThenElse extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

    behavior of "a if then else command"

    it should "lookup(resultado) must be equal to 25" in 
    {
        val a1 = new Assignment("resultado", IntValue(0))   
        val a2 = new Assignment("valA", IntValue(10))      
        val a3 = new Assignment("valB", IntValue(15))      
        val a4 = new Assignment("resultado", new AddExpression(new VarRef("valA"), new VarRef("valB")))
        val a5 = new Assignment("resultado", new SubExpression(new VarRef("valB"), new VarRef("valA")))
        val cond = new BigExpression(new VarRef("valB"), new VarRef("valA"))
        val w1 = new If_Then_Else(cond, a4, a5)

        a1.run()
        a2.run()
        a3.run()
        w1.run()

        val res = lookup("resultado")
        res match {
        case Some(v) => v.eval() should be (IntValue(25))
        case _       => 0 should be (1)
        }
    }
}