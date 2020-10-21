package com.github.shatteredsuite.shatteredplugin

import com.comphenix.protocol.ProtocolLibrary
import com.github.shatteredsuite.core.ShatteredPlugin
import com.github.shatteredsuite.core.tasks.AsyncBukkitRunStrategy
import com.github.shatteredsuite.core.util.PlayerDataManager
import com.github.shatteredsuite.shatteredplugin.data.PlayerSkinData
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

class ShatteredArmoire : ShatteredPlugin() {
    val playerRepo: PlayerDataManager<PlayerSkinData>
    val gson: Gson = GsonBuilder().create()
    lateinit var config: ArmoireConfig
        private set

    init {
        playerRepo = PlayerDataManager(this, gson, TypeToken.get(PlayerSkinData::class.java),
                "players", AsyncBukkitRunStrategy(this))
    }

    override fun postEnable() {
        val protoManager = ProtocolLibrary.getProtocolManager()
        protoManager.addPacketListener(ArmoirePacketManager(this))
    }

    fun config() : ArmoireConfig = config
}
