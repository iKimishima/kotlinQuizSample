package com.best_teacher_inc.btwritingsample.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.best_teacher_inc.btwritingsample.R
import com.best_teacher_inc.btwritingsample.ui.dialog.WritingPostDialogFragment
import kotlinx.android.synthetic.main.activity_step_three.*

/**
 * Created by kimishima on 2018/03/26.
 */

class StepThreeActivity : AppCompatActivity() {

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
        //TOOD　解説モーダルの表示
    }

    fun setupListener() {
        toolbar.setOnClickListener { finish() }
        buttonSendWritingLesson.setOnClickListener { showWritingPostDialog(editTextWritingLesson.text.toString()) }
    }

    private fun showWritingPostDialog(post: String) {
        val args = Bundle()
        args.putString(KEY_POST_WRITING, post)

        val dialogFragment = WritingPostDialogFragment()
        dialogFragment.setArguments(args)
        dialogFragment.show(supportFragmentManager, POST_FRAGMENT_TAG)
    }
}