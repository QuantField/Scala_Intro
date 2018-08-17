/*
setter and getter is scala
part 2
*/
object Lesson6 {
// if the parameters in class definition are preceded with val or var
// the become automatically fields of the class and setters and getters are created
class Circle(var Radius:Double)
class Square(val side :Double)

val C1 = new Circle(1.0)                          //> C1  : Lesson6.Circle = Lesson6$Circle@3843d287
C1.Radius =2

val S1 = new Square(3)                            //> S1  : Lesson6.Square = Lesson6$Square@1193b520
println(S1.side)                                  //> 3.0

// if the class parameter is not preceded by either val or var it won't be a field
// of the class...
class Cube(side:Double)

val D = new Cube(3.4)                             //> D  : Lesson6.Cube = Lesson6$$anonfun$main$1$Cube$1@2b0e08e1
// println(D.side) this doesn't work because side is not a field and hence
// the getter .side is not created

// However if the class parameter is not preceded by either val or var but used
// in one of the class methods it becomes an object-private field
class Cube2(side:Double){
	def volume():Double = side*side*side
	def getSide = side
}

val P = new Cube2(4)                              //> P  : Lesson6.Cube2 = Lesson6$$anonfun$main$1$Cube2$1@37f92637
P.volume()                                        //> res0: Double = 64.0
P.getSide                                         //> res1: Double = 4.0
//println(P.side)







}