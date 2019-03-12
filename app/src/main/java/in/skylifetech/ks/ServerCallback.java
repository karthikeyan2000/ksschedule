package in.skylifetech.ks;

import android.content.Context;

import org.json.JSONArray;

public interface ServerCallback {
    void onSuccess(JSONArray jsonArray, Context context);
}
