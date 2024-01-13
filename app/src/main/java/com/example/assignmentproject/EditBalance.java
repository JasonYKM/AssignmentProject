package com.example.assignmentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditBalance extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences prefs;
    EditText editBalanceAmt;
    Button confirmButton;

    public static final String MyPREFERNCES = "BalancePref";
    public static final String bAmt = "balanceAmt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_balance);
        editBalanceAmt = (EditText) findViewById(R.id.editBalanceAmt);
        confirmButton = (Button) findViewById(R.id.confirmBalance);

        prefs= getSharedPreferences(MyPREFERNCES,MODE_PRIVATE);
        String gBalance =prefs.getString(bAmt, "");

        editBalanceAmt.setText(gBalance);
    }

    @Override
    public void onPause(){
        super.onPause();
        editBalanceAmt = (EditText) findViewById(R.id.editBalanceAmt);
        confirmButton = (Button) findViewById(R.id.confirmBalance);

        prefs =getSharedPreferences(MyPREFERNCES,MODE_PRIVATE);
        String userBalance = editBalanceAmt.getText().toString();
        SharedPreferences.Editor editor =prefs.edit();
        editor.putString(bAmt,userBalance);
        editor.commit();
    }

    @Override
    public void onClick(View v) {
        Intent i;
        if(v.getId() == R.id.confirmBalance){

            String userBalance = editBalanceAmt.getText().toString();
            if(userBalance != "" || userBalance != null){
                editBalanceAmt = (EditText) findViewById(R.id.editBalanceAmt);
                confirmButton = (Button) findViewById(R.id.confirmBalance);

                prefs =getSharedPreferences(MyPREFERNCES,MODE_PRIVATE);
                SharedPreferences.Editor editor =prefs.edit();
                editor.putString(bAmt,userBalance);
                editor.commit();

                i = new Intent(this,MainActivity.class);
                startActivity(i);
                Log.d("EditBalance","Navigateback");
                finish();
            }
        }
    }
}