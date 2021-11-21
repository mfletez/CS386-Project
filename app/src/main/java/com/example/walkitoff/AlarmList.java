package com.example.walkitoff;

public class AlarmList {

    public static AlarmPreset[] alarmArray;

    public static int size;

    /**
     * constructor
     */
    public AlarmList(){

        size = 1;

        alarmArray = new AlarmPreset[ size ];
    }

    /**
     * adds alarm preset to array
     *
     * @param preset - alarm preset to add
     */
    public void addPreset( AlarmPreset preset ){

        if( alarmArray[ 0 ] != null ){

            resize();
        }

        alarmArray[ size - 1 ] = preset;

    }

    /**
     * finds alarm preset by its label
     *
     * @param label - key for searching
     *
     * @return preset
     */
    public AlarmPreset findPreset( String label ){

        int index;

        for( index = 0; index < size; index++ ){

            if( alarmArray[ index ].getAlarmLabel().equals( label ) ){

                return alarmArray[ index ];
            }
        }

        return null;
    }

    /**
     * increments the size of the array
     */
    private void resize(){

        int index;

        AlarmPreset[] tempArray = new AlarmPreset[ size + 1 ];

        for( index = 0; index < size; index++ ){

            tempArray[ index ] = alarmArray[ index ];
        }

        alarmArray = tempArray;

        size++;
    }

}
