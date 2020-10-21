package com.github.shatteredsuite.shatteredplugin.data

import com.comphenix.protocol.wrappers.WrappedSignedProperty

data class PlayerSkinData(val mineSkinPath: String, val textureHash: String, val textureSig: String,
                          val fragments: List<String>) : SkinData() {

    override fun toTextureProperty() : WrappedSignedProperty =
            WrappedSignedProperty("textures", textureHash, textureSig)
}