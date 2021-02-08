package com.example.Conestoga_Real_Estate;

import android.content.Intent;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.Fragment;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerlayout = findViewById(R.id.drawer);
        ActionBarDrawerToggle mToggle = new ActionBarDrawerToggle(this, mDrawerlayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        // Browse Property button listener

        BottomNavigationView bottomNav = findViewById(R.id.botton_nav);
        bottomNav.setOnNavigationItemSelectedListener(navlistener);

    }
    // Action  On Dragable navigation menu selection
    private BottomNavigationView.OnNavigationItemSelectedListener navlistener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                // On Dashboard click strt main activity
                case R.id.bot_home:
                    selectedFragment = new HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    break;

                case R.id.bot_forsale:
                    Intent intent= new Intent(getApplicationContext(),SaleActivity.class);
                    startActivity(intent);
                    break;

                case R.id.bot_forrent:
                    Intent rintent= new Intent(getApplicationContext(),RentActivity.class);
                    startActivity(rintent);
                    break;

            }
            //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;

        }
    };

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){

        switch (item.getItemId()){
            // On Dashboard click strt main activity
            case R.id.dhome:

                Intent hActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(hActivity);

                break;

            case R.id.newsearch:

                Intent mActivity = new Intent(getApplicationContext(), MapActivity.class);
                startActivity(mActivity);

                break;

            case R.id.forrent:
                Intent rintent= new Intent(getApplicationContext(),RentActivity.class);
                startActivity(rintent);
                break;

            case R.id.forsale:
                Intent intent= new Intent(getApplicationContext(),SaleActivity.class);
                startActivity(intent);
                break;


            case R.id.recview:
                Intent vActivity = new Intent(getApplicationContext(), ViewActivity.class);
                startActivity(vActivity);
                break;

            /*case R.id.recsearch:
                Intent sActivity = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(sActivity);
                break;*/

        }
        mDrawerlayout.closeDrawer(GravityCompat.START);

        return true;
    }

    // functionality to close drawable layout on back button press
    @Override
    public void onBackPressed(){
        if(mDrawerlayout.isDrawerOpen(GravityCompat.START)){
            mDrawerlayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

}
