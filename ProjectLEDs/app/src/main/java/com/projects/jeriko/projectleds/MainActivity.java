package com.projects.jeriko.projectleds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendData(View view) {
        TextView textDebug = (TextView) findViewById(R.id.text01);
        SendData sender = new SendData(this, textDebug);
        sender.execute();
            /*
            try {
                Socket socket = new Socket("10.0.0.10", 81);
                //OutputStream DOS = socket.getOutputStream();
                DataOutputStream DOS = new DataOutputStream(socket.getOutputStream());
                DOS.flush();
                DOS.close();
                DOS.writeUTF("x1");
                socket.close();
                textDebug.setText("x1");
            } catch (IOException ie) {
                ie.printStackTrace();
                textDebug.setText("failed");
            }
            */
    }
}
