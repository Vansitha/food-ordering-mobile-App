package com.example.foodapp;

public class CommonData {
    private static int LoginStatus;
    private static String LoginEmail;
    private static String FirstName;
    private  static String LastName;
    private static String Address;

    public static void setLoginStatus(int loginStatus) {
        LoginStatus = loginStatus;
    }

    public static int getLoginStatus(){ return LoginStatus; }

    public  static void setLoginEmail(String loginEmail){
        LoginEmail = loginEmail;
    }

    public static String getLoginEmail() { return LoginEmail; }

    public static void setFirstName(String firstName){
        FirstName = firstName;
    }

    public static void setLastName(String lastName) {
        LastName = lastName;
    }

    public static void setAddress(String address) {
        Address = address;
    }

    public static String getUserDetails() {
        String UserDetails;
        UserDetails = "Name: "+FirstName+" "+LastName+"\n\n`Address: "+Address;

        return UserDetails;
    }
}
