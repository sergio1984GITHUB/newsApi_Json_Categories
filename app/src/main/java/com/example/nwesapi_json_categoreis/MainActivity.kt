package com.example.nwesapi_json_categoreis

import android.support.design.widget.TabLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import android.os.Bundle
import android.view.MenuItem
import android.widget.TableLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var mSectionsPageAdapter: SectionsPagerAdapter? = null

    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        mSectionsPageAdapter= SectionsPagerAdapter(supportFragmentManager)

        val container
        container.adapter = mSectionsPageAdapter

        container.addonPagechangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TableLayout.ViewPagerOnTabSelectedListener(container))

        fab.setOnClickListener { view ->
                Snackbar.make(
                    view,  "Replace with your own Action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null) .show()

                }
        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id= item.itemId

        if (id == R.id.action_settings) {
             return true
            }

            return super.onOptionsItemSelected(item)
    }

        inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
            override fun getItem(position: Int): Fragment? {
                when (position) {
                    0 -> {
                        return BusinessActivity()
                    }
                    1 -> {
                        return TechActivity()
                    }
                    2 -> {
                        return BitcoinActivity()
                    }
                    else -> return null
                }
            }

            override fun getCount(): Int {
                TODO("Not yet implemented")
                return 3
            }

            override fun getPageTitle(position: Int) : CharSequence? {
                when (position) {
                    0 -> return "Business"
                    1 -> return "Tech"
                    2 -> return "Bitcoin"
                }
                return null
            }
        }
    }
}
