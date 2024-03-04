package org.Checker;

import burp.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class  BurpExtender implements IBurpExtender ,IContextMenuFactory,IMessageEditorTabFactory {

    private IBurpExtenderCallbacks callbacks;
    @Override
    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks) {
        this.callbacks = callbacks;
        //设置插件名称
        callbacks.setExtensionName("Fastjson Checker");
        //打印插件日志
        callbacks.printOutput("loaded!!");
        //添加右键菜单
        callbacks.registerContextMenuFactory(this);
//        menu mapper = new menu(callbacks, this);
//        callbacks.registerContextMenuFactory(mapper);
        callbacks.registerMessageEditorTabFactory((IMessageEditorTabFactory) this);


    }


    @Override
    public List<JMenuItem> createMenuItems(IContextMenuInvocation invocation) {
        menu mapper = new menu(callbacks, this);
        return mapper.createMenuItems(invocation);
    }

    public burp.IMessageEditorTab createNewInstance(IMessageEditorController controller, boolean editable) {
        return new IMessageEditorTab(callbacks, this);
    }

}