/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeus.serde.entity;

import java.util.List;

/**
 *
 * @author jeus
 */
public class User {

    private String name;
    private String famil;
    private int age;
    private long registerDate;
    private List<String> phoneNumber;
    private List<Integer> rateNumber;

    public User(String name, String famil, int age, long registerDate, List<String> phoneNumber, List<Integer> rateNumber) {
        this.name = name;
        this.famil = famil;
        this.age = age;
        this.registerDate = registerDate;
        this.phoneNumber = phoneNumber;
        this.rateNumber = rateNumber;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamil() {
        return famil;
    }

    public void setFamil(String famil) {
        this.famil = famil;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(long registerDate) {
        this.registerDate = registerDate;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Integer> getRateNumber() {
        return rateNumber;
    }

    public void setRateNumber(List<Integer> rateNumber) {
        this.rateNumber = rateNumber;
    }

    private void addRateNumber(Integer rateNum) {
        rateNumber.add(rateNum);
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", famil=" + famil + ", age=" + age + ", registerDate=" + registerDate + ", phoneNumber=" + phoneNumber + ", rateNumber=" + rateNumber + '}';
    }

}
