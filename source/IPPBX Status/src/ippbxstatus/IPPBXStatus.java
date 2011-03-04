/*
 * IPPBXStatus.java
 * Created on Feb 28, 2011, 1:30:36 PM
 *
 */
package ippbxstatus;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author M. Fauzilkamil Zainuddin <jerungkun@gmail.com>
 *
 */
public class IPPBXStatus extends javax.swing.JFrame {

    /** Creates new form IPPBXStatus */
    public IPPBXStatus() {

        try {
            if (System.getProperty("os.name").equals("Linux")) {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            } else if (System.getProperty("os.name").equals("Windows 7")) {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IPPBXStatus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(IPPBXStatus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(IPPBXStatus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(IPPBXStatus.class.getName()).log(Level.SEVERE, null, ex);
        }

        initComponents();
        appConf = new ippbxstatus.AppConfig();
        try {
            appConf.ReadConfig();
            this.txtIPPBXAddress.setText(appConf.IPPBXServerIP);
            this.txtUsername.setText(appConf.Username);
            this.txtPassword.setText(appConf.Password);
            this.txtExtension.setText(appConf.Extension);
            this.txtExtPassword.setText(appConf.ExtPassword);
            this.chkEnableLogin.setSelected(appConf.EnableLogin);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(IPPBXStatus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IPPBXStatus.class.getName()).log(Level.SEVERE, null, ex);
        }

        SetSystemTray();

        

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIPPBXAddress = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtExtension = new javax.swing.JTextField();
        txtExtPassword = new javax.swing.JPasswordField();
        chkEnableLogin = new javax.swing.JCheckBox();
        btnSave = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        lblServer = new javax.swing.JLabel();
        lblLoginStatus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLoginStatus = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        mnuMain = new javax.swing.JMenuBar();
        mnuApp = new javax.swing.JMenu();
        mnuShowLog = new javax.swing.JMenuItem();
        mnuSave = new javax.swing.JMenuItem();
        mnuSep1 = new javax.swing.JPopupMenu.Separator();
        mnuExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ultratone IPPBX Status");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ultratone IPPBX Status"));

        jLabel1.setText("IPPBX IP Address:");

        jLabel2.setText("Username:");

        jLabel3.setText("Password:");

        jLabel4.setText("Extension:");

        jLabel5.setText("Extension Password:");

        txtIPPBXAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIPPBXAddressActionPerformed(evt);
            }
        });

        txtUsername.setText("admin");
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        txtPassword.setText("ultratone");

        chkEnableLogin.setSelected(true);
        chkEnableLogin.setText("Enable Login");
        chkEnableLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEnableLoginActionPerformed(evt);
            }
        });

        btnSave.setText("Save Settings");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnLogin.setText("Login/Logout");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblServer.setText("Server:");

        lblLoginStatus.setText("Login Status:");

        txtLoginStatus.setEditable(false);
        txtLoginStatus.setText("Agent: \nName: \nStatus: \nLoggedInChan: \nLoggedInTime: \nTalkingTo: ");
        jScrollPane1.setViewportView(txtLoginStatus);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(lblLoginStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtExtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(txtExtension, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(txtIPPBXAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)))
                    .addComponent(chkEnableLogin, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblServer, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIPPBXAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtExtension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtExtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkEnableLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblServer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLoginStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ippbxstatus/ippbxstatus.png"))); // NOI18N

        mnuApp.setText("Application");

        mnuShowLog.setText("Show Status Log");
        mnuShowLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuShowLogActionPerformed(evt);
            }
        });
        mnuApp.add(mnuShowLog);

        mnuSave.setText("Save Settings");
        mnuSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSaveActionPerformed(evt);
            }
        });
        mnuApp.add(mnuSave);

        mnuSep1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mnuSep1.setForeground(new java.awt.Color(1, 1, 1));
        mnuApp.add(mnuSep1);

        mnuExit.setText("Exit");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        mnuApp.add(mnuExit);

        mnuMain.add(mnuApp);

        setJMenuBar(mnuMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIPPBXAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIPPBXAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIPPBXAddressActionPerformed

    private void chkEnableLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEnableLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkEnableLoginActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void SaveSettings() {
        this.appConf.IPPBXServerIP = txtIPPBXAddress.getText();
        this.appConf.Username = txtUsername.getText();

        this.appConf.Password = String.valueOf(txtPassword.getPassword());
        this.appConf.Extension = txtExtension.getText();
        this.appConf.ExtPassword = String.valueOf(txtExtPassword.getPassword());
        this.appConf.EnableLogin = chkEnableLogin.isSelected();

        this.appConf.UpdateConfig();

    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        this.SaveSettings();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        /*
         * to login and query using curl...
         * curl http://10.1.3.75/rawman?action=login\&username=admin\&secret=password
         * get the cookie!
         * then request to login agent...
         * curl http://10.1.3.75/rawman?action=AgentCallbackLogin&Agent=101&Exten=101
         * or request to logout agent...
         * /rawman?action=AgentLogoff&Agent=101&Soft=true
         * curl http://10.1.3.75/rawman?action=AgentLogoff\&Agent=101\&soft=true
         */
        //JOptionPane.showMessageDialog(rootPane, "unfinished code!");
        //iLastID++;
        //String sID = "tid" + iLastID;
        if (appConf.LoggedIn == false) {
            this.RequestLogin(true);
        } else {
            this.RequestLogin(false);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void mnuShowLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuShowLogActionPerformed
        // TODO add your handling code here:
        frmLog.setVisible(true);
    }//GEN-LAST:event_mnuShowLogActionPerformed

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mnuExitActionPerformed

    private void mnuSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSaveActionPerformed
        // TODO add your handling code here:
        this.SaveSettings();
    }//GEN-LAST:event_mnuSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmLog = new StatusLog();
                frmMain = new IPPBXStatus();

                // place the window in the middle of the screen
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                int h = frmMain.getHeight();
                int w = frmMain.getWidth();
                int x = (int) (dim.getWidth() - w) / 2;
                int y = (int) (dim.getHeight() - h) / 2;
                frmMain.setLocation(x, y);
                ImageIcon ic = new ImageIcon(getClass().getResource("icon.png"));
                java.awt.Image im = ic.getImage();
                frmMain.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frmMain.setIconImage(im);
                frmMain.setVisible(true);

                frmLog.setIconImage(im);
                frmLog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                x = (int) (dim.getWidth() - frmLog.getWidth()) / 2;
                y = (int) (dim.getHeight() - frmLog.getHeight()) / 2;
                frmLog.setLocation(x, y);
                //tSimple1 = new SimpleThread("Simple1", frmLog);
                //tSimple2 = new SimpleThread("Simple2", frmLog);

                if (appConf.EnableLogin == true) {
                    frmMain.RequestLogin(true);
                }

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox chkEnableLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLoginStatus;
    private javax.swing.JLabel lblServer;
    private javax.swing.JMenu mnuApp;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenuBar mnuMain;
    private javax.swing.JMenuItem mnuSave;
    private javax.swing.JPopupMenu.Separator mnuSep1;
    private javax.swing.JMenuItem mnuShowLog;
    private javax.swing.JPasswordField txtExtPassword;
    private javax.swing.JTextField txtExtension;
    private javax.swing.JTextField txtIPPBXAddress;
    private javax.swing.JTextPane txtLoginStatus;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
    private static AppConfig appConf;
    private static IPPBXStatus frmMain;
    private static java.awt.TrayIcon trayIcon;
    public static StatusLog frmLog;
    private int iLastID;
    //private static SimpleThread tSimple1;
    //private static SimpleThread tSimple2;


    private void SetSystemTray() {
        // adding the app to system tray
        if (!java.awt.SystemTray.isSupported()) {
            appConf.showDebug("SystemTray is not supported");
            return;
        }

        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {

        final java.awt.PopupMenu popup = new java.awt.PopupMenu();
        trayIcon = new java.awt.TrayIcon(createImage("icon.png", "Ultratone IPPBX Status"));
        final java.awt.SystemTray tray = java.awt.SystemTray.getSystemTray();

        // Create a popup menu components
        java.awt.MenuItem mnuSettings = new java.awt.MenuItem("Settings");
        java.awt.MenuItem exitItem = new java.awt.MenuItem("Exit");

        //Add components to popup menu
        popup.add(mnuSettings);
        popup.addSeparator();
        popup.add(exitItem);

        trayIcon.setPopupMenu(popup);
        trayIcon.setImageAutoSize(true);

        try {
            tray.add(trayIcon);
        } catch (java.awt.AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }

        mnuSettings.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
                frmMain.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        trayIcon.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent e) {
                /* show main form */
                frmMain.setVisible(true);
            }
        });


        exitItem.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });

        trayIcon.displayMessage("Ultratone IPPBX Status",
                "IPPBX Status logger", java.awt.TrayIcon.MessageType.INFO);
    }

    //Obtain the image URL
    protected static java.awt.Image createImage(String path, String description) {
        java.net.URL imageURL = IPPBXStatus.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new javax.swing.ImageIcon(imageURL, description)).getImage();
        }
    }

    /* HTTP Request to Login */
    private void RequestLogin(boolean bLogin) {
        // request using new thread
        /*
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                //JOptionPane.showMessageDialog(rootPane, "thread testing!");
                for (int i = 0;i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                        frmLog.AppendStatus("thread sending message id: " + sId);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(IPPBXStatus.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
         */
        //if (tSimple1 == null) {
        new ippLogin(appConf, frmLog, frmMain, bLogin).start();
        //}
        //tSimple1.start();
        //tSimple2.start();
    }

    public void SetServerLabel(String sData) {
        lblServer.setText("Server: " + sData);
    }

    public void SetLoginStatus(String sData) {
        txtLoginStatus.setText(sData);
    }

}

