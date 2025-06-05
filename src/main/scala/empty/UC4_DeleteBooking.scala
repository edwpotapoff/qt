package empty

import io.qt.builder.Load
import io.qt.{Script, ScriptObj}

object UC4_DeleteBooking extends ScriptObj {
  val name = "UC4_DeleteBooking"

  def apply() = new UC4_DeleteBooking
}

class UC4_DeleteBooking extends Script {
  def name = UC4_DeleteBooking.name

  val load = Load(OpenSite, Login, Itinerary, DeleteBooking, Logout)
}
