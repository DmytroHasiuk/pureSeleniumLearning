package org.yorm.constants;

import org.yorm.models.User;

public class Constants {
    public static User USER_WITH_WRONG_PASS = new User("Zhora", "1223");

    public static User USER_WITHOUT_PASS = new User("Ura", "gg@easy.com", "88005553535");

    public static User USER_WITH_CORRECT_PASS = new User("Ira", "rahulshettyacademy");
}
