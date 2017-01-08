package com.projects.jeriko.projectleds;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by LENOVO on 1/8/2017.
 */

public class SendData extends AsyncTask<String, Void, String> {
    Context mContext;
    TextView textDebug;
    String tempString;

    public SendData(Context context, TextView textDebugView) {
        mContext = context;
        textDebug = textDebugView;
    }

    protected String doInBackground(String... params) {
        try {
            tempString = "RESET";
            Socket socket = new Socket("10.0.0.10", 81);
            //OutputStream DOS = socket.getOutputStream();
            DataOutputStream DOS = new DataOutputStream(socket.getOutputStream());

            DOS.writeUTF(tempString);

            DOS.flush();
            DOS.close();

            //DOS.writeUTF(tempString);

            socket.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
            tempString = "UnknownHostException";

        } catch (IOException ie) {
            ie.printStackTrace();
            tempString = "IOException";
        }
        return tempString;
    }

    protected void onPostExecute(String result) {
        textDebug.setText(result);
        //TextView txt = (TextView) findViewById(R.id.output);
        //txt.setText("Executed"); // txt.setText(result);

        // might want to change "executed" for the returned string passed
        // into onPostExecute() but that is upto you
    }

    protected void onPreExecute() {}

    protected void onProgressUpdate(Void... values) {}
}
