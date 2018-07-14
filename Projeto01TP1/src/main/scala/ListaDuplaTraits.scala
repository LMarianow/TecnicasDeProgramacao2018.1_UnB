/**
 * Traits Lista Duplamente Encadeada
 *
 * @author Lucas Mariano
 * @author Iuri Sousa
 * @author Evandro Thalles
 **/
trait ListaDuplaTraits[A]
{
    class No[A](var valor: A, var next: No[A], var ant: No[A])
    def ehVazio(): Boolean
    def tamanhoLista(): Int
    def inicio(): A
    def fim(): A
    def insereInicio(valor: A): Unit
    def insereFim(valor: A): Unit
  //def insere(valor: A, posicao: Int): Unit Fazer funcao insere por posicao
    def buscaNo(posicao: Int): No[A]
    def reverse(): Unit
    def remove(posicao: Int): Unit
    def imprime(): Unit
    def hasNext(): Boolean
    def next(): No[A]
}
