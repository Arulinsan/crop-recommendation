package com.dicoding.mluas.menu

import android.content.Intent
import android.content.res.AssetManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dicoding.mluas.HomeActivity
import org.tensorflow.lite.Interpreter
import com.dicoding.mluas.R
import java.io.FileInputStream
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel

private lateinit var interpreter: Interpreter
private val mModelPath = "crop.tflite"

class SimulasiActivity : AppCompatActivity() {
    private val inputMeans = floatArrayOf(50.551818f, 53.362727f, 48.149091f, 25.616244f, 71.481779f, 6.469480f, 103.463655f)
    private val inputStds = floatArrayOf(36.917334f, 32.985883f, 50.647931f, 5.063749f, 22.263812f, 0.773938f, 54.958389f)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulasi)
        var resultText: TextView = findViewById(R.id.id_result)
        var edtNidrogen: TextView = findViewById(R.id.nitrogen)
        var edtFosfor: TextView = findViewById(R.id.fosfor)
        var edtKalium: TextView = findViewById(R.id.kalium)
        var edtDerajat: TextView = findViewById(R.id.derajat)
        var edtLembab: TextView = findViewById(R.id.lembab)
        var edtHidrogen: TextView = findViewById(R.id.hidrogen)
        var edtHujan: TextView = findViewById(R.id.hujan)
        var button: Button = findViewById(R.id.button2)
        var back : ImageView = findViewById(R.id.simulasi_home)

        back.setOnClickListener{
            finish()
        }
        button.setOnClickListener {
            val result = doInference1(
                edtNidrogen.text.toString(),
                edtFosfor.text.toString(),
                edtKalium.text.toString(),
                edtDerajat.text.toString(),
                edtLembab.text.toString(),
                edtHidrogen.text.toString(),
                edtHujan.text.toString()
            )
            runOnUiThread {
                val cropNames = arrayOf(
                    "apple", "banana", "blackgram", "chickpea", "coconut", "coffee",
                    "cotton", "grapes", "jute", "kidneybeans", "lentil", "maize",
                    "mango", "mothbeans", "mungbean", "muskmelon", "orange", "papaya",
                    "pigeonpeas", "pomegranate", "rice", "watermelon"
                )
                resultText.text = cropNames[result]
            }
        }
        initInterpreter()
    }

    private fun initInterpreter() {
        val options = Interpreter.Options()
        options.setNumThreads(5)
        options.setUseNNAPI(true)
        interpreter = Interpreter(loadModelFile(assets, mModelPath), options)
    }

    private fun doInference1(
        input1: String,
        input2: String,
        input3: String,
        input4: String,
        input5: String,
        input6: String,
        input7: String
    ): Int {
        val inputVal = FloatArray(7)
        inputVal[0] = (input1.toFloat() - inputMeans[0]) / inputStds[0]
        inputVal[1] = (input2.toFloat() - inputMeans[1]) / inputStds[1]
        inputVal[2] = (input3.toFloat() - inputMeans[2]) / inputStds[2]
        inputVal[3] = (input4.toFloat() - inputMeans[3]) / inputStds[3]
        inputVal[4] = (input5.toFloat() - inputMeans[4]) / inputStds[4]
        inputVal[5] = (input6.toFloat() - inputMeans[5]) / inputStds[5]
        inputVal[6] = (input7.toFloat() - inputMeans[6]) / inputStds[6]

        val output = Array(1) { FloatArray(22) }
        interpreter.run(inputVal, output)
        Log.e("result", output[0].toList().toString())
        return output[0].indexOfFirst { it == output[0].maxOrNull() }
    }

    private fun loadModelFile(assetManager: AssetManager, modelPath: String): MappedByteBuffer {
        val fileDescriptor = assetManager.openFd(modelPath)
        val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
        val fileChannel = inputStream.channel
        val startOffset = fileDescriptor.startOffset
        val declaredLength = fileDescriptor.declaredLength
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
    }
}
