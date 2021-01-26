package com.example.ate_ball;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class PlacesService {

    public static final String JSON_LOCATION = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=";
    private static final String KEY = "&key=AIzaSyABF2V9P8AcXW3iM_n7Wz--xIbVob5UIXg";

    String TAG = "tag";

    Context context;

    public PlacesService(Context context){
        this.context = context;
    }

    public interface VolleyResponseListener {
        void onError(String Message);

        void onResponse(JSONObject Places);
    }

    //Method to send the API call and manipulate the return string
    public void getPlaces(String lat, String lon, String distance, String price, final VolleyResponseListener volleyResponseListener){
        String url = JSON_LOCATION + lat + "," + lon + "&radius=" + distance + "&type=restaurant&maxprice=" + price + KEY;
        final String[] result = {""};

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        volleyResponseListener.onResponse(response);
                        parseJson parse = new parseJson();
                        parse.parseJson(response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyResponseListener.onError("Something went wrong");
                error.printStackTrace();
            }
        });

        RequestSingleton.getInstance(context).addToRequestQueue(request);

    }
}
