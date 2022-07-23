package ir.schooltech.pressroidcarousel

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.helper.widget.Carousel
import androidx.constraintlayout.motion.widget.MotionLayout
import com.squareup.picasso.Picasso
import schooltech.pressroidcarousel.R

class PressroidCarousel(context: Context, attrs: AttributeSet?) : MotionLayout(context, attrs) {
    var showHeader = true
    var autoplay=true
    private var carousel:Carousel
    var items:List<CarouselItem>?=null


    init {
        val root=inflate(context, R.layout.carousel_view,this).rootView
        carousel=root.findViewById<Carousel>(R.id.main_carousel)

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.PressroidCarousel,
            0, 0).apply {

            try {
                showHeader = getBoolean(R.styleable.PressroidCarousel_showHeader, false)
                autoplay=getBoolean(R.styleable.PressroidCarousel_Autoplay, false)
            } finally {
                recycle()
            }
            carousel.setAdapter(object:Carousel.Adapter{
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
            })
            //carousel.refresh()
        }
    }
}