// declared implicits

implicit val implicitCarrot = "carrot"

// imported implicits

import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.ExecutionContext.Implicits.global

def getFuture[A](implicit ec: ExecutionContext): Future[A] = { ??? }

getFuture[String]

// wildcard imports

def sum[T : Integral](list: List[T]): T = {
  val integral = implicitly[Integral[T]]
  import integral._   // get the implicits in question into scope
  list.foldLeft(integral.zero)(_ + _)
}
