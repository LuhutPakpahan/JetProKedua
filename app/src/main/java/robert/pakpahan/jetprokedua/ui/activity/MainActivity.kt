package robert.pakpahan.jetprokedua.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import robert.pakpahan.jetprokedua.R
import robert.pakpahan.jetprokedua.ui.adapter.ViewpagerAdapter
import robert.pakpahan.jetprokedua.ui.fragment.MovieFragment
import robert.pakpahan.jetprokedua.ui.fragment.TvShowFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setViewPager()
    }

    private fun setViewPager() {
        val fragmentList = listOf(MovieFragment(), TvShowFragment())
        val tabTitle = listOf(resources.getString(R.string.movie), resources.getString(R.string.tv_show))

        viewpager.adapter = ViewpagerAdapter(fragmentList, this.supportFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout2, viewpager){tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }
}