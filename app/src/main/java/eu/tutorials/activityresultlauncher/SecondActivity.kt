package eu.tutorials.activityresultlauncher

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val etName:EditText = findViewById(R.id.et_name)
        val etEmail:EditText = findViewById(R.id.et_email)
        val btnSubmit:Button = findViewById(R.id.btn_submit)

        btnSubmit.setOnClickListener {
            // This is used send the custom data with the result.
            val intent = Intent()
            intent.putExtra(MainActivity.NAME, etName.text.toString())
            intent.putExtra(MainActivity.EMAIL, etEmail.text.toString())

            setResult(Activity.RESULT_OK, intent) // It is used to set the RESULT OK and a custom data values which we wants to send back.
            finish()
        }
    }
}