package com.github.Ringoame196.Data

import com.github.Ringoame196.Item
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class CookingData {
    fun cut(itemStack: ItemStack): ItemStack? {
        return when (itemStack.itemMeta?.displayName) {
            "${ChatColor.RED}肉の塊" -> Item().make(Material.BEEF, "${ChatColor.RED}加工肉", null)
            "${ChatColor.RED}マグロ" -> Item().make(Material.COD, "${ChatColor.RED}マグロの切り身", 7)
            "${ChatColor.GOLD}サーモン" -> Item().make(Material.COD, "${ChatColor.GOLD}サーモンの切り身", 8)
            "イカ" -> Item().make(Material.COD, "イカの切り身", 10)
            "${ChatColor.RED}タコ" -> Item().make(Material.COD, "${ChatColor.RED}切ったタコ", 13)
            "${ChatColor.GOLD}人参" -> Item().make(Material.CARROT, "${ChatColor.GOLD}切った人参", 1)
            "${ChatColor.GOLD}切った人参" -> Item().make(Material.CARROT, "${ChatColor.GOLD}切りすぎた人参", 2)
            "${ChatColor.GOLD}じゃがいも" -> Item().make(Material.POTATO, "${ChatColor.GOLD}切ったじゃがいも", 1)
            "${ChatColor.GOLD}キャベツ" -> Item().make(Material.WHEAT, "${ChatColor.GOLD}千切りキャベツ", 2)
            "${ChatColor.AQUA}エビ" -> Item().make(Material.COD, "${ChatColor.AQUA}剥きエビ", 3)
            "${ChatColor.GOLD}たまねぎ" -> Item().make(Material.POTATO, "${ChatColor.GOLD}剥きたまねぎ", 3)
            "${ChatColor.YELLOW}生生地" -> Item().make(Material.WHEAT, "生麺", 4)
            "${ChatColor.RED}鶏肉の塊" -> Item().make(Material.BEEF, "${ChatColor.RED}加工鶏肉", 7)
            "${ChatColor.RED}加工肉" -> Item().make(Material.BEEF, "${ChatColor.RED}細かく切った加工肉", 4)
            "${ChatColor.GREEN}キュウリ" -> Item().make(Material.POTATO, "${ChatColor.GREEN}切ったキュウリ", 6)
            "${ChatColor.DARK_PURPLE}なす" -> Item().make(Material.POTATO, "${ChatColor.DARK_PURPLE}切ったなす", 8)
            else -> return null
        }
    }
    fun bake(itemStack: ItemStack): ItemStack? {
        return when (itemStack.itemMeta?.displayName) {
            "${ChatColor.RED}加工肉" -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}ステーキ", 8)
            "卵" -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}オムレツ", 5)
            "${ChatColor.RED}生ハンバーグ" -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}ハンバーグ", 7)
            "${ChatColor.YELLOW}生バンズ" -> Item().make(Material.WHEAT, "${ChatColor.YELLOW}バンズ", 8)
            "${ChatColor.RED}生ピザ" -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}ピザ", 9)
            "${ChatColor.RED}生ドリア" -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}ドリア", 13)
            "海苔" -> Item().make(Material.COD, "${ChatColor.BLACK}焼海苔", 16)
            "${ChatColor.RED}細かく切った加工肉" -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}サイコロステーキ", 35)
            else -> null
        }
    }
    fun dressing(itemStack: ItemStack): ItemStack? {
        return when (itemStack.itemMeta?.displayName) {
            "${ChatColor.AQUA}剥きエビ" -> Item().make(Material.COD, "${ChatColor.AQUA}衣付きエビ", 4)
            "${ChatColor.RED}加工鶏肉" -> Item().make(Material.BEEF, "${ChatColor.RED}生からあげ", 3)
            else -> null
        }
    }
    fun fly(itemStack: ItemStack): ItemStack? {
        val item = when (itemStack.itemMeta?.displayName) {
            "${ChatColor.AQUA}衣付きエビ" -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}エビフライ", 14)
            "${ChatColor.RED}生からあげ" -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}からあげ", 6)
            "${ChatColor.GOLD}切ったじゃがいも" -> Item().make(Material.MUSHROOM_STEW, "フライドポテト", 16)
            else -> null
        }
        item?.amount = 1
        return item
    }
    fun mix(ingredients: MutableList<String>): ItemStack? {
        val milk = mutableListOf("牛乳")
        val omeletteRice = mutableListOf("${ChatColor.YELLOW}オムレツ", "ライス")
        val curryRice = mutableListOf("${ChatColor.GOLD}カレー", "ライス")
        val hamburg = mutableListOf("${ChatColor.RED}加工肉", "${ChatColor.GOLD}剥きたまねぎ")
        val spaghetti = mutableListOf("茹で麺", "${ChatColor.RED}加工肉", "${ChatColor.GOLD}スパイス")
        val seafood = mutableListOf("${ChatColor.AQUA}剥きエビ", "ライス", "${ChatColor.RED}マグロの切り身", "${ChatColor.GOLD}サーモンの切り身")
        val material = mutableListOf("卵", "${ChatColor.GREEN}小麦", "${ChatColor.AQUA}水")
        val pizza = mutableListOf("${ChatColor.YELLOW}生生地", "${ChatColor.YELLOW}チーズ", "${ChatColor.RED}加工肉", "${ChatColor.RED}トマトペースト")
        val doria = mutableListOf("${ChatColor.GREEN}小麦", "牛乳", "ライス")
        val salad = mutableListOf("${ChatColor.GOLD}切りすぎた人参", "${ChatColor.GOLD}千切りキャベツ", "${ChatColor.GREEN}切ったキュウリ")
        val curryUdon = mutableListOf("${ChatColor.GOLD}カレー", "うどん")
        val hamburger = mutableListOf("${ChatColor.YELLOW}チーズ", "${ChatColor.YELLOW}バンズ", "${ChatColor.YELLOW}ハンバーグ")
        val kidsLnch = mutableListOf("${ChatColor.YELLOW}オムライス", "${ChatColor.YELLOW}スパゲッティ", "${ChatColor.GOLD}カレーライス", "${ChatColor.YELLOW}ハンバーグ", "${ChatColor.YELLOW}エビフライ")
        val shari = mutableListOf("ライス", "${ChatColor.GOLD}お酢")
        val nigiriOfTuna = mutableListOf("シャリ", "${ChatColor.RED}マグロの切り身")
        val nigiriOfSalmon = mutableListOf("シャリ", "${ChatColor.GOLD}サーモンの切り身")
        val nigiriOfSquid = mutableListOf("シャリ", "イカの切り身")
        val nigiriOfOctopus = mutableListOf("シャリ", "${ChatColor.RED}切ったタコ")
        val assortedSashimi = mutableListOf("${ChatColor.RED}切ったタコ", "${ChatColor.RED}マグロの切り身", "${ChatColor.GOLD}サーモンの切り身", "イカの切り身", "${ChatColor.AQUA}剥きエビ")
        val rawBuns = mutableListOf("${ChatColor.YELLOW}生生地", "${ChatColor.GOLD}バンズの型")
        val tekkamaki = mutableListOf("シャリ", "${ChatColor.RED}マグロの切り身", "${ChatColor.BLACK}焼海苔")
        val salmonNigiri = mutableListOf("${ChatColor.GOLD}サーモンの切り身", "ライス", "${ChatColor.BLACK}焼海苔")
        val cutTomato = mutableListOf("${ChatColor.RED}トマト")
        return when (ingredients.toSet()) {
            milk.toSet() -> Item().make(Material.APPLE, "${ChatColor.YELLOW}チーズ", 1)
            omeletteRice.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}オムライス", 1)
            curryRice.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}カレーライス", 2)
            hamburg.toSet() -> Item().make(Material.BEEF, "${ChatColor.RED}生ハンバーグ", 2)
            spaghetti.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}スパゲッティ", 4)
            seafood.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.AQUA}海鮮丼", 15)
            material.toSet() -> Item().make(Material.WHEAT, "${ChatColor.YELLOW}生生地", 6)
            pizza.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}生ピザ", 11)
            doria.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}生ドリア", 12)
            salad.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.GREEN}サラダ", 17)
            curryUdon.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}カレーうどん", 19)
            hamburger.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}ハンバーガー", 21)
            kidsLnch.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}お子様ランチ", 25)
            assortedSashimi.toSet() -> Item().make(Material.MUSHROOM_STEW, "刺身の盛り合わせ", 10)
            shari.toSet() -> Item().make(Material.COD, "シャリ", 15)
            nigiriOfTuna.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}マグロの握り", 29)
            nigiriOfSalmon.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}サーモンの握り", 30)
            nigiriOfSquid.toSet() -> Item().make(Material.MUSHROOM_STEW, "イカの握り", 31)
            nigiriOfOctopus.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}タコの握り", 32)
            rawBuns.toSet() -> Item().make(Material.WHEAT, "${ChatColor.YELLOW}生バンズ", 7)
            tekkamaki.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}鉄火巻", 34)
            salmonNigiri.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}サーモンのおにぎり", 36)
            cutTomato.toSet() -> Item().make(Material.POTATO, "${ChatColor.RED}トマトペースト", 9)
            else -> null
        }
    }
    fun pot(ingredients: MutableList<String>): ItemStack? {
        val noodles = mutableListOf<String>("生麺")
        val rice = mutableListOf<String>("稲")
        val curry = mutableListOf<String>("${ChatColor.GOLD}スパイス", "${ChatColor.GOLD}切った人参", "${ChatColor.GOLD}切ったじゃがいも", "${ChatColor.RED}加工肉", "${ChatColor.GOLD}剥きたまねぎ")
        val udon = mutableListOf<String>("茹で麺", "${ChatColor.GOLD}スパイス")
        return when (ingredients.toSet()) {
            noodles.toSet() -> Item().make(Material.WHEAT, "茹で麺", 5)
            rice.toSet() -> Item().make(Material.MUSHROOM_STEW, "ライス", 3)
            curry.toSet() -> Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}カレー", 27)
            udon.toSet() -> Item().make(Material.MUSHROOM_STEW, "うどん", 18)
            else -> null
        }
    }
}
