package hoo.u.magazine.u_hooprototype;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {
    Fragment fragment;
    FragmentManager fm;
    FragmentTransaction trans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-Light.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Note");
        dialog.setMessage("This App is still under development and most of the functions are still just for show. Please refrain from purchasing any items from this site at the moment\n\nIf you find any bugs or feel that the app has any areas which needs improving, please feel free to email bryanlowsk@gmail.com for any errors you may encounter.\n\nThank you for understanding. ");
        dialog.setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        if (savedInstanceState == null) {
            fragment = new FragmentHome();
            trans = getSupportFragmentManager().beginTransaction();
            trans.add(R.id.mainFrameLayout, fragment);
            trans.commit();
        }
        AlertDialog disclaimer = dialog.create();
        disclaimer.show();

        BottomNavigationView bottomBar = (BottomNavigationView) findViewById(R.id.navigation);
        bottomBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(bottomBar);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new FragmentHome();
                    fm = getSupportFragmentManager();
                    trans = fm.beginTransaction();
                    trans.replace(R.id.mainFrameLayout, fragment);
                    trans.commit();
                    return true;

                case R.id.navigation_history:
                    fragment = new FragmentHistory();
                    fm = getSupportFragmentManager();
                    trans = fm.beginTransaction();
                    trans.replace(R.id.mainFrameLayout, fragment);
                    trans.commit();

                case R.id.navigation_wallet:
                    return true;

                case R.id.navigation_account:
                    return true;

                case R.id.navigation_help:
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
