package me.rohinee.todo.service


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class ServiceControlActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ServiceControlScreen(
                onStart = {
                    val startIntent = Intent(this, MyService::class.java).apply {
                        action = MyService.ACTION_START
                    }
                    startService(startIntent)
                    Toast.makeText(this, "Service start requested", Toast.LENGTH_SHORT).show()
                },
                onStop = {
                    val stopIntent = Intent(this, MyService::class.java).apply {
                        action = MyService.ACTION_STOP
                    }
                    startService(stopIntent) // send stop action to service
                    Toast.makeText(this, "Service stop requested", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}

@Composable
fun ServiceControlScreen(onStart: () -> Unit, onStop: () -> Unit) {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = onStart, modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
                Text("Start Service")
            }
            Button(onClick = onStop, modifier = Modifier.fillMaxWidth()) {
                Text("Stop Service")
            }
        }
    }
}