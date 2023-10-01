package com.github.Ringoame196

import org.bukkit.Location
import org.bukkit.entity.Villager

class Customer {
    fun onTheDesk(villager: Villager): Location {
        val location = villager.location
        val direction = villager.facing

        // 村人の位置と向きから前方の座標を計算
        val xOffset = direction.modX.toDouble()
        val yOffset = direction.modY.toDouble()
        val zOffset = direction.modZ.toDouble()

        return location.add(xOffset, yOffset + 1, zOffset)
    }
}
