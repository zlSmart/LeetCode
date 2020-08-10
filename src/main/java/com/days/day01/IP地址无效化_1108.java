package com.days.day01;

/**
 * https://leetcode-cn.com/problems/defanging-an-ip-address/
 */
public class IP地址无效化_1108 {
    public static void main(String[] args) {

    }


}

//class Solution {
//    public String defangIPaddr(String address) {
//        return address.replace(".","[.]");
//    }
//}
class Solution11 {
    public String defangIPaddr(String address) {
        StringBuilder str = new StringBuilder();
        for(int i = 0;i<address.length();i++){
            if(address.charAt(i) == '.'){
                str.append("[.]");
            }else{
                str.append(address.charAt(i));
            }
        }
        return str.toString();
    }
}