fun hello(): String = "Hello"

fun toJSON(collection : Collection<Int>) : String {
    val sb = StringBuilder()
    sb.append("[")
    val iterator = collection.iterator()
    while(iterator.hasNext()){
        val element = iterator.next()
        sb.append(element)
        if(iterator.hasNext()){
            sb.append(", ")
        }
    }
    sb.append("]")
    return sb.toString()
}

fun joinToString(collection : Collection<String>)
    = collection.joinToString(prefix = "[", postfix = "]")

val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

fun getPattern(): String {
    return """\d{2} ${month} \d{4}"""
}