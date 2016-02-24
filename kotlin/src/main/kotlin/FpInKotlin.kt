val fib: (n: Int) -> Int = {
    n ->
    fun loop(n: Int, prev: Int, cur: Int): Int {
        if (n == 0) return prev
        else return loop(n - 1, cur, prev + cur)
    }
    loop(n, 0, 1)
}

val factorial: (n: Int) -> Int = {
    n ->
    fun go(n: Int, acc: Int): Int {
        if (n <= 0) return acc
        else return go(n - 1, n * acc)
    }
    go(n, 1)
}


val abs: (n: Int) -> Int = {
    n ->
    if (n < 0) -n
    else n
}


fun formatResult(s: String, i: Int, f: (Int) -> Int): String {
    return "The " + s + " of " + i + " is " + f(i)
}