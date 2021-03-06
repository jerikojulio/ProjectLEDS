package com.projects.jeriko.projectleds;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.ParseException;

/**
 * Created by LENOVO on 1/8/2017.
 */

public class ResetData extends AsyncTask<String, Void, String> {
    Context mContext;
    TextView textDebug;
    String tempString;

    public ResetData(Context context, TextView textDebugView) {
        mContext = context;
        textDebug = textDebugView;
    }

    protected String doInBackground(String... params) {
        Socket socket = null;
        DataOutputStream DOS = null;
        try {
            tempString = "RESET";
            socket = new Socket("10.0.0.10", 81);
            DOS = new DataOutputStream(socket.getOutputStream());

            DOS.writeUTF(tempString);
            DOS.flush();
            //DOS.close();
            //socket.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
            tempString = "UnknownHostException";

        } catch (IOException ie) {
            ie.printStackTrace();
            tempString = "IOException";

        } finally {
            if (DOS != null && socket != null) {
                try {
                    DOS.close();
                    socket.close();
                } catch (IOException ie) {
                    ie.printStackTrace();
                    tempString = "IOException";

                }
            }
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

    protected void onPreExecute() {
    }

    protected void onProgressUpdate(Void... values) {
    }
}
