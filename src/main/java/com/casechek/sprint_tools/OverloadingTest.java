package com.casechek.sprint_tools;

public class OverloadingTest {
    Integer fieldOne;
    Integer fieldTwo;
    Integer fieldThree;


    public OverloadingTest() {
        new OverloadingTest(1, 2);
    }

    public OverloadingTest(Integer fieldOne, Integer fieldThree) {
        new OverloadingTest(fieldOne, 2);
    }

    public OverloadingTest(Integer fieldOne, Integer fieldTwo, Integer fieldThree) {
        this.fieldOne = fieldOne;
        this.fieldTwo = fieldTwo;
    }
}

