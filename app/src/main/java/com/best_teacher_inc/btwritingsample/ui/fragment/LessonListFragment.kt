package com.best_teacher_inc.btwritingsample.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.best_teacher_inc.btwritingsample.R
import com.best_teacher_inc.btwritingsample.ui.adapter.LessonAdapter
import kotlinx.android.synthetic.main.fragment_lesson_list.*

/**
 * Created by kimishima on 2018/03/16.
 */


class LessonListFragment : Fragment() {
    private var adapter: LessonAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_lesson_list, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        setupView()
        setupListeners()
    }

    private fun setupView() {
        adapter = LessonAdapter()
        val manager = LinearLayoutManager(activity)
        recyclerView.layoutManager = manager
        recyclerView.isNestedScrollingEnabled = false
        recyclerView.adapter = adapter
    }

    private fun setupListeners() {
        this.adapter!!.setMasters()
    }


}