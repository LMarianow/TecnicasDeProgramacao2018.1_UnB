/**
 * Traits Array List
 *
 * @author Lucas Mariano
 * @author Iuri Sousa
 * @author Evandro Thalles
 **/

trait ArrayListTraits[A]
{
  def remove(posicao: Int): Option[A]
  def imprime(): String
  def buscaPosicao(posicao: Int): A
  def aumentaTamanho(): Unit
  def tamanhoArray(): Int
  def insere(valor: A): Unit
}
