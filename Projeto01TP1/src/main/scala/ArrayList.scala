class  ArrayList[A: Manifest] extends ArrayListTraits[A]
{
  var tamanho = 5;
  var indice = 0;
  var vetor: Array[A] = new Array[A](tamanho)

  def insere(valor: A)
  {
    if(indice == tamanho)
    {
      this.aumentaTamanho();
    }
    vetor(indice) = valor;
    indice += 1
  }

  def tamanhoArray() = indice

  def aumentaTamanho()
  {
    this.tamanho *= 2
    var novoVetor: Array[A] = new Array[A](tamanho);
    var i = 0
    for(i <- 0 until vetor.length)
    {
      novoVetor(i) = vetor(i);
    }
    this.vetor = novoVetor
  }

  def buscaPosicao(posicao: Int): A =
  {
    return this.vetor(posicao);
  }

  def remove(posicao: Int): Option[A] =
  {
      if(posicao >= 0 && posicao < indice) {
        var ret = vetor(posicao)
        if(posicao != (indice-1))
        {
          for(i <- posicao until (indice-1))
          {
            vetor(i) = vetor(i+1)
          }
        }
        indice -= 1
        return Some(ret)
      }
      else
      {
        throw InvalidArgument("Posicao invalida!\n")
      }
  }

  def imprime(): String =
  {
    var saida: String = "["
    var i = 0
    for(i <- 0 until indice - 1)
    {
      saida += vetor(i) + ", "
    }
    saida += vetor(indice - 1)
    saida += "]"
    return saida
  }
}
