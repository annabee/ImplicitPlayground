
// Imported library we can't touch
class Dragon(name: String)

object Dragon {

  implicit class DragonWithWings(dragon: Dragon) {
    def fly(): Unit = println("Look, ma, I'm flying!")
  }
}

val trogdor = new Dragon("Trogdor")

trogdor.fly()
