import org.scalatest._
import Matchers._

class TesteArvoreAVL extends FunSuite with BeforeAndAfter
{
  var raiz: ArvoreAVLTraits[Int] = _

	before
  {
		raiz = new ArvAVLVazia[Int]
	}

  test("a arvore deve estar vazia e possuir altura == 0 antes de qualquer insercao")
  {
    raiz.altura should be (0)
  }

  test("deve atribuir valor a raiz apos primeira insercao")
  {
    raiz = raiz.insere(1)
    raiz.buscaFolha(1) should be (true)
  }

  test("deve ter altura = 2 se os numeros (2,1,3) forem inseridos")
  {
    raiz = raiz.insere(2)
    raiz = raiz.insere(1)
    raiz = raiz.insere(3)

    raiz.altura should be (2)
  }

  test("deve ter altura = 2 se ocorre a insercao de 3 numeros em ordem crescente devido ao balanceamento")
  {
    raiz = raiz.insere(1)
    raiz = raiz.insere(2)
    raiz = raiz.insere(3)

    raiz.altura should be (2)
  }

  test("deve retornar 'true' quando um no que esta na arvore eh pesquisado")
  {
    raiz = raiz.insere(1)
    raiz = raiz.insere(2)
    raiz = raiz.insere(3)

    raiz.buscaFolha(3) should be (true)
  }

  test("deve retornar falso quando um no que nao esta na arvore eh pesquisado")
  {
    raiz = raiz.insere(1)
    raiz = raiz.insere(2)
    raiz = raiz.insere(3)

    raiz.buscaFolha(4) should be (false)
  }

  test("deve remover o no sem filhos corretamente")
  {
    raiz = raiz.insere(1)
    raiz = raiz.insere(2)
    raiz = raiz.insere(3)
    raiz = raiz.remove(3)

    raiz.buscaFolha(3) should be (false)
  }

  test("deve remover o no com 1 filho corretamente")
  {
    raiz = raiz.insere(2)
    raiz = raiz.insere(1)
    raiz = raiz.insere(5)
    raiz = raiz.insere(3)
    raiz = raiz.remove(5)

    raiz.altura should be (2)
  }

  test("deve remover o no com 2 filhos corretamente")
  {
    raiz = raiz.insere(2)
    raiz = raiz.insere(1)
    raiz = raiz.insere(5)
    raiz = raiz.insere(3)
    raiz = raiz.remove(5)
    raiz.altura should be (2)
  }
}
