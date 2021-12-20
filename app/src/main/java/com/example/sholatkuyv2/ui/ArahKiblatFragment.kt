package com.example.sholatkuyv2.ui

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import com.example.sholatkuyv2.R
import com.example.sholatkuyv2.databinding.FragmentArahKiblatBinding
import android.hardware.SensorEvent

import android.hardware.SensorEventListener
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import kotlin.math.roundToInt


class ArahKiblatFragment : Fragment(), SensorEventListener {

    private var _binding: FragmentArahKiblatBinding? = null
    private val binding get() = _binding
    private var mSensorManager: SensorManager? = null
    private var mAccelerometer: Sensor? = null
    private var currentDegree: Float = 0.0f

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentArahKiblatBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mSensorManager = activity?.getSystemService(Context.SENSOR_SERVICE) as SensorManager?
        mAccelerometer = mSensorManager?.getDefaultSensor(Sensor.TYPE_ORIENTATION)

        mSensorManager?.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onSensorChanged(event: SensorEvent) {

        var degree: Float = Math.round(event.values[0]).toFloat()
        var animation = RotateAnimation(
            currentDegree,
            -degree,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )

        animation.duration = 500
        animation.fillAfter = true
        binding?.compass?.animation = animation
        currentDegree = -degree
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}