package com.example.registro;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

public class Studente {
    private String username;
    private HashMap<String, Voto> voti;
    private ArrayList<Assenze> assenze;
    private String password;
    private Socket socket = new Socket("127.0.0.1", 50007);
    private DataOutputStream out = new DataOutputStream (socket.getOutputStream());
    private int media;


    public Studente(String username, String password) throws IOException{
        this.username = username;
        this.password = password;

        try {
            out.writeUTF(username);
            out.flush();
            out.writeUTF(password);
            out.flush();
            //out.println(this.password);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        try {
//            startTcp(this.username, this.password);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        this.loadRegistro();
        out.close();
        socket.close();
    }
    private void loadRegistro () {
        String asse = "";
        try {
            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String vot = "";

            int length = in.readInt();
            System.out.println(length);

            byte[] messageByte = new byte[length];
            boolean end = false;
            StringBuilder dataString = new StringBuilder(length);
            int totalBytesRead = 0;
            while(!end) {
                int currentBytesRead = in.read(messageByte);
                totalBytesRead = currentBytesRead + totalBytesRead;
                if(totalBytesRead <= length) {
                    dataString.append(new String(messageByte, 0, currentBytesRead, StandardCharsets.UTF_8));
                } else {
                    dataString.append(new String(messageByte, 0, length - totalBytesRead + currentBytesRead,
                                    StandardCharsets.UTF_8));
                }
                if(dataString.length()>=length) {
                    end = true;
                }
            }

            vot = new String(dataString);
            System.out.println(vot);
            getVoti(vot);


            length = in.readInt();
            messageByte = new byte[length];
            end = false;
            System.out.println(length);
            dataString = new StringBuilder(length);
            totalBytesRead = 0;
            while(!end) {
                int currentBytesRead = in.read(messageByte);
                totalBytesRead = currentBytesRead + totalBytesRead;
                if(totalBytesRead <= length) {
                    dataString.append(new String(messageByte, 0, currentBytesRead, StandardCharsets.UTF_8));
                } else {
                    try {
                        dataString.append(new String(messageByte, 0, length - totalBytesRead + currentBytesRead,
                                StandardCharsets.UTF_8));
                    }catch (Exception e){
                        System.out.println("errore");
                    }
                }
                if(dataString.length()>=length) {
                    end = true;
                }
            }


            asse = new String(dataString);
            System.out.println(asse);
            assenze = getAssenze(asse);
            System.out.println("Assenze: " + assenze);
//                out.writeUTF("chiudi");
//                out.flush();



        }catch (EOFException e){
            System.out.println(asse);
            System.out.println("Esticazzi");
            assenze = getAssenze(asse);
            System.out.println("Assenze: " + assenze);
        }catch (IOException ee){
            System.out.println("Sticazzi pt2");
        }
    }

    private static HashMap<String, Voto> getVoti (String s){
        return null;
    }
    private static ArrayList<Assenze> getAssenze(String s){
        int p = 0;
        ArrayList<Assenze> al = new ArrayList<>();
        String[] t = new String[100000];
        t = s.split(";");
        for (int i = 0; i < (t.length)-3; i+=3) {
            al.add(new Assenze (t[i], Boolean.getBoolean(t[i+1]), t[i+2]));
        }
        return al;
    }
}
