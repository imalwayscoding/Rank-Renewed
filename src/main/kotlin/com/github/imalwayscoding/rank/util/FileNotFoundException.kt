package com.github.imalwayscoding.rank.util

class FileNotFoundException : Exception() {

    override fun printStackTrace() {
        super.printStackTrace()

        println("""
            com.github.imalwayscoding.rank.exception.FileNotFountException:
                message:
                    file is didn't found.
                    watch your code again.
        """)
    }

}