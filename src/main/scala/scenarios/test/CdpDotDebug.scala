package scenarios.test

import io.qt.DebugScenario
import io.qt.api.annotation.ShowScenario
import scripts.test.CdpDot

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

@ShowScenario
class CdpDotDebug extends DebugScenario {
  val script = CdpDot
  val testersNum = 1
  val requestsNum = 1
  val name = "CdpDot debug"
  val openThrottle = 0 seconds
  val runImmediately = false // after opening
  val statPeriod = 10 seconds
}