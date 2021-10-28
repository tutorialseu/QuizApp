package eu.tutorials.quizapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

// TODO (STEP 1 : Create a QuizQuestions Activity.)
// START
class QuizQuestionsActivity : AppCompatActivity() {

    /**
     * This function is auto created by Android when the Activity Class is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_quiz_questions)

        // TODO (STEP 7: Now get the list of question here to show in the UI. As of now it is printed in log.)
        // START
        val questionsList = Constants.getQuestions()
        Log.e("Questions Size", "${questionsList.size}")
        for (i in questionsList) {
            Log.e("Questions", i.question)
        }
        // END
    }
}
// END