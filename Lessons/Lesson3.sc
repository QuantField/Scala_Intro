object Lesson3 {

val D:Map[String,Int] = Map("RED"->1,"GREEN"->2,"BLUE"->3)
                                                  //> D  : Map[String,Int] = Map(RED -> 1, GREEN -> 2, BLUE -> 3)

println(D("RED"))                                 //> 1

val E = D + ("YELLOW"->4) // adding and entry     //> E  : scala.collection.immutable.Map[String,Int] = Map(RED -> 1, GREEN -> 2, 
                                                  //| BLUE -> 3, YELLOW -> 4)



println(E("YELLOW"))                              //> 4

val P = D - "GREEN"   // removing an entry        //> P  : scala.collection.immutable.Map[String,Int] = Map(RED -> 1, BLUE -> 3)

 


var X = scala.collection.mutable.Map[String, Int]()
                                                  //> X  : scala.collection.mutable.Map[String,Int] = Map()


X += ("ORANGE"->7,"RED"->20)                      //> res0: scala.collection.mutable.Map[String,Int] = Map(RED -> 20, ORANGE -> 7)
                                                  //| 

X("RED")=10
println(X)                                        //> Map(RED -> 10, ORANGE -> 7)


}