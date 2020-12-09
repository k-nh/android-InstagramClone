package com.example.instagramclone.src.Main;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.instagramclone.R;
import com.example.instagramclone.src.Main.MainFeed.Comments.FragmentComment;
import com.example.instagramclone.src.Main.MainFeed.FragmentMain;
import com.example.instagramclone.src.Main.Navigation.Account.FragmentAccount;
import com.example.instagramclone.src.Main.Navigation.Alarm.FragmentAlarm;
import com.example.instagramclone.src.Main.Navigation.Search.FragmentSearch;
import com.example.instagramclone.src.Main.Navigation.Upload.FragmentUpload;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentMain fragmentMain = new FragmentMain();
    private FragmentSearch fragmentSearch = new FragmentSearch();
    private FragmentUpload fragmentUpload = new FragmentUpload();
    private FragmentAlarm fragmentAlarm = new FragmentAlarm();
    private FragmentAccount fragmentAccount = new FragmentAccount();
    private FragmentComment fragmentComment = new FragmentComment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_content, fragmentMain).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.BottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (menuItem.getItemId()) {
                case R.id.homeItem:
                    transaction.replace(R.id.main_content, fragmentMain).commitAllowingStateLoss();
                    break;
                case R.id.searchItem:
                    transaction.replace(R.id.main_content, fragmentSearch).commitAllowingStateLoss();
                    break;
                case R.id.uploadItem:
                    transaction.replace(R.id.main_content, fragmentUpload).commitAllowingStateLoss();
                    break;
                case R.id.alarmItem:
                    transaction.replace(R.id.main_content, fragmentAlarm).commitAllowingStateLoss();
                    break;
                case R.id.accountItem:
                    transaction.replace(R.id.main_content, fragmentAccount).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_content, fragment).addToBackStack(null).commit();
    }
}