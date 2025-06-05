package empty

import io.qt.builder.Load
import io.qt.{Script, ScriptObj}

object UC1_LoginLogout extends ScriptObj {
  val name = "UC1_LoginLogout"

  def apply() = new UC1_LoginLogout
}

class UC1_LoginLogout extends Script {
  def name = UC1_LoginLogout.name

  val load = Load(OpenSite, Login, Logout)
}