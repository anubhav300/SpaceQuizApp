package com.example.anubhavgupta

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.anubhavgupta.ResultActivity

class BH : AppCompatActivity(), View.OnClickListener {

    // TODO (STEP 2: A global variables for current position and questions list.)
    // START
    private var mCurrentPosition: Int = 1 // Default and the first question position
    private var mQuestionsList: ArrayList<Question>? = null
    private var mCorrectAnswers :Int=0
    private var mUserName : String? = null
    // END

    // TODO (STEP 5: A global variables for selected option.)
    // START
    private var mSelectedOptionPosition: Int = 0
    // END

    /**
     * This function is auto created by Android when the Activity Class is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_bh)
        mUserName = intent.getStringExtra(BHQ.USER_NAME)

        // TODO (STEP 3: Make the questions list and the current position variable global and remove the loBH here.)
        // START
        mQuestionsList = BHQ.getQuestions()
        // END

        setQuestion()

        // TODO (STEP 4: Set all the click events for Options using the interface onClick listener)
        // START
        val progressBar: ProgressBar = findViewById(R.id.progressBar)
        progressBar.progress = mCurrentPosition
        val tv_progress: TextView = findViewById(R.id.tv_progress)
        tv_progress.text = "$mCurrentPosition"+"/"+progressBar.max
        val tv_question :TextView = findViewById(R.id.tv_question)
        val tv_option_one: TextView = findViewById(R.id.tv_option_one)
        val tv_option_two: TextView = findViewById(R.id.tv_option_two)
        val tv_option_three: TextView = findViewById(R.id.tv_option_three)
        val tv_option_four: TextView = findViewById(R.id.tv_option_four)
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        // END
        val btn_submit: Button = findViewById(R.id.btn_submit)
        btn_submit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val tv_question :TextView = findViewById(R.id.tv_question)
        val tv_option_one: TextView = findViewById(R.id.tv_option_one)
        val tv_option_two: TextView = findViewById(R.id.tv_option_two)
        val tv_option_three: TextView = findViewById(R.id.tv_option_three)
        val tv_option_four: TextView = findViewById(R.id.tv_option_four)
        val btn_submit: Button = findViewById(R.id.btn_submit)
        when (v?.id) {

            R.id.tv_option_one -> {

                selectedOptionView(tv_option_one, 1)
            }

            R.id.tv_option_two -> {

                selectedOptionView(tv_option_two, 2)
            }

            R.id.tv_option_three -> {

                selectedOptionView(tv_option_three, 3)
            }

            R.id.tv_option_four -> {

                selectedOptionView(tv_option_four, 4)
            }

            R.id.btn_submit ->{
                if (mSelectedOptionPosition == 0) {

                    mCurrentPosition++

                    when {

                        mCurrentPosition <= mQuestionsList!!.size -> {

                            setQuestion()
                        }
                        else -> {


                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(BHQ.USER_NAME, mUserName)
                            intent.putExtra(BHQ.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(BHQ.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    // This is to check if the answer is wrong
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
else{mCorrectAnswers++;}
                    // This is for correct answer
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size) {
                        btn_submit.text = "FINISH"
                    } else {
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                }
            }

        }
    }

    // TODO (STEP 1 : Lets create a function to set the question in the UI components which we have done earlier the onCreate method. And make some of the variables global which we will be using later.)
    // START
    /**
     * A function for setting the question to UI components.
     */
    private fun setQuestion() {

        //val question:Question? = mQuestionsList!!.get(mCurrentPosition-1)
        val progressBar: ProgressBar = findViewById(R.id.progressBar)
        val tv_progress: TextView = findViewById(R.id.tv_progress)
        tv_progress.text = "$mCurrentPosition"+"/"+progressBar.max
        val tv_question :TextView = findViewById(R.id.tv_question)
        //val tv_question :TextView = findViewById(R.id.tv_question)
        val tv_option_one: TextView = findViewById(R.id.tv_option_one)
        val tv_option_two: TextView = findViewById(R.id.tv_option_two)
        val tv_option_three: TextView = findViewById(R.id.tv_option_three)
        val tv_option_four: TextView = findViewById(R.id.tv_option_four)
        val question =
            mQuestionsList!!.get(mCurrentPosition - 1) // Getting the question from the list with the help of current position.

        defaultOptionsView()

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.getMax()

        tv_question.text = question.question

        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
        val btn_submit: Button = findViewById(R.id.btn_submit)
        if (mCurrentPosition == mQuestionsList!!.size) {
            btn_submit.text = "FINISH"
        } else {
            btn_submit.text = "SUBMIT"
        }
    }
    // END

    // TODO (STEP 6: Create a function for view for highlighting the selected option.)
    // START
    /**
     * A function to set the view of selected option view.
     */
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@BH,
            R.drawable.selected_option_border_bg
        )
    }

    // TODO (STEP 8: Create a function to set default options view.)
    // START
    /**
     * A function to set default options view when the new question is loaded or when the answer is reselected.
     */
    private fun defaultOptionsView() {
        val tv_option_one: TextView = findViewById(R.id.tv_option_one)
        val tv_option_two: TextView = findViewById(R.id.tv_option_two)
        val tv_option_three: TextView = findViewById(R.id.tv_option_three)
        val tv_option_four: TextView = findViewById(R.id.tv_option_four)
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this@BH,
                R.drawable.default_option_border_bg
            )
        }
    }
    private fun answerView(answer: Int, drawableView: Int) {
        val tv_option_one: TextView = findViewById(R.id.tv_option_one)
        val tv_option_two: TextView = findViewById(R.id.tv_option_two)
        val tv_option_three: TextView = findViewById(R.id.tv_option_three)
        val tv_option_four: TextView = findViewById(R.id.tv_option_four)
        when (answer) {

            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                    this@BH,
                    drawableView
                )
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(
                    this@BH,
                    drawableView
                )
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(
                    this@BH,
                    drawableView
                )
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(
                    this@BH,
                    drawableView
                )
            }
        }
    }
}