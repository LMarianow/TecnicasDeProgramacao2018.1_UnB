import org.scalatest.FunSuite

class OpenAddressingHashMapTestSuite extends FunSuite with HashMapBehaviors {
  def emptyHashMap = new OpenAddressingHashMap[Int](10)

  testsFor(emptyHashMap(emptyHashMap))

  test("Tamanho Maximo - HashMap") {
    val map = new OpenAddressingHashMap[Int](1)
    map.set("a", 1)
    intercept[RuntimeException] {
      map.set("b", 2)
    }
  }

  test("Testando a otimização do Map - HashMap") {
    val map = new OpenAddressingHashMap[Int](10)
    for (i <- 0 until 8) {
      map.set(i.toString, i)
    }
    for (i <- 0 until 4) {
      map.delete(i.toString)
    }
    val optimizedMap = map.getOptimizedMap()
    for (i <- 4 until 8) {
      assert(map.get(i.toString) === Some(i))
    }
  }
}
