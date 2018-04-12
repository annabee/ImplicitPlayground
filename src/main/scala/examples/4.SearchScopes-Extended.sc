// companion objects

import play.api.libs.json._
import play.api.libs.functional.syntax._


case class Dragon(name: String, wingspan: Option[Double])

object Dragon {
  implicit val reads: Reads[Dragon] = (
    (JsPath \ "name").read[String] and
      (JsPath \ "wingspan").readNullable[Double])(Dragon.apply _)
}


val json = """{"name": "Trogdor", "wingspan": 2.8}"""
val dragon = Json.parse(json).as[Dragon]

// super types

class Water

object Water {
  implicit def ice2string(ice: Ice): String = "ice"
  implicit def water2string(water: Water): String = "water"
}

class Ice extends Water

val water: String = new Ice


// overriding

trait SomeBasicImplicits {
  implicit val vegetable = "vegetable"
}

object OverridingImplicitsInScope extends SomeBasicImplicits {
  //implicit val carrot = "carrot"

  val result = s"Implicitly found ${implicitly[String]}."

  println(result)
}

OverridingImplicitsInScope

