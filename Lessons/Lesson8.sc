// case classes
object Lesson8 {
  
  // in case class when we define the class name followed by the parameter, no need to
  // precede by val/var as they are automatically promoted to class members.
  // No need for the new keyword when we instantiate
  case class person(age : Int, weight : Int)
  val p = person(25, 75)                          //> p  : Lesson8.person = person(25,75)
  p.age                                           //> res0: Int = 25
  p.weight                                        //> res1: Int = 75
  
  // equals and hashcode methods are automatically generated
  
  val q = person(25,75)                           //> q  : Lesson8.person = person(25,75)
  val t = person(30, 80)                          //> t  : Lesson8.person = person(30,80)
  
  p == q                                          //> res2: Boolean = true
  p.equals(q)                                     //> res3: Boolean = true
  p equals q                                      //> res4: Boolean = true
  
  p==t                                            //> res5: Boolean = false
  
  
}