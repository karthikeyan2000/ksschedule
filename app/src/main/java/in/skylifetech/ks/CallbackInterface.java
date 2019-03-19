package in.skylifetech.ks;

import java.util.ArrayList;

public interface CallbackInterface {
    void callback(String queryGame);

    void setScheduleData(ArrayList<Schedule> data, ClusterAdapter.ClusterHolder gameHolder, boolean isEmpty);
}
