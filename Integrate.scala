import math._ 

package myMath{

 
object Integrate {
  
		def Simpson(func:Double=>Double, a:Double, b:Double, N :Int):Double ={
		  if (N%2 !=0) 
			{ 
			   println("method integrate error:N must be even."); 
			   0.0
			}
		  else{
  			val h = (b-a)/N
  			var S = func(a)+func(b)
  			for (i <- 1 to N by 2) S += 4.0*func(a + i*h)
  			for (i <- 2 to N-1 by 2) S += 2.0*func(a + i*h)
  			h*S/3	
		  }
		}  
		
		def SimpsonTab(func:Array[Double], h:Double):Double ={
		  val N = func.length-1
		  if (N%2 !=0) 
			{ 
			   println("method integrate error:N must be even."); 
			   0.0
			}
		  else{
  			var S = func(0)+func(N)
  			for (i <- 1 to N by 2)   S += 4.0*func(i)
  			for (i <- 2 to N-1 by 2) S += 2.0*func(i)
  			h*S/3	
		  }
		}  
		
		
}

object zeros{
  
  def bisection(f:Double=>Double ,a:Double, b:Double): (Double, Int) = {
   val epsilon = 1.0E-6 
   var (fa,  fb) = (f(a),f(b))
   var (xa,  xb) = (a,b)
   var xc,fc = 0.0
   var xc_old = 1.0;
   xc =2.0
   var iter = 2 // number of function evaluation
   if(fa*fb<0){
       while (abs((xc-xc_old)/xc_old) > epsilon){ 
         xc_old = xc
         xc = (xa+xb)/2.0
         fc = f(xc); iter+=1
         if (fa*fc<0.0) { xb = xc; fb=fc   }
                 else  { xa = xc; fa=fc   }
         println("x = "+xc+"  f(x) = "+ fc)
       }
    
    }
   else println(" No solutions ")
   (xc, iter)
 }
   
  
  
  def secant(f:Double=>Double ,a:Double, b:Double): (Double, Int) = {
   val (epsilon, maxIter) = (1.0E-6, 30)
   var (fa,  fb)   = (f(a),f(b))
   var (xa, xb) = (a,b)
   var iter = 2 // number of function evaluation
   var x1 = xa
   var x2 = xb
   var xm ,fxm, f1, f2, xv,fv = 0.0
   if (fa*fb>0)
       print("No solution")
   else{
       while (abs((x1-x2)/x2)>epsilon)  {
           if(x2<a | x2>b | iter==2){
               x1 = xa ;f1=fa
               xm = (xa+xb)/2.0
               fxm = f(xm) ; iter+=1
               if(fa*fxm<0) { xb = xm; fb =fxm }
                        else{ xa = xm; fa = fxm}
               x2 = xm ; f2 = fxm
           }
           xv = x2 ; fv = f2
           x2 += -(x2-x1)*f2/(f2-f1)
           f2 = f(x2) ; iter+=1
           x1 = xv; f1 = fv
           println("x = "+x2+"  f(x) = "+ f2)
       }
   }
   (x2, iter)
  }
  
  def brent(f:Double=>Double ,a:Double, b:Double): (Double, Int) = {
   val (epsilon, maxIter) = (1.0E-6, 30)
   var(xa, xb) = (a,b)
   var(fa,  fb)   = (f(a),f(b))
   var iter = 2
   var x1, f1, x2, f2 ,x3, f3 ,xm ,fxm ,xv, fv = 0.0
   x3 = 1.0
   x2 = 9999999.0

   if (fa*fb>0)
       println("No solution")
   else{
       while( abs((x2-x3)/x3)>epsilon){
           if (x3<a | x3>b | iter==2){
               x1 = xa; f1=fa 
               x2=xb ;f2 = fb
               xm = (xa + xb)/2.0               
               fxm = f(xm) ; iter+=1
               if (fa*fxm<0) { xb = xm ; fb = fxm}
                        else { xa = xm ; fa = fxm}                   
               x3 = (xa+xb)/2.0
               f3 = f(x3) ; iter+=1
           }
           xv = x3 ; fv = f3
           x3 = f1*f2*x3/((f3-f2)*(f3-f1)) + 
                f2*f3*x1/((f1-f2)*(f1-f3)) + 
                f3*f1*x2/((f2-f1)*(f2-f3))
           f3 = f(x3) ; iter+=1
           x1 = x2 ; f1 = f2
           x2 = xv ; f2 = fv
           println("x = "+x3+"  f(x) = "+ f3)
       }
    }
   (x3, iter)
  }
  }
}
