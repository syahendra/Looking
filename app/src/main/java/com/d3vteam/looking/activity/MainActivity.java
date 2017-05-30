package com.d3vteam.looking.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.d3vteam.looking.R;
import com.d3vteam.looking.helper.SQLiteHandler;
import com.d3vteam.looking.helper.SessionManager;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private TextView txtName;
    private TextView txtNis;
    private Button btnLogout;

    private SQLiteHandler db;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pengaturan);

        txtName = (TextView) findViewById(R.id.name);
        txtNis = (TextView) findViewById(R.id.nis);
        btnLogout = (Button) findViewById(R.id.btnLogout);

        // SqLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // session manager
        session = new SessionManager(getApplicationContext());

        if (!session.isLoggedIn()) {
            logoutUser();
        }

        // Fetching user details from sqlite
        HashMap<String, String> user = db.getUserDetails();

        String name = user.get("name");
        String nis = user.get("nis");

        // Displaying the user details on the screen
        txtName.setText(name);
        txtNis.setText(nis);

        // Logout button click event
        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });
    }

    /**
     * Logging out the user. Will set isLoggedIn flag to false in shared
     * preferences Clears the user data from sqlite users table
     * */
    private void logoutUser() {
        session.setLogin(false);

        db.deleteUsers();

        // Launching the login activity
        Intent intent = new Intent(MainActivity.this, login.class);
        startActivity(intent);
        finish();
    }
}
