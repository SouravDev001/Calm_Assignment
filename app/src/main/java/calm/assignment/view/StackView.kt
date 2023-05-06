package calm.assignment.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import calm.assignment.view.utils.StackViewContainer

class StackView(context: Context, attrs: AttributeSet? = null) :
    LinearLayout(context, attrs) {

    // Initialize the stack view.
    init {
        orientation = VERTICAL
    }

    // Add a new child view to the stack view.
    fun addChildView(view: View) {
        val container = StackViewContainer(context)
        container.addChildView(view)
        addView(container)
    }

    // Remove a child view from the stack view.
    fun removeChildView(view: View) {
        for (i in 0 until childCount) {
            val container = getChildAt(i) as StackViewContainer
            container.removeChildView(view)
            if (container.childCount == 0) {
                removeView(container)
            }
        }
    }

    // Remove all child views from the stack view.
    fun removeAllChildViews() {
        removeAllViews()
    }
}
