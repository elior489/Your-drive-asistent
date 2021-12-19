package com.example.yourdriveasistent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Activity2 extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
       mAuth = FirebaseAuth.getInstance();
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser!=null){
            startActivity(new Intent(Activity2.this ,WelcomeAc.class));


        }
    }


    public void Login(View view) {
        EditText EmailEt =findViewById(R.id.EmailEt);
        EditText PassEt =findViewById(R.id.PassEt);
        mAuth.signInWithEmailAndPassword(EmailEt.getText().toString(), PassEt.getText().toString())
                .addOnCompleteListener(Activity2.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(Activity2.this ,WelcomeAc.class));

                        } else {
                            Toast.makeText(Activity2.this,"login failed failed please try again",Toast.LENGTH_LONG);
                        }
                    }
                });


    }

    public void Register(View view) {
        EditText EmailEt =findViewById(R.id.EmailEt);
        EditText PassEt =findViewById(R.id.PassEt);
        mAuth.createUserWithEmailAndPassword(EmailEt.getText().toString(), PassEt.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
startActivity(new Intent(Activity2.this ,WelcomeAc.class));
                        } else {
Toast.makeText(Activity2.this,"register failed please try again",Toast.LENGTH_LONG);
                        }
                    }
                });


    }
}