package oberon.command

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

import oberon.Environment._
import oberon.expression._

class TestIfThen extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

    behavior of "a if then command"

    it should "lookup(soma) must be equal to 15" in 
    {

        val a1 = new Assignment("soma", IntValue(0))   
        val a2 = new Assignment("valA", IntValue(10))      
        val a3 = new Assignment("valB", IntValue(15))      
        val a4 = new Assignment("soma", new AddExpression(new VarRef("soma"), new VarRef("valB")))
        val cond = new MinExpression(new VarRef("valA"), new VarRef("valB"))
        val w1 = new If_Then(cond, a4)

        a1.run()
        a2.run()
        a3.run()
        w1.run()

        val res = lookup("soma")
        res match {
        case Some(v) => v.eval() should be (IntValue(15))
        case _       => 0 should be (1)
        }
    }

    it should "happen nothing if condition is false" in
    {
        val x = new Assignment("igual", IntValue(4))        //    x := 1;
        val cond = new EqExpression(new VarRef("igual"),IntValue(5))
        val command = new Assignment("igual", new AddExpression(new VarRef("igual"), IntValue(4)))

        val if_then = new If_Then(cond, command)

        x.run()
        if_then.run()

        val res = new VarRef("igual").eval() should be (IntValue(4))
    }
}