package in.skylifetech.ks;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Day1 extends Fragment {

    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    View view;
    ProgressBar progressBar;

    public Day1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_day1, container, false);

        progressBar = view.findViewById(R.id.d1progressbar);

        b();

        Button button = view.findViewById(R.id.d1button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b();
            }
        });

        Button button2 = view.findViewById(R.id.d1button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2();
            }
        });

        Button button3 = view.findViewById(R.id.d1button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b3();
            }
        });

        Button button4 = view.findViewById(R.id.d1button4);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b4();
            }
        });

        Button button5 = view.findViewById(R.id.d1button5);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b5();
            }
        });

        Button button6 = view.findViewById(R.id.d1button6);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b6();
            }
        });

        Button button7 = view.findViewById(R.id.d1button7);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b7();
            }
        });

        Button button8 = view.findViewById(R.id.d1button8);

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b8();
            }
        });

        Button button9 = view.findViewById(R.id.d1button9);

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b9();
            }
        });

        return view;
    }

    private void b() {
        progressBar.setVisibility(View.VISIBLE);
        Button d1button = view.findViewById(R.id.d1button);
        Button d1button2 = view.findViewById(R.id.d1button2);
        Button d1button3 = view.findViewById(R.id.d1button3);
        Button d1button4 = view.findViewById(R.id.d1button4);
        Button d1button5 = view.findViewById(R.id.d1button5);
        Button d1button6 = view.findViewById(R.id.d1button6);
        Button d1button7 = view.findViewById(R.id.d1button7);
        Button d1button8 = view.findViewById(R.id.d1button8);
        Button d1button9 = view.findViewById(R.id.d1button9);
        d1button.setBackground(getActivity().getDrawable(R.drawable.capsule_pressed));
        d1button2.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button3.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button4.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button5.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button6.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button7.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button8.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button9.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(getActivity());
        endPoint.getData(1, "Tamil Lits", new ServerCallback() {
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
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, Color.parseColor("#ffffff"));
                    data.add(schedule);
                }
                recyclerView = view.findViewById(R.id.d1RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
        progressBar.setVisibility(View.GONE);
    }

    private void b2() {
        progressBar.setVisibility(View.VISIBLE);
        Button d1button = view.findViewById(R.id.d1button);
        Button d1button2 = view.findViewById(R.id.d1button2);
        Button d1button3 = view.findViewById(R.id.d1button3);
        Button d1button4 = view.findViewById(R.id.d1button4);
        Button d1button5 = view.findViewById(R.id.d1button5);
        Button d1button6 = view.findViewById(R.id.d1button6);
        Button d1button7 = view.findViewById(R.id.d1button7);
        Button d1button8 = view.findViewById(R.id.d1button8);
        Button d1button9 = view.findViewById(R.id.d1button9);
        d1button.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button2.setBackground(getActivity().getDrawable(R.drawable.capsule_pressed));
        d1button3.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button4.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button5.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button6.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button7.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button8.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button9.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(getActivity());
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
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, Color.parseColor("#ffff00"));
                    data.add(schedule);
                }
                recyclerView = view.findViewById(R.id.d1RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
        progressBar.setVisibility(View.GONE);
    }

    private void b3() {
        progressBar.setVisibility(View.VISIBLE);
        Button d1button = view.findViewById(R.id.d1button);
        Button d1button2 = view.findViewById(R.id.d1button2);
        Button d1button3 = view.findViewById(R.id.d1button3);
        Button d1button4 = view.findViewById(R.id.d1button4);
        Button d1button5 = view.findViewById(R.id.d1button5);
        Button d1button6 = view.findViewById(R.id.d1button6);
        Button d1button7 = view.findViewById(R.id.d1button7);
        Button d1button8 = view.findViewById(R.id.d1button8);
        Button d1button9 = view.findViewById(R.id.d1button9);
        d1button.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button2.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button3.setBackground(getActivity().getDrawable(R.drawable.capsule_pressed));
        d1button4.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button5.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button6.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button7.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button8.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button9.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(getActivity());
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
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, Color.parseColor("#ff00ff"));
                    data.add(schedule);
                }
                recyclerView = view.findViewById(R.id.d1RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
        progressBar.setVisibility(View.GONE);
    }

    private void b4() {
        progressBar.setVisibility(View.VISIBLE);
        Button d1button = view.findViewById(R.id.d1button);
        Button d1button2 = view.findViewById(R.id.d1button2);
        Button d1button3 = view.findViewById(R.id.d1button3);
        Button d1button4 = view.findViewById(R.id.d1button4);
        Button d1button5 = view.findViewById(R.id.d1button5);
        Button d1button6 = view.findViewById(R.id.d1button6);
        Button d1button7 = view.findViewById(R.id.d1button7);
        Button d1button8 = view.findViewById(R.id.d1button8);
        Button d1button9 = view.findViewById(R.id.d1button9);
        d1button.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button2.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button3.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button4.setBackground(getActivity().getDrawable(R.drawable.capsule_pressed));
        d1button5.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button6.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button7.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button8.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button9.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(getActivity());
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
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, Color.parseColor("#00ffff"));
                    data.add(schedule);
                }
                recyclerView = view.findViewById(R.id.d1RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
        progressBar.setVisibility(View.GONE);
    }

    private void b5() {
        progressBar.setVisibility(View.VISIBLE);
        Button d1button = view.findViewById(R.id.d1button);
        Button d1button2 = view.findViewById(R.id.d1button2);
        Button d1button3 = view.findViewById(R.id.d1button3);
        Button d1button4 = view.findViewById(R.id.d1button4);
        Button d1button5 = view.findViewById(R.id.d1button5);
        Button d1button6 = view.findViewById(R.id.d1button6);
        Button d1button7 = view.findViewById(R.id.d1button7);
        Button d1button8 = view.findViewById(R.id.d1button8);
        Button d1button9 = view.findViewById(R.id.d1button9);
        d1button.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button2.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button3.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button4.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button5.setBackground(getActivity().getDrawable(R.drawable.capsule_pressed));
        d1button6.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button7.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button8.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button9.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));


        EndPoint endPoint = new EndPoint(getActivity());
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
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, Color.parseColor("#ff0000"));
                    data.add(schedule);
                }
                recyclerView = view.findViewById(R.id.d1RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
        progressBar.setVisibility(View.GONE);
    }

    private void b6() {
        progressBar.setVisibility(View.VISIBLE);
        Button d1button = view.findViewById(R.id.d1button);
        Button d1button2 = view.findViewById(R.id.d1button2);
        Button d1button3 = view.findViewById(R.id.d1button3);
        Button d1button4 = view.findViewById(R.id.d1button4);
        Button d1button5 = view.findViewById(R.id.d1button5);
        Button d1button6 = view.findViewById(R.id.d1button6);
        Button d1button7 = view.findViewById(R.id.d1button7);
        Button d1button8 = view.findViewById(R.id.d1button8);
        Button d1button9 = view.findViewById(R.id.d1button9);
        d1button.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button2.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button3.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button4.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button5.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button6.setBackground(getActivity().getDrawable(R.drawable.capsule_pressed));
        d1button7.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button8.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button9.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(getActivity());
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
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, Color.parseColor("#00ff00"));
                    data.add(schedule);
                }
                recyclerView = view.findViewById(R.id.d1RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
        progressBar.setVisibility(View.GONE);
    }

    private void b7() {
        progressBar.setVisibility(View.VISIBLE);
        Button d1button = view.findViewById(R.id.d1button);
        Button d1button2 = view.findViewById(R.id.d1button2);
        Button d1button3 = view.findViewById(R.id.d1button3);
        Button d1button4 = view.findViewById(R.id.d1button4);
        Button d1button5 = view.findViewById(R.id.d1button5);
        Button d1button6 = view.findViewById(R.id.d1button6);
        Button d1button7 = view.findViewById(R.id.d1button7);
        Button d1button8 = view.findViewById(R.id.d1button8);
        Button d1button9 = view.findViewById(R.id.d1button9);
        d1button.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button2.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button3.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button4.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button5.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button6.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button7.setBackground(getActivity().getDrawable(R.drawable.capsule_pressed));
        d1button8.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button9.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(getActivity());
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
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, Color.parseColor("#0000ff"));
                    data.add(schedule);
                }
                recyclerView = view.findViewById(R.id.d1RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
        progressBar.setVisibility(View.GONE);
    }

    private void b8() {
        progressBar.setVisibility(View.VISIBLE);
        Button d1button = view.findViewById(R.id.d1button);
        Button d1button2 = view.findViewById(R.id.d1button2);
        Button d1button3 = view.findViewById(R.id.d1button3);
        Button d1button4 = view.findViewById(R.id.d1button4);
        Button d1button5 = view.findViewById(R.id.d1button5);
        Button d1button6 = view.findViewById(R.id.d1button6);
        Button d1button7 = view.findViewById(R.id.d1button7);
        Button d1button8 = view.findViewById(R.id.d1button8);
        Button d1button9 = view.findViewById(R.id.d1button9);
        d1button.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button2.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button3.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button4.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button5.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button6.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button7.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button8.setBackground(getActivity().getDrawable(R.drawable.capsule_pressed));
        d1button9.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(getActivity());
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
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, Color.parseColor("#ccccff"));
                    data.add(schedule);
                }
                recyclerView = view.findViewById(R.id.d1RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
        progressBar.setVisibility(View.GONE);
    }

    private void b9() {
        progressBar.setVisibility(View.VISIBLE);
        Button d1button = view.findViewById(R.id.d1button);
        Button d1button2 = view.findViewById(R.id.d1button2);
        Button d1button3 = view.findViewById(R.id.d1button3);
        Button d1button4 = view.findViewById(R.id.d1button4);
        Button d1button5 = view.findViewById(R.id.d1button5);
        Button d1button6 = view.findViewById(R.id.d1button6);
        Button d1button7 = view.findViewById(R.id.d1button7);
        Button d1button8 = view.findViewById(R.id.d1button8);
        Button d1button9 = view.findViewById(R.id.d1button9);
        d1button.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button2.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button3.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button4.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button5.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button6.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button7.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button8.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d1button9.setBackground(getActivity().getDrawable(R.drawable.capsule_pressed));

        EndPoint endPoint = new EndPoint(getActivity());
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
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, Color.parseColor("#000000"));
                    data.add(schedule);
                }
                recyclerView = view.findViewById(R.id.d1RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
        progressBar.setVisibility(View.GONE);
    }
}
