/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ippbxtools;

import java.io.IOException;

/**
 * @author apogee
 */
public class Main {

    private static boolean DebugEnable = false;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        AppConfig ac = new AppConfig();


        if (ac.ReadConfig() == true) {
            IPPBXRequest ipr = new IPPBXRequest(ac);
            AppendStatus("Config found, " + ac.IPPBXServerIP + "\n");
            ipr.RequestLogout();
            
        } else {
            AppendStatus("error reading config file\n");
        }
    }

    private static void AppendStatus(String sData) {
        if (DebugEnable) {
            System.out.print(sData + "\n");
        }
    }

}
