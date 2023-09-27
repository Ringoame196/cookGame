package com.github.Ringoame196.Data

import com.github.Ringoame196.Item
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

class RecipeData {
    fun foodList(): MutableList<ItemStack> {
        return mutableListOf(
            itemMake("うどん", 18),
            itemMake("${ChatColor.YELLOW}エビフライ", 14),
            itemMake("${ChatColor.GOLD}お子様ランチ", 25),
            itemMake("${ChatColor.YELLOW}オムライス", 5),
            itemMake("${ChatColor.AQUA}海鮮丼", 15),
            itemMake("${ChatColor.YELLOW}からあげ", 6),
            itemMake("${ChatColor.GOLD}カレーうどん", 19),
            itemMake("${ChatColor.GOLD}カレーライス", 2),
            itemMake("刺身", 10),
            itemMake("${ChatColor.GREEN}サラダ", 17),
            itemMake("${ChatColor.RED}ステーキ", 8),
            itemMake("${ChatColor.YELLOW}スパゲティー", 4),
            itemMake("${ChatColor.YELLOW}ドリア", 13),
            itemMake("${ChatColor.YELLOW}ハンバーガー", 21),
            itemMake("${ChatColor.YELLOW}ハンバーグ", 7),
            itemMake("${ChatColor.YELLOW}ピザ", 9),
            itemMake("${ChatColor.YELLOW}フライドポテト", 16)
        )
    }
    fun selectGUI(): Inventory {
        val gui = Bukkit.createInventory(null, 54, "${ChatColor.DARK_GREEN}レシピ")
        val foodList = foodList()
        for (item in foodList) {
            gui.addItem(item)
        }
        return gui
    }

    private fun itemMake(name: String, customeModelData: Int): ItemStack {
        return Item().make(Material.MUSHROOM_STEW, name, customeModelData)
    }
}
