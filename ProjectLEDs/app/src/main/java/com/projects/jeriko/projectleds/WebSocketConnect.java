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

    public void connect_to_server(String inputColor, final MainActivity mainClass) {
        final String color;

        color = inputColor;

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
            }

            @Override
            public void onMessage(String s) {
                Log.i("Websocket", "onMessage" + s);
                mainClass.updateViewReceiver(s);

                try {
                    mWebSocketClient.close();
                } catch (Exception e) {
                    mainClass.updateViewReceiver(s);
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
