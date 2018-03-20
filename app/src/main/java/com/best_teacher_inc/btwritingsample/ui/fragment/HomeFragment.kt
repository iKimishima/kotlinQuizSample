package com.best_teacher_inc.btwritingsample.ui.fragment

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.best_teacher_inc.btwritingsample.R
import android.widget.CalendarView
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*


/**
 * Created by kimishima on 2018/03/16.
 */
class HomeFragment : Fragment() {


    private var achieveMax = 0
    private var context = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        setupView()
        setupListeners()
    }



    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        //TODO
//        context = activity as Nothing?
    }

    override fun onDetach() {
        super.onDetach()
//        context = null
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun setupView() {
        calenderViewSetting()
    }

    private fun setupListeners() {
        buttonCalender.setOnClickListener {
            calendar.visibility = View.VISIBLE
            graphView.visibility = View.GONE
        }
        buttonGraph.setOnClickListener {
            calendar.visibility = View.GONE
            graphView.visibility = View.VISIBLE
        }
    }

    private fun calenderViewSetting() {
        val calendarView = CalendarView(activity)
        calendarView.findViewById<CalendarView>(R.id.calendar)
        //現在の日付を取得する
        val selectedCalendar = Calendar.getInstance()
        val selectedTimeInMills = selectedCalendar.getTimeInMillis()
        //選択日付を指定します
        calendarView.date = selectedTimeInMills

        val minCalendar = Calendar.getInstance()
        minCalendar.add(Calendar.MONTH, -1)
        val minTimeInMills = minCalendar.timeInMillis
        // 遡れる制限を1か月前に制限する。
        calendarView.minDate = minTimeInMills

        // 一ヶ月後のUNIX時間を作成する。
        val maxCalendar = Calendar.getInstance()
        maxCalendar.add(Calendar.MONTH, 1)
        val maxTimeInMills = maxCalendar.timeInMillis
        // 遡れる制限を1か月前に制限する。
        calendarView.maxDate = maxTimeInMills

        // 日付文字のスタイルを変更する
        calendarView.setDateTextAppearance(android.R.style.TextAppearance_DeviceDefault_Large);

        //1秒後に処理を行う
        calendarView.postDelayed({
            val selectedCalendar = Calendar.getInstance()
            //2か月後の日付を作成する
            selectedCalendar.add(Calendar.MONTH, 2)
            val selectedTimeInMills = selectedCalendar.getTimeInMillis()
            /**
             * 選択日付を指定する
             * ・第1引数 : 選択する日付
             * ・第2引数 : trueの場合はスクロールアニメーションをつけて日付が変更される。
             * falseの場合は即座に変更される。
             * ・第3引数 : trueの場合は画面中央に持ってくる。
             * falseの場合は選択された日付が画面上にある時はスクロールしない。
             */
            calendarView.setDate(selectedTimeInMills, true, true)
        }, 1000)
    }
}
