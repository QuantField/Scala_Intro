
import math._

object mainWork2 extends App {
    
  	final val N       = 500;
	  final val Z       = 1.0;
	  val       Rmax    = 20.00;
	  val       h       = Rmax/N.toDouble
	  val       C       = h*h/12.00
	  val       r, rho, Sol,Vcoulomb, Vcentrifugal, V, K  = new Array[Double](N+1);
	  val wave = new Array[Double](N+1)
	    
	  // Couloumb potential
	  for(i<-0 to N){ 
	      r(i)=i*h
	      Vcoulomb(i) = -Z/r(i)
	  }
	  
	  def setVcentrifugal( l:Int) {
	    val A = 0.5*l*(l+1)
	    for(i<-0 to N) 
	      Vcentrifugal(i) = A/(r(i)*r(i));	 
	  }
	  
	 	    
	  def  setVext() {
	    	for(i<-0 to N) 
	        V(i) = Vcoulomb(i) +  Vcentrifugal(i)
	  }
	  
	  
	  
	  def F2(E:Double) = {
  	  var Phi2, Phi1, Phi0 = 0.0
  	  val alph = Math.sqrt(-2*E);
  		Phi2   = exp(-alph*r(N)) //; // r[N]*Math.exp(-Z*r[N]) ;  // Sol(xb) = 0;
  		Phi1   = exp(-alph*r(N-1))//1e-8; // r[N-1]*Math.exp(-Z*r[N-1]) ; //1e-6; //    
  		val TwoE = 2.0*E
  		// This is Numerov method starting from the left
  	  for( i<-N-1 to 1 by -1) {
  			Phi0 = ( 2*(1.0 - 5.0*C*(TwoE - 2.0*V(i)) )*Phi1 -
  					   (1.0 + C*(TwoE - 2.0*V(i+1)) )*Phi2 )/(1.0+C*(TwoE - 2.0*V(i-1)))		
  			Phi2 = Phi1		
  			Phi1 = Phi0			
  	  }
  	  Phi0	  
	  }
	  
//	  Sol[i-1] = ( 2*(1. - 5.*C*K[i])*Sol[i] - 
//						(1. + C*K[i+1] )*Sol[i+1] )/(1.+C*K[i-1]);
	  
	  def getWaveFunction(E:Double) {
  	  
	    var Phi2, Phi1, Phi0 = 0.0
  	  val alph = Math.sqrt(-2*E);
  		//val TwoE = 2.0*E
  		// This is Numerov method starting from the right
	    
	    val K = new Array[Double](N+1)
	    for(i<-N to 0) K(i) = 2.0*(E-V(i))
	    
	    wave(N)  = exp(-alph*r(N)) 
  		wave(N-1)= exp(-alph*r(N-1)) 
  	  for( i<-N-1 to 1 by -1) 
  			wave(i-1) = ( 2*(1.0 - 5.0*C*K(i) )*wave(i) -
  					   (1.0 + C*K(i+1) )*wave(i+1) )/(1.0+C*K(i-1))	 	  	   
	  }
	
	  def F(E:Double) = {
	    getWaveFunction(E)
	    wave(0)	    
	  }
	  
	  
	  
	
	  setVcentrifugal(l = 0);
	  setVext();
	  
	  val elist = List(-2.0, -1.5, -1.0)
	  elist.map(x=>F(x)).map(println)
	  
	  
	  import myMath.zeros._
    
	  val Res = secant(F, -2, -1.50)
	
	  //val wave = getWaveFunction(Res._1)
	  
	  //wave.map(println)

	  
	  
	  
}	