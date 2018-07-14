/**
 * Traits Fila 
 *
 * @author Lucas Mariano
 * @author Iuri Sousa
 * @author Evandro Thalles
 **/

trait FilaTraits[A]
{
  def tamanhoFila(): Int
  def insereFila(valor: A): Unit
  def removeFila(): Unit
  def imprime(): Unit
}
