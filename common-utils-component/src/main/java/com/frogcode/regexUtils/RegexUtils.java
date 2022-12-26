package com.frogcode.regexUtils;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author frogcode
 * Created on 2022-12-26
 *
 * https://www.runoob.com/regexp/regexp-syntax.html
 * https://c.runoob.com/front-end/854/
 */
public class RegexUtils {
    private static final int PASSWORD_DIGIT = 16;
    // \w 匹配字母、数字、下划线。等价于 [A-Za-z0-9_]
    private static final String PASSWORD_REGEX = "(\\w{4}(?=[^$]))";
    private static final String PASSWORD_REPLACE = "$1-";
    private static final String PASSWORD_MATCH_REGEX = "(\\w{4}[-]){3}(\\w{4})";

    private static String generatePassword(){
        String randomStr = RandomStringUtils.random(PASSWORD_DIGIT, true, true);
        String upperRandomStr = randomStr.toUpperCase();
        String password = upperRandomStr.replaceAll(PASSWORD_REGEX, PASSWORD_REPLACE);
        return password;
    }

    private static boolean checkPassword(String password){
        return password.matches(PASSWORD_MATCH_REGEX);
    }

    public static void main(String[] args) {
        String password = generatePassword();
        System.out.println(password);
        System.out.println(checkPassword(password));
    }


}
