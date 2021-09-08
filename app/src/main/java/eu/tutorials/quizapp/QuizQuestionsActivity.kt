package eu.tutorials.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {
    private var progressBar:ProgressBar?=null
    private var tvProgress: TextView? = null
    private var tvQuestion:TextView? = null
    private var ivImage: ImageView? = null
    private var tvOptionOne:TextView? = null
    private var tvOptionTwo:TextView? = null
    private var tvOptionThree:TextView? = null
    private var tvOptionFour:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar=findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)
        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)
        val questionsList = Constants.getQuestions()
        Log.e("Questions Size", "${questionsList.size}")
        for (i in questionsList) {
            Log.e("Questions", i.question)
        }
        // TODO (Step 3: Setting the question in the UI from the list.)
        // START
        val currentPosition = 1 // Default and the first question position
        val question: Question =
            questionsList[currentPosition - 1] // Getting the question from the list with the help of current position.

        progressBar?.progress =
            currentPosition // Setting the current progress in the progressbar using the position of question
        tvProgress?.text =
            "$currentPosition" + "/" + progressBar?.max // Setting up the progress text

        // Now set the current question and the options in the UI
        tvQuestion?.text = question.question
        ivImage?.setImageResource(question.image)
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour
        // END
    }
}