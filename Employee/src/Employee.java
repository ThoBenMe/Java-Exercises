public class Employee {


    private float monatsgehalt;
    private String name;

    public Employee(float monatsgehalt, String name){
       this(name);
       this.monatsgehalt = monatsgehalt;
    }

    public Employee(String name){
        this.name = name;
    }

    public void setMonatsgehalt(float monatsgehalt) {
        if(monatsgehalt <= 0 || monatsgehalt >= 50000){
            System.out.println("Unvalid amount! monatsgehalt has to be between 0 and 50000!\n");
            return;
        } else {
            this.monatsgehalt = monatsgehalt;
        }
    }

    public float getMonatsgehalt(){
        return monatsgehalt;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "Mitarbeiter: " + name + ", Gehalt: " + monatsgehalt + ".\n";
    }

}
