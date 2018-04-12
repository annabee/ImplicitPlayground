
final case class Witcher(name: String)
final case class Villager(name: String)

case class Dragon(name: String)
case class DeadDragon(name: String)

trait DragonSlayer[A] {
  def killDragon(dragonToSlay: Dragon): DeadDragon
}


// add DragonKillersUtils as an implicit class
object DragonKillers {

  implicit object Witcher extends DragonSlayer[Witcher] {
    override def killDragon(dragon: Dragon) = DeadDragon(dragon.name)
  }
  implicit object Villager extends DragonSlayer[Villager] {
    override def killDragon(dragon: Dragon) = DeadDragon(dragon.name)
  }

  // take type parameter out of def and into the implicit class
  implicit class KillDragonUtil[A](x: A) {
    def killDragon(dragon: Dragon)(implicit dragonSlayer: DragonSlayer[A]): DeadDragon = {
      dragonSlayer.killDragon(dragon)
    }
  }
}

// In another village (package)
import DragonKillers._
val deadTrogdor: DeadDragon = Witcher.killDragon(Dragon("Trogodr"))
val deadBlinky: DeadDragon = Villager.killDragon(Dragon("Blinky"))


