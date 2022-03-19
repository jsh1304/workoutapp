package jj.appproject.a7minutesworkout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jj.appproject.a7minutesworkout.databinding.ItemExerciseStatusBinding

class ExerciseStatusAdapter(val items: ArrayList<ExerciseModel>):
    RecyclerView.Adapter<ExerciseStatusAdapter.ViewHolder>() {
    /* RecyclerView == ListView와 비슷, 비슷한 형식의 뷰는 몇 개만 그려놓고
     스크롤을 내리면 위의 뷰를 없애고  미리 그려진 뷰에 데이터를 할당하는 방식

     RecyclerView의 장점
     1. ListView보다 재사용성이 좋음.
     2. ViewHolder를 통해 만든 객체를 재사용하기 때문에 훨씬 효율적

     RecyclerView 사용법

     1. build.gradle(app)에 implementation 추가
     2. activity_main.xml 또는 원하는 xml에 recyclerView 추가
     3. RecyclerView 안 각 item 배치할 Layout 만들기
     4. list_item에 넣을 data class 만들기
        - ViewHolder 만들기 (ViewHolder : 데이터가 틀 안에 들어갈 수 있게 하는 기능 정의
     5. RecyclerViewAdapter 만들기
        (Adapter의 역할 = 간단히 말해 데이터 리스트를 실제 눈으로 볼 수 있게 item으로 변환하는 중간다리 역할
        = 데이터를 받아오고 이를 레이아웃에 직접연결하는 함수를 실행시키는 클래스
        = 미리 생성해둔 ViewHolder 객체에 사용자가 원하는 data list를 주입하고 data list의 변경사항을 UI에 반영
     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemExerciseStatusBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model: ExerciseModel = items[position]
        holder.tvItem.text = model.getId().toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(binding: ItemExerciseStatusBinding):
        RecyclerView.ViewHolder(binding.root){
        val tvItem = binding.tvItem
    }

}