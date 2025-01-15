
package com.example.finalucp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.example.finalucp.R

data class FormState(
    var nama: String = "",
    var nim: String = "",
    var alamat: String = "",
    var judul: String = "",
    var dospem: String = "",
    var judulskripsi: String = ""
)

@Preview(showBackground = true)
@Composable
fun InputData(modifier: Modifier = Modifier) {
    var formState by remember { mutableStateOf(FormState()) }
    var savedForm by remember { mutableStateOf(FormState()) }

    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.persona2),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        //icon(ImageVector = Icons.Filled.Done,
        //    contentDescription = null)
        Text(
            text = "NIM",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.size(4.dp))

        Text(
            text = "Nama",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.size(4.dp))

        Text(
            text = "Alamat",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.size(4.dp))

        Text(
            text = "judul skripsi",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.size(4.dp))

        Text(
            text = "dosen pembimbing",
            color = Color.Black,
            fontSize = 6.sp,
        )

        TextField(
            value = formState.judulskripsi,
            onValueChange = { formState = formState.copy(judulskripsi = it) },
            label = { Text(text = "judul skripsi") },
            placeholder = { Text(text = "penelitian IT", color = Color.Black) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        TextField(
            value = formState.dospem,
            onValueChange = { formState = formState.copy(dospem = it) },
            label = { Text(text = "dosen pembimbing") },
            placeholder = { Text(text = "12 ", color = Color.Black) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )


        Button(onClick = { savedForm = formState }) {
            Text(text = "Submit",
                color = Color.White)
        }

        ResultMessage1(param = "Depart", argum = savedForm.judulskripsi)
        ResultMessage2(param = "Arrive", argum = savedForm.dospem)
    }
}

@Composable
fun ResultMessage1(param: String, argum: String) {
    Box(
        modifier = Modifier.fillMaxWidth()
            .background(color = Color.Blue)
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = param, modifier = Modifier
                        .weight(0.8f)
                )
                Text(text = ":", color = Color.White, modifier = Modifier.weight(0.2f))
                Text(text = argum, color = Color.White, modifier = Modifier.weight(2f))
            }
        }
    }
}


@Composable
fun ResultMessage2(param: String, argum: String) {
    Box(
        modifier = Modifier.fillMaxWidth()
            .background(color = Color.Blue)
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = param, modifier = Modifier
                        .weight(0.8f)
                )
                Text(text = ":", modifier = Modifier.weight(0.2f))
                Text(text = argum, modifier = Modifier.weight(2f))
            }
        }
    }
}