package com.best_teacher_inc.btwritingsample.ui.view

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import android.widget.FrameLayout
import com.best_teacher_inc.btwritingsample.R
import kotlinx.android.synthetic.main.layout_footer_tab_view.view.*


/**
 * Created by kimishima on 2018/03/15.
 */


class FooterTabView @JvmOverloads constructor(context: Context,
                                              attrs: AttributeSet? = null,
                                              defStyleAttr: Int = 0)
    : FrameLayout(context, attrs, defStyleAttr) {

    companion object {
        const val POSITION = "position"
        const val INSTANCE_STATE = "instance_state"
    }

    //タブの
    private var position: Int = 0
    //Tabが押された時のCallback
    var onTabClicked: ((n:Int) -> Unit)? = null

    init {
        inflate(context, R.layout.layout_footer_tab_view, this)
        linearLayoutTab0.setOnClickListener { setPosition(0) }
        linearLayoutTab1.setOnClickListener { setPosition(1) }
        linearLayoutTab2.setOnClickListener { setPosition(2) }
        linearLayoutTab3.setOnClickListener { setPosition(3) }
        updateTabColor(position)
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        if (state is Bundle) {
            position = state.getInt(POSITION)
            updateTabColor(position)
            var pState:Parcelable = state.getParcelable(INSTANCE_STATE)
            super.onRestoreInstanceState(pState)
        } else {
            super.onRestoreInstanceState(state)
        }
    }

    override fun onSaveInstanceState(): Parcelable {
        val bundle = Bundle()
        bundle.putParcelable(INSTANCE_STATE, super.onSaveInstanceState())
        bundle.putInt(POSITION, position)
        return bundle
    }

    fun updateTabColor(position: Int) {
        val accentColor = context.resources.getColor(R.color.material_green);
        imageViewHome.setColorFilter(if (position == 0) Color.WHITE else Color.GRAY)
        imageViewLesson.setColorFilter(if (position == 1) Color.WHITE else Color.GRAY)
        imageViewMyEnglish.setColorFilter(if (position == 2) Color.WHITE else Color.GRAY)
        imageViewSettings.setColorFilter(if (position == 3) Color.WHITE else Color.GRAY)
        textViewHome.setTextColor(if (position == 0) Color.WHITE else Color.GRAY)
        textViewLesson.setTextColor(if (position == 1) Color.WHITE else Color.GRAY)
        textViewMyEnglish.setTextColor(if (position == 2) Color.WHITE else Color.GRAY)
        textViewSettings.setTextColor(if (position == 3) Color.WHITE else Color.GRAY)
        linearLayoutTab0.setBackgroundColor(if (position == 0) accentColor else Color.WHITE)
        linearLayoutTab1.setBackgroundColor(if (position == 1) accentColor else Color.WHITE)
        linearLayoutTab2.setBackgroundColor(if (position == 2) accentColor else Color.WHITE)
        linearLayoutTab3.setBackgroundColor(if (position == 3) accentColor else Color.WHITE)
    }

    fun getPosition(): Int {
        return position
    }

    fun setPosition(position: Int) {
        this.position = position
        updateTabColor(position)
        onTabClicked?.invoke(position)
    }
}

