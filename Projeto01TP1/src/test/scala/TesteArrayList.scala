import org.scalatest._
import Matchers._

class TesteArrayList extends FunSuite with BeforeAndAfter
{
  var array: ArrayList[Int] = _

  before
  {
    array = new ArrayList[Int]
  }

  test("array list deve ser de tamanho == 0 antes de qualquer insercao")
  {
    array.tamanhoArray() shouldBe(0)
  }

  test("deve possuir tamanho == 2 apos insercao de 2 elementos")
  {
    array.insere(1)
    array.insere(2)

    array.tamanhoArray() shouldBe(2)
  }

  test("deve retornar o valor se posicao de busca for valida")
  {
    array.insere(1)
    array.insere(2)
    array.insere(3)

    array.buscaPosicao(2) shouldBe(3)
  }

  test("deve dar o devido alerta se tentar remover em um array list vazio")
  {
    intercept[InvalidArgument]
    {
      array.remove(0)
    }
  }

  test("deve dar o devido alerta se tentar remover uma posicao inexistente")
  {
    array.insere(1)
    array.insere(3)

    intercept[InvalidArgument]
    {
      array.remove(2)
    }
  }

  test("deve retornar o valor da devida posicao quando chamada a funcao remove e a posicao for valida")
  {
     array.insere(1)
     array.insere(2)
     array.insere(3)

     array.remove(2) shouldBe(Some(3))
  }

}
