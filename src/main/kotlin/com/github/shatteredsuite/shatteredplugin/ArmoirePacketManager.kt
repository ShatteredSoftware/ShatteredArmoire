package com.github.shatteredsuite.shatteredplugin

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.*
import com.comphenix.protocol.wrappers.WrappedGameProfile
import com.github.shatteredsuite.shatteredplugin.data.SkinData
import java.util.*

class ArmoirePacketManager(private val armoire: ShatteredArmoire)
    : PacketAdapter(armoire, ListenerPriority.LOWEST, PacketType.Play.Server.PLAYER_INFO) {
    override fun onPacketSending(event: PacketEvent?) {
        super.onPacketSending(event)
        var skinData: SkinData = armoire.config().defaultSkinData()
        event?.player?.uniqueId?.toString()?.let { skinData = armoire.playerRepo.get(it) ?: return }
        val profile = WrappedGameProfile(event?.player?.uniqueId ?: UUID.randomUUID(), "")
        profile.properties.removeAll("textures")
        profile.properties.put("textures", skinData.toTextureProperty())
    }
}