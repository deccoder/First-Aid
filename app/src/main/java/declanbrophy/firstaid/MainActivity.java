package declanbrophy.firstaid;

import android.content.Intent;
import android.media.MediaCodec;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.view.View.Z;


public class MainActivity extends AppCompatActivity {
    /*public static boolean isValidEmail(String str) {
        boolean isValid = false;
      if (Build.VERSION.SDK_INT >= 20) {
//           // return android.util.Patterns.EMAIL_ADDRESS.matcher(str).matches();
//        }
        String expression = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        CharSequence inputStr = str;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;

    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize and create contents of user interface
        final EditText inputEmail = (EditText) findViewById(R.id.inputEmail);
        final EditText password = (EditText) findViewById(R.id.password);
        final Button register = (Button) findViewById(R.id.register);
        Button signIn = (Button) findViewById(R.id.signIn);

        //Functionality of register button
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Selection statement that displays message if email format is not valid
             /*if (!isValidEmail(inputEmail.getText().toString().trim())) {
                 inputEmail.setError("Invalid Email ID");
                 //Selection statement that displays messaage if password format is not valid
             } else if (registerPassword(password.getText().toString())) {
                 password.setError("Invalid Password");
                 password.requestFocus();
                 Log.d("here ","Invalid address");

             } else {
                 Intent intent = new Intent();
                 intent.setClass(v.getContext(),videoSearch.class);
                 startActivity(intent);
             }*/
                Intent intent = new Intent();
                intent.setClass(v.getContext(),Playlist.class);
                startActivity(intent);


            }
        });
    }
    //Method of validation of password format to check it has uppercase, numbers and symbols included.
   /* private boolean registerPassword(final String password) {
        final String passwordPatern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";
        Pattern pattern = Pattern.compile(passwordPatern);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }*/
    /*Method of validation of email address using pattern to check format.
    private boolean registerEmail(String email) {
        String emailPattern = "";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }*/
}
