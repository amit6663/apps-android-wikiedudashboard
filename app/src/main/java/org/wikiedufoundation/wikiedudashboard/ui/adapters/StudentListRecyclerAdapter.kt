package org.wikiedufoundation.wikiedudashboard.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_rv_students.view.*
import org.wikiedufoundation.wikiedudashboard.R
import org.wikiedufoundation.wikiedudashboard.ui.coursedetail.students.data.User
import org.wikiedufoundation.wikiedudashboard.ui.coursedetail.students.view.StudentListFragment
import java.util.*

/**
 * RecyclerView adapter for recent activities
 * @property studentListFragment primary constructor property
 ***/
class StudentListRecyclerAdapter(
        private var studentListFragment: StudentListFragment
) : RecyclerView.Adapter<StudentListRecyclerAdapter.MyAdapter>() {
    private var studentList: List<User> = ArrayList()

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MyAdapter {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_rv_students, viewGroup, false)

        return MyAdapter(view)
    }

    override fun onBindViewHolder(myAdapter: MyAdapter, i: Int) {
        myAdapter.textView.text = studentList[i].userName
        myAdapter.itemView.setOnClickListener {
            studentListFragment.openStudentProfile(studentList[i].userName)
        }
    }

    /**
     * Set [User] type list of edited activities list
     * @param studentList a list of students
     * ***/
    fun setData(studentList: List<User>) {
        this.studentList = studentList
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    /**
     * Use [MyAdapter] inner class to declare Views component
     * @property itemView primary constructor property
     * ***/
    inner class MyAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.tv_students_name
    }
}