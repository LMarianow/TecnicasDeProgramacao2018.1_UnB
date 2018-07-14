class NoArvBin[A <% Ordered[A]](var valor: A, var esquerda: NoArvBin[A] = null, var direita: NoArvBin[A] = null)
{
  def insere(dado: A)
  {
    if(dado.compareTo(valor) <= 0)
    {
      if(esquerda == null)
      {
        esquerda = new NoArvBin(dado)
      }
      else
      {
        esquerda.insere(dado)
      }
    }
    else
    {
      if(direita == null)
      {
        direita = new NoArvBin(dado)
      }
      else
      {
        direita.insere(dado)
      }
    }
  }

  def minFolha(): A =
  {
    if (esquerda == null)
    {
      valor
    }
    else
    {
      esquerda.minFolha()
    }
  }

  def buscaFolha(dado: A) : Boolean =
  {
    if(dado.compareTo(valor) == 0)
    {
      true
    }
    else if ((dado.compareTo(valor) <= 0) && esquerda != null)
    {
      esquerda.buscaFolha(dado)
    }
    else if (direita != null)
    {
      direita.buscaFolha(dado)
    }
    else
    {
      false
    }
  }

  def remove(dado: A, parente: NoArvBin[A] = null)
  {
    if(dado < valor && esquerda != null)
    {
      esquerda.remove(dado, this)
    }
    else if (dado > valor && direita != null)
    {
      direita.remove(dado, this)
    }
    else
    {
      if (esquerda != null && direita != null)
      {
        valor = direita.minFolha()
        direita.remove(valor, this)
      }
      else if (parente.esquerda == this)
      {
        if(esquerda != null) parente.esquerda = esquerda
        else parente.esquerda = direita
      }
      else if (parente.direita == this)
      {
        if(esquerda != null) parente.direita = esquerda
        else parente.direita = direita
      }
    }
  }

  def maxFolha(): A =
  {
    if (direita == null)
    {
      valor
    }
    else
    {
      direita.maxFolha()
    }
  }

}

class ArvoreBinaria[A <% Ordered[A]] extends ArvoreBinariaTraits[A]
{
  var raiz: NoArvBin[A] = null

  def insere(dado: A): Unit =
  {
    if (raiz == null)
    {
      raiz = new NoArvBin(dado)
    }
    else
    {
      raiz.insere(dado)
    }
  }

  def remove(dado: A): Unit =
  {
    if (raiz == null)
    {
      throw InvalidMethod()
    }
    else
    {
      raiz.remove(dado)
    }
  }

  def buscaFolha(dado: A): Boolean =
  {
    if (raiz == null)
    {
      false
    }
    else
    {
      raiz.buscaFolha(dado)
    }
  }

  def altura(node: NoArvBin[A] = raiz): Int =
  {
    if (node ==  null)
    {
      0
    }
    else
    {
      var esquerdaAltura: Int = altura(node.esquerda)
      var direitaAltura: Int = altura(node.direita)

      if (esquerdaAltura < direitaAltura)
      {
        direitaAltura + 1
      }
      else
      {
        esquerdaAltura + 1
      }
    }
  }

  def printPreOrdem(node: NoArvBin[A] = raiz) : Unit =
  {
    if(node != null)
    {
      println(node.valor)
      printPreOrdem(node.esquerda)
      printPreOrdem(node.direita)
    }
  }

  def printEmOrdem(node: NoArvBin[A] = raiz) : Unit =
  {
    if(node != null)
    {
      printEmOrdem(node.esquerda)
      println(node.valor)
      printEmOrdem(node.direita)
    }
  }

}
