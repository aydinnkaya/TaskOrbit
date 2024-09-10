package com.aydinkaya.taskorbit.views.to_do_screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aydinkaya.taskorbit.R

@Composable
fun HeaderView(
    title: String,
    subtitle: String,
    angle: Float,
    backgroundColor: Color
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
            //.clipToBounds()
            .offset(y = (-150).dp)
    ) {
        // Background with rotation (rounded rectangle as background)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    rotationZ = angle
                    scaleX = 3.0f
                    scaleY = 1.1f
                }
                .background(backgroundColor)
        )


        // ToDoList Icon
        Image(
            painter = painterResource(id = R.drawable.todo_list_icon),
            contentDescription = "ToDo List Icon",
            modifier = Modifier
                .size(200.dp, 250.dp)
                .align(Alignment.Center)
                .offset(y = 328.dp),
            contentScale = ContentScale.Fit
        )
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 194.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                color = Color.White,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = subtitle,
                color = Color.White,
                fontSize = 30.sp
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHeaderView() {
    HeaderView(
        title = "Register",
        subtitle = "Start organizing todos",
        angle = -15f,
        backgroundColor = Color(0xFFFFA500) // Orange color
    )
}

