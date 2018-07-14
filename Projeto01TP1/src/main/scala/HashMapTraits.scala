/**
 * Traits Lista Duplamente Encadeada
 *
 * @author Lucas Mariano
 * @author Iuri Sousa
 * @author Evandro Thalles
 **/
 
trait HashMap[V] {
  def set(key: String, value: V)

  def get(key: String): Option[V]

  def delete(key: String): Option[V]

  def load(): Float
}
