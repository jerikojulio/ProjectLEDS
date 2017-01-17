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
    public void setColor(View view){

        switch (view.getId()) {
            case R.id.red01:
                xValue = 0xff;
                yValue = 0;
                zValue = 0;
                parseit(xValue,yValue,zValue);
                break;

            case R.id.red02:
                xValue = 0xfd;
                yValue = 0x2a;
                zValue = 0;
                parseit(xValue,yValue,zValue);
                break;

            case R.id.red03:
                xValue = 0xff;
                yValue = 0x44;
                zValue = 0;
                parseit(xValue,yValue,zValue);
                break;
            case R.id.red04:
                xValue = 0xff;
                yValue = 0x9d;
                zValue = 0;
                parseit(xValue,yValue,zValue);
                break;

            case R.id.red05:
                xValue = 0xfb;
                yValue = 0xff;
                zValue = 0;
                parseit(xValue,yValue,zValue);
                break;

            case R.id.green01:
                xValue = 0;
                yValue = 0xb0;
                zValue = 0;
                parseit(xValue,yValue,zValue);
                break;

            case R.id.green02:
                xValue = 0x0c;
                yValue = 0xc8;
                zValue = 0x0c;
                parseit(xValue,yValue,zValue);
                break;

            case R.id.green03:
                xValue = 0x00;
                yValue = 0x90;
                zValue = 0x90;
                parseit(xValue,yValue,zValue);
                break;

            case R.id.green04:
                xValue = 0x00;
                yValue = 0x80;
                zValue = 0x00;
                parseit(xValue,yValue,zValue);
                break;

            case R.id.green05:
                xValue = 0x00;
                yValue = 0x30;
                zValue = 0x00;
                parseit(xValue,yValue,zValue);
                break;

            case R.id.rplus:
                xValue = xValue+8;
                if (xValue>=0xff)
                {
                    xValue=0xff;
                }
                parseit(xValue,yValue,zValue);
                break;

            case R.id.gplus:
                yValue = yValue+8;
                if (yValue>=0xff)
                {
                    yValue=0xff;
                }
                parseit(xValue,yValue,zValue);
                break;

            case R.id.bplus:
                zValue = zValue+8;
                if (zValue>=0xff)
                {
                    zValue=0xff;
                }
                parseit(xValue,yValue,zValue);
                break;

            case R.id.rminus:
                xValue = xValue-8;
                if (xValue<=0x00)
                {
                    xValue=0x00;
                }
                parseit(xValue,yValue,zValue);
                break;

            case R.id.gminus:
                yValue = yValue-8;
                if (yValue<=0x00)
                {
                    yValue=0x00;
                }
                parseit(xValue,yValue,zValue);
                break;

            case R.id.bminus:
                zValue = zValue-8;
                if (zValue<=0x0)
                {
                    zValue=0x00;
                }
                parseit(xValue,yValue,zValue);
                break;

        }
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
