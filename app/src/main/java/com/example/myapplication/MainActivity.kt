package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import com.example.myapplication.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var changeLang: (String) -> Unit = {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.btnTranslation.isVisible=
                destination.id==R.id.attractionsFragment
            binding.title.text =when(destination.id){
                R.id.attractionsFragment->getString(R.string.title_attractions)
                else -> {""}
            }
            binding.btnBack.isVisible=
                destination.id!=R.id.attractionsFragment
        }
        binding.btnTranslation.setOnClickListener {
            showDialog()
        }
        binding.btnBack.setOnClickListener { onBackPressed() }
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        with(builder)
        {
            val items = arrayOf("zh-tw", "zh-cn", "en", "ja", "ko", "es", "id", "th", "vi")
            setItems(items) { dialog, which ->
                changeLang.invoke(items[which])
                updateLang(items[which])
                dialog.dismiss()
            }

             show()


        }

    }
    private fun updateLang(lang:String){
        val config = resources.configuration
        val locale = Locale(lang)
        Locale.setDefault(locale)
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
        binding.title.text =getString(R.string.title_attractions)
    }

}