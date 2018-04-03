package com.best_teacher_inc.btwritingsample.ui.activity

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.best_teacher_inc.btwritingsample.R
import com.best_teacher_inc.btwritingsample.entity.StepTwoData
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_step_two.*

/**
 * Created by kimishima on 2018/03/23.
 */

class StepTwoActivity : AppCompatActivity() {

    private lateinit var questionData: List<StepTwoData>
    private var lessonCount = 0
    private var collectCount = 0

    companion object {
        const val KEY_LESSON_ID = "lesson_id"

        fun newIntent(context: Context, id: Int): Intent {
            val intent = Intent(context, StepTwoActivity::class.java)
            intent.putExtra(KEY_LESSON_ID, id)
            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step_two)
        setupView()
        setupListener()
    }

    fun setupView() {
        //TODO 問題文の表示
        val gson = GsonBuilder().setPrettyPrinting().create()
        questionData = gson.fromJson(questions, object : TypeToken<List<StepTwoData>>() {}.type)
        setQuestions()

    }

    fun setupListener() {
        toolbar.setOnClickListener { finish() }

        button1.setOnClickListener { setText(button1.text.toString()) }
        button2.setOnClickListener { setText(button2.text.toString()) }
        button3.setOnClickListener { setText(button3.text.toString()) }
        button4.setOnClickListener { setText(button4.text.toString()) }
        button5.setOnClickListener { setText(button5.text.toString()) }
        button6.setOnClickListener { setText(button6.text.toString()) }

        buttonDecide.setOnClickListener { checkAnswer() }
        imageViewBackSpace.setOnClickListener { removeWord() }
    }


    fun setQuestions() {
        resetAns()
        var lessonCountText = lessonCount + 1
        textViewQuestionCount.text = "第" + lessonCountText + "問／10問中"
        var data = questionData!![lessonCount]

        textViewBefore.text = data.qBefore
        textViewAfter.text = data.qAfter
        textViewQuestionJapanese.text = data.japanese

        val wordList: List<String> = data.selectList
        wordList.shuffled()
        button1.text = wordList[0]
        button2.text = wordList[1]
        button3.text = wordList[2]
        button4.text = wordList[3]
        button5.text = wordList[4]
        button6.text = wordList[5]
    }

    fun resetAns() {
        textViewQuestion1.text = getString(R.string.answer_one)
        textViewQuestion2.text = getString(R.string.answer_two)
        textViewQuestion3.text = getString(R.string.answer_three)
        textViewQuestion4.text = getString(R.string.answer_four)
        buttonDecide.setBackgroundResource(R.color.primary_dark)
    }

    fun setText(word: String) {

        if (textViewQuestion1.text.toString() == getString(R.string.answer_one)) {
            textViewQuestion1.text = word
        } else if (textViewQuestion2.text.toString() == (getString(R.string.answer_two))) {
            textViewQuestion2.text = word
        } else if (textViewQuestion3.text.toString() == (getString(R.string.answer_three))) {
            textViewQuestion3.text = word
        } else if (textViewQuestion4.text.toString() == (getString(R.string.answer_four))) {
            textViewQuestion4.text = word
            buttonDecide.setBackgroundResource(R.color.material_green)
        }
    }

    fun removeWord() {
        if (textViewQuestion4.text.toString() != (getString(R.string.answer_four))) {
            textViewQuestion4.text = getString(R.string.answer_four)
            buttonDecide.setBackgroundResource(R.color.primary_dark)
        } else if (textViewQuestion3.text.toString() != (getString(R.string.answer_three))) {
            textViewQuestion3.text = getString(R.string.answer_three)
        } else if (textViewQuestion2.text.toString() != (getString(R.string.answer_two))) {
            textViewQuestion2.text = getString(R.string.answer_two)
        } else if (textViewQuestion1.text.toString() != getString(R.string.answer_one)) {
            textViewQuestion1.text = getString(R.string.answer_one)
        }
    }

