package com.example.uts_moneytrackerapp.model;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    public static List<User> userList = new ArrayList<>();

    public static void addUser(User user) {
        userList.add(user);
    }

    public static boolean checkUser(String email, String password) {
        for (User u : userList) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmailExist(String email) {
        for (User u : userList) {
            if (u.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static String getNameByEmail(String email) {
        for (User u : userList) {
            if (u.getEmail().equals(email)) {
                return u.getName();
            }
        }
        return "";
    }
}
