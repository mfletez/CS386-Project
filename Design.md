#*1. Description*
WalkItOff is an app for those people that have a rough time waking up in the morning, this will change the way they start their day. The user will set an alarm and walk a set distance to turn off the alarm when it goes off. Location services are used to pinpoint the user's location. The app has a leveling up system that will allow users to unlock different sounds to use as new alarms. The app has a high score system so that there is some competition and motivation for all the users.

#*2. Architecture*
The WalkItOff app has two components, the MYSQL database, and the Android application. Similar to the examples given we have split these into two packages.Classes are also listed as packages within the larger packages, these represent the individual classes and their respective functions,which will help facilitate the display of the interconnectivities. The dotted lines serve to represent the individual connectivities between class packages.
![image](https://user-images.githubusercontent.com/89943041/140659914-10eb7751-8315-4787-b803-9c48740a6f98.png)



#*3. Class Diagram*

![](https://github.com/aidenhalili/CS386-Project/blob/main/Class%20Screenshot.jpg)

#*4. Sequence Diagram*
![image](https://user-images.githubusercontent.com/89943041/140682137-ae790673-6836-4059-8668-85e5a67ed923.png)
Use Case:
Adding a new alarm

Actor:
User

Description:
The User can create a new alarm once requested

Pre-Condition:
The User has recently opened the app and ready to set an alarm for the next day

Post-Condition:
The new alarm has been set and saved

Main-Flow

1.The User has requested to make a new alarm.

2.The system has opened up the prompt for the user to select Time of alarm, Alarm sound, and distance requested.

3.The User selects the time they would like for the alarm to go off.

4.The system would save the requested time.

5.The User would open up the list of sounds they can choose from.

6.The System pulls the sounds available for the user.

7.The User selects one of the sounds given to them.

8.The system saves that sound for the current alarm.

9.The User then inputs the Distance they wish to walk in order to turn alarm off.

10.The system saves that distance into the alarm.

11.The User then selects save for the system.

11.The system takes all three requested objects and combines them to finish the alarm.

12.The system closes the prompts and the alarm is ready to go off upon selected time from the User.

Alternative Flow
**. The User decides to cancel the request to set an alarm

The system would then cancel the prompt and return to previous screen


#*5. Design Patterns*

![Design Patterns](https://user-images.githubusercontent.com/71902318/140685454-ed98e290-f55b-433c-b75e-16fec9797fb7.jpg)

[LocationData] https://github.com/aidenhalili/CS386-Project/blob/main/app/src/main/java/com/example/walkitoff/LocationData.java
[Distance] https://github.com/aidenhalili/CS386-Project/blob/main/app/src/main/java/com/example/walkitoff/Distance.java
[Score] https://github.com/aidenhalili/CS386-Project/blob/main/app/src/main/java/com/example/walkitoff/Score.java
[Observer] https://github.com/aidenhalili/CS386-Project/blob/main/app/src/main/java/com/example/walkitoff/Observer.java

Location and LocationManager are imported; no link available. 



#*6. Design Principles*

1. Our design observes the single responsibility principle by including classes that only have a single responsibility. The Single Responsibility Principle requires that “There should never be more than one reason for a class to change.” An example of this is our class “Sound”. This class's only responsibility is to provide a library of sounds that the user can choose from. 
Example: 

![sounds](https://user-images.githubusercontent.com/72279824/140683441-284f4180-e12e-4a44-b7cd-5dae8c51a296.PNG)
![sound2](https://user-images.githubusercontent.com/72279824/140683458-cc5898c9-1aea-468f-9278-01b8bee0c963.PNG)
![sounds3](https://user-images.githubusercontent.com/72279824/140683470-ac94ee11-0f61-4ce7-af5e-977ad7e86751.PNG)

2. Next, our design follows the Open/Closed Principle. The Open/Closed Principle requires that “Software entities should be open for extension, but closed for modification.”  It does this by allowing the user to add on and extend the behavior of a class without having to go back and change parts of the code in that class. An example of this is our unitsOfmeasurement class, where if you want to add another unit of measurement, you can do so without having to alter any previous code. When you add a new unit of measurement, you just add in another method that deals with the conversion that you want to happen. Example:

![units](https://user-images.githubusercontent.com/72279824/140683550-76e4315c-d227-4082-bdbb-28d536f92711.PNG)
![units2](https://user-images.githubusercontent.com/72279824/140683559-6b50c765-00f2-4a8c-86b1-c4651d58c8f4.PNG)

3. For the Liskov Substitution Principle, it requires that “Objects in a program should be replaceable with instances of their subtypes without altering the correctness of that program.” We do not directly use the Liskov Substitution Principle in our code; we do not currently have any subtypes for the different objects. 

4. An example of the Interface Segregation Principle in our code would be the unitsOfMeasurement Class. This class allows the user to choose between their desired unit of measurement, but it does not force any of the other options on the user if they do not want them. For example, the default unit of measurement is in meters, and if the user is fine with that, they do not have to go and mess with any of the other units. If the user selects a different unit of measurement, they choose which measurement they would like without having any other units of measurement imposed on them that they do not care for. Example: 

![units](https://user-images.githubusercontent.com/72279824/140683626-6e8dfa40-43b5-453b-9a37-29009a662b15.PNG)
![units2](https://user-images.githubusercontent.com/72279824/140683641-e45cef44-01ae-4bc7-ba3d-a57d9317dfcd.PNG)

5. For the Dependency Inversion Principle, it requires that “High level modules should not depend upon low level modules. Both should depend upon abstractions” and that “Abstractions should not depend upon details. Details should depend upon abstractions.” We do not directly use the Dependency Inversion Principle in our code.

