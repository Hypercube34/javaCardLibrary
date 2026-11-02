/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javaassignmentone_deployablejar;

/**
 *
 * @author nathan
 */

import java.io.IOException;

interface Card {
    
    // Default Values
    int SPD = 0;
    int HP = 0;
    String name = "";
    String DISPLAYNAME = "";
    int lengthTracker = 0;
    int LVL = 1;
    int DMG = 0;
    String TEXTBOX = "|                                                                                                                                                                                                                        ";
    String DISPLAYTEXT = "";
    String partOfSpeach = "";
    String displayPOS = "";
    
    void takeDamage(int dmg, String damageSource);
    
    public void displayCard();
}

class Language_Barrier implements Card {

    
    int SPD = 0;
    int HP = 9;
    String name = "Language Barrier";
    String DISPLAYNAME = "";
    int lengthTracker = 0;
    int LVL = 4;
    int DMG = 0;
    String TEXTBOX = "| Guard.                  If this is hit by an    attack and survives,    give it +1 HP for each  word in that attack's   name.";
    String DISPLAYTEXT = "";
    String partOfSpeach = "Person";
    String displayPOS = "";
    
    @Override
    public void takeDamage(int dmg, String damageSource){
        HP -= dmg;
        if (HP >= 1) {
            int attackWordCount = damageSource.split("\\s").length;
            HP += attackWordCount;
        }
    }
    
    @Override
    public void displayCard(){
        CardPrinter.printCard(SPD, name, HP, TEXTBOX, LVL, displayPOS, DMG);
    }
}

class Text_Block implements Card {
    int SPD = 0;
    int HP = 0;
    String name = "Text Block";
    String DISPLAYNAME = "";
    int lengthTracker = 0;
    int LVL = 1;
    int DMG = 0;
    String TEXTBOX = "|                         This Interjection can   only be revealed when   a Person in the ring is targeted by an attack.  You may play a Book,    and you may redirect    the attack to target    any Book in the ring.";
    String DISPLAYTEXT = "";
    String partOfSpeach = "Interjection";
    String displayPOS = "";
    
    @Override
    public void takeDamage(int dmg, String damageSource){
        HP -= dmg;
    }
    
    @Override
    public void displayCard(){
        CardPrinter.printCard(SPD, name, HP, TEXTBOX, LVL, displayPOS, DMG);
    }
}

class Wall_of_Text implements Card {
    int SPD = 0;
    int HP = 4;
    String name = "Wall of Text";
    String DISPLAYNAME = "";
    int lengthTracker = 0;
    int LVL = 1;
    int DMG = 0;
    String TEXTBOX = "| Guard.                  This has +1 HP for      for each line of text   on Adjective cards      describing this.";
    String DISPLAYTEXT = "";
    String partOfSpeach = "Person";
    String displayPOS = "";
    
    @Override
    public void takeDamage(int dmg, String damageSource){
        HP -= dmg;
    }
    
    @Override
    public void displayCard(){
        // Displays the card itself!
        CardPrinter.printCard(SPD, name, HP, TEXTBOX, LVL, displayPOS, DMG);
    }
}

class CardPrinter {
    static void printCard(int speed, String inputName, int healthPoints, String textBox, int level, String PartOfSpeach, int damage){
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

public class JavaAssignmentOne_DeployableJAR {
    public static void main(String[] args) throws IOException {
        Language_Barrier languageBarrier = new Language_Barrier();
        Text_Block textBlock = new Text_Block();
        Wall_of_Text wallOfText = new Wall_of_Text();
        
        languageBarrier.displayCard();
        textBlock.displayCard();
        wallOfText.displayCard();
    }
}

