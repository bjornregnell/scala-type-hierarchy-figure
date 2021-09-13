
def sh(xs: String*): Unit = 
  println(xs.mkString(" "))
  scala.sys.process.Process(xs).run

def dot(in: String, tpe: String = "pdf"): Unit =
  val i = 
    if in.endsWith(".dot") then in 
    else s"$in.dot"
  val o = 
    if in.endsWith(".dot") then in.stripSuffix(".dot") ++ s".$tpe" 
    else s"$in.$tpe"
  sh("dot", s"-T$tpe", i, "-o", o)

@main def run: Unit = 
  println("*** Building pdf from dot files. ***")
  for n <- Seq("simplified", "matchable") do
    dot(s"scala3-$n")
    dot(s"scala3-$n-null")