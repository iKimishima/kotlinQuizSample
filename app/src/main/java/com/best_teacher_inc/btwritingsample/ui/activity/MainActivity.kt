package com.best_teacher_inc.btwritingsample.ui.activity

import android.content.Context
import android.content.Intent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.best_teacher_inc.btwritingsample.R
import com.best_teacher_inc.btwritingsample.ui.fragment.HomeFragment
import com.best_teacher_inc.btwritingsample.ui.fragment.LessonListFragment
import com.best_teacher_inc.btwritingsample.ui.fragment.MyEnglishListFragment
import com.best_teacher_inc.btwritingsample.ui.fragment.SettingFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val KEY_TAB_POSITION = "tab_position"
        const val KEY_TUTORIAL = "tutorial"
    }

    fun newIntent(context: Context, footerTabPosition: Int): Intent {
        val intent = Intent(context, MainActivity::class.java)
        intent.putExtra(KEY_TAB_POSITION, footerTabPosition)
        return intent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        footerTabView.onTabClicked = this@MainActivity::onTabClicked

        if (savedInstanceState == null) {
            if (intent.hasExtra(KEY_TAB_POSITION)) {
                val position = intent.getIntExtra(KEY_TAB_POSITION, 0)
                footerTabView.setPosition(position)
                onTabClicked(position)
            } else {
                footerTabView.setPosition(0)
                onTabClicked(0)
            }
        }
    }

    //タブが押された際のフラグメントの切り替え
    private fun onTabClicked (position :Int){
        val bundle = Bundle()
        bundle.putBoolean(KEY_TUTORIAL, intent.getBooleanExtra(KEY_TUTORIAL, false))
        supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, createFragment(position))
                .commit()
    }

    //
    private fun createFragment(tabPosition: Int): Fragment {
        return when (tabPosition) {
            0 -> HomeFragment()
            1 -> LessonListFragment()
            2 -> MyEnglishListFragment()
            3 -> SettingFragment()
            else -> HomeFragment()
        }
    }


}
