/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ippbxtools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apogee
 */
public class AppConfig {
    private String ConfigFile = "ippbxstatus.conf";

    public String IPPBXServerIP = "";
    public String Username = "admin";
    public String Password = "ultratone";
    public String Extension = "";
    public String ExtPassword = "";
    public boolean EnableLogin = true;


    public boolean ReadConfig() throws IOException {
        // open config file if exists

        Properties prop = new Properties();


        try {
            InputStream is;

            is = new FileInputStream(this.ConfigFile);

                        // read config file
            prop.load(is);

            this.EnableLogin = Boolean.parseBoolean(prop.getProperty("enableLogin"));
            this.ExtPassword = prop.getProperty("extpass");
            this.Extension = prop.getProperty("ext");
            this.Password = prop.getProperty("password");
            this.Username = prop.getProperty("user");
            this.IPPBXServerIP = prop.getProperty("server");


        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppConfig.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
            

        return true;

    }

}
