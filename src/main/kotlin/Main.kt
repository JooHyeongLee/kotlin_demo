import kotlinx.coroutines.*
import java.util.concurrent.Future

fun main() = runBlocking<Unit> {

    val t1 = async {
        Main().parserTest()
    }
    t1.await()
   // Main().hashMapTest();
}
