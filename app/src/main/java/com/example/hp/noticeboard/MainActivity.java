package com.example.hp.noticeboard;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         *Setup the DrawerLayout and NavigationView
         */
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerView,new HomeFragment()).commit();

        /**
         * Setup click events on the Navigation View Items.
         */
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                drawerLayout.closeDrawers();

                if (menuItem.getItemId() == R.id.nav_item_home) {
                    FragmentTransaction mFragmentTransaction = fragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.containerView,new HomeFragment()).commit();
                    getSupportActionBar().setTitle("College Notice");
                }

                if (menuItem.getItemId() == R.id.nav_item_bachelors) {
                    FragmentTransaction mFragmentTransaction = fragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();
                    getSupportActionBar().setTitle("B.E. Notice");
                }


                if (menuItem.getItemId() == R.id.nav_item_masters) {
                    FragmentTransaction mFragmentTransaction = fragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.containerView,new MastersTabFragment()).commit();
                    getSupportActionBar().setTitle("M.E. Notice");
                }


                if (menuItem.getItemId() == R.id.nav_item_login) {
                    FragmentTransaction mFragmentTransaction = fragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.containerView,new LoginFragment()).commit();
                    getSupportActionBar().setTitle("Login");
                }


                if (menuItem.getItemId() == R.id.nav_item_about) {
                    FragmentTransaction mFragmentTransaction = fragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.containerView,new AboutFragment()).commit();
                    getSupportActionBar().setTitle("About Us");
                }

                return false;
            }

        });

        /**
         * Setup Drawer Toggle of the Toolbar
         */
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);

        drawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id = item.getItemId();

        if (res_id==R.id.action_search){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
