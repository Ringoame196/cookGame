package com.github.Ringoame196

import com.github.Ringoame196.Data.CookingData
import com.github.Ringoame196.Entity.ArmorStand
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.block.Block
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
    fun bake(plugin: Plugin, entity: ItemFrame, furnace: Furnace) {
        var c = 0
        if (entity.isVisible) { entity.isVisible = false }
        val armorStand = ArmorStand().summon(entity.location, "")
        object : BukkitRunnable() {
            override fun run() {
                val item = entity.item
                c++
                furnace.burnTime = 40
                armorStand.customName = "${ChatColor.YELLOW}${c}秒"
                furnace.update()
                if (c == 5) {
                    val bakeItem = CookingData().bake(item)
                    if (bakeItem != null) {
                        entity.setItem(bakeItem)
                    }
                } else if (c >= 10 || item.type == Material.AIR) {
                    if (item.type != Material.AIR) {
                        entity.setItem(Item().make(Material.CHARCOAL, "${ChatColor.BLACK}炭", null))
                    }
                    armorStand.remove()
                    this.cancel()
                }
            }
        }.runTaskTimer(plugin, 0L, 20L) // 1秒間隔 (20 ticks) でタスクを実行
    }
    fun dressing(player: Player) {
        val item = player.inventory.itemInMainHand
        val dressingItem = CookingData().dressing(item) ?: return
        dressingItem.amount = item.amount
        player.inventory.setItemInMainHand(dressingItem)
    }
    fun fry(block: Block, item: ItemStack, plugin: Plugin) {
        val armorStand = ArmorStand().summon(block.location.clone().add(0.5, -0.2, 0.5), " ")
        val timer = ArmorStand().summon(block.location.clone().add(0.5, 1.0, 0.5), " ")
        armorStand.equipment?.helmet = item
        var c = 0
        object : BukkitRunnable() {
            override fun run() {
                c++
                timer.customName = "${ChatColor.YELLOW}${c}秒"
                if (c == 8) {
                    Item().drop(block.location.clone().add(0.5, 1.0, 0.5), CookingData().fly(item))
                    armorStand.remove()
                    timer.remove()
                    this.cancel()
                }
            }
        }.runTaskTimer(plugin, 0L, 20L) // 1秒間隔 (20 ticks) でタスクを実行
    }
}
