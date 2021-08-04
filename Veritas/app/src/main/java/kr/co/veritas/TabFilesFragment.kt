package kr.co.veritas

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.file_list.view.*
import kotlinx.android.synthetic.main.fragment_tab_files.*
import java.util.ArrayList

class TabFilesFragment : Fragment() {
    var fileList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fileList.clear()
        fileList.add("abc.txt")
        fileList.add("자기소개.pdf")
        fileList.add("가나다.png")

//        lvFiles.adapter = FileAdapter(context) // listView에 어댑터 등록
//
//        // listView에 각 요소에 클릭 리스너 등록 (임시로 클릭하면 지워지도록 설정함)
//        lvFiles.setOnItemClickListener{parent, view, position, id ->
//            if(position == 0) return@setOnItemClickListener
//            fileList.removeAt(position - 1)
//            (parent.adapter as FileAdapter).notifyDataSetChanged()
//        }
//        (lvFiles.adapter as FileAdapter).notifyDataSetChanged()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab_files, container, false)
    }

//    inner class FileAdapter(private val context: Context): BaseAdapter(){
//        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//            var itemView = convertView
//            if(itemView == null){
//                itemView = View.inflate(context, R.layout.file_list, null)
//            }
//            if(position != 0){
//                var filename = fileList[position - 1]
//                itemView!!.tvFile.text = filename
//                if(filename.substring(filename.length-3, filename.length) == "pdf"){
//                    itemView.ivFile.setImageResource(R.drawable.button_pdf_1)
//                }
//                else{
//                    itemView.ivFile.setImageResource(R.drawable.icon_512x512)
//                }
//            }
//            return itemView!!
//        }
//
//        override fun getItem(position: Int): Any {
//            return 0
//        }
//
//        override fun getItemId(position: Int): Long {
//            return 0
//        }
//
//        override fun getCount(): Int {
//            return fileList.size + 1
//        }
//
//    }
}