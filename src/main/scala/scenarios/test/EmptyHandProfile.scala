package scenarios.test

import empty._
import io.qt.api.annotation.ShowScenario
import io.qt.{HandProfile, ScenarioObj}
import scala.language.postfixOps
import scala.concurrent.duration.DurationInt


object EmptyHandProfile extends ScenarioObj {
  def apply() = new EmptyHandProfile
}

@ShowScenario
class EmptyHandProfile extends HandProfile {
  val requestsNum = -1
  val openThrottle = 100 millis
  val runImmediately = true // after opening
  val statPeriod = 10 seconds

  // Отражение Скрипт -> RPS
  override val loadProfile = Map(
    UC1_LoginLogout -> (1, 1)
    //    , UC2_BuyingATicket -> (0.88, 2)
    //    , UC3_ViewBooking -> (0.07 / 3600, 0)
    //    , UC4_DeleteBooking -> (90.37, 6)
    //    , UC5_UserRegistration -> (0.48, 1)
  )

  val name: String = "EmptyHandProfile"

  override val pacingReserve = 0.3
}