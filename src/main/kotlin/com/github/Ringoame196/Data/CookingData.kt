package com.github.Ringoame196.Data

import com.github.Ringoame196.Item
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class CookingData {
    fun cut(itemStack: ItemStack): ItemStack? {
        return when (itemStack.itemMeta?.displayName) {
            "${ChatColor.RED}肉の塊" -> Item().make(Material.BEEF, "${ChatColor.RED}加工肉", null)
            "${ChatColor.AQUA}魚" -> Item().make(Material.MUSHROOM_STEW, "刺身", 10)
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
            "${ChatColor.RED}加工肉" -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}ステーキ", 8)
            "卵" -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}オムレツ", 5)
            "${ChatColor.RED}生ハンバーグ" -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}ハンバーグ", 7)
            "小麦" -> Item().make(Material.BREAD, "${ChatColor.GREEN}バンズ", 1)
            "${ChatColor.RED}生ピザ" -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}ピザ", 9)
            "${ChatColor.RED}生ドリア" -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}ドリア", 13)
            else -> null
        }
    }
    fun dressing(itemStack: ItemStack): ItemStack? {
        return when (itemStack.itemMeta?.displayName) {
            "${ChatColor.AQUA}剥きエビ" -> Item().make(Material.COD, "${ChatColor.AQUA}衣付きエビ", 4)
            "${ChatColor.RED}加工肉" -> Item().make(Material.BEEF, "${ChatColor.RED}生からあげ", 3)
            else -> null
        }
    }
    fun fly(itemStack: ItemStack): ItemStack? {
        val item = when (itemStack.itemMeta?.displayName) {
            "${ChatColor.AQUA}衣付きエビ" -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}エビフライ", 14)
            "${ChatColor.RED}生からあげ" -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}からあげ", 6)
            else -> null
        }
        item?.amount = 1
        return item
    }
    fun mix(ingredients: MutableList<String>): ItemStack? {
        val milk = mutableListOf<String>("牛乳")
        val omeletteRice = mutableListOf<String>("${ChatColor.YELLOW}オムレツ", "ライス")
        val curryRice = mutableListOf<String>("${ChatColor.GOLD}カレー", "ライス")
        val hamburg = mutableListOf<String>("${ChatColor.RED}加工肉", "${ChatColor.GOLD}剥きたまねぎ")
        val noodles = mutableListOf<String>("${ChatColor.GREEN}小麦", "${ChatColor.AQUA}水")
        val spaghetti = mutableListOf<String>("茹で麺", "${ChatColor.RED}加工肉", "${ChatColor.GOLD}スパイス")
        val seafood = mutableListOf<String>("${ChatColor.AQUA}剥きエビ", "ライス", "${ChatColor.AQUA}刺身")
        val material = mutableListOf<String>("卵", "${ChatColor.GREEN}小麦", "${ChatColor.AQUA}水")
        val pizza = mutableListOf<String>("${ChatColor.YELLOW}生地", "${ChatColor.YELLOW}チーズ", "${ChatColor.RED}加工肉")
        val doria = mutableListOf<String>("${ChatColor.GREEN}小麦", "牛乳", "ライス")
        val salad = mutableListOf<String>("${ChatColor.GOLD}切ったじゃがいも", "${ChatColor.GOLD}切りすぎた人参", "${ChatColor.GOLD}千切りキャベツ")
        val curryUdon = mutableListOf<String>("${ChatColor.GOLD}カレー", "うどん")
        val hamburger = mutableListOf<String>("${ChatColor.YELLOW}チーズ", "${ChatColor.YELLOW}パン", "${ChatColor.YELLOW}ハンバーグ")
        return when (ingredients.toSet()) {
            milk.toSet() -> Item().make(Material.APPLE, "${ChatColor.YELLOW}チーズ", 1)
            omeletteRice.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}オムライス", 1)
            curryRice.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}カレーライス", 2)
            hamburg.toSet() -> Item().make(Material.BEEF, "${ChatColor.RED}生ハンバーグ", 2)
            noodles.toSet() -> Item().make(Material.WHEAT, "生麺", 4)
            spaghetti.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}スパゲッティ", 4)
            seafood.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.AQUA}海鮮丼", 15)
            material.toSet() -> Item().make(Material.WHEAT, "${ChatColor.YELLOW}生地", 6)
            pizza.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}生ピザ", 11)
            doria.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}生ドリア", 12)
            salad.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.GREEN}サラダ", 17)
            curryUdon.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}カレーうどん", 19)
            hamburger.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}ハンバーガー", 21)
            else -> null
        }
    }
}
