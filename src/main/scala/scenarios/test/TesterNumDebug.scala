package scenarios.test

import io.qt.DebugScenario
import io.qt.api.annotation.ShowScenario
import scripts.test.TesterNum
import scala.language.postfixOps
import scala.concurrent.duration.DurationInt

@ShowScenario
class TesterNumDebug extends DebugScenario {
  val script = TesterNum
  val testersNum = 2
  val requestsNum = 1
  val name = "TesterNum debug"
  val openThrottle = 0 seconds
  val runImmediately = false // after opening
  val statPeriod = 10 seconds
}