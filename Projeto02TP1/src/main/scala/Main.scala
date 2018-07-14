import java.io._ // Criando e escrevendo no arquivo

object Test 
{
   def main(args: Array[String]) 
   {
     val operadores: List[String] = List("+", "-", "*" , "/" , "%","!=" , "<" , ">" , ">=" , "<=" , "||" , "&" , "==" , "!")
     val nome: List[String] = List("Add", "Sub", "Multi" , "Div" , "Mod", "NotEq","Min","Big","BigOrEq","MinOrEq","Or","And","Eq","Not")
     val tipo: List[String] = List("IntValue", "BoolValue" , "Undefined")
     val checa_tipo: List[String] = List("TInt", "TBool") 
     val comandos: List[String] = List("For", "Print", "If_Then", "If_Then_Else", "While","BlockCommand","VarRef", "OberonProgram", "Assignment","Return") 
     val funcoes: List[String] = List("Procedure", "Function") 
      var i: Int = 0
      var a: Int = 0 // 
      var b: Int = 0 // Contador da variavel tipo : IntValue", "BoolValue" , "Undefined
      var c: Int = 0 // Contador da variavel checa_tipo

      val writer = new PrintWriter(new File("src/main/scala/oberon/expression/BinExpression.scala" ))
      val visitor = new PrintWriter(new File("src/main/scala/oberon/visitor/Visitor.scala" ))

      writer.write("package oberon.expression \n")
      writer.write("import oberon.visitor.Visitor \n") 
      writer.write("abstract class BinExpression(val lhs: Expression , val rhs: Expression) extends Expression { }\n")
      while(i < 14)
      { 

        writer.write("class " +nome(i)+"Expression(lhs: Expression, rhs: Expression) extends BinExpression(lhs, rhs) {\n")
        writer.write("  override\n")
        writer.write("  def eval() : Value = { \n")
        
        if(i > 4)
        {
          a = 1
          if(i > 9)
          {
            b = 1
          }
        }
        if (i > 5)  { c =1 }
        
        if( i == 12) // Caso em que a expressão é Equal. Caso a parte.
        {
        writer.write("    val v1 : "+tipo(0)+" = lhs.eval().asInstanceOf["+tipo(0)+ "]\n")
        writer.write("    val v2 : "+tipo(0)+" = rhs.eval().asInstanceOf["+tipo(0)+ "]\n")  
        }
        else
        {
        writer.write("    val v1 : "+tipo(b)+" = lhs.eval().asInstanceOf["+tipo(b)+ "]\n")
        writer.write("    val v2 : "+tipo(b)+" = rhs.eval().asInstanceOf["+tipo(b)+ "]\n")
        }
        // Caso seja expressões que envolvam 2 variáveis
        if ( i < 13) { writer.write("   return new "+tipo(a)+"(v1.value "+operadores(i)+" v2.value )\n  }\n") }   
        // Se não, i=13, expressão é not no qual envolve uma única variavel, então entre no Else
        else { writer.write("   return new " +tipo(a)+ "( " +operadores(i)+ " v1.value)\n  }\n")  }  // Caso em que expressão é Not. 

         writer.write("   override\n")
         writer.write("   def calculateType() : Type = { \n")
         writer.write("   val t1 = lhs.calculateType()\n")
         writer.write("   val t2 = lhs.calculateType()\n")
         writer.write("   return if(t1 ==" +checa_tipo(b)+"() && t2 ==" +checa_tipo(b)+"()) " +checa_tipo(c)+"() else TUndefined() \n } \n")
         writer.write("     override def accept(v: Visitor) {\n")
         writer.write("     v.visit(this)\n }\n}\n")
      
        i+=1
      }
      writer.close()
   
   i=0
  // Gerando o arquivo visitor
   visitor.write("package oberon.visitor\n")
   visitor.write("import oberon.expression._\n")
   visitor.write("import oberon.command._\n")
   visitor.write("import oberon.{Function,OberonProgram,Procedure}\n")
   visitor.write("trait Visitable { \n")
   visitor.write("def accept(v : Visitor) : Unit \n } \n")
   visitor.write("trait Visitor { \n")

   while(i < 15)
   {
      if(i < 2) // Gerando as funcoes
      {
        visitor.write("def visit (e:" +funcoes(i)+") : Unit\n") 
      }
      if(i < 3) // Gerando os tipos das variaveis : IntValue", "BoolValue" , "Undefined
      {
        visitor.write("def visit (e:" +tipo(i)+") : Unit\n")
      }
      if(i < 14) // Gerando as Expressoes binarias: Adicao,subtracao, ifs,Or...
      {
        visitor.write("def visit (e:" +nome(i)+"Expression) : Unit\n")
      }
      if( i < 10) // Gerando Comandos: For,While, BlockCommand ...
      {
        visitor.write("def visit (e:" +comandos(i)+") : Unit\n")
      }
      i+=1
   }
   visitor.write("}\n")
   visitor.close()
 }
}