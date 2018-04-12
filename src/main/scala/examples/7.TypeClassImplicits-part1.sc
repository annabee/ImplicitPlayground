
final case class Witcher(name: String)
final case class Villager(name: String)

case class Dragon(name: String)
case class DeadDragon(name: String)

trait DragonSlayer[A] {
  def killDragon(dragonToSlay: Dragon): DeadDragon
}

object Witcher extends DragonSlayer[Witcher] {
  override def killDragon(dragon: Dragon) = DeadDragon(dragon.name)
}
object Villager extends DragonSlayer[Villager] {
  override def killDragon(dragon: Dragon) = DeadDragon(dragon.name)
}

// Common functionality moved out
object KillDragonUtil {
  def killDragon[A](dragon: Dragon, dragonSlayer: DragonSlayer[A]): DeadDragon = {
    dragonSlayer.killDragon(dragon)
  }
}

val deadDragon: DeadDragon = KillDragonUtil.killDragon(Dragon("Trogodr"), Witcher)





