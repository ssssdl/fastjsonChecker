package org.Checker;

import burp.*;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
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
                    System.setProperty("file.encoding", "UTF-8");

                    // 重新加载系统属性
                    try {
                        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
                    } catch (UnsupportedEncodingException e1) {
                        e1.printStackTrace();
                    }
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
                    System.setProperty("file.encoding", "UTF-8");

                    // 重新加载系统属性
                    try {
                        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
                    } catch (UnsupportedEncodingException e1) {
                        e1.printStackTrace();
                    }
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
                    System.setProperty("file.encoding", "UTF-8");

                    // 重新加载系统属性
                    try {
                        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
                    } catch (UnsupportedEncodingException e1) {
                        e1.printStackTrace();
                    }
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

        //bypass 模块
        JMenuItem CheckerMenuItemBypassWaf = new JMenu("bypass");
        //Unicode 编码
        JMenuItem MenuItemBypassWafUnicode = new JMenuItem("Unicode");
        MenuItemBypassWafUnicode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    System.setProperty("file.encoding", "UTF-8");

                    // 重新加载系统属性
                    try {
                        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
                    } catch (UnsupportedEncodingException e1) {
                        e1.printStackTrace();
                    }
                    IHttpRequestResponse[] messages = invocation.getSelectedMessages();
                    byte[] selectedData = null;

                    // 获取上下文类型
                    int context = invocation.getInvocationContext();

                    if (context == IContextMenuInvocation.CONTEXT_MESSAGE_EDITOR_REQUEST ||
                            context == IContextMenuInvocation.CONTEXT_MESSAGE_VIEWER_REQUEST) {
                        // 在请求编辑器或请求查看器中
                        selectedData = messages[0].getRequest();
                    } else if (context == IContextMenuInvocation.CONTEXT_MESSAGE_EDITOR_RESPONSE ||
                            context == IContextMenuInvocation.CONTEXT_MESSAGE_VIEWER_RESPONSE) {
                        // 在响应编辑器或响应查看器中
                        selectedData = messages[0].getResponse();
                    }
                    // 获取用户所选文本的起始和结束位置
                    int[] selectionBounds = invocation.getSelectionBounds();
                    int selectionStart = selectionBounds[0];
                    int selectionEnd = selectionBounds[1];
                    String selectedContent = new String(selectedData);
                    callbacks.printOutput(selectedContent.substring(selectionStart,selectionEnd));
                    //对selectedContent.substring(selectionStart,selectionEnd) 进行编码
                    String  encodeedPayload = encode.encodeToJsonUnicode(selectedContent.substring(selectionStart,selectionEnd));
                    InsertPayload iPayload = new InsertPayload();
                    iPayload.inputString(encodeedPayload);
                } catch(Exception e1){
                    callbacks.printError(e1.getMessage());
                }
            }
        });
        CheckerMenuItemBypassWaf.add(MenuItemBypassWafUnicode);
        JMenuItem MenuItemBypassWafHex = new JMenuItem("Hex");
        MenuItemBypassWafHex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    System.setProperty("file.encoding", "UTF-8");

                    // 重新加载系统属性
                    try {
                        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
                    } catch (UnsupportedEncodingException e1) {
                        e1.printStackTrace();
                    }
                    IHttpRequestResponse[] messages = invocation.getSelectedMessages();
                    byte[] selectedData = null;

                    // 获取上下文类型
                    int context = invocation.getInvocationContext();

                    if (context == IContextMenuInvocation.CONTEXT_MESSAGE_EDITOR_REQUEST ||
                            context == IContextMenuInvocation.CONTEXT_MESSAGE_VIEWER_REQUEST) {
                        // 在请求编辑器或请求查看器中
                        selectedData = messages[0].getRequest();
                    } else if (context == IContextMenuInvocation.CONTEXT_MESSAGE_EDITOR_RESPONSE ||
                            context == IContextMenuInvocation.CONTEXT_MESSAGE_VIEWER_RESPONSE) {
                        // 在响应编辑器或响应查看器中
                        selectedData = messages[0].getResponse();
                    }
                    // 获取用户所选文本的起始和结束位置
                    int[] selectionBounds = invocation.getSelectionBounds();
                    int selectionStart = selectionBounds[0];
                    int selectionEnd = selectionBounds[1];
                    String selectedContent = new String(selectedData);
                    callbacks.printOutput(selectedContent.substring(selectionStart,selectionEnd));
                    //对selectedContent.substring(selectionStart,selectionEnd) 进行编码
                    String  encodeedPayload = encode.encodeToJsonHex(selectedContent.substring(selectionStart,selectionEnd));
                    InsertPayload iPayload = new InsertPayload();
                    iPayload.inputString(encodeedPayload);
                } catch(Exception e1){
                    callbacks.printError(e1.getMessage());
                }
            }
        });
        CheckerMenuItemBypassWaf.add(MenuItemBypassWafHex);
        CheckerMenuItem.add(CheckerMenuItemBypassWaf);

        list.add(CheckerMenuItem);
        return list;
    }
}
