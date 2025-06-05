package scenarios.test

import io.qt.DebugScenario
import io.qt.api.annotation.ShowScenario
import scripts.test.ReadKafka
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

@ShowScenario
class ReadKafkaDebug extends DebugScenario {
  val script = ReadKafka
  val testersNum = 10
  val requestsNum = 10000
  val name = "read kafka debug"
  val openThrottle = 0 seconds
  val runImmediately = false // after opening
  val statPeriod = 10 seconds
}