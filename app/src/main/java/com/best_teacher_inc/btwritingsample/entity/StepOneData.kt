package com.best_teacher_inc.btwritingsample.entity

import com.google.gson.annotations.SerializedName

data class StepOneData(
        @SerializedName("id")
        val id: Long, //non-null

        @SerializedName("question")
        val question: String, //non-null

        @SerializedName("japanese")
        val japanese: String, //non-null

        @SerializedName("select1")
        val select1: String, //non-null

        @SerializedName("select2")
        val select2: String,//non-null

        @SerializedName("select3")
        val select3: String, //non-null

        @SerializedName("select4")
        var select4: String,

        @SerializedName("answer")
        var answer: String,

        @SerializedName("explanation")
        var explanation: String
)