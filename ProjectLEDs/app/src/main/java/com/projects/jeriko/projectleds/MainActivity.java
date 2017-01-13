package com.projects.jeriko.projectleds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

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

    public void xVal(View view) {
        TextView textDebug = (TextView) findViewById(R.id.text01);

        try {
            XValue ws = new XValue();
            ws.connect_to_server();
        } catch (Exception e) {
            textDebug.setText("WebSocketConnect failed");
            e.printStackTrace();
        }
    }

    public void yVal(View view) {
        TextView textDebug = (TextView) findViewById(R.id.text01);
        try {
            YValue ws = new YValue();
            ws.connect_to_server();
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
}
