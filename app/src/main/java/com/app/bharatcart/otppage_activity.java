package com.app.bharatcart;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;

import com.app.bharatcart.R;
import com.app.bharatcart.network.APIClient;
import com.app.bharatcart.network.APIInterface;
import com.app.bharatcart.pojo.UserExixts;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class otppage_activity extends Activity {
    Button login,resend;
    EditText entermobile,enterotp;
    ImageView otp2;
    TextView timer;
    ProgressDialog progressDialog;
    String smsCode,mVerificationId,mobileNo;
    PhoneAuthProvider.ForceResendingToken mResendToken;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks;
    private FirebaseAuth mAuth;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;
    private long backPressedTime;
    private Toast backToast;
    int backButtonCount=0;
    APIInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.otppage);
        entermobile = findViewById(R.id.entermobile);
        login = findViewById(R.id.login);
        timer = findViewById(R.id.timer);
        enterotp = findViewById(R.id.enterotp);
        otp2 = findViewById(R.id.otp2);
        resend=findViewById(R.id.resend);
        resend.setVisibility(View.GONE);
        otp2.setVisibility(View.GONE);
        enterotp.setVisibility(View.GONE);
        enterotp.setEnabled(false);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        mAuth = FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(otppage_activity.this);
        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(60000,1000){
                    public void onTick(long millisUntilFinished) {
                        resend.setVisibility(View.GONE);
                        timer.setText("Resend in ..." + millisUntilFinished / 1000 + " Seconds");
                    }

                    public void onFinish() {
                        timer.setText("");
                        resend.setVisibility(View.VISIBLE);
                    }
                }.start();
                Log.e("TAG","OnResend"+mobileNo+"   "+mResendToken.toString());
                Toast.makeText(otppage_activity.this,"OTP Sent Again",Toast.LENGTH_SHORT).show();
                resendVerificationCode(mobileNo,mResendToken);
            }
        });
        onVerificationStateChangedCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                progressDialog.dismiss();
                smsCode = phoneAuthCredential.getSmsCode();
                if (smsCode != null) {
                    enterotp.setText(smsCode);
                    //login.performClick();
                    verifyPhoneNumberWithCode(enterotp.getText().toString());
                    progressDialog.setMessage("Auto Verifying OTP ...");
                    progressDialog.setCancelable(false);
                    progressDialog.show();

                } else {
                    Toast.makeText(otppage_activity.this, "Enter The OTP", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                progressDialog.dismiss();
                Log.e("MainActivity", "onVerificationFailed: " + e.getLocalizedMessage());
                Toast.makeText(otppage_activity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onCodeSent( String verificationId,
                                    PhoneAuthProvider.ForceResendingToken token) {
                Toast.makeText(otppage_activity.this, "Code Sent Wait For 60 Seconds", Toast.LENGTH_SHORT).show();
                Log.d("otplogin", "onCodeSent:" + verificationId);
                mVerificationId = verificationId;
                mResendToken = token;
                progressDialog.dismiss();
            }
        };
        login.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                resend.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        resend.setVisibility(View.VISIBLE);
                    }
                },1000*60);

                Log.e("Welcome", "onClick: "+login.getText());
                if(login.getText().toString().equals("Login"))
                {
                    if(entermobile.getText().toString().length()!=10 && entermobile.getText().toString().length()>0)
                    {
                        entermobile.setError("Invalid Phone Number");
                        entermobile.requestFocus();
                        return;
                    }
                    if(entermobile.getText().toString().isEmpty())
                    {
                        entermobile.setError("Phone Number Cannot be empty");
                        entermobile.requestFocus();
                        return;
                    }
                    new CountDownTimer(60000,1000){
                        public void onTick(long millisUntilFinished) {
                            timer.setText("Resend in ... " + millisUntilFinished / 1000 + " Seconds");
                        }

                        public void onFinish() {
                            timer.setText("");

                        }
                    }.start();
                    entermobile.setEnabled(false);
                    enterotp.setEnabled(true);
                    otp2.setVisibility(View.VISIBLE);
                    enterotp.setVisibility(View.VISIBLE);

                    login.setText("Verify");
                    mobileNo="+91"+entermobile.getText().toString();
                    verifyMobileNumber(mobileNo);
                }
                else{

                    verifyPhoneNumberWithCode(enterotp.getText().toString());

                }

            }
        });
    }

    private void signInWithMobile(PhoneAuthCredential phoneAuthCredential) {

        mAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    progressDialog.dismiss();
                    FirebaseUser currentUser = task.getResult().getUser();
                    String uid = currentUser.getUid();
                    getUserStatus(uid);
//
                }
            }
        });
    }

    private void getUserStatus(String UID) {
        Call<UserExixts> call=apiInterface.checkUserExists(UID);
        call.enqueue(new Callback<UserExixts>() {
            @Override
            public void onResponse(Call<UserExixts> call, Response<UserExixts> response) {
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
                        progressDialog.cancel();
                        Toast.makeText(otppage_activity.this, "Welcome Back !!", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(otppage_activity.this,navactivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        intent.putExtra("mobile",entermobile.getText().toString());
                        startActivity(intent);
                        finish();
                    }
                    else{
                        progressDialog.cancel();
                        Toast.makeText(otppage_activity.this, "Welcome !!", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(otppage_activity.this,loginpage_activity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        intent.putExtra("mobile",entermobile.getText().toString());
                        startActivity(intent);
                        finish();
                        Log.d("TAG", "Is New User!");
                    }
                }
            }

            @Override
            public void onFailure(Call<UserExixts> call, Throwable t) {
                Log.e("OTP PAGE", "onFailure: "+t.getLocalizedMessage() );
            }
        });


    }


    private void verifyMobileNumber(String mobile) {
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        PhoneAuthProvider.getInstance().verifyPhoneNumber(mobile, 60, TimeUnit.SECONDS, this, onVerificationStateChangedCallbacks);
    }

    private void verifyPhoneNumberWithCode(String otp) {
        if (!otp.equals("")) {
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, otp);
            signInWithMobile(credential);
        } else {
            Toast.makeText(otppage_activity.this, "Please enter the otp", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            SharedPreferences sharedPreferences=getSharedPreferences("Name",0);
            String token=sharedPreferences.getString("token","No Token");
            if(!token.equals("No Token")) {
                Intent intent = new Intent(otppage_activity.this, navactivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                finish();
                startActivity(intent);
            }
        }
    }

    private void resendVerificationCode(String phoneNumber,
                                        PhoneAuthProvider.ForceResendingToken token) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                onVerificationStateChangedCallbacks,         // OnVerificationStateChangedCallbacks
                token);             // ForceResendingToken from callbacks
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
            finish();
        }
        else
        {
            Toast.makeText(this, "Press again to exit.", Toast.LENGTH_SHORT).show();
            Log.d("ButtonCount1", "Value: " + Float.toString(backButtonCount));
            backButtonCount ++;
        }
    }

}