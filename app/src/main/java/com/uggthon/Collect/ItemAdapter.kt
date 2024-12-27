package com.uggthon.Collect

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uggthon.Collect.databinding.ItemContentBinding

class ItemAdapter(
    private val items: List<Item>,
    private val categories: Map<Int, String> // 카테고리 이름 매핑
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    // ViewHolder: 각 아이템을 표시하는 클래스
    class ViewHolder(private val binding: ItemContentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item, categoryName: String, onMemoChanged: (String) -> Unit) {
            // 이미지 설정
            binding.itemImage.setImageResource(item.imageResId)

            // 설명 설정 (카테고리와 함께 표시)
            binding.itemDescription.text = "${item.description} (${categoryName})"

            // 메모 클릭 시, 새로운 메모로 업데이트
            binding.itemDescription.setOnClickListener {
                // 예시: 메모 변경을 위한 텍스트 필드 입력 처리
                onMemoChanged("새로운 메모")
            }
        }
    }

    // ViewHolder 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // ViewHolder에 데이터를 바인딩
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        val categoryName = categories[item.category] ?: "알 수 없음"

        // 메모 변경 시, item.description을 업데이트
        holder.bind(item, categoryName) { newMemo ->
            item.description = newMemo  // 새로운 메모로 업데이트
            notifyItemChanged(position) // 해당 아이템 갱신
        }
    }

    // 아이템 개수 반환
    override fun getItemCount(): Int = items.size
}
