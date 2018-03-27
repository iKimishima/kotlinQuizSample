package com.best_teacher_inc.btwritingsample.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by kimishima on 2018/03/27.
 */
data class Phrase(
        @SerializedName("id")
        var id: Long,

        @SerializedName("correctedContent")
        var correctedContent: String,

        @SerializedName("voiceUrl")
        var voiceUrl: String

)

