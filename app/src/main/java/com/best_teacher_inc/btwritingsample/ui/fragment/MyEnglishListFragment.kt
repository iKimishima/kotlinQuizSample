package com.best_teacher_inc.btwritingsample.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.best_teacher_inc.btwritingsample.R
import com.best_teacher_inc.btwritingsample.entity.MyEnglishData
import com.best_teacher_inc.btwritingsample.ui.adapter.MyEnglishAdapter
import kotlinx.android.synthetic.main.fragment_my_english_list.*

/**
 * Created by kimishima on 2018/03/19.
 */


class MyEnglishListFragment : Fragment() {

    private var adapter: MyEnglishAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_my_english_list, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        setupView()
        setupListeners()
    }

    private fun setupView() {
        adapter = MyEnglishAdapter()
        val manager = LinearLayoutManager(activity)
        recyclerView.layoutManager = manager
        recyclerView.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.HORIZONTAL))
        recyclerView.isNestedScrollingEnabled = false
        recyclerView.adapter = adapter
    }

    private fun setupListeners() {
        //TODO
        this.adapter!!.setMasters()
        this.adapter!!.onItemClicked = { item: MyEnglishData, position: Int -> this.onItemClicked(item, position) }
    }

    //TODO
    private fun onItemClicked(item: MyEnglishData, position: Int) {
        Toast.makeText(activity, "復習すっぞ" + position.toString(), Toast.LENGTH_SHORT).show()
    }
}