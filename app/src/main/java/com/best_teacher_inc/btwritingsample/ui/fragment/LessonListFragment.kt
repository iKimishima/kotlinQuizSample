package com.best_teacher_inc.btwritingsample.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.best_teacher_inc.btwritingsample.R

/**
 * Created by kimishima on 2018/03/16.
 */


class LessonListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_lesson_list, container, false)
        return view
    }
}