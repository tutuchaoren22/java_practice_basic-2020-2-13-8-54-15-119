package com.thoughtworks;

import com.thoughtworks.controllers.Restaurant;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        String selectedItems = new Scanner(System.in).nextLine();
        String res = new Restaurant().bestCharge(selectedItems);
        System.out.println(res);
    }
}
