package com.github.imalwayscoding.rank.util

class DifferentRankFoundException : Exception() {

    override fun printStackTrace() {
        super.printStackTrace()

        println("""
            com.github.imalwayscoding.rank.util.DifferentRankFoundException:
                message:
                    Different Rank is Found At Player YAML File.
                    watch your code again.
        """)
    }

}