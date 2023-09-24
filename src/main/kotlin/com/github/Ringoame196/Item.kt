package com.github.Ringoame196

import org.bukkit.Material
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
}
