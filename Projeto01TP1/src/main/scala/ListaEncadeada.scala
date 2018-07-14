                    /****************IMPLEMENTAÇÃO LISTA SIMPLES ENCADEADA*****************/
class ListaEncadeada[A] extends ListaEncadeadaTraits[A]
{

    private var _tamanho: Int = 0
    private var inicio_lista: No[A] = _

    def tamanhoLista(): Int = _tamanho

    def inicio(): A = inicio_lista.valor

    def PesquisaNoh(posicao: Int): No[A] =
    {
        var Auxiliar = inicio_lista
        if (posicao >= 0 && posicao <= _tamanho)
        {
            for (i <- 0 until posicao ) { Auxiliar = Auxiliar.next }
            Auxiliar /* Retorne esse Nó, caso encontre */
        }
        else
        {
            throw InvalidArgument() // Retorna a excessão de erro
        }
    }

    def insere(valor: A, posicao: Int): Unit =
    {
        var Novo_elem = new No(valor, null)
        if (posicao >= 0 && posicao <= _tamanho)
        {
            if (_tamanho == 0)
            {
                inicio_lista = Novo_elem
            }
            else
            {
                if (posicao == 0)
                {
                    Novo_elem.next = inicio_lista
                    inicio_lista = Novo_elem
                }
                else /*Percorre até chegar na posicao n-1 para realizar as devidas manipulações*/
                {
                    var Auxiliar = PesquisaNoh(posicao-1)
                    if (Auxiliar.next != null)
                    {
                        Novo_elem.next = Auxiliar.next
                    }
                    Auxiliar.next = Novo_elem
                }
            }
            _tamanho+=1
        }
        else
        {
            throw InvalidArgument() // Retorna a excessão de erro
        }
    }

    def retira(posicao: Int): Unit =
    {
        if (posicao >= 0 && posicao <= _tamanho)
        {
            if (posicao == 0) /* Retira o elemento do inicio da lista */
            {
                inicio_lista = inicio_lista.next
            }
            else /* Percorre até chegar na posição n-1,e após isso, faz com que o próximo do nó anterior, aponte para dois elementos na frente */
            {
                var no_ant = PesquisaNoh(posicao-1)
                no_ant.next = no_ant.next.next
            }
            _tamanho-=1
        }
        else
        {
            throw InvalidArgument() // Retorna a excessão de erro
        }
    }

    def imprime(): Unit =
    {
        var Auxiliar = inicio_lista

        for (i <- 0 until _tamanho)
        {
            println(s"${Auxiliar.valor}")
            Auxiliar = Auxiliar.next
        }
    }

    private var pos : Int = -1

    override def hasNext : Boolean = 
    {
        var Aux = PesquisaNoh(pos+1)
        if(Aux.next != null) return true
            return false
    }

    override def next : No[A] = 
    {
        var Aux = PesquisaNoh(pos+1)
        pos+=1
        return Aux.next
    }
}
