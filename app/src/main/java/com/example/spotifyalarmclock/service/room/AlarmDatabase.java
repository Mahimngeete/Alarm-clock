package com.example.spotifyalarmclock.service.room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.spotifyalarmclock.service.model.Alarm;
import com.example.spotifyalarmclock.service.model.AlarmType;

@Database(entities = Alarm.class, version = 1)
public abstract class AlarmDatabase extends RoomDatabase {
    private static AlarmDatabase instance;

    public abstract AlarmDao alarmDao();

    public static synchronized AlarmDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AlarmDatabase.class,
                    "alarm_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(room_callback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback room_callback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDBAsyncTask(instance).execute();
        }
    };

    private static class PopulateDBAsyncTask extends AsyncTask<Void, Void, Void>{

        private AlarmDao alarmDao;

        private PopulateDBAsyncTask(AlarmDatabase alarmDatabase){
            alarmDao = alarmDatabase.alarmDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            alarmDao.insert(new Alarm(6, 15, AlarmType.AM, "spotify:user:spotify:playlist:37i9dQZF1DX9oegrjMzKDW", true, false, false, "", null));
            alarmDao.insert(new Alarm(6, 20, AlarmType.AM, "spotify:user:spotify:playlist:37i9dQZF1DX9oegrjMzKDW", true, false, false, "", null));
            alarmDao.insert(new Alarm(6, 25, AlarmType.AM, "spotify:user:spotify:playlist:37i9dQZF1DX9oegrjMzKDW", true, false, false, "", null));
            return null;
        }
    }

}
