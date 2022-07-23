package ir.schooltech.pressroidcarousel

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.helper.widget.Carousel
import com.squareup.picasso.Picasso

class CarouselAdapter(val items:List<CarouselItem>?=null): Carousel.Adapter {
    override fun count(): Int {
        return 5
    }

    override fun populate(view: View?, index: Int) {
        if (view is ImageView) {
            Picasso.get().load("https://picsum.photos/300/200").into(view)
            view.setOnClickListener {
                ///TODO:head to items[index].link
            }
        } else if (view is TextView) {
            view.text= items?.get(index)?.header ?: ""

        }
    }

    override fun onNewItem(index: Int) {

    }
}