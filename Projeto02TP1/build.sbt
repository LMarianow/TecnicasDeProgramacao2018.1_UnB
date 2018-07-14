name := "Mini linguagem de programação Oberon" // Nome do projeto
organization := "br.unb.cic"
version := "1.0" // Versão do projeto
scalaVersion := "2.12.4" // Versão do scala

// As Bibliotecas utilizadas para testes e outras coisas
libraryDependencies += "org.typelevel" %% "cats-core" % "1.0.1"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"

libraryDependencies += "org.scalameta" %% "scalameta" % "3.7.4"
libraryDependencies += "org.scalameta" %% "contrib" % "3.7.4"

parallelExecution in Test := false
