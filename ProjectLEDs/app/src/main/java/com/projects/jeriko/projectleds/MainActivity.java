package com.projects.jeriko.projectleds;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int xValue;
    int yValue;
    int zValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void resetData(View view) {

        TextView textDebug = (TextView) findViewById(R.id.text01);

        try {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server("RESET");
        } catch (Exception e) {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
        }

    }

    public void resetDataInternal(){
        try {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server("RESET");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void blinkLed(View view) {
        TextView textDebug = (TextView) findViewById(R.id.text01);

        try {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server("LED");
        } catch (Exception e) {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
        }
    }
    public void redColor(View view){
/*
        TextView textDebug = (TextView) findViewById(R.id.text01);

        String tempString;
        String tempX;
        resetDataInternal();
*/
        xValue = 255;
        yValue = 0;
        zValue = 0;
        parseit(xValue,yValue,zValue);

/*  HANDLED BY NEW METHOD
        tempString = String.valueOf(xValue);
        tempX = "x" + tempString;

        try {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server(tempX);
            textDebug.setText("Success");
        } catch (Exception e) {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
        }
 */
    }


    public void xVal(View view) {
        TextView textDebug = (TextView) findViewById(R.id.text01);

        try {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server("x200");
        } catch (Exception e) {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
        }
    }

    public void yVal(View view) {
        TextView textDebug = (TextView) findViewById(R.id.text01);
        try {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server("y200");
        } catch (Exception e) {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
        }
    }

    public void zVal(View view) {
        TextView textDebug = (TextView) findViewById(R.id.text01);

        try {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server("z200");
        } catch (Exception e) {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
        }
    }
    public void apapun(View view) {
        TextView textDebug = (TextView) findViewById(R.id.text01);

        try {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server("z50");
        } catch (Exception e) {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
        }
        try {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server("y50");
        } catch (Exception e) {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
        }
        try {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server("x50");
        } catch (Exception e) {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
        }
    }
    public void pinkColor(View view)
    {
        xValue =255;
        yValue = 99;
        zValue = 99;
        parseit(xValue,yValue,zValue);
    }


    public void parseit (int xValue,int  yValue, int zValue)
    {
        String tempString;
        String tempX;
        String tempY;
        String tempZ;
        TextView textDebug = (TextView) findViewById(R.id.text01);
        TextView rDebug = (TextView) findViewById(R.id.text02);
        TextView gDebug = (TextView) findViewById(R.id.text03);
        TextView bDebug = (TextView) findViewById(R.id.text04);
        tempString = String.valueOf(xValue);
        tempX = "x" + tempString;
        tempString = String.valueOf(yValue);
        tempY = "y" + tempString;
        tempString = String.valueOf(zValue);
        tempZ = "z" + tempString;

        try
        {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server(tempX);
            textDebug.setText("Success");
            rDebug.setText(tempX);
        }
        catch (Exception e)
        {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
            rDebug.setText("ERROR SENDING");
        }
        try
        {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server(tempY);
            textDebug.setText("Success");
            gDebug.setText(tempY);
        }
        catch (Exception e)
        {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
            gDebug.setText("ERROR SENDING");
        }
        try
        {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server(tempZ);
            textDebug.setText("Success");
            bDebug.setText(tempZ);
        }
        catch (Exception e)
        {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
            bDebug.setText("ERROR SENDING");
        }

    }

}
