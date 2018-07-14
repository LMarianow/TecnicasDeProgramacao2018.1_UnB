import math._

case class ArvoreAVL[A <% Ordered[A]](esquerda: ArvoreAVLTraits[A] = null, dado: A, direita: ArvoreAVLTraits[A] = null) extends ArvoreAVLTraits[A]
{
  val altura = max(esquerda.altura, direita.altura) + 1

  def insere(valor: A) =
  {
    if (valor < dado) ArvoreAVL(esquerda.insere(valor), dado, direita).balanceamento
    else if (valor > dado) ArvoreAVL(esquerda, dado, direita.insere(valor)).balanceamento
    else this
  }

  def remove(valor: A) =
  {
    if (valor < dado) ArvoreAVL(esquerda.remove(valor), dado, direita).balanceamento
    else if (valor > dado) ArvoreAVL(esquerda, dado, direita.remove(valor)).balanceamento
    else direita match
    {
      case ArvoreAVL(rl, rk, rr) => ArvoreAVL(esquerda, rk, direita.remove(rk)).balanceamento
      case _ => esquerda
    }
  }

  def rotacaoEsquerda() = direita match
  {
    case ArvoreAVL(rl, rk, rr) => ArvoreAVL(ArvoreAVL(esquerda, dado, rl), rk, rr)
  }

  def rotacaoDireita() = esquerda match
  {
    case ArvoreAVL(ll, lk, lr) => ArvoreAVL(ll, lk, ArvoreAVL(lr, dado, direita))
  }
  
  def balanceamento() =
  {
    if (esquerda.altura > direita.altura + 1) esquerda match
    {
      case ArvoreAVL(ll, lk, lr) =>
      {
        if (ll.altura >= lr.altura) rotacaoDireita
        else ArvoreAVL(esquerda.rotacaoEsquerda, dado, direita).rotacaoDireita
      }
    }
    else if (esquerda.altura + 1 < direita.altura) direita match
    {
      case ArvoreAVL(rl, rk, rr) =>
      {
        if (rl.altura <= rr.altura) rotacaoEsquerda
        else ArvoreAVL(esquerda, dado, direita.rotacaoDireita).rotacaoEsquerda
      }
    }
    else this
  }

  def buscaFolha(valor: A) =
  {
    if (valor < dado) esquerda.buscaFolha(valor)
    else if (valor > dado) direita.buscaFolha(valor)
    else true
  }

  def imprime(level: Int) =
  {
    esquerda.imprime(level + 1)
    print("\t" * level + dado + '(' + altura + ')' + '\n')
    direita.imprime(level + 1)
  }

  def checaAlturaNo(): Int =
  {
    val lh = esquerda.checaAlturaNo
    val rh = direita.checaAlturaNo
    if (abs(lh - rh) > 1) throw new RuntimeException("Nao esta balanceada")
    max(lh, rh) + 1
  }

}
