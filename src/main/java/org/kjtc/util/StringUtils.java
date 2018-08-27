package org.kjtc.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created By Donghua.Chen on  2018/1/9
 */
public class StringUtils {


    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static String UUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }



    public static String trimAllWhitespace(String str){
        return org.springframework.util.StringUtils.trimAllWhitespace(str);
    }
    public static String removeStart(String tstr, String rstr){
        return org.apache.commons.lang.StringUtils.removeStart(tstr,rstr);
    }

    public static LinkedList<String> stringArray2LinkedList(String[] split){

        LinkedList<String> stringLinkedList = new LinkedList<>();

        for (int i = 0; i <split.length ; i++) {

            if ( isEmpty(split[i])){

                stringLinkedList.add(split[i]);

            }

        }
        return stringLinkedList;

    };

    public static boolean contains(String dir, String src){

        return org.apache.commons.lang.StringUtils.contains(dir, src);

    }

    public static String replace(String str, String reql, String with){

         return org.springframework.util.StringUtils.replace(str, reql, with);
    }
    /**
     *     public static String getFileUrl(Object url) {
     return isEmpty(url) ? "" : ConfigUtil.file_url + url.toString();
     }

     */


    /**
     * 去掉DOUBLE 类型小数点后面的数字 变整数
     */
    public static String DoubleToInteger(Double doublestr) {
        if (doublestr == null) {
            return "";
        }
        String[] strlast = String.valueOf(doublestr).split("\\.", -1);
        if (isNotEmpty(strlast[0])) {
            return strlast[0];
        } else {
            return "";
        }
    }

    /**
     * 去掉所有空格
     *
     * @param str
     * @return
     */
    public static String trimAll(Object str) {
        String newStr = nullToString(str);
        return newStr.replace(" ", nullToString(null));
    }

    /**
     * 获取最后的方法名
     *
     * @param
     */
    public static String getActionName(String menuPath) {

        String name = "";

        String[] arr = menuPath.split("/");

        if (null == arr) {

            return "";
        } else {

            if (arr.length > 2) {
                name = arr[arr.length - 2].toString();// +"/"+ arr[arr.length -
                // 1].toString();
                // name = name.substring(0, name.indexOf("."));
            }
        }
        return name;

    }

    /**
     * 获取空格
     *
     * @param
     * @return
     */
    public static String getBlankObject(Object number) {

        // 判断是否有值
        if (number == null || number.equals("null") || number.equals("")) {

            return "empty";
        } else {

            return number.toString();
        }

    }

    public static String likeStr(String str) {
        return "%" + str.trim() + "%";
    }

    /**
     * 本类用到的方法--null转变成空
     *
     * @param
     * @return
     */
    public static String nullToString(Object obj) {
        String resource = "";
        if (obj == null || obj.equals("null")) {
            return resource;
        } else {
            resource = obj.toString().trim();
        }
        return resource;
    }

    // 0100888888880099 => 0100888888880100
    public static String getNextCardCode(String oldCode) {
        String newCode = "" + (Long.parseLong(oldCode) + 1);
        while (newCode.length() < 16) {
            newCode = "0" + newCode;
        }
        return newCode;
    }

    /**
     * 判断对象是否为空
     *
     * @param
     * @return
     */
    public static boolean isNull(Object obj) {

        if (obj == null) {
            return true;
        }
        if (org.springframework.util.StringUtils.isEmpty(obj.toString())) {
            return true;
        }
        return false;
    }

    /**
     * 判断对象是否不为空
     *
     * @param
     * @return
     */
    public static boolean isNotNull(Object obj) {

        if (obj == null) {
            return false;
        }
        if (org.springframework.util.StringUtils.isEmpty(obj.toString())) {
            return false;
        }
        return true;
    }

    /**
     * 分隔字符 , 注意：如果前后有分隔符，String.split会多出来一个。该方法自动去掉前后分隔符再调用 String.split
     * 注意：特殊字符 $ % 等，需要使用 转义 $, 改为 \\$ aibo zeng 2009-06-09
     *
     * @param str
     * @param ch
     * @return
     */
    public static String[] split(String str, char ch) {
        if (str == null) {
            return null;
        }
        if (str.charAt(0) == ch) {
            str = str.substring(1);
        }
        if (str.charAt(str.length() - 1) == ch) {
            str = str.substring(0, str.length() - 1);
        }
        return str.split(ch + "");
    }

    /**
     * 判断字符串是否为null或空字符串,在模糊查询的时候很有意义
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0 || str.trim().length() == 0;
    }

    public static boolean isEmpty(Long o) {
        return (o == null);
    }

    public static boolean isEmpty(Integer o) {
        return (o == null);
    }

    public static boolean isEmpty(Date o) {
        return (o == null);
    }

    public static boolean isEmpty(BigDecimal o) {
        return (o == null);
    }

    public static boolean isEmpty(Object o) {
        return (o == null);
    }

    /**
     * 判断字符串是否为null或空字符串,在模糊查询的时候很有意义
     */
    public static boolean isNotEmpty(String str) {
        return (str != null && !"".equals(str.trim()) && !"null".equals(str));
    }

    public static boolean isNotEmpty(Long o) {
        return (o != null);
    }

    public static boolean isNotEmpty(Integer o) {
        return (o != null);
    }

    public static boolean isNotEmpty(Date o) {
        return (o != null);
    }

    public static boolean isNotEmpty(BigDecimal o) {
        return (o != null);
    }

    public static boolean isNotEmpty(Object o) {
        return (o != null);
    }

    /**
     * 抓取网站源代码
     *
     * @param surl
     * @return
     */
    public static String getStaticPage(String surl) {
        String htmlContent = "";
        InputStream inputStream = null;
        try {
            URL url = new URL(surl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            inputStream = connection.getInputStream();
            byte bytes[] = new byte[1024 * 2000];
            int index = 0;
            int count = inputStream.read(bytes, index, 1024 * 2000);
            while (count != -1) {
                index += count;
                count = inputStream.read(bytes, index, 1);
            }
            htmlContent = new String(bytes, "UTF-8");
            connection.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return htmlContent.trim();
    }

    /**
     * 把MAP里不为空的key按ASCII排序
     *
     * @param hash
     * @return 排序后的字符串
     */
    public static String packageSupSign(HashMap<String, String> hash, String partnet_key, String supUser_key) {
        TreeMap<String, String> tempInfo = new TreeMap<String, String>(new Comparator<String>() {

            /**
             * int compare(Object o1, Object o2) 返回一个基本类型的整型， 返回负数表示：o1 小于o2，
             * 返回0 表示：o1和o2相等， 返回正数表示：o1大于o2。
             */
            public int compare(String o1, String o2) {
                /*
                 * o1 = o1.toLowerCase(); o2 = o2.toLowerCase();
                 */
                // 指定排序器按照降序排列
                return o1.compareTo(o2);
            }
        });
        if (null != hash) {
            Iterator<String> it = hash.keySet().iterator();
            while (it.hasNext()) {
                String key = it.next();
                String value = hash.get(key);
                if (StringUtils.isNotEmpty(value)) {
                    tempInfo.put(key, value);

                }

            }

        }
        Set<String> set = tempInfo.keySet();
        Iterator<String> it = set.iterator();
        StringBuffer buffer = new StringBuffer();
        while (it.hasNext()) {
            String key = it.next();
            String value = hash.get(key);
            if (StringUtils.isNotEmpty(value)) {
                buffer.append(key).append(value);

            }
        }
        System.out.println("sign------------------------" + buffer.toString() + partnet_key + supUser_key);
        // 返回签名串
        // yuzhijia 20130105 edit 不能去掉，
        return buffer.toString() + partnet_key + supUser_key;
        // return tempInfo.toString().replace("{", "").replace("}",
        // "").replace("=", "").replace(",", "").replace(" ", "") + partnet_key
        // + supUser_key;
    }

    /**
     * 返回URL中的参数字符串（MAP里VALUE为空不加入参数，VALUE经过URLEncode编码）
     *
     * @param hash
     * @return 排序后的字符串
     */
    public static String urlParameters(HashMap<String, String> hash) {
        String urlParameters = "";
        StringBuffer buffer = new StringBuffer();
        if (null != hash) {
            Iterator<String> it = hash.keySet().iterator();
            while (it.hasNext()) {
                String key = it.next();
                String value = hash.get(key);
                if (StringUtils.isNotEmpty(value)) {
                    buffer.append(key + "=" + StringUtils.parameterEncode(value, "GBK") + "&");
                }

            }
            if (StringUtils.isNotEmpty(buffer.toString())) {
                urlParameters = buffer.toString().substring(0, buffer.toString().length() - 1);
            }

        }
        return urlParameters;
    }

    /**
     * 把参数通过URLEncode转码
     *
     * @param beforeFormat
     * @return
     */
    public static String parameterEncode(String beforeFormat, String format) {
        String afterFormat = "";
        try {
            afterFormat = URLEncoder.encode(beforeFormat, format);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return afterFormat;
    }

    /**
     * 判断对象是否为空
     *
     * @param o
     * @return
     */
    public static boolean isBlank(Object o) {
        // o = o.toString().trim();
        if (o == null) {
            return true;
        }
        if (org.springframework.util.StringUtils.isEmpty(o.toString())) {
            return true;
        }
        return false;
    }

    /**
     * 判断对象是否不为空
     *
     * @param o
     * @return
     */
    public static boolean isNotBlank(Object o) {

        // o = o.toString().trim();
        if (o == null) {
            return false;
        }
        if (org.springframework.util.StringUtils.isEmpty(o.toString())) {
            return false;
        }
        return true;
    }

    /**
     * 判断是否是数字
     *
     * @param number
     * @return
     */
    public static boolean isTrueNumber(String number) {

        boolean rs = false;

        // 判断是否带小数点
        if (number.indexOf(".") > -1) {

            String test = "\\d+.\\d+";

            if (number != null && Pattern.compile(test).matcher(number).matches()) {

                rs = true;
            } else {

                rs = false;
            }

        } else {

            String test = "\\d+";

            if (number != null && Pattern.compile(test).matcher(number).matches()) {

                rs = true;
            } else {

                rs = false;
            }

        }

        return rs;
    }

    /**
     * 将字符串转换成List对象
     *
     * @param obj
     * @return
     */
    public static List<Integer> getStringToList(String obj) {

        if (obj == null || obj.equals("")) {
            return null;
        }

        String[] arr = obj.split(",");

        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {

            list.add(Integer.parseInt(arr[i].toString()));
        }

        return list;
    }

    /**
     * Chica.Yu 20130309 add 把所有标准的
     * http://www.cxxcom/sss/sxx/x/x/或者htpps://www.cxx.com/sdfsdfx/x/x/x/截取到第3个/
     * 符号为止 结果形式：http://www.cxxcom/ htpps://www.cxx.com/
     *
     * @param urlstr
     *            需要截取的URL
     * @return
     */
    public static String cutUrl(String urlstr) {
        String http = "http://";
        String https = "https://";
        if (isNotEmpty(urlstr)) {
            if (urlstr.startsWith(http)) {
                urlstr = urlstr.substring(http.length(), urlstr.length());
                if (urlstr.contains("/")) {
                    urlstr = urlstr.substring(0, urlstr.indexOf("/") + 1);
                }
                urlstr = http + urlstr;
            }
            if (urlstr.startsWith(https)) {
                urlstr = urlstr.substring(https.length(), urlstr.length());
                if (urlstr.contains("/")) {
                    urlstr = urlstr.substring(0, urlstr.indexOf("/") + 1);
                }
                urlstr = https + urlstr;
            }

        } else {
            urlstr = "";
        }
        return urlstr;
    }

    // Chica.Yu 2013年3月18日17:56:37 空数字转化--------------------------------
    public static Double null20(Double d) {
        if (StringUtils.isBlank(d)) {
            return 0d;
        }
        return d;
    }

    public static Long null20(Long d) {
        if (StringUtils.isBlank(d)) {
            return 0l;
        }
        return d;
    }

    public static Integer null20(Integer d) {
        if (StringUtils.isBlank(d)) {
            return 0;
        }
        return d;
    }

    public static Long int2Long(Integer d) {
        return Long.parseLong(null20(d) + "");
    }

    public static Integer logn2int(Long d) {
        return Integer.parseInt(null20(d) + "");
    }

    public static Double null20(String d) {
        if (StringUtils.isBlank(d)) {
            return 0d;
        }
        return Double.parseDouble(d);
    }

    public static String unicodeToUtf8(String theString) {
        char aChar;
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len;) {
            aChar = theString.charAt(x++);
            if (aChar == '\\') {
                aChar = theString.charAt(x++);
                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = theString.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
                        }
                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);
        }
        return outBuffer.toString();
    }

    public static Map<String, String> string2Map(String a) {
        Map<String, String> m = new HashMap<String, String>();
        if (!isNull(a)) {
            String[] as = a.split("&");
            if (as.length > 0) {
                for (int i = 0; i < as.length; i++) {
                    String[] aas = as[i].split("=");
                    if (aas.length == 1) {
                        m.put(aas[0], "");
                    } else {
                        m.put(aas[0], aas[1]);
                    }
                }
            }
        }
        return m;
    }

    public static String praseMap2String(Map map) {
        String str = "";
        if (!StringUtils.isEmpty(map)) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String key = (String) entry.getKey();
                str += "," + key;
            }
            if (str != null && str.startsWith(","))
                str = str.substring(1);
        }
        return "'" + str + "'";
    }

    /**
     * 解析字符串，从河南旅游局传入的日期格式2013/12/6 12:25:00转换成2013-01-28 12:52:08
     *
     * @param sdate
     *            2013/12/6 12:25:00
     * @return
     */
    public static String praseDate(String sdate) throws Exception {
        String tmpData = sdate;
        String sy = tmpData.substring(0, 4);
        tmpData = tmpData.substring(tmpData.indexOf("/") + 1);
        String sm = tmpData.substring(0, tmpData.indexOf("/"));
        if (sm != null && sm.length() < 2)
            sm = "0" + sm;
        tmpData = tmpData.substring(tmpData.indexOf("/") + 1);
        String sd = tmpData.substring(0, tmpData.indexOf(" "));
        if (sd != null && sd.length() < 2)
            sd = "0" + sd;
        tmpData = tmpData.substring(tmpData.indexOf(" ") + 1);
        String sh = tmpData.substring(0, tmpData.indexOf(":"));
        if (sh != null && sh.length() < 2)
            sh = "0" + sh;
        tmpData = tmpData.substring(tmpData.indexOf(":") + 1);
        String sMi = tmpData.substring(0, tmpData.indexOf(":"));
        if (sMi != null && sMi.length() < 2)
            sMi = "0" + sMi;
        String ss = tmpData.substring(tmpData.indexOf(":") + 1);
        if (ss != null && ss.length() < 2)
            ss = "0" + ss;
        return sy + "-" + sm + "-" + sd + " " + sh + ":" + sMi + ":" + ss;
    }

    /**
     * 字符串去掉重复
     *
     * @param ss
     * @return
     */
    public static String formatString(String ss) {
        String strnew = "";
        String[] strs = ss.split(",");
        Map<String, String> map = new HashMap<String, String>();
        // 用Map过滤重复记录
        if (strs != null && strs.length > 0) {
            for (String s : strs) {
                map.put(s, s);
            }
        }
        // 将过滤完数据放入List
        ArrayList<String> list = new ArrayList<String>();
        Set<String> set = map.keySet();
        for (String str : set) {
            list.add(str);
        }
        // 排序
        Collections.sort(list);
        // 返回
        Object[] objs = list.toArray();
        // 重新定义长度
        strs = new String[objs.length];
        for (int i = 0; i < objs.length; i++) {
            strnew += (String) objs[i] + ",";
        }
        return strnew;

    }

    // ------------------------------------------------end
    public static String formatHtml(String html) {
        html = html.replace("onmouseover", "");
        html = html.replace("onmouseout", "");
        html = html.replace("onmousedown", "");
        html = html.replace("onmouseup", "");
        html = html.replace("onmousemove", "");
        html = html.replace("onclick", "");
        html = html.replace("ondblclick", "");
        html = html.replace("onkeypress", "");
        html = html.replace("onkeydown", "");
        html = html.replace("onkeyup", "");
        html = html.replace("onkeyup", "");
        html = Pattern.compile("<script.*?>.*?</script>", Pattern.CASE_INSENSITIVE).matcher(html).replaceAll("");
        return html;
    }

    public static boolean containsEmoji(String source) {
        if (StringUtils.isBlank(source)) {
            return false;
        }

        int len = source.length();

        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);

            if (isEmojiCharacter(codePoint)) {
                // do nothing，判断到了这里表明，确认有表情字符
                return true;
            }
        }

        return false;
    }

    private static boolean isEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) || (codePoint == 0xD)
                || ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
                || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }

    /**
     * 过滤emoji 或者 其他非文字类型的字符
     *
     * @param source
     * @return
     */
    public static String filterEmoji(String source) {

        if (!containsEmoji(source)) {
            return source;// 如果不包含，直接返回
        }
        // 到这里铁定包含
        StringBuilder buf = null;

        int len = source.length();

        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);

            if (isEmojiCharacter(codePoint)) {
                if (buf == null) {
                    buf = new StringBuilder(source.length());
                }

                buf.append(codePoint);
            } else {
            }
        }

        if (buf == null) {
            return source;// 如果没有找到 emoji表情，则返回源字符串
        } else {
            if (buf.length() == len) {// 这里的意义在于尽可能少的toString，因为会重新生成字符串
                buf = null;
                return source;
            } else {
                return buf.toString();
            }
        }

    }

    public static void main(String[] args) {
        String aa = "ssss.ftl";
        System.out.println(getFileName(aa));
    }


    public static String bytetoString(byte[] bytearray) {
        String result = "";

        int temp = 0;
        for(int n = 0; n < bytearray.length; n++) {
            temp = byteConvortInt(bytearray[n]);
            temp = temp >> 4;
            result += (0x0a<=temp && temp <=0x0f)?(char)(temp+87):(char)(temp+48);

            temp=byteConvortInt(bytearray[n]) & 0x0F;
            result += (0x0a<=temp && temp <=0x0f)?(char)(temp+87):(char)(temp+48);
        }
        return result.toUpperCase();
    }
    public static int byteConvortInt(byte b) {
        return b>=0?b:256+b;
    }

    /**
     *
     * @param str
     * @return
     */
    public static String getvalue(String  str) {
        if(str==null || str=="" ||str.length()==0){

            return null;
        }
        return str;
    }
    public static String getStr(String na) {
        String str = null;
        if(na.contains("_") == true){
            StringBuffer  sb = new StringBuffer();
            String[]  spStr = na.split("_");
            sb.append(spStr[0]);
            for (int i = 1; i < spStr.length; i++) {
                sb.append(spStr[i].substring(0,1).toUpperCase()+spStr[i].substring(1,spStr[i].length()).toLowerCase());
            }
            str = sb.toString();
        }else {
            str = na.toLowerCase();
        }
        return str;
    }

    /**
     * 获取路径
     * @param str
     * @return
     */
    public static String getPath(String str) {
        int show = show1(str, "..\\");
        String[] spl = str.split("\\\\");
        System.out.println(spl.length);
        String s ="";
        for (int i = 0; i < spl.length-show*2; i++) {
            s  =s+ spl[i]+"\\";
        }

        return s;
    } //第一种
    public static int show1(String str, String key) {
        int count = 0;// 计数器
        int tmp = 0;// 记录截取后的新位置
        while ((tmp = str.indexOf(key)) != -1) {// 查找key(ss),找到的地址码给tmp
            str = str.substring(tmp + key.length());// 截取
            // 地址码+key长度,截取后重组成新str,继续while
            // 截取指导索引位置的字符串
            // 子串第一次出现的位置+长度=下一次的起始位置
            count++;
        }
        return count;
    }
    //第二种
    public static int show2(String str, String key) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(key, index)) != -1) {// 循环到没有ss就停
            index = index + key.length();
            count++;
        }
        return count;
    }

    public static String getFileName(String originalFilename) {
        String[] str =originalFilename.split("\\.");
        String fName = "";
        for (int i = 0; i < str.length; i++) {
            fName= str[0];

        }
        return fName;
    }
}
