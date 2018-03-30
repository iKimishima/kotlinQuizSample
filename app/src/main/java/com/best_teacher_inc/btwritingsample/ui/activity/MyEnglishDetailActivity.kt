package com.best_teacher_inc.btwritingsample.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.best_teacher_inc.btwritingsample.R
import kotlinx.android.synthetic.main.activity_my_english.*

class MyEnglishDetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_LESSON_ID = "lesson_id"

        fun newIntent(context: Context, id: Int): Intent {
            val intent = Intent(context, MyEnglishDetailActivity::class.java)
            intent.putExtra(KEY_LESSON_ID, id)
            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_english)
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
    }
}