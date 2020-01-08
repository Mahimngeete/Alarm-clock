package com.example.spotifyalarmclock.service.room;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;


public class AlarmDayConverter {
    @TypeConverter
    public static String convertMapToString(Map<Integer, Boolean> map){
        Gson gson = new Gson();
        if (map == null){
            return null;
        }
        return gson.toJson(map);
    }

    @TypeConverter
    public static Map<Integer,Boolean> convertStringToMap(String data){
        Gson gson = new Gson();
        if(data == null){
            return null;
        }
        Type map = new TypeToken<Map<Integer,Boolean>>(){}.getType();
        return gson.fromJson(data, map);
    }

}
