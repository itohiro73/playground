import org.junit.Assert.assertEquals
import org.junit.Test

class KoansTest {
    @Test fun helloTest() {
        assertEquals("Hello", hello())
    }

    @Test fun toJsonTest() {
        assertEquals("[1, 2, 3, 42, 555]", toJSON(listOf(1, 2, 3, 42, 555)))
    }

    @Test fun joinToStringTest() {
        assertEquals("[one, two, three]", joinToString(listOf("one", "two", "three")))
    }
}