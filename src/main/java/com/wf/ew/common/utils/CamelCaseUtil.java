package com.wf.ew.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CamelCaseUtil<T> {

        /**
         * 下划线转驼峰
         *
         * @param fieldName
         * @return
         */
        public static String _toUpper(String fieldName) {
            if (fieldName == null) {
                return null;
            }
            fieldName = fieldName.toLowerCase();
            final StringBuffer sb = new StringBuffer();
            Pattern p = Pattern.compile("_(\\w)");
            Matcher m = p.matcher(fieldName);
            while (m.find()){
                m.appendReplacement(sb,m.group(1).toUpperCase());
            }
            m.appendTail(sb);
            return sb.toString();
        }

        /**
         * 驼峰转 下划线
         * @param camelCaseStr 驼峰字符串
         * @return 带下滑线的String
         */
        public static String toUnderlineCase(String camelCaseStr) {
            if (camelCaseStr == null) {
                return null;
            }
            // 将驼峰字符串转换成数组
            char[] charArray = camelCaseStr.toCharArray();
            StringBuffer buffer = new StringBuffer();
            //处理字符串
            for (int i = 0, l = charArray.length; i < l; i++) {
                if (charArray[i] >= 65 && charArray[i] <= 90) {
                    buffer.append("_").append(charArray[i] += 32);
                } else {
                    buffer.append(charArray[i]);
                }
            }
            return buffer.toString();
        }
}
