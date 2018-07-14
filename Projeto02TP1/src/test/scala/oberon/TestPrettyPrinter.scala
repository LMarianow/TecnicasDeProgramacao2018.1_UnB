package oberon

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

import oberon.visitor.PrettyPrinter
import oberon.expression._
import oberon.command._




class TestPrettyPrinter extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "a pretty printer"

  it should "Imprimir (2 + 3) quando chamamos accept na expressao AddExpression" in {
    val num  = IntValue(2)
    val num1 = IntValue(3)
    val add  = new AddExpression(num, num1) 

    val pp = new PrettyPrinter()

    add.accept(pp)

    pp.str should be ("(2 + 3)")
  }


  it should "Imprimir if quando chamamos accept na expressao If_Then" in {
    // x := 15
    val a = new Assignment("x", IntValue(15))
    // x > 10
    val condicao = new BigExpression(new VarRef("x"), IntValue(10))
    
    val cmd = new Assignment("x", new AddExpression(new VarRef("x"), IntValue(1)))
    // if (x > 10) 
    //   then x := x + 1 -> x = 15 + 1 = 16   
    val ifthen = new If_Then(condicao, cmd)

    val pp = new PrettyPrinter()

    a.run()
    ifthen.accept(pp)

    pp.str should be ("if(x > 10){var x = (x + 1)}")
  }

  it should "Imprimir var x = 10 quando chamamos accept na expressao Assignment" in 
  {
    val valor = IntValue(10)
    val x = new VarRef("x")
    val recebe = new Assignment("x", valor)
    recebe.run()

    val pp = new PrettyPrinter()

    recebe.accept(pp)

    pp.str should be ("var x = 10")
  }

  it should "Imprimir x = 10 quando chamamos o accept na expressao VarRef" in 
  {
    val valor = IntValue(10)
    val x = new VarRef("x")
    val recebe = new Assignment("x", valor)
    recebe.run()

    val pp = new PrettyPrinter()

    x.accept(pp)

    pp.str should be ("x")
  }

  it should "Imprimir (3 > 2) quando chamamos o accept na expressão BigExpression" in {
    val num  = IntValue(3)
    val num1 = IntValue(2)
    val big  = new BigExpression(num, num1)

    val pp = new PrettyPrinter()

    big.accept(pp)

    pp.str should be ("(3 > 2)")
  }

  it should "Imprimir (3 >= 3) quando chamamos o accept na expressão BigOrEqExpression" in {
    val num   = IntValue(3)
    val num1  = IntValue(3)
    val bigeq = new BigOrEqExpression(num, num1)

    val pp = new PrettyPrinter()

    bigeq.accept(pp)

    pp.str should be ("(3 >= 3)")
  }

  it should "Imprimir (2 < 3) quando chamamos o accept na expressão MinExpression" in {
    val num  = IntValue(3)
    val num1 = IntValue(2)
    val min  = new MinExpression(num1, num)

    val pp = new PrettyPrinter()

    min.accept(pp)

    pp.str should be ("(2 < 3)")
  }

  it should "Imprimir (3 <= 3) quando chamamos accept na expressao MinOrEqExpression" in {
    val num   = IntValue(3)
    val num1  = IntValue(3)
    val mineq = new MinOrEqExpression(num, num1)

    val pp = new PrettyPrinter()

    mineq.accept(pp)

    pp.str should be ("(3 <= 3)")
  }

  it should "Imprimir (5 % 5) quando chamamos accept na expressao ModExpression" in {
    val num  = IntValue(3)
    val num1 = IntValue(3)
    val mod  = new ModExpression(num, num1)

    val pp = new PrettyPrinter()

    mod.accept(pp)

    pp.str should be ("(3 % 3)")
}

  /*it should "print \"Block command\" when we call accept in a definition" in 
  {

    val soma = new AddExpression(new VarRef("x"), new VarRef("y"))
    val recebe = new Assignment("x", new AddExpression(new VarRef("x"), IntValue(1)))
    val comando = new BlockCommand(List(recebe, Return(soma)))

    val pp = new PrettyPrinter()
    comando.accept(pp)

    pp.str should be ("var x = (x + 1)\nreturn (x + y)\n")

  }*/
    
  
}