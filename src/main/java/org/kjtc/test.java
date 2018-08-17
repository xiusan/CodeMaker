package org.kjtc;

/**
 * Created by Administrator on 2018/8/17/017.
 */
public class test {
    public static void main(String[] args) {
        String  nan= "org.kjtc.test";
        String[] ba =nan.split("\\.");
        String  pack="";
        for (int i = 0; i < ba.length; i++) {
            pack= ba[i];
        }
        System.out.println(pack);
    }
}