    fun checkAnswer() {
        if (textViewQuestion4.text.toString() != getString(R.string.answer_four)){
            var userAns =textViewQuestion1.text.toString() + " " +
                    textViewQuestion2.text.toString() + " " +
                    textViewQuestion3.text.toString() + " " +
                    textViewQuestion4.text.toString()

            if (userAns == questionData!![lessonCount].answer) {
                collectCount++
                showAlertDialog(true)
            } else {
                showAlertDialog(false)
            }

        } else {
            return
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
                    "'questionBefore': ''," +
                    "'questionAfter': '.'," +
                    "'japanese': '私は歌手です。'," +
                    "'selectList': ['ginger', 'You', 'I', 'am', 'a', 'singer']," +
                    "'answer':'I am a singer'," +
                    "'explanation':'第一文型SV＝S「誰が/何が(主語) + V「~する/である(動詞)」'" +
                    "}," +
                    "{" +
                    "'id': 2," +
                    "'questionBefore': ''," +
                    "'questionAfter': '.'," +
                    "'japanese': '私は納豆が好きではありません。'," +
                    "'selectList': ['am', 'don\\'t', 'not', 'like', 'natto', 'I']," +
                    "'answer':'do not like natto'," +
                    "'explanation':'do / does / did + not + 動詞の原形 で、「〜をしない」'" +
                    "}," +
                    "{" +
                    "'id': 1," +
                    "'questionBefore': ''," +
                    "'questionAfter': '.'," +
                    "'japanese': 'あの女性は誰ですか？'," +
                    "'selectList': ['Who', 'is', 'that', 'girl', 'When', 'are']," +
                    "'answer':'Who is that girl'," +
                    "'explanation':'Who ~? ＝ 「〜は誰？」'" +
                    "}," +
                    "{" +
                    "'id': 1," +
                    "'questionBefore': ''," +
                    "'questionAfter': 'birthday?'," +
                    "'japanese': 'あなたの妹の誕生日はいつですか？'," +
                    "'selectList': ['When', 'is', 'your', 'sister\\'s', 'are', 'Who']," +
                    "'answer':'When is your sister\\'s'," +
                    "'explanation':'When ~? =「〜はいつ？」'" +
                    "}," +
                    "{" +
                    "'id': 1," +
                    "'questionBefore': ''," +
                    "'questionAfter': 'sport?'," +
                    "'japanese': 'あなたの好きなスポーツはなんですか。'," +
                    "'selectList': ['What', 'is', 'your', 'favorite', 'When', 'are']," +
                    "'answer':'What is your favorite'," +
                    "'explanation':'What ~? = 「〜は何？」'" +
                    "}," +
                    "{" +
                    "'id': 1," +
                    "'questionBefore': ''," +
                    "'questionAfter': '.'," +
                    "'japanese': '私は歌手です。'," +
                    "'selectList': ['ginger', 'You', 'I', 'am', 'a', 'singer']," +
                    "'answer':'I am a singer'," +
                    "'explanation':'第一文型SV＝S「誰が/何が(主語) + V「~する/である(動詞)」'" +
                    "}," +
                    "{" +
                    "'id': 1," +
                    "'id': 2," +
                    "'questionBefore': ''," +
                    "'questionAfter': '.'," +
                    "'japanese': '私は納豆が好きではありません。'," +
                    "'selectList': ['am', 'don\\'t', 'not', 'like', 'natto', 'I']," +
                    "'answer':'do not like natto'," +
                    "'explanation':'do / does / did + not + 動詞の原形 で、「〜をしない」'" +
                    "}," +
                    "{" +
                    "'id': 1," +
                    "'questionBefore': ''," +
                    "'questionAfter': '.'," +
                    "'japanese': 'あの女性は誰ですか？'," +
                    "'selectList': ['Who', 'is', 'that', 'girl', 'When', 'are']," +
                    "'answer':'Who is that girl'," +
                    "'explanation':'Who ~? ＝ 「〜は誰？」'" +
                    "}," +
                    "{" +
                    "'id': 1," +
                    "'questionBefore': ''," +
                    "'questionAfter': 'birthday?'," +
                    "'japanese': 'あなたの妹の誕生日はいつですか？'," +
                    "'selectList': ['When', 'is', 'your', 'sister\\'s', 'are', 'Who']," +
                    "'answer':'When is your sister\\'s'," +
                    "'explanation':'When ~? =「〜はいつ？」'" +
                    "}," +
                    "{" +
                    "'id': 1," +
                    "'questionBefore': ''," +
                    "'questionAfter': 'sport?'," +
                    "'japanese': 'あなたの好きなスポーツはなんですか。'," +
                    "'selectList': ['What', 'is', 'your', 'favorite', 'When', 'are']," +
                    "'answer':'What is your favorite'," +
                    "'explanation':'What ~? = 「〜は何？」'" +
                    "}" +
                    "]"
}