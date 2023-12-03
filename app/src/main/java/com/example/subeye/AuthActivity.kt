package com.example.subeye

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.subeye.MyApplication.Companion.auth
import com.example.subeye.databinding.ActivityAuthBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.OAuthProvider

class AuthActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthBinding
    private val provider = OAuthProvider.newBuilder("github.com")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.urgentCall.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:/119"))
            startActivity(intent)
        }

        changeVisibility(intent.getStringExtra("data").toString())
        binding.goSignInBtn.setOnClickListener{
            // 회원가입
            changeVisibility("signin")
        }

        binding.signBtn.setOnClickListener {
            //이메일,비밀번호 회원가입........................
            val email:String = binding.authEmailEditView.text.toString()
            val password:String = binding.authPasswordEditView.text.toString()
            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this){ task ->
                    if(task.isSuccessful){
                        auth.currentUser?.sendEmailVerification()?.addOnCompleteListener{
                                sendTask ->
                            if(sendTask.isSuccessful){
                                Toast.makeText(baseContext, "회원가입 성공...이메일 확인", Toast.LENGTH_LONG).show()
                                changeVisibility("logout")
                            }
                            else{
                                Toast.makeText(baseContext, "메일 전송 실패...", Toast.LENGTH_LONG).show()
                                changeVisibility("logout")
                            }
                        }
                    }
                    else{
                        Toast.makeText(baseContext, "회원가입 실패...", Toast.LENGTH_LONG).show()
                        changeVisibility("logout")
                    }
                    binding.authEmailEditView.text.clear()
                    binding.authPasswordEditView.text.clear()
                }
        }

        binding.loginBtn.setOnClickListener {
            //이메일, 비밀번호 로그인.......................
            val email:String = binding.authEmailEditView.text.toString()
            val password:String = binding.authPasswordEditView.text.toString()
            auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this){task ->
                    if(task.isSuccessful){
                        if(MyApplication.checkAuth()){
                            MyApplication.email = email
                            changeVisibility("login")
                            finish()
                        }
                        else{
                            Toast.makeText(baseContext, "이메일 인증 실패...", Toast.LENGTH_LONG).show()
                        }
                    }
                    else{
                        Toast.makeText(baseContext, "로그인 실패...", Toast.LENGTH_LONG).show()
                        changeVisibility("logout")
                    }
                    binding.authEmailEditView.text.clear()
                    binding.authPasswordEditView.text.clear()
                }
        }

        binding.logoutBtn.setOnClickListener {
            //로그아웃...........
            MyApplication.auth.signOut()
            MyApplication.email = null
            changeVisibility("logout")
            finish()
        }

        val requestLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            //api exception 처리
            try {
                val account = task.getResult(ApiException::class.java)
                val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                auth.signInWithCredential(credential)
                    .addOnCompleteListener(this){task ->
                        if(task.isSuccessful){
                            MyApplication.email = account.email
                            changeVisibility("login")
                            Log.d("mobileApp", "GoogleSingIn - Successful")
                            finish()
                        }
                        else{
                            changeVisibility("logout")
                            Log.d("mobileApp", "GoogleSingIn - Not Successful")
                        }
                    }
            } catch (e: ApiException){
                changeVisibility("logout")
                Log.d("mobileApp", "GoogleSingIn - ${e.message}")
            }
        }
        binding.googleLoginBtn.setOnClickListener {
            //구글 로그인....................
            val gso : GoogleSignInOptions = GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

            val signInIntent : Intent = GoogleSignIn.getClient(this, gso).signInIntent
            requestLauncher.launch(signInIntent)
        }
        binding.githubLoginBtn.setOnClickListener {
            //Github 로그인
            auth.startActivityForSignInWithProvider(this, provider.build())
                .addOnSuccessListener (
                    OnSuccessListener<AuthResult?> {authResult ->
                        auth.signInWithCredential(authResult.credential!!)
                            .addOnCompleteListener(this@AuthActivity) { task ->
                                if (task.isSuccessful) {
                                    finish()
                                } else {
                                    Toast.makeText(this, "깃허브 로그인 실패", Toast.LENGTH_LONG).show()
                                }
                            }
                    })
                .addOnFailureListener(
                    OnFailureListener {
                        Toast.makeText(this, "Error : $it", Toast.LENGTH_LONG).show()
                    })
        }
    }

    fun changeVisibility(mode: String){
        if(mode.equals("signin")){
            binding.run {
                logoutBtn.visibility = View.GONE
                goSignInBtn.visibility = View.GONE
                googleLoginBtn.visibility = View.GONE
                githubLoginBtn.visibility = View.GONE
                authEmailEditView.visibility = View.VISIBLE
                authPasswordEditView.visibility = View.VISIBLE
                signBtn.visibility = View.VISIBLE
                loginBtn.visibility = View.GONE
            }
        }else if(mode.equals("login")){
            binding.run {
                authMainTextView.text = "${MyApplication.email} 님 반갑습니다."
                logoutBtn.visibility= View.VISIBLE
                goSignInBtn.visibility= View.GONE
                googleLoginBtn.visibility= View.GONE
                githubLoginBtn.visibility = View.GONE
                authEmailEditView.visibility= View.GONE
                authPasswordEditView.visibility= View.GONE
                signBtn.visibility= View.GONE
                loginBtn.visibility= View.GONE
            }

        }else if(mode.equals("logout")){
            binding.run {
                authMainTextView.text = "로그인 하거나 회원가입 해주세요."
                logoutBtn.visibility = View.GONE
                goSignInBtn.visibility = View.VISIBLE
                googleLoginBtn.visibility = View.VISIBLE
                githubLoginBtn.visibility = View.VISIBLE
                authEmailEditView.visibility = View.VISIBLE
                authPasswordEditView.visibility = View.VISIBLE
                signBtn.visibility = View.GONE
                loginBtn.visibility = View.VISIBLE
            }
        }
    }
}