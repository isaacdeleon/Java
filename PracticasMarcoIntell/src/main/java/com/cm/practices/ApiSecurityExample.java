package main.java.com.cm.practices;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class ApiSecurityExample {

    public static void main(String[] args) {
        try {
            String privateKey = "privateKey";
            String message = "Message";
            String publicKey = "publicKey";
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(privateKey.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            String hash = Base64.encodeBase64String(sha256_HMAC.doFinal(message.getBytes()));
            System.out.println(publicKey + ":" + hash);
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }
}
