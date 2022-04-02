package jj.appproject.a7minutesworkout

import java.util.ArrayList

class Constants {
    companion object {

        fun defaultExerciseList(): ArrayList<ExerciseModel> {
            val exerciseList = ArrayList<ExerciseModel>()

            val jumpingJacks =
                ExerciseModel(
                    1,
                    "팔벌려뛰기",
                    R.drawable.ic_jumping_jacks,
                    false,
                    false
                )
            exerciseList.add(jumpingJacks)

            val wallSit =
                ExerciseModel(
                    2,
                    "벽 기대어 앉기",
                    R.drawable.ic_wall_sit,
                    false,
                    false
                )
            exerciseList.add(wallSit)

            val kneePushUp =
                ExerciseModel(
                    3,
                    "무릎꿇고 팔굽혀펴기",
                    R.drawable.ic_knee_push_up,
                    false,
                    false
                )
            exerciseList.add(kneePushUp)

            val pushUp =
                ExerciseModel(
                    4,
                    "팔굽혀펴기",
                    R.drawable.ic_push_up,
                    false,
                    false
                )
            exerciseList.add(pushUp)

            val plank =
                ExerciseModel(
                    5,
                    "플랭크",
                    R.drawable.ic_plank,
                    false,
                    false
                )
            exerciseList.add(plank)

            val sidePlank =
                ExerciseModel(
                    6,
                    "사이드 플랭크",
                    R.drawable.ic_side_plank,
                    false,
                    false
                )
            exerciseList.add(sidePlank)

            val abdominalCrunch =
                ExerciseModel(
                    7,
                    "복근운동",
                    R.drawable.ic_abdominal_crunch,
                    false,
                    false
                )
            exerciseList.add(abdominalCrunch)

            val lunge =
                ExerciseModel(
                    8,
                    "런지",
                    R.drawable.ic_lunge,
                    false,
                    false
                )
            exerciseList.add(lunge)

            val squat =
                ExerciseModel(
                    9,
                    "스쿼트",
                    R.drawable.ic_squat,
                    false,
                    false
                )
            exerciseList.add(squat)

            val tricepsDip =
                ExerciseModel(
                    10,
                    "트라이셉 딥(Triceps Dip)",
                    R.drawable.ic_triceps_dip,
                    false,
                    false
                )
            exerciseList.add(tricepsDip)

            val highKneesRunning =
                ExerciseModel(
                    11,
                    "제자리 무릎 높여 달리기",
                    R.drawable.ic_high_knees_running,
                    false,
                    false
                )
            exerciseList.add(highKneesRunning)


            val stepUp =
                ExerciseModel(
                    12,
                    "스텝업",
                    R.drawable.ic_step_up,
                    false,
                    false
                )
            exerciseList.add(stepUp)

            return exerciseList
        }
    }
}
