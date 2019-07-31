package com.minhaj.archnavviewpagerimpl

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)

        val words = hiAllArray()

        println("After calling Hi")

        for (word in words) {
            println(word)
        }

    }


    fun hi() = sequence { // this: SequenceScope<String>
        println("Before")
        yield("Hi")
        println("After Hi")
        yield(":))")
        println("After :)")
    }


    fun hiAll() = sequence { // this: SequenceScope<String>
        println("Before")
        yieldAll(sequence {
            yield("1")
            yield("2")
            yield("3")
        })
        println("After :)")
    }


    fun hiAllArray() = sequence { // this: SequenceScope<String>
        println("Before")
        yieldAll((3..12).toList())
        println("After :)")
    }




}
