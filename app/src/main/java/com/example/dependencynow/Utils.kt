package com.example.dependencynow

import android.util.Log
import com.example.dependencynow.database.model.Person

const val TXT =
    "Bùi Nguyễn Thanh Đình X 20/08/200202 Phan Nguyễn Huy Hoàng X 01/11/200203 Trần Minh Hùng X 12/12/200204 Nguyễn Hữu Đăng Khoa X 17/09/200205 Trần Thị Mỹ Linh X 29/12/200206 Nguyễn Gia Lượng X 23/11/200207 Võ Hoàng Minh X 14/09/200208 Vương Công Thắng X 03/08/200209 Hoàng Thanh Thiên X 14/04/200210 Nguyễn Thuỳ Trâm X 04/10/200211 Thi Huỳnh Ngọc Trâm X 15/10/200212 Lê Thị Thảo Vân X 06/06/200213 Phạm Thị Tường Vy X 24/04/200214 Đoàn Quốc Bảo X 10/11/200215 Trần Nguyễn Kim Chi X 02/08/200216 Võ Duy Chương X 11/03/200217 Lâm Quang Duy X 26/04/200218 Phạm Thu Hiền X 11/11/200219 Nguyễn Hữu Hoàng X 09/03/200220 Trần Quốc Khánh X 11/09/200221 Trương Thị Ny Na X 17/10/200222 Nguyễn Quảng Nam X 23/08/200"

class Utils {


    companion object {
        val txts: List<String>
            get() = TXT.devideTxt()

        fun randomPerson(): Person {

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
            while (index < TXT.length) {
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
