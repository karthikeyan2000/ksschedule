package in.skylifetech.ks;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void d1b(View v) {
        Button d1button = findViewById(R.id.d1button);
        Button d1button2 = findViewById(R.id.d1button2);
        Button d1button3 = findViewById(R.id.d1button3);
        Button d1button4 = findViewById(R.id.d1button4);
        Button d1button5 = findViewById(R.id.d1button5);
        Button d1button6 = findViewById(R.id.d1button6);
        Button d1button7 = findViewById(R.id.d1button7);
        Button d1button8 = findViewById(R.id.d1button8);
        Button d1button9 = findViewById(R.id.d1button9);
        d1button.setBackground(getDrawable(R.drawable.capsule_pressed));
        d1button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button9.setBackground(getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(1, "Tamil Lits", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                Log.d("JSONArrayStorage", "" + jsonArray.length());
                ArrayList<Schedule> data;
                data = new ArrayList<>();

                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                Log.d("dataStorage", "" + data.size());
                recyclerView = findViewById(R.id.d1RecyclerView);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d1b2(View v) {
        Button d1button = findViewById(R.id.d1button);
        Button d1button2 = findViewById(R.id.d1button2);
        Button d1button3 = findViewById(R.id.d1button3);
        Button d1button4 = findViewById(R.id.d1button4);
        Button d1button5 = findViewById(R.id.d1button5);
        Button d1button6 = findViewById(R.id.d1button6);
        Button d1button7 = findViewById(R.id.d1button7);
        Button d1button8 = findViewById(R.id.d1button8);
        Button d1button9 = findViewById(R.id.d1button9);
        d1button.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button2.setBackground(getDrawable(R.drawable.capsule_pressed));
        d1button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button9.setBackground(getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(1, "Telugu Lits", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d1RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d1b3(View v) {
        Button d1button = findViewById(R.id.d1button);
        Button d1button2 = findViewById(R.id.d1button2);
        Button d1button3 = findViewById(R.id.d1button3);
        Button d1button4 = findViewById(R.id.d1button4);
        Button d1button5 = findViewById(R.id.d1button5);
        Button d1button6 = findViewById(R.id.d1button6);
        Button d1button7 = findViewById(R.id.d1button7);
        Button d1button8 = findViewById(R.id.d1button8);
        Button d1button9 = findViewById(R.id.d1button9);
        d1button.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button3.setBackground(getDrawable(R.drawable.capsule_pressed));
        d1button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button9.setBackground(getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(1, "English Lits", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d1RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d1b4(View v) {
        Button d1button = findViewById(R.id.d1button);
        Button d1button2 = findViewById(R.id.d1button2);
        Button d1button3 = findViewById(R.id.d1button3);
        Button d1button4 = findViewById(R.id.d1button4);
        Button d1button5 = findViewById(R.id.d1button5);
        Button d1button6 = findViewById(R.id.d1button6);
        Button d1button7 = findViewById(R.id.d1button7);
        Button d1button8 = findViewById(R.id.d1button8);
        Button d1button9 = findViewById(R.id.d1button9);
        d1button.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button4.setBackground(getDrawable(R.drawable.capsule_pressed));
        d1button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button9.setBackground(getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(1, "Hindi Lits", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d1RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }


    public void d1b5(View v) {
        Button d1button = findViewById(R.id.d1button);
        Button d1button2 = findViewById(R.id.d1button2);
        Button d1button3 = findViewById(R.id.d1button3);
        Button d1button4 = findViewById(R.id.d1button4);
        Button d1button5 = findViewById(R.id.d1button5);
        Button d1button6 = findViewById(R.id.d1button6);
        Button d1button7 = findViewById(R.id.d1button7);
        Button d1button8 = findViewById(R.id.d1button8);
        Button d1button9 = findViewById(R.id.d1button9);
        d1button.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button5.setBackground(getDrawable(R.drawable.capsule_pressed));
        d1button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button9.setBackground(getDrawable(R.drawable.capsule_normal));


        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(1, "Arts", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d1RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d1b6(View v) {
        Button d1button = findViewById(R.id.d1button);
        Button d1button2 = findViewById(R.id.d1button2);
        Button d1button3 = findViewById(R.id.d1button3);
        Button d1button4 = findViewById(R.id.d1button4);
        Button d1button5 = findViewById(R.id.d1button5);
        Button d1button6 = findViewById(R.id.d1button6);
        Button d1button7 = findViewById(R.id.d1button7);
        Button d1button8 = findViewById(R.id.d1button8);
        Button d1button9 = findViewById(R.id.d1button9);
        d1button.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button6.setBackground(getDrawable(R.drawable.capsule_pressed));
        d1button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button9.setBackground(getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(1, "Studio", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d1RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d1b7(View v) {
        Button d1button = findViewById(R.id.d1button);
        Button d1button2 = findViewById(R.id.d1button2);
        Button d1button3 = findViewById(R.id.d1button3);
        Button d1button4 = findViewById(R.id.d1button4);
        Button d1button5 = findViewById(R.id.d1button5);
        Button d1button6 = findViewById(R.id.d1button6);
        Button d1button7 = findViewById(R.id.d1button7);
        Button d1button8 = findViewById(R.id.d1button8);
        Button d1button9 = findViewById(R.id.d1button9);
        d1button.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button7.setBackground(getDrawable(R.drawable.capsule_pressed));
        d1button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button9.setBackground(getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(1, "Music", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d1RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d1b8(View v) {
        Button d1button = findViewById(R.id.d1button);
        Button d1button2 = findViewById(R.id.d1button2);
        Button d1button3 = findViewById(R.id.d1button3);
        Button d1button4 = findViewById(R.id.d1button4);
        Button d1button5 = findViewById(R.id.d1button5);
        Button d1button6 = findViewById(R.id.d1button6);
        Button d1button7 = findViewById(R.id.d1button7);
        Button d1button8 = findViewById(R.id.d1button8);
        Button d1button9 = findViewById(R.id.d1button9);
        d1button.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button8.setBackground(getDrawable(R.drawable.capsule_pressed));
        d1button9.setBackground(getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(1, "Dance", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d1RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d1b9(View v) {
        Button d1button = findViewById(R.id.d1button);
        Button d1button2 = findViewById(R.id.d1button2);
        Button d1button3 = findViewById(R.id.d1button3);
        Button d1button4 = findViewById(R.id.d1button4);
        Button d1button5 = findViewById(R.id.d1button5);
        Button d1button6 = findViewById(R.id.d1button6);
        Button d1button7 = findViewById(R.id.d1button7);
        Button d1button8 = findViewById(R.id.d1button8);
        Button d1button9 = findViewById(R.id.d1button9);
        d1button.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d1button9.setBackground(getDrawable(R.drawable.capsule_pressed));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(1, "OAT", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d1RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d2b(View v) {
        Button d2button = findViewById(R.id.d2button);
        Button d2button2 = findViewById(R.id.d2button2);
        Button d2button3 = findViewById(R.id.d2button3);
        Button d2button4 = findViewById(R.id.d2button4);
        Button d2button5 = findViewById(R.id.d2button5);
        Button d2button6 = findViewById(R.id.d2button6);
        Button d2button7 = findViewById(R.id.d2button7);
        Button d2button8 = findViewById(R.id.d2button8);
        Button d2button9 = findViewById(R.id.d2button9);
        d2button.setBackground(getDrawable(R.drawable.capsule_pressed));
        d2button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button9.setBackground(getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(2, "Tamil Lits", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d2RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d2b2(View v) {
        Button d2button = findViewById(R.id.d2button);
        Button d2button2 = findViewById(R.id.d2button2);
        Button d2button3 = findViewById(R.id.d2button3);
        Button d2button4 = findViewById(R.id.d2button4);
        Button d2button5 = findViewById(R.id.d2button5);
        Button d2button6 = findViewById(R.id.d2button6);
        Button d2button7 = findViewById(R.id.d2button7);
        Button d2button8 = findViewById(R.id.d2button8);
        Button d2button9 = findViewById(R.id.d2button9);
        d2button.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button2.setBackground(getDrawable(R.drawable.capsule_pressed));
        d2button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button9.setBackground(getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(2, "Telugu Lits", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d2RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d2b3(View v) {
        Button d2button = findViewById(R.id.d2button);
        Button d2button2 = findViewById(R.id.d2button2);
        Button d2button3 = findViewById(R.id.d2button3);
        Button d2button4 = findViewById(R.id.d2button4);
        Button d2button5 = findViewById(R.id.d2button5);
        Button d2button6 = findViewById(R.id.d2button6);
        Button d2button7 = findViewById(R.id.d2button7);
        Button d2button8 = findViewById(R.id.d2button8);
        Button d2button9 = findViewById(R.id.d2button9);
        d2button.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button3.setBackground(getDrawable(R.drawable.capsule_pressed));
        d2button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button9.setBackground(getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(2, "English Lits", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d2RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d2b4(View v) {
        Button d2button = findViewById(R.id.d1button);
        Button d2button2 = findViewById(R.id.d2button2);
        Button d2button3 = findViewById(R.id.d2button3);
        Button d2button4 = findViewById(R.id.d2button4);
        Button d2button5 = findViewById(R.id.d2button5);
        Button d2button6 = findViewById(R.id.d2button6);
        Button d2button7 = findViewById(R.id.d2button7);
        Button d2button8 = findViewById(R.id.d2button8);
        Button d2button9 = findViewById(R.id.d2button9);
        d2button.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button4.setBackground(getDrawable(R.drawable.capsule_pressed));
        d2button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button9.setBackground(getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(2, "Hindi Lits", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d2RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d2b5(View v) {
        Button d2button = findViewById(R.id.d2button);
        Button d2button2 = findViewById(R.id.d2button2);
        Button d2button3 = findViewById(R.id.d2button3);
        Button d2button4 = findViewById(R.id.d2button4);
        Button d2button5 = findViewById(R.id.d2button5);
        Button d2button6 = findViewById(R.id.d2button6);
        Button d2button7 = findViewById(R.id.d2button7);
        Button d2button8 = findViewById(R.id.d2button8);
        Button d2button9 = findViewById(R.id.d2button9);
        d2button.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button5.setBackground(getDrawable(R.drawable.capsule_pressed));
        d2button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button9.setBackground(getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(2, "Arts", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d2RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d2b6(View v) {
        Button d2button = findViewById(R.id.d2button);
        Button d2button2 = findViewById(R.id.d2button2);
        Button d2button3 = findViewById(R.id.d2button3);
        Button d2button4 = findViewById(R.id.d2button4);
        Button d2button5 = findViewById(R.id.d2button5);
        Button d2button6 = findViewById(R.id.d2button6);
        Button d2button7 = findViewById(R.id.d2button7);
        Button d2button8 = findViewById(R.id.d2button8);
        Button d2button9 = findViewById(R.id.d2button9);
        d2button.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button6.setBackground(getDrawable(R.drawable.capsule_pressed));
        d2button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button9.setBackground(getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(2, "Studio", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d2RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d2b7(View v) {
        Button d2button = findViewById(R.id.d2button);
        Button d2button2 = findViewById(R.id.d2button2);
        Button d2button3 = findViewById(R.id.d2button3);
        Button d2button4 = findViewById(R.id.d2button4);
        Button d2button5 = findViewById(R.id.d2button5);
        Button d2button6 = findViewById(R.id.d2button6);
        Button d2button7 = findViewById(R.id.d2button7);
        Button d2button8 = findViewById(R.id.d2button8);
        Button d2button9 = findViewById(R.id.d2button9);
        d2button.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button7.setBackground(getDrawable(R.drawable.capsule_pressed));
        d2button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button9.setBackground(getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(2, "Music", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d2RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d2b8(View v) {
        Button d2button = findViewById(R.id.d2button);
        Button d2button2 = findViewById(R.id.d2button2);
        Button d2button3 = findViewById(R.id.d2button3);
        Button d2button4 = findViewById(R.id.d2button4);
        Button d2button5 = findViewById(R.id.d2button5);
        Button d2button6 = findViewById(R.id.d2button6);
        Button d2button7 = findViewById(R.id.d2button7);
        Button d2button8 = findViewById(R.id.d2button8);
        Button d2button9 = findViewById(R.id.d2button9);
        d2button.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button8.setBackground(getDrawable(R.drawable.capsule_pressed));
        d2button9.setBackground(getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(2, "Dance", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d2RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d2b9(View v) {
        Button d2button = findViewById(R.id.d2button);
        Button d2button2 = findViewById(R.id.d2button2);
        Button d2button3 = findViewById(R.id.d2button3);
        Button d2button4 = findViewById(R.id.d2button4);
        Button d2button5 = findViewById(R.id.d2button5);
        Button d2button6 = findViewById(R.id.d2button6);
        Button d2button7 = findViewById(R.id.d2button7);
        Button d2button8 = findViewById(R.id.d2button8);
        Button d2button9 = findViewById(R.id.d2button9);
        d2button.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d2button9.setBackground(getDrawable(R.drawable.capsule_pressed));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(2, "OAT", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d2RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d3b(View v) {
        Button d3button = findViewById(R.id.d3button);
        Button d3button2 = findViewById(R.id.d3button2);
        Button d3button3 = findViewById(R.id.d3button3);
        Button d3button4 = findViewById(R.id.d3button4);
        Button d3button5 = findViewById(R.id.d3button5);
        Button d3button6 = findViewById(R.id.d3button6);
        Button d3button7 = findViewById(R.id.d3button7);
        Button d3button8 = findViewById(R.id.d3button8);
        Button d3button9 = findViewById(R.id.d3button9);
        d3button.setBackground(getDrawable(R.drawable.capsule_pressed));
        d3button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button9.setBackground(getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(3, "Tamil Lits", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d3RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d3b2(View v) {
        Button d3button = findViewById(R.id.d3button);
        Button d3button2 = findViewById(R.id.d3button2);
        Button d3button3 = findViewById(R.id.d3button3);
        Button d3button4 = findViewById(R.id.d3button4);
        Button d3button5 = findViewById(R.id.d3button5);
        Button d3button6 = findViewById(R.id.d3button6);
        Button d3button7 = findViewById(R.id.d3button7);
        Button d3button8 = findViewById(R.id.d3button8);
        Button d3button9 = findViewById(R.id.d3button9);
        d3button.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button2.setBackground(getDrawable(R.drawable.capsule_pressed));
        d3button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button9.setBackground(getDrawable(R.drawable.capsule_normal));


        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(3, "Telugu Lits", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d3RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d3b3(View v) {
        Button d3button = findViewById(R.id.d3button);
        Button d3button2 = findViewById(R.id.d3button2);
        Button d3button3 = findViewById(R.id.d3button3);
        Button d3button4 = findViewById(R.id.d3button4);
        Button d3button5 = findViewById(R.id.d3button5);
        Button d3button6 = findViewById(R.id.d3button6);
        Button d3button7 = findViewById(R.id.d3button7);
        Button d3button8 = findViewById(R.id.d3button8);
        Button d3button9 = findViewById(R.id.d3button9);
        d3button.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button3.setBackground(getDrawable(R.drawable.capsule_pressed));
        d3button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button9.setBackground(getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(3, "English Lits", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d3RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d3b4(View v) {
        Button d3button = findViewById(R.id.d1button);
        Button d3button2 = findViewById(R.id.d3button2);
        Button d3button3 = findViewById(R.id.d3button3);
        Button d3button4 = findViewById(R.id.d3button4);
        Button d3button5 = findViewById(R.id.d3button5);
        Button d3button6 = findViewById(R.id.d3button6);
        Button d3button7 = findViewById(R.id.d3button7);
        Button d3button8 = findViewById(R.id.d3button8);
        Button d3button9 = findViewById(R.id.d3button9);
        d3button.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button4.setBackground(getDrawable(R.drawable.capsule_pressed));
        d3button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button9.setBackground(getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(3, "Hindi Lits", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d3RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d3b5(View v) {
        Button d3button = findViewById(R.id.d3button);
        Button d3button2 = findViewById(R.id.d3button2);
        Button d3button3 = findViewById(R.id.d3button3);
        Button d3button4 = findViewById(R.id.d3button4);
        Button d3button5 = findViewById(R.id.d3button5);
        Button d3button6 = findViewById(R.id.d3button6);
        Button d3button7 = findViewById(R.id.d3button7);
        Button d3button8 = findViewById(R.id.d3button8);
        Button d3button9 = findViewById(R.id.d3button9);
        d3button.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button5.setBackground(getDrawable(R.drawable.capsule_pressed));
        d3button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button9.setBackground(getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(3, "Arts", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d3RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d3b6(View v) {
        Button d3button = findViewById(R.id.d3button);
        Button d3button2 = findViewById(R.id.d3button2);
        Button d3button3 = findViewById(R.id.d3button3);
        Button d3button4 = findViewById(R.id.d3button4);
        Button d3button5 = findViewById(R.id.d3button5);
        Button d3button6 = findViewById(R.id.d3button6);
        Button d3button7 = findViewById(R.id.d3button7);
        Button d3button8 = findViewById(R.id.d3button8);
        Button d3button9 = findViewById(R.id.d3button9);
        d3button.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button6.setBackground(getDrawable(R.drawable.capsule_pressed));
        d3button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button9.setBackground(getDrawable(R.drawable.capsule_normal));


        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(3, "Studio", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d3RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d3b7(View v) {
        Button d3button = findViewById(R.id.d3button);
        Button d3button2 = findViewById(R.id.d3button2);
        Button d3button3 = findViewById(R.id.d3button3);
        Button d3button4 = findViewById(R.id.d3button4);
        Button d3button5 = findViewById(R.id.d3button5);
        Button d3button6 = findViewById(R.id.d3button6);
        Button d3button7 = findViewById(R.id.d3button7);
        Button d3button8 = findViewById(R.id.d3button8);
        Button d3button9 = findViewById(R.id.d3button9);
        d3button.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button7.setBackground(getDrawable(R.drawable.capsule_pressed));
        d3button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button9.setBackground(getDrawable(R.drawable.capsule_normal));


        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(3, "Music", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d3RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d3b8(View v) {
        Button d3button = findViewById(R.id.d3button);
        Button d3button2 = findViewById(R.id.d3button2);
        Button d3button3 = findViewById(R.id.d3button3);
        Button d3button4 = findViewById(R.id.d3button4);
        Button d3button5 = findViewById(R.id.d3button5);
        Button d3button6 = findViewById(R.id.d3button6);
        Button d3button7 = findViewById(R.id.d3button7);
        Button d3button8 = findViewById(R.id.d3button8);
        Button d3button9 = findViewById(R.id.d3button9);
        d3button.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button8.setBackground(getDrawable(R.drawable.capsule_pressed));
        d3button9.setBackground(getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(3, "Dance", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d3RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    public void d3b9(View v) {
        Button d3button = findViewById(R.id.d3button);
        Button d3button2 = findViewById(R.id.d3button2);
        Button d3button3 = findViewById(R.id.d3button3);
        Button d3button4 = findViewById(R.id.d3button4);
        Button d3button5 = findViewById(R.id.d3button5);
        Button d3button6 = findViewById(R.id.d3button6);
        Button d3button7 = findViewById(R.id.d3button7);
        Button d3button8 = findViewById(R.id.d3button8);
        Button d3button9 = findViewById(R.id.d3button9);
        d3button.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button2.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button3.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button4.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button5.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button6.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button7.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button8.setBackground(getDrawable(R.drawable.capsule_normal));
        d3button9.setBackground(getDrawable(R.drawable.capsule_pressed));

        EndPoint endPoint = new EndPoint(this);
        endPoint.getData(3, "OAT", new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                ArrayList<Schedule> data;
                data = new ArrayList<>();
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        eventName = jsonObject.getString("ename");
                        eventVenue += jsonObject.getString("venue");
                        eventTime = jsonObject.getString("fromTime");
                        eventTime += " - ";
                        eventTime += jsonObject.getString("toTime");
                        Log.d("JSONResponse", i + " " + eventName + " " + eventVenue + " " + eventTime);
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, 0);
                    data.add(schedule);
                }
                recyclerView = findViewById(R.id.d3RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }
}
