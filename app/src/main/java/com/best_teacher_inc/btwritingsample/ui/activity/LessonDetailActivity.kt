package com.best_teacher_inc.btwritingsample.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.best_teacher_inc.btwritingsample.R
import kotlinx.android.synthetic.main.activity_lesson_detail.*

/**
 * Created by kimishima on 2018/03/22.
 */

class LessonDetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_LESSON_ID = "lesson_id"

        fun newIntent(context: Context, id: Int): Intent {
            val intent = Intent(context, LessonDetailActivity::class.java)
            intent.putExtra(KEY_LESSON_ID, id)
            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_detail)
        setupView()
        setupListener()

    }

    fun setupView() {
        //TODO 解説文の表示
        //TOOD
    }

    fun setupListener() {
        toolbar.setNavigationOnClickListener {
            finish()
        }


        buttonStep1.setOnClickListener {
            startActivity(StepOneActivity.newIntent(this, intent.getIntExtra(KEY_LESSON_ID, 1)))
        }
        buttonStep2.setOnClickListener {
            startActivity(StepTwoActivity.newIntent(this, intent.getIntExtra(KEY_LESSON_ID, 1)))
        }
        buttonStep3.setOnClickListener {

        }
    }

}