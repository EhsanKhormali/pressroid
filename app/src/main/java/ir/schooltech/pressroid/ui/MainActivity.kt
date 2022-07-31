package ir.schooltech.pressroid.ui

import android.app.SearchManager
import android.content.ComponentName
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import com.google.android.material.textview.MaterialTextView
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import ir.schooltech.pressroid.SearchResultsActivity
import schooltech.pressroid.R
import ir.schooltech.carousel.Carousel
import ir.schooltech.pressroid.models.CarouselItem
import ir.schooltech.pressroid.ui.adapter.MainCarouselAdapter

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var searchView:SearchView
    private lateinit var searchText:MaterialTextView
    lateinit var carousel:Carousel
    val carouselItems=ArrayList<CarouselItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        searchText=findViewById(R.id.app_bar_search_text_hint)
        carousel=findViewById(R.id.main_carousel)

        getSampleData()
        carousel.apply {
            adapter = MainCarouselAdapter(carouselItems)
            set3DItem(true)
            setInfinite(true)
        }

        //associate searchable configuration with the searchView
        val searchManager=getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView=findViewById(R.id.app_bar_search_view)
        searchView.apply {
            setSearchableInfo(searchManager.getSearchableInfo(//componentName))
                ComponentName(this@MainActivity, SearchResultsActivity::class.java)))
            setOnQueryTextFocusChangeListener { view, b ->
                if (b || searchView.query.isNotEmpty()) {
                    searchText.visibility = View.GONE
                } else {
                    searchText.visibility = View.VISIBLE
                }
            }
            setOnQueryTextListener(object: SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    ///TODO("Not yet implemented")
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    searchText.visibility = View.GONE
                    return true
                }
            })
        }
    }

    private fun getSampleData() {
        carouselItems.apply {
            add(CarouselItem("https://picsum.photos/400/200","1",""))
            add(CarouselItem("https://picsum.photos/402/201","2",""))
            add(CarouselItem("https://picsum.photos/404/202","3",""))
            add(CarouselItem("https://picsum.photos/406/203","4",""))
            add(CarouselItem("https://picsum.photos/408/204","5",""))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        /*menuInflater.inflate(R.menu.menu_main_top,menu)

        (menu.findItem(R.id.app_bar_searchview).actionView as SearchView).apply {
            setIconifiedByDefault(false)
            queryHint="search products"
        }*/
        return true
    }
}