package org.Checker;

import burp.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class  BurpExtender implements IBurpExtender {

    @Override
    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks) {
        //设置插件名称
        callbacks.setExtensionName("Fastjson Checker");
        //打印插件日志
        callbacks.printOutput("loaded!!");
        //添加右键菜单
        menu mapper = new menu(callbacks, this);
        callbacks.registerContextMenuFactory(mapper);


    }


}