package com.projects.jeriko.projectleds;

import android.util.Log;
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

    public void connect_to_server(String inputColor, TextView messageDisplayer) {
        final String color;
        final TextView localMessageDisplayer;
        color = inputColor;
        localMessageDisplayer = messageDisplayer;

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
                localMessageDisplayer.setText(message);
                try {
                    mWebSocketClient.close();
                } catch (Exception e) {
                    localMessageDisplayer.setText(e.toString());
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
