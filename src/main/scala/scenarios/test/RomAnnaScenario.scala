package scenarios.test

import io.qt.{DebugScenario, ScenarioObj}
import io.qt.api.annotation.ShowScenario
import scripts.test.RomAnnaScript

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps


@ShowScenario
class RomAnnaScenario extends DebugScenario {
  override val statRequests = true // рассчитывать статистику по запросам (а не только по транзакциям)
  override val statDeviation = true // рассчитывать отклонение
  val script = RomAnnaScript
  val testersNum = 1
  val requestsNum = -1
  val name: String = "RomAnnaScenario"
  val openThrottle = 10 millis
  val runImmediately = false // after opening
  val statPeriod = 10 seconds
}

object RomAnnaScenario extends ScenarioObj {
  def apply() = new RomAnnaScenario
}
