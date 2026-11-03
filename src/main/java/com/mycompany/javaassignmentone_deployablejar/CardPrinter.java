/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaassignmentone_deployablejar;

/**
 *
 * @author nathan
 */
public class CardPrinter {
    public static void printCard(int speed, String inputName, int healthPoints, String textBox, int level, String PartOfSpeach, int damage){
        int SPD = speed;
        String name = inputName;
        int HP = healthPoints;
        String TEXTBOX = textBox;
        int LVL = level;
        String partOfSpeach = PartOfSpeach;
        int DMG = damage;
        
        int lengthTracker = 0;
        String displayPOS = "";
        String displayName = "";
        String displayTextbox = "";
        
        // Takes any fitting name and centers it with whitespace!
        lengthTracker = name.length();
        for (int i = 0; i < (16 - lengthTracker)/2; ++i){ // Makes the whitespace before the name longer based on its length to center the name.
            displayName = displayName + " "; // Appends a space to the end of the display name
        }
        if (lengthTracker % 2 != 0) { // Adds 1 extra space if the name has an odd length!
            displayName = displayName + " "; // Appends a space to the end of the display name
        }
        displayName = displayName + name; // Inserts the actual name in the middle of the whitespace.
        for (int i = 0; i < (16 - lengthTracker)/2; ++i){ // Makes the whitespace after the name longer based on its length to center the name.
            displayName = displayName + " "; // Appends a space to the end of the display name
        }
        
        // Automaticially wraps the textbox
        lengthTracker = TEXTBOX.length();
        int currentLineCharacterCount = 0;
        for (int i = 0; i < 216; ++i){
            if (i < lengthTracker){
                displayTextbox += TEXTBOX.charAt(i);
            } else {
                displayTextbox += " ";
            }
            
            if (currentLineCharacterCount == 24){
                displayTextbox += "|\n|";
                currentLineCharacterCount = 0;
            }
            currentLineCharacterCount += 1;
        }
        displayTextbox += " |";
        
        // Takes any fitting POS (Part Of Speach) and centers it with whitespace!
        lengthTracker = partOfSpeach.length();
        for (int i = 0; i < (16 - lengthTracker)/2; ++i){ // Makes the whitespace before the POS (Part Of Speach) longer based on its length to center the name.
            displayPOS = displayPOS + " "; // Appends a space to the end of displayPOS
        }
        if (lengthTracker % 2 != 0) { // Adds 1 extra space if the POS (Part Of Speach) has an odd length!
            displayPOS = displayPOS + " "; // Appends a space to the end of displayPOS
        }
        displayPOS = displayPOS + partOfSpeach; // Inserts the actual POS (Part Of Speach) in the middle of the whitespace.
        for (int i = 0; i < (16 - lengthTracker)/2; ++i){ // Makes the whitespace after the POS (Part Of Speach) longer based on its length to center the name.
            displayPOS = displayPOS + " "; // Appends a space to the end of displayPOS
        }
        
    // Displays the card itself!
        System.out.println("__________________________");
        System.out.println("| " + SPD + " |" + displayName + "| " + HP + " |");
        System.out.println("|___|________________|___|");
        System.out.println(displayTextbox);
        System.out.println("|________________________|");
        System.out.println("| " + LVL + " |" + displayPOS + "| " + DMG + " |");
        System.out.println("|___|________________|___|");
    }
}