package com.github.imalwayscoding.rank.event

import com.github.imalwayscoding.rank.handlers.FileHandler
import com.github.imalwayscoding.rank.handlers.PlayerHandler
import com.github.imalwayscoding.rank.plugin.RankPlugin
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerJoinEvent

class Event : Listener {

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        val player = event.player
        val rank = FileHandler.getRank(player)

        FileHandler.setup(player)

        PlayerHandler.setRank(player, rank)
        FileHandler.setRank(player, rank)
    }

    @EventHandler
    fun onChat(event: AsyncPlayerChatEvent) {
        val player = event.player
        val message = event.message
        val rank = FileHandler.getRank(player)

        event.format = "${rank.getPrefix()}${rank.getNameColor()}${player.name}${ChatColor.WHITE}: $message"
    }

}