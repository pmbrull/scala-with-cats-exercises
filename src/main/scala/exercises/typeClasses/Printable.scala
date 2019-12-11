package exercises.typeClasses

trait Printable[A] {
  def format(value: A): String
}

object PrintableInstances {
  implicit val stringPrinter: Printable[String] =
    new Printable[String] {
      def format(value: String): String = value
    }

  implicit val IntPrinter: Printable[Int] =
    new Printable[Int] {
      def format(value: Int): String = value.toString
    }

  implicit val CatPrinter: Printable[Cat] =
    new Printable[Cat] {
      def format(cat: Cat): String = {
        val name = Printable.format(cat.name)
        val age = Printable.format(cat.age)
        val color = Printable.format(cat.color)
        s"$name is a $age year-old $color cat."
      }
    }
}

object Printable {
  def format[A](value: A)(implicit p: Printable[A]): String =
    p.format(value)

  def print[A](value: A)(implicit p: Printable[A]): Unit =
    println(format(value))
}

// Create methods for better syntax to easen the use of the library
object PrintableSyntax {
  implicit class PrintableOps[A](value: A) {
    def format(implicit p: Printable[A]): String =
      p.format(value)

    def print(implicit p: Printable[A]): Unit =
      println(format(p))
  }
}

// Now let's create an Example with a case class
final case class Cat(name: String, age: Int, color: String)
