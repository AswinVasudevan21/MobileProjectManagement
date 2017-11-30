package com.example.aswin.mobileprojectmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.login.widget.ProfilePictureView;

/**
 * Created by aswin on 28-11-2017.
 */


public class AddProject extends AppCompatActivity {

    ProfilePictureView profilePictureView;
    private TextView txtName;
    private TextView txtEmail;
    private Button btnProject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addproject_layout);

        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");
        String email = intent.getExtras().getString("email");
        String userId = intent.getExtras().getString("userid");


        profilePictureView = (ProfilePictureView) findViewById(R.id.friendProfilePicture);
        profilePictureView.setProfileId(userId);
        txtName = (TextView)findViewById(R.id.textViewName);
        txtName.setText(name);
        txtEmail = (TextView)findViewById(R.id.textViewEmail);
        txtEmail.setText(email);

        btnProject = (Button)findViewById(R.id.buttonProject);

        btnProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent createIntent = new Intent(AddProject.this, CreateProject.class);
                startActivity(createIntent);
            }

        });

    }
}
