package com.crtyiot.scandemo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ScanViewModel : ViewModel() {
    private val _scanData = MutableStateFlow<List<String>>(emptyList())
    val scanData = _scanData.asStateFlow()

    fun addScanData(data: String) {
        _scanData.value += data
    }
}

@Composable
fun ScanApp(scanViewModel: ScanViewModel = viewModel()) {
    val scanData by scanViewModel.scanData.collectAsState()
    val context = LocalContext.current

    // 在这里注册BroadcastReceiver
    DisposableEffect(context) {
        val receiver = ScanReceiver.register(context) { data ->
            scanViewModel.addScanData(data)
        }
        onDispose {
            context.unregisterReceiver(receiver)
        }
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            TextField(value = scanData.lastOrNull() ?: "", onValueChange = {}, label = { Text("Scanned Data") })
            LazyColumn {
                items(scanData) { data ->
                    Text(text = data)
                }
            }
        }
    }
}
