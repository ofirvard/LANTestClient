package com.example.ofir.lantestclient;

import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Client extends AppCompatActivity
{
    TextView ip;
    EditText room;
    String myIP;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        room = findViewById(R.id.room);
        ip = findViewById(R.id.ip);
        myIP = getIpAddress();
        String text = "Your IPv4: " + myIP;
        ip.setText(text);
    }

    public String getIpAddress()
    {
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
        return String.format("%d.%d.%d.%d", (ipAddress & 0xff), (ipAddress >> 8 & 0xff),
                (ipAddress >> 16 & 0xff), (ipAddress >> 24 & 0xff));

    }

    public void connect(View view)
    {
        String hex = room.getText().toString();
        if (hex.length() == 8)
        {
            String roomIP = "";
            for (int i = 0; i < hex.length(); i = i + 2)
            {
                roomIP = roomIP + Integer.valueOf(hex.substring(i, i + 2), 16) + ".";
            }
            String text = "Your IPv4: " + myIP + "\nRoom IP: " + roomIP;
            ip.setText(text);

            Connector connector = new Connector();
            connector.execute(roomIP);
        }
    }
}
