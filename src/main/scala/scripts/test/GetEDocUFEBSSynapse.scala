package scripts.test

import io.qt.builder.KafkaGet
import io.qt.{Script, ScriptObj, builder}
import io.utils.Random

object GetEDocUFEBSSynapse extends ScriptObj {

  def apply() = new GetEDocUFEBSSynapse
}

class GetEDocUFEBSSynapse extends Script {
  val name = "SrvGetEDocUFEBS_Synapse_SBPPRB-GWFI_101_01"
  val rqUID = Random.genNumString(32)
  val correlationRqUID = Random.genNumString(32)
  val rpName = "urn:sbrfsystems:99-gmq"
  val _body = "./asit/kafka/01/data/BodyRq.json".file()

  val httpReq =
    s"""{
      type: "send"
      send.endpoint.url: "http://getufebs-rq-dev.dev-sh4.ocp-geo.delta.sbrf.ru:80/service"
      send.endpoint.headers: {
        type: POST
        status: 200
      }
      send.message: {
        headers: {
          content-type: "application/json"
          X-MessageID: "${rqUID}"
          X-CorrelationMessageID: "${correlationRqUID}"
          X-FinlineChannel: "${rpName}"
          X-DocFormat: "ufebs"
          X-MessageType: "request"
          X-DateTime: "2023-05-17T19:00:00"
        }
      }
    }""".http
      .copy(body = _body)

  def stepHttp() = httpReq

  def showHttp() = {
    showMessage() // выводим в лог сообщение от http-сервиса
    empty
  }

  val checkStep = () => {
    showMessage() // выводим в лог сообщение от kafka

    // lrb - вырезаем значение из сообщения по правой и левой границе
    if (lrb("MessageID\":\"", "\"") == rqUID)
      stopUser()
  }

  override def init = builder.LoadInit(stepHttp, showHttp)

  val load = builder.Load(KafkaGet("monitoring:GWFI.monitoring_request"), checkStep)
}