package jj.appproject.a7minutesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import jj.appproject.a7minutesworkout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root) // view binding 접근 방식으로 작성

        //val flStartButton : FrameLayout = findViewById(R.id.flstart)
        binding?.flstart?.setOnClickListener{
            Toast.makeText(
                this@MainActivity,
                "운동시작!!",
                Toast.LENGTH_SHORT
            ).show()

        }
    }

    override fun onDestroy(){ // memory 누락 방지 위해 binding을 해제하는 방법
        super.onDestroy()

        binding = null
    }
}