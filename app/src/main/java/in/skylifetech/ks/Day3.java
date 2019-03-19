package in.skylifetech.ks;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Day3 extends Fragment {

    private static final String TAG = Day3.class.getSimpleName();
    public static Day3 instance;
    public ArrayList<Schedule> scheduleArrayList = new ArrayList<>();
    private RecyclerView clusterRecyclerView;
    private ClusterAdapter clusterAdapter;
    private View view;

    public static Day3 getInstance() {  //Gets the instance of this fragment.
        if (instance == null) {
            instance = new Day3();
        }
        return instance;
    }

    public Day3() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_day3, container, false);

        clusterRecyclerView = view.findViewById(R.id.d1ClusterRecyclerView);        //Creates the rrecycler view and displays the clusters
        clusterAdapter = new ClusterAdapter(getActivity(), 1);
        clusterRecyclerView.setAdapter(clusterAdapter);
        clusterRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    public void getSchedule(String query, final CallbackInterface callbackInterface, final ClusterAdapter.ClusterHolder clusterHolder) {
        //Schedule data is set here.

        //TODO: Implement API here.

        //API is to be called here.
        //API returns JSONArray.
        //Parse it here and return it in scheduleArrayList.
        //It is to be queried with the 'query', which has the query word, and day.
        //Name, venue in the format: "Venue: ________" and time in the format: "08.30 AM - 12.30 PM" is the data that is required.

        scheduleArrayList.clear();      //Clears the previous data.
        scheduleArrayList.add(new Schedule("THAMIZATTAM", "Venue: JVC CR 1", "08.30 AM - 11.00"));  //Fake placeholder datas.
        scheduleArrayList.add(new Schedule("DRAMA", "JVC CR 2", "08.30 AM - 11.00"));
        scheduleArrayList.add(new Schedule("SHERLOCK", "VKJ CR 1", "08.30 AM - 11.00"));
        callbackInterface.setScheduleData(scheduleArrayList, clusterHolder, false);     //Callback interface to set schedule data.
    }
}
