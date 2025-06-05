package scripts.test

import io.qt.builder.Sql
import io.qt.{Script, ScriptObj, builder}

import scala.collection.mutable.Buffer

object ScriptJdbc extends ScriptObj {
  def apply() = new ScriptJdbc
}

class ScriptJdbc extends Script {
  val name = "test jdbc"

  val req = Sql("dvdrental", Map(query -> "", timeout -> 600))
    .make()
    .copy(_requestTemplate = "SELECT * FROM public.film where film_id = $id")

  //    """{
  //         type : "jdbc"
  //            jdbc.endpoint.url : "dvdrental"
  //            jdbc.endpoint.headers : {
  //                query: "SELECT * FROM public.film where film_id = 1"
  //                timeout: 600 ms
  //            }
  //            _requestTemplate = "SELECT * FROM public.film where film_id = $$id"
  //       }
  //       """.jdbc //

  var id = 0

  def assertStep() = {
    val rs = tc("dvdrental").asInstanceOf[Buffer[Map[String, Any]]]
    val h = rs.head
    val t = rs.tail
    assert(t == Nil, "Набор должен содержать только одну запись")
    assert(rs.size == 1, "Набор должен содержать только одну запись")
    assert(h("film_id") == id, s"film_id должен равняться $id")
    assert(tc("film_id") == id, s"film_id должен равняться $id")
    empty
  }


  def step1() = {
    id += 1
    if (id > 1000)
      id = 1
    val query = s"SELECT * FROM public.film where film_id = $id"
    req.copy(query = query)
  }

  val load = builder.LoadSteps(step1, assertStep)
}
