package com.example.myapplication.ui.attractions.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.attractions.AttractionDetail
import com.example.myapplication.attractions.AttractionsInfo
import com.example.myapplication.ui.attractions.AttractionsFragmentDirections

class AttractionsAdapter(private val mData: List<AttractionsInfo>) :
    RecyclerView.Adapter<AttractionsAdapter.ViewHolder>() {
    var onItemClick: (AttractionDetail) -> Unit = {}

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AttractionsAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_attraction_all, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mData[position])

    }

    override fun getItemCount(): Int {
        return mData.size
    }


    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val imgAttraction: ImageView = v.findViewById(R.id.image_attractions)
        private val btnDirect: ImageButton = v.findViewById(R.id.btn_direct)
        private val txtDes: TextView = v.findViewById(R.id.txt_des)

        fun bind(model: AttractionsInfo) {
            Glide.with(itemView.context).load(model.images?.firstOrNull()?.src).into(imgAttraction)
            txtDes.text = model.introduction
            btnDirect.setOnClickListener {
                onItemClick.invoke(
                    AttractionDetail(
                        url = model.images?.firstOrNull()?.src,
                        introduce = model.introduction,
                        address = model.address,
                        linkUrl = model.url
                    ))
            }
        }
    }
}
