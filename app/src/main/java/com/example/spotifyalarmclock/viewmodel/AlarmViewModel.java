package com.example.spotifyalarmclock.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.spotifyalarmclock.service.model.Alarm;
import com.example.spotifyalarmclock.service.repository.AlarmRepository;

import java.util.List;

public class AlarmViewModel extends AndroidViewModel {

    private AlarmRepository alarmRepository;
    private LiveData<List<Alarm>> allAlarms;

    public AlarmViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Alarm>> getAllAlarms(){
        alarmRepository = new AlarmRepository(getApplication());
        allAlarms = alarmRepository.getAllAlarms();
        return allAlarms;
    }

    public void createNewAlarm(Alarm alarm){
        alarmRepository.createNewAlarm(alarm);
    }

    public void deleteAlarm(Alarm alarm){
        alarmRepository.deleteAlarm(alarm);
    }

    public void updateAlarm(Alarm alarm){
        alarmRepository.updateAlarm(alarm);
    }

}
