package com.best_teacher_inc.btwritingsample.ui.activity

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.best_teacher_inc.btwritingsample.R
import com.best_teacher_inc.btwritingsample.entity.StepOneData
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_step_one.*

/**
 * Created by kimishima on 2018/03/23.
 */

class StepOneActivity : AppCompatActivity() {

    private lateinit var questionData: List<StepOneData>
    private var lessonCount = 0
    private var collectCount = 0

    companion object {
        const val KEY_LESSON_ID = "lesson_id"

        fun newIntent(context: Context, id: Int): Intent {
            val intent = Intent(context, StepOneActivity::class.java)
            intent.putExtra(KEY_LESSON_ID, id)
            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step_one)
        setupView()
        setupListener()


    }

    fun setupView() {
        //TODO 問題文の表示
        val gson = GsonBuilder().setPrettyPrinting().create()
        questionData = gson.fromJson(questions, object : TypeToken<List<StepOneData>>() {}.type)
        setQuestions()


    }

    fun setupListener() {
        toolbar.setOnClickListener { finish() }

        button1.setOnClickListener { checkAnswer(button1.text.toString()) }
        button2.setOnClickListener { checkAnswer(button2.text.toString()) }
        button3.setOnClickListener { checkAnswer(button3.text.toString()) }
        button4.setOnClickListener { checkAnswer(button4.text.toString()) }

    }

    fun setQuestions() {
        var lessonCountText = lessonCount + 1
        textViewQuestionCount.text = "第" + lessonCountText + "問／10問中"
        var data = questionData!![lessonCount]

        textViewQuestion.text = data.question
        textViewQuestionJapanese.text = data.japanese
        button1.text = data.select1
        button2.text = data.select2
        button3.text = data.select3
        button4.text = data.select4

    }

    fun checkAnswer(ans: String) {

        if (ans.equals(questionData[lessonCount].answer)) {
            collectCount++
            //TODO 正解モーダル表示
            showAlertDialog(true)
        } else {
            //TODO 不正解モーダル非表示
            showAlertDialog(false)
        }
    }

    fun showAlertDialog(isCorrect: Boolean) {

        var title = if (isCorrect) "正解" else "不正解"
        var explanation = questionData[lessonCount].explanation
        // ダイアログを作成して表示
        AlertDialog.Builder(this).apply {
            setTitle(title)
            setMessage(explanation)
            setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
                // OKをタップしたときの処理
                if (lessonCount + 1 >= 10) {
                    //TODO 結果画面に遷移
                    segueResultActivity()
                } else {
                    lessonCount++
                    setQuestions()
                }

            })
            show()
        }
    }

    fun segueResultActivity() {
        startActivity(LessonResultActivity.newIntent(this, collectCount))
        finish()
    }


    val questions =
            "[" +
                    "{" +
                    "'id': 1," +
                    "'question': '( ) am a student.'," +
                    "'japanese': '(私は学生です。)'," +
                    "'select1': 'I'," +
                    "'select2':'You'," +
                    "'select3':'He'," +
                    "'select4':'She'," +
                    "'answer':'I'," +
                    "'explanation':'動詞がamだから、amに対応するのはI よ。'" +
                    "}," +
                    "{" +
                    "'id': 2," +
                    "'question': 'I (    ) like natto.'," +
                    "'japanese': '(私は納豆が好きではありません。)'," +
                    "'select1': 'is not'," +
                    "'select2':'do not'," +
                    "'select3':'did not'," +
                    "'select4':'will not'," +
                    "'answer':'do not'," +
                    "'explanation':'「好き」は動詞なのでdoを使用。「do not ~」で「~ではない」ということ'" +
                    "}," +
                    "{" +
                    "'id': 3," +
                    "'question': '( ) she play soccer? '," +
                    "'japanese': '(彼女はサッカーをしますか。)'," +
                    "'select1': 'Can'," +
                    "'select2':'Is'," +
                    "'select3':'Do'," +
                    "'select4':'Does'," +
                    "'answer':'Does'," +
                    "'explanation':'playという動詞が入っているのでdoかと思いきや、sheなので3単現に従ってdoesが正解。'" +
                    "}," +
                    "{" +
                    "'id': 4," +
                    "'question': '( ) am a student.'," +
                    "'japanese': '(私は学生です。)'," +
                    "'select1': 'I'," +
                    "'select2':'You'," +
                    "'select3':'He'," +
                    "'select4':'She'," +
                    "'answer':'I'," +
                    "'explanation':'動詞がamだから、amに対応するのはI よ。'" +
                    "}," +
                    "{" +
                    "'id': 5," +
                    "'question': 'I (    ) like natto.'," +
                    "'japanese': '(私は納豆が好きではありません。)'," +
                    "'select1': 'is not'," +
                    "'select2':'do not'," +
                    "'select3':'did not'," +
                    "'select4':'will not'," +
                    "'answer':'do not'," +
                    "'explanation':'「好き」は動詞なのでdoを使用。「do not ~」で「~ではない」ということ'" +
                    "}," +
                    "{" +
                    "'id': 6," +
                    "'question': '( ) am a student.'," +
                    "'japanese': '(私は学生です。)'," +
                    "'select1': 'I'," +
                    "'select2':'You'," +
                    "'select3':'He'," +
                    "'select4':'She'," +
                    "'answer':'I'," +
                    "'explanation':'動詞がamだから、amに対応するのはI よ。'" +
                    "}," +
                    "{" +
                    "'id': 7," +
                    "'question': 'I (    ) like natto.'," +
                    "'japanese': '(私は納豆が好きではありません。)'," +
                    "'select1': 'is not'," +
                    "'select2':'do not'," +
                    "'select3':'did not'," +
                    "'select4':'will not'," +
                    "'answer':'do not'," +
                    "'explanation':'「好き」は動詞なのでdoを使用。「do not ~」で「~ではない」ということ'" +
                    "}," +
                    "{" +
                    "'id': 8," +
                    "'question': '( ) am a student.'," +
                    "'japanese': '(私は学生です。)'," +
                    "'select1': 'I'," +
                    "'select2':'You'," +
                    "'select3':'He'," +
                    "'select4':'She'," +
                    "'answer':'I'," +
                    "'explanation':'動詞がamだから、amに対応するのはI よ。'" +
                    "}," +
                    "{" +
                    "'id': 9," +
                    "'question': 'I (    ) like natto.'," +
                    "'japanese': '(私は納豆が好きではありません。)'," +
                    "'select1': 'is not'," +
                    "'select2':'do not'," +
                    "'select3':'did not'," +
                    "'select4':'will not'," +
                    "'answer':'do not'," +
                    "'explanation':'「好き」は動詞なのでdoを使用。「do not ~」で「~ではない」ということ'" +
                    "}," +
                    "{" +
                    "'id': 10," +
                    "'question': '( ) she play soccer? '," +
                    "'japanese': '(彼女はサッカーをしますか。)'," +
                    "'select1': 'Can'," +
                    "'select2':'Is'," +
                    "'select3':'Do'," +
                    "'select4':'Does'," +
                    "'answer':'Does'," +
                    "'explanation':'playという動詞が入っているのでdoかと思いきや、sheなので3単現に従ってdoesが正解。'" +
                    "}" +
                    "]"
}