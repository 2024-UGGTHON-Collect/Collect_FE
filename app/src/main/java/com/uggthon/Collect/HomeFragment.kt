package com.uggthon.Collect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.uggthon.Collect.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        // 카테고리 매핑
        val categories = mapOf(
            0 to "쇼핑",
            1 to "문서",
            2 to "SNS",
            3 to "기타"
        )

        // 샘플 데이터
        val items = listOf(
            Item(R.drawable.ic_launcher_foreground, "기본 설명", 0),
            Item(R.drawable.ic_launcher_foreground, "기본 설명", 1),
            Item(R.drawable.ic_launcher_foreground, "기본 설명", 2),
            Item(R.drawable.ic_launcher_foreground, "기본 설명", 3)
        )

        // RecyclerView 설정
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView.adapter = ItemAdapter(items, categories)

        // 1부터 31까지 버튼 동적으로 추가
        val linearLayout = binding.linearLayoutButtons
        for (i in 1..31) {
            val button = Button(requireContext())
            button.text = i.toString()

            // LinearLayout.LayoutParams로 버튼 너비와 높이 설정
            val layoutParams = LinearLayout.LayoutParams(
                150, // 버튼 너비를 100dp로 설정
                LinearLayout.LayoutParams.WRAP_CONTENT // 높이는 내용에 맞게 자동 조정
            ).apply {
                marginEnd = 25 // 버튼 간의 여백 추가
            }
            button.layoutParams = layoutParams

            // 둥근 테두리 설정 (배경 설정)
            button.setBackgroundResource(R.drawable.rounded_button)

            // 버튼을 LinearLayout에 추가
            linearLayout.addView(button)
        }

        // 버튼 클릭 리스너 설정
        binding.buttonShopping.setOnClickListener {
            navigateToCategory("쇼핑")
        }

        binding.buttonDocument.setOnClickListener {
            navigateToCategory("문서")
        }

        binding.buttonMusic.setOnClickListener {
            navigateToCategory("음악")
        }

        binding.buttonEtc.setOnClickListener {
            navigateToCategory("기타")
        }

        return binding.root
    }

    // 카테고리 프래그먼트로 이동하는 함수
    private fun navigateToCategory(categoryName: String) {
        val fragment = CategoryFragment.newInstance(categoryName)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null) // 뒤로 가기 가능
            .commit()
    }
}
