package declanbrophy.firstaid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class videoSearch extends AppCompatActivity {
    //Declaring storage containers for list and search views
    ListView lv;
    SearchView sv;
    //Declaring and creating storage area for videos
    String[] videos={};
    //Declaring and creating instance of type array adapter
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_search);
        //Declaring and creating instance of items in the user interface
        lv=(ListView) findViewById(R.id.listView1);
        sv=(SearchView) findViewById(R.id.searchView1);
        //Adapter view that will return list of videos
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,videos);
        //Setting listview to adapter
        lv.setAdapter(adapter);
        //Creating functionality for search view
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            //Method to search for a query entered by the user
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            //Method to change text in the query entered to new query
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/
}
