package com.wms.generators;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 根据 query.hbm.xml 中的 SQL 语句，生成对应的 query.item
 *
 * 读取模板文件 ： sql_colums.txt
 *
 */
public class WmsQueryItems {

    public static void main(String[] args) {
        try {

            // 读取内容
            String txt = readFile("sql_colums.txt");

            // 清除所有空格和不可见字符
            txt = txt.replaceAll("\\s*", "");

            // 获取字段
            Map<String, String> map = getFields(txt, ",");

            StringBuffer codeSegment = new StringBuffer();

            /*-------------------------------------------------------
                构建字段
            -------------------------------------------------------*/
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String value = entry.getValue();
                codeSegment.append("private String ").append(value).append(";\n");
            }

            codeSegment.append("\n\n\n");

            /*-------------------------------------------------------
                构建方法
            -------------------------------------------------------*/
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                // getter
                codeSegment.append("@Column(name=\"").append(key).append("\")").append("\n"); // 持久化注解
                codeSegment.append("public String get").append(firstLetterUpperCase(value)).append("() {");
                codeSegment.append("return ").append(value).append(";");
                codeSegment.append("}").append("\n");

                // setter
                codeSegment.append("public void set").append(firstLetterUpperCase(value)).append("(").append("String ").append(value).append(") {");
                codeSegment.append("this.").append(value).append("=").append(value).append(";");
                codeSegment.append("}").append("\n");
            }

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n\n");
            System.out.println(codeSegment.toString());
            System.out.println("\n\n\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 读取文件
     *
     * @return
     */
    private static String readFile(String sourceFileName) throws Exception {
        String fileContent = new String();
        try {
            // 文件输入流
            InputStream ins = WmsQueryItems.class.getClassLoader().getResourceAsStream(sourceFileName);

            // 按固定长度字节数组读取
            ByteArrayOutputStream ops = new ByteArrayOutputStream();
            byte[] str_b = new byte[1024];
            int i = -1;
            while ((i = ins.read(str_b)) > 0) {
                ops.write(str_b, 0, i);
            }

            fileContent = ops.toString();
        } catch (Exception e) {
            throw new Exception("read file error : " + e.getMessage());
        }
        return fileContent;
    }

    /**
     * 解析文本，读取字段
     *
     * @param target
     * @param delimiter
     * @return
     */
    private static Map<String, String> getFields(String target, String delimiter) {

        Map<String, String> result = new LinkedHashMap<>();

        try {
            String[] sa = target.split(delimiter);

            for (String s : sa) {
                String key = s.split("\\.")[1]; // cdsk_owner_code
                String value = formatFieldName(key);    // cdskOwnerCode
                result.put(key.toUpperCase(), value);   // CDSK_OWNER_CODE : cdskOwnerCode
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 按下划线分隔单词，将各个单词首字母大写后合并
     *
     * @param name
     * @return
     */
    public static String formatFieldName(String name) {
        if (name.contains("_")) {
            String[] tmp = name.split("_");
            StringBuilder sb = new StringBuilder();
            sb.append(tmp[0]);
            for (int i = 1; i < tmp.length; i++) {
                //sb.append(tmp[i].substring(0, 1).toUpperCase()).append(tmp[i].substring(1));
                sb.append(firstLetterUpperCase(tmp[i]));
            }
            return sb.toString();
        } else {
            return name;
        }
    }

    /**
     * 单词首字母大写
     *
     * @param word
     * @return
     */
    public static String firstLetterUpperCase(String word) {
        char[] chars = word.toCharArray();
        if (chars[0] >= 'a' && chars[0] <= 'z') {
            chars[0] = (char) (chars[0] - 32);
        }
        return new String(chars);
    }


}
