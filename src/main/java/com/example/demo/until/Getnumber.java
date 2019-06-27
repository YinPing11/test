package com.example.demo.until;

public class Getnumber {
    public String getnum(String s){
        s=s.trim();
        String str2="";
        if(s != null && !"".equals(s)){
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)>=48 && s.charAt(i)<=57){
                    str2+=s.charAt(i);
                }
            }

        }
        return str2;
    }
}
