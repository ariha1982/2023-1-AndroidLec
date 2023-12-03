package com.example.subeye

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.subeye.databinding.FragmentLandmarkBinding
import com.example.subeye.databinding.FragmentRouteBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Locale

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val RECORD_AUDIO_PERMISSION_REQUEST_CODE = 1001

/**
 * A simple [Fragment] subclass.
 * Use the [LandmarkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LandmarkFragment : Fragment(), RecognitionListener, TextToSpeech.OnInitListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var sttResult: String = ""

    private lateinit var tts: TextToSpeech
    private lateinit var speechRecognizer: SpeechRecognizer
    lateinit var binding: FragmentLandmarkBinding

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
        val mutableList: MutableList<ItemRetrofitModel2>
        binding = FragmentLandmarkBinding.inflate(inflater, container, false)

        binding.beforeSTT2Btn.setOnClickListener {
            requestRecordAudioPermission()
        }
        binding.restartBtn2.setOnClickListener {
            changeVisibility("restart", binding)
        }

        mutableList = mutableListOf<ItemRetrofitModel2>()
        binding.landmarkRecycler.layoutManager = LinearLayoutManager(context)
        binding.landmarkRecycler.adapter = MyLandmarkAdapter(requireContext(), mutableList)

        return binding.root
    }

    fun changeVisibility(mode: String, binding: FragmentLandmarkBinding){
        if(mode.equals("sttFin")){
            binding.run {
                beforeSTT2.visibility = View.GONE
                afterSTT2.visibility = View.VISIBLE
            }
        } else if(mode.equals("restart")){
            binding.run {
                beforeSTT2.visibility = View.VISIBLE
                afterSTT2.visibility = View.GONE
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tts = TextToSpeech(requireContext(),this)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts!!.setLanguage(Locale.KOREAN)  // 언어 설정

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "이 언어는 지원되지 않습니다.")
            } else {
                // TTS 작동
                speakOut("역사ID를 찾는 페이지입니다. 버튼을 눌러 역사명을 말씀하신 후 결과로 출력되는 ID를 잘 기억해주세요.")
            }
        } else {
            Log.e("TTS", "TextToSpeech 초기화 실패")
        }
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

    private fun requestRecordAudioPermission() {
        val permission = android.Manifest.permission.RECORD_AUDIO
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                permission
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // 권한이 없을 경우 권한 요청
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(permission),
                RECORD_AUDIO_PERMISSION_REQUEST_CODE
            )
        } else {
            // 이미 권한이 있는 경우
            startSpeechToText()
        }
    }

    private fun startSpeechToText() {
        Log.d("mobileApp", "startSpeechToText 실행")
        // SpeechRecognizer 초기화
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(requireContext()).apply {
            setRecognitionListener(this@LandmarkFragment)
        }

        // RecognizerIntent 생성
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.KOREAN)
        }

        // 음성 인식 시작
        speechRecognizer.startListening(intent)
        Log.d("mobileApp", "음성인식 시작")
    }

    override fun onResults(results: Bundle?) {
        // 음성 인식 결과 처리
        val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
        if (!matches.isNullOrEmpty()) {
            sttResult = matches[0]
            val sttResultWithoutSpaces = sttResult.replace("\\s".toRegex(), "")
            val chars = sttResultWithoutSpaces.split("").toTypedArray()
            val processedResult = Array<String?>(chars.size) { null }

            for(i in chars.indices) {
                var char = chars[i]
                if (char.matches("[a-z]".toRegex())) {
                    char = char.uppercase(Locale.getDefault())
                }
                processedResult[i] = char
            }

            var realResult = processedResult.joinToString("")
            Log.d("mobileApp", "$realResult")
            Toast.makeText(requireContext(), "Recognized text: $realResult", Toast.LENGTH_SHORT)
                .show()

            performNetworkRequest(realResult)
        }
    }

    private fun performNetworkRequest(searchSt: String?) {
        val call: Call<MyBody2> = MyApplication.networkService2.getList(
            "60ECh/NfkIkgGCjHdaYvmnrDc561s/GoSnsPdh83A4hrTdmjKDUUbiRsz2mTInB1Iu9PIb7AjZDzTyFNRgFRSg==",
            "json",
            "$searchSt"
        )
        Log.d("mobileApp","${call.request()}")

        call?.enqueue(object: Callback<MyBody2> {
            override fun onResponse(call: Call<MyBody2>, response: Response<MyBody2>) {
                if(response.isSuccessful){
                    Log.d("mobileApp","${response.body()}")
                    binding.landmarkRecycler.layoutManager = LinearLayoutManager(context)
                    //binding.landmarkRecycler.adapter = MyLandmarkAdapter(requireContext(),response.body()!!.response.body.items.item)
                    changeVisibility("result", binding)
                }
            }

            override fun onFailure(call: Call<MyBody2>, t: Throwable) {
                Log.d("mobileApp", "${t.toString()}")
            }
        })
        changeVisibility("sttFin", binding)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LandmarkFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LandmarkFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onBeginningOfSpeech() {
    }

    override fun onReadyForSpeech(params: Bundle?) {
    }

    override fun onBufferReceived(buffer: ByteArray?) {
    }

    override fun onEndOfSpeech() {
    }

    override fun onError(error: Int) {
    }

    override fun onEvent(eventType: Int, params: Bundle?) {
    }

    override fun onPartialResults(partialResults: Bundle?) {
    }

    override fun onRmsChanged(rmsdB: Float) {
    }
}