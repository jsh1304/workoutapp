package jj.appproject.a7minutesworkout

import android.content.Intent
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
            // ExcerciseActivity로 넘어가는 방법
            val intent = Intent(this, ExerciseActivity::class.java)
            // https://stackoverflow.com/questions/68686142/what-is-the-meaning-of-class-java
            startActivity(intent)
        }
        binding?.flBMI?.setOnClickListener {
            val intent = Intent(this, BMIActivity::class.java)
            startActivity(intent)
        }

        binding?.flHistory?.setOnClickListener {
            val intent = Intent(this,HistoryActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy(){ // memory 누락 방지 위해 binding을 해제하는 방법
        super.onDestroy()
        binding = null
    }
}