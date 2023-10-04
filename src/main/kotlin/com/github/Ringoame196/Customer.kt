package com.github.Ringoame196

import com.github.Ringoame196.Data.RecipeData
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.entity.Villager
import org.bukkit.plugin.Plugin
import kotlin.random.Random

class Customer {
    fun switching(plugin: Plugin, entity: Villager, player: Player) {
        when (val name = entity.customName) {
            null -> {
                entity.isCustomNameVisible = true
                entity.customName = "${ChatColor.GOLD}注文待ち中"
            }
            "${ChatColor.GOLD}注文待ち中" -> {
                if (Customer().onTheDesk(entity).block.type == Material.HEAVY_WEIGHTED_PRESSURE_PLATE) {
                    player.sendMessage("${ChatColor.RED}皿を片付けてください")
                    return
                }
                val foodList = RecipeData().foodList()
                val orderedItems = foodList[Random.nextInt(0, foodList.size - 1)]
                entity.customName = orderedItems.itemMeta?.displayName
                entity.equipment?.helmet = orderedItems
                player.sendMessage("${ChatColor.YELLOW}[注文]${orderedItems.itemMeta?.displayName}")
            }
            "${ChatColor.RED}食事中" -> {}
            else -> {
                val playerItem = player.inventory.itemInMainHand.itemMeta?.displayName
                if (name == playerItem || playerItem == "${ChatColor.YELLOW}パフェ") {
                    player.inventory.addItem(Item().make(Material.PAPER, getMoney(name), 3))
                    Item().remove(player)
                    entity.customName = "${ChatColor.RED}食事中"
                    entity.equipment?.helmet = null
                    val mTime = Random.nextInt(20, 60) * 20
                    Bukkit.getScheduler().runTaskLater(
                        plugin,
                        Runnable
                        {
                            if (Random.nextInt(1, 3) == 1) {
                                entity.customName = "${ChatColor.GOLD}注文待ち中"
                            } else {
                                entity.remove()
                            }
                            Customer().onTheDesk(entity).block.setType(Material.HEAVY_WEIGHTED_PRESSURE_PLATE)
                        },
                        mTime.toLong()
                    ) // 20Lは1秒を表す（1秒 = 20ticks）
                }
            }
        }
    }
    private fun getMoney(item: String): String {
        for (food in RecipeData().foodList()) {
            if (item != food.itemMeta?.displayName) { continue }
            return food.itemMeta?.lore?.get(0) ?: "0"
        }
        return "50"
    }
    private fun onTheDesk(villager: Villager): Location {
        val location = villager.location
        val direction = villager.facing

        // 村人の位置と向きから前方の座標を計算
        val xOffset = direction.modX.toDouble()
        val yOffset = direction.modY.toDouble()
        val zOffset = direction.modZ.toDouble()

        return location.add(xOffset, yOffset + 1, zOffset)
    }
}
