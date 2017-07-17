package declanbrophy.firstaid;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class voiceToText extends AppCompatActivity {
    //Declare and create contents of user interface
    private Button speakNow;
    private TextView showVoiceText;
    private final int REQ_CODE_SPEECH_OUTPUT = 143;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_to_text);
        //Initialize functionality of user interface
        speakNow = (Button) findViewById(R.id.button);
        showVoiceText = (TextView) findViewById(R.id.showVoiceOutput);
        //Functionality of button to allow user to make voice entry
        speakNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showVoiceText();
            }
        });
    }
    //Method to recognize speech being said
    private void showVoiceText () {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        //Method to recognize language being spoken
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        //Method to use default language if none is provided
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        //Request prompting the user to speak into microphone
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak Now Please");
        //try method to show speech in text
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_OUTPUT);
            //Catch method if no voice entry was found
        } catch (ActivityNotFoundException dec) {
            Toast.makeText(voiceToText.this, "Microphone Error, Try Again", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Method to move text file to a particular position in an array called voiceInText
        switch (requestCode) {
            case REQ_CODE_SPEECH_OUTPUT: {
                if (resultCode == RESULT_OK &&null !=data){
                    ArrayList<String> voiceInText = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    showVoiceText.setText(voiceInText.get(0));
                }
            }
        }
    }
}
