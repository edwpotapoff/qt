package scenarios.test

import io.qt.DebugScenario
import io.qt.api.annotation.ShowScenario
import scripts.test.SqlFeederLocal
import scala.language.postfixOps
import scala.concurrent.duration.DurationInt

@ShowScenario
class SQLFeederLocalDebug extends DebugScenario {
  val script = SqlFeederLocal
  val testersNum = 100
  val requestsNum = 1000
  val name = "local sql debug"
  val openThrottle = 0 seconds
  val runImmediately = false // after opening
  val statPeriod = 10 seconds
}