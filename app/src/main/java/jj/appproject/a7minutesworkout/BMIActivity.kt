package jj.appproject.a7minutesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import jj.appproject.a7minutesworkout.databinding.ActivityBmiBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {
    private var binding: ActivityBmiBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBmiBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarBmiActivity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "BMI 계산"
        binding?.toolbarBmiActivity?.setNavigationOnClickListener {
            onBackPressed()
        }

        binding?.btnCalculateUnits?.setOnClickListener {

            if(validateMetricUnits()){

                val heightValue: Float = binding?.etMetricUnitHeight?.text.toString().toFloat() / 100
                val weightValue: Float = binding?.etMetricUnitWeight?.text.toString().toFloat()

                val bmi = weightValue / (heightValue * heightValue)

                displayBMIResult(bmi)
            }
        }
    }



    private fun validateMetricUnits(): Boolean{
        var isValid = true

        if(binding?.etMetricUnitHeight?.text.toString().isEmpty()){
            isValid = false
        }
        else if(binding?.etMetricUnitWeight?.text.toString().isEmpty()){
            isValid = false
        }
        return isValid
    }

    private fun displayBMIResult(bmi: Float) {
        val bmiLabel: String
        val bmiDescription: String

        if(bmi.compareTo(15f) <= 0){
            bmiLabel = "당신은 매우 심각한 저체중입니다."
            bmiDescription = "당신은 음식을 평소보다 많이 드셔야 합니다!"
        }
        else if(bmi.compareTo(15f) > 0 && bmi.compareTo(16f) <= 0){
            bmiLabel = "당신은 심각한 저체중입니다."
            bmiDescription = "당신은 음식을 평소보다 많이 드셔야 합니다!"
        }
        else if(bmi.compareTo(16f) > 0 && bmi.compareTo(18.5f) <= 0){
            bmiLabel = "당신은 저체중입니다."
            bmiDescription = "당신은 음식을 평소보다 많이 드셔야 합니다!"
        }
        else if(bmi.compareTo(18.5f) > 0 && bmi.compareTo(25f) <= 0){
            bmiLabel = "당신은 정상입니다."
            bmiDescription = "축하드립니다!\n정상적인 상태입니다."
        }
        else if(bmi.compareTo(25f) > 0 && bmi.compareTo(30f) <= 0){
            bmiLabel = "당신은 과체중입니다."
            bmiDescription = "당신은 체중조절할 필요가 있습니다.\n운동을 해주세요!"
        }
        else if(bmi.compareTo(30f) > 0 && bmi.compareTo(35f) <= 0){
            bmiLabel = "당신은 1단계 비만입니다."
            bmiDescription = "당신은 체중조절할 필요가 있습니다.\n운동을 해주세요!"
        }
        else if(bmi.compareTo(35f) > 0 && bmi.compareTo(40f) <= 0){
            bmiLabel = "당신은 2단계 비만입니다.(위험상태)"
            bmiDescription = "당신은 위험한 상태입니다.\n지금 당장 운동을 해주세요!"
        }
        else {
            bmiLabel = "당신은 3단계 비만입니다.(초위험상태)"
            bmiDescription = "당신은 매우 위험한 상태입니다.\n지금 당장 운동을 해주세요!"
        }

        binding?.llDisplayBMIResult?.visibility = View.VISIBLE

        val bmiValue = BigDecimal(bmi.toDouble()).setScale(2,RoundingMode.HALF_EVEN).toString()

        binding?.tvBMIValue?.text = bmiValue
        binding?.tvBMIType?.text = bmiLabel
        binding?.tvBMIDescription?.text = bmiDescription
    }
}