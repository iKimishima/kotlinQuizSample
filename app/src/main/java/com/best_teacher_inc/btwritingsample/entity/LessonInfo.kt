package com.best_teacher_inc.btwritingsample.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by kimishima on 2018/03/20.
 */

data class LessonInfo (
    @SerializedName("id")
    val id: Long, //non-null

    @SerializedName("title")
    val title: String, //non-null

    @SerializedName("detail")
    val detail: String, //non-null

    @SerializedName("star")
    val star: Long,//non-null

    @SerializedName("lock")
    val isLocked: Boolean //non-null
)
