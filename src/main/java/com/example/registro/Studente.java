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
    private int media;



    public Studente(String username, String password) throws IOException{
        this.username = username;
        this.password = password;

        DataOutputStream out = new DataOutputStream (socket.getOutputStream());

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
    }
    private void loadRegistro () {
        String asse = "";
        try {
            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String vot = "";

            vot = in.readUTF();
            System.out.println(vot);
            getVoti(vot);

            asse = in.readUTF();

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
