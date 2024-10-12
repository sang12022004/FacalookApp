package com.example.facelookapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun PostContent(
    modifier: Modifier = Modifier, avatar:String, name: String,
    timeline: String, content: String, image: Int = -1
){
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(contentColor = Color.Transparent),
        border = BorderStroke(1.dp, Color.LightGray),
    ) {
        Column {
            Row (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
            ){
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(30.dp)
                        .background(color = Color.Gray),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = avatar, color = Color.White, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = modifier.width(5.dp))

                Column {
                    Text(text = name, fontWeight = FontWeight.Bold, color = Color.Black)
                    Text(text = timeline, color = Color.Gray)
                }
            }
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text=content,
                color = Color.Black, softWrap = true,
                textAlign = TextAlign.Left,
                modifier = modifier.padding(5.dp)
            )
            Spacer(modifier = Modifier.width(2.dp))
            if (image >= 0) {
                Image(painter = painterResource(id = image), contentDescription = null)

            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController,
               modifier: Modifier = Modifier){
    LazyColumn (
        modifier = modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            Card(
                modifier = Modifier.fillMaxWidth().height(80.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                ),
                border = BorderStroke(1.dp, Color.LightGray)
            ) {
                Row (
                    modifier = Modifier.fillMaxSize()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box (
                        modifier = Modifier.clip(CircleShape)
                            .background(color = Color.Gray)
                            .size(30.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "HN", color = Color.White,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Spacer(modifier = Modifier.width(2.dp))
                    OutlinedButton(
                        modifier = Modifier.weight(2f),
                        onClick = {
                            navController.navigate(NavRoot.Post.router)
                        }
                    ) {
                        Text(
                            text = "What's on your mind?",
                            textAlign = TextAlign.Left,
                            color = Color.Gray,
                            modifier = modifier.fillMaxWidth()
                        )
                    }
                    Spacer(modifier = modifier.width(2.dp))
                    Icon(
                        imageVector = Icons.Filled.Image,
                        contentDescription = "",
                        tint = Color.Green,
                        modifier = Modifier.border(1.dp, color = Color.Gray)
                    )
                }
            }
        }
        item {
            PostContent(
                avatar = "BT", name = "Bá Tài", timeline = "10m",
                content = "Trường Cao đẳng kỹ thuật Cao Thắng là "+
                        "trường cộng lập, đào tạo trình độ cao đẳng "+
                        "các ngành, nghề Kỹ thuật cộng nghệ cơ khí, "+
                        "điện, điện tử, nhiệt-lạnh, ô tô, công nghệ thông "+
                        "tin và kinh tế.",
                image = R.drawable.caothang
            )
        }

        item {
            PostContent(
                avatar = "QK", name = "Quang Khải", timeline = "1d",
                content = "Khoa khoa Điện Tử - Tin Học, tiền thân của "+
                        "khoa Công Nghệ Thông Tin được thành lập vào  "+
                        "tháng 8/1998.\n "+
                        "Khoa Công Nghệ thông tin gồm: Bộ môn Công "+
                        "nghệ Phần mềm; Bộ môn Phần cứng và Mạng máy tính;"+
                        " Trung tâm Tin học; Bộ phận Quản lý mạng "+
                        "và Phát triển phần mềm.",
                image = R.drawable.letraobang
            )
        }
    }
}