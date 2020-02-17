package com.thoughtworks;

import com.thoughtworks.controllers.Restaurant;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        String selectedItems = new Scanner(System.in).nextLine();
        String orderSummary = new Restaurant().bestCharge(selectedItems);
        System.out.println(orderSummary);
    }
}
