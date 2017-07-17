package declanbrophy.firstaid;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by User on 03/07/2017.
 */

public class ViewListContents extends AppCompatActivity {

    DatabaseHelper myDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents_layout);

        ListView listView = (ListView) findViewById(R.id.listView);
        myDB = new DatabaseHelper(this);

        ArrayList<String> List = new ArrayList<>();
        Cursor data = myDB.getListContents();

        if (data.getCount() == 0) {
            Toast.makeText(ViewListContents.this,"The database was empty",Toast.LENGTH_LONG).show();
        }else {
            while (data.moveToNext()) {
                List.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,List);
                listView.setAdapter(listAdapter);
            }
        }
    }
}
