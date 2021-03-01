package com.app.bharatcart;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDelegate;

import com.app.bharatcart.R;
import com.app.bharatcart.network.APIClient;
import com.app.bharatcart.network.APIInterface;
import com.app.bharatcart.pojo.SignUp;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class loginpage_activity extends Activity {
    private long backPressedTime;
    private Toast backToast;
    int backButtonCount=0;
    EditText firstName,lastName,contact,email,city;
    APIInterface apiInterface;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
        Intent intent=getIntent();
        String mobileNo=intent.getStringExtra("mobile");
        apiInterface= APIClient.getClient().create(APIInterface.class);
        firstName=findViewById(R.id.firstname);
        lastName=findViewById(R.id.lastname);
        contact=findViewById(R.id.contactNo);
        email=findViewById(R.id.mailId);
        city=findViewById(R.id.cityname);
        submit=findViewById(R.id.request);
        contact.setText(mobileNo);
        contact.setEnabled(false);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstName.length()<1)
                {
                    firstName.setError("First Name Cannot be empty");
                    firstName.requestFocus();
                    return;
                }
                if(lastName.length()<1)
                {
                    lastName.setError("Last Name Cannot be empty");
                    lastName.requestFocus();
                    return;
                }
                /*if(email.length()<1)
                {
                    email.setError("Email Cannot be empty");
                    email.requestFocus();
                    return;
                }*/
                /*if(city.length()<1)
                {
                    city.setError("City Cannot be empty");
                    city.requestFocus();
                    return;
                }*/
                /*if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches())
                {
                    email.setError("Invalid EMail");
                    email.requestFocus();
                    return;
                }*/
                startSignUp();
            }
        });
    }

    private void startSignUp() {
        Map<String,String> map=new HashMap<>();
        map.put("firstName",firstName.getText().toString());
        map.put("lastName",lastName.getText().toString());
        map.put("contact_no",contact.getText().toString());
        map.put("email",email.getText().toString());
        map.put("city",city.getText().toString());
        map.put("fireBaseUID", FirebaseAuth.getInstance().getCurrentUser().getUid());
        Call<SignUp> call=apiInterface.signUp(map);
        call.enqueue(new Callback<SignUp>() {
            @Override
            public void onResponse(Call<SignUp> call, Response<SignUp> response) {
                if(response.isSuccessful())
                {
                    if(response.body().getSuccess())
                    {
                        SharedPreferences preferences = getSharedPreferences("Name",0);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("firstname",response.body().getFirstName());
                        editor.putString("lastname",response.body().getLastName());
                        editor.putString("token",response.body().getToken());
                        editor.apply();
                        Toast.makeText(loginpage_activity.this, "Welcome !!", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(loginpage_activity.this,navactivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        finish();
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(loginpage_activity.this, "Error Registering User", Toast.LENGTH_LONG).show();
                        FirebaseAuth.getInstance().signOut();
                        Intent i=new Intent(loginpage_activity.this,otppage_activity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(i);
                        finish();
                    }
                }
                else{

                        Toast.makeText(loginpage_activity.this, "Error Registering User", Toast.LENGTH_LONG).show();
                        FirebaseAuth.getInstance().signOut();
                        Intent i=new Intent(loginpage_activity.this,otppage_activity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(i);
                        finish();

                }
            }

            @Override
            public void onFailure(Call<SignUp> call, Throwable t) {
                Log.e("Login Activity", "onFailure: "+t.getLocalizedMessage() );
                    Toast.makeText(loginpage_activity.this, "Error Registering User", Toast.LENGTH_LONG).show();
                    FirebaseAuth.getInstance().signOut();
                    Intent i=new Intent(loginpage_activity.this,otppage_activity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(i);
                    finish();

            }
        });
    }

    @Override
    public void onBackPressed()
    {

        if(backButtonCount >= 1)
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Press again to exit.", Toast.LENGTH_SHORT).show();
            Log.d("ButtonCount1", "Value: " + Float.toString(backButtonCount));
            backButtonCount ++;
        }
    }
}
