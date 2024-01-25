package org.Checker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//编码类 ，对json字符串进行编码，从而bypasswaf
public class encode {
    public static String encodeToJsonUnicode(String json) {
        // 匹配双引号中间的部分的正则表达式
        String regex = "\"(.*?)\"";

        // 编译正则表达式
        Pattern pattern = Pattern.compile(regex);

        // 创建Matcher对象
        Matcher matcher = pattern.matcher(json);

        // 使用StringBuffer保存转换后的JSON
        StringBuffer result = new StringBuffer();

        // 循环匹配并替换
        while (matcher.find()) {
            // 获取匹配到的部分（包含引号）
            String matchWithQuotes = matcher.group();

            // 获取匹配到的部分（不包含引号）
            String matchWithoutQuotes = matcher.group(1);

            // 判断是否有引号，然后进行相应的处理
            if (matchWithQuotes != null) {
                // 处理带引号的部分
                String unicodeMatch = "\"" + convertToUnicode(matchWithoutQuotes).replace("\\u", "\\\\u") + "\"";
                matcher.appendReplacement(result, unicodeMatch);
            }
        }

        // 将最后一次匹配后的部分追加到结果中
        matcher.appendTail(result);

        return result.toString();
    }

    public static String encodeToJsonHex(String json) {
        // 匹配双引号中间的部分的正则表达式
        String regex = "\"(.*?)\"";

        // 编译正则表达式
        Pattern pattern = Pattern.compile(regex);

        // 创建Matcher对象
        Matcher matcher = pattern.matcher(json);

        // 使用StringBuffer保存转换后的JSON
        StringBuffer result = new StringBuffer();

        // 循环匹配并替换
        while (matcher.find()) {
            // 获取匹配到的部分（包含引号）
            String matchWithQuotes = matcher.group();

            // 获取匹配到的部分（不包含引号）
            String matchWithoutQuotes = matcher.group(1);

            // 判断是否有引号，然后进行相应的处理
            if (matchWithQuotes != null) {
                // 处理带引号的部分
                String hexMatch = "\"" + convertToHex(matchWithoutQuotes).replace("\\x", "\\\\x") + "\"";
                matcher.appendReplacement(result, hexMatch);
            }
        }

        // 将最后一次匹配后的部分追加到结果中
        matcher.appendTail(result);

        return result.toString();
    }

    private static String convertToUnicode(String input) {
        StringBuilder unicode = new StringBuilder();
        for (char character : input.toCharArray()) {
            unicode.append("\\u").append(Integer.toHexString(character | 0x10000).substring(1));
        }
        return unicode.toString();
    }

    private static String convertToHex(String input) {
        StringBuilder hex = new StringBuilder();
        for (char character : input.toCharArray()) {
            hex.append("\\x").append(Integer.toHexString(character));
        }
        return hex.toString();
    }
}
