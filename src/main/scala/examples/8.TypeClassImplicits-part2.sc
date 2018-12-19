
final case class Witcher(name: String)
final case class Villager(name: String)

case class Dragon(name: String)
case class DeadDragon(name: String)

trait DragonSlayer[A] {
  def killDragon(dragonToSlay: Dragon, killer: A): DeadDragon
}

// Common functionality moved out
// plus implicit parameters
object KillDragonUtil {
  def killDragon[A](dragon: Dragon, x: A)(implicit dragonSlayer: DragonSlayer[A]): DeadDragon = {
    dragonSlayer.killDragon(dragon, x)
  }
}

// companion objects moved into a common place
// make them implicit
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
}

// In another village (package)
import DragonKillers._
val deadTrogdor: DeadDragon = KillDragonUtil.killDragon(Dragon("Trogodr"), Witcher("Geralt"))
val deadBlinky: DeadDragon = KillDragonUtil.killDragon(Dragon("Blinky"), Villager("Bob"))
