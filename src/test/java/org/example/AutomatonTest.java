package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class AutomatonTest {

    @BeforeAll
    static void setUp() {
        System.out.println("Початок тестів");
    }

    @BeforeEach
    void setTest() {
        System.out.println("Початок тесту");
    }

    @Test
    void testConstructor(){
        Automaton automaton = new Automaton();
        assertNotNull(automaton.alphabet);
        assertNotNull(automaton.statuses);
        assertNotNull(automaton.statusFinal);

        assertTrue(automaton.alphabet.isEmpty());
        assertTrue(automaton.statuses.isEmpty());
        assertTrue(automaton.statusFinal.isEmpty());
    }

    @Test
    void AutomatonTest1() throws Exception{
        Automaton automaton = new Automaton();
        automaton.setAlphabetPower(2);
        automaton.setStatusPower(3);
        automaton.setStart(0);
        automaton.setStatusFinalPower(1);
        automaton.setStatusFinal(2);
        automaton.setLink(0, 'a', 1);
        automaton.setLink(0, 'b', 2);
        automaton.setLink(1, 'a', 1);
        automaton.setLink(1, 'b', 2);
        automaton.setLink(2, 'a', 2);
        automaton.setLink(2, 'b', 1);

        assertThat(automaton.alphabet, containsInAnyOrder('a', 'b'));
        assertThat(automaton.statusFinal, containsInAnyOrder(2));
        assertEquals(automaton.statusFinal.size(), 1);

        automaton.proceed();
    }

    @Test
    void AutomatonTest2() throws Exception{
        Automaton automaton = new Automaton();
        automaton.setAlphabetPower(2);
        automaton.setStatusPower(3);
        automaton.setStart(0);
        automaton.setStatusFinalPower(1);
        automaton.setStatusFinal(2);
        automaton.setLink(0, 'a', 1);
        automaton.setLink(0, 'b', 0);
        automaton.setLink(1, 'a', 1);
        automaton.setLink(1, 'b', 0);
        automaton.setLink(2, 'a', 2);
        automaton.setLink(2, 'b', 1);

        String output = automaton.proceed();

        assertThat(output, startsWith("There`s no suitable words of length"));
    }

    @ParameterizedTest
    @ValueSource(ints = { 3, 4, 5})
    void ExceptionTest(int state){
        Automaton automaton = new Automaton();
        automaton.setStatusPower(3);
        assertThrows(Exception.class, () -> automaton.setStart(state));
    }
}