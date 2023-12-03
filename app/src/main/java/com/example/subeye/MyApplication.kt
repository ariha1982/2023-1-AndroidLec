package com.example.subeye
import android.app.Application
import androidx.multidex.MultiDexApplication
import com.example.subeye.MyApplication.Companion.db
import com.example.subeye.MyApplication.Companion.storage
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : MultiDexApplication() {
    companion object {
        lateinit var db: FirebaseFirestore
        lateinit var storage: FirebaseStorage

        lateinit var auth: FirebaseAuth
        var email: String? = null
        fun checkAuth(): Boolean {
            auth=Firebase.auth
            var currentuser = auth.currentUser
            return currentuser?.let {
                email = currentuser.email
                if (currentuser.isEmailVerified) true
                else false
            } ?: false
            return false
        }

        var networkService : NetworkService
        val retrofit: Retrofit
            get() = Retrofit.Builder()
                .baseUrl("https://apis.data.go.kr/1613000/SubwayInfoService/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        var networkService2 : NetworkService2
        val retrofit2: Retrofit
            get() = Retrofit.Builder()
                .baseUrl("https://apis.data.go.kr/1613000/SubwayInfoService/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        init{
            networkService = retrofit.create(NetworkService::class.java)
            networkService2 = retrofit2.create(NetworkService2::class.java)// 초기화
        }
    }

    override fun onCreate() {
        super.onCreate()
        auth = Firebase.auth
        db = FirebaseFirestore.getInstance()
        storage = Firebase.storage
    }
}