package org.Checker;

import burp.IBurpExtenderCallbacks;
import burp.ITextEditor;

import java.awt.*;
import java.nio.charset.StandardCharsets;

class IMessageEditorTab  implements burp.IMessageEditorTab  {
    private final BurpExtender extender;
    private final IBurpExtenderCallbacks callbacks;
    private ITextEditor iTextEditor;
    public static boolean isEnabled = false;
    public static String Massage = "";
    @Override
    public String getTabCaption() {
        //设置编辑器标题
        return "FastJson";
    }
    public IMessageEditorTab(IBurpExtenderCallbacks callbacks, BurpExtender extender) {
        this.callbacks = callbacks;
        this.extender = extender;
    }

    @Override
    public Component getUiComponent() {
        iTextEditor = callbacks.createTextEditor();
        //todo 可以实现但不是很规范
        iTextEditor.setText(Massage.getBytes(StandardCharsets.UTF_8));
        //设置页面组件
        return iTextEditor.getComponent();
    }

    @Override
    public boolean isEnabled(byte[] content, boolean isRequest) {
        //设置何时启动该文本框
        if(isRequest){
            return isEnabled;
        }
        return false;
    }

    @Override
    public void setMessage(byte[] content, boolean isRequest) {
        //设置消息内容 //todo 消息传递
        try{
            if(isRequest){//同样判断当请求为request才处理数据
                iTextEditor.setText(Massage.getBytes(StandardCharsets.UTF_8));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public byte[] getMessage() {
        //返回iTextEditor内的文本
        return iTextEditor.getText();
    }

    @Override
    public boolean isModified() {
        //不允许编辑
        return false;
    }

    @Override
    public byte[] getSelectedData() {
        //返回iTextEditor中选定的文本 没有选择的话 则不返回数据
        return iTextEditor.getSelectedText();
    }
}