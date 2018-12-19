
final case class Witcher(name: String)
final case class Villager(name: String)

case class Dragon(name: String)
case class DeadDragon(name: String)

trait DragonSlayer[A] {
  def killDragon(dragonToSlay: Dragon, killer: A): DeadDragon
}

// collect all dragon killers
// add implicit conversion
object DragonKillers {

  implicit object WitcherDragonSlayer extends DragonSlayer[Witcher] {
    def killDragon(dragon: Dragon, witcher: Witcher): DeadDragon = {
      println(s"I'm a Witcher and I've slayed ${dragon.name}.")
      DeadDragon(dragon.name)
    }
  }

  implicit object VillagerDragonSlayer extends DragonSlayer[Villager] {
    def killDragon(dragon: Dragon, villager: Villager): DeadDragon = {
      println(s"I'm a Villager and I've pitchforked ${dragon.name}.")
      DeadDragon(dragon.name)
    }
  }

  // take type parameter out of def and into the implicit class
  implicit class KillDragonUtil[A](x: A) {
    def killDragon(dragon: Dragon)(implicit dragonSlayer: DragonSlayer[A]): DeadDragon = {
      dragonSlayer.killDragon(dragon, x)
    }
  }

}
import DragonKillers._

val deadTrogdor: DeadDragon = Witcher("Geralt").killDragon(Dragon("Trogdor"))
