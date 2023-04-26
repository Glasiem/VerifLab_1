package org.example;

import java.io.File;
import java.util.Scanner;
public class Main {



    public static void main(String[] args) throws Exception {
        try {
            File file = new File("E:\\in.txt");
            Scanner input = new Scanner(file);
            Automaton automaton = new Automaton();
            automaton.setAlphabetPower(input.nextInt());
            automaton.setStatusPower(input.nextInt());
            automaton.setStart(input.nextInt());
            int statusFinalPower = input.nextInt();
            automaton.setStatusFinalPower(input.nextInt());
            for (int i = 0; i < statusFinalPower; i++)
                automaton.setStatusFinal(input.nextInt());
            while (input.hasNextLine())
                automaton.setLink(input.nextInt(), input.next().charAt(0), input.nextInt());
            automaton.proceed();
        }
        catch(Exception e){
            System.out.println("Wrong input");
        }
    }
}