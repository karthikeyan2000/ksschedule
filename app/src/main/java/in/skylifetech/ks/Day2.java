package in.skylifetech.ks;

import android.app.ProgressDialog;
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

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Day2 extends Fragment {

    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    View view;
    ProgressDialog progressDialog;

    public Day2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_day2, container, false);

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Loading...");
        progressDialog.setMessage("Downloading Data.....Please Wait");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);

        b();

        Button button = view.findViewById(R.id.d2button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b();
            }
        });

        Button button2 = view.findViewById(R.id.d2button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2();
            }
        });

        Button button3 = view.findViewById(R.id.d2button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b3();
            }
        });

        Button button4 = view.findViewById(R.id.d2button4);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b4();
            }
        });

        Button button5 = view.findViewById(R.id.d2button5);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b5();
            }
        });

        Button button6 = view.findViewById(R.id.d2button6);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b6();
            }
        });

        Button button7 = view.findViewById(R.id.d2button7);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b7();
            }
        });

        Button button8 = view.findViewById(R.id.d2button8);

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b8();
            }
        });

        Button button9 = view.findViewById(R.id.d2button9);

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b9();
            }
        });

        return view;
    }

    public void b() {
        progressDialog.show();
        Button d2button = view.findViewById(R.id.d2button);
        Button d2button2 = view.findViewById(R.id.d2button2);
        Button d2button3 = view.findViewById(R.id.d2button3);
        Button d2button4 = view.findViewById(R.id.d2button4);
        Button d2button5 = view.findViewById(R.id.d2button5);
        Button d2button6 = view.findViewById(R.id.d2button6);
        Button d2button7 = view.findViewById(R.id.d2button7);
        Button d2button8 = view.findViewById(R.id.d2button8);
        Button d2button9 = view.findViewById(R.id.d2button9);
        d2button.setBackground(getActivity().getDrawable(R.drawable.capsule_pressed));
        d2button2.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button3.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button4.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button5.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button6.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button7.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button8.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button9.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(getActivity());
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
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, Color.parseColor("#ffffff"));
                    data.add(schedule);
                }
                recyclerView = view.findViewById(R.id.d2RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
        progressDialog.cancel();
    }

    public void b2() {
        progressDialog.show();
        Button d2button = view.findViewById(R.id.d2button);
        Button d2button2 = view.findViewById(R.id.d2button2);
        Button d2button3 = view.findViewById(R.id.d2button3);
        Button d2button4 = view.findViewById(R.id.d2button4);
        Button d2button5 = view.findViewById(R.id.d2button5);
        Button d2button6 = view.findViewById(R.id.d2button6);
        Button d2button7 = view.findViewById(R.id.d2button7);
        Button d2button8 = view.findViewById(R.id.d2button8);
        Button d2button9 = view.findViewById(R.id.d2button9);
        d2button.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button2.setBackground(getActivity().getDrawable(R.drawable.capsule_pressed));
        d2button3.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button4.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button5.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button6.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button7.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button8.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button9.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(getActivity());
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
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, Color.parseColor("#ffff00"));
                    data.add(schedule);
                }
                recyclerView = view.findViewById(R.id.d2RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
        progressDialog.cancel();
    }

    public void b3() {
        progressDialog.show();
        Button d2button = view.findViewById(R.id.d2button);
        Button d2button2 = view.findViewById(R.id.d2button2);
        Button d2button3 = view.findViewById(R.id.d2button3);
        Button d2button4 = view.findViewById(R.id.d2button4);
        Button d2button5 = view.findViewById(R.id.d2button5);
        Button d2button6 = view.findViewById(R.id.d2button6);
        Button d2button7 = view.findViewById(R.id.d2button7);
        Button d2button8 = view.findViewById(R.id.d2button8);
        Button d2button9 = view.findViewById(R.id.d2button9);
        d2button.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button2.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button3.setBackground(getActivity().getDrawable(R.drawable.capsule_pressed));
        d2button4.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button5.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button6.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button7.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button8.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button9.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(getActivity());
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
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, Color.parseColor("#ff00ff"));
                    data.add(schedule);
                }
                recyclerView = view.findViewById(R.id.d2RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
        progressDialog.cancel();
    }

    public void b4() {
        progressDialog.show();
        Button d2button = view.findViewById(R.id.d2button);
        Button d2button2 = view.findViewById(R.id.d2button2);
        Button d2button3 = view.findViewById(R.id.d2button3);
        Button d2button4 = view.findViewById(R.id.d2button4);
        Button d2button5 = view.findViewById(R.id.d2button5);
        Button d2button6 = view.findViewById(R.id.d2button6);
        Button d2button7 = view.findViewById(R.id.d2button7);
        Button d2button8 = view.findViewById(R.id.d2button8);
        Button d2button9 = view.findViewById(R.id.d2button9);
        d2button.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button2.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button3.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button4.setBackground(getActivity().getDrawable(R.drawable.capsule_pressed));
        d2button5.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button6.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button7.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button8.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button9.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(getActivity());
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
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, Color.parseColor("#00ffff"));
                    data.add(schedule);
                }
                recyclerView = view.findViewById(R.id.d2RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
        progressDialog.cancel();
    }

    public void b5() {
        progressDialog.show();
        Button d2button = view.findViewById(R.id.d2button);
        Button d2button2 = view.findViewById(R.id.d2button2);
        Button d2button3 = view.findViewById(R.id.d2button3);
        Button d2button4 = view.findViewById(R.id.d2button4);
        Button d2button5 = view.findViewById(R.id.d2button5);
        Button d2button6 = view.findViewById(R.id.d2button6);
        Button d2button7 = view.findViewById(R.id.d2button7);
        Button d2button8 = view.findViewById(R.id.d2button8);
        Button d2button9 = view.findViewById(R.id.d2button9);
        d2button.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button2.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button3.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button4.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button5.setBackground(getActivity().getDrawable(R.drawable.capsule_pressed));
        d2button6.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button7.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button8.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button9.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(getActivity());
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
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, Color.parseColor("#ff0000"));
                    data.add(schedule);
                }
                recyclerView = view.findViewById(R.id.d2RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
        progressDialog.cancel();
    }

    public void b6() {
        progressDialog.show();
        Button d2button = view.findViewById(R.id.d2button);
        Button d2button2 = view.findViewById(R.id.d2button2);
        Button d2button3 = view.findViewById(R.id.d2button3);
        Button d2button4 = view.findViewById(R.id.d2button4);
        Button d2button5 = view.findViewById(R.id.d2button5);
        Button d2button6 = view.findViewById(R.id.d2button6);
        Button d2button7 = view.findViewById(R.id.d2button7);
        Button d2button8 = view.findViewById(R.id.d2button8);
        Button d2button9 = view.findViewById(R.id.d2button9);
        d2button.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button2.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button3.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button4.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button5.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button6.setBackground(getActivity().getDrawable(R.drawable.capsule_pressed));
        d2button7.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button8.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button9.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(getActivity());
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
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, Color.parseColor("#00ff00"));
                    data.add(schedule);
                }
                recyclerView = view.findViewById(R.id.d2RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
        progressDialog.cancel();
    }

    public void b7() {
        progressDialog.show();
        Button d2button = view.findViewById(R.id.d2button);
        Button d2button2 = view.findViewById(R.id.d2button2);
        Button d2button3 = view.findViewById(R.id.d2button3);
        Button d2button4 = view.findViewById(R.id.d2button4);
        Button d2button5 = view.findViewById(R.id.d2button5);
        Button d2button6 = view.findViewById(R.id.d2button6);
        Button d2button7 = view.findViewById(R.id.d2button7);
        Button d2button8 = view.findViewById(R.id.d2button8);
        Button d2button9 = view.findViewById(R.id.d2button9);
        d2button.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button2.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button3.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button4.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button5.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button6.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button7.setBackground(getActivity().getDrawable(R.drawable.capsule_pressed));
        d2button8.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button9.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(getActivity());
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
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, Color.parseColor("#0000ff"));
                    data.add(schedule);
                }
                recyclerView = view.findViewById(R.id.d2RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
        progressDialog.cancel();
    }

    public void b8() {
        progressDialog.show();
        Button d2button = view.findViewById(R.id.d2button);
        Button d2button2 = view.findViewById(R.id.d2button2);
        Button d2button3 = view.findViewById(R.id.d2button3);
        Button d2button4 = view.findViewById(R.id.d2button4);
        Button d2button5 = view.findViewById(R.id.d2button5);
        Button d2button6 = view.findViewById(R.id.d2button6);
        Button d2button7 = view.findViewById(R.id.d2button7);
        Button d2button8 = view.findViewById(R.id.d2button8);
        Button d2button9 = view.findViewById(R.id.d2button9);
        d2button.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button2.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button3.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button4.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button5.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button6.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button7.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button8.setBackground(getActivity().getDrawable(R.drawable.capsule_pressed));
        d2button9.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));

        EndPoint endPoint = new EndPoint(getActivity());
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
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, Color.parseColor("#ccccff"));
                    data.add(schedule);
                }
                recyclerView = view.findViewById(R.id.d2RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
        progressDialog.cancel();
    }

    public void b9() {
        progressDialog.show();
        Button d2button = view.findViewById(R.id.d2button);
        Button d2button2 = view.findViewById(R.id.d2button2);
        Button d2button3 = view.findViewById(R.id.d2button3);
        Button d2button4 = view.findViewById(R.id.d2button4);
        Button d2button5 = view.findViewById(R.id.d2button5);
        Button d2button6 = view.findViewById(R.id.d2button6);
        Button d2button7 = view.findViewById(R.id.d2button7);
        Button d2button8 = view.findViewById(R.id.d2button8);
        Button d2button9 = view.findViewById(R.id.d2button9);
        d2button.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button2.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button3.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button4.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button5.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button6.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button7.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button8.setBackground(getActivity().getDrawable(R.drawable.capsule_normal));
        d2button9.setBackground(getActivity().getDrawable(R.drawable.capsule_pressed));

        EndPoint endPoint = new EndPoint(getActivity());
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
                    } catch (Exception e) {
                        //Log.d("in.skylifetech.ks.json", e.getMessage());
                    }
                    schedule = new Schedule(eventName, eventVenue, eventTime, Color.parseColor("#000000"));
                    data.add(schedule);
                }
                recyclerView = view.findViewById(R.id.d2RecyclerView);
                layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerViewAdapter = new ScheduleAdapter(context, data);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
        progressDialog.cancel();
    }
}
