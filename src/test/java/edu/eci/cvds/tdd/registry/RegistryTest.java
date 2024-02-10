package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateRegistryResult() {
        Person person = new Person();
        RegisterResult result = registry.registerVoter(person);
        assertEquals(RegisterResult.VALID, result);
    }
    @Test
    public void validateRegistryGender(){
        Person person1 = new Person("Sotsa",11111,19,Gender.MALE,true);
        System.out.println(person1);
        RegisterResult result = registry.registerVoter(person1);
        Assert.assertEquals(RegisterResult.VALID, result);
        Person person2 = new Person("Milton",11111,19,Gender.FEMALE,true);
        System.out.println(person1);
        RegisterResult result2 = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.VALID, result2);
        Person person3 = new Person("Milton",11111,19,Gender.FEMALE,true);
        System.out.println(person1);
        RegisterResult result3 = registry.registerVoter(person3);
        Assert.assertEquals(RegisterResult.VALID, result3);

    }
}
