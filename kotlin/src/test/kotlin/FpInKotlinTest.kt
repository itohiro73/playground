import org.junit.Assert.assertEquals
import org.junit.Test

class FpInKotlinTest {
    @Test fun formatTest() {
        assertEquals("The absolute value of -42 is 42", formatResult("absolute value", -42, abs))
        assertEquals("The factorial of 4 is 24", formatResult("factorial", 4, factorial))
        assertEquals("The fibonacci of 6 is 8", formatResult("fibonacci", 6, fib))
    }

    @Test fun functionTest() {
        val add: (a: Int, b: Int) -> Int = {a, b -> a + b}
        val addCurry: (a: Int) -> (b: Int) -> Int = {a -> {b -> a + b}}
        assertEquals(3, partial1(1, add)(2))
        assertEquals(3, curry(add)(1)(2))
        assertEquals(3, uncurry(addCurry)(1, 2))

        val hello: (s: String) -> String = {s -> "Hello " + s}
        val toUpper: (s: String) -> String = {s -> s.toUpperCase()}
        assertEquals("HELLO WORLD", compose(toUpper, hello)("World"))
    }
}