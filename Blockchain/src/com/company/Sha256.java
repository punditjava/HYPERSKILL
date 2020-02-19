package com.company;

import java.security.MessageDigest;

class Sha256
{
   String applySha256(String lol){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            /* Applies sha256 to our input */
            byte[] hash = digest.digest(lol.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte elem: hash) {
                String hex = Integer.toHexString(0xff & elem);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

   boolean Proved(String hash , int i)
   {
       boolean flag = false;
       char [] chars = hash.toCharArray();
       for(int k = 0; k < i; k++)
       {
           if(chars[k] != '0') {
               flag = true;
               break;
           }
       }
       return flag;
   }
}
