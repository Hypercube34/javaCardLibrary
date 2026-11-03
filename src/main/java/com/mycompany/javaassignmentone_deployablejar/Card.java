package com.mycompany.javaassignmentone_deployablejar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nathan
 */
public interface Card {
    
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
    
    void displayCard();
}
