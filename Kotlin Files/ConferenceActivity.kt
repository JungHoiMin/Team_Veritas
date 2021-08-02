@file:Suppress("DEPRECATION")

package kr.co.veritas

import android.app.TabActivity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.lvFiles
import kotlinx.android.synthetic.main.file_list.view.*
import java.util.*

class ConferenceActivity : TabActivity() {
    var fileList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fileList.clear()
        fileList.add("abc.txt")
        fileList.add("가나다.txt")

        var tabConference = tabHost.newTabSpec("Conference").setIndicator("회의")
        tabConference.setContent(R.id.llConference)
        tabHost.addTab(tabConference)

        var tabFiles = tabHost.newTabSpec("Files").setIndicator("파일관리")
        tabFiles.setContent(R.id.llFiles)
        tabHost.addTab(tabFiles)

        var tabSetting = tabHost.newTabSpec("Setting").setIndicator("환경설정")
        tabSetting.setContent(R.id.llSetting)
        tabHost.addTab(tabSetting)

        tabHost.currentTab = 0

        lvFiles.adapter = MyAdapter(this)
        lvFiles.setOnItemClickListener{parent, view, position, id ->
            if(position == 0) return@setOnItemClickListener
            fileList.removeAt(position - 1)
            (parent.adapter as MainActivity.MyAdapter).notifyDataSetChanged()
        }

        (lvFiles.adapter as MainActivity.MyAdapter).notifyDataSetChanged()
    }
    inner class MyAdapter(val context: Context): BaseAdapter(){
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var itemView = convertView
            if(itemView == null){
                itemView = View.inflate(context, R.layout.file_list, null)
            }
            if(position != 0){
                itemView!!.tvFile.text = fileList[position - 1]
                itemView.ivFile.setImageResource(R.drawable.logo)
            }
            return itemView!!
        }

        override fun getItem(position: Int): Any {
            return 0
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getCount(): Int {
            return fileList.size + 1
        }

    }
}
