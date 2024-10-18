package com.example.a17app

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

private val novosibirsk = LatLng(55.0084, 82.9346)

@Composable
fun MapActivity(navController: NavController) {

}

@Composable
fun GoogleMapView() {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(novosibirsk, 10f)
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        onMapLoaded = {
            cameraPositionState.move(
                CameraUpdateFactory.newLatLngZoom(novosibirsk, 10f)
            )
        }
    ) {
        Marker(
            state = MarkerState(position = novosibirsk),
            title = "Новосибирск",
            snippet = null
        )
    }
}


@Composable
fun SideMenuExample() {
    var isMenuVisible by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(onClick = { isMenuVisible = !isMenuVisible }) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
        }

        if (isMenuVisible) {
            SideMenu(onDismiss = { isMenuVisible = false })
        }
    }
}

@Composable
fun SideMenu(onDismiss: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.CenterStart
    ) {
        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .width(165.dp)
            ,
            color = Color.Gray
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                ){
                Row{
                    Icon(imageVector = Icons.Default.AccountCircle,
                        contentDescription = "passwordIcon",
                        Modifier
                            .size(35.dp),
                        tint = Color.Red
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text("Ivanov Ivan\nDriver", modifier = Modifier.clickable { onDismiss() })
                }
                Row(verticalAlignment = Alignment.CenterVertically ){
                    Icon(imageVector = Icons.Default.List,
                        contentDescription = "historyIcon",
                        Modifier.size(35.dp)
                    )
                    TextButton(onClick = { onDismiss() }, Modifier.padding(0.dp)){Text("HISTORY", fontSize = 11.sp, color = Color.Black)}
                }
                Row(verticalAlignment = Alignment.CenterVertically ){
                    Icon(imageVector = Icons.Default.Settings,
                        contentDescription = "settingsIcon",
                        Modifier.size(35.dp)
                    )
                    TextButton(onClick = { onDismiss() }, Modifier.padding(0.dp)){Text("SETTINGS", fontSize = 11.sp, color = Color.Black)}
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewSideMenuExample() {
    SideMenuExample()
    SideMenu {}
    GoogleMapView()
}
