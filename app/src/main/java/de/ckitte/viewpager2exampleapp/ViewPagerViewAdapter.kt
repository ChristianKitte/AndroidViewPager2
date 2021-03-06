package de.ckitte.viewpager2exampleapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class ViewPagerViewAdapter : RecyclerView.Adapter<ViewPagerViewAdapter.ViewHolder>() {
    var userList: ArrayList<User> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = userList[position].name
        holder.tvFirstName.text = userList[position].firstName
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    // Neue Users anzeigen...
    fun setNewUser(userList: ArrayList<User>) {
        this.userList = userList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tvName)
        var tvFirstName: TextView = itemView.findViewById(R.id.tvFirstname)
    }
}