class ippLogin extends Thread {
    private AppConfig m_cConf ;
    private StatusLog m_fLog;
    private IPPBXStatus m_fStat;
    private String m_sSavedCookie;
    private boolean m_bToLogin = true;

    public ippLogin(AppConfig conf, StatusLog fLog, IPPBXStatus fStat, boolean bLogin) {
        m_cConf = conf;
        m_fLog = fLog;
        m_fStat = fStat;
        m_bToLogin = bLogin;
    }

    @Override
    public void run() {

        String sURL = "http://" + m_cConf.IPPBXServerIP + "/rawman?action=login&username="
                    + m_cConf.Username + "&secret=" + m_cConf.Password;
        String sUTF = "UTF-8";
        // construct data
        String sData = null;
        try {

            sData = "?action=login&username=" + URLEncoder.encode(m_cConf.Username,sUTF);
            sData += "&secret=" + URLEncoder.encode(m_cConf.Password, sUTF);

            m_fLog.AppendStatus(sData);

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ippLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        // send data
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
                    m_fLog.AppendStatus(j + ": " + line);
                    if (Pattern.matches("^Response: Success", line)) {
                        m_fLog.AppendStatus("Success");
                    } else if (Pattern.matches("^Message: Authentication accepted", line)) {
                        m_fLog.AppendStatus("Authentication accepted");

                        bSuccess = true;
                    } 
                }
                rd.close();
                String headerName=null;
                for (int i=1; (headerName = conn.getHeaderFieldKey(i))!=null; i++) {
                    if (headerName.equals("Set-Cookie")) {
                        String cookie = conn.getHeaderField(i);
                        m_fLog.AppendStatus("Set-Cookie: " + cookie);

                        if (bSuccess == true) {
                            // save the cookie
                            this.SaveCookie(cookie);
                        }

                    } else {
                        if (headerName.equals("Server")) {
                            m_fStat.SetServerLabel(conn.getHeaderField(i));
                        }
                        m_fLog.AppendStatus("h: " + headerName + " f: " + conn.getHeaderField(i));
                    }
                }

                // get agent status
                this.GetAgentStatus();

                if (m_bToLogin == true) {
                    // Login the Agent
                    this.LoginAgent();
                } else {
                    // Logout Agent
                    this.LogoutAgent();
                }

                /*
                 * get agent status again
                 */
                this.GetAgentStatus();



            } catch (IOException ex) {
                Logger.getLogger(ippLogin.class.getName()).log(Level.SEVERE, null, ex);
            }



        } catch (MalformedURLException ex) {
            Logger.getLogger(ippLogin.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

    private void SaveCookie(String cookie) {
        /* set the cookie
         * mansession_id="7caece15"; username="+ m_cConf.Username +"; rwaccess=yes
         */

        String mansession_id = cookie.substring(0, cookie.indexOf(";"));


        this.m_sSavedCookie = mansession_id + "; username=" + m_cConf.Username + "; rwaccess=yes";
        //conn
        m_fLog.AppendStatus("Cookie: " + m_sSavedCookie);
        
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
                        m_fLog.AppendStatus("Log off Success");
                        bSuccess = true;
                        m_cConf.LoggedIn = false;
                    }
                }
                rd.close();
            } catch (IOException ex) {
                Logger.getLogger(ippLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ippLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void LoginAgent() {
        /*
         * Login agent
         *
         * http://xx.xx.xx.xx/rawman?action=AgentCallbackLogin&Agent=101&Exten=101
         *
         * Response: Success
         * Message: Agent logged in
         *
         */
        String sUTF = "UTF-8";
        String sData = "?action=AgentCallbackLogin&Agent=" + m_cConf.Extension + "&Exten=" + m_cConf.Extension;
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
                        m_fLog.AppendStatus("Login Success");
                        bSuccess = true;
                        m_cConf.LoggedIn = true;
                    }
                }
                rd.close();
            } catch (IOException ex) {
                Logger.getLogger(ippLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ippLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void GetAgentStatus() {
        // get agent status
        /*
         * http://xx.xx.xx.xx/rawman?action=Agents
         *
         * Response: Success
         * Message: Agents will follow
         *
         * Event: Agents
         * Agent: 100
         * Name: 100
         * Status: AGENT_LOGGEDOFF
         * LoggedInChan: n/a
         * LoggedInTime: 0
         * TalkingTo: n/a
         *
         * Event: Agents
         * Agent: 106
         * Name: 106
         * Status: AGENT_IDLE
         * LoggedInChan: 106
         * LoggedInTime: 1299129679
         * TalkingTo: n/a
         *
         * Event: AgentsComplete
         *
         */
        String sUTF = "UTF-8";
        String sData = "?action=Agents";
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
                        m_fLog.AppendStatus("Get Status Success");
                        bSuccess = true;

                    }

                    if (bSuccess == true) {
                        if (Pattern.matches("^Agent: " + m_cConf.Extension, line)) {
                            bFound = true;
                        }

                        if (bFound == true) {
                            if (Pattern.matches("^Agent:.*", line)) {
                                sLoginStatus = line;
                                //m_fLog.AppendStatus(line);
                            } else if (Pattern.matches("^Name:.*", line)) {
                                sLoginStatus += "\n" + line;
                                //m_fLog.AppendStatus(line);
                            } else if (Pattern.matches("^Status:.*", line)) {
                                sLoginStatus += "\n" + line;
                                // check login status
                                if (Pattern.matches(".* AGENT_LOGGEDOFF", line)) {
                                    m_cConf.LoggedIn = false;
                                } else {
                                    m_cConf.LoggedIn = true;
                                }
                                //m_fLog.AppendStatus(line);
                            } else if (Pattern.matches("^LoggedInChan:.*", line)) {
                                sLoginStatus += "\n" + line;
                                //m_fLog.AppendStatus(line);
                            } else if (Pattern.matches("^LoggedInTime:.*", line)) {
                                sLoginStatus += "\n" + line;
                                //m_fLog.AppendStatus(line);
                            } else if (Pattern.matches("^TalkingTo:.*", line)) {
                                sLoginStatus += "\n" + line;
                                //m_fLog.AppendStatus(line);
                                m_fStat.SetLoginStatus(sLoginStatus);
                                bFound = false;
                            }
                        }
                    }


                }
                rd.close();

            } catch (IOException ex) {
                Logger.getLogger(ippLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ippLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

/*
class SimpleThread extends Thread {
    private ippbxstatus.StatusLog m_fLog;
    private String sID;

    public SimpleThread(String str,StatusLog fLog) {
	//super(str);
        m_fLog = fLog;
        sID = str;
    }
    @Override
    public void run() {
	for (int i = 0; i < 10; i++) {
	    m_fLog.AppendStatus(i + " " + sID);
            try {
		sleep((int)(Math.random() * 1000));
	    } catch (InterruptedException e) {}
	}
	m_fLog.AppendStatus("DONE! " + sID);
    }
}
*/