package com.app.bharatcart;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.app.bharatcart.R;
import com.app.bharatcart.network.APIClient;
import com.app.bharatcart.network.APIInterface;
import com.app.bharatcart.pojo.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class searchpage_activity extends Fragment {
    private long backPressedTime;
    private Toast backToast;
    int backButtonCount=0;
    EditText searchQuery;
    APIInterface apiInterface;
    Button menuubar,search_Button;
    ProgressDialog progressDialog;
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.searchpage);
//        menuubar = findViewById(R.id.menuubar);
//        menuubar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(searchpage_activity.this, navactivity.class);
//                startActivity(i);
//            }
//        });
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        View root = inflater.inflate(R.layout.searchpage, container, false);
        searchQuery=root.findViewById(R.id.searchQuery);
        search_Button=root.findViewById(R.id.searchBuutton);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        progressDialog=new ProgressDialog(getContext());
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Please wait fetching result ...");
        progressDialog.setCancelable(false);
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                return;
            }
        });

        search_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(searchQuery.getText().toString().trim().length()>0)
                {
                    InputMethodManager inputManager = (InputMethodManager)
                            getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

                    inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                    searchForApp();
                }
                else{
                    Toast.makeText(getContext(),"Field cannot be blank",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }

    private void searchForApp() {
        progressDialog.show();
        Call<Result> call=apiInterface.getApps("in",true,250,searchQuery.getText().toString().trim());
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if(response.isSuccessful())
                {
                    Result result=response.body();

                    if(result!=null)
                    {
                        if(result.getSuccess())
                        {
                            Toast.makeText(getContext(),"Click on the app you want, to go to download page.",Toast.LENGTH_SHORT).show();
                            Log.e("TAG", "onResponse: Called" );
                            Intent intent = new Intent(getContext(),listpage_activity.class);
                            intent.putExtra("searchresult",result);
                            progressDialog.cancel();
                            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            }
                        else{
                        }
                    }
                    else{
                    }
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.e("Search Page", "onFailure: "+t.getLocalizedMessage() );
                Toast.makeText(getContext(),"Try again Network Error",Toast.LENGTH_LONG).show();
                progressDialog.cancel();
            }
        });
    }


//

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(null);
    }
}
