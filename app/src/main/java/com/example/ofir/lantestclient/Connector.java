package com.example.ofir.lantestclient;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by ofir on 3/28/2018.
 */

public class Connector extends AsyncTask<String, Void, String>
{
    @Override
    protected String doInBackground(String... strings)
    {
        try
        {
//            InetAddress inet = InetAddress.getByName(strings[0]);
            InetAddress inet = InetAddress.getByName("192.168.1.106");
            Socket socket = new Socket(inet, 9153);
            DataOutputStream DOS = new DataOutputStream(socket.getOutputStream());
            DOS.writeUTF("Hi my name is " + strings[1]);
            socket.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return strings[0];
    }

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
    }
}
