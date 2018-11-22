package com.example.modamaniaapp.modamania.app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle("Anasayfa");
                    Home home = new Home();
                    android.support.v4.app.FragmentTransaction fragmentTransactionHome = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionHome.replace(R.id.modamaniaContainer, home, "Trends");
                    fragmentTransactionHome.commit();
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_trends:
                    setTitle("Trend");
                    Trends trends = new Trends();
                    android.support.v4.app.FragmentTransaction fragmentTransactionTrends = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionTrends.replace(R.id.modamaniaContainerContentContainer, trends, "Notifications");
                    fragmentTransactionTrends.commit();
                    mTextMessage.setText(R.string.title_trends);
                    return true;
                case R.id.navigation_notifications:
                    setTitle("Bildirimler");
                    Notification notification = new Notification();
                    android.support.v4.app.FragmentTransaction fragmentTransactionNotification = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionNotification.replace(R.id.modamaniaContainerContentContainer, notification, "Profile");
                    fragmentTransactionNotification.commit();


                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_profile:
                    setTitle("Profil");
                    Profile profile = new Profile();
                    android.support.v4.app.FragmentTransaction fragmentTransactionProfile = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionProfile.replace(R.id.modamaniaContainerContentContainer, profile, "Profile");
                    fragmentTransactionProfile.commit();

                    mTextMessage.setText(R.string.title_profile);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
