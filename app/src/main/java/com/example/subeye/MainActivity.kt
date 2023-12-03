package com.example.subeye

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.preference.PreferenceManager
import com.example.subeye.MyApplication.Companion.auth
import com.example.subeye.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.Locale

class MainActivity : AppCompatActivity(), OnInitListener {

    lateinit var binding: ActivityMainBinding
    lateinit var routeFragment: RouteFragment
    lateinit var memoFragment: MemoFragment
    lateinit var landmarkFragment: LandmarkFragment
    lateinit var settingsFragment: SettingsFragment
    lateinit var sharedPreferences: SharedPreferences

    var mode = "route"

    private var tts: TextToSpeech? = null
    var authMenuItem: MenuItem? = null

    val sharedPreferencesListener =
        SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            if (key == "actionBar_color") {
                applyThemeColor()
            }
            else if(key == "tx_color") {
                applyTextColor()
            }
            /*else if(key == "tts_speed"){
                applyTTSSpeed()
            }
            else if(key == "tts_pitch"){
                applyTTSPitch()
            }*/
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        routeFragment = RouteFragment()
        memoFragment = MemoFragment()
        landmarkFragment = LandmarkFragment()
        settingsFragment = SettingsFragment()


        setSupportActionBar(binding.toolBar)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, routeFragment)
            .commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, landmarkFragment)
            .hide(landmarkFragment)
            .commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, memoFragment)
            .hide(memoFragment)
            .commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, settingsFragment)
            .hide(settingsFragment)
            .commit()

        val bottomNavigation: BottomNavigationView = findViewById(R.id.nav_view)
        bottomNavigation.setOnItemSelectedListener {it ->
            if(it.itemId === R.id.nav_route && mode != "route") {
                supportFragmentManager.beginTransaction()
                    .show(routeFragment)
                    .commit()
                supportFragmentManager.beginTransaction()
                    .hide(landmarkFragment)
                    .commit()
                supportFragmentManager.beginTransaction()
                    .hide(memoFragment)
                    .commit()
                supportFragmentManager.beginTransaction()
                    .hide(settingsFragment)
                    .commit()
                mode = "route"
            } else if(it.itemId === R.id.nav_landmark && mode != "landmark") {
                supportFragmentManager.beginTransaction()
                    .show(landmarkFragment)
                    .commit()
                supportFragmentManager.beginTransaction()
                    .hide(routeFragment)
                    .commit()
                supportFragmentManager.beginTransaction()
                    .hide(memoFragment)
                    .commit()
                supportFragmentManager.beginTransaction()
                    .hide(settingsFragment)
                    .commit()
                mode = "landmark"
            } else if(it.itemId === R.id.nav_memo && mode != "memo") {
                supportFragmentManager.beginTransaction()
                    .show(memoFragment)
                    .commit()
                supportFragmentManager.beginTransaction()
                    .hide(routeFragment)
                    .commit()
                supportFragmentManager.beginTransaction()
                    .hide(landmarkFragment)
                    .commit()
                supportFragmentManager.beginTransaction()
                    .hide(settingsFragment)
                    .commit()
                mode = "memo"
            } else if(it.itemId === R.id.nav_setting && mode != "setting") {
                supportFragmentManager.beginTransaction()
                    .show(settingsFragment)
                    .commit()
                supportFragmentManager.beginTransaction()
                    .hide(routeFragment)
                    .commit()
                supportFragmentManager.beginTransaction()
                    .hide(landmarkFragment)
                    .commit()
                supportFragmentManager.beginTransaction()
                    .hide(memoFragment)
                    .commit()
                mode = "setting"
            }
            true
        }

        bottomNavigation.selectedItemId = R.id.nav_route

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        sharedPreferences.registerOnSharedPreferenceChangeListener(sharedPreferencesListener)

        tts = TextToSpeech(this, this)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts!!.setLanguage(Locale.KOREAN)  // 언어 설정

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "이 언어는 지원되지 않습니다.")
            } else {
                // TTS 작동
                speakOut("지하를 밝히는 눈, 서브아이입니다.")
            }
        } else {
            Log.e("TTS", "TextToSpeech 초기화 실패")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        authMenuItem = menu!!.findItem(R.id.menu_login)
        auth = Firebase.auth
        if(MyApplication.checkAuth()){
            authMenuItem!!.title = "${MyApplication.email}님"
        }
        else {
            authMenuItem!!.title = "로그인"
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onStart() {
        //Intent에서 finish 되고 다시 돌아올 때 실행되는 부분
        super.onStart()

        if(authMenuItem != null){
            if(MyApplication.checkAuth()){
                authMenuItem!!.title = "${MyApplication.email}님"
            }
            else {
                authMenuItem!!.title = "로그인"
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId === R.id.menu_login){
            val intent = Intent(this,AuthActivity::class.java)
            if(authMenuItem!!.title!!.equals("로그인")){
                intent.putExtra("data", "logout")
            }
            else {
                intent.putExtra("data", "login")
            }
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()

        val themeColor: String? = sharedPreferences.getString("actionBar_color", "#9fd3aa")
        binding.toolBar.setBackgroundColor(Color.parseColor(themeColor))
        val textColor = sharedPreferences.getString("tx_color", "#FFFFFF")
        binding.toolBar.setTitleTextColor(Color.parseColor(textColor))
        /*val pitch = sharedPreferences.getFloat("tts_pitch", 0.1f)
        tts?.setPitch(pitch)
        val speed = sharedPreferences.getFloat("tts_speed", 0.1f)
        tts?.setSpeechRate(speed)*/
    }

    private fun speakOut(text: String) {
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    override fun onDestroy() {
        super.onDestroy()
        // TTS 종료
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
    }

    private fun applyThemeColor() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val themeColor = sharedPreferences.getString("actionBar_color", "#9fd3aa")
        binding.toolBar.setBackgroundColor(Color.parseColor(themeColor))
    }

    private fun applyTextColor() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val textColor = sharedPreferences.getString("tx_color", "#FFFFFF")
        binding.toolBar.setTitleTextColor(Color.parseColor(textColor))
    }

    /*private fun applyTTSSpeed() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val speed = sharedPreferences.getFloat("tts_speed", 0.1f)
        tts?.setSpeechRate(speed)
    }

    private fun applyTTSPitch() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val pitch = sharedPreferences.getFloat("tts_pitch", 0.1f)
        tts?.setPitch(pitch)
    }*/
}