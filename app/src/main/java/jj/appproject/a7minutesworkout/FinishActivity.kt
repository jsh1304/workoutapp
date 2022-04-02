package jj.appproject.a7minutesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import jj.appproject.a7minutesworkout.databinding.ActivityFinishBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class FinishActivity : AppCompatActivity() {

    private var binding: ActivityFinishBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFinishBinding.inflate(layoutInflater)

        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarFinishActivity)

        if(supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        binding?.toolbarFinishActivity?.setNavigationOnClickListener {
            onBackPressed()
        }

        binding?.btnFinish?.setOnClickListener {
            finish()
        }

        val dao = (application as WorkOutApp).db.historyDao()
        addDateToDatabase(dao)
    }
    
    private fun addDateToDatabase(historyDao: HistoryDao){
        
        val c = Calendar.getInstance()
        val dateTime = c.time // 현재 날짜와 시간
        Log.e("날짜 :", "" + dateTime) //로그 안을 출력

        val sdf = SimpleDateFormat("yyyy MMM dd HH:mm:ss", Locale.getDefault())
        val date = sdf.format(dateTime)
        Log.e("날짜 형식 : ", "" + date)

        lifecycleScope.launch {
            historyDao.insert(HistoryEntity(date))
            Log.e(
                "날짜 : ",
                "추가되었습니다."
            )
        }
    }
}