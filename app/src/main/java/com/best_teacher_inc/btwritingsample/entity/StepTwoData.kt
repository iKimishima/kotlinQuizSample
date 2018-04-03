package com.best_teacher_inc.btwritingsample.entity

import com.google.gson.annotations.SerializedName

data class StepTwoData(
        @SerializedName("id")
        val id: Long, //non-null

        @SerializedName("questionBefore")
        val qBefore: String, //non-null

        @SerializedName("questionAfter")
        val qAfter: String, //non-null

        @SerializedName("japanese")
        val japanese: String, //non-null

        @SerializedName("selectList")
        val selectList: List<String>, //non-null

        @SerializedName("answer")
        val answer: String,//non-null

        @SerializedName("explanation")
        var explanation: String
)

