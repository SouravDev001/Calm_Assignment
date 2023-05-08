package calm.assignment.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import calm.assignment.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get a reference to the stack view.
        val stackView = findViewById<StackView>(R.id.stackView)

        // Add some sample child views to the stack view.
        val inflater = LayoutInflater.from(this)
        for (i in 1..4) {
            val view = inflater.inflate(R.layout.child_view, null)
//            val textView = view.findViewById<TextView>(R.id.textView)
//            textView.text = "Child View $i"
            stackView.addChildView(view)
        }
    }
}
