package com.example.assignmentproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences prefs;
    private DrawerLayout drawerLayout;
    private ImageView openDrawer;
    private TextView budgetAmt;
    public static final String MyPREFERNCES = "BalancePref";
    public static final String bAmt = "balanceAmt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs= getSharedPreferences(MyPREFERNCES,MODE_PRIVATE);
        String gBalance =prefs.getString(bAmt, "0.00");
        budgetAmt = (TextView)findViewById(R.id.budgetAmount);
        budgetAmt.setText(gBalance);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        drawerLayout = findViewById(R.id.drawer_layout);
        openDrawer = findViewById(R.id.hamburger_menu_icon);
        // Set up the hamburger icon and open/close actions
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        openDrawer.setOnClickListener(view ->{
            drawerLayout.openDrawer(GravityCompat.START);
        });

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            // Handle item clicks here

            if(item.getItemId() == R.id.home){
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
            }
            else if(item.getItemId() == R.id.dailyTab){
                Toast.makeText(this, "Daily", Toast.LENGTH_SHORT).show();
            }
            else if(item.getItemId() == R.id.finInsight){
                Toast.makeText(this, "Insight", Toast.LENGTH_SHORT).show();
            }
            else if(item.getItemId() == R.id.savingsGoal){
                Toast.makeText(this, "Saving", Toast.LENGTH_SHORT).show();
            }
            else if(item.getItemId() == R.id.reminder){
                Toast.makeText(this, "Reminder", Toast.LENGTH_SHORT).show();
            }
            else if(item.getItemId() == R.id.exchangeRate){
                Toast.makeText(this, "Exchange", Toast.LENGTH_SHORT).show();
            }
            else if(item.getItemId() == R.id.decision){
                Toast.makeText(this, "Decision", Toast.LENGTH_SHORT).show();
            }
            else if(item.getItemId() == R.id.setting){
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        Log.d("MainActivity","Clicking");
        if(v.getId() == R.id.budgetCard){
            Log.d("MainActivity","Move to Edit Balance");
            i = new Intent(this,EditBalance.class);
            startActivity(i);
        }
    }
}