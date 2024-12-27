package com.uggthon.Collect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.uggthon.Collect.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance(category: String): CategoryFragment {
            val fragment = CategoryFragment()
            val args = Bundle()
            args.putString("category_name", category)
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
            Pair(R.drawable.doc, "Item 1"),
            Pair(R.drawable.babo, "Item 2"),
            Pair(R.drawable.etc, "Item 3"),
            Pair(R.drawable.bag, "Item 4"),
            Pair(R.drawable.fashion, "Item 5")
        )

        // RecyclerView 초기화
        binding.recyclerViewFrequent.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewFrequent.adapter =
            FrequentAdapter(frequentlyViewedItems) { item ->
                // 아이템 클릭 이벤트 처리
                println("Clicked on: ${item.second}")
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
