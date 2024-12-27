package com.uggthon.Collect

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.uggthon.Collect.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 뷰 바인딩 초기화
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 기본 프래그먼트 로드
        loadFragment(HomeFragment())

        // 바텀 네비게이션 리스너 설정
        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> loadFragment(HomeFragment())
                R.id.alarm -> loadFragment(AlarmFragment())
                R.id.report -> loadFragment(ReportFragment())
                R.id.my -> loadFragment(MyFragment())
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(binding.navHostFragment.id, fragment) // 뷰 바인딩 사용
            .commit()
        return true
    }
}