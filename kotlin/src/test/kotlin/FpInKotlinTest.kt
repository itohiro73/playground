import org.junit.Assert.assertEquals
import org.junit.Test

class FpInKotlinTest {
    @Test fun formatTest() {
        assertEquals("The absolute value of -42 is 42", formatResult("absolute value", -42, abs))
        assertEquals("The factorial of 4 is 24", formatResult("factorial", 4, factorial))
        assertEquals("The fibonacci of 6 is 8", formatResult("fibonacci", 6, fib))
    }
}