package com.project.myprogress;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.project.myprogress.adapters.AdapterProfilePager;
import com.project.myprogress.fragments_container.ContainerFragment;
import com.project.myprogress.fragments_profile.AddProgressFragment;
import com.project.myprogress.fragments_profile.AddTaskFragment;
import com.project.myprogress.fragments_profile.ProfileFragment;
import com.project.myprogress.fragments_profile.TasksFragment;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class ProfileActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    public Fragment user_info_fragment, add_progress_fragment, task_fragment, add_task_fragment;
    NavController navController;

    public Fragment container_fragment;
    public Context context;

    FragmentManager fragmentManager = getSupportFragmentManager();

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        user_info_fragment = new ProfileFragment();
        add_progress_fragment = new AddProgressFragment();
        //task_fragment = new TasksFragment();
        add_task_fragment = new AddTaskFragment();
        container_fragment = new ContainerFragment();



        fragmentManager.beginTransaction()
                .add(R.id.nav_host_fragment, user_info_fragment)
                .commit();





        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.nav_header_desc, R.string.nav_app_bar_open_drawer_description
        );

        drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();




        if (id == R.id.nav_profile) {



            getSupportFragmentManager().popBackStack(null,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);

           /* fragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment, user_info_fragment)
                        .commit();
*/

        } else if (id == R.id.nav_task) {


            fragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.nav_host_fragment, container_fragment)
                    .commit();

        }

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);


        return true;
    }


}




