package org.kjtc.util;

import java.util.Properties;

/**
 * Created by xiaojinlu on 2018/7/6.
 */
public class SystemUtils {

   public static boolean getSystem(){
       Properties props=System.getProperties(); //获得系统属性集
       String osName = props.getProperty("os.name"); //操作系统名称
       String osArch = props.getProperty("os.arch"); //操作系统构架
       String osVersion = props.getProperty("os.version"); //操作系统版本
        if (osName.contains("Windows")){
            return true;
        }else {
            return false;

        }
   }

}
