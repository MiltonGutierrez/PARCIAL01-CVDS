import java.util.ArrayList;

public class Registry {

    private ArrayList<Person> people;

    public Registry(){
        people = new ArrayList<>();
    }

    public RegisterResult registerVoter(Person p) {
        // Verificar si la persona ya ha votado antes
        if (hasVotedBefore(p)) {
            return RegisterResult.DUPLICATED;
        }

        // Verificar si la persona está viva
        if (!p.isAlive()) {
            return RegisterResult.DEAD;
        }

        // Verificar si la persona es menor de edad
        if (p.getAge() < 18) {
            return RegisterResult.UNDERAGE;
        }

        // Verificar si la edad de la persona es inválida
        if (p.getAge() < 0) {
            return RegisterResult.INVALID_AGE;
        }

        // Registrar a la persona y marcarla como que ya ha votado
        people.add(p);
        p.setHasVoted(true);

        // Retornar que el registro fue válido
        return RegisterResult.VALID;
    }

    private boolean hasVotedBefore(Person p) {
        // Verificar si la persona ya está en la lista y ha votado antes
        for (Person person : people) {
            if (person.getId() == p.getId() && person.hasVoted()) {
                return true;
            }
        }
        return false;
    }
}
