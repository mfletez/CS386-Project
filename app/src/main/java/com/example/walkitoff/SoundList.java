package com.example.walkitoff;

public class SoundList {

    /*
    this class is to be used by the Alarm class. it functions as a library
    of sounds that the user can choose from, all stored in an array
     */

    private static final int NUMBER_OF_ALL_SOUNDS = 4;

    private int arrayCapacity, level;

    /**
     * constructor
     */
    public SoundList(int level ){

        this.level = level;

        if( level < NUMBER_OF_ALL_SOUNDS ){

            arrayCapacity = level + 1;
        }
        else{

            arrayCapacity = NUMBER_OF_ALL_SOUNDS;

        }
    }

    /**
     * adds a sound to an array if it has the capacity for it and returns the updated array
     *
     * @param array - the array to add sound name to
     *
     * @param arraySize - how many sound names are in the array
     *
     * @param soundName - the sound name that can appear on the menu
     *
     * @return array
     */
    private String[] addSound( String[] array, int arraySize, String soundName ){

        if( arraySize < arrayCapacity ){

            array[ arraySize ] = soundName;

        }

        return array;
    }

    /**
     * adds all unlocked sounds to the array.
     * <p>
     * note: uses score object to determine which sounds to add
     */
    public String[] addAllUnlockedSounds(){

        String[] unlockedSoundArray = new String[ arrayCapacity ];

        int arraySize = 0;

        // TODO: add sounds without the repetition shown below
        // maybe map each level to a sound name?

        unlockedSoundArray = addSound( unlockedSoundArray, arraySize, SoundName.DEFAULT_SOUND );
        arraySize++;

        unlockedSoundArray = addSound( unlockedSoundArray, arraySize, SoundName.SOUND_ONE );
        arraySize++;

        unlockedSoundArray = addSound( unlockedSoundArray, arraySize, SoundName.SOUND_TWO );
        arraySize++;

        unlockedSoundArray = addSound( unlockedSoundArray, arraySize, SoundName.SOUND_THREE );
        arraySize++;

        return unlockedSoundArray;

    }

}
