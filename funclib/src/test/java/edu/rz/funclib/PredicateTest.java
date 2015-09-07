package edu.rz.funclib;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PredicateTest {

    Predicate<Integer> greaterThan20;
    Predicate<Integer> lessThan77;

    @Before
    public void setUp() throws Exception {
        greaterThan20 = new Predicate<Integer>() {
            @Override
            public Boolean invoke() {
                return this.argument > 20;
            }
        };
        lessThan77 = new Predicate<Integer>(){
            @Override
            public Boolean invoke(){
                return this.argument < 77;
            }
        };

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void predicatePositiveTest(){

        greaterThan20.setArgument(21);
        assertTrue(greaterThan20.invoke());
    }

    @Test
    public void predicateNegativeTest(){
        greaterThan20.setArgument(18);
        assertFalse(greaterThan20.invoke());
    }

    @Test
    public void predicateNotFuncGreaterTest(){

        Predicate<Integer> lessOrEqualThen20 = greaterThan20.not();
        lessOrEqualThen20.setArgument(55);
        assertFalse(lessOrEqualThen20.invoke());
    }

    @Test
    public void predicateNotFuncEqualsTest(){
        Predicate<Integer> lessOrEqualThen20 = greaterThan20.not();
        lessOrEqualThen20.setArgument(20);
        assertTrue(lessOrEqualThen20.invoke());
    }

    @Test
    public void predicateNotFuncLessTest(){
        Predicate<Integer> lessOrEqualThen20 = greaterThan20.not();
        lessOrEqualThen20.setArgument(15);
        assertTrue(lessOrEqualThen20.invoke());
    }

    @Test
    public void predicateAndTrueConditionTest(){

        Predicate<Integer> beetween20And77 = greaterThan20.and(lessThan77);
        beetween20And77.setArgument(55);
        assertTrue(beetween20And77.invoke());
    }

    @Test
    public void predicateAndFalseConditionTest(){

        Predicate<Integer> beetween20And77 = greaterThan20.and(lessThan77);
        beetween20And77.setArgument(94);
        assertFalse(beetween20And77.invoke());
    }

    @Test
    public void  predicateOrTrueConditionTest(){

        Predicate<Integer> lessOrEqualThen20 = greaterThan20.not();
        Predicate<Integer>  greaterOrEqualThan77 = lessThan77.not();
        Predicate<Integer> le20ge77 = lessOrEqualThen20.or(greaterOrEqualThan77);
        le20ge77.setArgument(10);
        assertTrue(le20ge77.invoke());
        le20ge77.setArgument(111);
        assertTrue(le20ge77.invoke());

    }

    @Test
    public void  predicateOrFalseConditionTest(){

        Predicate<Integer> lessOrEqualThen20 = greaterThan20.not();
        Predicate<Integer>  greaterOrEqualThan77 = lessThan77.not();
        Predicate<Integer> le20ge77 = lessOrEqualThen20.or(greaterOrEqualThan77);
        le20ge77.setArgument(64);
        assertFalse(le20ge77.invoke());


    }
}