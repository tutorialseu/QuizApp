package eu.tutorials.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        WindowInsetsControllerCompat(window, window.decorView).hide(WindowInsetsCompat.Type.systemBars())
        val buttonStart:Button = findViewById(R.id.btn_start)
        val etName:AppCompatEditText = findViewById(R.id.et_name)
        buttonStart.setOnClickListener {
          if (etName.text.toString().isEmpty()){
              Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_SHORT).show()
          }else{
              val intent = Intent(this,QuizQuestionsActivity::class.java)
              startActivity(intent)
          }
        }
    }
}