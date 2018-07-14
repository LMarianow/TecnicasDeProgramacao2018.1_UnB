import org.scalatest._
import Matchers._

class TesteListaDuplaEncadeada extends FunSuite with BeforeAndAfter
{
  var lista: ListaDuplamenteEncadeada[Int] = _

  before
  {
    lista = new ListaDuplamenteEncadeada[Int]
  }

  test("deve inserir elemento no topo de uma lista vazia")
  {
    lista.insereInicio(1)
    lista.inicio should be(1)
    lista.tamanhoLista should be(1)
  }
  test("deve inserir elemento no topo de uma lista nao vazia")
  {
    lista.insereInicio(1)
    lista.insereInicio(2)
    lista.inicio should be(2)
    lista.tamanhoLista should be(2)
  }
  test("deve inserir o elemento no fim da lista vazia")
  {
    lista.insereFim(1)
    lista.fim should be(1)
    lista.tamanhoLista should be(1)
  }
  test("deve inserir o elemento no fim de uma lista nao vazia")
  {
    lista.insereFim(2)
    lista.insereFim(1)
    lista.inicio should be(2)
    lista.fim should be(1)
    lista.tamanhoLista should be(2)
  }
  test("a busca por posicao deve apresentar o devido valor do no")
  {
    lista.insereInicio(1)
    lista.insereFim(2)
    lista.insereFim(3)

    lista.buscaNo(2).valor should be (3)
  }
  test("deve emitir alerta ao informar posicao invalida na busca de um no")
  {
    a [InvalidArgument] should be thrownBy
    {
      lista.buscaNo(-1)
    }
  }
  test("deve apresentar alerta quando inserir posicao de elemento invalida na remocao")
  {
    a [InvalidArgument] should be thrownBy
    {
      lista.remove(-1)
    }
  }
  test("deve deletar apenas o elemento com a posicao especificada")
  {
    lista.insereFim(1)
    lista.remove(0)
    lista.tamanhoLista should be(0)
  }
}
