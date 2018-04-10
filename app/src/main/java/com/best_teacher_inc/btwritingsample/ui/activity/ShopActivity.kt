package com.best_teacher_inc.btwritingsample.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.best_teacher_inc.btwritingsample.R


class ShopActivity : AppCompatActivity() {

    companion object {
        const val KEY_LESSON_ID = "lesson_id"
        const val POST_FRAGMENT_TAG = "WritingPostDialogFragment"
        const val KEY_POST_WRITING = "post_writing"

        fun newIntent(context: Context, id: Int): Intent {
            val intent = Intent(context, StepThreeActivity::class.java)
            intent.putExtra(KEY_LESSON_ID, id)
            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step_three)
        setupView()
        setupListener()
    }

    fun setupView() {
        //TODO 問題文の表示
    }

    fun setupListener() {
//        toolbar.setOnClickListener { finish() }
    }

    private fun showWritingPostDialog(post: String) {
        val args = Bundle()
        args.putString(KEY_POST_WRITING, post)
    }
}