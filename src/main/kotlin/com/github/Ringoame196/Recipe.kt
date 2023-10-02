package com.github.Ringoame196

import com.github.Ringoame196.Data.RecipeData
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Recipe {
    fun select(item: ItemStack, player: Player) {
        val gui = Bukkit.createInventory(null, 9, "${ChatColor.RED}レシピ")
        RecipeData().quote(item.itemMeta?.displayName ?: return, gui) ?: return
        player.openInventory(gui)
    }
}
