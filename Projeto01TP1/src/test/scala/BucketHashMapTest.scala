import org.scalatest.FunSuite

class BucketHashMapTestSuite extends FunSuite with HashMapBehaviors {
  def emptyHashMap = new BucketHashMap[Int](10)

  testsFor(emptyHashMap(emptyHashMap))

  test("Teste das Colisões - HashMap") {
    val map = new BucketHashMap[Int](1)
    map.set("a", 1)
    map.set("b", 2)
    assert(map.get("a") === Some(1))
    assert(map.get("b") === Some(2))
    map.set("a", 2)
    map.set("b", 1)
    assert(map.get("a") === Some(2))
    assert(map.get("b") === Some(1))
  }

  test("Incluindo uma grande quantidade de dados - HashMap") {
    val map = new BucketHashMap[Int](10)
    for (i <- 0 until 1000) {
      map.set(i.toString, i)
    }
    for (i <- 0 until 1000) {
      assert(map.get(i.toString) === Some(i))
      assert(map.delete(i.toString) === Some(i))
    }
  }
}
