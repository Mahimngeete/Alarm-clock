package com.example.spotifyalarmclock.service.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.spotifyalarmclock.service.model.Alarm;
import com.example.spotifyalarmclock.service.room.AlarmDao;
import com.example.spotifyalarmclock.service.room.AlarmDatabase;

import java.util.List;

public class AlarmRepository {
    private AlarmDao alarmDao;
    private LiveData<List<Alarm>> allAlarms;

    public AlarmRepository(Application application){
        AlarmDatabase alarmDatabase = AlarmDatabase.getInstance(application);
        alarmDao = alarmDatabase.alarmDao();
        allAlarms = alarmDao.getAllAlarms();
    }

    public void createNewAlarm(Alarm alarm){
        new CreateNewAlarmAsyncTask(alarmDao).execute(alarm);
    }

    public void updateAlarm(Alarm alarm){
        new UpdateAlarmAsyncTask(alarmDao).execute(alarm);
    }

    public void deleteAlarm(Alarm alarm){
        new DeleteAlarmAsyncTask(alarmDao).execute(alarm);
    }

    public LiveData<List<Alarm>> getAllAlarms(){
        return allAlarms;
    }

    private static class CreateNewAlarmAsyncTask extends AsyncTask<Alarm, Void, Void>{
        private AlarmDao alarmDao;
        CreateNewAlarmAsyncTask(AlarmDao alarmDao){
            this.alarmDao = alarmDao;
        }

        @Override
        protected Void doInBackground(Alarm... alarms) {
            alarmDao.insert(alarms[0]);
            return null;
        }
    }

    private static class UpdateAlarmAsyncTask extends AsyncTask<Alarm, Void, Void>{
        private AlarmDao alarmDao;

        UpdateAlarmAsyncTask(AlarmDao alarmDao){
            this.alarmDao = alarmDao;
        }

        @Override
        protected Void doInBackground(Alarm... alarms) {
            alarmDao.update(alarms[0]);
            return null;
        }
    }

    private static class DeleteAlarmAsyncTask extends AsyncTask<Alarm, Void, Void>{
        private AlarmDao alarmDao;

        DeleteAlarmAsyncTask(AlarmDao alarmDao){
            this.alarmDao = alarmDao;
        }

        @Override
        protected Void doInBackground(Alarm... alarms) {
            alarmDao.update(alarms[0]);
            return null;
        }
    }


}
