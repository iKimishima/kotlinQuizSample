package com.best_teacher_inc.btwritingsample.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.best_teacher_inc.btwritingsample.R
import com.best_teacher_inc.btwritingsample.entity.LessonInfo
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.list_item_lesson.*
import kotlinx.android.synthetic.main.list_item_lesson.view.*
import java.lang.reflect.Type

import java.util.ArrayList

/**
 * Created by kimishima on 2018/03/20.
 */

class LessonAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var masters: List<LessonInfo>

    private var context: Context? = null
    private var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        context = parent.context

//        if (viewType == VIEW_TYPE_ITEM) {
        val view = inflater.inflate(R.layout.list_item_lesson, parent, false)
        return ItemView(view)
//        }
//        val view = LayoutInflater.from(parent.context)
//                .inflate(R.layout.list_item_footer, parent, false)
//        return FooterView(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is ItemView) {
            val item = masters!![position]

            holder.itemView.textViewTitle.text = item.title
            holder.itemView.textViewLessonDetail.text = item.detail

            

//            LinearLayoutWritingLesson.setOnClickListener({ v ->
//                if (listener != null) {
//                    listener!!.onItemClicked(item, position)
//                }
//            })

        }
    }

    override fun getItemViewType(position: Int): Int {
//        return if (position == masters.size) {
//            VIEW_TYPE_FOOTER
//        } else VIEW_TYPE_ITEM
        return VIEW_TYPE_ITEM
    }

    override fun getItemCount(): Int {
        return masters!!.size
        //TODO FOOTERをつける場合は+1
    }

    fun setMasters() {

        //Moshiでパーズすることを検討したがうまく動かなかった。
        val gson =GsonBuilder().setPrettyPrinting().create()
        masters = gson.fromJson(lessonInfoJson, object : TypeToken<List<LessonInfo>>() {}.type)
//        masters.clear()
//        masters.addAll(items)
        notifyDataSetChanged()
    }

    interface Listener {
//        fun onItemClicked(item: LessonInfo, index: Int)
    }

    fun setListener(listener: Listener) {
        this.listener = listener
    }


    internal inner class ItemView(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        val binding: ListItemNewLessonBinding
//
//        init {
//            this.binding = DataBindingUtil.bind(itemView)
//        }
    }

    internal inner class FooterView(itemView: View) : RecyclerView.ViewHolder(itemView)

    companion object {

        private val VIEW_TYPE_ITEM = 1
        private val VIEW_TYPE_FOOTER = 2
    }


    val lessonInfoJson =
            "[" +
                    "{" +
                    "'id': 1," +
                    "'title': 'Lesson1'," +
                    "'detail': 'S(主語)とV(動詞)'," +
                    "'star':2," +
                    "'lock':false" +
                    "}," +
                    "{" +
                    "'id': 2," +
                    "'title': 'Lesson2'," +
                    "'detail': '人称'," +
                    "'star':3," +
                    "'lock':false" +
                    "}," +
                    "{" +
                    "'id': 3," +
                    "'title': 'Lesson5'," +
                    "'detail': 'be動詞:肯定文'," +
                    "'star':1," +
                    "'lock':false" +
                    "}," +
                    "{" +
                    "'id': 1," +
                    "'title': 'Lesson4'," +
                    "'detail': 'be動詞:否定文と疑問文'," +
                    "'star':2," +
                    "'lock':false" +
                    "}," +
                    "{" +
                    "'id': 2," +
                    "'title': 'Lesson5'," +
                    "'detail': '一般動詞(動作・状態)'," +
                    "'star':3," +
                    "'lock':false" +
                    "}," +
                    "{" +
                    "'id': 3," +
                    "'title': 'Lesson6'," +
                    "'detail': '一般動詞(3人称単数)'," +
                    "'star':1," +
                    "'lock':false" +
                    "}" +
                    "]"

}
