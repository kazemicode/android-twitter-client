package com.codepath.apps.restclienttemplate.models;
import com.codepath.apps.restclienttemplate.TimeFormatter;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;
import org.parceler.Parcels;

@Parcel
public class Tweet {
    public String body;
    public String createdAt;
    public User user;

    public Tweet() {} // empty constructor needed for Parceler class

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        return tweet;
    }

    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for(int i=0; i< jsonArray.length(); i++){
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }

        return tweets;
    }

    public String getFormattedTimeStamp(){
        String result = TimeFormatter.getTimeDifference(createdAt);
        return result;
    }
}
