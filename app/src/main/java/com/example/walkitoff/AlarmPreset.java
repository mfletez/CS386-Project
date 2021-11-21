package com.example.walkitoff;

import android.content.Context;
import android.media.MediaPlayer;

public class AlarmPreset {

    private String alarmLabel;
    private String time;
    private MediaPlayer sound;
    private Context context;

    /**
     * constructor for alarm preset
     * <p>
     * note: add distance to parameter as soon as the feature for choosing goal distance is
     * implemented
     *
     * @param sound - the name of the sound to wake up to
     */
    public AlarmPreset( Context context, int hour, int minute, MediaPlayer sound ){

        this.time = Time.parseTime( hour, minute );
        this.sound = sound;

        this.context = context;

        alarmLabel = Time.formatAlarmLabel( hour, minute );

    }

    public String getAlarmLabel(){

        return alarmLabel;
    }
    /**
     * creates an alarm object based off of member data
     *
     * @return alarm
     */
    public Alarm makeAlarm(){

        return new Alarm( context, time, sound );
    }
}
