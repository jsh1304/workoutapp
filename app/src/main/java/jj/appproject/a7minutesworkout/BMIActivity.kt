package jj.appproject.a7minutesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import jj.appproject.a7minutesworkout.databinding.ActivityBmiBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {

    companion object{
        private  const val METRIC_UNITS_VIEW = "METRIC_UNITS_VIEW"
        private  const val US_UNITS_VIEW = "US_UNITS_VIEW"
    }

    private var currentVisibleView: String = METRIC_UNITS_VIEW

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

        makeVisibleMetricUnitsView()

        binding?.rgUnits?.setOnCheckedChangeListener { _, checkedId: Int ->

            if(checkedId == R.id.rbMetricUnits)
                makeVisibleMetricUnitsView()
            else
                makeVisibleUSUnitsView()
        }

        binding?.btnCalculateUnits?.setOnClickListener {

            calculateUnits()
        }
    }

    private fun calculateUnits() {
        if(currentVisibleView == METRIC_UNITS_VIEW) {
            if(validateMetricUnits()){

                val heightValue: Float = binding?.etMetricUnitHeight?.text.toString().toFloat() / 100
                val weightValue: Float = binding?.etMetricUnitWeight?.text.toString().toFloat()

                val bmi = weightValue / (heightValue * heightValue)

                displayBMIResult(bmi)
            }
            else{
                Toast.makeText(
                    this@BMIActivity,
                    "값을 입력해주세요.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        else {
            if(validateUSUnits()){

                val usUnitHeightValueFeet: String = binding?.etUSUnitHeightFeet?.text.toString()
                val usUnitHeightValueInch: String = binding?.etUSUnitHeightInch?.text.toString()
                val usUnitWeightValue: Float = binding?.etUSUnitWeight?.text.toString().toFloat()

                val heightValue =
                    usUnitHeightValueFeet.toFloat() * 12 + usUnitHeightValueInch.toFloat()

                val bmi = 703 * ( usUnitWeightValue / (heightValue * heightValue) )

                displayBMIResult(bmi)
            }
            else{
                Toast.makeText(
                    this@BMIActivity,
                    "값을 입력해주세요.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun makeVisibleMetricUnitsView() {
        currentVisibleView = METRIC_UNITS_VIEW

        binding?.tilMetricUnitHeight?.visibility = View.VISIBLE
        binding?.tilMetricUnitWeight?.visibility = View.VISIBLE

        binding?.tilUSUnitWeight?.visibility = View.GONE
        binding?.tilUSUnitHeightFeet?.visibility = View.GONE
        binding?.tilUSUnitHeightInch?.visibility = View.GONE

        binding?.etMetricUnitHeight?.text!!.clear()
        binding?.etMetricUnitWeight?.text!!.clear()

        binding?.llDisplayBMIResult?.visibility = View.INVISIBLE
    }

    private fun makeVisibleUSUnitsView() {
        currentVisibleView = US_UNITS_VIEW

        binding?.tilMetricUnitHeight?.visibility = View.INVISIBLE // GONE X
        binding?.tilMetricUnitWeight?.visibility = View.INVISIBLE // GONE X

        binding?.tilUSUnitWeight?.visibility = View.VISIBLE
        binding?.tilUSUnitHeightFeet?.visibility = View.VISIBLE
        binding?.tilUSUnitHeightInch?.visibility = View.VISIBLE

        binding?.etUSUnitHeightFeet?.text!!.clear()
        binding?.etUSUnitHeightInch?.text!!.clear()
        binding?.etUSUnitWeight?.text!!.clear()

        binding?.llDisplayBMIResult?.visibility = View.INVISIBLE
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

    private fun validateUSUnits(): Boolean{
        var isValid = true

        when{
            binding?.etUSUnitHeightFeet?.text.toString().isEmpty() -> {
                isValid = false
            }
            binding?.etUSUnitHeightInch?.text.toString().isEmpty() -> {
            isValid = false
            }
            binding?.etUSUnitWeight?.text.toString().isEmpty() -> {
                isValid = false
            }
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