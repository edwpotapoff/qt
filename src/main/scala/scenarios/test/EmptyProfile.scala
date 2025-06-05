package scenarios.test

import empty._
import io.qt.api.annotation.ShowScenario
import io.qt.{ComplexProfile, ScenarioObj}
import scala.language.postfixOps
import scala.concurrent.duration.DurationInt


object EmptyProfile extends ScenarioObj {
  def apply() = new EmptyProfile
}

@ShowScenario
class EmptyProfile extends ComplexProfile {
  val testersNum = 0
  val requestsNum = 100
  val statPeriod = 10 seconds

  val name: String = "EmptyProfile"

  val openThrottle = 500 millis
  val runImmediately = true
  val pacingReserve = 0.1

  val loadScripts = Set(
    UC1_LoginLogout
    , UC2_BuyingATicket
    , UC3_ViewBooking
    , UC4_DeleteBooking
    , UC5_UserRegistration
  )

  // Отражение Имя транзакции -> RPS
  val loadProfile = Map(
    Continue -> 97D / 10
    , DeleteBooking -> 73D / 10
    , FindFlights -> 282D / 10
    , Flights -> 305D / 10
    , Itinerary -> 280D / 10
    , Login -> 422D / 10
    , Logout -> 422D / 10
    , OpenSite -> 520D / 10
    , Payment -> 175D / 10
    , Registration -> 97D / 10
    , SelectionFlights -> 270D / 10
    , SignUp -> 97D / 10
  )
}