package com.github.imalwayscoding.rank.plugin

import com.github.imalwayscoding.rank.command.KommandRank
import com.github.imalwayscoding.rank.event.Event
import com.github.imalwayscoding.rank.util.Ranks
import com.github.noonmaru.kommand.kommand
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scoreboard.Scoreboard

class RankPlugin : JavaPlugin() {

    companion object {
        private lateinit var scoreboard: Scoreboard


        fun getScoreboard(): Scoreboard {
            return scoreboard
        }
    }

    override fun onEnable() {
        logger.info("[Rank] Loading Scoreboard..")
        scoreboard = Bukkit.getScoreboardManager().mainScoreboard
        logger.info("[Rank] Ok..")
        logger.info("[Rank] Loading Events..")
        Bukkit.getPluginManager().registerEvents(Event(), this)
        logger.info("[Rank] Ok..")
        logger.info("[Rank] Loading Commands..")
        registerCommands()
        logger.info("[Rank] Ok..")
        logger.info("[Rank] Success to Load ALL.")
    }

    override fun onDisable() {
        logger.info("[Rank] Bye!")
    }

    private fun registerTeam() {
        if (scoreboard.getTeam("owner") != null) {
            scoreboard.getTeam("owner")?.unregister()
        }
        if (scoreboard.getTeam("admin") != null) {
            scoreboard.getTeam("admin")?.unregister()
        }
        if (scoreboard.getTeam("friend") != null) {
            scoreboard.getTeam("friend")?.unregister()
        }
        if (scoreboard.getTeam("default") != null) {
            scoreboard.getTeam("default")?.unregister()
        }

        val owner = scoreboard.registerNewTeam("owner")
        val admin = scoreboard.registerNewTeam("admin")
        val friend = scoreboard.registerNewTeam("friend")
        val default = scoreboard.registerNewTeam("default")

        owner.color = Ranks.OWNER.getNameColor()
        owner.prefix = Ranks.OWNER.getPrefix()

        admin.color = Ranks.ADMIN.getNameColor()
        admin.prefix = Ranks.ADMIN.getPrefix()

        friend.color = Ranks.FRIEND.getNameColor()
        friend.prefix = Ranks.FRIEND.getPrefix()

        default.color = Ranks.DEFAULT.getNameColor()
        default.prefix = Ranks.DEFAULT.getPrefix()
    }

    private fun registerCommands() = kommand {
        register("rank") {
            KommandRank.register(this)
        }
    }
}