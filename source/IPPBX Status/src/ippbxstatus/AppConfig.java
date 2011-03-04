/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ippbxstatus;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author M. Fauzilkamil Zainuddin <jerungkun@gmail.com>
 * 
 */
public class AppConfig {


    private boolean bDebug = false;
    private String ConfigFile = "ippbxstatus.conf";


    public String IPPBXServerIP = "";
    public String Username = "admin";
    public String Password = "ultratone";
    public String Extension = "";
    public String ExtPassword = "";
    public boolean EnableLogin = true;
    public boolean LoggedIn = false;

    public boolean ReadConfig() throws FileNotFoundException, IOException {
        boolean bSuccess = false;

        showDebug("Reading Config File!");
        
        // open config file if exists
        Properties prop = new Properties();

        try {
            InputStream is;
            is = new FileInputStream(ConfigFile);
            // read config file
            prop.load(is);

            this.EnableLogin = Boolean.parseBoolean(prop.getProperty("enableLogin"));
            this.ExtPassword = prop.getProperty("extpass");
            this.Extension = prop.getProperty("ext");
            this.Password = prop.getProperty("password");
            this.Username = prop.getProperty("user");
            this.IPPBXServerIP = prop.getProperty("server");


        } catch (FileNotFoundException ex)  {
            showDebug("Config Not Exists!");
            // create config file
            prop.setProperty("server", IPPBXServerIP.toString());
            prop.setProperty("user", Username.toString());
            prop.setProperty("password", Password.toString());
            prop.setProperty("ext", Extension.toString());
            prop.setProperty("extpass", ExtPassword.toString());
            prop.setProperty("enableLogin", Boolean.toString(EnableLogin));

            FileOutputStream fos = new FileOutputStream(ConfigFile);

            prop.store(fos, "Ultratone IPPBX");
        }

        return true;
    }

    public void showDebug(String dbgMessage) {
        if (bDebug == false) return;
        javax.swing.JOptionPane.showMessageDialog(null, "DEBUG: " + dbgMessage );
    }

    public void UpdateConfig() {
        Properties prop = new Properties();

        showDebug(this.Password.toString());

        prop.setProperty("server", this.IPPBXServerIP.toString());
        prop.setProperty("user", this.Username.toString());
        prop.setProperty("password", this.Password.toString());
        prop.setProperty("ext", this.Extension.toString());
        prop.setProperty("extpass", this.ExtPassword.toString());
        prop.setProperty("enableLogin", Boolean.toString(EnableLogin));

        FileOutputStream fos;
        try {
            fos = new FileOutputStream(ConfigFile);
            try {
                prop.store(fos, "Ultratone IPPBX");
            } catch (IOException ex) {
                Logger.getLogger(AppConfig.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppConfig.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
         
}
