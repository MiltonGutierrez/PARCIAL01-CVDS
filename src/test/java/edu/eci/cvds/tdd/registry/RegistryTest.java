package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegistryTest {
    private Registry registry = new Registry();

    @Test
    public void testDeadPersonRegistration() {
        Person person = new Person("Sotsa", 12345, 25, Gender.MALE, false); // Persona muerta
        RegisterResult result = registry.registerVoter(person);
        assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void testUnderagePersonRegistration() {
        Person person = new Person("Milton", 54321, 15, Gender.MALErue); // Persona viva y menor de edad
        RegisterResult result = registry.registerVoter(person);
        assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void testInvalidAgePersonRegistration() {
        Person person = new Person("Mutsia", 67890, -5, Gender.MALE, true); // Edad inválida
        RegisterResult result = registry.registerVoter(person);
        assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void testValidPersonRegistration() {
        Person person = new Person("Jeitson", 13579, 30, Gender.MALE true); // Persona viva y edad válida
        RegisterResult result = registry.registerVoter(person);
        assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void testDuplicatedPersonRegistration() {
        Person person1 = new Person("Carl", 24680, 40, Gender.MALE, true); // Persona viva
        registry.registerVoter(person1); // Registrando a la persona por primera vez
        Person person2 = new Person("Carl", 24680, 40, Gender.MALE, true); // Persona viva, pero intentando registrarla nuevamente
        RegisterResult result = registry.registerVoter(person2);
        assertEquals(RegisterResult.DUPLICATED, result);
    }
}
