package declanbrophy.firstaid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogEntryList extends AppCompatActivity {

    DatabaseHelper myDB;
    Button btnAdd,btnView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_entry_list);

        editText = (EditText) findViewById(R.id.editText);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);
        myDB = new DatabaseHelper(this);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogEntryList.this,LogEntryList.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if (editText.length() !=0) {
                    AddData(newEntry);
                    editText.setText("");
                }else {
                    Toast.makeText(LogEntryList.this,"You must put something in the text field",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void AddData(String newEntry) {
        boolean insertData = myDB.addData(newEntry);

        if (insertData==true) {
            Toast.makeText(LogEntryList.this,"Data entered successfully",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(LogEntryList.this,"Data entry error",Toast.LENGTH_LONG).show();
        }
    }
}
