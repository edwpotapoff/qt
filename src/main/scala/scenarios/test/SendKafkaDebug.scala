package scenarios.test

import io.qt.DebugScenario
import io.qt.api.annotation.ShowScenario
import scripts.test.SendKafka
import scala.language.postfixOps
import scala.concurrent.duration.DurationInt

@ShowScenario
class SendKafkaDebug extends DebugScenario {
  val script = SendKafka
  val testersNum = 10
  val requestsNum = 1000
  val name = "send kafka debug"
  val openThrottle = 0 seconds
  val runImmediately = false // after opening
  val statPeriod = 10 seconds
}