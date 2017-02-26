/*
 * Hello Minecraft! Launcher.
 * Copyright (C) 2013  huangyuhui <huanghongxun2008@126.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see {http://www.gnu.org/licenses/}.
 */
package org.jackhuang.hmcl.ui;

import java.io.IOException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jackhuang.hmcl.util.C;
import org.jackhuang.hmcl.api.HMCLog;
import org.jackhuang.hmcl.api.ui.Theme;
import org.jackhuang.hmcl.setting.Settings;
import org.jackhuang.hmcl.core.download.DownloadType;
import org.jackhuang.hmcl.util.sys.IOUtils;
import org.jackhuang.hmcl.util.MessageBox;
import org.jackhuang.hmcl.util.lang.SupportedLocales;
import org.jackhuang.hmcl.util.ui.JSystemFileChooser;
import org.jackhuang.hmcl.util.ui.SwingUtils;

/**
 *
 * @author huangyuhui
 */
public class LauncherSettingsPanel extends RepaintPage {
    
    public LauncherSettingsPanel() {
        setRepainter(this);
    }

    void initGui() {
        initComponents();
        
        animationEnabled = Settings.getInstance().isEnableAnimation();

        DefaultComboBoxModel<String> d = new DefaultComboBoxModel<>();
        for (DownloadType type : DownloadType.values())
            d.addElement(type.getName());
        cboDownloadSource.setModel(d);

        d = new DefaultComboBoxModel<>();
        int id = 0;
        for (SupportedLocales type : SupportedLocales.values()) {
            d.addElement(type.showString());
            if (type.name().equals(Settings.getInstance().getLocalization()))
                id = type.ordinal();
        }
        cboLang.setModel(d);
        cboLang.setSelectedIndex(id);
        
        DefaultComboBoxModel<Theme> g = new DefaultComboBoxModel<>();
        for (Theme t : Theme.THEMES.values())
            g.addElement(t);
        cboTheme.setModel(g);

        txtBackgroundPath.setText(Settings.getInstance().getBgpath());
        txtCommonPath.setText(Settings.getInstance().getCommonpath());
        txtProxyHost.setText(Settings.getInstance().getProxyHost());
        txtProxyPort.setText(Settings.getInstance().getProxyPort());
        txtProxyUsername.setText(Settings.getInstance().getProxyUserName());
        txtProxyPassword.setText(Settings.getInstance().getProxyPassword());
        cboDownloadSource.setSelectedIndex(Settings.getInstance().getDownloadType());
        cboTheme.setSelectedItem(Settings.getInstance().getTheme());
        chkEnableShadow.setSelected(Settings.getInstance().isEnableShadow());
        chkEnableBlur.setSelected(Settings.getInstance().isEnableBlur());
        chkEnableAnimation.setSelected(Settings.getInstance().isEnableAnimation());
        chkDecorated.setSelected(Settings.getInstance().isDecorated());
    }

