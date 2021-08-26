import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {

    val pre = async {
        Main().parserTest()
    }


    pre.await()
//    Main().hashMapTest();

}
