package kr.co.veritas

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = PagerAdapter(supportFragmentManager)
        adapter.addFragment(TabConferenceFragment(), "회의")
        adapter.addFragment(TabFilesFragment(), "파일 관리")
        adapter.addFragment(TabSettingFragment(), "환경 설정")
        vpMain.adapter = adapter
        tlMain.setupWithViewPager(vpMain)
        tlMain.getTabAt(0)?.setIcon(R.drawable.icon_room)
        tlMain.getTabAt(1)?.setIcon(R.drawable.icon_folder)
        tlMain.getTabAt(2)?.setIcon(R.drawable.icon_setting)
    }

    class PagerAdapter(manager: FragmentManager): FragmentPagerAdapter(manager){
        private val fragmentList = ArrayList<Fragment>()
        private val titleList = ArrayList<String>()
        override fun getItem(position: Int): Fragment = fragmentList[position]

        override fun getCount(): Int = titleList.size

        override fun getPageTitle(position: Int): CharSequence = titleList[position]

        fun addFragment(fragment:Fragment, title:String){
            fragmentList.add(fragment)
            titleList.add(title)
        }
    }
}