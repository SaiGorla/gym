/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GMS.GymManagementSystem.models;

/**
 *
 * @author Sai Rohith Gorla
 */
public class BMI {
    private double weight;
    private double height;
    private double bmi;

    public BMI() {

    }

    public BMI(double weight, double height) {

        this.weight = weight;
        this.height = height;
    }

    public BMI(double weight, double height, double bmi) {

        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
    }

    public double getWeight() {

        return weight;
    }

    public void setWeight(double weight) {

        this.weight = weight;
    }

    public double getHeight() {

        return height;
    }

    public void setHeight(double height) {

        this.height = height;
    }

    public double getBmi() {

        return bmi;
    }

    public void setBmi(double bmi) {

        this.bmi = bmi;
    }
}

