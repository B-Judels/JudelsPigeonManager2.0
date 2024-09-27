package org.example;

import java.util.Date;

public class PigeonLoad {
    private String nickname;
    private int id;
    private String letters;
    private int year;
    private String colour;
    private String gender;
    private String weaned;
    private int timesFlyed;
    private int timesScored;
    private double scorePercentage;
    private int wins;
    private String description;
    private String strain;
    private String Father;
    private String Mother;
    private byte[] image1;
    private byte[] image2;
    private byte[] image3;
    private String gene1, gene2, gene3, gene4, gene5, gene6, gene7, gene8;


    public PigeonLoad(String nickname, int id, String letters, int year, String colour, String gender, String weaned, int timesFlyed, int timesScored, double scorePercentage, int wins , String description, String strain, String Father, String Mother, byte[] image1, byte[] image2, byte[] image3, String gene1, String gene2, String gene3, String gene4,  String gene5, String gene6, String gene7, String gene8) {
        this.nickname = nickname;
        this.id = id;
        this.letters = letters;
        this.year = year;
        this.colour = colour;
        this.gender = gender;
        this.weaned = weaned;
        this.timesFlyed = timesFlyed;
        this.timesScored = timesScored;
        this.scorePercentage = scorePercentage;
        this.wins = wins;
        this.description = description;
        this.strain = strain;
        this.Father = Father;
        this.Mother = Mother;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.gene1 = gene1;
        this.gene2 = gene2;
        this.gene3 = gene3;
        this.gene4 = gene4;
        this.gene5 = gene5;
        this.gene6 = gene6;
        this.gene7 = gene7;
        this.gene8 = gene8;
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

    public String getWeaned() {
        return weaned;
    }

    public int getTimesFlyed() {
        return timesFlyed;
    }

    public int getTimesScored() {
        return timesScored;
    }

    public double getScorePercentage() {
        return scorePercentage;
    }

    public int getWins() {
        return wins;
    }

    public String getDescription() {
        return description;
    }

    public String getStrain() {
        return strain;
    }

    public String getFather() {
        return Father;
    }

    public String getMother() {
        return Mother;
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

    public String getGene5() {
        return gene5;
    }

    public String getGene6() {
        return gene6;
    }

    public String getGene7() {
        return gene7;
    }

    public String getGene8() {
        return gene8;
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

    public void setWeaned(String weaned) {
        this.weaned = weaned;
    }

    public void setTimesFlyed(int timesFlyed) {
        this.timesFlyed = timesFlyed;
    }

    public void setTimesScored(int timesScored) {
        this.timesScored = timesScored;
    }

    public void setScorePercentage(double scorePercentage) {
        this.scorePercentage = scorePercentage;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStrain(String strain) {
        this.strain = strain;
    }

    public void setFather(String Father) {
        this.Father = Father;
    }

    public void setMother(String Mother) {
        this.Mother = Mother;
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

    public void setGene5(String gene5) {
        this.gene5 = gene5;
    }

    public void setGene6(String gene6) {
        this.gene6 = gene6;
    }

    public void setGene7(String gene7) {
        this.gene7 = gene7;
    }

    public void setGene8(String gene8) {
        this.gene8 = gene8;
    }
}
