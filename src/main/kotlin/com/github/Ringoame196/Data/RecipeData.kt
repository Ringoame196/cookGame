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
            itemMake("${ChatColor.YELLOW}オムライス", 1),
            itemMake("${ChatColor.AQUA}海鮮丼", 15),
            itemMake("${ChatColor.YELLOW}からあげ", 6),
            itemMake("${ChatColor.GOLD}カレーうどん", 19),
            itemMake("${ChatColor.GOLD}カレーライス", 2),
            itemMake("刺身の盛り合わせ", 10),
            itemMake("${ChatColor.GREEN}サラダ", 17),
            itemMake("${ChatColor.RED}ステーキ", 8),
            itemMake("${ChatColor.YELLOW}スパゲッティー", 4),
            itemMake("${ChatColor.YELLOW}ドリア", 13),
            itemMake("${ChatColor.YELLOW}ハンバーガー", 21),
            itemMake("${ChatColor.YELLOW}ハンバーグ", 7),
            itemMake("${ChatColor.YELLOW}ピザ", 9),
            itemMake("${ChatColor.YELLOW}フライドポテト", 16),
            itemMake("${ChatColor.RED}マグロの握り", 29),
            itemMake("${ChatColor.GOLD}サーモンの握り", 30),
            itemMake("イカの握り", 31),
            itemMake("${ChatColor.RED}タコの握り", 32),
        )
    }

    fun selectGUI(): Inventory {
        val gui = Bukkit.createInventory(null, 54, "${ChatColor.RED}レシピ")
        val foodList = foodList()
        for (item in foodList) {
            gui.addItem(item)
        }
        return gui
    }

    private fun itemMake(name: String, customeModelData: Int): ItemStack {
        return Item().make(Material.MUSHROOM_STEW, name, customeModelData)
    }

    fun quote(name: String, inventory: Inventory): Inventory? {
        when (name) {
            "うどん" -> udon(inventory)
            "茹で麺" -> boiledNoodles(inventory)
            "生麺" -> rawNoodles(inventory)
            "${ChatColor.YELLOW}エビフライ" -> friedShrimp(inventory)
            "${ChatColor.AQUA}衣付きエビ" -> clothesShrimp(inventory)
            "${ChatColor.AQUA}剥きエビ" -> cutShrimp(inventory)
            "${ChatColor.GOLD}お子様ランチ" -> kidsLunch(inventory)
            "${ChatColor.YELLOW}オムライス" -> omeletteRice(inventory)
            "ライス" -> rice(inventory)
            "${ChatColor.YELLOW}オムレツ" -> omelette(inventory)
            "${ChatColor.AQUA}海鮮丼" -> seafoodrice(inventory)
            "${ChatColor.RED}マグロの刺身" -> cuttuna(inventory)
            "${ChatColor.GOLD}サーモンの刺身" -> cutsalmon(inventory)
            "${ChatColor.YELLOW}からあげ" -> friedChicken(inventory)
            "${ChatColor.RED}生からあげ" -> rawFriedChicken(inventory)
            "${ChatColor.RED}加工肉" -> cutBeef(inventory)
            "${ChatColor.GOLD}カレー" -> curry(inventory)
            "${ChatColor.GOLD}切ったにんじん" -> cutCarrot(inventory)
            "${ChatColor.GOLD}切ったじゃがいも" -> cutPtato(inventory)
            "${ChatColor.GOLD}剥きたまねぎ" -> cutOnion(inventory)
            "${ChatColor.GOLD}カレーうどん" -> curryUdon(inventory)
            "${ChatColor.GOLD}カレーライス" -> curryRice(inventory)
            "刺身の盛り合わせ" -> sashimi(inventory)
            "${ChatColor.RED}切ったタコ" -> cutOctopus(inventory)
            "${ChatColor.GREEN}サラダ" -> salad(inventory)
            "${ChatColor.GOLD}切りすぎたにんじん" -> veryCutCarrot(inventory)
            "${ChatColor.GOLD}千切りキャベツ" -> catCabbage(inventory)
            "${ChatColor.RED}ステーキ" -> steak(inventory)
            "${ChatColor.YELLOW}スパゲッティー" -> spaghetti(inventory)
            "${ChatColor.YELLOW}ドリア" -> doria(inventory)
            "${ChatColor.RED}生ドリア" -> rawDoria(inventory)
            "${ChatColor.YELLOW}ハンバーグ" -> hamburg(inventory)
            "${ChatColor.RED}生ハンバーグ" -> rawHamburg(inventory)
            "${ChatColor.YELLOW}バンズ" -> bread(inventory)
            "${ChatColor.YELLOW}ハンバーガー" -> hamburger(inventory)
            "${ChatColor.YELLOW}チーズ" -> cheese(inventory)
            "${ChatColor.YELLOW}フライドポテト" -> flyPotato(inventory)
            "${ChatColor.YELLOW}ピザ" -> pizza(inventory)
            "${ChatColor.RED}生ピザ" -> rawPizza(inventory)
            "${ChatColor.YELLOW}生生地" -> material(inventory)
            "${ChatColor.RED}加工鶏肉" -> catchickenMeat(inventory)
            "${ChatColor.RED}マグロの握り" -> nigiriOfTuna(inventory)
            "${ChatColor.GOLD}サーモンの握り" -> nigiriOfSalmon(inventory)
            "イカの握り" -> nigiriOfSquid(inventory)
            "${ChatColor.RED}タコの握り" -> nigiriOfOctopus(inventory)
            "シャリ" -> shari(inventory)
            else -> return null
        }
        return inventory
    }

    private fun udon(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.WHEAT, "茹で麺", 5))
        inventory.setItem(1, Item().make(Material.SWEET_BERRIES, "${ChatColor.GOLD}スパイス", null))
        inventory.setItem(2, Item().make(Material.CAULDRON, "${ChatColor.GREEN}茹でる", null))
        inventory.setItem(3, Item().make(Material.PAPER, "", 1))
        inventory.setItem(4, Item().make(Material.MUSHROOM_STEW, "うどん", 18))
    }

    private fun boiledNoodles(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.WHEAT, "生麺", 4))
        inventory.setItem(1, Item().make(Material.CAULDRON, "${ChatColor.GREEN}茹でる", null))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.WHEAT, "茹で麺", 5))
    }

    private fun rawNoodles(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.WHEAT, "${ChatColor.YELLOW}生生地", 6))
        inventory.setItem(1, Item().make(Material.DIAMOND_SWORD, "${ChatColor.RED}切る", 1))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.WHEAT, "生麺", 4))
    }

    private fun friedShrimp(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.COD, "${ChatColor.AQUA}衣付きエビ", 4))
        inventory.setItem(1, Item().make(Material.CAULDRON, "${ChatColor.YELLOW}揚げる", null))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}エビフライ", 14))
    }

    private fun clothesShrimp(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.COD, "${ChatColor.AQUA}剥きエビ", 3))
        inventory.setItem(1, Item().make(Material.CAULDRON, "衣", null))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.COD, "${ChatColor.AQUA}衣付きエビ", 4))
    }

    private fun cutShrimp(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.COD, "${ChatColor.AQUA}エビ", 2))
        inventory.setItem(1, Item().make(Material.DIAMOND_SWORD, "${ChatColor.AQUA}切る", 1))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.COD, "${ChatColor.AQUA}剥きエビ", 3))
    }

    private fun kidsLunch(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}スパゲッティー", 4))
        inventory.setItem(1, Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}ハンバーグ", 7))
        inventory.setItem(2, Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}エビフライ", 14))
        inventory.setItem(3, Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}カレーライス", 27))
        inventory.setItem(4, Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}オムライス", 1))
        inventory.setItem(5, Item().make(Material.COMPOSTER, "${ChatColor.GOLD}混ぜる", null))
        inventory.setItem(6, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(7, Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}お子様ランチ", 25))
    }

    private fun omeletteRice(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}オムレツ", 5))
        inventory.setItem(1, Item().make(Material.MUSHROOM_STEW, "ライス", 3))
        inventory.setItem(2, Item().make(Material.COMPOSTER, "${ChatColor.GOLD}混ぜる", null))
        inventory.setItem(3, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(4, Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}オムライス", 1))
    }

    private fun rice(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.WHEAT, "稲", 3))
        inventory.setItem(1, Item().make(Material.CAULDRON, "${ChatColor.RED}鍋", null))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.MUSHROOM_STEW, "ライス", 3))
    }

    private fun omelette(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.EGG, "卵", null))
        inventory.setItem(1, Item().make(Material.FURNACE, "${ChatColor.RED}焼く", null))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}オムレツ", 5))
    }

    private fun seafoodrice(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.COD, "${ChatColor.RED}マグロの刺身", 7))
        inventory.setItem(1, Item().make(Material.COD, "${ChatColor.GOLD}サーモンの刺身", 8))
        inventory.setItem(2, Item().make(Material.COD, "${ChatColor.AQUA}剥きエビ", 3))
        inventory.setItem(3, Item().make(Material.MUSHROOM_STEW, "ライス", 3))
        inventory.setItem(4, Item().make(Material.COMPOSTER, "${ChatColor.GOLD}混ぜる", null))
        inventory.setItem(5, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(6, Item().make(Material.MUSHROOM_STEW, "${ChatColor.AQUA}海鮮丼", 15))
    }

    private fun cuttuna(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.COD, "${ChatColor.RED}マグロ", 5))
        inventory.setItem(1, Item().make(Material.DIAMOND_SWORD, "${ChatColor.AQUA}切る", 1))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.COD, "${ChatColor.RED}マグロの刺身", 7))
    }

    private fun cutsalmon(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.COD, "${ChatColor.GOLD}サーモン", 6))
        inventory.setItem(1, Item().make(Material.DIAMOND_SWORD, "${ChatColor.AQUA}切る", 1))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.COD, "${ChatColor.GOLD}サーモンの刺身", 8))
    }

    private fun friedChicken(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.BEEF, "${ChatColor.RED}生からあげ", 3))
        inventory.setItem(1, Item().make(Material.CAULDRON, "${ChatColor.YELLOW}揚げる", null))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}からあげ", 6))
    }

    private fun rawFriedChicken(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.BEEF, "${ChatColor.RED}加工鶏肉", 4))
        inventory.setItem(1, Item().make(Material.CAULDRON, "衣", null))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.BEEF, "${ChatColor.RED}生からあげ", 3))
    }

    private fun cutBeef(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.BEEF, "${ChatColor.RED}肉の塊", 1))
        inventory.setItem(1, Item().make(Material.DIAMOND_SWORD, "${ChatColor.AQUA}切る", 1))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.BEEF, "${ChatColor.RED}加工肉", null))
    }

    private fun curry(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.SWEET_BERRIES, "${ChatColor.GOLD}スパイス", null))
        inventory.setItem(1, Item().make(Material.CARROT, "${ChatColor.GOLD}切った人参", 1))
        inventory.setItem(2, Item().make(Material.POTATO, "${ChatColor.GOLD}切ったじゃがいも", 1))
        inventory.setItem(3, Item().make(Material.BEEF, "${ChatColor.RED}加工肉", null))
        inventory.setItem(4, Item().make(Material.POTATO, "${ChatColor.GOLD}剥き玉ねぎ", 3))
        inventory.setItem(5, Item().make(Material.CAULDRON, "${ChatColor.RED}鍋", null))
        inventory.setItem(6, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(7, Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}カレー", 27))
    }

    private fun cutCarrot(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.CARROT, "${ChatColor.GOLD}にんじん", null))
        inventory.setItem(1, Item().make(Material.DIAMOND_SWORD, "${ChatColor.AQUA}切る", 1))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.CARROT, "${ChatColor.GOLD}切ったにんじん", 1))
    }

    private fun cutPtato(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.POTATO, "${ChatColor.GOLD}じゃがいも", null))
        inventory.setItem(1, Item().make(Material.DIAMOND_SWORD, "${ChatColor.AQUA}切る", 1))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.POTATO, "${ChatColor.GOLD}切ったじゃがいも", 1))
    }

    private fun cutOnion(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.BEEF, "${ChatColor.GOLD}たまねぎ", 2))
        inventory.setItem(1, Item().make(Material.DIAMOND_SWORD, "${ChatColor.AQUA}切る", 1))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.BEEF, "${ChatColor.GOLD}剥きたまねぎ", 3))
    }

    private fun curryUdon(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}カレー", 27))
        inventory.setItem(1, Item().make(Material.MUSHROOM_STEW, "うどん", 18))
        inventory.setItem(2, Item().make(Material.COMPOSTER, "${ChatColor.GOLD}混ぜる", null))
        inventory.setItem(3, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(4, Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}カレーうどん", 19))
    }

    private fun curryRice(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}カレー", 27))
        inventory.setItem(1, Item().make(Material.MUSHROOM_STEW, "ライス", 3))
        inventory.setItem(2, Item().make(Material.COMPOSTER, "${ChatColor.GOLD}混ぜる", null))
        inventory.setItem(3, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(4, Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}カレーライス", 2))
    }

    private fun sashimi(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.COD, "${ChatColor.RED}切ったタコ", 13))
        inventory.setItem(1, Item().make(Material.COD, "${ChatColor.RED}マグロの刺身", 7))
        inventory.setItem(2, Item().make(Material.COD, "${ChatColor.GOLD}サーモンの刺身", 8))
        inventory.setItem(3, Item().make(Material.COD, "${ChatColor.AQUA}剥きエビ", 3))
        inventory.setItem(4, Item().make(Material.COD, "イカの刺身", 10))
        inventory.setItem(5, Item().make(Material.COMPOSTER, "${ChatColor.GOLD}混ぜる", null))
        inventory.setItem(6, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(7, Item().make(Material.MUSHROOM_STEW, "刺身の盛り合わせ", 10))
    }

    private fun cutOctopus(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.COD, "${ChatColor.RED}タコ", 12))
        inventory.setItem(1, Item().make(Material.DIAMOND_SWORD, "${ChatColor.AQUA}切る", 1))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.COD, "${ChatColor.RED}切ったタコ", 13))
    }
    private fun salad(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.POTATO, "${ChatColor.GOLD}切ったじゃがいも", 2))
        inventory.setItem(1, Item().make(Material.CARROT, "${ChatColor.GOLD}切りすぎたにんじん", 3))
        inventory.setItem(2, Item().make(Material.WHEAT, "${ChatColor.GOLD}千切りキャベツ", 2))
        inventory.setItem(3, Item().make(Material.COMPOSTER, "${ChatColor.GOLD}混ぜる", null))
        inventory.setItem(4, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(5, Item().make(Material.MUSHROOM_STEW, "${ChatColor.GREEN}サラダ", 17))
    }
    private fun veryCutCarrot(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.CARROT, "${ChatColor.GOLD}切ったにんじん", 1))
        inventory.setItem(1, Item().make(Material.DIAMOND_SWORD, "${ChatColor.AQUA}切る", 1))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.CARROT, "${ChatColor.GOLD}切りすぎたにんじん", 2))
    }
    private fun catCabbage(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.WHEAT, "${ChatColor.GOLD}キャベツ", 1))
        inventory.setItem(1, Item().make(Material.DIAMOND_SWORD, "${ChatColor.AQUA}切る", 1))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.WHEAT, "${ChatColor.GOLD}千切りキャベツ", 2))
    }
    private fun steak(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.BEEF, "${ChatColor.RED}加工肉", null))
        inventory.setItem(1, Item().make(Material.FURNACE, "${ChatColor.RED}焼く", null))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(2, Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}ステーキ", 8))
    }
    private fun spaghetti(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.BEEF, "${ChatColor.RED}加工肉", null))
        inventory.setItem(1, Item().make(Material.WHEAT, "茹で麺", 5))
        inventory.setItem(2, Item().make(Material.SWEET_BERRIES, "${ChatColor.GOLD}スパイス", null))
        inventory.setItem(3, Item().make(Material.COMPOSTER, "${ChatColor.GOLD}混ぜる", null))
        inventory.setItem(4, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(5, Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}スパゲッティー", 4))
    }
    private fun doria(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}生ドリア", 12))
        inventory.setItem(1, Item().make(Material.FURNACE, "${ChatColor.RED}焼く", null))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}ドリア", 13))
    }
    private fun rawDoria(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.WHEAT, "${ChatColor.GREEN}小麦", null))
        inventory.setItem(1, Item().make(Material.MILK_BUCKET, "牛乳", null))
        inventory.setItem(2, Item().make(Material.MUSHROOM_STEW, "ライス", 3))
        inventory.setItem(3, Item().make(Material.COMPOSTER, "${ChatColor.GOLD}混ぜる", null))
        inventory.setItem(4, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(5, Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}生ドリア", 12))
    }
    private fun hamburg(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.BEEF, "${ChatColor.RED}生ハンバーグ", 2))
        inventory.setItem(1, Item().make(Material.FURNACE, "${ChatColor.RED}焼く", null))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}ハンバーグ", 7))
    }
    private fun rawHamburg(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.BEEF, "${ChatColor.RED}加工肉", null))
        inventory.setItem(1, Item().make(Material.POTATO, "${ChatColor.GOLD}剥きたまねぎ", 3))
        inventory.setItem(2, Item().make(Material.COMPOSTER, "${ChatColor.GOLD}混ぜる", null))
        inventory.setItem(3, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(4, Item().make(Material.BEEF, "${ChatColor.RED}生ハンバーグ", 2))
    }
    private fun bread(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.WHEAT, "${ChatColor.YELLOW}生生地", 6))
        inventory.setItem(1, Item().make(Material.PAPER, "${ChatColor.GOLD}バンズの型", 2))
        inventory.setItem(2, Item().make(Material.COMPOSTER, "${ChatColor.GOLD}混ぜる", null))
        inventory.setItem(3, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(4, Item().make(Material.BREAD, "${ChatColor.YELLOW}バンズ", null))
    }
    private fun hamburger(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.BREAD, "${ChatColor.YELLOW}バンズ", null))
        inventory.setItem(1, Item().make(Material.MILK_BUCKET, "牛乳", null))
        inventory.setItem(2, Item().make(Material.APPLE, "${ChatColor.YELLOW}チーズ", 1))
        inventory.setItem(3, Item().make(Material.COMPOSTER, "${ChatColor.GOLD}混ぜる", null))
        inventory.setItem(4, Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}ハンバーガー", 21))
    }
    private fun cheese(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.MILK_BUCKET, "牛乳", null))
        inventory.setItem(1, Item().make(Material.COMPOSTER, "${ChatColor.GOLD}混ぜる", null))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.APPLE, "${ChatColor.YELLOW}チーズ", 1))
    }
    private fun flyPotato(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.POTATO, "${ChatColor.GOLD}切ったじゃがいも", 1))
        inventory.setItem(1, Item().make(Material.CAULDRON, "${ChatColor.YELLOW}揚げる", null))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}フライドポテト", 16))
    }
    private fun pizza(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}生ピザ", 11))
        inventory.setItem(1, Item().make(Material.FURNACE, "${ChatColor.RED}焼く", null))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}ピザ", 9))
    }
    private fun rawPizza(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.WHEAT, "${ChatColor.YELLOW}生生地", 6))
        inventory.setItem(1, Item().make(Material.APPLE, "${ChatColor.YELLOW}チーズ", 1))
        inventory.setItem(2, Item().make(Material.BEEF, "${ChatColor.RED}加工肉", null))
        inventory.setItem(3, Item().make(Material.COMPOSTER, "${ChatColor.GOLD}混ぜる", null))
        inventory.setItem(4, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(5, Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}生ピザ", 11))
    }
    private fun material(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.WHEAT, "${ChatColor.GREEN}小麦", null))
        inventory.setItem(1, Item().make(Material.POTION, "${ChatColor.AQUA}水", null))
        inventory.setItem(2, Item().make(Material.EGG, "卵", null))
        inventory.setItem(3, Item().make(Material.COMPOSTER, "${ChatColor.GOLD}混ぜる", null))
        inventory.setItem(4, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(5, Item().make(Material.WHEAT, "${ChatColor.YELLOW}生生地", 6))
    }
    private fun catchickenMeat(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.CHICKEN, "${ChatColor.RED}鶏肉", null))
        inventory.setItem(1, Item().make(Material.DIAMOND_SWORD, "${ChatColor.AQUA}切る", 1))
        inventory.setItem(2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(3, Item().make(Material.BEEF, "${ChatColor.RED}加工鶏肉", 4))
    }
    private fun nigiriOfTuna(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.COD, "${ChatColor.RED}マグロの切り身", 7))
        inventory.setItem(1, Item().make(Material.COD, "シャリ", 15))
        inventory.setItem(2, Item().make(Material.COMPOSTER, "${ChatColor.GOLD}混ぜる", null))
        inventory.setItem(3, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(4, Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}マグロの握り", 29))
    }

    private fun nigiriOfSalmon(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.COD, "${ChatColor.GOLD}サーモンの切り身", 8))
        inventory.setItem(1, Item().make(Material.COD, "シャリ", 15))
        inventory.setItem(2, Item().make(Material.COMPOSTER, "${ChatColor.GOLD}混ぜる", null))
        inventory.setItem(3, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(4, Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}サーモンの握り", 30))
    }

    private fun nigiriOfSquid(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.COD, "イカの切り身", 10))
        inventory.setItem(1, Item().make(Material.COD, "シャリ", 15))
        inventory.setItem(2, Item().make(Material.COMPOSTER, "${ChatColor.GOLD}混ぜる", null))
        inventory.setItem(3, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(4, Item().make(Material.MUSHROOM_STEW, "イカの握り", 31))
    }
    private fun nigiriOfOctopus(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.COD, "${ChatColor.RED}切ったタコ", 13))
        inventory.setItem(1, Item().make(Material.COD, "シャリ", 15))
        inventory.setItem(2, Item().make(Material.COMPOSTER, "${ChatColor.GOLD}混ぜる", null))
        inventory.setItem(3, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(4, Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}タコの握り", 32))
    }
    private fun shari(inventory: Inventory) {
        inventory.setItem(0, Item().make(Material.MUSHROOM_STEW, "ライス", 3))
        inventory.setItem(1, Item().make(Material.COD, "${ChatColor.GOLD}お酢", 14))
        inventory.setItem(2, Item().make(Material.COMPOSTER, "${ChatColor.GOLD}混ぜる", null))
        inventory.setItem(3, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(4, Item().make(Material.COD, "シャリ", 15))
    }
}
