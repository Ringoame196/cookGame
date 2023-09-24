package com.github.Ringoame196.Data

import com.github.Ringoame196.Item
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class CookingData {
    fun cut(itemStack: ItemStack): ItemStack? {
        return when (itemStack.itemMeta?.displayName) {
            "${ChatColor.RED}肉の塊" -> Item().make(Material.BEEF, "${ChatColor.RED}加工肉", null)
            "${ChatColor.AQUA}魚" -> Item().make(Material.COD, "刺身", 1)
            "${ChatColor.GOLD}人参" -> Item().make(Material.CARROT, "${ChatColor.GOLD}切った人参", 1)
            "${ChatColor.GOLD}切った人参" -> Item().make(Material.CARROT, "${ChatColor.GOLD}切りすぎた人参", 2)
            "${ChatColor.GOLD}じゃがいも" -> Item().make(Material.POTATO, "${ChatColor.GOLD}切ったじゃがいも", 1)
            "${ChatColor.GOLD}キャベツ" -> Item().make(Material.WHEAT, "${ChatColor.GOLD}千切りキャベツ", 2)
            "${ChatColor.AQUA}エビ" -> Item().make(Material.COD, "${ChatColor.AQUA}剥きエビ", 3)
            "${ChatColor.GOLD}たまねぎ" -> Item().make(Material.POTATO, "${ChatColor.GOLD}剥きたまねぎ", 3)
            else -> return null
        }
    }
    fun bake(itemStack: ItemStack): ItemStack? {
        return when (itemStack.itemMeta?.displayName) {
            "${ChatColor.RED}加工肉" -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}ステーキ", 7)
            else -> itemStack
        }
    }
}
