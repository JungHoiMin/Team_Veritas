package kr.co.veritas

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.fragment_tab_conference.view.*

class TabConferenceFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView:ViewGroup= inflater.inflate(R.layout.fragment_tab_conference, container, false) as ViewGroup

        // 회의 만들기
        rootView.btnMakeConference.setOnClickListener {
            var dlg = AlertDialog.Builder(requireContext())
            dlg.setTitle("회의 만들기")
            dlg.setMessage("김범준님 회의를 만드시겠습니까?")
            dlg.setNegativeButton("닫기",null)
            dlg.setPositiveButton("확인"){ dialog, which ->
                var intent = Intent(activity, ConferenceActivity::class.java)
                startActivity(intent)
            }
            dlg.show()
        }

        // 회의 참가
        rootView.btnEnterRoom.setOnClickListener {
            var intent = Intent(activity, RoomListActivity::class.java)
            startActivity(intent)
        }



        return rootView
    }

}