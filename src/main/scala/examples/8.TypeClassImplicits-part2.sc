
final case class Witcher(name: String)
final case class Villager(name: String)

case class Dragon(name: String)
case class DeadDragon(name: String)

trait DragonSlayer[A] {
  def killDragon(dragonToSlay: Dragon): DeadDragon
}

// Common functionality moved out
// plus implict parameters
object KillDragonUtil {
  def killDragon[A](dragon: Dragon)(implicit dragonSlayer: DragonSlayer[A]): DeadDragon = {
    dragonSlayer.killDragon(dragon)
  }
}

// companion objects moved into a common place
// make them implicit
object DragonKillers {

  implicit object Witcher extends DragonSlayer[Witcher] {
    override def killDragon(dragon: Dragon) = DeadDragon(dragon.name)
  }
  implicit object Villager extends DragonSlayer[Villager] {
    override def killDragon(dragon: Dragon) = DeadDragon(dragon.name)
  }
}

// In another village (package)
import DragonKillers._
val deadTrogdor: DeadDragon = KillDragonUtil.killDragon(Dragon("Trogodr"))
val deadBlinky: DeadDragon = KillDragonUtil.killDragon(Dragon("Blinky"))







