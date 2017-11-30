package com.example.aswin.mobileprojectmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    LoginButton loginButton;

    CallbackManager callbackmgr;
    String name;
    String email;
    String userID;
    com.facebook.login.widget.ProfilePictureView profilePictureView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        FacebookSdk.sdkInitialize(getApplicationContext());

        loginButton = (LoginButton)findViewById(R.id.btnid);
        loginButton.setReadPermissions(Arrays.asList(
                "public_profile", "email", "user_birthday", "user_friends"));

        callbackmgr = CallbackManager.Factory.create();

        loginButton.registerCallback(callbackmgr, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(final LoginResult loginResult) {

                //   txtView.setText(profile.getFirstName());
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(
                                    JSONObject object,
                                    GraphResponse response) {
                                // Application code

                                try {
                                    email = object.getString("email");
                                    name = object.getString("name");
                                    userID = object.getString("id");
                                    String Token = loginResult.getAccessToken().getToken().toString();

                                    //URL imageURL = new URL("https://graph.facebook.com/" + userID + "/picture?type=large");
                                   //Bitmap bitmap = BitmapFactory.decodeStream(imageURL.openConnection().getInputStream());


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                } //catch (MalformedURLException e) {
                                   // e.printStackTrace();
                                //} catch (IOException e) {
                                   // e.printStackTrace();
                               // }

                                Intent projectIntent = new Intent(MainActivity.this, AddProject.class);
                                projectIntent.putExtra("name",name);
                                projectIntent.putExtra("email",email);
                                projectIntent.putExtra("userid",userID);
                                startActivity(projectIntent);


                            }


                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,link");
                request.setParameters(parameters);
                request.executeAsync();
                String userid;
                userid = loginResult.getAccessToken().getToken() ;


            }


            @Override
            public void onCancel() {



            }

            @Override
            public void onError(FacebookException error) {


                Intent createIntent = new Intent(MainActivity.this, CreateProject.class);
                startActivity(createIntent);
                System.out.println(error);
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackmgr.onActivityResult(requestCode,resultCode,data);
    }
}

