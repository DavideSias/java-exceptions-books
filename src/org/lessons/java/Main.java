package org.lessons.java;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Quanti libri vuoi inserire?: ");
        int nBooks = Integer.parseInt(scan.nextLine());

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
        scan.close();
    }
}
