package com.example.shared_preferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /**
     * @author Roey Schwartz rs7532@bs.amalnet.k12.il
     * @version 1
     * @since 4.11.2023
     * this code will show a counter promoted by the user and save the last status of the counter and EditText
     */

    EditText et;
    TextView tv;
    int count;
    SharedPreferences settings;
    SharedPreferences.Editor editor;
    Intent si;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et);
        tv = findViewById(R.id.tv);

        count = 0;

        settings = getSharedPreferences("Last_Status", MODE_PRIVATE);
        editor = settings.edit();

        et.setText(settings.getString("Name",""));
        tv.setText(settings.getString("Count", ""));
    }

    /**
     * <p>
     *     the function get a variable of View type,
     *     the function will advance the counter by one and display to the user
     * </>
     */
    public void Count_pressed(View view) {
        count++;
        tv.setText(String.valueOf(count));
    }

    /**
     * <p>
     *     the function get a variable of View type,
     *     the function will reset the counter by one and display to the user series
     * </>
     */
    public void Reset_pressed(View view) {
        count = 0;
        tv.setText(String.valueOf(count));
    }

    /**
     * <p>
     *     the function get a variable of View type,
     *     the function will save the last status of the EditText and counter and close the application
     * </>
     */
    public void Exit_pressed(View view) {
        editor.putString("Count", String.valueOf(count));
        editor.putString("Name", String.valueOf(et.getText()));
        editor.commit();
        finish();
    }

    /**
     * <p
     *      the function get a variable of Menu type
     * </>
     * @return the function will create a general menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * <p
     *      the function get a variable of MenuItem type
     * </>
     * @return the function will as the user choice will return to the main screen or close the menu
     */
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        String st = item.getTitle().toString();
        if(st.equals("move screen")){
            finish();
        }
        else{
            closeOptionsMenu();
        }
        return super.onOptionsItemSelected(item);
    }
}