package scenarios.test

import io.qt.Max
import io.qt.api.annotation.ShowScenario
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

@ShowScenario
class MaxEmptyProfile extends Max {
  val scenario = EmptyHandProfile
  val stepsNumber = 4
  val stepDuration = 60 seconds
  val startK = 1
  val stepK = 1
}
