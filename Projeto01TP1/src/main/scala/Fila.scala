class Fila[A] extends FilaTraits[A]
{
    private var lista: ListaDuplamenteEncadeada[A] = new ListaDuplamenteEncadeada[A]

    def tamanhoFila(): Int = lista.tamanhoLista

    def insereFila(valor: A): Unit =
    {
        lista.insereFim(valor)
    }

    def imprime(): Unit = lista.imprime

    def removeFila(): Unit =
    {
        if (tamanhoFila > 0)
        {
		        lista.remove(0)
        }
        else
        {
            throw InvalidMethod()
        }
    }
}
