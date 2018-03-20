package com.best_teacher_inc.btwritingsample.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by kimishima on 2018/03/20.
 */

data class LessonInfo (
    @SerializedName("id")
    var id: Long,

    @SerializedName("title")
    var title: String,

    @SerializedName("detail")
    var detail: String
)
