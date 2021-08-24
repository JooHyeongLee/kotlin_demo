import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val a = async {
        6
    }

    val b = async {
        7
    }

//    Main().hashMapTest();
    Main().parserTest();
}
