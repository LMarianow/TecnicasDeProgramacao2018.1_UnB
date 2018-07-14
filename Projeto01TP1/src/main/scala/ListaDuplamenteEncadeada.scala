class ListaDuplamenteEncadeada[A] extends ListaDuplaTraits[A]
{
  private var tamanho: Int = 0
  private var inicio_lista: No[A] = _
  private var fim_lista: No[A] = _
  private var isReversed: Boolean = false

  def ehVazio: Boolean = (tamanho == 0)

  def tamanhoLista(): Int = tamanho

  def inicio(): A =
  {
    if (inicio_lista == null)
      throw InvalidArgument()
    inicio_lista.valor
  }

  def fim(): A =
  {
    if (fim_lista == null)
      throw InvalidArgument()
    fim_lista.valor
  }

  def insereInicio(valor: A): Unit =
  {
      if (inicio_lista == null)
      {
        inicio_lista = new No(valor, null, null)
        tamanho = 1
        fim_lista = inicio_lista
      }
      else
      {
        val atual = new No(valor, inicio_lista, null)
        inicio_lista.ant = atual
        inicio_lista = atual
        tamanho += 1
      }
  }

  def insereFim(valor: A): Unit =
  {
    if (fim_lista == null)
    {
      insereInicio(valor)
    }
    else
    {
      val atual = new No(valor, null, fim_lista)
      fim_lista.next = atual
      fim_lista = atual
      tamanho += 1
    }
  }

  def imprime(): Unit =
  {
      var Auxiliar = inicio_lista

      for (i <- 0 until tamanhoLista)
      {
          println(s"${Auxiliar.valor}")
          Auxiliar = Auxiliar.next
      }
  }

  def buscaNo(posicao: Int): No[A] =
  {
    var Auxiliar = inicio_lista
    if (posicao >= 0 && posicao <= tamanho)
    {
        for (i <- 0 until posicao ) { Auxiliar = Auxiliar.next }
        Auxiliar /* Retorne esse Nó, caso encontre */
    }
    else
    {
        throw InvalidArgument() // Retorna a excessão de erro
    }
  }

  def reverse(): Unit =
  {
    isReversed = !isReversed
    val temp = inicio_lista
    inicio_lista = fim_lista
    fim_lista = temp
  }

  def remove(posicao: Int): Unit =
  {
      if(posicao >= 0 && posicao <= tamanho )
      {
        if (posicao==0)
        {
            var aux = inicio_lista.next
            inicio_lista = aux
        }
        else if (posicao == tamanho-1)
        {
          var aux = buscaNo(posicao-1)
          aux.next = null
          fim_lista = aux
        }
        else
        {
          var aux = buscaNo(posicao-1)
          var auxnext = buscaNo(posicao+1)
          aux.next = auxnext
        }
        tamanho -= 1
      }
      else
      {
        throw InvalidArgument() // Retorna a excessão de erro
      }
  }

  private var pos : Int = -1

    override def hasNext : Boolean = 
    {
        var Aux = buscaNo(pos+1)
        if(Aux.next != null) return true
            return false
    }

    override def next : No[A] = 
    {
        var Aux = buscaNo(pos+1)
        pos+=1
        return Aux.next
    }
}
