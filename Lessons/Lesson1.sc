object Lesson1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val myvalue =3                                  //> myvalue  : Int = 3
  
  myvalue match{
    case 1 => "One"
    case 2 => "Two"
    case _ => "Nothing"
  }                                               //> res0: String = Nothing
  
  
  myvalue match {
  
   case value  if value<=3 => "Less than three"
   case value  if value==2 => "Two"
   case _  => "Rien"
}                                                 //> res1: String = Less than three
}