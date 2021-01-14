package com.github.imalwayscoding.rank.command

import com.github.noonmaru.kommand.KommandBuilder
import com.github.noonmaru.kommand.argument.player
import org.bukkit.entity.Player

object KommandRank {

    fun register(builder: KommandBuilder) {
        builder.apply {
            then("target" to player()) {
                then("owner") {
                    executes {
                        require { this is Player }
                        val player = it.sender as Player


                    }
                }
                then("admin") {
                    executes {
                        require { this is Player }
                        val player = it.sender as Player


                    }
                }
                then("friend") {
                    executes {
                        require { this is Player }
                        val player = it.sender as Player


                    }
                }
                then("default") {
                    executes {
                        require { this is Player }
                        val player = it.sender as Player


                    }
                }
            }
        }
    }

}