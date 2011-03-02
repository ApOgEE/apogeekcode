/*
 * IPPBXStatus.java
 * Created on Feb 28, 2011, 1:30:36 PM
 *
 */
package ippbxstatus;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
        btnMinimize = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

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

        btnMinimize.setText("Minimize");
        btnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtExtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(txtExtension, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(txtIPPBXAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                    .addComponent(chkEnableLogin)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))
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
                    .addComponent(btnMinimize)
                    .addComponent(btnSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ippbxstatus/ippbxstatus.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        this.appConf.IPPBXServerIP = txtIPPBXAddress.getText();
        this.appConf.Username = txtUsername.getText();

        this.appConf.Password = String.valueOf(txtPassword.getPassword());
        this.appConf.Extension = txtExtension.getText();
        this.appConf.ExtPassword = String.valueOf(txtExtPassword.getPassword());
        this.appConf.EnableLogin = chkEnableLogin.isSelected();

        this.appConf.UpdateConfig();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        // TODO add your handling code here:
        // minimize to tray
        this.setVisible(false);

        trayIcon.displayMessage("Ultratone IPPBX Status",
                "IPPBX Status logger", java.awt.TrayIcon.MessageType.INFO);
    }//GEN-LAST:event_btnMinimizeActionPerformed

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
        JOptionPane.showMessageDialog(rootPane, "unfinished code!");
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmMain = new IPPBXStatus();

                // place the window in the middle of the screen
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                int h = frmMain.getHeight();
                int w = frmMain.getWidth();
                int x = (int) (dim.getWidth() - w) / 2;
                int y = (int) (dim.getHeight() - h) / 2;
                frmMain.setLocation(x, y);

                frmMain.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox chkEnableLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtExtPassword;
    private javax.swing.JTextField txtExtension;
    private javax.swing.JTextField txtIPPBXAddress;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
    private ippbxstatus.AppConfig appConf;
    private static javax.swing.JFrame frmMain;
    private static java.awt.TrayIcon trayIcon;

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
        trayIcon = new java.awt.TrayIcon(createImage("bulb.gif", "Ultratone IPPBX Status"));
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
                /*javax.swing.JOptionPane.showMessageDialog(null,
                "This dialog box is run from System Tray");*/
                frmMain.setVisible(true);
            }
        });

        /*
        aboutItem.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
        javax.swing.JOptionPane.showMessageDialog(null,
        "This dialog box is run from the About menu item");
        }
        });

        cb1.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent e) {
        int cb1Id = e.getStateChange();
        if (cb1Id == java.awt.event.ItemEvent.SELECTED){
        trayIcon.setImageAutoSize(true);
        } else {
        trayIcon.setImageAutoSize(false);
        }
        }
        });

        cb2.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent e) {
        int cb2Id = e.getStateChange();
        if (cb2Id == java.awt.event.ItemEvent.SELECTED){
        trayIcon.setToolTip("Sun TrayIcon");
        } else {
        trayIcon.setToolTip(null);
        }
        }
        });
        
        java.awt.event.ActionListener listener = new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
        java.awt.MenuItem item = (java.awt.MenuItem)e.getSource();
        //TrayIcon.MessageType type = null;
        System.out.println(item.getLabel());
        if ("Error".equals(item.getLabel())) {
        //type = TrayIcon.MessageType.ERROR;
        trayIcon.displayMessage("Sun TrayIcon Demo",
        "This is an error message", java.awt.TrayIcon.MessageType.ERROR);

        } else if ("Warning".equals(item.getLabel())) {
        //type = TrayIcon.MessageType.WARNING;
        trayIcon.displayMessage("Sun TrayIcon Demo",
        "This is a warning message", java.awt.TrayIcon.MessageType.WARNING);

        } else if ("Info".equals(item.getLabel())) {
        //type = TrayIcon.MessageType.INFO;
        trayIcon.displayMessage("Sun TrayIcon Demo",
        "This is an info message", java.awt.TrayIcon.MessageType.INFO);

        } else if ("None".equals(item.getLabel())) {
        //type = TrayIcon.MessageType.NONE;
        trayIcon.displayMessage("Sun TrayIcon Demo",
        "This is an ordinary message", java.awt.TrayIcon.MessageType.NONE);
        }
        }
        };*/
        /*
        errorItem.addActionListener(listener);
        warningItem.addActionListener(listener);
        infoItem.addActionListener(listener);
        noneItem.addActionListener(listener);
         */
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
}
