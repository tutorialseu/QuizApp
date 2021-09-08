package eu.tutorials.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class QuizQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        val questionsList = Constants.getQuestions()
        Log.e("Questions Size", "${questionsList.size}")
        for (i in questionsList) {
            Log.e("Questions", i.question)
        }
    }
}