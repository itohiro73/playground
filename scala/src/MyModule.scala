object MyModule {

  def fib(n: Int): Int = {
    @annotation.tailrec
    def loop(n: Int, prev: Int, cur: Int): Int = {
      if(n==0) prev
      else loop(n-1, cur, prev + cur)
    }
    loop(n, 0, 1)
  }

  def factorial(n: Int): Int = {
    def go(n: Int, acc: Int): Int = {
      if(n <= 0) acc
      else go(n-1, n*acc)
    }

    go(n, 1)
  }

  def abs(n: Int): Int =
    if (n < 0) -n
    else n

  def formatResult(s: String, i: Int, func: (Int) => Int): String = {
    val msg = "The %s of %d is %d"
    msg.format(s, i, func(i))
  }

  def main(args: Array[String]): Unit =
    println(formatResult("absolute value", -42, abs))
    println(formatResult("factorial", 7, factorial))
}
