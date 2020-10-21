package com.github.shatteredsuite.shatteredplugin.skin

import com.github.shatteredsuite.core.util.Identified
import com.google.gson.annotations.SerializedName
import java.io.File

data class SkinFragment(@SerializedName("type") val fragmentType: FragmentType,
                        override val id: String, val path: String, val name: String,
                        val thin: Boolean) : Identified {
    val file: File = File(path)
}