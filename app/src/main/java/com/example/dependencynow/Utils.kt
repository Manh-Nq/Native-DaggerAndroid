package com.example.dependencynow

import android.util.Log
import androidx.core.content.ContextCompat
import com.example.dependencynow.database.model.Person

class Utils {


    companion object {


        fun randomPerson(txts: List<String>): Person {

            val age = (20..30).random()
            val name = txts[(txts.indices).random()]
            return Person(
                age = age, name = name
            )
        }

        fun String.devideTxt(): List<String> {
            var index = 0
            var txts = mutableListOf<String>()
            var lastIndex = 0
            while (index < this.length) {
                if (this[index].toString() == "X") {
                    val txt = if (lastIndex > 0) {
                        this.substring(lastIndex + "X 20/08/200202 ".length, index)
                    } else {
                        this.substring(lastIndex, index)
                    }

                    lastIndex = index
                    txts.add(txt)
                }
                index++
            }
            return txts
        }
    }
}
