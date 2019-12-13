package exercises.typeClasses
import cats.instances.option._
import cats.syntax.eq._
import cats.syntax.show._
import exercises.typeClasses.CatEq._
import exercises.typeClasses.CatShow._
import exercises.typeClasses.PrintableInstances._
import exercises.typeClasses.PrintableSyntax._ // for Eq

object Example extends App {

  val cat = Cat(name = "Levy", age = 1, color = "white")

  // Using the Instances
  Printable.print(cat)

  // Using better syntax
  cat.print

  // Using Cats' show
  println(cat.show)

  // Testing Cat Eq
  val cat1 = Cat("Garfield",   38, "orange and black")
  val cat2 = Cat("Heathcliff", 33, "orange and black")

  cat1 === cat2

  val optionCat1 = Option(cat1)
  val optionCat2 = Option.empty[Cat]

  // to compare options we need to import
  // import cats.instances.option._
  println(optionCat1 === optionCat2)
}
