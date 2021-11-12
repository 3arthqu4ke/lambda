package com.lambda.client.gui.clickgui.component

import com.lambda.client.gui.clickgui.LambdaClickGui
import com.lambda.client.gui.rgui.component.BooleanSlider
import com.lambda.client.util.math.Vec2f

class RemotePluginButton(
    pluginName: String,
    val description: String,
    val authors: String,
    val version: String,
    val downloadUrl: String,
    val fileName: String
) : BooleanSlider(pluginName, 0.0, description) {
    override fun onClick(mousePos: Vec2f, buttonId: Int) {
        super.onClick(mousePos, buttonId)
        if (buttonId == 0) LambdaClickGui.downloadPlugin(this)
    }
}