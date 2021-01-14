package com.github.imalwayscoding.rank.handlers

import com.github.imalwayscoding.rank.plugin.RankPlugin
import com.github.imalwayscoding.rank.util.Ranks
import org.bukkit.entity.Player

class PlayerHandler {

    companion object {
        @Suppress("deprecation")
        fun setRank(player: Player, rank: Ranks) {
            val team = RankPlugin.getScoreboard().getTeam(rank.toString().toLowerCase())

            team?.addPlayer(player)
        }
    }

}