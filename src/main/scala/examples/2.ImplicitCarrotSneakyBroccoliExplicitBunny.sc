
implicit val implicitCarrot: String = "carrot"

def whoAmI(implicit a: String): Unit = {
  println(s"Here's your $a.")
}

//implicit val sneakyBroccoli: String = "broccoli"

val explicitBunny = "bunny"

whoAmI(explicitBunny)

whoAmI


