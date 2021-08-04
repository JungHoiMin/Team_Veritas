package kr.co.veritas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_conference_student.*

@Suppress("DEPRECATION")
class ConferenceStudentActivity : AppCompatActivity() {
    var micOnOff:Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conference_student)

        sd.setOnDrawerOpenListener {
            ibMenuOpen.setImageResource(R.drawable.button_close_menu)
        }
        sd.setOnDrawerCloseListener {
            ibMenuOpen.setImageResource(R.drawable.ibtn_menu)
        }

        ibSharing.setOnClickListener {
            ivMain.setImageResource(R.drawable.iv_example)
        }

        ibPDF.setOnClickListener {
            var toast = Toast(this)
            val toastView = View.inflate(this, R.layout.pdf_change,null)
            toast.view = toastView
            toast.duration = Toast.LENGTH_LONG
            toast.show()
            Toast.makeText(this, "PDF 변환이 완료되었습니다.",Toast.LENGTH_SHORT).show()
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
    }
}