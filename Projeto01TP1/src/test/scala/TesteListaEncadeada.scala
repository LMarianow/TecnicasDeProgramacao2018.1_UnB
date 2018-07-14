import org.scalatest._
import Matchers._

class TesteListaEncadeada extends FunSuite with BeforeAndAfter
{
  var lista: ListaEncadeada[Int] = _

  before
  {
    lista = new ListaEncadeada[Int]
  }

  test("o tamanho de uma lista vazia deve ser igual a 0 antes de qualquer insercao.")
  {
    lista.tamanhoLista shouldEqual 0
  }
  test("ocorreu mudanca no tamanho da lista depois de inserir elementos")
  {
    lista.insere(1 , 0)

    lista.tamanhoLista should be (1)

    lista.insere(2 , 1)
    lista.insere(3 , 2)
    lista.insere(4 , 3)

    lista.tamanhoLista should be (4)
  }
  test("a busca por posicao deve apresentar o devido valor do no")
  {
    lista.insere(1 , 0)
    lista.insere(2 , 1)
    lista.insere(3 , 2)

    lista.PesquisaNoh(2).valor should be (3)
  }
  test("insercao de valores entre valores inseridos anteriormente"){
    lista.insere(1 , 0)
    lista.insere(2 , 1)
    lista.insere(3 , 2)
    lista.insere(4 , 2)

    lista.PesquisaNoh(2).valor should be (4)
    lista.PesquisaNoh(3).valor should be (3)
  }
  test("emitir o devido alerta se a posicao for menor do que 0 e maior que tamanho da lista")
  {
    a [InvalidArgument] should be thrownBy
    {
      lista.insere(1 , -1)
      lista.retira(15)
    }
  }
  test("inicio da lista mudou apos inserir elemento na primeira posicao")
  {
    lista.insere(1 , 0)
    lista.insere(2 , 0)

    lista.inicio should be (2)
  }
  test("o tamanho da lista decrementou apos remover um elemento")
  {
    lista.insere(1 , 0)
		lista.insere(2 , 1)
		lista.insere(3 , 2)
		lista.retira(0)

		lista.tamanhoLista should be (2)
  }
  test("inicio da lista mudou apos deletar elemento da primeira posicao")
  {
    lista.insere(1 , 0)
    lista.insere(2 , 1)
    lista.retira(0)

    lista.inicio should be (2)
  }
}
