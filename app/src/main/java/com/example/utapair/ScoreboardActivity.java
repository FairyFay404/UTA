package com.example.utapair;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ScoreboardActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private ArrayList<ScoreboardUser> scoreboardUserList;
    private RecyclerView recyclerView;
    private ImageButton buttonProfile;
    private ImageButton buttonSetting;
    private ImageButton buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        Spinner spinner = findViewById(R.id.level_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.level,R.layout.spinner_text_select);
        adapter.setDropDownViewResource(R.layout.spinner_text_dropdown);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        recyclerView = findViewById(R.id.scoreboard_recycler_view);

        scoreboardUserList = new ArrayList<>();
        setUserInfo();
        setAdapter();

        buttonProfile = (ImageButton) findViewById(R.id.profile_btn);
        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAccountActivity();
            }
        });

        buttonSetting = (ImageButton) findViewById(R.id.setting_btn);
        buttonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettingActivity();
            }
        });

        buttonBack = findViewById(R.id.backward_btn);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public void openAccountActivity(){
        Intent intent=new Intent(this, AccountActivity.class);
        finish();
        startActivity(intent);
    }

    public void openSettingActivity(){
        Intent intent=new Intent(this, SettingActivity.class);
        finish();
        startActivity(intent);
    }
    private void setAdapter() {
        ScoreboardRecyclerAdapter scoreboardRecyclerAdapter = new ScoreboardRecyclerAdapter(scoreboardUserList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(scoreboardRecyclerAdapter);
    }

    private void setUserInfo() {
        scoreboardUserList.add(new ScoreboardUser(1,"FEN","3:00"));
        scoreboardUserList.add(new ScoreboardUser(2,"FEN","3:00"));
        scoreboardUserList.add(new ScoreboardUser(3,"FEN","3:00"));
        scoreboardUserList.add(new ScoreboardUser(4,"FEN","3:00"));
        scoreboardUserList.add(new ScoreboardUser(5,"FEN","3:00"));
        scoreboardUserList.add(new ScoreboardUser(6,"FEN","3:00"));
        scoreboardUserList.add(new ScoreboardUser(7,"FEN","3:00"));
        scoreboardUserList.add(new ScoreboardUser(8,"FEN","3:00"));
        scoreboardUserList.add(new ScoreboardUser(9,"FEN","3:00"));
        scoreboardUserList.add(new ScoreboardUser(10,"FEN","3:00"));
        scoreboardUserList.add(new ScoreboardUser(1,"FEN","3:00"));
        scoreboardUserList.add(new ScoreboardUser(1,"FEN","3:00"));
        scoreboardUserList.add(new ScoreboardUser(1,"FEN","3:00"));
        scoreboardUserList.add(new ScoreboardUser(1,"FEN","3:00"));

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String level = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(),level,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public void onCheckboxClicked(View view) {
    }
}