package com.example.yourdriveasistent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemIe = item.getItemId();
        if (itemIe == R.id.OPlogout) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this, Activity2.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}