package kr.co.veritas
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_room_list.*
import kotlinx.android.synthetic.main.room_list.view.*

class RoomListActivity : AppCompatActivity() {
    class Room(_hostName:String, _roomNumber:String, _current:Int, _full:Int){
        val hostName: String = _hostName
        val roomNumber: String = _roomNumber
        val current:Int = _current
        val full:Int = _full
    }
    var roomList = ArrayList<Room>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_list)

        roomList.add(Room("정회민","1431",4,20))
        roomList.add(Room("김준연","9863",5,14))
        roomList.add(Room("이한결","6946",13,26))
        roomList.add(Room("김범준","1722",1,23))

        val adapter = RoomAdapter(this)
        lvRooms.adapter = adapter

        lvRooms.setOnItemClickListener { parent, view, position, id ->
            val room = roomList[position]
            var dlg = AlertDialog.Builder(this)
            dlg.setTitle("${room.hostName}님의 방")
            dlg.setMessage("${room.current}/${room.full}\n입장하시겠습니까?")
            dlg.setNegativeButton("닫기",null)
            dlg.setPositiveButton("확인"){ dialog, which ->
                var intent = Intent(this, ConferenceStudentActivity::class.java)
                startActivity(intent)
            }
            dlg.show()
        }

    }
    inner class RoomAdapter(private val context: Context):BaseAdapter(){
        override fun getCount(): Int {
            return roomList.size
        }

        override fun getItem(position: Int): Any {
            return roomList[position]
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view:View = LayoutInflater.from(context).inflate(R.layout.room_list, null)
            val room = roomList[position]
            view.tvHost.text = room.hostName
            view.tvRoomNumber.text = room.roomNumber
            view.tvCurrent.text = room.current.toString()
            view.tvFull.text = room.full.toString()

            return view
        }

    }
}