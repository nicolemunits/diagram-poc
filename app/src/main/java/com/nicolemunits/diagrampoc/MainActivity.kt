package com.nicolemunits.diagrampoc

import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.nicolemunits.diagrampoc.adapters.MyRecyclerViewAdapter
import com.nicolemunits.diagrampoc.adapters.MyRecyclerViewAdapter.ItemClickListener
import com.nicolemunits.diagrampoc.model.BarModel


class MainActivity : AppCompatActivity(), ItemClickListener {

    private var adapter: MyRecyclerViewAdapter? = null
    private val expenses = listOf(
        BarModel(13000f, "JANUARY"),
        BarModel(12000f, "FEBRUARY"),
        BarModel(0f, "MARCH"),
        BarModel(15000f, "APRIL"),
        BarModel(0f, "MAY"),
        BarModel(0f, "JUNE"),
        BarModel(15400f, "JULY"),
        BarModel(15000f, "AUGUST"),
        BarModel(0f, "SEPTEMBER"),
        BarModel(16040f, "OCTOBER"),
        BarModel(14560f, "NOVEMBER"),
        BarModel(1320f, "DECEMBER")
    ).reversed()

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set up the RecyclerView
        recyclerView = findViewById<RecyclerView>(R.id.barRecycler)
        val horizontalLayoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = horizontalLayoutManager
        adapter = MyRecyclerViewAdapter(this, expenses)
        adapter!!.setClickListener(this)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(view: View?, position: Int) {
        view?.findViewById<View>(R.id.barView)?.background = getDrawable(R.drawable.background_white)
        var child: View
        if(::recyclerView.isInitialized) {
            view?.findViewById<View>(R.id.barView)?.background = getDrawable(R.drawable.background_white)
            for (i in 0 until recyclerView.childCount) {
                child = recyclerView.getChildAt(i)
                if (child != recyclerView.getChildAt(position)) {
                    //if (child.findViewById<View>(R.id.barView).background == getDrawable(R.drawable.background_white)) {
                        child.findViewById<View>(R.id.barView).background = getDrawable(R.drawable.background)
                    //}
                    //In case you need to access ViewHolder:
                    //recyclerView.getChildViewHolder(child)
                }
            }
        }
    }
}




//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//
//class MainActivity : AppCompatActivity() {
//
//    //private var recyclerViewAdapter: Adap= null
//    private var monthData: List<Column> = listOf(Column(Months.FEBRUARY, 2000), Column(Months.APRIL, 3000))
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//    }
//
//    data class Column(val monthName: Months, val monthSpending: Int)
//
//    enum class Months{
//        SEPTEMBER,
//        OCTOBER,
//        NOVEMBER,
//        DECEMBER,
//        JANUARY,
//        FEBRUARY,
//        MARCH,
//        APRIL,
//        MAY,
//        JUNE,
//        JULY,
//        AUGUST
//    }
//}