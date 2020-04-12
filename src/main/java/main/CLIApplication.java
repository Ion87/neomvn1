package main;

import space.NasaDataProvider;

import java.util.Scanner;

public class CLIApplication {
    public static void main(String[] args) {
 //       System.out.println("CLI running");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter start and than end dates YYYY-MM-DD :");
        String startDate = in.next(), endDate = in.next();
        try {
            new NasaDataProvider().getNeoAsteroids(startDate,endDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
