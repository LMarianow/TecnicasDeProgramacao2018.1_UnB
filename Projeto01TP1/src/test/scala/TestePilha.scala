import org.scalatest._
import Matchers._

class TestePilha extends FunSuite with BeforeAndAfter
{
  var pilha: Pilha[Int] = _

  before
  {
    pilha = new Pilha[Int]
  }

  test("deve ter tamanho == 0 antes de qualquer insercao em uma pilha vazia")
  {
    pilha.tamanhoPilha should be (0)
	}

	test("deve aumentar o tamanho em 1 apos qualquer insercao em uma pilha vazia e nao vazia")
  {
    pilha.inserePilha(1)

    pilha.tamanhoPilha should be (1)

    pilha.inserePilha(2)
    pilha.inserePilha(3)

		pilha.tamanhoPilha should be (3)
  }

	test("deve diminuir em 1 o tamanho apos chamada a funcao de remocao em uma pilha nao vazia")
  {
    pilha.inserePilha(1)
    pilha.inserePilha(2)
    pilha.inserePilha(3)
    pilha.inserePilha(4)
    pilha.removePilha

		pilha.tamanhoPilha should be (3)

    pilha.removePilha
    pilha.removePilha

		pilha.tamanhoPilha should be (1)
  }

  test("deve emitir o devido alerta ao tentar remover um elemento de uma pilha vazia")
  {
		a [InvalidMethod] should be thrownBy
    {
      pilha.removePilha
    }
  }

  test("deve retornar o ultimo elemento quando funcao topo() e chamada")
  {
      pilha.inserePilha(1)
      pilha.inserePilha(2)
      pilha.inserePilha(3)

      pilha.topo should be (3)

      pilha.inserePilha(4)

      pilha.topo should be (4)
  }

}
