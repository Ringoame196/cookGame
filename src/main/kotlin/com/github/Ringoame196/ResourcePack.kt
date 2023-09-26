package com.github.Ringoame196

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.Plugin
import java.io.File

class ResourcePack(plugin: Plugin) {
    val path = "${plugin.dataFolder}/resourcePack.yml"
    val configPath = File(path)
    fun load(): String? {
        if (!configPath.exists()) { return null }
        val config = YamlConfiguration.loadConfiguration(File(path))
        return config.getString("URL").toString()
    }
    fun update(plugin: Plugin) {
        if (!configPath.exists()) { return }
        val url = YamlConfiguration.loadConfiguration(File(path)).getString("URL")
        val gas = YamlConfiguration.loadConfiguration(File(path)).getString("GAS_URL") ?: return

        val newURL = Web().get(gas).toString()
        if (url == newURL) { return }
        config().save(plugin, "URL", newURL)
        Bukkit.broadcastMessage("${ChatColor.YELLOW}[クックゲーム]リソースパックが更新されました")
    }
}
