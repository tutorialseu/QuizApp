package eu.tutorials.activityresultlauncher

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        val buttonFinish: Button = findViewById(R.id.btn_finish)
        buttonFinish.setOnClickListener {
            setResult(Activity.RESULT_OK) // It is used to set the RESULT OK which means it is success action which we wants to send back.
            finish()
        }

    }
}