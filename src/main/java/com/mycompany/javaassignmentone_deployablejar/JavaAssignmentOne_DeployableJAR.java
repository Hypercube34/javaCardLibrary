/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javaassignmentone_deployablejar;

/**
 *
 * @author nathan
 */

import java.io.IOException;

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

