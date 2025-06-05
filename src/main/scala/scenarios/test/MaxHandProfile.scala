package scenarios.test

import io.qt.Max
import io.qt.api.annotation.ShowScenario
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

@ShowScenario
class MaxHandProfile extends Max {
  val scenario = EmptyHandProfile
  val stepsNumber = 4
  val stepDuration = 30 seconds
  val startK = 2
  val stepK = 3
}
