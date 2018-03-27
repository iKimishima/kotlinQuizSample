package com.best_teacher_inc.btwritingsample.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by kimishima on 2018/03/27.
 */

data class HighScore(
        @SerializedName("id")
        var id: Long,

        @SerializedName("user_id")
        var userId: Long,

        @SerializedName("dialog_id")
        var dialogId: Long,

        @SerializedName("high_score")
        var highScore: Long
)