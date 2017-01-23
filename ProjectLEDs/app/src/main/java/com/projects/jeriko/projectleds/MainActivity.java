package com.projects.jeriko.projectleds;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int xValue;
    int yValue;
    int zValue;

    private TextView bright;
    private TextView textDebug;
    private TextView rDebug;
    private TextView gDebug;
    private TextView bDebug;

    private View mainActivityView;

    /*
    TextView bright = (TextView) findViewById(R.id.brtext);
    TextView textDebug = (TextView) findViewById(R.id.text01);
    TextView rDebug = (TextView) findViewById(R.id.text02);
    TextView gDebug = (TextView) findViewById(R.id.text03);
    TextView bDebug = (TextView) findViewById(R.id.text04);
    */

    int brValue = 100;
    String cepat;

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
    }

    public void resetData(View view) {

        try {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server("RESET", mainActivityView);
            rDebug.setText("0");
            gDebug.setText("0");
            bDebug.setText("0");
            brValue = 100;
            bright.setText(Integer.toString(brValue));
        } catch (Exception e) {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
        }

    }

    public void blinkLed(View view) {

        try {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server("LED", mainActivityView);
        } catch (Exception e) {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
        }
    }

    public void rainBow(View view) {
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

            case R.id.blue01:
                xValue = 0x00;
                yValue = 0x00;
                zValue = 0x50;
                parseit(xValue,yValue,zValue);
                break;
            case R.id.blue02:
                xValue = 0x00;
                yValue = 0x00;
                zValue = 0xff;
                parseit(xValue,yValue,zValue);
                break;

            case R.id.blue03:
                xValue = 0x50;
                yValue = 0x50;
                zValue = 0xff;
                parseit(xValue,yValue,zValue);
                break;

            case R.id.blue04:
                xValue = 0x00;
                yValue = 0x50;
                zValue = 0x50;
                parseit(xValue,yValue,zValue);
                break;

            case R.id.blue05:
                xValue = 0x80;
                yValue = 0x00;
                zValue = 0x50;
                parseit(xValue,yValue,zValue);
                break;

            case R.id.white01:
                xValue = 0xff;
                yValue = 0xff;
                zValue = 0xff;
                parseit(xValue,yValue,zValue);
                break;
            case R.id.white02:
                xValue = 0xff;
                yValue = 0x80;
                zValue = 0x80;
                parseit(xValue,yValue,zValue);
                break;
            case R.id.white03:
                xValue = 0xff;
                yValue = 0x50;
                zValue = 0x50;
                parseit(xValue,yValue,zValue);
                break;
            case R.id.white04:
                xValue = 0x80;
                yValue = 0x80;
                zValue = 0xff;
                parseit(xValue,yValue,zValue);
                break;
            case R.id.white05:
                xValue = 0x20;
                yValue = 0x20;
                zValue = 0x80;
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

    public void brightness(View view)
    {
        switch (view.getId())
        {
            case R.id.brightUp:
               brValue = brValue+50;
                if (brValue>=100)
                {
                    brValue=100;
                }
                parseit(xValue,yValue,zValue);
             break;
            case R.id.brightDown:
                brValue = brValue-50;
                if (brValue<=00)
                {
                    brValue=00;
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

        tempString = String.valueOf(xValue*brValue/100);
        tempX = "x" + tempString;
        tempString = String.valueOf(yValue*brValue/100);
        tempY = "y" + tempString;
        tempString = String.valueOf(zValue*brValue/100);
        tempZ = "z" + tempString;
        try
        {
            WebSocketConnect ws = new WebSocketConnect();
            ws.connect_to_server(tempX, mainActivityView);
            textDebug.setText("Success");
            rDebug.setText(Integer.toString(xValue));
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
            ws.connect_to_server(tempY, mainActivityView);
            textDebug.setText("Success");
            gDebug.setText(Integer.toString(yValue));
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
            ws.connect_to_server(tempZ, mainActivityView);
            textDebug.setText("Success");
            bDebug.setText(Integer.toString(zValue));
        }
        catch (Exception e)
        {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
            bDebug.setText("ERROR SENDING");
        }

    }

}
