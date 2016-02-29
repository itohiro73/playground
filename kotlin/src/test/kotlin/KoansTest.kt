import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse
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

    @Test fun match1() {
        testMatch("03 JUL 1980")
    }

    @Test fun match2() {
        testMismatch("3 JUL 1980")
    }

    private fun testMatch(data: String) {
        assertTrue("The pattaern should match $data", data.matches(getPattern().toRegex()))
    }

    private fun testMismatch(data: String) {
        assertFalse("The pattaern should not match $data", data.matches(getPattern().toRegex()))
    }

    @Test fun testListOfPeople() {
        assertEquals("[Person(name=Alice, age=29), Person(name=Bob, age=31)]", getPeople().toString())
    }
}