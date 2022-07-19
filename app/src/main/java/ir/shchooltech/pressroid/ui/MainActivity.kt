package ir.shchooltech.pressroid.ui

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.core.view.size
import dagger.hilt.android.AndroidEntryPoint
import ir.shchooltech.pressroid.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_top,menu)
        //associate searchable configuration with the searchView
        val searchManager=getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.app_bar_search).actionView as SearchView).apply {
            isIconified=true
            maxWidth= Int.MAX_VALUE
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }
        return true
    }
}