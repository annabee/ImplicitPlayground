
final case class Witcher(name: String)
final case class Villager(name: String)

case class Dragon(name: String)
case class DeadDragon(name: String)

trait DragonSlayer[A] {
  def killDragon(dragonToSlay: Dragon, killer: A): DeadDragon
}

object WitcherDragonSlayer extends DragonSlayer[Witcher] {
  def killDragon(dragon: Dragon, witcher: Witcher): DeadDragon = {
    println(s"I'm a Witcher and I've slayed ${dragon.name}.")
    DeadDragon(dragon.name)
  }
}

object VillagerDragonSlayer extends DragonSlayer[Villager] {
  def killDragon(dragon: Dragon, villager: Villager): DeadDragon = {
    println(s"I'm a Villager and I've pitchforked ${dragon.name}.")
    DeadDragon(dragon.name)
  }
}

// Common functionality moved out
object KillDragonUtil {
  def killDragon[A](dragon: Dragon, x: A, dragonSlayer: DragonSlayer[A]): DeadDragon = {
    dragonSlayer.killDragon(dragon, x)
  }
}

val deadDragon: DeadDragon = KillDragonUtil.killDragon(Dragon("Trogodr"), Witcher("Geralt"), WitcherDragonSlayer)
val deadDragon2: DeadDragon = KillDragonUtil.killDragon(Dragon("Trogodr"), Villager("Bob"), VillagerDragonSlayer)
