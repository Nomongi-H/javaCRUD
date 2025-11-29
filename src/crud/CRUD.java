/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crud;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NomongiHlatshwayo
 */
public class CRUD {

     // Using StringBuffer (thread-safe) to store notes
    static ArrayList<StringBuffer> notes = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Notes Manager ---");
            System.out.println("1. Create Note");
            System.out.println("2. View Notes");
            System.out.println("3. Update Note");
            System.out.println("4. Delete Note");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: createNote(); break;
                case 2: viewNotes(); break;
                case 3: updateNote(); break;
                case 4: deleteNote(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    // Create
    static void createNote() {
        System.out.print("Enter your note: ");
        String note = scanner.nextLine();
        notes.add(new StringBuffer(note));
        System.out.println("Note added.");
    }

    // Read
    static void viewNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes available.");
            return;
        }
        System.out.println("Your Notes:");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i+1) + ". " + notes.get(i));
        }
    }

    // Update
    static void updateNote() {
        viewNotes();
        if (notes.isEmpty()) return;

        System.out.print("Enter note number to update: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // consume newline
        if (index >= 0 && index < notes.size()) {
            System.out.print("Enter new text: ");
            String newText = scanner.nextLine();
            notes.get(index).setLength(0); // clear existing note
            notes.get(index).append(newText);
            System.out.println("Note updated.");
        } else {
            System.out.println("Invalid note number.");
        }
    }

    // Delete
    static void deleteNote() {
        viewNotes();
        if (notes.isEmpty()) return;

        System.out.print("Enter note number to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // consume newline
        if (index >= 0 && index < notes.size()) {
            notes.remove(index);
            System.out.println("Note deleted.");
        } else {
            System.out.println("Invalid note number.");
        }
    }
    
}
