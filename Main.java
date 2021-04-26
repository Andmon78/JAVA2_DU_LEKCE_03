package com.engeto.examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	// write your code here
         firstTask();
         System.out.println("---------------------------------------");
         readFile1("priklad2.txt");
         System.out.println("---------------------------------------");
         readFiles2("priklad3_1.txt","priklad3_2.txt");
         System.out.println("---------------------------------------");
         powers(4,12);

    }

    // první příklad domácího úkolu - nejdelší řetězec
    public static void firstTask(){
        String[] poleStringu = new String[]{"A", "b", "C", "De", "fF", "gHiJK", "LmN"};
        Stream<String> stringStream = Arrays.stream(poleStringu);

        //1.1  - Najde nejdelší řetězec
        //vypis:   stringStream.max(Comparator.comparing(String::length)).ifPresent(System.out::println);
        String longestString = stringStream.max(Comparator.comparing(String::length)).get();
        //1.2  - V nejdelším řetězci spočítá počet kapitálek
        System.out.println("Počet kapitálek v nejdelším řetězci: " + longestString.chars().filter((s)->Character.isUpperCase(s)).count());
    }

    // spočítat počet znaků na řádku, který nemá žádnou číslici
    public static void readFile1(String fileName){
        int lineNo = 0;
        try{  BufferedReader readerLine = new BufferedReader(new FileReader(fileName));
              String line = readerLine.readLine();
              lineNo++;
              while(line != null) {
                  long digitsCount = line.chars().filter((c) -> Character.isDigit(c)).count();
                  long charsCount = line.chars().count();
                  System.out.println(digitsCount == 0 ? "Řádek č." + lineNo + " má " + charsCount +" znaků" : "Řádek č." + lineNo + " obsahuje číslo");
                  line = readerLine.readLine();
                  lineNo++;
              }
        } catch (IOException error){
            error.printStackTrace();
        }
    }

    // nacteni cisel ze dvou souboru a vypocet jejich prumeru na 2 desetinná místa
    public static void readFiles2(String fileName1, String fileName2){
        ArrayList<Double> arrayOfNumbers = new ArrayList<>();
        // nacteni cisel ze souboru č.1
        try(Scanner strings = new Scanner(new BufferedReader(new FileReader(fileName1)));) {
            while (strings.hasNext()) {
                if (strings.hasNextDouble()) {
                    arrayOfNumbers.add(strings.nextDouble());
               }
            }
        } catch (IOException error){
            error.printStackTrace();
        }
        // nacteni cisel ze souboru č.2
        try(Scanner strings = new Scanner(new BufferedReader(new FileReader(fileName2)));) {
            while (strings.hasNext()) {
               if (strings.hasNextDouble()) {
                    arrayOfNumbers.add(strings.nextDouble());
                }
            }
        } catch (IOException error){
            error.printStackTrace();
        }
        // zpracovani cisel - vypocet prumeru na 2 desetinná místa
        System.out.println("Pole načtených čísel: " + arrayOfNumbers);
        System.out.printf("Průměr: %.2f\n", arrayOfNumbers.stream().mapToDouble(num -> num).average().getAsDouble());
        // zaokrouhlování je krkolomné, ale nic jiného mi nešlo
    }

    public static void powers(int numberOne, int numberTwo){
        System.out.print("Čísla k vypočtení druhé mocniny:  ");
        IntStream.rangeClosed(numberOne, numberTwo).forEach(i -> System.out.print(i + "  "));

        System.out.print("\nVypočtené druhé mocniny:  ");
        IntStream.rangeClosed(numberOne, numberTwo).forEach(i -> System.out.print(i*i + "  "));
    }
}
