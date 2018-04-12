implicit def listMaker[T](implicit t: T): List[T] = List(t)
implicit def optionMaker[T](implicit t: T): Option[T] = Some(t)

implicit val carrot: String = "carrot"

def muchImplicitMagic(implicit l: Option[Option[List[Option[Option[List[Option[List[String]]]]]]]]): Unit = {
  println(s"I heard you like inception... $l.")
}

muchImplicitMagic
