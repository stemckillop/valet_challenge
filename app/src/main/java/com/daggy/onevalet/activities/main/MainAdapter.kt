package com.daggy.onevalet.activities.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daggy.onevalet.R
import com.daggy.onevalet.models.Devices

class MainAdapter(var filteredList: List<Devices>, var delegate: MainAdapterDelegate) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    var items : List<Devices> = listOf()
    init {
        items = filteredList
    }

    fun getFilteredList(str: String) {
        if (str.isEmpty()) {
            filteredList = items
            notifyDataSetChanged()
        } else {
            val arr = arrayListOf<Devices>()
            for (l in items) {
                if (l.name.contains(str, true)) {
                    arr.add(l)
                }
            }
            filteredList = arr
            notifyDataSetChanged()
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title = view.findViewById<TextView>(R.id.cell_devices_txt_title)
        var status = view.findViewById<TextView>(R.id.cell_devices_txt_status)

        fun bind(device: Devices, delegate: MainAdapterDelegate) {

            title.text = device.name
            status.text = "Status: ${device.getFriendlyStatus()}"

            itemView.setOnClickListener {
                delegate.onItemClicked(device)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(filteredList[position], delegate)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_main_devices, parent, false))
    override fun getItemCount(): Int = filteredList.size

}