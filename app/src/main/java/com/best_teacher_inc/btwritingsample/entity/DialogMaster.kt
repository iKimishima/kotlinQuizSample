package com.best_teacher_inc.btwritingsample.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by kimishima on 2018/03/26.
 */

data class DialogMaster (

    @SerializedName("id")
    val id: Long,

    @SerializedName("japaneseTitle")
    val japaneseTitle: String,

    @SerializedName("bot")
    val bot: String,

    @SerializedName("image")
    val image: String
)