object Lesson7 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  case class interpolate(x1:Double, y1 :Double, x2:Double, y2 :Double,x3:Double, y3 :Double){
  	private val d1 = y1/(x1-x2)*(x1-x3)
  	private val d2 = y2/(x2-x1)*(x2-x3)
  	private val d3 = y3/(x3-x1)*(x3-x2)
  	
  	private val n1 = (x1-x2)*(x1-x3)
  	private val n2 = (x2-x1)*(x2-x3)
  	private val n3 = (x3-x1)*(x3-x2)
  	
  	
  	def evalF(x:Double) = {
  	 d1*(x-x2)*(x-x3) + d2*(x-x1)*(x-x3) +d3*(x-x1)*(x-x2)
  	}
  
  def evalF2(x:Double) = {
  	 y1*(x-x2)*(x-x3)/n1 + y2*(x-x1)*(x-x3)/n2 +y3*(x-x1)*(x-x2)/n3
  	}
  
  
  }
  import math._
  
  val x1 = 0.0                                    //> x1  : Double = 0.0
  val x2 = 0.1                                    //> x2  : Double = 0.1
  val x3 = 0.2                                    //> x3  : Double = 0.2
  
  val I = interpolate(x1, sin(x1), x2, sin(x2), x3, sin(x3))
                                                  //> I  : Lesson7.interpolate = interpolate(0.0,0.0,0.1,0.09983341664682815,0.2,0
                                                  //| .19866933079506122)
  I.evalF2(0.12)                                  //> res0: Double = 0.11968039967636235
  sin(0.12)                                       //> res1: Double = 0.11971220728891936
  
  
}