package scenarios.test

import io.qt.Stress
import io.qt.api.annotation.ShowScenario

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

@ShowScenario
class StressTest extends Stress {
  val scenario = TestScenario
  val stepDuration = 60 seconds
  val startK = 1
  val stepK = 10
}
