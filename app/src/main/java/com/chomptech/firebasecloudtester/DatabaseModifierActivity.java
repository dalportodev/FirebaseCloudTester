package com.chomptech.firebasecloudtester;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class DatabaseModifierActivity extends AppCompatActivity implements View.OnClickListener{



    private TextView mTextFieldMessage;
    private Button mButtonOn;
    private Button mButtonOff;
    private Firebase mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_modifier);
        mButtonOff = (Button)findViewById(R.id.buttonOff);
        mButtonOn = (Button)findViewById(R.id.buttonOn);
        mRef = new Firebase("https://fir-cloud-tester.firebaseio.com/basemessage");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                mTextFieldMessage.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mButtonOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRef.setValue("Off");
            }
        });
        mButtonOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRef.setValue("On");
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
    @Override
    protected void onStart() {
        super.onStart();
        mTextFieldMessage = (TextView)findViewById(R.id.textViewMessage);

    }
}
