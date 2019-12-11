package exercises.typeClasses
import PrintableInstances._
import PrintableSyntax._

object Example extends App {

  val cat = Cat(name = "Levy", age = 1, color = "white")

  // Using the Instances
  Printable.print(cat)

  // Using better syntax
  cat.print
}
