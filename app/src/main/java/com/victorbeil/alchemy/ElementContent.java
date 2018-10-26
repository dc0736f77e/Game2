package com.victorbeil.alchemy;

import java.util.HashMap;
import java.util.Map;

public class ElementContent {

    private String[] baseElements = {"Water", "Fire", "Air", "Soil"};

    private String[] secondElements = {"Steam", "Rain", "Mud", "Energy", "Lava", "Dust", "Life", "Bakterium", "Tree", "Mushroom"};

    private Map<UserInput, Integer> baseToSecondElementMapping = new HashMap<>();

    public static void main(String[] args) {
        ElementContent elementContent = new ElementContent();

        UserInput input = new UserInput(0, 1);
        System.out.println("Input: " + input);
        int index = elementContent.getMappingIndex(input);
        System.out.println("Mapping result (index): " + index);
        if (index == -1) {
            System.out.println("Try again!");
        } else {
            System.out.println("Mapping result (content): " + elementContent.getSecondElement(index));
        }

        System.out.println("---");

        input = new UserInput(1, 4);
        System.out.println("Input: " + input);
        index = elementContent.getMappingIndex(input);
        System.out.println("Mapping result (index): " + index);
        if (index == -1) {
            System.out.println("Try agin!");
        } else {
            System.out.println("Mapping result (content): " + elementContent.getSecondElement(index));
        }

        System.out.println("Mapping result (content): " + elementContent.getSecondElement(index));

        System.out.println("---");

        input = new UserInput("Water", "Fire");
        System.out.println("Input: " + input);
        index = elementContent.getMappingIndex(input);
        System.out.println("Mapping result (index): " + index);
        if (index == -1) {
            System.out.println("Try agin!");
        } else {
            System.out.println("Mapping result (content): " + elementContent.getSecondElement(index));
        }

        System.out.println("---");

        for (int i = 0; i < elementContent.getBaseElements().length; i++) {
            System.out.println(i + " > " + elementContent.getBaseElements()[i]);
        }

        System.out.println("---");

        for (int i = 0; i < elementContent.getSecondElements().length; i++) {
            System.out.println(i + " > " + elementContent.getSecondElements()[i]);
        }
    }

    public ElementContent() {
       System.out.println("Init ElementContent mapping");

       baseToSecondElementMapping.put(new UserInput(0, 1), 0);
       baseToSecondElementMapping.put(new UserInput(baseElements[0], baseElements[1]), 0);

       baseToSecondElementMapping.put(new UserInput(1, 3), 4);
       baseToSecondElementMapping.put(new UserInput(baseElements[1], baseElements[3]), 4);
    }

    public int getMappingIndex(UserInput input) {
        try {
            return baseToSecondElementMapping.get(input);
        } catch (NullPointerException e) {
            return  -1;
        }
    }

    public String getSecondElement(int index) {
        if (index < 0 || index >= secondElements.length) {
            return null;
        }
        return secondElements[index];
    }

    public String[] getBaseElements() {
        return baseElements;
    }

    public String[] getSecondElements() {
        return secondElements;
    }
}
