package com.example.spotifyalarmclock.service.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.spotifyalarmclock.service.room.AlarmDayConverter;
import com.example.spotifyalarmclock.service.room.AlarmTypeConvertor;

import java.util.Map;

@Entity(tableName = "alarm_table")
public class Alarm {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int alarm_hour;
    private int alarm_min;
    @TypeConverters(AlarmTypeConvertor.class)
    private AlarmType alarmType;
    private String spotifyPlaylistName;
    private boolean isShuffle;
    private boolean isRepeat;
    private boolean isAlarmSet;
    private String alarmRingtone;

    @TypeConverters(AlarmDayConverter.class)
    private Map<Integer, Boolean> daysAlarmIsSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getAlarm_hour() {
        return alarm_hour;
    }

    public void setAlarm_hour(int alarm_hour) {
        this.alarm_hour = alarm_hour;
    }

    public int getAlarm_min() {
        return alarm_min;
    }

    public void setAlarm_min(int alarm_min) {
        this.alarm_min = alarm_min;
    }

    public AlarmType getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(AlarmType alarmType) {
        this.alarmType = alarmType;
    }

    public String getSpotifyPlaylistName() {
        return spotifyPlaylistName;
    }

    public void setSpotifyPlaylistName(String spotifyPlaylistName) {
        this.spotifyPlaylistName = spotifyPlaylistName;
    }

    public boolean isShuffle() {
        return isShuffle;
    }

    public void setShuffle(boolean shuffle) {
        isShuffle = shuffle;
    }

    public boolean isRepeat() {
        return isRepeat;
    }

    public void setRepeat(boolean repeat) {
        isRepeat = repeat;
    }

    public boolean isAlarmSet() {
        return isAlarmSet;
    }

    public void setAlarmSet(boolean alarmSet) {
        isAlarmSet = alarmSet;
    }

    public String getAlarmRingtone() {
        return alarmRingtone;
    }

    public void setAlarmRingtone(String alarmRingtone) {
        this.alarmRingtone = alarmRingtone;
    }

    public Map<Integer, Boolean> getDaysAlarmIsSet() {
        return daysAlarmIsSet;
    }

    public void setDaysAlarmIsSet(Map<Integer, Boolean> daysAlarmIsSet) {
        this.daysAlarmIsSet = daysAlarmIsSet;
    }


    public Alarm(int alarm_hour, int alarm_min, AlarmType alarmType, String spotifyPlaylistName, boolean isShuffle, boolean isRepeat, boolean isAlarmSet, String alarmRingtone, Map<Integer, Boolean> daysAlarmIsSet) {
        this.alarm_hour = alarm_hour;
        this.alarm_min = alarm_min;
        this.alarmType = alarmType;
        this.spotifyPlaylistName = spotifyPlaylistName;
        this.isShuffle = isShuffle;
        this.isRepeat = isRepeat;
        this.isAlarmSet = isAlarmSet;
        this.alarmRingtone = alarmRingtone;
        this.daysAlarmIsSet = daysAlarmIsSet;
    }


}
