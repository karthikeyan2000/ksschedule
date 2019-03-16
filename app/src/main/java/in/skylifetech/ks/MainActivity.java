package in.skylifetech.ks;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isNetworkConnectionAvailable()) {
            TabLayout tabLayout = findViewById(R.id.sliding_tabs);
            SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());
            ViewPager viewPager = findViewById(R.id.viewpager);
            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);
        } else
            noNetworkConnection();
    }

    public void noNetworkConnection() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Please check your network state!");
        builder.setIcon(R.drawable.noInternetIcon);
        builder.setMessage("Please trun on internet connection to continuse!");
        builder.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                MainActivity.this.startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public boolean isNetworkConnectionAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnected();
        return isConnected;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!isNetworkConnectionAvailable())
            noNetworkConnection();
    }
}
