class BucketHashMap[V](maxSize: Int) extends HashMap[V] {
  require(maxSize > 0)

  private var size = 0
  private var data = new Array[BucketHashMap.Node[V]](maxSize)

  // Criando nós ficticios.
  for (i <- 0 until maxSize) {
    data(i) = BucketHashMap.Node("", null.asInstanceOf[V], null)
  }

  /** Precisa ser chamado no nó ficticio. Retorna o nó antes do
      nó real que queremos encontrar. Nunca retorna `null`. */
  private def find(key: String, head: BucketHashMap.Node[V]): BucketHashMap.Node[V] = {
    var n = head
    while (n.next != null && n.next.key != key)
      n = n.next
    n
  }

  def set(key: String, value: V) = {
    val bucket = key.hashCode % maxSize
    val n = find(key, data(bucket))
    if (n.next != null) {
      n.next.value = value
    }
    else {
      data(bucket).key = key
      data(bucket).value = value
      data(bucket) = BucketHashMap.Node("", null.asInstanceOf[V], data(bucket))
      size += 1
    }
  }

  def get(key: String): Option[V] = {
    val bucket = key.hashCode % maxSize
    val n = find(key, data(bucket))
    if (n.next != null)
      Some(n.next.value)
    else
      None
  }

  def delete(key: String): Option[V] = {
    val bucket = key.hashCode % maxSize
    val n = find(key, data(bucket))
    if (n.next != null) {
      val value = n.next.value
      n.next = n.next.next
      size -= 1
      Some(value)
    }
    else
      None
  }

  def load(): Float = size * 1.0f / maxSize
}

object BucketHashMap {
    /** Nós para a lista encadeada usada para as colisões */
    private case class Node[V](var key: String, var value: V, var next: Node[V])
}
