class Pilha[A] extends PilhaTraits[A]
{
    private var lista: ListaDuplamenteEncadeada[A] = new ListaDuplamenteEncadeada[A]

    def tamanhoPilha(): Int = lista.tamanhoLista

    def imprime(): Unit = lista.imprime

    def inserePilha(valor: A): Unit =
    {
        lista.insereFim(valor)
    }

    def removePilha(): Unit =
    {
        if (tamanhoPilha > 0)
        {
		        lista.remove(tamanhoPilha-1)
        }
        else
        {
            throw InvalidMethod()
        }
    }

    def topo(): A =
    {
        lista.buscaNo(tamanhoPilha-1).valor
    }
}
