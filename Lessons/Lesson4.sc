/*
Setter and getter.. in other word a property
*/


object Lesson4 {
    
  class Car {
     var color = "Blue"
  }
  // The setter and getter are
  // color_ and color, are created by default
  val polo = new Car                              //> polo  : Lesson4.Car = Lesson4$Car@709a6e58
  polo.color                                      //> res0: String = Blue
  polo.color = "Red"
  polo.color                                      //> res1: String = Red
  
  // if we want to override the default setter and getter
  class Car2 {
     private var thecolor = "Blue"
     
     def color_=(col : String) {
       if (col.trim.toUpperCase()!="WHITE") this.thecolor = col
       else println("White color is not allowed")
     }
     
     def color = thecolor
     
     def printColor( obj:Car2){
       println(obj.thecolor)
     }
     
  }
  
  val quo = new Car2                              //> quo  : Lesson4.Car2 = Lesson4$$anonfun$main$1$Car2$1@5298db1f
  quo.color="White"                               //> White color is not allowed
  
  /*
  For every field scala creates a property(meaning setter and getter), it is private if the field is private
  and public if the field is public.
  If we want scala not to create them declare with private[this].. in this cas even another object from the same
  class won't have access. This is called object-private field
  */
  class privateCar {
     private[this] var thecolor = "Blue"
     
     def color_=(col : String) {
       if (col.trim.toUpperCase()!="WHITE") this.thecolor = col
       else println("White color is not allowed")
     }
     
     def color = thecolor
     
     /*  error because thecolor is not visible to any other privateCar object
     def printColor( obj:privateCar){
       println(obj.thecolor)
     }
     */
  }
  
  
  
  
  
  
  
  
  
  
}