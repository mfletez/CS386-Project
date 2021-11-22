package com.example.walkitoff;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectDB extends AppCompatActivity {

    TextView thebox, testView, view1,view2,view3,view4,view5;
    EditText idField,hostField,passField,adminField;
    public static String hostName,dbPass,adminName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_db);
        thebox = (TextView) findViewById(R.id.statusText);
        view1 = (TextView) findViewById(R.id.textView9);
        view2 = (TextView) findViewById(R.id.textView10);
        view3 = (TextView) findViewById(R.id.textView11);
        view4 = (TextView) findViewById(R.id.textView12);
        view5 = (TextView) findViewById(R.id.textView13);
        idField = (EditText) findViewById(R.id.editText1);
        hostField = (EditText) findViewById(R.id.editText2);
        passField = (EditText) findViewById(R.id.editText3);
        adminField = (EditText) findViewById(R.id.editText4);



    }

    public void getConnected(View view)
    {
        //set values before async uses them
        MainActivity.uID = idField.getText().toString();
        hostName = hostField.getText().toString();
        adminName = adminField.getText().toString();
        dbPass = passField.getText().toString();
        new getDBData().execute();
    }

    public void updateDB(View view)
    {

        new updateDB().execute();
    }

    class getDBData extends AsyncTask<Void, Void, Void> {

        String records = "",error = "", message = "Connected!!", distanceRan = "", unlockLevel = "";
        
        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(hostName, adminName, dbPass);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM user");


                //iterate through DB
                while(resultSet.next())
                {
                    records += resultSet.getString(1) + " "
                            + resultSet.getString(2) + " "
                            + resultSet.getInt(3) + " "
                            + resultSet.getInt(4) + " "
                            + resultSet.getInt(5) + "\n";
                }


                //Get user name.
                resultSet = statement.executeQuery("SELECT user_name FROM user WHERE id =" + MainActivity.uID);
                while(resultSet.next()) {
                    MainActivity.uName = resultSet.getString(1);
                }

                //get user distance data
                resultSet = statement.executeQuery("SELECT distance_ran FROM user WHERE id =" + MainActivity.uID);
                while(resultSet.next()) {
                    MainActivity.uDistance = resultSet.getString(1);
                }

                //get user score
                resultSet = statement.executeQuery("SELECT user_score FROM user WHERE id =" + MainActivity.uID);
                while(resultSet.next()) {
                    MainActivity.uScore = resultSet.getString(1);
                }

                //get user level
                resultSet = statement.executeQuery("SELECT user_level FROM user WHERE id =" + MainActivity.uID);
                while(resultSet.next()) {
                    MainActivity.uLevel = resultSet.getString(1);
                }


            } catch (Exception e) {
                error = e.toString();

            }
            return null;
        }


        //-----------------------------------------------------
        @Override
        protected void onPostExecute(Void aVoid) {
   
            thebox.setText(records);
            view1.setText(MainActivity.uID);
            view2.setText(MainActivity.uName);
            view3.setText(MainActivity.uDistance);
            view4.setText(MainActivity.uScore);
            view5.setText(MainActivity.uLevel);



            if (error != "")
                thebox.setText(error);
            super.onPostExecute(aVoid);
        }


    }//end async

    class updateDB extends AsyncTask<Void, Void, Void> {

        String records = "",error = "", message = "Connected!!", distanceRan = "", unlockLevel = "";
        //public Statement statement;

        @Override
        protected Void doInBackground(Void... voids) {

            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(hostName, adminName, dbPass);
                Statement statement = connection.createStatement();

                statement.executeUpdate("UPDATE user SET distance_ran = "
                        + MainActivity.uDistance +  " WHERE id = " + MainActivity.uID);

                statement.executeUpdate("UPDATE user SET user_score = "
                        + MainActivity.uScore +  " WHERE id = " + MainActivity.uID);

                statement.executeUpdate("UPDATE user SET user_level = "
                        + MainActivity.uLevel +  " WHERE id = " + MainActivity.uID);



            } catch (Exception e) {
                error = e.toString();

            }
            return null;
        }


        //-----------------------------------------------------
        @Override
        protected void onPostExecute(Void aVoid) {

            if (error != "")
                thebox.setText(error);
            super.onPostExecute(aVoid);
        }


    }//end asyncUpdate


}//end ConnectDB
