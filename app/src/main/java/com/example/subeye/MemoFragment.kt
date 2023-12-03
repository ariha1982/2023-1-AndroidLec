package com.example.subeye

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.subeye.databinding.FragmentMemoBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import java.util.Locale

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MemoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MemoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding : FragmentMemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMemoBinding.inflate(inflater, container, false)

        //myCheckPermission(requireActivity() as AppCompatActivity)

        binding.addMemoBtn.setOnClickListener {
            if(MyApplication.checkAuth()) {
                startActivity(Intent(requireContext(), AddActivity::class.java))
            }else {
                Toast.makeText(requireContext(), "인증진행해주세요..",Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    /*override fun onStart() {
        super.onStart()

        if(MyApplication.checkAuth()){
            Log.d("mobileApp", "onStart")
            MyApplication.db.collection("news")

                .orderBy("date", Query.Direction.DESCENDING)

                .get()
                .addOnSuccessListener { result ->
                    val itemList = mutableListOf<ItemMemoModel>()
                    for(document in result){
                        val item = document.toObject(ItemMemoModel::class.java)
                        item.docId = document.id
                        itemList.add(item)
                    }
                    binding.memoRecyclerView.layoutManager = LinearLayoutManager(requireContext())
                    binding.memoRecyclerView.adapter = MyMemoAdapter(requireContext(), itemList)
                }
                .addOnFailureListener{ exception ->
                    Toast.makeText(requireContext(), "서버 데이터 획득 실패", Toast.LENGTH_SHORT).show()
                }
        }
    }*/

    /*fun myCheckPermission(activity: AppCompatActivity) {
        Log.d("mobileApp", "myCheckPermission")
        val requestPermissionLauncher = activity.registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {
            if (it) {
                Toast.makeText(activity, "권한 승인", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "권한 거부", Toast.LENGTH_SHORT).show()
            }
        }

        if (ContextCompat.checkSelfPermission(
                activity, Manifest.permission.READ_EXTERNAL_STORAGE
            ) !== PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }

        if (ContextCompat.checkSelfPermission(
                activity, Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) !== PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()) {
                val intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
                activity.startActivity(intent)
            }
        }
    }*/

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MemoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MemoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}