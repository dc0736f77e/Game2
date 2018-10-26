package com.victorbeil.alchemy;

import java.util.Objects;

public class UserInput {

    private int index1;

    private int index2;

    private String element2;

    private String element1;

    public UserInput() {
    }

    public UserInput(int index1, int index2) {
        this.index1 = index1;
        this.index2 = index2;
    }

    public UserInput(String element1, String element2) {
       this.element1 = element1;
       this.element2 = element2;
    }

    public int getIndex1() {
        return index1;
    }

    public void setIndex1(int index1) {
        this.index1 = index1;
    }

    public int getIndex2() {
        return index2;
    }

    public void setIndex2(int index2) {
        this.index2 = index2;
    }

    public String getElement2() {
        return element2;
    }

    public void setElement2(String element2) {
        this.element2 = element2;
    }

    public String getElement1() {
        return element1;
    }

    public void setElement1(String element1) {
        this.element1 = element1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInput input = (UserInput) o;
        return index1 == input.index1 && index2 == input.index2 && Objects.equals(element2, input.element2) && Objects.equals(element1, input.element1);
    }

    @Override
    public int hashCode() {

        return Objects.hash(index1, index2, element2, element1);
    }

    @Override
    public String toString() {
        return "UserInput{" + "index1=" + index1 + ", index2=" + index2 + ", element2='" + element2 + '\'' + ", element1='" + element1 + '\'' + '}';
    }
}
