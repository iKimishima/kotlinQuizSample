package com.best_teacher_inc.btwritingsample.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.best_teacher_inc.btwritingsample.R
import com.best_teacher_inc.btwritingsample.entity.LessonInfo
import com.best_teacher_inc.btwritingsample.entity.MyEnglishData
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.list_item_my_english.view.*

/**
 * Created by kimishima on 2018/03/26.
 */

class MyEnglishAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var dataset : List<MyEnglishData>

    private var context: Context? = null
    var onItemClicked: ((item: MyEnglishData, position: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    //    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val inflater = LayoutInflater.from(parent.context)
        context = parent.context
        val view = inflater.inflate(R.layout.list_item_my_english, parent, false)
        return ItemView(view)
    }

    override fun getItemCount(): Int {
  //      TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return dataset!!.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        if (holder is ItemView) {
            val item = dataset!![position]
            holder.itemView.textViewTitle.text = item.dialogMaster.japaneseTitle
            holder.itemView.textViewQuestion.text = item.dialogMaster.bot
            holder.itemView.textViewAnswer.text = item.phrase.correctedContent
            holder.itemView.buttonReview.setOnClickListener {onItemClicked?.invoke(item, position) }
            holder.itemView.buttonSortPhrases.setOnClickListener {onItemClicked?.invoke(item, position) }

        }
    }
    override fun getItemViewType(position: Int): Int {
//        return if (position == masters.size) {
//            VIEW_TYPE_FOOTER
//        } else VIEW_TYPE_ITEM
        return VIEW_TYPE_ITEM
    }

    fun setMasters() {
        //Moshiでパーズすることを検討したがうまく動かなかった。
        val gson = GsonBuilder().setPrettyPrinting().create()
        dataset = gson.fromJson(myEnglishJson, object : TypeToken<List<MyEnglishData>>() {}.type)
        notifyDataSetChanged()
    }


    internal inner class ItemView(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    companion object {
        private val VIEW_TYPE_ITEM = 1
        private val VIEW_TYPE_FOOTER = 2
    }

    val myEnglishJson  ="[" +
            "{" +
            "\"id\": 7694," +
            "\"createdAt\": \"2013-03-20T17:47:00.322+09:00\"," +
            "\"updatedAt\": \"2017-05-24T20:26:24.669+09:00\"," +
            "\"private\": true," +
            "\"correctionDoneAt\": \"2013-03-20T19:19:12.000+09:00\"," +
            "\"sharedAt\": \"2017-04-12T10:00:46.893+09:00\"," +
            "\"selfStudyClosed?\": true," +
            "\"sharedLessonId\": 7694," +
            "\"dialogMaster\": {" +
            "\"id\": 221," +
            "\"japaneseTitle\": \"S(主語)とM(同士)\"," +
            "\"bot\": \"Which do you like, S or M?\"," +
            "\"image\": \"http://s3.amazonaws.com/test-best-teacher/image/dialog_master/image/221/original.jpg\"" +
            "}," +
            "\"user\": {" +
            "\"id\": 2," +
            "\"firstName\": \"Sachiko\"," +
            "\"lastName\": \"Tanaka\"," +
            "\"photo\": \"http://s3.amazonaws.com/test-best-teacher/user/img/2/original.png?1490864246\"" +
            "}," +
            "\"phrase\": {" +
            "\"id\": 58848," +
            "\"content\": \"If i had to choose one, I am S.\"," +
            "\"reviewedContent\": \"<p><span style=\\\"color: #8a9299; font-family: 'ヒラギノ角ゴ Pro W3', 'Hiragino Kaku Gothic Pro', メイリオ, Meiryo, 'ＭＳ Ｐゴシック', 'Helvetica Neue', Arial, sans-serif; font-size: 12px; letter-spacing: 1px; line-height: 15.59375px; -webkit-text-size-adjust: none;\\\">I often cook pasta. It's easy and delicious! (great, you may also say \\\"I<span style=\\\"text-decoration: underline;\\\"> usually</span> cook pasta...\\\")</span></p>\"," +
            "\"correctedContent\": \"If i had to choose one, I am S.\"," +
            "\"voiceUrl\": \"user/original/missing.mp3\"" +
            "}," +
            "\"highScore\": {" +
            "\"id\": 2," +
            "\"user_id\": 2," +
            "\"dialog_id\": 7694," +
            "\"high_score\": 9999" +
            "}" +
            "}," +
            "{" +
            "\"id\": 7694," +
            "\"createdAt\": \"2013-03-20T17:47:00.322+09:00\"," +
            "\"updatedAt\": \"2017-05-24T20:26:24.669+09:00\"," +
            "\"private\": true," +
            "\"correctionDoneAt\": \"2013-03-20T19:19:12.000+09:00\"," +
            "\"sharedAt\": \"2017-04-12T10:00:46.893+09:00\"," +
            "\"selfStudyClosed?\": true," +
            "\"sharedLessonId\": 7694," +
            "\"dialogMaster\": {" +
            "\"id\": 221," +
            "\"japaneseTitle\": \"S(主語)とM(同士)\"," +
            "\"bot\": \"Which do you like, S or M?\"," +
            "\"image\": \"http://s3.amazonaws.com/test-best-teacher/image/dialog_master/image/221/original.jpg\"" +
            "}," +
            "\"user\": {" +
            "\"id\": 2," +
            "\"firstName\": \"Sachiko\"," +
            "\"lastName\": \"Tanaka\"," +
            "\"photo\": \"http://s3.amazonaws.com/test-best-teacher/user/img/2/original.png?1490864246\"" +
            "}," +
            "\"phrase\": {" +
            "\"id\": 58848," +
            "\"content\": \"If i had to choose one, I am S.\"," +
            "\"reviewedContent\": \"<p><span style=\\\"color: #8a9299; font-family: 'ヒラギノ角ゴ Pro W3', 'Hiragino Kaku Gothic Pro', メイリオ, Meiryo, 'ＭＳ Ｐゴシック', 'Helvetica Neue', Arial, sans-serif; font-size: 12px; letter-spacing: 1px; line-height: 15.59375px; -webkit-text-size-adjust: none;\\\">I often cook pasta. It's easy and delicious! (great, you may also say \\\"I<span style=\\\"text-decoration: underline;\\\"> usually</span> cook pasta...\\\")</span></p>\"," +
            "\"correctedContent\": \"If i had to choose one, I am S.\"," +
            "\"voiceUrl\": \"user/original/missing.mp3\"" +
            "}," +
            "\"highScore\": {" +
            "\"id\": 2," +
            "\"user_id\": 2," +
            "\"dialog_id\": 7694," +
            "\"high_score\": 9999" +
            "}" +
            "}," +
            "{" +
            "\"id\": 7694," +
            "\"createdAt\": \"2013-03-20T17:47:00.322+09:00\"," +
            "\"updatedAt\": \"2017-05-24T20:26:24.669+09:00\"," +
            "\"private\": true," +
            "\"correctionDoneAt\": \"2013-03-20T19:19:12.000+09:00\"," +
            "\"sharedAt\": \"2017-04-12T10:00:46.893+09:00\"," +
            "\"selfStudyClosed?\": true," +
            "\"sharedLessonId\": 7694," +
            "\"dialogMaster\": {" +
            "\"id\": 221," +
            "\"japaneseTitle\": \"S(主語)とM(同士)\"," +
            "\"bot\": \"Which do you like, S or M?\"," +
            "\"image\": \"http://s3.amazonaws.com/test-best-teacher/image/dialog_master/image/221/original.jpg\"" +
            "}," +
            "\"user\": {" +
            "\"id\": 2," +
            "\"firstName\": \"Sachiko\"," +
            "\"lastName\": \"Tanaka\"," +
            "\"photo\": \"http://s3.amazonaws.com/test-best-teacher/user/img/2/original.png?1490864246\"" +
            "}," +
            "\"phrase\": {" +
            "\"id\": 58848," +
            "\"content\": \"If i had to choose one, I am S.\"," +
            "\"reviewedContent\": \"<p><span style=\\\"color: #8a9299; font-family: 'ヒラギノ角ゴ Pro W3', 'Hiragino Kaku Gothic Pro', メイリオ, Meiryo, 'ＭＳ Ｐゴシック', 'Helvetica Neue', Arial, sans-serif; font-size: 12px; letter-spacing: 1px; line-height: 15.59375px; -webkit-text-size-adjust: none;\\\">I often cook pasta. It's easy and delicious! (great, you may also say \\\"I<span style=\\\"text-decoration: underline;\\\"> usually</span> cook pasta...\\\")</span></p>\"," +
            "\"correctedContent\": \"If i had to choose one, I am S.\"," +
            "\"voiceUrl\": \"user/original/missing.mp3\"" +
            "}," +
            "\"highScore\": {" +
            "\"id\": 2," +
            "\"user_id\": 2," +
            "\"dialog_id\": 7694," +
            "\"high_score\": 9999" +
            "}" +
            "}," +
            "{" +
            "\"id\": 7694," +
            "\"createdAt\": \"2013-03-20T17:47:00.322+09:00\"," +
            "\"updatedAt\": \"2017-05-24T20:26:24.669+09:00\"," +
            "\"private\": true," +
            "\"correctionDoneAt\": \"2013-03-20T19:19:12.000+09:00\"," +
            "\"sharedAt\": \"2017-04-12T10:00:46.893+09:00\"," +
            "\"selfStudyClosed?\": true," +
            "\"sharedLessonId\": 7694," +
            "\"dialogMaster\": {" +
            "\"id\": 221," +
            "\"japaneseTitle\": \"S(主語)とM(同士)\"," +
            "\"bot\": \"Which do you like, S or M?\"," +
            "\"image\": \"http://s3.amazonaws.com/test-best-teacher/image/dialog_master/image/221/original.jpg\"" +
            "}," +
            "\"user\": {" +
            "\"id\": 2," +
            "\"firstName\": \"Sachiko\"," +
            "\"lastName\": \"Tanaka\"," +
            "\"photo\": \"http://s3.amazonaws.com/test-best-teacher/user/img/2/original.png?1490864246\"" +
            "}," +
            "\"phrase\": {" +
            "\"id\": 58848," +
            "\"content\": \"If i had to choose one, I am S.\"," +
            "\"reviewedContent\": \"<p><span style=\\\"color: #8a9299; font-family: 'ヒラギノ角ゴ Pro W3', 'Hiragino Kaku Gothic Pro', メイリオ, Meiryo, 'ＭＳ Ｐゴシック', 'Helvetica Neue', Arial, sans-serif; font-size: 12px; letter-spacing: 1px; line-height: 15.59375px; -webkit-text-size-adjust: none;\\\">I often cook pasta. It's easy and delicious! (great, you may also say \\\"I<span style=\\\"text-decoration: underline;\\\"> usually</span> cook pasta...\\\")</span></p>\"," +
            "\"correctedContent\": \"If i had to choose one, I am S.\"," +
            "\"voiceUrl\": \"user/original/missing.mp3\"" +
            "}," +
            "\"highScore\": {" +
            "\"id\": 2," +
            "\"user_id\": 2," +
            "\"dialog_id\": 7694," +
            "\"high_score\": 9999" +
            "}" +
            "}," +
            "{" +
            "\"id\": 7694," +
            "\"createdAt\": \"2013-03-20T17:47:00.322+09:00\"," +
            "\"updatedAt\": \"2017-05-24T20:26:24.669+09:00\"," +
            "\"private\": true," +
            "\"correctionDoneAt\": \"2013-03-24T19:19:12.000+09:00\"," +
            "\"sharedAt\": \"2017-04-12T10:00:46.893+09:00\"," +
            "\"selfStudyClosed?\": true," +
            "\"sharedLessonId\": 7694," +
            "\"dialogMaster\": {" +
            "\"id\": 221," +
            "\"japaneseTitle\": \"人称\"," +
            "\"bot\": \"Please tell me your father.\"," +
            "\"image\": \"http://s3.amazonaws.com/test-best-teacher/image/dialog_master/image/221/original.jpg\"" +
            "}," +
            "\"user\": {" +
            "\"id\": 2," +
            "\"firstName\": \"Taro\"," +
            "\"lastName\": \"User\"," +
            "\"photo\": \"http://s3.amazonaws.com/test-best-teacher/user/img/2/original.png?1490864246\"" +
            "}," +
            "\"phrase\": {" +
            "\"id\": 58848," +
            "\"content\": \"My father works as an engineer. He makes 'Love Doll' at a company called Oriental Industry.\"," +
            "\"reviewedContent\": \"<p><span style=\\\"color: #8a9299; font-family: 'ヒラギノ角ゴ Pro W3', 'Hiragino Kaku Gothic Pro', メイリオ, Meiryo, 'ＭＳ Ｐゴシック', 'Helvetica Neue', Arial, sans-serif; font-size: 12px; letter-spacing: 1px; line-height: 15.59375px; -webkit-text-size-adjust: none;\\\">I often cook pasta. It's easy and delicious! (great, you may also say \\\"I<span style=\\\"text-decoration: underline;\\\"> usually</span> cook pasta...\\\")</span></p>\"," +
            "\"correctedContent\": \"My father works as an engineer. He makes 'Love Doll' at a company called Oriental Industry.\"," +
            "\"voiceUrl\": \"user/original/missing.mp3\"" +
            "}," +
            "\"highScore\": {" +
            "\"id\": 2," +
            "\"user_id\": 2," +
            "\"dialog_id\": 7694," +
            "\"high_score\": 0" +
            "}" +
            "}" +
            "]"

}

