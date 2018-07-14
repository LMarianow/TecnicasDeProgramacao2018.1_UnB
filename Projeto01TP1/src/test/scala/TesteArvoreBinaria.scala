import org.scalatest._
import Matchers._

class TesteArvoreBinaria extends FunSuite with BeforeAndAfter
{
  var arv: ArvoreBinaria[Int] = _

	before
  {
		arv = new ArvoreBinaria[Int]
	}

	test("a arvore deve estar vazia antes de qualquer insercao")
  {
		arv.raiz should be (null)
	}

	test("deve atribuir valor a raiz apos primeira insercao")
  {
		arv.insere(1)
		arv.raiz.valor should be (1)
	}

  test("deve inserir o nodo a esquerda se o valor coligado for menor")
  {
		arv.insere(2)
		arv.insere(1)

		arv.raiz.esquerda.valor should be(1)
	}

	test("deve inserir o nodo a direita se o valor coligado for maior ou igual")
  {
		arv.insere(1)
		arv.insere(2)

		arv.raiz.direita.valor should be(2)
	}

	test("deve ter altura = 3 se ocorre a insercao de 3 numeros em ordem crescente")
  {
		arv.insere(1)
		arv.insere(2)
		arv.insere(3)

		arv.altura() should be (3)
	}

  test("deve ter altura = 2 se os numeros (2,1,3) forem inseridos")
  {
		arv.insere(2)
		arv.insere(1)
		arv.insere(3)

		arv.altura() should be (2)
	}

	test("deve retornar 'true' quando um no que esta na arvore eh pesquisado")
  {
	 	arv.insere(1)
	 	arv.insere(2)
	 	arv.insere(3)

	 	arv.buscaFolha(3) should be (true)
	}

	test("deve retornar falso quando um no que nao esta na arvore eh pesquisado")
  {
	 	arv.insere(1)
	 	arv.insere(2)
	 	arv.insere(3)

	 	arv.buscaFolha(4) should be (false)
	}

	test("deve remover o no sem filhos corretamente")
  {
		arv.insere(1)
		arv.insere(2)
		arv.insere(3)
		arv.remove(4)

		arv.buscaFolha(4) should be (false)
	}

	test("deve remover o no com 1 filho corretamente")
  {
		arv.insere(2)
		arv.insere(1)
		arv.insere(5)
		arv.insere(3)
		arv.remove(5)

		arv.raiz.direita.valor should be (3)
	}

	test("deve remover o no com 2 filhos corretamente")
  {
		arv.insere(2)
		arv.insere(1)
		arv.insere(5)
		arv.insere(3)
		arv.remove(5)
		arv.raiz.direita.valor should be (3)
	}
}
