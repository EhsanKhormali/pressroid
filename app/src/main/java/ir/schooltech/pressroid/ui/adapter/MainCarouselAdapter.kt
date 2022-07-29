package ir.schooltech.pressroid.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ir.schooltech.pressroid.models.CarouselItem
import schooltech.pressroid.R

class MainCarouselAdapter (private var list : ArrayList<CarouselItem>): RecyclerView.Adapter<MainCarouselAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image : ImageView = itemView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.main_carousel_item, parent,false)
        return ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(list[position].imageUrl).into(holder.image)
    }

    fun updateData(list: ArrayList<CarouselItem>) {
        this.list = list
        notifyDataSetChanged()
    }

    //Use the method for item changed
    fun itemChanged() {
        // remove last item for test purposes
        //this.list[0] = (DataModel(R.drawable.londonlove, "Thi is cool"))
        //notifyItemChanged(0)

    }

    //Use the method for checking the itemRemoved
    fun removeData() {
        // remove last item for test purposes
        val orgListSize = list.size
        this.list = this.list.subList(0, orgListSize - 1).toList() as ArrayList<CarouselItem>
        notifyItemRemoved(orgListSize - 1)
    }
}