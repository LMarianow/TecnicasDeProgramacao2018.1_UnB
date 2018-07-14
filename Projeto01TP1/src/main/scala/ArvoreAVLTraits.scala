/**
 * Traits Arvore AVL
 *
 * @author Lucas Mariano
 * @author Iuri Sousa
 * @author Evandro Thalles
 **/

import math._

trait ArvoreAVLTraits[A]
{

  val altura: Int

  def insere(valor: A): ArvoreAVLTraits[A]
  def remove(valor: A): ArvoreAVLTraits[A]

  def rotacaoEsquerda(): ArvoreAVLTraits[A]
  def rotacaoDireita(): ArvoreAVLTraits[A]

  def buscaFolha(valor: A): Boolean
  def imprime(level: Int = 0)
  def checaAlturaNo(): Int
}

class ArvAVLVazia[A <% Ordered[A]] extends ArvoreAVLTraits[A]
{
    val altura = 0

    def insere(valor: A) = ArvoreAVL(new ArvAVLVazia[A], valor, new ArvAVLVazia[A])
    def remove(valor: A) = new ArvAVLVazia[A]

    def rotacaoEsquerda() = new ArvAVLVazia[A]
    def rotacaoDireita() = new ArvAVLVazia[A]

    def buscaFolha(valor: A) = false
    def imprime(level: Int) = {}
    def checaAlturaNo() = 0
}
