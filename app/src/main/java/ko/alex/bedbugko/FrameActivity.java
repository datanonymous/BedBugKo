package ko.alex.bedbugko;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class FrameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        //Setting up back floating action button
        findViewById(R.id.fabLogin).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FirebaseAuth.getInstance().signOut();
                finish(); //https://stackoverflow.com/questions/10847526/what-exactly-activity-finish-method-is-doing
                startActivity(new Intent(FrameActivity.this, MainActivity.class)); //Can also use getApplicationContext() instead of TableOfContents.this
            }
        });

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(new Bot1Frag());

    } //END ONCREATE



    //https://www.androidhive.info/2017/12/android-working-with-bottom-navigation/
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bot1:
                    //Toast.makeText(getApplicationContext(), "Climbing clinics", Toast.LENGTH_SHORT).show();
                    loadFragment(new Bot1Frag());
                    return true;
                case R.id.bot2:
                    //Toast.makeText(getApplicationContext(), "Yoga sessions", Toast.LENGTH_SHORT).show();
                    loadFragment(new Bot2Frag());
                    return true;
                case R.id.bot3:
                    //Toast.makeText(getApplicationContext(), "Special events", Toast.LENGTH_SHORT).show();
                    loadFragment(new Bot3Frag());
                    return true;
                case R.id.bot4:
                    //Toast.makeText(getApplicationContext(), "Special events", Toast.LENGTH_SHORT).show();
                    loadFragment(new Bot4Frag());
                    return true;
            }
            return false;
        }
    };
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //ViewPager should not be used when using bottom navigation
        transaction.replace(R.id.topConstraint, fragment); //TOP CONSTRAINT IS THE LAYOUT THAT IS CHANGED BETWEEN BOTTOM TABS
        transaction.addToBackStack(null);
        transaction.commit();
    }



    @Override
    public void onBackPressed() {
        Intent intent = new Intent(FrameActivity.this, MainActivity.class);
        startActivity(intent);
//        moveTaskToBack(true); //https://stackoverflow.com/questions/3141996/android-how-to-override-the-back-button-so-it-doesnt-finish-my-activity
    }



}
