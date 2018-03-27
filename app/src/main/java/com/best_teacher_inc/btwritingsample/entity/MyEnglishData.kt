package com.best_teacher_inc.btwritingsample.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by kimishima on 2018/03/26.
 */

data class MyEnglishData(
        @SerializedName("id")
        val id: Long, //non-null

        @SerializedName("createdAt")
        val createdAt: String, //non-null

        @SerializedName("updatedAt")
        val upDatedAt: String, //non-null

        @SerializedName("correctionDoneAt")
        val correctionDoneAt: String,//non-null

        @SerializedName("dialogMaster")
        val dialogMaster: DialogMaster, //non-null

        @SerializedName("user")
        var user: User,

        @SerializedName("phrase")
        var phrase: Phrase,

        @SerializedName("highScore")
        var highScore: HighScore
)
