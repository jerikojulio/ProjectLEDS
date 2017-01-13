package com.projects.jeriko.projectleds;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

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
}
