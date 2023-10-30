package solid.s;

import org.json.JSONObject;

public class PersonaOutputter {
    private Persona persona;

    public PersonaOutputter(Persona persona) {
        this.persona = persona;
    }

    public void output () {
        System.out.println(persona.getNom() + ":" + persona.getEdat());
    }

    public void toJson() {
        JSONObject jsonObject = new JSONObject(persona);
        System.out.println(jsonObject);
    }



}