    @Override
    public void onCreate() {
        initGui();
        super.onCreate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboDownloadSource = new javax.swing.JComboBox();
        lblAbout = new javax.swing.JLabel();
        btnSelBackgroundPath = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();
        txtBackgroundPath = new javax.swing.JTextField();
        lblDownloadSource = new javax.swing.JLabel();
        btnCheckUpdate = new javax.swing.JButton();
        chkEnableShadow = new javax.swing.JCheckBox();
        lblTheme = new javax.swing.JLabel();
        cboTheme = new javax.swing.JComboBox();
        lblProxy = new javax.swing.JLabel();
        txtProxyHost = new javax.swing.JTextField();
        lblProxyHost = new javax.swing.JLabel();
        txtProxyPort = new javax.swing.JTextField();
        lblProxyPort = new javax.swing.JLabel();
        lblProxyUserName = new javax.swing.JLabel();
        txtProxyUsername = new javax.swing.JTextField();
        txtProxyPassword = new javax.swing.JTextField();
        lblProxyPassword = new javax.swing.JLabel();
        chkDecorated = new javax.swing.JCheckBox();
        lblModpack = new javax.swing.JLabel();
        cboLang = new javax.swing.JComboBox();
        lblLang = new javax.swing.JLabel();
        lblRestart = new javax.swing.JLabel();
        btnMCBBS = new javax.swing.JButton();
        chkEnableBlur = new javax.swing.JCheckBox();
        chkEnableAnimation = new javax.swing.JCheckBox();
        lblCommonPath = new javax.swing.JLabel();
        txtCommonPath = new javax.swing.JTextField();
        btnSetCommonPath = new javax.swing.JButton();

        cboDownloadSource.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboDownloadSourceItemStateChanged(evt);
            }
        });

        lblAbout.setText(C.i18n("launcher.about")); // NOI18N
        lblAbout.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnSelBackgroundPath.setText(C.i18n("ui.button.explore")); // NOI18N
        btnSelBackgroundPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelBackgroundPathActionPerformed(evt);
            }
        });

        lblBackground.setText(C.i18n("launcher.background_location")); // NOI18N
        lblBackground.setToolTipText("");

        txtBackgroundPath.setToolTipText(C.i18n("launcher.background_tooltip")); // NOI18N
        txtBackgroundPath.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBackgroundPathFocusLost(evt);
            }
        });

        lblDownloadSource.setText(C.i18n("launcher.download_source")); // NOI18N

        btnCheckUpdate.setText(C.i18n("launcher.update_launcher")); // NOI18N
        btnCheckUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckUpdateActionPerformed(evt);
            }
        });

        chkEnableShadow.setText(C.i18n("launcher.enable_shadow")); // NOI18N
        chkEnableShadow.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkEnableShadowItemStateChanged(evt);
            }
        });

        lblTheme.setText(C.i18n("launcher.theme")); // NOI18N

        cboTheme.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboThemeItemStateChanged(evt);
            }
        });

        lblProxy.setText(C.i18n("launcher.proxy")); // NOI18N

        txtProxyHost.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProxyHostFocusLost(evt);
            }
        });

        lblProxyHost.setText(C.i18n("proxy.host")); // NOI18N

        txtProxyPort.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProxyPortFocusLost(evt);
            }
        });

        lblProxyPort.setText(C.i18n("proxy.port")); // NOI18N

        lblProxyUserName.setText(C.i18n("proxy.username")); // NOI18N

        txtProxyUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProxyUsernameFocusLost(evt);
            }
        });

        txtProxyPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProxyPasswordFocusLost(evt);
            }
        });

        lblProxyPassword.setText(C.i18n("proxy.password")); // NOI18N

        chkDecorated.setText(C.i18n("launcher.decorated")); // NOI18N
        chkDecorated.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkDecoratedItemStateChanged(evt);
            }
        });

        lblModpack.setText(C.i18n("launcher.modpack")); // NOI18N
        lblModpack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblModpack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblModpackMouseClicked(evt);
            }
        });

        cboLang.setModel(new DefaultComboBoxModel(new String[]{C.i18n("color.blue"),C.i18n("color.green"),C.i18n("color.purple"),C.i18n("color.dark_blue"),C.i18n("color.orange"),C.i18n("color.red")}));
        cboLang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLangItemStateChanged(evt);
            }
        });

        lblLang.setText(C.i18n("launcher.lang")); // NOI18N

        lblRestart.setText(C.i18n("launcher.restart")); // NOI18N

        btnMCBBS.setText("MCBBS");
        btnMCBBS.setToolTipText("");
        btnMCBBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMCBBSActionPerformed(evt);
            }
        });

        chkEnableBlur.setText(C.i18n("launcher.enable_blur")); // NOI18N
        chkEnableBlur.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkEnableBlurItemStateChanged(evt);
            }
        });

        chkEnableAnimation.setText(C.i18n("launcher.enable_animation")); // NOI18N
        chkEnableAnimation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkEnableAnimationItemStateChanged(evt);
            }
        });

        lblCommonPath.setText(C.i18n("launcher.common_location")); // NOI18N

        txtCommonPath.setToolTipText(C.i18n("launcher.commpath_tooltip")); // NOI18N
        txtCommonPath.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCommonPathFocusLost(evt);
            }
        });

        btnSetCommonPath.setText(C.i18n("ui.button.explore")); // NOI18N
        btnSetCommonPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetCommonPathActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblProxy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblProxyHost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProxyHost, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblProxyPort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProxyPort, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblProxyUserName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProxyUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblProxyPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProxyPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkDecorated)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkEnableShadow)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkEnableBlur)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkEnableAnimation))
                            .addComponent(lblAbout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCheckUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMCBBS))
                            .addComponent(lblModpack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRestart))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDownloadSource)
                            .addComponent(lblTheme)
                            .addComponent(lblBackground)
                            .addComponent(lblLang)
                            .addComponent(lblCommonPath))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCommonPath)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSetCommonPath))
                            .addComponent(cboLang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtBackgroundPath, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSelBackgroundPath))
                            .addComponent(cboDownloadSource, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboTheme, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCommonPath)
                    .addComponent(txtCommonPath, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSetCommonPath, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBackground)
                    .addComponent(btnSelBackgroundPath, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBackgroundPath, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDownloadSource)
                    .addComponent(cboDownloadSource, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTheme)
                    .addComponent(cboTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLang)
                    .addComponent(cboLang, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProxyHost, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProxy)
                    .addComponent(lblProxyHost)
                    .addComponent(txtProxyPort, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProxyPort)
                    .addComponent(txtProxyUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProxyUserName)
                    .addComponent(txtProxyPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProxyPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkEnableShadow)
                    .addComponent(chkEnableBlur)
                    .addComponent(chkEnableAnimation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkDecorated)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCheckUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMCBBS, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRestart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblModpack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAbout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboDownloadSourceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboDownloadSourceItemStateChanged
        Settings.getInstance().setDownloadType(cboDownloadSource.getSelectedIndex());
    }//GEN-LAST:event_cboDownloadSourceItemStateChanged

    private void btnSelBackgroundPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelBackgroundPathActionPerformed
        JSystemFileChooser fc = new JSystemFileChooser();
        fc.setFileSelectionMode(JSystemFileChooser.FILES_ONLY);
        fc.setDialogTitle(C.i18n("launcher.choose_bgpath"));
        fc.setMultiSelectionEnabled(false);
        fc.setFileFilter(new FileNameExtensionFilter("*.png", "png"));
        fc.addChoosableFileFilter(new FileNameExtensionFilter("*.jpg", "jpg"));
        if (fc.showOpenDialog(this) != JSystemFileChooser.APPROVE_OPTION || fc.getSelectedFile() == null)
            return;
        try {
            String path = fc.getSelectedFile().getCanonicalPath();
            path = IOUtils.removeLastSeparator(path);
            txtBackgroundPath.setText(path);
            Settings.getInstance().setBgpath(path);
            MainFrame.INSTANCE.loadBackground();
        } catch (IOException e) {
            HMCLog.warn("Failed to set background path.", e);
            MessageBox.show(C.i18n("ui.label.failed_set") + e.getMessage());
        }
    }//GEN-LAST:event_btnSelBackgroundPathActionPerformed

    private void txtBackgroundPathFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBackgroundPathFocusLost
        Settings.getInstance().setBgpath(txtBackgroundPath.getText());
        MainFrame.INSTANCE.loadBackground();
    }//GEN-LAST:event_txtBackgroundPathFocusLost

    private void btnCheckUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckUpdateActionPerformed
        Settings.UPDATE_CHECKER.process(true);
        Settings.UPDATE_CHECKER.checkOutdate();
    }//GEN-LAST:event_btnCheckUpdateActionPerformed

    private void cboThemeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboThemeItemStateChanged
        Settings.getInstance().setTheme(((Theme) cboTheme.getSelectedItem()).id);
    }//GEN-LAST:event_cboThemeItemStateChanged

    private void lblModpackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModpackMouseClicked
        SwingUtils.openLink("http://huangyuhui.duapp.com/link.php?type=modpack");
    }//GEN-LAST:event_lblModpackMouseClicked

    private void cboLangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLangItemStateChanged
        Settings.getInstance().setLocalization(SupportedLocales.values()[cboLang.getSelectedIndex()].name());
    }//GEN-LAST:event_cboLangItemStateChanged

    private void chkEnableShadowItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkEnableShadowItemStateChanged
        Settings.getInstance().setEnableShadow(chkEnableShadow.isSelected());
    }//GEN-LAST:event_chkEnableShadowItemStateChanged

    private void chkDecoratedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkDecoratedItemStateChanged
        Settings.getInstance().setDecorated(chkDecorated.isSelected());
    }//GEN-LAST:event_chkDecoratedItemStateChanged

    private void txtProxyHostFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProxyHostFocusLost
        Settings.getInstance().setProxyHost(txtProxyHost.getText());
    }//GEN-LAST:event_txtProxyHostFocusLost

    private void txtProxyPortFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProxyPortFocusLost
        Settings.getInstance().setProxyPort(txtProxyPort.getText());
    }//GEN-LAST:event_txtProxyPortFocusLost

    private void txtProxyUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProxyUsernameFocusLost
        Settings.getInstance().setProxyUserName(txtProxyUsername.getText());
    }//GEN-LAST:event_txtProxyUsernameFocusLost

    private void txtProxyPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProxyPasswordFocusLost
        Settings.getInstance().setProxyPassword(txtProxyPassword.getText());
    }//GEN-LAST:event_txtProxyPasswordFocusLost

    private void btnMCBBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMCBBSActionPerformed
        SwingUtils.openLink(C.URL_PUBLISH);
    }//GEN-LAST:event_btnMCBBSActionPerformed

    private void chkEnableBlurItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkEnableBlurItemStateChanged
        Settings.getInstance().setEnableBlur(chkEnableBlur.isSelected());
    }//GEN-LAST:event_chkEnableBlurItemStateChanged

    private void chkEnableAnimationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkEnableAnimationItemStateChanged
        Settings.getInstance().setEnableAnimation(chkEnableAnimation.isSelected());
    }//GEN-LAST:event_chkEnableAnimationItemStateChanged

    private void btnSetCommonPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetCommonPathActionPerformed
        JSystemFileChooser fc = new JSystemFileChooser();
        fc.setFileSelectionMode(JSystemFileChooser.DIRECTORIES_ONLY);
        fc.setDialogTitle(C.i18n("launcher.choose_commonpath"));
        fc.setMultiSelectionEnabled(false);
        if (fc.showOpenDialog(this) != JSystemFileChooser.APPROVE_OPTION || fc.getSelectedFile() == null)
            return;
        try {
            String path = fc.getSelectedFile().getCanonicalPath();
            txtCommonPath.setText(path);
            Settings.getInstance().setCommonpath(path);
        } catch (IOException e) {
            HMCLog.warn("Failed to set common path.", e);
            MessageBox.show(C.i18n("ui.label.failed_set") + e.getMessage());
        }
    }//GEN-LAST:event_btnSetCommonPathActionPerformed

    private void txtCommonPathFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCommonPathFocusLost
        Settings.getInstance().setCommonpath(txtCommonPath.getText());
    }//GEN-LAST:event_txtCommonPathFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckUpdate;
    private javax.swing.JButton btnMCBBS;
    private javax.swing.JButton btnSelBackgroundPath;
    private javax.swing.JButton btnSetCommonPath;
    private javax.swing.JComboBox cboDownloadSource;
    private javax.swing.JComboBox cboLang;
    private javax.swing.JComboBox cboTheme;
    private javax.swing.JCheckBox chkDecorated;
    private javax.swing.JCheckBox chkEnableAnimation;
    private javax.swing.JCheckBox chkEnableBlur;
    private javax.swing.JCheckBox chkEnableShadow;
    private javax.swing.JLabel lblAbout;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblCommonPath;
    private javax.swing.JLabel lblDownloadSource;
    private javax.swing.JLabel lblLang;
    private javax.swing.JLabel lblModpack;
    private javax.swing.JLabel lblProxy;
    private javax.swing.JLabel lblProxyHost;
    private javax.swing.JLabel lblProxyPassword;
    private javax.swing.JLabel lblProxyPort;
    private javax.swing.JLabel lblProxyUserName;
    private javax.swing.JLabel lblRestart;
    private javax.swing.JLabel lblTheme;
    private javax.swing.JTextField txtBackgroundPath;
    private javax.swing.JTextField txtCommonPath;
    private javax.swing.JTextField txtProxyHost;
    private javax.swing.JTextField txtProxyPassword;
    private javax.swing.JTextField txtProxyPort;
    private javax.swing.JTextField txtProxyUsername;
    // End of variables declaration//GEN-END:variables
}
