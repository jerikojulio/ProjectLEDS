package com.projects.jeriko.projectleds;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LENOVO on 1/12/2017.
 */

public class WebSocketConnect {

    private WebSocketClient mWebSocketClient;

    public void connect_to_server(String inputColor, View messageDisplayer) {
        final String color;
        final View localMessageDisplayer;
        final TextView xSend;
        final TextView receiver;
        color = inputColor;
        localMessageDisplayer = messageDisplayer;

        xSend = (TextView) localMessageDisplayer.findViewById(R.id.text02);
        receiver = (TextView) localMessageDisplayer.findViewById(R.id.receiveText);

        URI uri;
        try {
            uri = new URI("http://10.0.0.10:81/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        Map<String, String> headers = new HashMap<>();

        mWebSocketClient = new WebSocketClient(uri, new Draft_17(), headers, 0) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                Log.i("Websocket", "Opened");
                mWebSocketClient.send(color);
                // mWebSocketClient.close();
            }

            @Override
            public void onMessage(String s) {
                final String message = s;
                Log.i("Websocket", "onMessage" + s);
                receiver.setText(s);
                try {
                    mWebSocketClient.close();
                } catch (Exception e) {
                    receiver.setText(s);
                }
            }

            @Override
            public void onClose(int code, String s, boolean b) {
                Log.i("Websocket", code + ": Closed " + s);
            }

            @Override
            public void onError(Exception e) {
                Log.i("Websocket", "Error " + e.getMessage());
            }
        };
        mWebSocketClient.connect();
    }
}
