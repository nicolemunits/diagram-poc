package com.nicolemunits.diagrampoc.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import com.nicolemunits.diagrampoc.R
import com.nicolemunits.diagrampoc.model.BarModel


class MyRecyclerViewAdapter internal constructor(context: Context?, expenses: List<BarModel>) : RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {

    private var mExpenses: List<BarModel> = expenses
    private var mInflater: LayoutInflater = LayoutInflater.from(context)
    private var mClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = mInflater.inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyRecyclerViewAdapter.ViewHolder, position: Int) {
        val h = (mExpenses[position].expense/7440) * 100
        if (mExpenses[position].expense == 0f) {
            holder.barView. layoutParams = LinearLayout.LayoutParams(36, 36)
        }else  {
            holder.barView. layoutParams = LinearLayout.LayoutParams(36, ((h*317)/200).toInt())
        }
        holder.month.text = when (mExpenses[position].month) {
            "JANUARY" -> "ינו׳"
            "FEBRUARY" -> "פבר׳"
            "MARCH" -> "מרץ׳"
            "APRIL" -> "אפר׳"
            "MAY" -> "מאי"
            "JUNE" -> "יוני"
            "JULY" -> "יולי"
            "AUGUST" -> "אוג׳"
            "SEPTEMBER" -> "ספט׳"
            "OCTOBER "-> "אוק׳"
            "NOVEMBER" -> "נוב׳"
            else -> "דצב׳"
        }
    }

    // total number of rows
    override fun getItemCount() = mExpenses.size

    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var barView = itemView.findViewById<View>(R.id.barView)
        var month = itemView.findViewById<TextView>(R.id.monthName)


        override fun onClick(view: View?) {
            if (mClickListener != null) mClickListener!!.onItemClick(view, adapterPosition)
        }

        init {
//            myView = itemView.findViewById(R.id.colorView)
//            myTextView = itemView.findViewById(R.id.tvAnimalName)
            itemView.setOnClickListener(this)
        }
    }

    // convenience method for getting data at click position
//    fun getItem(id: Int): String {
//        return m[id]
//    }

    // allows clicks events to be caught
    fun setClickListener(itemClickListener: ItemClickListener?) {
        mClickListener = itemClickListener
    }

    // parent activity will implement this method to respond to click events
    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }
}














//import androidx.recyclerview.widget.RecyclerView
//import com.nicolemunits.diagrampoc.MainActivity

//class ColumsRecuclerViewAdapter(val monthListData: List<MainActivity.Column>): RecyclerView.Adapter<Column> {
//
//
//
//
//
//
//
//
//
//}


