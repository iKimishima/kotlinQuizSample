package com.best_teacher_inc.btwritingsample.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.best_teacher_inc.btwritingsample.R
import kotlinx.android.synthetic.main.activity_lesson_result.*

class LessonResultActivity : AppCompatActivity() {

    companion object {
        const val KEY_CORRECT_COUNT = "correct_count"

        fun newIntent(context: Context, count: Int): Intent {
            val intent = Intent(context, LessonResultActivity::class.java)
            intent.putExtra(KEY_CORRECT_COUNT, count)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle? ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_result)
        setupView()
        setupListener()
    }

    fun setupView() {
        val correctCount = intent.getIntExtra(KEY_CORRECT_COUNT, 0)
        textViewCorrectCount.text = getString(R.string.correct_count, correctCount)
        when (correctCount) {
            10 -> {
                textViewBettyComment.text = "すごいじゃない！この調子で頑張ってね。"
                imageViewBettyResult.setImageResource(R.drawable.betty_happy_clear)
            }
            9,8 -> {
                textViewBettyComment.text = "へぇ、結構やるじゃない。"
                imageViewBettyResult.setImageResource(R.drawable.betty_amazed_clear)
            }
            7,6 -> {
                textViewBettyComment.text = "まぁまぁってとこね"
                imageViewBettyResult.setImageResource(R.drawable.betty_scorn_clear)
            }
            5,4,3 -> {
                textViewBettyComment.text = "ちょっとヤバイかも..."
                imageViewBettyResult.setImageResource(R.drawable.betty_confused_clear)
            }
            else -> {
                textViewBettyComment.text = "マジメにや・れ。"
                imageViewBettyResult.setImageResource(R.drawable.betty_smile_angry)
            }
        }


    }

    fun setupListener() {
        toolbar.setNavigationOnClickListener { finish() }
        buttonCloseResult.setOnClickListener { finish() }
    }


}