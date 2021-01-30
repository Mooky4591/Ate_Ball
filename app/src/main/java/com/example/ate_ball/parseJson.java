package com.example.ate_ball;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

//public class parseJson {
//
//    String name;
//    int price_level;
//    int rating;
//    String address;
//    ArrayList<RestaurantObjectCreater> list_of_places;
//    String TAG = "tag";
//
//    public void parseJson(JSONObject json){
//
//        try {
//            JSONArray jsonArray = json.getJSONArray("results");
//            list_of_places = new ArrayList<>(jsonArray.length());
//            RestaurantObjectCreater restaurantOB = null;
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject results = jsonArray.getJSONObject(i);
//                name = results.getString("name");
//                price_level = results.getInt("price_level");
//                rating = results.getInt("rating");
//                address = results.getString("vicinity");
//
//                restaurantOB = new RestaurantObjectCreater(name, price_level, rating, address);
//                list_of_places.add(restaurantOB);
//
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//
