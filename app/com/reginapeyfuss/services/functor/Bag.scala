package com.reginapeyfuss.services.functor

case class Bag[A](content: A) {
    //this function is given by the case class and hence hidden
    //def apply(content: A): Bag[A] = new Bag(content)

    def map[B](f: A => B): Bag[B] = Bag(f(content))
    def flatMap[B](f: A => Bag[B]): Bag[B] = f(content)
    def flatten: A = content
}

case class Sugar(weight: Double)
case class HalfSugar(weight: Double)

object FunctorExample {
    //making sugar half
    def half: Sugar => HalfSugar = (sugar: Sugar) => HalfSugar(sugar.weight / 2)

    val sugarBag: Bag[Sugar] = Bag(Sugar(1))

    val halfSugarBag: Bag[HalfSugar] = sugarBag.map(sugar => half(sugar))

    def double = (sugar: Sugar) => Bag(Sugar(sugar.weight * 2))
    val doubleSugarBagFlatten: Bag[Sugar] = sugarBag.map(sugar => double(sugar)).flatten
    //or
    val doubleSugarBag: Bag[Sugar] = sugarBag.flatMap(sugar => double(sugar))
}

object OptionExampleWithoutMap {
    val x: Option[Int] = Some(1)
    val y: Int = 2
    val m: Int = 2
    val z: Option[Int] = if(x.isDefined) Some((x.get + y) * m) else None
}

object OptionExampleWithMap {
    //simplified logic
    val x: Option[Int] = Some(1)
    val y: Int = 2
    val m: Int = 2
    val z: Option[Int] = x.map(a => (a+y) * m)
}


