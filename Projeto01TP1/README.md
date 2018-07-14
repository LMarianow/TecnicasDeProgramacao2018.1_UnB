# UNB / Técnicas de Programação I - 2018/01
## Projeto 01 Estruturas de Dados

### Professor 
- Rodrigo Bonifácio 

### Alunos
- Iuri Sousa Vieira - 16/0152488
- Lucas Mariano Carvalho - 16/0133661
- Evandro Thalles Vale de Castro - 16/0119286

### Objetivo
O objetivo do projeto consiste no desenvolvimento de uma biblioteca de estruturas de dados já aprendidas na disciplina de estrutura de dados utilizando a linguagem Scala, com metodologia orientada a objetos e a testes utilizando a biblioteca Scala Test.

### Lista de Estrutura de Dados Implementadas

- Array List
- Lista Simples encadeada
- Lista Duplamente encadeada
- Pilha
- Fila
- Árvore Binária
- Árvore Binária com balanceamento (AVL)
- Tabela de Hash com uso de Buckets
- Grafo

### Versionamento Utilizado

* **Scala** - *2.12.4*
* **SBT** - *1.1.2*
* **Biblioteca Scala Test** - *3.0.5*

### Testes
Para realizar os testes das implementações das Estruturas de Dados foi utilizado a biblioteca ScalaTest. Os testes realizados se encontram em [TESTES](src/test).

### Execução Testes
Para de Execução dos testes siga os passos a seguir:
- Primeiramente verifique se o scala e o sbt estão devidamente instalados e em seu versionamento correto, após verificado isso clone o repositório em sua máquina utilizando
  ```
  git clone https://github.com/LMarianow/TecnicasDeProgramacao2018.1_UnB.git
  ```
  ```
  cd TecnicasDeProgramacao2018.1_UnB
  ```
  ```
  cd Projeto01TP1
  ```

- Digitar os seguintes comandos no terminal:

  ```
  sbt compile
  ```
  ```
  sbt test
  ```

##### Exemplo de saída do 'sbt test'
<p align="center">
<img src="https://i.imgur.com/nYywuOh.png">
</p>