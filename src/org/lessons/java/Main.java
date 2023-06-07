package org.lessons.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int nBooks = 0;

        do {
            try {
                System.out.print("Quanti libri vuoi inserire?: ");
                nBooks = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Inserire un numero valido");
            }

        } while (nBooks <= 0);

        Book[] books = new Book[nBooks];

        for (int i = 0; i < nBooks; i++) {
            Book book = null;
            boolean validBook = false;

            do {
                try {
                    System.out.print("Titolo: ");
                    String title = scan.nextLine();

                    System.out.print("Numero pagine: ");
                    int pages = Integer.parseInt(scan.nextLine());

                    System.out.print("Autore: ");
                    String author = scan.nextLine();

                    System.out.print("Editore: ");
                    String publisher = scan.nextLine();

                    book = new Book(title, pages, author, publisher);
                    validBook = true;
                } catch (InvalidBookException e) {
                    System.out.println(e.getMessage());
                } catch (NumberFormatException ne) {
                    System.out.println("Numero non valido");
                }
            } while (!validBook);

            books[i] = book;
        }

        System.out.println(Arrays.toString(books));

        //BONUS
        File myFile = new File("./myBooks.txt");
        myFile.createNewFile();
        try {
            FileWriter myWriter = new FileWriter("myBooks.txt");
            for (int i = 0; i < books.length; i++) {
                myWriter.write(books[i].toString() + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner reader = new Scanner(myFile);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            System.out.println(line);
        }
        scan.close();
    }
}
