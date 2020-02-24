package com.jawidmohammadi.statechange;

import android.os.Bundle;
import android.widget.EditText;
import androidx.annotation.NonNull;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.nio.charset.Charset;
import  java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



public class MainActivity extends AppCompatActivity {
private static final String TAG= "StateChange";    //This tag method created

    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    private ListView myListView;

  private void addListItem(){
      SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy", Locale.US);
      listItems.add(dateformat.format(new Date()));
      adapter.notifyDataSetChanged();
  }

  View.OnClickListener undoOnClickListener = new View.OnClickListener(){
      @Override
      public void onClick(View view){
          listItems.remove(listItems.size() -1);
          adapter.notifyDataSetChanged();
          Snackbar.make(view, "Item removed", Snackbar.LENGTH_LONG).setAction("Action", null);
      }
  };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myListView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        myListView.setAdapter(adapter);

       FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addListItem();
                Snackbar.make(view, "Item added to List!", Snackbar.LENGTH_LONG)
                        .setAction("Undo", undoOnClickListener).show();
            }
        });
        Log.i(TAG, "onCreate");




    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");

//        final EditText editText = findViewById(R.id.editText);
//        CharSequence userText = editText.getText();
//        outState.putCharSequence("savedText", userText);
    }



    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");

//        final EditText editText = findViewById(R.id.editText);
//        CharSequence userText = savedInstanceState.getCharSequence("savedText");
//        editText.setText(userText);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
