package eu.tutorials.activityresultlauncher

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private var buttonFirstActivityLauncher: Button? = null
    private var buttonSecondActivityLauncher:Button? = null
    private var tvFirstActivityResult: TextView? = null
    private var tvSecondActivityResult: TextView? = null

    companion object{
        const val NAME = "name"
        const val EMAIL = "email"
    }

    private var firstActivityResultLauncher:ActivityResultLauncher<Intent> = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data
            //receive data from firstActivity
            tvFirstActivityResult?.text = "First Activity Result Success."
        }else if (result.resultCode == Activity.RESULT_CANCELED) {
            Log.e("Cancelled", "Cancelled")
            Toast.makeText(this@MainActivity,"Result Cancelled",Toast.LENGTH_SHORT).show()
        }
    }

    private var secondActivityResultLauncher:ActivityResultLauncher<Intent> = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data
            //receive data from secondActivity
            if (data != null) {
                // Here the data which we have sent from the second activity is received and displayed in the textview.
                val name = data.getStringExtra(NAME)
                val email = data.getStringExtra(EMAIL)

                tvSecondActivityResult?.text = "$name  ==>  $email"
            }
        } else if (result.resultCode == Activity.RESULT_CANCELED) {
            Log.e("Cancelled", "Cancelled")
            Toast.makeText(this@MainActivity,"Result Cancelled", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonFirstActivityLauncher = findViewById(R.id.btn_launch_activity_first)
        buttonSecondActivityLauncher = findViewById(R.id.btn_launch_activity_second)
        tvFirstActivityResult = findViewById(R.id.tv_first_activity_result)
        tvSecondActivityResult = findViewById(R.id.tv_second_activity_result)

        buttonFirstActivityLauncher?.setOnClickListener {
            val intent = Intent(this@MainActivity, FirstActivity::class.java)
            firstActivityResultLauncher.launch(intent)
        }

        buttonSecondActivityLauncher?.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            secondActivityResultLauncher.launch(intent)
        }
    }
}