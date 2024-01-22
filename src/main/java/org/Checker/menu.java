package org.Checker;

import burp.IBurpExtenderCallbacks;
import burp.IContextMenuFactory;
import burp.IContextMenuInvocation;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class menu implements IContextMenuFactory {
    private final IBurpExtenderCallbacks callbacks;
    private final BurpExtender extender;

    public menu(IBurpExtenderCallbacks callbacks, BurpExtender extender) {
        this.callbacks = callbacks;
        this.extender = extender;
    }

    @Override
    public List<JMenuItem> createMenuItems(IContextMenuInvocation invocation) {
        List<JMenuItem> list = new ArrayList<>();
        //创建单级右键菜单 //todo 设置多级菜单，并且添加插入功能
        JMenuItem CheckerMenuItem = new JMenu("Fastjson Checker");
        JMenuItem CheckerMenuItemPayload = new JMenu("payload");

        //批量添加子项 payload 菜单
        List<Vulnerability> payloads = Payload.getPayload();
        for(int i=0;i<payloads.size();i++){
            Vulnerability payload = payloads.get(i);
            JMenuItem MenuItemPayload = new JMenuItem(payload.getDescription());
            //监听菜单点击事件
            MenuItemPayload.addActionListener(new ActionListener() { // from class: com.professionallyevil.co2.sqlmapper.SQLMapper.1
                public void actionPerformed(ActionEvent e) {
                    try {
                        callbacks.printOutput(payload.getDetails());
                        //粘贴对应的payload
                        InsertPayload iPayload = new InsertPayload();
                        iPayload.inputString(payload.getPayload());
                    } catch (Exception e1) {
                        callbacks.printError(e1.getMessage());
                    }
                }
            });
            CheckerMenuItemPayload.add(MenuItemPayload);
        }
        CheckerMenuItem.add(CheckerMenuItemPayload);
        JMenuItem CheckerMenuItemdnslog = new JMenu("dnslog");

        //批量添加子项 dnslog 菜单
        List<Vulnerability> dnslogs = Payload.getDnslog();
        for(int i=0;i<dnslogs.size();i++){
            Vulnerability dnslog = dnslogs.get(i);
            JMenuItem MenuItemPayload = new JMenuItem(dnslog.getDescription());
            //监听菜单点击事件
            MenuItemPayload.addActionListener(new ActionListener() { // from class: com.professionallyevil.co2.sqlmapper.SQLMapper.1
                public void actionPerformed(ActionEvent e) {
                    try {
                        callbacks.printOutput(dnslog.getDetails());
                        //粘贴对应的payload
                        InsertPayload iPayload = new InsertPayload();
                        iPayload.inputString(dnslog.getPayload());
                    } catch (Exception e1) {
                        callbacks.printError(e1.getMessage());
                    }
                }
            });
            CheckerMenuItemdnslog.add(MenuItemPayload);
        }
        CheckerMenuItem.add(CheckerMenuItemdnslog);

        JMenuItem CheckerMenuItemversion = new JMenu("version");

        //批量添加子项 version 菜单
        List<Vulnerability> versions = Payload.getVersion();
        for(int i=0;i<versions.size();i++){
            Vulnerability version = versions.get(i);
            JMenuItem MenuItemversion = new JMenuItem(version.getDescription());
            //监听菜单点击事件
            MenuItemversion.addActionListener(new ActionListener() { // from class: com.professionallyevil.co2.sqlmapper.SQLMapper.1
                public void actionPerformed(ActionEvent e) {
                    try {
                        callbacks.printOutput(version.getDetails());
                        //粘贴对应的payload
                        InsertPayload iPayload = new InsertPayload();
                        iPayload.inputString(version.getPayload());
                    } catch (Exception e1) {
                        callbacks.printError(e1.getMessage());
                    }
                }
            });
            CheckerMenuItemversion.add(MenuItemversion);
        }
        CheckerMenuItem.add(CheckerMenuItemversion);
        list.add(CheckerMenuItem);
        return list;
    }
}
