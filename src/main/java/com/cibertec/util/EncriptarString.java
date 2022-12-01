package com.cibertec.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarString {
    public static void main(String[] args) {

        var password = "root";

        System.out.println("password: " + password);
        System.out.println("password encriptada: " + encriptarString(password));
    }

    public static String encriptarString(String password) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.encode(password);
    }
}
