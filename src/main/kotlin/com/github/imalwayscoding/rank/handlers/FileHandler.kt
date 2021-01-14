package com.github.imalwayscoding.rank.handlers

import com.github.imalwayscoding.rank.util.DifferentRankFoundException
import com.github.imalwayscoding.rank.util.FileNotFoundException
import com.github.imalwayscoding.rank.util.Ranks
import org.bukkit.Bukkit
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player
import java.io.File
import java.io.IOException

class FileHandler {

    companion object {
        fun setup(player: Player) {
            val file = File(Bukkit.getPluginManager().getPlugin("Rank")?.dataFolder, "${player.uniqueId}.yml")
            val config = YamlConfiguration.loadConfiguration(file)

            if (!file.exists()) {
                try {
                    file.createNewFile()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                config.addDefault("Name", player.name)
                config.addDefault("Rank", Ranks.DEFAULT.getId())

                try {
                    config.save(file)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }

        fun getRank(player: Player): Ranks {
            val file = File(Bukkit.getPluginManager().getPlugin("Rank")?.dataFolder, "${player.uniqueId}.yml")
            val config = YamlConfiguration.loadConfiguration(file)

            if (!file.exists()) {
                throw FileNotFoundException()
            }

            return when(config.get("Rank")) {
                Ranks.OWNER.getId() -> Ranks.OWNER
                Ranks.ADMIN.getId() -> Ranks.ADMIN
                Ranks.FRIEND.getId() -> Ranks.FRIEND
                Ranks.DEFAULT.getId() -> Ranks.DEFAULT
                else -> throw DifferentRankFoundException()
            }
        }

        fun setRank(player: Player, rank: Ranks) {
            val file = File(Bukkit.getPluginManager().getPlugin("Rank")?.dataFolder, "${player.uniqueId}.yml")
            val config = YamlConfiguration.loadConfiguration(file)

            config.set("Rank", rank.getId())

            try {
                config.save(file)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        fun updateName(player: Player) {
            val file = File(Bukkit.getPluginManager().getPlugin("Rank")?.dataFolder, "${player.uniqueId}.yml")
            val config = YamlConfiguration.loadConfiguration(file)

            if (config.getString("Name") != player.name) {
                config.set("Name", player.name)

                try {
                    config.save(file)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }

}