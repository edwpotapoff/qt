package scenarios.test

import io.qt.api.annotation.ShowScenario
import io.qt.{DebugScenario, ScenarioObj}
import scripts.test.XmlTest

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

object XmlScenario extends ScenarioObj {
  def apply() = new XmlScenario
}

@ShowScenario
class XmlScenario extends DebugScenario {
  val script = XmlTest
  val testersNum = 1
  val requestsNum = 1
  val name: String = "XmlScenario"
  val openThrottle = 10 millis
  val runImmediately = false // after opening
  val statPeriod = 10 seconds

  override val statRequests = true // рассчитывать статистику по запросам (а не только по транзакциям)
  override val statDeviation = true // рассчитывать отклонение
}