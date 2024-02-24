package edu.eci.cvds.tdd.calculadora;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.eci.cvds.tdd.registry.Gender;
import edu.eci.cvds.tdd.registry.Person;

public class CalculadoraEdadTest {

    @Test
    public void shouldReturnFalseWhenPersonIsAnAdult(){
        Person p = new Person("Hola", 1, 18, Gender.MALE, true);
        assertFalse(CalculoEdad.esMenorDeEdad(p));
    }

}