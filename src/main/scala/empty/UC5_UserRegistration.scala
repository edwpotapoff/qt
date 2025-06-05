package empty

import io.qt.builder.Load
import io.qt.{Script, ScriptObj}

object UC5_UserRegistration extends ScriptObj {
  val name = "UC5_UserRegistration"

  def apply() = new UC5_UserRegistration
}

class UC5_UserRegistration extends Script {
  def name = UC5_UserRegistration.name

  val load = Load(OpenSite, SignUp, Registration, Continue)
}
