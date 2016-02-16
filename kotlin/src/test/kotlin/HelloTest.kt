import org.junit.Assert.assertEquals
import org.junit.Test

class HelloTest {
    @Test fun helloTest() {
        assertEquals("Hello", hello())
    }

    private fun hello(): String? = "Hello"
}