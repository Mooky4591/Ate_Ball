package com.example.ate_ball;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class PlacesService {

    public static final String JSON_LOCATION = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=";
    private static final String KEY = "&key=AIzaSyABF2V9P8AcXW3iM_n7Wz--xIbVob5UIXg";

    Context context;

    public PlacesService(Context context){
        this.context = context;
    }

    public interface VolleyResponseListener {
        void onError(String Message);

        void onResponse(String Places);
    }

    //Method to send the API call and manipulate the return string
    public void getPlaces(String lat, String lon, String distance, String price, final VolleyResponseListener volleyResponseListener){
        String url = JSON_LOCATION + lat + "," + lon + "&radius=" + distance + "&type=restaurant&maxprice=" + price + KEY;
        final String[] result = {""};

        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        result[0] = response;
                        volleyResponseListener.onResponse(result[0]);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyResponseListener.onError("Something went wrong");
            }
        });

        RequestSingleton.getInstance(context).addToRequestQueue(request);

    }
}
