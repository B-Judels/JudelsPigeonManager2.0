package org.example;

import java.time.Year;
import java.util.Date;

public class BreederPigeons{
    private String nickname;
    private int id;
    private String letters;
    private int year;
    private String colour;
    private String gender;
    private String description;
    private String strain;
    private byte[] image1;
    private byte[] image2;
    private byte[] image3;
    private String gene1;
    private String gene2;
    private String gene3;
    private String gene4;


    public BreederPigeons(String nickname, int id, String letters, int year, String colour, String gender, String description, String strain, byte[] image1, byte[] image2, byte[] image3, String gene1, String gene2, String gene3, String gene4) {
        this.nickname = nickname;
        this.id = id;
        this.letters = letters;
        this.year = year;
        this.colour = colour;
        this.gender = gender;
        this.description = description;
        this.strain = strain;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.gene1 = gene1;
        this.gene2 = gene2;
        this.gene3 = gene3;
        this.gene4 = gene4;
    }
public BreederPigeons(int id, String nickname, int year, String letters, String colour, String gender){

    }

    //Getters ------------------------------------
    public String getNickname() {
        return nickname;
    }

    public int getId() {
        return id;
    }

    public String getLetters() {
        return letters;
    }

    public int getYear() {
        return year;
    }

    public String getColour() {
        return colour;
    }

    public String getGender() {
        return gender;
    }

    public String getDescription() {
        return description;
    }

    public String getStrain() {
        return strain;
    }

    public byte[] getImage1() {
        return image1;
    }

    public byte[] getImage2() {
        return image2;
    }

    public byte[] getImage3() {
        return image3;
    }

    public String getGene1() {
        return gene1;
    }

    public String getGene2() {
        return gene2;
    }

    public String getGene3() {
        return gene3;
    }

    public String getGene4() {
        return gene4;
    }
    //...............................................
    //Setters -----------------------------------------
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStrain(String strain) {
        this.strain = strain;
    }

    public void setImage1(byte[] image1) {
        this.image1 = image1;
    }

    public void setImage2(byte[] image2) {
        this.image2 = image2;
    }

    public void setImage3(byte[] image3) {
        this.image3 = image3;
    }

    public void setGene1(String gene1) {
        this.gene1 = gene1;
    }

    public void setGene2(String gene2) {
        this.gene2 = gene2;
    }

    public void setGene3(String gene3) {
        this.gene3 = gene3;
    }

    public void setGene4(String gene4) {
        this.gene4 = gene4;
    }
    //.................................................
}
