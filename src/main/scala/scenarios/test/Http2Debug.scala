package scenarios.test

import io.qt.api.annotation.ShowScenario
import io.qt.{DebugScenario, ScenarioObj}
import scripts.test.{Http2Test, HttpTest, ScriptWs}

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps


@ShowScenario
class Http2Debug extends DebugScenario {
  val script = Http2Test
  val testersNum = 1
  val requestsNum = 1
  val name: String = "Http2 debug"
  val openThrottle = 10 millis
  val runImmediately = false // after opening
  val statPeriod = 10 seconds

  override val statRequests = true // рассчитывать статистику по запросам (а не только по транзакциям)
  override val statDeviation = true // рассчитывать отклонение
}