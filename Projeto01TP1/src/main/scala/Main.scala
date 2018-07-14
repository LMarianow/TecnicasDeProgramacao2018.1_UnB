
object Main extends App
{
   override def main(args: Array[String]): Unit =
    {
      // TESTE MAIN ARVORE AVL
      var raiz: ArvoreAVLTraits[Int] = new ArvAVLVazia[Int]
      raiz=raiz.insere(1)
      raiz=raiz.insere(2)
      raiz=raiz.insere(3) // Inserindo os devidos valores na arvore
      raiz=raiz.insere(4)
      raiz=raiz.insere(5)
      raiz = raiz.insere(6)
      val l = raiz.buscaFolha(6) // Fazendo a busca de um elemento existente na arvore
      println(l)
      val z = raiz.buscaFolha(7) // Fazendo a busca de um elemento nao existente na arvore
      println(z)
      raiz.imprime()
      println()
      raiz = raiz.remove(4)
      raiz.imprime()
    }
}
