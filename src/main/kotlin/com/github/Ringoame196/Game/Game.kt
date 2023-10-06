package com.github.Ringoame196.Game

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Item
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Game {
    fun settingGUI(player: Player) {
        val gui = Bukkit.createInventory(null, 18, "${ChatColor.GREEN}ゲーム設定")
        gui.setItem(0, com.github.Ringoame196.Item().make(Material.EMERALD_BLOCK, "${ChatColor.GREEN}スタート", null))
        gui.setItem(1, com.github.Ringoame196.Item().make(Material.COMPASS, "${ChatColor.GREEN}座標", null))
        player.openInventory(gui)
    }
    fun clickSettingGUI(player: Player, item: ItemStack) {
        when (item.itemMeta?.displayName) {
            "${ChatColor.GREEN}座標" -> {
            }
        }
    }
}
