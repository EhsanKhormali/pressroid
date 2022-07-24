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
import androidx.constraintlayout.helper.widget.Carousel
import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.material.textview.MaterialTextView
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import ir.schooltech.pressroid.SearchResultsActivity
import schooltech.pressroid.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var searchView:SearchView
    private lateinit var searchText:MaterialTextView
    lateinit var carousel:Carousel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        searchText=findViewById(R.id.app_bar_search_text_hint)
        val motionLayout:MotionLayout=findViewById(R.id.carousel_motion_layout)
        /*motionLayout.setTransitionListener(object : MotionLayout.TransitionListener{
            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int
            ) {
                TODO("Not yet implemented")
            }

            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int,
                progress: Float
            ) {
                TODO("Not yet implemented")
            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                TODO("Not yet implemented")
            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout?,
                triggerId: Int,
                positive: Boolean,
                progress: Float
            ) {
                TODO("Not yet implemented")
            }

        })*/
        carousel=findViewById(R.id.main_carousel)
        carousel.setAdapter(object : Carousel.Adapter{
            override fun count(): Int {
                return 5
            }

            override fun populate(view: View?, index: Int) {
                if(view is ImageView)
                Picasso.get().load("https://picsum.photos/300/200").into(view)
            }

            override fun onNewItem(index: Int) {

            }

        })
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        /*menuInflater.inflate(R.menu.menu_main_top,menu)

        (menu.findItem(R.id.app_bar_searchview).actionView as SearchView).apply {
            setIconifiedByDefault(false)
            queryHint="search products"
        }*/
        return true
    }
}