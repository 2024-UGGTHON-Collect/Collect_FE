package com.uggthon.Collect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.uggthon.Collect.databinding.FragmentAlarmBinding

class AlarmFragment : Fragment() {

    private var _binding: FragmentAlarmBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: AlarmAdapter
    private val alarmList = listOf(
        R.drawable.babo, R.drawable.moon, R.drawable.bag, R.drawable.docu
    ) // 알람 이미지 리소스 리스트

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 뷰 바인딩 사용
        _binding = FragmentAlarmBinding.inflate(inflater, container, false)

        // 알림 시간 Spinner 설정
        val timeAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.alarm_time_options,  // strings.xml에서 정의한 alarm_time_options 배열
            android.R.layout.simple_spinner_item
        )
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.alarmTimeSpinner.adapter = timeAdapter

        // 알림 반복 Spinner 설정
        val repeatAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.alarm_repeat_options,  // strings.xml에서 정의한 alarm_repeat_options 배열
            android.R.layout.simple_spinner_item
        )
        repeatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.alarmRepeatSpinner.adapter = repeatAdapter

        // 리사이클러뷰 설정
        binding.alarmRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapter = AlarmAdapter(alarmList)
        binding.alarmRecyclerView.adapter = adapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // 메모리 누수를 방지하기 위해 binding을 null로 설정
    }
}