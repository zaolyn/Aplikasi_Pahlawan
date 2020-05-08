package com.yazidevelop.heroappkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class HeroAdapter(var items : ArrayList<Hero>, var clickListner: OnHeroClickListener) : RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): HeroViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row, viewGroup, false)
        return HeroViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.initialize(items.get(position),clickListner)

    }
    class HeroViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        var heroname = itemView.item_name
        var herodetail = itemView.item_detail
        var heroimg = itemView.item_photo

        fun initialize(item: Hero, action:OnHeroClickListener){
            heroname.text = item.name
            herodetail.text = item.detail
            heroimg.setImageResource(item.img)

            itemView.setOnClickListener{
                action.onItemClick(item,adapterPosition)
            }

        }

    }

}
interface OnHeroClickListener{
    fun onItemClick(item: Hero, position: Int)
}