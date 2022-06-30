package com.dmitrycho.kston

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dmitrycho.kston.fragments.ContestFragment
import com.dmitrycho.kston.fragments.MyContestFragment
import com.dmitrycho.kston.fragments.MyPageFragment
import com.dmitrycho.kston.fragments.MyTeamFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val contestFragment = ContestFragment()
        val myContestFragment = MyContestFragment()
        val myTeamFragment = MyTeamFragment()
        val myPageFragment = MyPageFragment()

        makeCurrentFragment(contestFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.ic_contest -> makeCurrentFragment(contestFragment)
                R.id.ic_myContest -> makeCurrentFragment(myContestFragment)
                R.id.ic_myTeam -> makeCurrentFragment(myTeamFragment)
                R.id.ic_myPage -> makeCurrentFragment(myPageFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}