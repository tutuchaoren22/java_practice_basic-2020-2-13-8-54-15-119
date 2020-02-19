package com.thoughtworks;

import com.thoughtworks.controllers.Restaurant;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        String selectedItems = new Scanner(System.in).nextLine();
        System.out.println(new Restaurant().bestCharge(selectedItems));
    }
}
