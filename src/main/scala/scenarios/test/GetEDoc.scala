package scenarios.test

import io.qt.FunctionalScenario
import io.qt.api.annotation.ShowScenario
import scripts.test.GetEDocUFEBSSynapse

@ShowScenario
class GetEDoc extends FunctionalScenario {
  val script = GetEDocUFEBSSynapse
  override val requestsNum = -1 // -1 бесконечный цикл
  val name = "GetEDoc функциональный сценарий"
}