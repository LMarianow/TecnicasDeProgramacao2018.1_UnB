// Representação do Grafo por nós

object Grafos
{

  // Lista de nós contidos no grafo
  var nodes = collection.mutable.Map[String,Node]()


  class Node (id : String)
  {

    // Lista que conterá os vizinhos dos nós
    private var vizinhos = collection.mutable.Map[Node, Int]()

    // Variavel Dijkstra guarda o caminho mais curto para alcançar o nó
    private var dijkstra : (Node, Int) = (null, 0)

    // Variável Boleana para indicar se o nó já foi visitado
    private var visited = false

    // Pega o custo total
    def getCost() : Int = this.dijkstra._2

    // Pega o estado nó (Visited : true || false)
    def getState() : Boolean =  this.visited
    def setState(b : Boolean) : Unit = this.visited = b

    // Pega e seta o valor do Dijkstra
    def setDijkstra(p : Node, w : Int) : Unit = this.dijkstra = (p, w)
    def getDijkstra() : (Node, Int) = this.dijkstra

    // Pega o Id do nó (id = string)
    def getId() : String = this.id

    // Pega o nó
    def getNode(id : String) : Node = this

    // Adiciona uma vizinhança para aquele nó, jogando tal elemento para a lista de vizinhos daquele mesmo nó
    def addvizinhos(V : Node, W : Int) : Unit = {
      this.vizinhos += (V -> W)
    }

    // Pega a lista de vizinhos
    def getvizinhos() : collection.mutable.Map[Node, Int] = vizinhos

    // Retorna a informação do nó do tipo string
    override def toString: String = {
      var res = "Nó " + this.id + " tem " + this.vizinhos.size + " Vizinhos"

      for ((i, j) <- this.vizinhos ; if(!this.vizinhos.isEmpty)) {
        res += "\n que é o Nó " + i.getId() + " distância de " + j
      }
      return res + "\nStatus : " + this.visited +"\n Custo Dijkstra : " + this.dijkstra._2 + "\n Vizinho anterior Dijkstra  : " + this.dijkstra._1.getId()
    }
  }


  // Adiciona nós para o grafo

  def addNodes(nx : List[Node]) : Unit = nx match {
    case head::tail => {
      nodes += (head.getId()-> head)
      addNodes(tail)
    }
    case Nil => Unit
  }


  val nodeA = new Node("A")
  val nodeB = new Node("B")
  val nodeC = new Node("C")
  val nodeD = new Node("D")
  val nodeE = new Node("E")
  val nodeF = new Node("F")

  // Adicionando os nós para os grafos
  addNodes(List(nodeA, nodeB, nodeC, nodeD, nodeE, nodeF))

  println("Criando Grafo: Adicionando Nós: A,B,C,D,E,F ")
  println("Criando Vizinhança entre os nós, pesos entre parenteses: A->B (1), A->C (2), B->D (4), D->E (6), C->F (1), F->D (1), F->E (9)")
  nodeA.addvizinhos(nodeB, 1)
  nodeA.addvizinhos(nodeC, 2)
  nodeB.addvizinhos(nodeD, 4)
  nodeD.addvizinhos(nodeE, 6)
  //nodeC.addvizinhos(nodeE, 5)
  nodeC.addvizinhos(nodeF, 1)
  nodeF.addvizinhos(nodeD, 1)
  nodeF.addvizinhos(nodeE, 9)


  // Define o grafo atual
  override def toString: String = {
    return("Esse grafo possui " + nodes.size + " nós")
  }


  // Procura o nó dentro do grafo a partir do Id.
  def findNode(s : String): Node = {
    var returnNode : Node = null
    for (n <- nodes; if n._1 == s){
      returnNode = n._2
    }
    if(returnNode != null) return returnNode
    else throw new IllegalArgumentException
  }


  // Procura o menor elemento da pilha , total de custo também virá com o nó

