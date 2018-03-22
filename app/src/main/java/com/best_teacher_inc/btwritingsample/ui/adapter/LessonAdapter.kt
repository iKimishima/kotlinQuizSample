package com.best_teacher_inc.btwritingsample.ui.adapter

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.best_teacher_inc.btwritingsample.R
import com.best_teacher_inc.btwritingsample.entity.LessonInfo
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.list_item_lesson.view.*

/**
 * Created by kimishima on 2018/03/20.
 */

class LessonAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var masters: List<LessonInfo>

    private var context: Context? = null
    private var listener: Listener? = null

    var onItemClicked: ((item: LessonInfo, position:Int) -> Unit)? = null

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

            setStar(item.star.toInt(), holder)
            holder.itemView.linearLayoutLock.visibility = if (item.isLocked) View.VISIBLE else View.GONE
            holder.itemView.LinearLayoutLesson.setOnClickListener {onItemClicked?.invoke(item, position) }
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

    private fun setStar(star: Int, holder: RecyclerView.ViewHolder) {
        //TODO 星のセットInt型はList<Object>に変更予定
        holder.itemView.imageViewStar1.setImageResource(if (star > 0) R.drawable.ic_star_black_24dp else R.drawable.ic_star_border_black_24dp)
        holder.itemView.imageViewStar2.setImageResource(if (star > 1) R.drawable.ic_star_black_24dp else R.drawable.ic_star_border_black_24dp)
        holder.itemView.imageViewStar3.setImageResource(if (star > 2) R.drawable.ic_star_black_24dp else R.drawable.ic_star_border_black_24dp)
        holder.itemView.imageViewStar1.setColorFilter(if (star > 0) Color.YELLOW else Color.BLACK)
        holder.itemView.imageViewStar2.setColorFilter(if (star > 1) Color.YELLOW else Color.BLACK)
        holder.itemView.imageViewStar3.setColorFilter(if (star > 2) Color.YELLOW else Color.BLACK)
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
        fun onItemClicked(item: LessonInfo, index: Int)
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
                    "'star':0," +
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
                    "'star':0," +
                    "'lock':true" +
                    "}," +
                    "{" +
                    "'id': 2," +
                    "'title': 'Lesson5'," +
                    "'detail': '一般動詞(動作・状態)'," +
                    "'star':0," +
                    "'lock':true" +
                    "}," +
                    "{" +
                    "'id': 3," +
                    "'title': 'Lesson6'," +
                    "'detail': '一般動詞(3人称単数)'," +
                    "'star':0," +
                    "'lock':true" +
                    "}" +
                    "]"

}
