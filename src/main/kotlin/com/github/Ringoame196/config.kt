package com.github.Ringoame196

import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.Plugin
import java.io.File
import java.io.IOException

class config {
    fun save(plugin: Plugin, key: String, text: String) {
        val filePath = File(plugin.dataFolder, "/resourcePack.yml")
        val yamlConfiguration = YamlConfiguration.loadConfiguration(filePath)

        // 既存のデータを上書き
        yamlConfiguration.set(key, text)

        try {
            yamlConfiguration.save(filePath)
        } catch (e: IOException) {
            println("Error while saving data: ${e.message}")
        }
    }
}
