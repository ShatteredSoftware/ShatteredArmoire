package com.github.shatteredsuite.shatteredplugin.data

import com.comphenix.protocol.wrappers.WrappedSignedProperty

abstract class SkinData {
    abstract fun toTextureProperty() : WrappedSignedProperty;
}