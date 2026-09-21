package org.example;

public class Attack {

    //Namn för attack
    private String name;

    //Hur mycket damage gör attacken
    private int baseDamage;

    //Chans för träff av attack
    private int accuracy;

    //Vilken typ av attack
    private Element element;

    //Format vid skapandet av en attack
    //Kolla ifall det är giltig information
    public Attack(String name, int baseDamage, int accuracy, Element element){

        //Attack namn kan inte vara tom
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Attack name cannot be empty!");
        }

        //baseDamage kan inte vara mindre än 0
        if (baseDamage <= 0){
            throw new IllegalArgumentException("Base Damage must be greater than 0.");
        }

        //Accuracy behöver vara mellan 1 - 100
        if (accuracy < 1 || accuracy > 100){
            throw new IllegalArgumentException("Accuracy must be between 1 - 100");
        }

        //En attack behöver en element
        if (element == null){
            throw new IllegalArgumentException("An Attack needs an Element!");
        }

        this.name = name;
        this.baseDamage = baseDamage;
        this.accuracy = accuracy;
        this.element = element;
    }

    //Metoder för att göra det möjligt för andra..
    // klasser att läsa Attack-objektets privata värden
    public String getName(){
        return name;
    }

    public int getBaseDamage(){
        return baseDamage;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public Element getElement() {
        return element;
    }
}
