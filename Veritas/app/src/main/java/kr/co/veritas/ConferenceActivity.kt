package kr.co.veritas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_conference.*

@Suppress("DEPRECATION")
class ConferenceActivity : AppCompatActivity() {
    var micOnOff:Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conference)

        ivMe.setOnClickListener {   // 프로세스 관리 앱 실행시 toast
            var toast = Toast.makeText(this,"\"박자범\"님이 \"YouTube\"을(를) 실행"
                ,Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.TOP,100,100)
            toast.show()
        }

        sd.setOnDrawerOpenListener {
            ibMenuOpen.setImageResource(R.drawable.button_close_menu)
        }
        sd.setOnDrawerCloseListener {
            ibMenuOpen.setImageResource(R.drawable.ibtn_menu)
        }

        ibSharing.setOnClickListener {
            ivMain.setImageResource(R.drawable.iv_example)
        }

        ibAttention.setOnClickListener {
            ivMain.setImageResource(R.drawable.group)
        }

        ibLookStudent.setOnClickListener {
            ivMain.setImageResource(R.drawable.students)
        }

        ibMic.setOnClickListener {
            if(micOnOff){
                ibMic.setImageResource(R.drawable.button_micoff_1)
                micOnOff = false
            }
            else{
                ibMic.setImageResource(R.drawable.button_micon_1)
                micOnOff = true
            }
        }

        btnClose.setOnClickListener {
            finish()
        }
    }
}