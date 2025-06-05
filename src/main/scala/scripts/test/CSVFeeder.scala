package scripts.test


import io.qt.{Script, ScriptObj, builder}

object CSVFeeder extends ScriptObj {
  def apply() = new CSVFeeder
}

class CSVFeeder extends Script {
  val name = "script data"

  var users: FDS = _
  var cities: FDS = _

  def initStep0() = {
    users = "./parameters/Users".fcsv("DataSource0")
    cities = "./parameters/Cities".fcsv("DataSource0")
    pass
  }

  def setupStep() = {
    users.next
    cities.rand // nextUnique
    pass
  }

  def check0() = {
    val username = tc("username")
    val city = "city".tc
    log.info(s"username $username, city $city, id $hitId")
    empty
  }

  override val init = builder.LoadInit(initStep0)
  val load = builder.LoadSteps(setupStep, check0)
}