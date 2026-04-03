package com.sallyjayz.colabsroomaccess

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sallyjayz.colabsroomaccess.ui.TopBottomBar
import com.sallyjayz.colabsroomaccess.ui.email_verification.EmailVerificationTwoScreen
import com.sallyjayz.colabsroomaccess.ui.explore.ExploreRoomDetailsScreen
import com.sallyjayz.colabsroomaccess.ui.theme.ColabsRoomAccessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ColabsRoomAccessTheme {
                ExploreRoomDetailsScreen()
//                TopBottomBar(modifier = Modifier.fillMaxSize())
            }
        }
    }
}