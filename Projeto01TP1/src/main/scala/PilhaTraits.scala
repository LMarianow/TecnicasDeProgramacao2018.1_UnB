/**
 * Traits Pilha
 *
 * @author Lucas Mariano
 * @author Iuri Sousa
 * @author Evandro Thalles
 **/

trait PilhaTraits[A]
{
    def tamanhoPilha(): Int
    def imprime(): Unit
    def inserePilha(valor: A): Unit
    def removePilha(): Unit
    def topo(): A
}
