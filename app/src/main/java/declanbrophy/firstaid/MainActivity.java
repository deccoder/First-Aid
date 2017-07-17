package declanbrophy.firstaid;

import android.media.MediaCodec;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize and create contents of user interface
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText password = (EditText) findViewById(R.id.password);
        final Button register = (Button) findViewById(R.id.register);
        Button signIn = (Button) findViewById(R.id.signIn);

        //Functionality of register button
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Selection statement checking if email is valid
             if (!registerEmail(email.getText().toString())) {
                 email.setError("Invalid Email");
                 email.requestFocus();
                 //Selection statement checking password is valid
             } else if (registerPassword(password.getText().toString())) {
                 password.setError("Invalid Password");
                 password.requestFocus();
                 //Selection statement stating password and email is valid
             } else {
                 Toast.makeText(MainActivity.this, "Sign In Successful", Toast.LENGTH_LONG).show();
             }
            }
        });
    }
    //Method of validation of password to check it has uppercase, numbers and symbols included.
    private boolean registerPassword(final String password) {
        final String passwordPatern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{4,}$\";\n";
        Pattern pattern = Pattern.compile(password);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    //Method of validation of email address using pattern to check format.
    private boolean registerEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\\\.+[a-z]+";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
