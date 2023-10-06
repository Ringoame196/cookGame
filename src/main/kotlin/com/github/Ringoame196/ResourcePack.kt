package com.github.Ringoame196

import com.github.Ringoame196.Data.GameData
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import java.io.File

class ResourcePack(plugin: Plugin) {
    val path = "${plugin.dataFolder}/resourcePack.yml"
    val configPath = File(path)
    fun update(plugin: Plugin) {
        if (!configPath.exists()) { return }
        val url = YamlConfiguration.loadConfiguration(File(path)).getString("URL")
        val gas = YamlConfiguration.loadConfiguration(File(path)).getString("GAS_URL") ?: return

        val newURL = Web().get(gas).toString()
        if (url == newURL) { return }
        config().save(plugin, "URL", newURL)
        GameData.DataManager.resourcePack = newURL
        Bukkit.broadcastMessage("${ChatColor.YELLOW}[クックゲーム]リソースパックが更新されました")
    }
    fun adaptation(player: Player) {
        val resourcePack = GameData.DataManager.resourcePack
        if (resourcePack == null) {
            player.sendMessage("${ChatColor.RED}リソパURL未設定です")
        } else {
            player.setResourcePack(resourcePack)
        }
    }
}
