package com.example.kyros.mediumandroidtutorials

import com.example.kyros.mediumandroidtutorials.part1.step1.BinaryGame1
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun printBinaryMessage() {
        val binaryGame = BinaryGame1()
        binaryGame.message.let {
            println(it)
            assertEquals(BinaryGame1.MESSAGE_LENGTH, it.length)
        }
    }
}
