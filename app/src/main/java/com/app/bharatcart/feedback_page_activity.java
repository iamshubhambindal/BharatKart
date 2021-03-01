package com.app.bharatcart;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.app.bharatcart.R;

public class feedback_page_activity extends Fragment {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.feedback_page);
//    }
    EditText feedbackBody;
    Button submitFeedback;
@Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    View root = inflater.inflate(R.layout.feedback_page, container, false);
    feedbackBody=root.findViewById(R.id.mailbody);
    submitFeedback=root.findViewById(R.id.submitFeedback);
    submitFeedback.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(feedbackBody.getText().toString().isEmpty())
            {
                feedbackBody.setError("Feedback Cannot Be Empty");
                feedbackBody.setFocusable(true);
                return;
            }

            Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setType("vnd.android.cursor.item/email");
            intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[] {"feedbackbharatcart@gmail.com"});
            intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Feedback Regarding BharatKart App");
            intent.putExtra(android.content.Intent.EXTRA_TEXT, (feedbackBody.getText().toString()));
            startActivity(Intent.createChooser(intent, "Send mail using..."));
           /* if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                startActivity(intent);
            }*/
        }
    });
    return root;
}
}
