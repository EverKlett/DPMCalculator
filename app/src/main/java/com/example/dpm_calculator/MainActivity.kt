package com.example.dpm_calculator

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dpm_calculator.databinding.ActivityMainBinding
import com.example.dpm_calculator.ui.theme.DPMCalculatorTheme

@Suppress("UNUSED_PARAMETER")
class MainActivity : ComponentActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    private var canAddOperation = false

    private var canAddDecimal = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
    }

    fun numberAction(view: View) {

        if (view is Button)
            Log.d("numberAction", view.text.toString())

        Log.d("view is Button", (view is Button).toString())
        Log.d("mainBinding.workingsTV", activityMainBinding.workingsTV.text.toString())
        if (view is Button) {

            if (view.text == ".") {
                if (canAddDecimal)
                    activityMainBinding.workingsTV.append(view.text)

                canAddDecimal = false
            }
            else
                activityMainBinding.workingsTV.append(view.text)

            canAddOperation = true
        }

        Log.d("mainBinding.workingsTV", activityMainBinding.workingsTV.text.toString())
    }

    fun operationAction(view: View) {

        if (view is Button)
            Log.d("operationAction", view.text.toString())

        Log.d("mainBinding.workingsTV", activityMainBinding.workingsTV.text.toString())

        if (view is Button && canAddOperation) {
            activityMainBinding.workingsTV.append(view.text)
            canAddOperation = false
            canAddDecimal = true
        }
    }

    fun allClearAction(view: View) {
        activityMainBinding.workingsTV.text = ""
        activityMainBinding.resultsTV.text = ""
    }

    fun equalsAction(view: View) {}

    fun backSpaceAction(view: View) {

        val length = activityMainBinding.workingsTV.length()

        if (length > 0)
            activityMainBinding.workingsTV.text.subSequence(0, length - 1)
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
}