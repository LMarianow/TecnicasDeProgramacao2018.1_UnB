package oberon

import java.io._
import scala.meta._
import scala.annotation._

// Quasiquotes são uma notação que permite manipular árvores 
//Toda vez que você encapsular um trecho de código, q"""..."""ele se tornará uma árvore que representa um determinado trecho.

// @inline além de dar otimizações para função, faz com que essa metaprogramação seja priorizada na compilação do projeto
class GeneratorBinExpression extends StaticAnnotation {

  @inline def apply(defn: Any): Any = {
    
    var i: Int = 0
    var j: Int = 0

    // Operador '$' ("sem marcação")  Sempre que você desmarcar uma expressão do tipo Tree em um quasiquote, 
    // ela substituirá estruturalmente aquela árvore nesse local.
    val names: List[String] = List("Add","Sub","Div","Mod","Multi","Min","MinOrEq","Big","BigOrEq","Eq","And","Or","Not")
    val operators: List[String] = List("+","-","/","%","*","<","<=",">",">=")
    val operatorslogic: List[String] = List("==","&&","||","!")

    q"abstract class BinExpression(val lhs: Expression, val rhs: Expression) extends Expression {}"

    for(i <- 0 to 12){

      val auxname       = Type.fresh(names(i)+"Expression") // Tipo Type ,pois atribui os nomes respectivos de cada classe
      var auxoperator   = Term.fresh(operators(i)) // Tipo Term,já que são recursos a serem utilizados na classe(variáveis)
      var auxreturn     = Term.fresh("auxreturn")
      var auxreturntype = Term.fresh("auxreturntype")
      var auxval = Term.fresh("auxval") // Usa-se esse fresh para poder utilizar o recurso do $

      if(i<9)
      {
        var auxval = q"""val v1 : IntValue = lhs.eval().asInstanceOf[IntValue]
                         val v2 : IntValue = rhs.eval().asInstanceOf[IntValue]
                      """
        if(i<5)
        {
          var auxreturn = q"""return new IntValue(v1.value $auxoperator v2.value)"""
          var auxreturntype = q"""return if(t1 == TInt() && t2 == TInt()) TInt() else TUndefined()"""
        }
        else
        {
          var auxreturn = q"""return BoolValue(v1 &auxoperator v2)"""
          var auxreturntype = q"""return if(t1 == TInt() && t2 == TInt()) TBool() else TUndefined()"""
        }
      }
      else
      {
        var auxoperator = Term.fresh(operatorslogic(j))

        var auxval = q"""val v1 : IntValue = lhs.eval()
                         val v2 : IntValue = rhs.eval()
                      """
        if(i == 9)
        {
          var auxreturn = q"""return BoolValue(v1 $auxoperator v2)"""
          var auxreturntype = q"""return if(t1 == t2) TBool() else TUndefined()"""
        }
        else if(i< names.size-1)
        {
          var auxreturn = q"""return BoolValue(v1  $auxoperator v2 )"""
          var auxreturntype = q"""return if(t1 == TBool() && t2 == TBool()) TBool() else TUndefined()"""
        }
        else{
          var auxreturn = q"""return BoolValue( !v1.value )"""
        }
        j+=1  
      }

      q"""
      class $auxname (lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {
        
        override
        def eval() : Value = {

          $auxval

          $auxreturn
        }

        override
        def calculateType() : Type = {
          val t1 = lhs.calculateType()
          val t2 = rhs.calculateType()

          $auxreturntype
        }

        override
        def accept(v : Visitor) {
          v.visit(this)
        }
      }
      """ 
    }
  }
}