package com.example.spotifyalarmclock.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotifyalarmclock.R;
import com.example.spotifyalarmclock.service.model.Alarm;
import com.example.spotifyalarmclock.service.model.AlarmType;

import java.util.List;

public class AlarmAdapter extends ListAdapter<Alarm, AlarmAdapter.AlarmHolder> {

    private OnItemClickListener listener;

    public AlarmAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Alarm> DIFF_CALLBACK = new DiffUtil.ItemCallback<Alarm>() {
        @Override
        public boolean areItemsTheSame(@NonNull Alarm oldItem, @NonNull Alarm newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Alarm oldItem, @NonNull Alarm newItem) {
            return checkIfContentsAreSame(oldItem, newItem);
        }
    };

    @NonNull
    @Override
    public AlarmHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.alarm_list_item, parent, false);
        return new AlarmHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull AlarmAdapter.AlarmHolder holder, int position) {
        Alarm currentAlarm = getItem(position);
        String time  = currentAlarm.getAlarm_hour() + ":" + currentAlarm.getAlarm_min();
        holder.textViewTime.setText(time);
        holder.textViewAlarmType.setText(currentAlarm.getAlarmType() == AlarmType.AM ? "am" : "pm");
        holder.isAlarmSetSwitch.setChecked(currentAlarm.isAlarmSet());
        holder.editTextSpotifyPlaylistName.setText(currentAlarm.getSpotifyPlaylistName());
        holder.isShuffleSetSwitch.setChecked(currentAlarm.isShuffle());
    }

    class AlarmHolder extends RecyclerView.ViewHolder {
        private TextView textViewTime;
        private TextView textViewAlarmType;
        private Switch isAlarmSetSwitch;
        private EditText editTextSpotifyPlaylistName;
        private Switch isShuffleSetSwitch;

        public AlarmHolder(@NonNull View itemView) {
            super(itemView);
            textViewTime = itemView.findViewById(R.id.alarm_time_hh_mm);
            textViewAlarmType = itemView.findViewById(R.id.alarm_type);
            isAlarmSetSwitch = itemView.findViewById(R.id.is_alarm_set_switch);
            isShuffleSetSwitch = itemView.findViewById(R.id.is_shuffle_set_switch);
            editTextSpotifyPlaylistName = itemView.findViewById(R.id.spotify_playlist_name);
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(getItem(position));
                }
            });
        }
    }

    private static boolean checkIfContentsAreSame(Alarm oldItem, Alarm newItem) {
        return oldItem.getAlarm_hour() == newItem.getAlarm_hour() && oldItem.getAlarm_min() == newItem.getAlarm_min()
                && oldItem.getAlarmType() == newItem.getAlarmType() && oldItem.getSpotifyPlaylistName() == newItem.getSpotifyPlaylistName()
                && oldItem.isShuffle() == newItem.isShuffle() && oldItem.isRepeat() == newItem.isRepeat()
                && oldItem.isAlarmSet() == newItem.isAlarmSet();
    }

    public interface OnItemClickListener {
        void onItemClick(Alarm alarm);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

}

