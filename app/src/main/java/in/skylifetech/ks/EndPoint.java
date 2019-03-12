package in.skylifetech.ks;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

public class EndPoint {
    private Context context;

    public EndPoint(Context ctx) {
        context = ctx;
    }

    public void getData(final int day, final String cluster, final ServerCallback callback) {
        String url = "https://protocolfest.co.in/ks/participants/getAllEvents.php";
        JsonArrayRequest jasonArrayRequest = new JsonArrayRequest(
                Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                callback.onSuccess(jsonArray,context);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Log.d("in.skylifetech.ks.api", error.getMessage());
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(jasonArrayRequest);
    }
}
