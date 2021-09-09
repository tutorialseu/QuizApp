package eu.tutorials.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

       //Todo: connect to each view in the layout through its id
        val tvName: TextView = findViewById(R.id.tv_name)
        val tvScore:TextView = findViewById(R.id.tv_score)
        val btnFinish:Button = findViewById(R.id.btn_finish)

        val userName = intent.getStringExtra(Constants.USER_NAME)
        tvName.text = userName

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        tvScore.text = "Your Score is $correctAnswers out of $totalQuestions."

        btnFinish.setOnClickListener {
            //
            startActivity(Intent(this@ResultActivity, MainActivity::class.java))
        }
    }


}