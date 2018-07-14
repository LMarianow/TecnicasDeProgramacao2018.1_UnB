import org.scalatest._
import Matchers._

class TesteFila extends FunSuite with BeforeAndAfter
{
  var fila: Fila[Int] = _

	before
  {
		fila = new Fila[Int]
	}

  test("deve ter tamanho == 0 antes de qualquer insercao")
  {
		fila.tamanhoFila should be (0)
	}

	test("deve ter tamanho == 1 depois de uma insercao e tamanho == 3 depois de mais duas insercoes")
  {
    fila.insereFila(1)

    fila.tamanhoFila should be (1)

    fila.insereFila(2)
    fila.insereFila(3)

		fila.tamanhoFila should be (3)
  }

	test("deve remover corretamente e o tamanho da fila diminuir em 1 depois de cada remocao")
  {
    fila.insereFila(3)
    fila.insereFila(5)
    fila.insereFila(7)
    fila.insereFila(11)
    fila.removeFila

		fila.tamanhoFila should be (3)

    fila.removeFila
    fila.removeFila

		fila.tamanhoFila should be (1)
  }

  test("deve retornar o devido alerta ao tentar remover elemento de uma pilha vazia")
  {
		a [InvalidMethod] should be thrownBy
    {
      fila.removeFila
    }
  }

}
