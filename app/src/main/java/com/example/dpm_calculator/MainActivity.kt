package com.example.dpm_calculator

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dpm_calculator.databinding.ActivityMainBinding
import com.example.dpm_calculator.ui.theme.DPMCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DPMCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }

    fun numberAction(view: View) {}
    fun operationAction(view: View) {}

    fun allClearAction(view: View) {
        val binding = ActivityMainBinding.inflate(layoutInflater);
        binding.workingsTV.text = ""
        binding.resultsTV.text = ""
    }
    fun equalsAction(view: View) {}
    fun backSpaceAction(view: View) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val length = binding.workingsTV.length()
        if (length > 0)
            binding.workingsTV.text.subSequence(0, length - 1)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DPMCalculatorTheme {
        Greeting("Android")
    }
}