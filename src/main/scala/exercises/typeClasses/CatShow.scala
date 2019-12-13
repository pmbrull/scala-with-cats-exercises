package exercises.typeClasses

import cats.Show
import cats.instances.int._    // for Show
import cats.instances.string._ // for Show
import cats.syntax.show._      // for show

object CatShow {
  implicit val catShow: Show[Cat] =
    Show.show(cat =>
      s"${cat.name.show} is a ${cat.age.show} year-old ${cat.color.show} cat."
    )
}
