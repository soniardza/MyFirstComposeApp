package com.soniadevs.myfirstcomposeapp.components.navigation

import com.soniadevs.myfirstcomposeapp.components.navigation.examples.model.SettingModel
import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Detail(val id: String)

@Serializable
data class Settings(val settingModel: SettingModel)
