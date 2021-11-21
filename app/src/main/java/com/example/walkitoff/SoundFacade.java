package com.example.walkitoff;

public class SoundFacade {

    /**
     * facade class so that the main activity can interact with the sound list class and sound class
     * via this class only. The main activity only needs to input the level here and it can get an
     * array to populate the sound dropdown menu and also use a string to get the integer value
     * of a sound needed to input in the MediaPlayer.create method.
     */

    /**
     * gets an array of unlocked sounds to populate the sound dropdown menu
     *
     * @return array of the names of unlocked sounds
     */
    public static String[] getSoundArray( int level ){

        SoundList soundList = new SoundList( level );

        return soundList.addAllUnlockedSounds();
    }

    /**
     * uses the string sound name to get the integer value needed for the MediaPlayer.create method
     *
     * @param soundName - String value chosen by the user in the dropdown menu
     *
     * @return integer value of sound
     */
    public static int getSound( String soundName ){

        return SoundName.getSound( soundName );
    }


}
