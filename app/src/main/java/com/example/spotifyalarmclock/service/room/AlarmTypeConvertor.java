package com.example.spotifyalarmclock.service.room;

import androidx.room.TypeConverter;

import com.example.spotifyalarmclock.service.model.AlarmType;

public class AlarmTypeConvertor {

    @TypeConverter
    public static int alarmTypeToInt(AlarmType alarmType){
        if(alarmType == null){
            return 0;
        }
        return alarmType == AlarmType.AM ? 0 : 1;
    }

    @TypeConverter
    public static AlarmType intToAlarmType(int i){
        return i == 0 ? AlarmType.AM : AlarmType.PM;
    }
}
