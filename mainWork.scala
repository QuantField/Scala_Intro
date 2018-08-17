// Shroding equation for particle in box..Hard Wall potential
/*
 * 
 * -a----------------0------------------+a
 * 
 * V(-a) = V(+a) = Infinity
 * V(x) =0  when -a <x<a 
 * 
 * 
 * 
 */
import math._
import myMath.Integrate._
import myMath.zeros._

class HardWallExacteSolution( a:Double ){
  
  val E0       = Pi*Pi/(8*a*a)
  val w0       = Pi/(2*a)
  val NormCste = 1.0/sqrt(a)
  
  def E(n:Int) = n*n*E0
  
  def WaveFunction(n:Int, x:Double) : Double  = {    
      if (n%2==0)  NormCste*sin(n*w0*x)
              else NormCste*cos(n*w0*x)   
  }
  
}

object mainWork extends App {
  
  val a  = 1.0
  val xa = -a
	val xb = a
	val N  = 100
	val h  = (xb-xa)/N;
	val Psi0 = 0.0
	val Psi1 = 1.0E-6
	val Psi  = new Array[Double](N+1)
	val x    = new Array[Double](N+1)
	for(i <- 0 to N) x(i) = xa +i*h
	
	val C =h*h/12.0
	
	val V  = new Array[Double](N+1)
	
	def F(E:Double) = {
	  var Phi2, Phi1, Phi0 = 0.0
	  Phi0 = Psi0
	  Phi1 = Psi1
	  val TwoE = 2.0*E
	  for( i<-1 to N-1) {
			Phi2 = ( 2*(1.0 - 5.0*C*(TwoE - 2.0*V(i)) )*Phi1 -
					(1.0 + C*(TwoE - 2.0*V(i-1)) )*Phi0 )/(1.0+C*(TwoE - 2.0*V(i+1)))		
			Phi0 = Phi1		
			Phi1 = Phi2			
	  }
	  Phi2	  
	}

	def calculateWaveFunction(E:Double ) {
		/* begin of the Numerov-Algorithm */
		Psi(0) = Psi0   // Psi(xa) = 0;
		Psi(1) = Psi1
		val TwoE = 2.0*E
		for( i<-1 to N-1) {
			Psi(i+1) = ( 2*(1.0 - 5.0*C*(2.0*E - 2.0*V(i)) )*Psi(i) -
					(1.0 + C*(2.0*E - 2.0*V(i-1)) )*Psi(i-1) )/(1.0+C*(2.0*E - 2.0*V(i+1)))			 
		}
	}
	
  
	
	
	def normalise(Psi:Array[Double])
	{
		//val PsiSq = Psi.map(x=>x*x)
		val Norm  = sqrt(SimpsonTab(Psi.map(x=>x*x),h))
		for(i<-0 to N) Psi(i) = Psi(i)/Norm	  
	}
	
  
	println("-----Secant ------")
	
	val  (energy_numeric, iterations)  = secant(F, 0, 2)
	// when we use tuples variable names must be in lower case, at least the first letter
	
	calculateWaveFunction(energy_numeric)
	normalise(Psi)
	println
	val P = new HardWallExacteSolution(a)
	println("=========== Eigen Energy ============")
	println("Computed value : " + energy_numeric + " (" + iterations +" iterations)")
	println("Exact value    : " + P.E(1))

	println
	
	//Psi.map(println)
	val PsiExact = x.map(t=>P.WaveFunction(1, t))
	var error = 0.0
	for(i<-0 to N) error = max(abs(Psi(i)-PsiExact(i)),error)
	
	println(error)
	println
	for(i<-0 to N) println(Psi(i)+"\t"+PsiExact(i))
	
	
	
	
	
	
  //val PsiSq = Psi.map(x=>x*x)
	
  
  //println(SimpsonTab(PsiSq,h))
  
  //Psi.map(println)
}