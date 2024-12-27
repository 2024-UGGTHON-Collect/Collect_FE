package com.uggthon.Collect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.uggthon.Collect.databinding.FragmentCategoryBinding
import com.uggthon.Collect.databinding.ItemFrequentBinding

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    companion object {
        // 카테고리 이름을 인자로 받는 newInstance 메서드
        fun newInstance(category: String): CategoryFragment {
            val fragment = CategoryFragment()
            val args = Bundle()
            args.putString("category_name", category) // 카테고리 이름을 Bundle에 저장
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 샘플 데이터
        val frequentlyViewedItems = listOf(
            Pair(R.drawable.ic_launcher_background, "Item 1"),
            Pair(R.drawable.ic_launcher_background, "Item 2"),
            Pair(R.drawable.ic_launcher_background, "Item 3"),
            Pair(R.drawable.ic_launcher_background, "Item 4"),
            Pair(R.drawable.ic_launcher_background, "Item 5")
        )

        // 동적으로 아이템 추가
        for ((imageRes, title) in frequentlyViewedItems) {
            val itemBinding = ItemFrequentBinding.inflate(layoutInflater, binding.frequentlyViewedContainer, false)
            itemBinding.imageFrequent.setImageResource(imageRes)
            itemBinding.textFrequent.text = title

            // 클릭 이벤트 설정 (필요시)
            itemBinding.root.setOnClickListener {
                // 클릭 시 동작
            }

            binding.frequentlyViewedContainer.addView(itemBinding.root)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
