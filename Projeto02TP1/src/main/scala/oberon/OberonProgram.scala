package oberon

import oberon.command.Command

import oberon.visitor.Visitor

class OberonProgram(val cmd: Command) extends Command {

  override
  def run() : Unit = {
    cmd.run()
  }

   override
  def checa_tipo_comando() : Boolean = cmd.checa_tipo_comando()

  override def accept(v : Visitor) {
    v.visit(this) 
  }

}
