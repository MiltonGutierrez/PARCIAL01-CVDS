package edu.eci.cvds.tdd.calculadora;

import edu.eci.cvds.tdd.registry.Person;

public class CalculoEdad {

    public static boolean esMenorDeEdad(Person p) throws Exception{
        if(p.getAge() < 0) throw new Exception("Edad invalida");
        if(p.getAge() >= 0 && p.getAge() < 18) return true;
        return false;
    }
}