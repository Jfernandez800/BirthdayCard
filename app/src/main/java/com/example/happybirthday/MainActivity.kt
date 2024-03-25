package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme
import com.example.myapplication.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Replace the GreetingText() function call with a GreetingImage() function call
                    // for the changes to reflect.
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_text),
                        from = stringResource(R.string.signature_text),

                        //-----------------------NOTE FOR TO SELF-----------------------
                        // It is a good practice to pass the modifier attribute(s) along with the
                        // modifier from the parent composable.
                        modifier = Modifier.padding(8.dp) // Update the modifier parameter in the GreetingText()
                    )
                }
            }
        }
    }
}

// This GreetingText() function displays text in the UI. It does so by calling the Text() composable
// function.
@Composable
fun GreetingText(
    message: String,
    //Pass the function from parameter of type String for your signature.
    from: String,
    //add a Modifier & message parameter to the GreetingText() function.
    modifier: Modifier = Modifier
) {

    Column(
        verticalArrangement = Arrangement.Center, //To align the greeting in the center
        modifier = modifier //pass the modifier parameter to the Column composable.
    ) {
        Text(
            text = message, // add a Text composable passing in the text message as a named argument.
            fontSize = 100.sp, //Add a fontSize argument with value of 100.sp.
            lineHeight = 116.sp, //Add a lineHeight argument with a value of 116.sp.
            textAlign = TextAlign.Center // align the greeting text to the center
        )
        Text(
            text = from, //Add Text composable that accepts text argument set to the from value.
            fontSize = 36.sp, //Add a fontSize argument with a value of 36.sp.
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

// Every composable function should accept an optional Modifier parameter. Modifiers tell a UI
// element how to lay out, display, or behave within its parent layout.
@Composable
// Pass the GreetingImage() function two String parameters: one called message for the birthday
// greeting and the other called from for your signature.
fun GreetingImage(
    message: String,
    from: String,
    modifier: Modifier = Modifier
) {
    // call to painterResource() function by passing in the androidparty resource. Assign the
    // returned value to the image variable.
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) { // pass the modifier parameter to the Box composable
        Image(
            painter = image,
            contentDescription = null, //add argument called contentDescription and set its value to null.
            contentScale = ContentScale.Crop, // use the ContentScale.Crop parameter scaling, which
                                            // scales the image uniformly to maintain the aspect ratio.
            alpha = 0.5F
        )
        //call the GreetingText() function, and pass it the birthday message, signature, and the modifier
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() { //the preview function is calling the Greeting() composable function.
    HappyBirthdayTheme {
        //Call the GreetingText function and pass a string argument.
        GreetingImage(
            message = stringResource(R.string.happy_birthday_text),
            from = stringResource(R.string.signature_text)
        )
    }
}

/*-----------------------NOTES FOR TO SELF-----------------------
Example:
Row {
    Text("First Column")
    Text("Second Column")
}

- {}curly braces are used instead of ()parentheses in ROW composable.
  This is called Trailing Lambda Syntax.

- An R class is an automatically generated class by Android that contains the IDs of all resources
in the project. In most cases, the resource ID is the same as the filename. For example, the image
in the previous file hierarchy can be accessed with this code:

- The painterResource() function loads a drawable image resource,and takes resource ID
  (R.drawable.androidparty in this case) as an argument.

- Modifiers are used to decorate or add behavior to Jetpack Compose UI elements. For example, you
  can add backgrounds, padding or behavior to rows, text, or buttons. To set them, a composable or
  a layout needs to accept a modifier as a parameter.

- Some Android Studio versions replace the hardcoded string with the getString() function. Please
  manually change the function to stringResource() in such cases.

*/