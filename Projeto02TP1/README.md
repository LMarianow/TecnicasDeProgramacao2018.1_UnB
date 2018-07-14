# UNB / Técnicas de Programação I - 2018/01
## Projeto 02 Mini Linguagem Scala Oberon

### Professor 
- Rodrigo Bonifácio 

### Alunos
- Iuri Sousa Vieira - 16/0152488
- Lucas Mariano Carvalho - 16/0133661
- Evandro Thalles Vale de Castro - 16/0119286

### Objetivo
O objetivo do projeto consiste no desenvolvimento de uma mini linguagem de programação utilizando Scala para interpretar a linguagem Oberon, com metodologia orientada a objetos e a testes utilizando a biblioteca Scala Test.

### Estrutura do Projeto
O interpretador da linguagem oberon em scala foi separado em três principais partes para o funcionamento do mesmo: 

* **Comandos e Expressões:** Primeiramente, foram implementados as expressões e os comandos, tais como: atribuições, declarações de variáveis, loops, condicionais, multiplicação, expressões aritméticas e algumas expressões para comparação de valores. Os únicos tipos definidos foram os valores de tipo Inteiro, Booleano e valores indefinidos para facilitar na implementação.
* **Funções e Procedimentos:** As chamadas de funções e procedimentos são semelhantes a da linguagem Pascal, com as mesmas estruturas. Um procedimento é uma função que retorna um valor indefinido e uma função tem um valor retornado. É importante saber que nenhum desses são comandos ou expressões, mas seu chamado é como expressão.
* **Metaprogramação:** A metaprogramação consiste em enxutar o código a fim de remover as repetições gerados na implementação do código.

### Versionamento Utilizado

* **Scala** - *2.12.4*
* **SBT** - *1.1.2*
* **Biblioteca Scala Test** - *3.0.5*
* **Biblioteca Scala Meta** - *3.7.4*

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
  cd Projeto02TP1
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
<img src="https://i.imgur.com/jjQAE3V.png">
</p>