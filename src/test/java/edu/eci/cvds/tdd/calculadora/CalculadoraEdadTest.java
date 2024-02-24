package edu.eci.cvds.tdd.calculadora;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.eci.cvds.tdd.registry.Gender;
import edu.eci.cvds.tdd.registry.Person;

public class CalculadoraEdadTest {

    @Test
    public void shouldReturnFalseWhenPersonIsAnAdult() throws Exception{
        //Edad primer limite: 18
        Person p = new Person("Hola", 1, 18, Gender.MALE, true);
        assertFalse(CalculoEdad.esMenorDeEdad(p));
        //Edad media: 50
        Person p2 = new Person("Hola", 2, 50, Gender.MALE, true);
        assertFalse(CalculoEdad.esMenorDeEdad(p2));
        //Edad segundo limite: 150
        Person p3 = new Person("Hola", 3, 150, Gender.MALE, true);
        assertFalse(CalculoEdad.esMenorDeEdad(p3));


    }

    @Test
    public void shouldReturnTrueWhenPersonIsUnderage() throws Exception{
        //Edad primer limite: 0
        Person p = new Person("Hola", 1, 0, Gender.MALE, true);
        assertTrue(CalculoEdad.esMenorDeEdad(p));
        //Edad media: 10
        Person p2 = new Person("Hola", 2, 10, Gender.MALE, true);
        assertTrue(CalculoEdad.esMenorDeEdad(p2));
        //Edad segundo limite: 17
        Person p3 = new Person("Hola", 3, 17, Gender.MALE, true);
        assertTrue(CalculoEdad.esMenorDeEdad(p3));
    }

    @Test(expected = Exception.class)
    public void shouldFailWhenPersonHasInvalidValuesForAge() throws Exception{
        Person p = new Person("Hola", 1, -1, Gender.MALE, true);
        Person p2 = new Person("Hola", 3, -150, Gender.MALE, true);
        boolean result;
        result = CalculoEdad.esMenorDeEdad(p);
        result = CalculoEdad.esMenorDeEdad(p2);
    }
    
}