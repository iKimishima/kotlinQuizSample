package com.best_teacher_inc.btwritingsample.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by kimishima on 2018/03/27.
 */
data class User (
    @SerializedName("id")
    val id: Long, //non-null

    @SerializedName("user_id")
    val userId: Long,

    @SerializedName("dialog_id")
    val dialogId: Long,

    @SerializedName("high_score")
    val highScore: Long
)