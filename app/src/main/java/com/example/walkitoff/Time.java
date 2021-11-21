package com.example.walkitoff;

public class Time {

    /**
     * parses time to string
     *
     * @return - parsed time (ex. 23:12 -> "2312") (String)
     */
    public static String parseTime( int hour, int minute ){

        // variables
        String parsedHour = String.valueOf( hour );
        String parsedMinute = String.valueOf( minute );

        if( hour < 10 ){

            parsedHour = "0" + parsedHour;
        }

        if( minute < 10 ){

            parsedMinute = "0" + parsedMinute;
        }

        return parsedHour + parsedMinute;
    }

    /**
     * to be used as an alarm label for alarm preset
     *
     * @return time in 12 hour format
     */
    public static String formatAlarmLabel( int hour, int minute ){

        String parsedHour = String.valueOf( hour );
        String parsedMinute = String.valueOf( minute );
        String meridiem = " AM";

        if( hour > 12 ){

            parsedHour = String.valueOf( hour - 12 );
            meridiem = " PM";
        }

        if( minute < 10 ){

            parsedMinute = "0" + String.valueOf( minute );
        }

        return parsedHour + ":" + parsedMinute + meridiem;
    }
}
