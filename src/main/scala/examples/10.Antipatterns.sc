
import scala.language.implicitConversions

// Don't convert between existing types
implicit def intToString(i: Int): String = i.toString

// Definitely don't do that!
implicit def stringToInt(s: String): Int = s.toInt

//println(stringToInt("anna"))


// Changes behaviour of equals()
import scala.collection.convert.{WrapAsJava, WrapAsScala}

// Instead use Decorators
import scala.collection.convert.{DecorateAsJava, DecorateAsScala}



val a = new WrapAsJava { }
val b = new WrapAsScala { }


val c = new DecorateAsJava {}
val d = new DecorateAsScala {}
