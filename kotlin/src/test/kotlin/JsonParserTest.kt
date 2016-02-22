import org.junit.Test
import org.junit.Assert.assertEquals

class JsonParserTest{
    @Test fun toJsonTest(){
        assertEquals("[1, 2, 3, 42, 555]", toJSON(listOf(1, 2, 3, 42, 555)))
    }
}