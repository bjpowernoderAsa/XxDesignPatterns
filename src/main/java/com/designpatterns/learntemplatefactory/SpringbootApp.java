package com.designpatterns.learntemplatefactory;

import org.apache.shiro.crypto.hash.Sha256Hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.stream.Stream;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/20 10:10
 */

public class SpringbootApp {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Stream<String> stringStream = Stream.of("i","love","you");
        stringStream.forEach(s -> System.out.println(s));

        Stream<String> fileStream = Stream.of("I","Love","You","Too");
        fileStream.filter(str -> str.length() == 3).forEach(s -> System.out.println(s));

        String pd = "12345";
        String passWord = new Sha256Hash(pd).toHex();
        System.out.println("---------"+passWord);

        MessageDigest md = MessageDigest.getInstance("md5");
        byte[] bytes = md.digest(pd.getBytes());
        String str = Base64.getEncoder().encodeToString(bytes);
        //5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5
        //e27476508982bfa403db9f54aa6cf2ee082752bf18c169e1a06fcd7e167fa9fe
        System.out.println("---------------MD5-----------"+str);
    }
}
