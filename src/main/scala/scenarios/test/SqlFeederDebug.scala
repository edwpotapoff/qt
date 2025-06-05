package scenarios.test

import io.qt.DebugScenario
import io.qt.api.annotation.ShowScenario
import scripts.test.SqlFeeder
import scala.language.postfixOps
import scala.concurrent.duration.DurationInt

@ShowScenario
class SqlFeederDebug extends DebugScenario {
  val script = SqlFeeder
  val testersNum = 10
  val requestsNum = 10
  val name = "SqlFeederDebug"
  val openThrottle = 0 seconds
  val runImmediately = false // after opening
  override val statTemplate = true
  val statPeriod = 10 seconds
}