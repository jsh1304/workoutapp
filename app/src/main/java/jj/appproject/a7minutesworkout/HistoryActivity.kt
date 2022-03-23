package jj.appproject.a7minutesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jj.appproject.a7minutesworkout.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {
    private var binding: ActivityHistoryBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarHistoryActivity)

        val actionbar = supportActionBar
        if(actionbar != null){
            actionbar.setDisplayHomeAsUpEnabled(true)
            actionbar.title = "히스토리"
        }

        binding?.toolbarHistoryActivity?.setNavigationOnClickListener{
            onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        binding = null
    }
}