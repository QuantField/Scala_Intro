//
//  How to use static variable.. creating object with the same name as the class
//  here it is Complex. a Complex class has access to the static Complex object
//  data and methods, which are all static.
//

object Lesson2 {

case class Complex(var real:Double=0.0, var imag:Double=0.0)
{
  Complex.increment()
  println("Complex Object Created ")
  println("Number of Complex Objects:" + Complex.count)
}

object Complex{
  private var count = 0;
  def increment() { count = count + 1}
}

  val a = Complex(1,2)                            //> Complex Object Created 
                                                  //| Number of Complex Objects:1
                                                  //| a  : Lesson2.Complex = Complex(1.0,2.0)
  val b = Complex()                               //> Complex Object Created 
                                                  //| Number of Complex Objects:2
                                                  //| b  : Lesson2.Complex = Complex(0.0,0.0)

}