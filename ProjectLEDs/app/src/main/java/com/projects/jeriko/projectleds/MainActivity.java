package com.projects.jeriko.projectleds;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int xValue;
    int yValue;
    int zValue;
    String tempString;


    private TextView bright;
    private TextView textDebug;
    private TextView rDebug;
    private TextView gDebug;
    private TextView bDebug;

    private View mainActivityView;

    int brValue = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bright = (TextView) findViewById(R.id.brtext);
        textDebug = (TextView) findViewById(R.id.receiveText);
        rDebug = (TextView) findViewById(R.id.text02);
        gDebug = (TextView) findViewById(R.id.text03);
        bDebug = (TextView) findViewById(R.id.text04);
        mainActivityView = getWindow().getDecorView().getRootView();
        getSupportActionBar().setTitle("WIFI LED CONTROLLER");
    }

    public void resetData(View view) {

        try {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server("RESET", this);
            rDebug.setText("0");
            gDebug.setText("0");
            bDebug.setText("0");
            brValue = 1000;
            bright.setText(Integer.toString(brValue));
        } catch (Exception e) {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
        }

    }

    public void blinkLed(View view) {

        try {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server("LED", this);
        } catch (Exception e) {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
        }
    }
/*    public void rainBow(View view) {
        EditText cepaT = (EditText) findViewById(R.id.editTime);
        cepat = cepaT.getText().toString();

        bright.setText(cepat);

        try {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server("t"+cepat, mainActivityView);
        } catch (Exception e) {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
        }

        try {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server("RAINBOW", mainActivityView);
        } catch (Exception e) {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
        }

    }
*/
    public void setColor(View view){

        switch (view.getId()) {

            case R.id.red01:
                xValue = 256;
                yValue = 0;
                zValue = 0;
                triColorupdate();
                break;

            case R.id.red02:
                xValue = 252;
                yValue = 40;
                zValue = 0;
                triColorupdate();
                break;

            case R.id.red03:
                xValue = 256;
                yValue = 72;
                zValue = 0;
                triColorupdate();
                break;

            case R.id.red04:
                xValue = 248;
                yValue = 160;
                zValue = 0;
                triColorupdate();
                break;

            case R.id.red05:
                xValue = 248;
                yValue = 248;
                zValue = 0;
                triColorupdate();
                break;

            case R.id.green01:
                xValue = 0;
                yValue = 176;
                zValue = 0;
                triColorupdate();
                break;

            case R.id.green02:
                xValue = 16;
                yValue = 192;
                zValue = 16;
                triColorupdate();
                break;

            case R.id.green03:
                xValue = 0;
                yValue = 144;
                zValue = 144;
                triColorupdate();
                break;

            case R.id.green04:
                xValue = 0;
                yValue = 128;
                zValue = 0;
                triColorupdate();
                break;

            case R.id.green05:
                xValue = 0;
                yValue = 48;
                zValue = 0;
                triColorupdate();
                break;

            case R.id.blue01:
                xValue = 0;
                yValue = 0;
                zValue = 90;
                triColorupdate();
                break;

            case R.id.blue02:
                xValue = 0;
                yValue = 0;
                zValue = 256;
                triColorupdate();
                break;

            case R.id.blue03:
                xValue = 90;
                yValue = 90;
                zValue = 256;
                triColorupdate();
                break;

            case R.id.blue04:
                xValue = 0;
                yValue = 90;
                zValue = 90;
                triColorupdate();
                break;

            case R.id.blue05:
                xValue = 128;
                yValue = 0;
                zValue = 90;
                triColorupdate();
                break;

            case R.id.white01:
                xValue = 256;
                yValue = 256;
                zValue = 256;
                triColorupdate();
                break;

            case R.id.white02:
                xValue = 256;
                yValue = 128;
                zValue = 128;
                triColorupdate();
                break;

            case R.id.white03:
                xValue = 256;
                yValue = 90;
                zValue = 90;
                triColorupdate();
                break;

            case R.id.white04:
                xValue = 128;
                yValue = 128;
                zValue = 256;
                triColorupdate();
                break;

            case R.id.white05:
                xValue = 32;
                yValue = 32;
                zValue = 128;
                triColorupdate();
                break;

            case R.id.rplus:
                xValue = xValue+16;
                if (xValue>=256)
                {
                    xValue=256;
                }
                updateRed(xValue);
                break;

            case R.id.gplus:
                yValue = yValue+16;
                if (yValue>=256)
                {
                    yValue=256;
                }
                updateGreen(yValue);
                break;

            case R.id.bplus:
                zValue = zValue+16;
                if (zValue>=256)
                {
                    zValue=256;
                }
                updateBlue(zValue);
                break;

            case R.id.rminus:
                xValue = xValue-16;
                if (xValue<=0)
                {
                    xValue=0;
                }
                updateRed(xValue);
                break;

            case R.id.gminus:
                yValue = yValue-16;
                if (yValue<=0)
                {
                    yValue=0;
                }
                updateGreen(yValue);
                break;

            case R.id.bminus:
                zValue = zValue-16;
                if (zValue<=0)
                {
                    zValue=0;
                }
                updateBlue(zValue);
                break;
        }
        brValue = 1000;
    }

    public void brightness(View view)
    {
        switch (view.getId())
        {
            case R.id.brightUp:
               brValue = brValue+125;
                if (brValue>=1000)
                {
                    brValue=1000;
                }
                triColorupdate();
                break;

            case R.id.brightDown:
                brValue = brValue-125;
                if (brValue<=0)
                {
                    brValue=0;
                }
                triColorupdate();
                break;
        }
    }

    public void updateRed (int xValue)
    {
        String tempX;
        tempString = String.valueOf(xValue*brValue/1000);
        tempX = "x" + tempString;
        try
        {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server(tempX, this);
            rDebug.setText(Integer.toString(xValue));
        }
        catch (Exception e)
        {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
            rDebug.setText("ERROR SENDING");
        }
    }
    public void updateGreen (int  yValue)
    {
        String tempY;

        tempString = String.valueOf(yValue*brValue/1000);
        tempY = "y" + tempString;

        try
        {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server(tempY, this);
            gDebug.setText(Integer.toString(yValue));
        }
        catch (Exception e)
        {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
            gDebug.setText("ERROR SENDING");
        }
    }
    public void updateBlue (int zValue)
    {
        String tempZ;

        tempString = String.valueOf(zValue*brValue/1000);
        tempZ = "z" + tempString;

        try
        {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server(tempZ, this);
            bDebug.setText(Integer.toString(zValue));
        }
        catch (Exception e)
        {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
            bDebug.setText("ERROR SENDING");
        }
    }
    public void triColorupdate ()
    {
        updateRed(xValue);
        updateGreen(yValue);
        updateBlue(zValue);
    }

    public void updateViewReceiver(String s){
        final TextView receiver;
        receiver = (TextView) findViewById(R.id.receiveText);
        receiver.setText(s);
    }
}