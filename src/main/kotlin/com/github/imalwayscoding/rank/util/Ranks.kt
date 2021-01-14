package com.github.imalwayscoding.rank.util

import org.bukkit.ChatColor

enum class Ranks (prefix: String, nameColor: ChatColor, id: Int) {

    OWNER("${ChatColor.RED}[OWNER] ", ChatColor.RED, 3),
    ADMIN("${ChatColor.RED}[ADMIN] ", ChatColor.RED, 2),
    FRIEND("${ChatColor.YELLOW}[FRIEND] ", ChatColor.YELLOW, 1),
    DEFAULT("${ChatColor.BLUE}[DEFAULT] ", ChatColor.BLUE, 0);

    private var prefix = ""
    private var nameColor = ChatColor.RESET
    private var id = -1

    init {
        this.prefix = prefix
        this.nameColor = nameColor
        this.id = id
    }

    fun getPrefix(): String {
        return prefix
    }

    fun getNameColor(): ChatColor {
        return nameColor
    }

    fun getId(): Int {
        return id
    }
}