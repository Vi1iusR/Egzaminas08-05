//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company.Utils;

public class BCryptPassword {
    private static int workload = 12;

    public BCryptPassword() {
    }

    public static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);
        return hashed_password;
    }

    public static boolean checkPassword(String password_plaintext, String stored_hash) {
        boolean password_verified = false;
        if (null != stored_hash && stored_hash.startsWith("$2a$")) {
            password_verified = BCrypt.checkpw(password_plaintext, stored_hash);
            return password_verified;
        } else {
            throw new IllegalArgumentException("Invalid hash provided for comparison");
        }
    }
}
