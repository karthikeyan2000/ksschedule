package in.skylifetech.ks;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Day1 extends Fragment {

    private static final String TAG = Day1.class.getSimpleName();
    public static Day1 instance;
    public ArrayList<Schedule> scheduleArrayList = new ArrayList<>();
    private RecyclerView clusterRecyclerView;
    private ClusterAdapter clusterAdapter;
    private View view;

    public static Day1 getInstance() {
        if (instance == null) {
            instance = new Day1();
        }
        return instance;
    }

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

        clusterRecyclerView = view.findViewById(R.id.d1ClusterRecyclerView);
        clusterAdapter = new ClusterAdapter(getActivity(), 1);
        clusterRecyclerView.setAdapter(clusterAdapter);
        clusterRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    public void getSchedule(String query, final CallbackInterface callbackInterface, final ClusterAdapter.ClusterHolder clusterHolder) {

        EndPoint endPoint = new EndPoint(getActivity());
        endPoint.getData(1, query, new ServerCallback() {
            @Override
            public void onSuccess(JSONArray jsonArray, Context context) {
                String eventName = "", eventVenue = "Venue: ", eventTime = "";
                Schedule schedule;
                scheduleArrayList.clear();
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
                    schedule = new Schedule(eventName, eventVenue, eventTime);
                    scheduleArrayList.add(schedule);
                }
                if (scheduleArrayList.size() > 0)
                    callbackInterface.setScheduleData(scheduleArrayList, clusterHolder, false);
                else
                    callbackInterface.setScheduleData(null, null, true);
            }
        });
    }
}