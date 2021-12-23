package com.example.sholatkuyv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sholatkuyv2.databinding.ActivityMainBinding
import com.example.sholatkuyv2.repository.Repository
import com.example.sholatkuyv2.ui.ArahKiblatFragment
import com.example.sholatkuyv2.ui.ArtikelIslamFragment
import com.example.sholatkuyv2.ui.WaktuSholatFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setOnNavigationListener()
    }

    private fun setOnNavigationListener() {
        val waktuSholatFragment = WaktuSholatFragment()
        val arahKiblatFragment = ArahKiblatFragment()
        val artikelIslamFragment = ArtikelIslamFragment()

        setCurrentFragment(waktuSholatFragment)

        binding.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.waktuSholat -> setCurrentFragment(waktuSholatFragment)
                R.id.arahKiblat -> setCurrentFragment(arahKiblatFragment)
                R.id.artikelIslam -> setCurrentFragment(artikelIslamFragment)
            }

            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setActionBarText(fragment)
            replace(R.id.flFragment, fragment)
            commit()
        }
    }

    private fun setActionBarText(fragment: Fragment) {
        if (fragment is WaktuSholatFragment) {
            supportActionBar?.title = "Waktu Sholat"
        } else if (fragment is ArahKiblatFragment) {
            supportActionBar?.title = "Arah Kiblat"
        } else {
            supportActionBar?.title = "Artikel Islam"
        }
    }
}