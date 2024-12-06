import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readText

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/$name.txt").readText().trim().lines()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)

fun <T> checkAnswer(expected: T, actual: T, part: Int) {
    if (expected == actual) {
        println("✅✨ correct. part$part output = $actual ✨✅")
    } else {
        println("🚨🚫 WRONG! part$part output = $actual 🚫🚨")
    }
}
