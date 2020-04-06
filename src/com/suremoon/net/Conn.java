package com.suremoon.net;

import java.io.*;
import java.net.Socket;


//a class to suit go's code.
public abstract class Conn {
    private Socket socket;
    private InputStream is;
    private OutputStream os;

    public Conn(Socket socket) throws IOException {
        this.socket = socket;
        this.is = new DataInputStream(socket.getInputStream());
        this.os = new DataOutputStream(socket.getOutputStream());
    }
    public Socket getSocket() {
        return socket;
    }

    public byte[] readBytes() throws IOException {
        byte[] get = new byte[4];
        is.read(get, 0, 4);
        int length = CJDeal.byte2int(get);
        get= new byte[length];
        is.read(get, 0, length);
        return  get;
    }

    public void writeBytes(byte[] msg) throws  IOException{
        os.write(CJDeal.int2byte(msg.length));
        os.write(msg, 0, msg.length);
    }
}
