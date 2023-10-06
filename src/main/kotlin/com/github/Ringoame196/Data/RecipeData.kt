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
            itemMake("イカの握り", 31, 100),
            itemMake("うどん", 18, 100),
            itemMake("${ChatColor.YELLOW}エビフライ", 14, 100),
            itemMake("${ChatColor.GOLD}お子様ランチ", 25, 100),
            itemMake("${ChatColor.YELLOW}オムライス", 1, 100),
            itemMake("${ChatColor.AQUA}海鮮丼", 15, 100),
            itemMake("${ChatColor.YELLOW}からあげ", 6, 100),
            itemMake("${ChatColor.GOLD}カレーうどん", 19, 100),
            itemMake("${ChatColor.GOLD}カレーライス", 2, 100),
            itemMake("刺身の盛り合わせ", 10, 100),
            itemMake("${ChatColor.GOLD}サーモンのおにぎり", 36, 100),
            itemMake("${ChatColor.GOLD}サーモンの握り", 30, 100),
            itemMake("${ChatColor.GREEN}サラダ", 17, 100),
            itemMake("${ChatColor.RED}ステーキ", 8, 100),
            itemMake("${ChatColor.YELLOW}スパゲッティー", 4, 100),
            itemMake("${ChatColor.RED}タコの握り", 32, 100),
            itemMake("${ChatColor.RED}鉄火巻", 34, 100),
            itemMake("${ChatColor.YELLOW}ドリア", 13, 100),
            itemMake("${ChatColor.YELLOW}ハンバーガー", 21, 100),
            itemMake("${ChatColor.YELLOW}ハンバーグ", 7, 100),
            itemMake("${ChatColor.YELLOW}ピザ", 9, 100),
            itemMake("${ChatColor.RED}マグロの握り", 29, 100),
            itemMake("${ChatColor.YELLOW}フライドポテト", 16, 100),
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

    private fun itemMake(name: String, customeModelData: Int, price: Int): ItemStack {
        val item = Item().make(Material.MUSHROOM_STEW, name, customeModelData)
        val meta = item.itemMeta
        meta?.lore = mutableListOf<String>("${ChatColor.GREEN}${price}円")
        item.setItemMeta(meta)
        return item
    }

    fun quote(name: String, inventory: Inventory): Inventory? {
        when (name) {
            "うどん" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.WHEAT, "茹で麺", 5),
                    Item().make(Material.SWEET_BERRIES, "${ChatColor.GOLD}スパイス", null)
                )
                mix(inventory, material, Item().make(Material.MUSHROOM_STEW, "うどん", 18))
            }
            "茹で麺" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.WHEAT, "生麺", 4)
                )
                pot(inventory, material, Item().make(Material.WHEAT, "茹で麺", 5))
            }
            "生麺" -> {
                cut(
                    inventory,
                    Item().make(Material.WHEAT, "${ChatColor.YELLOW}生生地", 6),
                    Item().make(Material.WHEAT, "生麺", 4)
                )
            }
            "${ChatColor.YELLOW}エビフライ" -> {
                fry(
                    inventory,
                    Item().make(Material.COD, "${ChatColor.AQUA}衣付きエビ", 4),
                    Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}エビフライ", 14)
                )
            }
            "${ChatColor.AQUA}衣付きエビ" -> {
                clothing(
                    inventory,
                    Item().make(Material.COD, "${ChatColor.AQUA}剥きエビ", 3),
                    Item().make(Material.COD, "${ChatColor.AQUA}衣付きエビ", 4)
                )
            }
            "${ChatColor.AQUA}剥きエビ" -> {
                cut(
                    inventory,
                    Item().make(Material.COD, "${ChatColor.AQUA}エビ", 2),
                    Item().make(Material.COD, "${ChatColor.AQUA}剥きエビ", 3)
                )
            }
            "${ChatColor.GOLD}お子様ランチ" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}スパゲッティー", 4),
                    Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}ハンバーグ", 7),
                    Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}エビフライ", 14),
                    Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}カレーライス", 27),
                    Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}オムライス", 1)
                )
                mix(inventory, material, Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}お子様ランチ", 25))
            }
            "${ChatColor.YELLOW}オムライス" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}オムレツ", 5),
                    Item().make(Material.MUSHROOM_STEW, "ライス", 3)
                )
                mix(inventory, material, Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}オムライス", 1))
            }
            "ライス" -> {
                val material = mutableListOf<ItemStack>(Item().make(Material.WHEAT, "稲", 3))
                pot(inventory, material, Item().make(Material.MUSHROOM_STEW, "ライス", 3))
            }
            "${ChatColor.YELLOW}オムレツ" -> {
                bake(
                    inventory,
                    Item().make(Material.EGG, "卵", null),
                    Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}オムレツ", 5)
                )
            }
            "${ChatColor.AQUA}海鮮丼" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.COD, "${ChatColor.RED}マグロの切り身", 7),
                    Item().make(Material.COD, "${ChatColor.GOLD}サーモンの切り身", 8),
                    Item().make(Material.COD, "${ChatColor.AQUA}剥きエビ", 3),
                    Item().make(Material.MUSHROOM_STEW, "ライス", 3)
                )
                mix(inventory, material, Item().make(Material.MUSHROOM_STEW, "${ChatColor.AQUA}海鮮丼", 15))
            }
            "${ChatColor.RED}マグロの切り身" -> {
                cut(
                    inventory,
                    Item().make(Material.COD, "${ChatColor.RED}マグロ", 5),
                    Item().make(Material.COD, "${ChatColor.RED}マグロの切り身", 7)
                )
            }
            "${ChatColor.GOLD}サーモンの切り身" -> {
                cut(
                    inventory,
                    Item().make(Material.COD, "${ChatColor.GOLD}サーモン", 6),
                    Item().make(Material.COD, "${ChatColor.GOLD}サーモンの切り身", 8)
                )
            }
            "${ChatColor.YELLOW}からあげ" -> {
                fry(
                    inventory,
                    Item().make(Material.BEEF, "${ChatColor.RED}生からあげ", 3),
                    Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}からあげ", 6)
                )
            }
            "${ChatColor.RED}生からあげ" -> {
                clothing(
                    inventory,
                    Item().make(Material.BEEF, "${ChatColor.RED}加工鶏肉", 4),
                    Item().make(Material.BEEF, "${ChatColor.RED}生からあげ", 3)
                )
            }
            "${ChatColor.RED}加工肉" -> {
                cut(
                    inventory,
                    Item().make(Material.BEEF, "${ChatColor.RED}肉の塊", 1),
                    Item().make(Material.BEEF, "${ChatColor.RED}加工肉", null)
                )
            }
            "${ChatColor.GOLD}カレー" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.SWEET_BERRIES, "${ChatColor.GOLD}スパイス", null),
                    Item().make(Material.CARROT, "${ChatColor.GOLD}切った人参", 1),
                    Item().make(Material.POTATO, "${ChatColor.GOLD}切ったじゃがいも", 1),
                    Item().make(Material.BEEF, "${ChatColor.RED}加工肉", null),
                    Item().make(Material.POTATO, "${ChatColor.GOLD}剥きたまねぎ", 3)
                )
                pot(inventory, material, Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}カレー", 27))
            }
            "${ChatColor.GOLD}切ったにんじん" -> {
                cut(
                    inventory,
                    Item().make(Material.CARROT, "${ChatColor.GOLD}にんじん", null),
                    Item().make(Material.CARROT, "${ChatColor.GOLD}切ったにんじん", 1)
                )
            }
            "${ChatColor.GOLD}切ったじゃがいも" -> {
                cut(
                    inventory,
                    Item().make(Material.POTATO, "${ChatColor.GOLD}じゃがいも", null),
                    Item().make(Material.POTATO, "${ChatColor.GOLD}切ったじゃがいも", 1)
                )
            }
            "${ChatColor.GOLD}剥きたまねぎ" -> {
                cut(
                    inventory,
                    Item().make(Material.BEEF, "${ChatColor.GOLD}たまねぎ", 2),
                    Item().make(Material.BEEF, "${ChatColor.GOLD}剥きたまねぎ", 3)
                )
            }
            "${ChatColor.GOLD}カレーうどん" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}カレー", 27),
                    Item().make(Material.MUSHROOM_STEW, "うどん", 18)
                )
                mix(inventory, material, Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}カレーうどん", 19))
            }
            "${ChatColor.GOLD}カレーライス" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}カレー", 27),
                    Item().make(Material.MUSHROOM_STEW, "ライス", 3)
                )
                mix(inventory, material, Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}カレーライス", 2))
            }
            "刺身の盛り合わせ" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.COD, "${ChatColor.RED}切ったタコ", 13),
                    Item().make(Material.COD, "${ChatColor.RED}マグロの切り身", 7),
                    Item().make(Material.COD, "${ChatColor.GOLD}サーモンの切り身", 8),
                    Item().make(Material.COD, "${ChatColor.AQUA}剥きエビ", 3),
                    Item().make(Material.COD, "イカの切り身", 10)
                )
                mix(inventory, material, Item().make(Material.MUSHROOM_STEW, "刺身の盛り合わせ", 10))
            }
            "${ChatColor.RED}切ったタコ" -> {
                cut(
                    inventory,
                    Item().make(Material.COD, "${ChatColor.RED}タコ", 12),
                    Item().make(Material.COD, "${ChatColor.RED}切ったタコ", 13)
                )
            }
            "イカの切り身" -> {
                cut(
                    inventory,
                    Item().make(Material.COD, "イカ", 9),
                    Item().make(Material.COD, "切ったイカ", 10)
                )
            }
            "${ChatColor.YELLOW}スパゲッティー" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.BEEF, "${ChatColor.RED}加工肉", null),
                    Item().make(Material.WHEAT, "茹で麺", 5),
                    Item().make(Material.SWEET_BERRIES, "${ChatColor.GOLD}スパイス", null)
                )
                mix(inventory, material, Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}スパゲッティー", 4))
            }
            "${ChatColor.GOLD}切りすぎたにんじん" -> {
                cut(
                    inventory,
                    Item().make(Material.CARROT, "${ChatColor.GOLD}切ったにんじん", 1),
                    Item().make(Material.CARROT, "${ChatColor.GOLD}切りすぎたにんじん", 2)
                )
            }
            "${ChatColor.GOLD}千切りキャベツ" -> {
                cut(
                    inventory,
                    Item().make(Material.WHEAT, "${ChatColor.GOLD}キャベツ", 1),
                    Item().make(Material.WHEAT, "${ChatColor.GOLD}千切りキャベツ", 2)
                )
            }
            "${ChatColor.RED}ステーキ" -> {
                bake(
                    inventory,
                    Item().make(Material.BEEF, "${ChatColor.RED}加工肉", null),
                    Item().make(Material.BEEF, "${ChatColor.RED}加工肉", null)
                )
            }
            "${ChatColor.GREEN}サラダ" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.POTATO, "${ChatColor.GREEN}切ったキュウリ", 6),
                    Item().make(Material.CARROT, "${ChatColor.GOLD}切りすぎたにんじん", 3),
                    Item().make(Material.WHEAT, "${ChatColor.GOLD}千切りキャベツ", 2)
                )
                mix(inventory, material, Item().make(Material.MUSHROOM_STEW, "${ChatColor.GREEN}サラダ", 17))
            }
            "${ChatColor.YELLOW}ドリア" -> {
                bake(
                    inventory,
                    Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}生ドリア", 12),
                    Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}ドリア", 13)
                )
            }
            "${ChatColor.RED}生ドリア" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.WHEAT, "${ChatColor.GREEN}小麦", null),
                    Item().make(Material.MILK_BUCKET, "牛乳", null),
                    Item().make(Material.MUSHROOM_STEW, "ライス", 3)
                )
                mix(inventory, material, Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}生ドリア", 12))
            }
            "${ChatColor.YELLOW}ハンバーグ" -> {
                bake(
                    inventory,
                    Item().make(Material.BEEF, "${ChatColor.RED}生ハンバーグ", 2),
                    Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}ハンバーグ", 7)
                )
            }
            "${ChatColor.RED}生ハンバーグ" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.BEEF, "${ChatColor.RED}加工肉", null),
                    Item().make(Material.POTATO, "${ChatColor.GOLD}剥きたまねぎ", 3),
                    Item().make(Material.COMPOSTER, "${ChatColor.GOLD}混ぜる", null)
                )
                mix(inventory, material, Item().make(Material.BEEF, "${ChatColor.RED}生ハンバーグ", 2))
            }
            "${ChatColor.YELLOW}生バンズ" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.WHEAT, "${ChatColor.YELLOW}生生地", 6),
                    Item().make(Material.PAPER, "${ChatColor.GOLD}バンズの型", 2)
                )
                mix(inventory, material, Item().make(Material.WHEAT, "${ChatColor.YELLOW}生バンズ", 7))
            }
            "${ChatColor.YELLOW}バンズ" -> {
                bake(inventory, Item().make(Material.WHEAT, "${ChatColor.YELLOW}生バンズ", 7), Item().make(Material.WHEAT, "${ChatColor.YELLOW}バンズ", 8))
            }
            "${ChatColor.YELLOW}ハンバーガー" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.WHEAT, "${ChatColor.YELLOW}バンズ", 8),
                    Item().make(Material.MILK_BUCKET, "牛乳", null),
                    Item().make(Material.APPLE, "${ChatColor.YELLOW}チーズ", 1),
                    Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}ハンバーグ", 7)
                )
                mix(inventory, material, Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}ハンバーガー", 21))
            }
            "${ChatColor.YELLOW}チーズ" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.MILK_BUCKET, "牛乳", null)
                )
                mix(inventory, material, Item().make(Material.APPLE, "${ChatColor.YELLOW}チーズ", 1))
            }
            "${ChatColor.YELLOW}フライドポテト" -> {
                fry(
                    inventory,
                    Item().make(Material.POTATO, "${ChatColor.GOLD}切ったじゃがいも", 1),
                    Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}フライドポテト", 16)
                )
            }
            "${ChatColor.YELLOW}ピザ" -> {
                bake(
                    inventory,
                    Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}生ピザ", 11),
                    Item().make(Material.MUSHROOM_STEW, "${ChatColor.YELLOW}ピザ", 9)
                )
            }
            "${ChatColor.RED}生ピザ" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.WHEAT, "${ChatColor.YELLOW}生生地", 6),
                    Item().make(Material.APPLE, "${ChatColor.YELLOW}チーズ", 1),
                    Item().make(Material.BEEF, "${ChatColor.RED}加工肉", null),
                    Item().make(Material.POTATO, "${ChatColor.RED}トマトペースト", 9)
                )
                mix(inventory, material, Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}生ピザ", 11))
            }
            "${ChatColor.YELLOW}生生地" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.WHEAT, "${ChatColor.GREEN}小麦", null),
                    Item().make(Material.POTION, "${ChatColor.AQUA}水", null),
                    Item().make(Material.EGG, "卵", null)
                )
                mix(inventory, material, Item().make(Material.WHEAT, "${ChatColor.YELLOW}生生地", 6))
            }
            "${ChatColor.RED}加工鶏肉" -> {
                cut(
                    inventory,
                    Item().make(Material.CHICKEN, "${ChatColor.RED}鶏肉の塊", null),
                    Item().make(Material.BEEF, "${ChatColor.RED}加工鶏肉", 7)
                )
            }
            "${ChatColor.RED}マグロの握り" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.COD, "${ChatColor.RED}マグロの切り身", 7),
                    Item().make(Material.COD, "シャリ", 15)
                )
                mix(inventory, material, Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}マグロの握り", 29))
            }
            "${ChatColor.GOLD}サーモンの握り" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.COD, "${ChatColor.GOLD}サーモンの切り身", 8),
                    Item().make(Material.COD, "シャリ", 15)
                )
                mix(inventory, material, Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}サーモンの握り", 30))
            }
            "イカの握り" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.COD, "イカの切り身", 10),
                    Item().make(Material.COD, "シャリ", 15)
                )
                mix(inventory, material, Item().make(Material.MUSHROOM_STEW, "イカの握り", 31))
            }
            "${ChatColor.RED}タコの握り" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.COD, "${ChatColor.RED}切ったタコ", 13),
                    Item().make(Material.COD, "シャリ", 15)
                )
                mix(inventory, material, Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}タコの握り", 32))
            }
            "シャリ" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.MUSHROOM_STEW, "ライス", 3),
                    Item().make(Material.COD, "${ChatColor.GOLD}お酢", 14)
                )
                mix(inventory, material, Item().make(Material.COD, "シャリ", 15))
            }
            "${ChatColor.RED}鉄火巻" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.COD, "シャリ", 15),
                    Item().make(Material.COD, "${ChatColor.BLACK}焼海苔", 16),
                    Item().make(Material.COD, "${ChatColor.RED}マグロの切り身", 7)
                )
                mix(inventory, material, Item().make(Material.MUSHROOM_STEW, "${ChatColor.RED}鉄火巻", 34))
            }
            "${ChatColor.BLACK}焼海苔" -> {
                bake(inventory, Item().make(Material.COD, "海苔", 11), Item().make(Material.COD, "焼海苔", 16))
            }
            "${ChatColor.GOLD}サーモンのおにぎり" -> {
                val material = mutableListOf<ItemStack>(
                    Item().make(Material.COD, "${ChatColor.BLACK}焼海苔", 16),
                    Item().make(Material.MUSHROOM_STEW, "ライス", 3),
                    Item().make(Material.COD, "${ChatColor.GOLD}サーモンの切り身", 8)
                )
                mix(inventory, material, Item().make(Material.MUSHROOM_STEW, "${ChatColor.GOLD}サーモンのおにぎり", 36))
            }
            "${ChatColor.GREEN}切ったキュウリ" -> {
                cut(inventory, Item().make(Material.POTATO, "${ChatColor.GREEN}キュウリ", 5), Item().make(Material.POTATO, "${ChatColor.GREEN}切ったキュウリ", 6))
            }
            else -> return null
        }
        return inventory
    }
    private fun cut(inventory: Inventory, before: ItemStack, after: ItemStack) {
        inventory.setItem(0, before)
        inventory.setItem(1, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(2, Item().make(Material.DIAMOND_SWORD, "${ChatColor.RED}切る", 1))
        inventory.setItem(3, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(4, after)
    }
    private fun bake(inventory: Inventory, before: ItemStack, after: ItemStack) {
        inventory.setItem(0, before)
        inventory.setItem(1, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(2, Item().make(Material.FURNACE, "${ChatColor.RED}焼く", null))
        inventory.setItem(3, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(4, after)
    }
    private fun fry(inventory: Inventory, before: ItemStack, after: ItemStack) {
        inventory.setItem(0, before)
        inventory.setItem(1, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(2, Item().make(Material.CAULDRON, "${ChatColor.YELLOW}揚げる", 1))
        inventory.setItem(3, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(4, after)
    }
    private fun clothing(inventory: Inventory, before: ItemStack, after: ItemStack) {
        inventory.setItem(0, before)
        inventory.setItem(1, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(2, Item().make(Material.CAULDRON, "衣", 2))
        inventory.setItem(3, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(4, after)
    }
    private fun mix(inventory: Inventory, material: List<ItemStack>, after: ItemStack) {
        var i = 0
        for (c in material.indices) {
            val item = material[c]
            inventory.setItem(c, item)
            i++
        }
        inventory.setItem(i, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(i + 1, Item().make(Material.COMPOSTER, "${ChatColor.GOLD}混ぜる", null))
        inventory.setItem(i + 2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(i + 3, after)
    }
    private fun pot(inventory: Inventory, material: List<ItemStack>, after: ItemStack) {
        var i = 0
        for (c in material.indices) {
            val item = material[c]
            inventory.setItem(c, item)
            i++
        }
        inventory.setItem(i, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(i + 1, Item().make(Material.CAULDRON, "${ChatColor.RED}鍋", 3))
        inventory.setItem(i + 2, Item().make(Material.PAPER, "→", 1))
        inventory.setItem(i + 3, after)
    }
}
