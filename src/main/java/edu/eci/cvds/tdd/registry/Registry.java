package edu.eci.cvds.tdd.registry;

import java.util.HashSet;

public class Registry {

    private HashSet<Integer> IDVotes;

    public Registry(){
        IDVotes = new HashSet<>();
    }

    public RegisterResult registerVoter(Person p) {
        // Verificar si la persona ya ha votado antes
        if (hasVotedBefore(p.getId())) {
            return RegisterResult.DUPLICATED;
        }

        // Verificar si la persona está viva
        if (!p.isAlive()) {
            return RegisterResult.DEAD;
        }

        // Verificar si la persona es menor de edad
        if (p.getAge() < 18 && p.getAge() >= 0) {
            return RegisterResult.UNDERAGE;
        }

        // Verificar si la edad de la persona es inválida
        if (p.getAge() < 0 | p.getAge() >= 135) {
            return RegisterResult.INVALID_AGE;
        }

        IDVotes.add(p.getId());

        // Retornar que el registro fue válido
        return RegisterResult.VALID;
    }

    private boolean hasVotedBefore(Integer ID) {
        return IDVotes.contains(ID);
    } 
}
