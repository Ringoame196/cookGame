package com.github.Ringoame196

import com.github.Ringoame196.Data.CookingData
import com.github.Ringoame196.Entity.ArmorStand
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.World
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
        player.world.playSound(player.location, Sound.ENTITY_SHEEP_SHEAR, 1f, 1f)
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
        val world = entity.world
        object : BukkitRunnable() {
            override fun run() {
                val item = entity.item
                c++
                world.playSound(entity.location, Sound.BLOCK_FIRE_AMBIENT, 1f, 1f)
                furnace.burnTime = 40
                armorStand.customName = "${ChatColor.YELLOW}${c}秒"
                furnace.update()
                if (c == 10) {
                    val bakeItem = CookingData().bake(item)
                    if (bakeItem != null) {
                        entity.setItem(bakeItem)
                        world.playSound(entity.location, Sound.BLOCK_FIRE_EXTINGUISH, 1f, 1f)
                    }
                } else if (c == 20 || item.type == Material.AIR) {
                    if (item.type != Material.AIR) {
                        entity.setItem(Item().make(Material.CHARCOAL, "${ChatColor.BLACK}炭", null))
                        world.playSound(entity.location, Sound.ENTITY_GENERIC_EXPLODE, 1f, 1f)
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
        player.world.playSound(player.location, Sound.ITEM_BUCKET_EMPTY, 1f, 1f)
    }
    fun fry(block: Block, item: ItemStack, plugin: Plugin) {
        val armorStand = ArmorStand().summon(block.location.clone().add(0.5, -0.2, 0.5), " ")
        val timer = ArmorStand().summon(block.location.clone().add(0.5, 1.0, 0.5), " ")
        armorStand.equipment?.helmet = item
        var c = 8
        object : BukkitRunnable() {
            override fun run() {
                c--
                timer.customName = "${ChatColor.YELLOW}${c}秒"
                if (c == 0) {
                    Item().drop(block.location.clone().add(0.5, 1.0, 0.5), CookingData().fly(item) ?: return)
                    armorStand.remove()
                    timer.remove()
                    block.world.playSound(block.location, Sound.BLOCK_FIRE_EXTINGUISH, 1f, 1f)
                    this.cancel()
                }
            }
        }.runTaskTimer(plugin, 0L, 20L) // 1秒間隔 (20 ticks) でタスクを実行
    }
    fun mix(player: Player, block: Block) {
        val location = block.location.add(0.5, -0.5, 0.5)
        val armorStandList = findArmorStandsInRadius(location, 0.5)
        val locationText = "${location.x},${location.y},${location.z}"
        val item = player.inventory.itemInMainHand

        val mainItem = player.inventory.itemInMainHand
        when (mainItem.type) {
            Material.STICK -> {
                player.world.playSound(player.location, Sound.BLOCK_BREWING_STAND_BREW, 1f, 1f)
                Scoreboard().add("mixCount", locationText, 1)
                val ingredients = mutableListOf<String>()
                val cook = Scoreboard().getValue("mixCount", locationText) >= 25
                for (armorStand in armorStandList) {
                    val armorStandLocation = armorStand.location
                    armorStandLocation.yaw = armorStandLocation.yaw + Random.nextInt(10, 30)
                    armorStand.teleport(armorStandLocation)
                    if (cook) {
                        val hetItem = armorStand.equipment?.helmet?.itemMeta?.displayName ?: continue
                        ingredients.add(hetItem)
                        armorStand.remove()
                    }
                }
                if (!cook) { return }
                val food = CookingData().mix(ingredients)
                if (food == null) {
                    mixReturn(player, armorStandList)
                    player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BELL, 1f, 1f)
                    return
                }
                player.inventory.addItem(food)
                player.world.playSound(player.location, Sound.BLOCK_ANVIL_USE, 1f, 1f)
                Scoreboard().set("mixCount", locationText, 0)
            }
            Material.AIR -> {}
            else -> {
                val armorStand = ArmorStand().summon(location, " ")
                val inItem = item.clone()
                inItem.amount = 1
                armorStand.equipment?.helmet = inItem
                player.world.playSound(player.location, Sound.BLOCK_END_PORTAL_FRAME_FILL, 1f, 1f)
                Item().remove(player)
                Scoreboard().set("mixCount", locationText, 0)
            }
        }
    }
    private fun mixReturn(player: Player, armorStandList: List<org.bukkit.entity.ArmorStand>) {
        for (armorStand in armorStandList) {
            val item = armorStand.equipment?.helmet ?: continue
            player.inventory.addItem(item)
            armorStand.remove()
        }
    }
    private fun findArmorStandsInRadius(location: Location, radius: Double): List<org.bukkit.entity.ArmorStand> {
        val world: World? = location.world?.name?.let { Bukkit.getWorld(it) }

        val armorStandsInRange = mutableListOf<org.bukkit.entity.ArmorStand>()

        if (world != null) {
            for (entity in world.entities) {
                if (entity is org.bukkit.entity.ArmorStand) {
                    val entityLocation = entity.location
                    val distance = location.distance(entityLocation)

                    if (distance <= radius) {
                        armorStandsInRange.add(entity)
                    }
                }
            }
        }

        return armorStandsInRange
    }
}
