/**
 * Traits Arvore Binaria
 *
 * @author Lucas Mariano
 * @author Iuri Sousa
 * @author Evandro Thalles
 **/
 abstract class ArvoreBinariaTraits[A <% Ordered[A]]
 {
     def insere(dado: A): Unit
     def remove(dado: A): Unit
     def buscaFolha(dado: A): Boolean
     def altura(node: NoArvBin[A]): Int
     def printPreOrdem(node: NoArvBin[A]): Unit
     def printEmOrdem(node: NoArvBin[A]): Unit
 }
