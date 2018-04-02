package com.best_teacher_inc.btwritingsample.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.best_teacher_inc.btwritingsample.R
import kotlinx.android.synthetic.main.activity_lesson_detail.*

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
        if (intent.getIntExtra(KEY_LESSON_ID, 0) == 0) {
            toolbar.title = "SV(主語+動詞)"
            textViewBetty1.text = "SV(主語と動詞)のみで成り立つ文章は第一文型と呼ばれるって知ってた？"
            imageViewBetty1.setImageResource(R.drawable.betty_clear)
            textViewTanaka1.text = "え？なにそれ？ワタシキイタコトナイヨ"
            imageViewTanaka1.setImageResource(R.drawable.tanasyo_doya_clear)
            textViewBetty2.text = "(ダメだこいつ早くなんとかしないと...)\n超基本よ！でも、基本的にはSV(第一文型)の文に情報を加えて文を作ることが多いんだけどね。"
            imageViewBetty2.setImageResource(R.drawable.betty_sullen_clear)
            textViewTanaka2.text = "For Example? (たとえば？)"
            imageViewTanaka2.setImageResource(R.drawable.tanasyo_other_clear)
            textViewBetty3.text = "(ｲﾗｯ)\n I live.(SV)の文章に、in Japanを加えると、I live in Japan.となって文章が完成するの。こうやって、英語の文章は基本的にSVに様々な情報が加わって大きな文章になっているのよ。どうしてもって言うなら私が教えてあげてもいいわよ。"
            imageViewBetty3.setImageResource(R.drawable.betty_smile_angry)
            textViewTanaka3.text = "そっかー、それなら教えてもらおうかな。(...今日の宿題、全部教えてもらおう。)"
            imageViewTanaka3.setImageResource(R.drawable.tanasyo_hirameki_clear)
            textViewPointDetail.text = "第一文型SV＝S「誰が/何が(主語) + V「~する/である(動詞)」」\n" +
                    "英文の基本となる文法なので、しっかりと抑えておきましょう。\n" +
                    "S(Subject): 文章の主語\n" +
                    "例 I, You, She, He, They, This, etc\n" +
                    "V(Verb): 動詞\n" +
                    "例 am, do, clean, eat\n" +
                    "*動詞は時制(現在、過去、未来等)が異なると形が変わることに注意しましょう。\n" +
                    "過去形の例: was, did, cleaned, ate"

        } else {
            toolbar.title = "否定文(not)"
            textViewBetty1.text = " I am not a student.\n I do not go to school.\n I cannot go to school.\n この３つの文から何が分かると思う？"
            imageViewBetty1.setImageResource(R.drawable.betty_happy_clear)
            textViewTanaka1.text = "その人は学校が嫌いなんだろうね！"
            imageViewTanaka1.setImageResource(R.drawable.tanasyo_doya_clear)
            textViewBetty2.text = "は？やる気あんの？英語の文法の話！"
            imageViewBetty2.setImageResource(R.drawable.betty_smile_angry)
            textViewTanaka2.text = "(怖っ)うーん、not が入っているっていうこと？"
            imageViewTanaka2.setImageResource(R.drawable.tanasyo_bouzen_clear)
            textViewBetty3.text = "そう。そのnotの使い方というのが大きく３パターンあって、いずれもnotの後ろにくる内容を否定しているの。"
            imageViewBetty3.setImageResource(R.drawable.betty_clear)
            textViewTanaka3.text = "う、うん・・・。(わからん)"
            imageViewTanaka3.setImageResource(R.drawable.tanasyo_other_clear)

            textViewPointDetail.text ="notを使用した否定文は大きく分けて３つあります。いずれもnotの後ろにくる内容を否定する文章です。\n" +
                    "\n" +
                    "1. be動詞 + not\n" +
                    "例: She is not a singer. （彼女は歌手ではない）\n" +
                    "\n" +
                    "2. do / does / did + not + 動詞の原形\n" +
                    "例: He did not come.（彼は来なかった。）\n" +
                    "\n" +
                    "3. 助動詞 + not + 動詞の原形\n" +
                    "例: I will not play tennis tomorrow.（私は明日テニスをしません。）"

        }




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
            startActivity(StepThreeActivity.newIntent(this, intent.getIntExtra(KEY_LESSON_ID, 1)))
        }
    }

}