package de.ckitte.viewpager2exampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewPager2()
    }

    private fun initViewPager2() {
        // ViewPager initialisieren
        var viewPager: ViewPager2 = findViewById(R.id.viewpager)
        var adapter = ViewPagerViewAdapter()

        viewPager.adapter = adapter
        adapter.setNewUser(createExampleUserList())

        viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL

        var tabLayout: TabLayout = findViewById(R.id.tablayout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = createExampleUserList()[position].name
        }.attach()
    }

    private fun createExampleUserList(): ArrayList<User> {
        var export: ArrayList<User> = ArrayList()
        export.add(User(name = "Kitte", firstName = "Christian"))
        export.add(User(name = "Hermann", firstName = "Doris"))
        export.add(User(name = "Witte", firstName = "Bernd"))

        return export
    }
}