package com.github.Ringoame196

import com.github.Ringoame196.Data.CookingData
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.block.Furnace
import org.bukkit.entity.ItemFrame
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.Plugin
import org.bukkit.scheduler.BukkitRunnable
import kotlin.random.Random

class Cooking {
    fun cut(item: ItemStack, player: Player, entity: ItemFrame) {
        if (!knife(player)) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BELL, 1f, 1f)
            return
        }
        player.inventory.addItem(CookingData().cut(item) ?: return)
        entity.setItem(ItemStack(Material.AIR))
        player.playSound(player, Sound.ENTITY_SHEEP_SHEAR, 1f, 1f)
    }
    private fun knife(player: Player): Boolean {
        val knife = player.inventory.itemInMainHand
        val count = when (knife.type) {
            Material.STONE_SWORD -> 5
            Material.IRON_SWORD -> 3
            Material.DIAMOND_SWORD -> 1
            else -> return false
        }
        return Random.nextInt(0, count) == 0
    }
    fun bake(plugin: Plugin, player: Player, entity: ItemFrame, furnace: Furnace) {
        var c = 0
        object : BukkitRunnable() {
            override fun run() {
                player.sendMessage(c.toString())
                val item = entity.item
                c++
                furnace.burnTime = 20
                furnace.update()
                if (c == 5) {
                    entity.setItem(CookingData().bake(item))
                } else if (c >= 10 || item.type == Material.AIR) {
                    if (item.type != Material.AIR) {
                        entity.setItem(Item().make(Material.CHARCOAL, "${ChatColor.BLACK}炭", 1))
                    }
                    this.cancel()
                }
            }
        }.runTaskTimer(plugin, 0L, 20L) // 1秒間隔 (20 ticks) でタスクを実行
    }
}
