package com.github.Ringoame196

import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.Item
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Item {
    fun make(type: Material, display: String, customModelData: Int?): ItemStack {
        val item = ItemStack(type)
        val meta = item.itemMeta
        meta?.setDisplayName(display)
        if (customModelData != null) {
            meta?.setCustomModelData(customModelData)
        }
        item.setItemMeta(meta)
        return item
    }
    fun drop(location: Location, itemStack: ItemStack) {
        val item: Item = location.world!!.spawn(location, org.bukkit.entity.Item::class.java)
        item.itemStack = itemStack
    }
    fun remove(player: Player) {
        val item = player.inventory.itemInMainHand
        item.amount = item.amount - 1
        player.inventory.setItemInMainHand(item)
    }
}
