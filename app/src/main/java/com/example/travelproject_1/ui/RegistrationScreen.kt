package com.example.travelproject_1.ui
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelproject_1.R
import com.example.travelproject_1.components.CAccountRow
import com.example.travelproject_1.components.CButton
import com.example.travelproject_1.components.CCheckPassword
import com.example.travelproject_1.components.CPassword
import com.example.travelproject_1.components.CTextField

@Composable
fun RegistrationScreen(
    onSignInButtonTap: () -> Unit
) {
    var emty by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var cPassword by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var cPasswordVisibility by remember { mutableStateOf(false) }
    var errorE by remember { mutableStateOf(false) }
    var errorCP by remember { mutableStateOf(false) }
    var errorC by remember { mutableStateOf(false) }
    var errorP by remember { mutableStateOf(false) }
    var pLength by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {


        Box(modifier = Modifier.fillMaxSize())
        {
            Column(modifier = Modifier) {


                Box(modifier = Modifier.fillMaxSize()
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.sunny_beach),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                }

            }
            Column {
                Text(
                    text = "Hello, don't you have an account?",
                    style = TextStyle(
                        fontWeight = FontWeight(600),
                        fontSize = 16.sp,
                        color = Color(0xFFFFFFFF)
                    ),
                    modifier = Modifier
                        //.align(Alignment.Top)
                        .padding(top = 20.dp, start = 20.dp, bottom = 5.dp)

                )
                Text(
                    text = "Sign Up",
                    style = TextStyle(
                        fontWeight = FontWeight(600),
                        fontSize = 36.sp,
                        color = Color(0xFFFFFFFF)
                    ),
                    modifier = Modifier
                        .padding(top =5.dp , start = 30.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 110.dp)
                    .background(
                        color = Color(0xFFFFFFFF),
                        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                    )

            ) {

                Image(
                    painter = painterResource(R.drawable.sign_up),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 5.dp)
                        .height(100.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Column(
                    modifier = Modifier
                        .padding(top = 10.dp, start = 30.dp, end = 30.dp)
                        .align(Alignment.CenterHorizontally)

                ) {
                    CTextField(label = "User Name", placeholder = "Enter Email", value = email, onValueChange = { email = it})
                    Spacer(modifier = Modifier.height(10.dp))
                    if (errorE){
                        Text(text = "Enter password",
                            color = Color.Red,
                            modifier = Modifier
                                .padding(end = 100.dp))

                    }
                    if (pLength){
                        Text(text = "Password must be 6 characters",
                            color = Color.Red,
                            modifier = Modifier
                                .padding(end = 100.dp))

                    }

                    CPassword(
                        onValueChange = {password = it},
                        placeholder = "Enter Password",
                        value = password,
                        label = "User Name",
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Go),
                        passwordVisibility = passwordVisibility,
                        cPasswordVisibility = cPasswordVisibility,
                    )
                    CCheckPassword(
                        onValueChange = {password = it},
                        placeholder = "Enter Password",
                        value = cPassword,
                        label = "Confirm Password",
                        passwordVisibility = passwordVisibility,
                        cPasswordVisibility = cPasswordVisibility,

                    )
                    CTextField(label = "Confirm Password" ,placeholder = "Enter Password", value = password, onValueChange = {password = it})
                    CButton(text = "Sign Up")
                    CAccountRow(text1 = "Already have an account ? ", text2 = "Sign In " ,
                        onText2Tap = { onSignInButtonTap()})
                }
            }
        }
    }
}

@Preview(showBackground = true,widthDp = 320, heightDp = 640)
@Composable
fun RegistrationPrev() {
    RegistrationScreen( onSignInButtonTap = {})
}

