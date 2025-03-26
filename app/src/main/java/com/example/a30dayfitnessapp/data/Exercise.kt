package com.example.a30dayfitnessapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.text.util.LocalePreferences.FirstDayOfWeek.Days
import com.example.a30dayfitnessapp.R

data class Exercise(
    val day: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val duration: Int,
    @StringRes val description: Int
)

val exercises = listOf(
    Exercise(1,R.drawable.pushups, R.string.exercise_name_1, 10, R.string.exercise_description_1),
    Exercise(2,R.drawable.squats, R.string.exercise_name_2, 15, R.string.exercise_description_2),
    Exercise(3,R.drawable.lunges, R.string.exercise_name_3, 12, R.string.exercise_description_3),
    Exercise(4,R.drawable.plank, R.string.exercise_name_4, 5, R.string.exercise_description_4),
    Exercise(5,R.drawable.jumping_jacks, R.string.exercise_name_5, 8, R.string.exercise_description_5),
    Exercise(6,R.drawable.burpees, R.string.exercise_name_6, 10, R.string.exercise_description_6),
    Exercise(7,R.drawable.mountain_climbers, R.string.exercise_name_7, 8, R.string.exercise_description_7),
    Exercise(8,R.drawable.high_knees, R.string.exercise_name_8, 7, R.string.exercise_description_8),
    Exercise(9,R.drawable.crunches, R.string.exercise_name_9, 10, R.string.exercise_description_9),
    Exercise(10,R.drawable.bicycle_crunches, R.string.exercise_name_10, 10, R.string.exercise_description_10),
    Exercise(11,R.drawable.triceps_dips, R.string.exercise_name_11, 8, R.string.exercise_description_11),
    Exercise(12,R.drawable.wall_sit, R.string.exercise_name_12, 6, R.string.exercise_description_12),
    Exercise(13,R.drawable.russian_twists, R.string.exercise_name_13, 12, R.string.exercise_description_13),
    Exercise(14,R.drawable.superman, R.string.exercise_name_14, 10, R.string.exercise_description_14),
    Exercise(15,R.drawable.jump_squats, R.string.exercise_name_15, 8, R.string.exercise_description_15),
    Exercise(16,R.drawable.side_plank, R.string.exercise_name_16, 5, R.string.exercise_description_16),
    Exercise(17,R.drawable.calf_raises, R.string.exercise_name_17, 15, R.string.exercise_description_17),
    Exercise(18,R.drawable.leg_raises, R.string.exercise_name_18, 10, R.string.exercise_description_18),
    Exercise(19,R.drawable.dead_bug, R.string.exercise_name_19, 8, R.string.exercise_description_19),
    Exercise(20,R.drawable.glute_bridges, R.string.exercise_name_20, 10, R.string.exercise_description_20),
    Exercise(21,R.drawable.reverse_lunges, R.string.exercise_name_21, 12, R.string.exercise_description_21),
    Exercise(22,R.drawable.step_ups, R.string.exercise_name_22, 10, R.string.exercise_description_22),
    Exercise(23,R.drawable.shadow_boxing, R.string.exercise_name_23, 15, R.string.exercise_description_23),
    Exercise(24,R.drawable.arm_circles, R.string.exercise_name_24, 8, R.string.exercise_description_24),
    Exercise(25,R.drawable.flutter_kicks, R.string.exercise_name_25, 10, R.string.exercise_description_25),
    Exercise(26,R.drawable.side_lunges, R.string.exercise_name_26, 12, R.string.exercise_description_26),
    Exercise(27,R.drawable.bear_crawl, R.string.exercise_name_27, 6, R.string.exercise_description_27),
    Exercise(28,R.drawable.tuck_jumps, R.string.exercise_name_28, 7, R.string.exercise_description_28),
    Exercise(29,R.drawable.hip_thrusts, R.string.exercise_name_29, 10, R.string.exercise_description_29),
    Exercise(30,R.drawable.jump_rope, R.string.exercise_name_30, 15, R.string.exercise_description_30)
)
