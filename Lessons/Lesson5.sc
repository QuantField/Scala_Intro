/*
Function paramaters
*/

object Lesson5 {
 
 def func(x:Double, name:String) = {
 		println("My name is " + name)
 		x*x
 }                                                //> func: (x: Double, name: String)Double
 
 func(2.3, "F1")                                  //> My name is F1
                                                  //| res0: Double = 5.289999999999999
 // input parameters with named argument
 func(x=5, name="F2")                             //> My name is F2
                                                  //| res1: Double = 25.0
 // the order is not important.
 func(name = "F3", x=6)                           //> My name is F3
                                                  //| res2: Double = 36.0
  
 
 
}