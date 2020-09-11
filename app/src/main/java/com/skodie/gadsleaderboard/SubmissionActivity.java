package com.skodie.gadsleaderboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SubmissionActivity extends AppCompatActivity {
    EditText mFirstName, mLastName, mEmailAddress, mGithubLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Link Android XML to java class
        Button submitProject;
        mFirstName = findViewById(R.id.first_name);
        mLastName = findViewById(R.id.last_name);
        mEmailAddress = findViewById(R.id.email_address);
        mGithubLink = findViewById(R.id.github_link);
        submitProject = findViewById(R.id.submit_project);
        submitProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Convert Edittext Values to string
                String firstName,lastName,email,gitHubLink;
                firstName = mFirstName.getText().toString();
                lastName = mLastName.getText().toString();
                email = mEmailAddress.getText().toString();
                gitHubLink = mGithubLink.getText().toString();
                //Send String data into the PopUp activity
                Intent intent = new Intent(SubmissionActivity.this, SubmitFormConfirmation.class);
                intent.putExtra("firstname",firstName);
                intent.putExtra("lastName",lastName);
                intent.putExtra("email",email);
                intent.putExtra("gitHubLink",gitHubLink);
                startActivity(intent);
            }
        });


    }
    //To handle back pressed
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
