/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ippbxtools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author apogee
 */
public class IPPBXRequest {
    private AppConfig m_cConf;
    private String m_sSavedCookie;
    private boolean DebugEnable = false;

    public IPPBXRequest(AppConfig conf) {
        m_cConf = conf;
    }

    public void AppendStatus(String sData) {
        if (DebugEnable) {
            System.out.print(sData + "\n");
        }
    }

    public void RequestLogout() {
        // login/logout
        String sURL = "http://" + m_cConf.IPPBXServerIP + "/rawman?action=login&username="
                    + m_cConf.Username + "&secret=" + m_cConf.Password;
        String sUTF = "UTF-8";

        if ((m_cConf.IPPBXServerIP == null ? "" == null : m_cConf.IPPBXServerIP.equals("")) || (m_cConf.Username == null ? "" == null : m_cConf.Username.equals(""))) {
            return;
        }

        // construct data
        String sData = null;
        try {

            sData = "?action=login&username=" + URLEncoder.encode(m_cConf.Username,sUTF);
            sData += "&secret=" + URLEncoder.encode(m_cConf.Password, sUTF);

            AppendStatus(sData);

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(IPPBXRequest.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* send data */
        try {
            URL url = new URL("http://" + m_cConf.IPPBXServerIP + "/rawman" + sData);
            try {
                URLConnection conn = url.openConnection();

                // get the response
                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                int j=0;
                boolean bSuccess = false;
                while ((line = rd.readLine()) != null) {
                    j++;
                    AppendStatus(j + ": " + line);
                    if (Pattern.matches("^Response: Success", line)) {
                        AppendStatus("Success");
                    } else if (Pattern.matches("^Message: Authentication accepted", line)) {
                        AppendStatus("Authentication accepted");

                        bSuccess = true;
                    }
                }
                rd.close();
                String headerName=null;
                for (int i=1; (headerName = conn.getHeaderFieldKey(i))!=null; i++) {
                    if (headerName.equals("Set-Cookie")) {
                        String cookie = conn.getHeaderField(i);
                        AppendStatus("Set-Cookie: " + cookie);

                        if (bSuccess == true) {
                            // save the cookie
                            this.SaveCookie(cookie);
                        }

                    } else {
                        AppendStatus("h: " + headerName + " f: " + conn.getHeaderField(i));
                    }
                }

                // Logout Agent
                this.LogoutAgent();


            } catch (IOException ex) {
                Logger.getLogger(IPPBXRequest.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(IPPBXRequest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void SaveCookie(String cookie) {
        /* set the cookie
         * mansession_id="7caece15"; username="+ m_cConf.Username +"; rwaccess=yes
         */
        String mansession_id = cookie.substring(0, cookie.indexOf(";"));
        this.m_sSavedCookie = mansession_id + "; username=" + m_cConf.Username + "; rwaccess=yes";
    }

        private void LogoutAgent() {
        /*
         * to logout agent
         * http://xx.xx.xx.xx/rawman?action=AgentLogoff&Agent=101&Soft=true
         *
         * Response: Success
         * Message: Agent logged out
         *
         */
        String sUTF = "UTF-8";
        String sData = "?action=AgentLogoff&Agent=" + m_cConf.Extension + "&Soft=true";
        try {
            URL url = new URL("http://" + m_cConf.IPPBXServerIP + "/rawman" + sData);
            try {
                URLConnection conn = url.openConnection();
                conn.setRequestProperty("Cookie", m_sSavedCookie);

                // get the response
                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                int j=0;
                boolean bSuccess = false;
                boolean bFound = false;
                String sLoginStatus = "";
                while ((line = rd.readLine()) != null) {
                    j++;
                    //m_fLog.AppendStatus(j + ": " + line);
                    if (Pattern.matches("^Response: Success", line)) {
                        AppendStatus("Log off Success");
                        bSuccess = true;
                        //m_cConf.LoggedIn = false;
                    }
                }
                rd.close();
            } catch (IOException ex) {
                Logger.getLogger(IPPBXRequest.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(IPPBXRequest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
