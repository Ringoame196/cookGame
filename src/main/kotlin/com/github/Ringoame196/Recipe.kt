package com.github.Ringoame196

import com.github.Ringoame196.Data.RecipeData
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Recipe {
    fun select(item: ItemStack, player: Player) {
        if (item.itemMeta?.displayName == "${ChatColor.GREEN}料理一覧") {
            player.openInventory(RecipeData().selectGUI())
            return
        }
        val openGUI = player.openInventory
        val beforeItem = if (openGUI.title == "${ChatColor.RED}レシピ" && openGUI.topInventory.size == 18) {
            openGUI.topInventory.getItem(13)
        } else { Item().make(Material.BARRIER, " ", null) }
        if (beforeItem == item) { return }
        val gui = Bukkit.createInventory(null, 18, "${ChatColor.RED}レシピ")
        RecipeData().quote(item.itemMeta?.displayName ?: return, gui) ?: return
        gui.setItem(9, Item().make(Material.EMERALD, "${ChatColor.GREEN}料理一覧", null))
        gui.setItem(10, Item().make(Material.PAPER, "→", 1))
        gui.setItem(11, beforeItem)
        gui.setItem(12, Item().make(Material.PAPER, "→", 1))
        gui.setItem(13, item)
        player.openInventory(gui)
    }
}
