package com.smallcode.common.util;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/**
 * @author lenny
 * @Title: PasswordUtil
 * @Description: 密码工具
 **/
public class PasswordUtil {


    /**
     * 判断密码大小写数字 8-32
     */
    public static boolean checkPwd(String pwd) {

        if (pwd.matches("^[A-Za-z0-9]{8,32}$")) {
            Pattern numPattern = Pattern.compile("[0-9]+");
            Pattern lowerPattern = Pattern.compile("[a-z]+");
            Pattern upperPattern = Pattern.compile("[A-Z]+");
            if (numPattern.matcher(pwd).find() && lowerPattern.matcher(pwd).find() && upperPattern
                    .matcher(pwd).find()) {
                return true;
            }
        }
        return false;
    }


    /**
     * 对原始密码hash
     */
    public static String hash(String source) {
        String password = Hashing.sha256()
            .hashString(source, StandardCharsets.UTF_8)
            .toString();
        return password;
    }
}
