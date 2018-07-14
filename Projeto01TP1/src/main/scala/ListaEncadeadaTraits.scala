/**
 * Traits Lista Simplesmente Encadeada
 *
 * @author Lucas Mariano
 * @author Iuri Sousa
 * @author Evandro Thalles
 **/
trait ListaEncadeadaTraits[A]
{
    class No[A](val valor: A, var next: No[A])
    def tamanhoLista(): Int
    //def ehVazio(): Boolean
    def inicio(): A
    def insere(valor: A, posicao: Int): Unit
    def retira(posicao: Int): Unit
    def imprime(): Unit
    def PesquisaNoh(posicao: Int): No[A]
    def hasNext(): Boolean
  	def next(): No[A]
}