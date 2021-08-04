package kr.co.veritas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_tab_setting.view.*

class TabSettingFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView:ViewGroup= inflater.inflate(R.layout.fragment_tab_setting, container, false) as ViewGroup

        var SettingAdapter: ArrayAdapter<String> = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1,
            arrayOf("회의 설정", "프로필 설정", "어플리케이션 설정", "파일 관리 설정"))
        rootView.lvSetting.adapter = SettingAdapter


        return rootView
    }
}