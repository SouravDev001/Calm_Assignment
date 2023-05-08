package calm.assignment.view.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import calm.assignment.R

class StackViewContainer(context: Context, attrs: AttributeSet? = null) :
    FrameLayout(context, attrs) {

    private val toggleButton: AppCompatImageView
    private val textField: AppCompatTextView = AppCompatTextView(context)
    private val stackContainer: LinearLayout
    private var isExpanded = false

    init {
        LayoutInflater.from(context).inflate(R.layout.stack_view_container, this, true)

        toggleButton = findViewById(R.id.toggleButton)
        stackContainer = findViewById(R.id.stackContainer)

        toggleButton.setOnClickListener {
            toggle()
        }
    }

    // Add a child view to the stack view container.
    fun addChildView(view: View) {
        stackContainer.addView(view)
    }

    // Remove a child view from the stack view container.
    fun removeChildView(view: View) {
        stackContainer.removeView(view)
    }

    // Collapse the stack view container.
    fun collapse() {
        isExpanded = false
        toggleButton.isSelected = false
        toggleButton.setImageResource(R.drawable.down_arrow)
        stackContainer.visibility = View.GONE
    }

    // Toggle the stack view container and collapse all others.
    fun toggle() {
        if (parent != null) {
            val parentView = parent as ViewGroup
            for (i in 0 until parentView.childCount) {
                val view = parentView.getChildAt(i)
                if (view is StackViewContainer && view != this) {
                    view.collapse()
                }
            }
        }

        isExpanded = !isExpanded
        toggleButton.isSelected = isExpanded

        if (isExpanded) {
            stackContainer.visibility = View.VISIBLE
            toggleButton.setImageResource(R.drawable.up_arrow)
        } else {
            stackContainer.visibility = View.GONE
            toggleButton.setImageResource(R.drawable.down_arrow)
        }
    }
}
