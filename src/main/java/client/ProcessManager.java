package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessManager {
    private static final String TASKLIST = "tasklist";
    private static final String KILL = "taskkill /F /PID ";

    public BufferedReader listProcess () throws IOException {
        Process process = Runtime.getRuntime().exec(TASKLIST);
        BufferedReader listProcess = new BufferedReader(new InputStreamReader(process.getInputStream()));
        return listProcess;
    }

    public void killProcess(int PID) throws Exception {
        Runtime.getRuntime().exec("taskkill /F /PID " + PID);
    }
    
    public void shutdown () throws IOException{
        Runtime.getRuntime().exec("shutdown -s -t 0");
    }

    /*public static void main (String[] args) throws Exception{
        //killProcess(14768);
    }*/
}