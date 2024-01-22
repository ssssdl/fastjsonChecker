package org.Checker;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;
//右键粘贴payload实现类
public class InsertPayload extends Robot {

    public InsertPayload() throws AWTException {
    }

    public static boolean isWindows() {
        String OS_NAME = System.getProperties().getProperty("os.name").toLowerCase();
        if (OS_NAME.contains("windows")) {
            return true;
        }
        return false;
    }

    public static boolean isWindows10() {
        String OS_NAME = System.getProperties().getProperty("os.name").toLowerCase();
        if (OS_NAME.equalsIgnoreCase("windows 10")) {
            return true;
        }
        return false;
    }

    public static boolean isMac() {
        String os = System.getProperty("os.name").toLowerCase();
        return os.indexOf("mac") >= 0;
    }

    public static boolean isUnix() {
        String os = System.getProperty("os.name").toLowerCase();
        return os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0;
    }

    //插入payload，通过把payload复制到粘贴板，模拟键盘ctrl+v 实现粘贴
    public void inputString(String str) {
        delay(100);
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable origin = clip.getContents((Object) null);
        StringSelection tText = new StringSelection(str);
        clip.setContents(tText, tText);
        if (isWindows10()) {
            inputWithCtrl(86);
        } else if (isWindows()) {
            inputWithCtrl(86);
            // inputWithAlt(32);
            // InputChar(69);
            // InputChar(80);
        } else if (isMac()) {
            String text = "";
            Transferable trans = clip.getContents((Object) null);
            if (trans != null && trans.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                try {
                    text = (String) trans.getTransferData(DataFlavor.stringFlavor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            String script = "tell application \"Terminal\"\n do script \"" + text + "\"";
            ProcessBuilder pb = new ProcessBuilder("osascript", "-e", script + "\n end tell");
            pb.inheritIO();
            try {
                pb.start();
            } catch (IOException e2) {
            }
        } else if (isUnix()) {
            delay(100);
            inputWithCtrlAndShift(86);
            delay(100);
        }
        //clip.setContents(origin, (ClipboardOwner) null);
        delay(100);
    }

    public void inputWithShift(int key) {
        delay(100);
        keyPress(16);
        keyPress(key);
        keyRelease(key);
        keyRelease(16);
        delay(100);
    }

    public void inputWithCtrl(int key) {
        delay(100);
        keyPress(17);
        keyPress(key);
        keyRelease(key);
        keyRelease(17);
        delay(100);
    }

    public void inputWithAlt(int key) {
        delay(100);
        keyPress(18);
        keyPress(key);
        keyRelease(key);
        keyRelease(18);
        delay(100);
    }

    public void inputWithCtrlAndShift(int key) {
        delay(100);
        keyPress(17);
        keyPress(16);
        keyPress(key);
        keyRelease(key);
        keyRelease(16);
        keyRelease(17);
        delay(100);
    }

    public void InputChar(int key) {
        delay(100);
        keyPress(key);
        keyRelease(key);
        delay(100);
    }

}