  def findMin(m : collection.mutable.Map[(Node, Node),Int]) : ((Node, Node), Int) = {
    var min : ((Node, Node),Int) = m.head
    for(n <- m; if min._2 > n._2) min = n
    return(min)
  }

  // Mostra o custo da Origem até o destino
  def djikstracusto(origem : Node, dest : Node) : collection.mutable.ListBuffer[Node] = {
    var custo = new collection.mutable.ListBuffer[Node]()
    custo += dest
    var node_atual : Node = dest
    while(node_atual != origem){
      custo += node_atual.getDijkstra()._1
      node_atual = node_atual.getDijkstra()._1
    }
    custo = custo.reverse

    return custo
  }


  def dijkstra(origem : String, dest : String) : List[Node] =
  {
    val node_origem = findNode(origem)
    var node_atual = node_origem
    val node_dest = findNode(dest)

    // Mapeia o nó a partir da pilha, para identificar o custo que será realizado
    var pilha_nodes = collection.mutable.Map[(Node, Node),Int]()

    // Enquanto o nó atual não for visitado e este seja o destino final
    while (!node_atual.getState() && node_atual.getId() != node_dest.getId())
    {
      node_atual.setState(true)

      // Pega os nós vizinhos
      val vizinhos = node_atual.getvizinhos()

      // Se nao possui vizinhos
      if(!vizinhos.isEmpty)
      {
        // Para os vizinhos nao visitados na lista, coloque-os na pilha
        // custo do caminho do nó anterior + o atual
        for (node <- vizinhos; if !node._1.getState())
            pilha_nodes += ((node._1, node_atual) -> (node._2 + node_atual.getCost()))

        // Procura o menor nó da pilha
        val min : ((Node, Node), Int)= findMin(pilha_nodes)

        // Delete o menor elemento da pilha
        for(n <- pilha_nodes; if(n._1._1==min._1._1))
            pilha_nodes -= n._1
        // Atualize o menor nó da variável Djikstra com o nó anterior e o total de custo
        min._1._1.setDijkstra(min._1._2,min._2)

        node_atual = min._1._1
      }
    }
    println(node_dest)
    //Mostre o custo da origem até o destino
    val custo : List[Node] = djikstracusto(node_origem, node_dest).toList
    return custo
  }

  def custoToString(nx: List[Grafos.Node]) : String = nx match {
    case head::Nil =>   head.getId() + " -- custo do Caminho : " + head.getCost()
    case head::tail =>  head.getId() + "->" + custoToString(tail)
    case Nil => ""
  }

  def main(args: Array[String]): Unit =
  {
    // Função que define o grafo
    try
    {
  // Test1 Adicionando um novo elemento no Grafo e novas arestas
  println("Adicionando um novo elemento no Grafo,que será G.Vizinhos: G->E (1), G->D (9),B->G (1)")

  val nodeG = new Node("G")
  addNodes(List(nodeG))
  nodeG.addvizinhos(nodeE, 1)
  nodeB.addvizinhos(nodeG, 1)
  nodeG.addvizinhos(nodeD, 9)

  //Teste 2
  println("\n Buscando o Nó B")
  val recebe:Node =  findNode("B")
  if(recebe!= null)
  {
      println("Nó "+ nodeB.getId() +" encontrado")

  }
  else
    println("Nó não encontrado")

    //Teste 3
    println("\nPercorrimento do caminho: Origem: A , Destino: E")
    val custo : List[Node] = dijkstra("A", "E")
      println(custoToString(custo))

    //Teste 4
    println("\nDepois de percorrido,Status do nós sofreram devidos alterações")
    println("Status do nó A,B: " + nodeA.getState(),nodeB.getState())

    // Teste 5
    println("\n Procurar um nó que não está no Grafo,por exemplo: K")
      val recebe2: Node = findNode("K")

    } catch {
      case e: IllegalArgumentException => println("Nó nao está no grafo.Impossivel de encontrar o caminho ! ")
    }

  }
}
