package com.best_teacher_inc.btwritingsample.ui.dialog

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.view.View
import com.best_teacher_inc.btwritingsample.R
import kotlinx.android.synthetic.main.dialog_writing_post.*
import kotlinx.android.synthetic.main.dialog_writing_post.view.*


class WritingPostDialogFragment : DialogFragment() {

    private var listener: Listener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(activity)
        val view = View.inflate(activity, R.layout.dialog_writing_post, null)

        builder.setView(view)
        builder.setCancelable(false)

        val text = arguments.getString(KEY_POST_WRITING)
        view.textViewWritingPost.text = text

        view.buttonPostWriting.setOnClickListener({ v ->
            if (listener != null) {
                listener!!.onPostClicked(text)
                dismiss()
            }
        })

        view.buttonCloseDialog.setOnClickListener({ v -> dismiss() })
        view.buttonFixWriting.setOnClickListener({ v -> dismiss() })

        return builder.create()
    }

    override fun onPause() {
        super.onPause()
        dismiss()
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        if (activity is Listener) {
            listener = activity
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface Listener {
        fun onPostClicked(text: String?)
    }

    companion object {
        private val KEY_POST_WRITING = "post_writing"
        private val KEY_WRITING_COUNT = "writing_count"
    }
}