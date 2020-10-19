/**
 * Ch3. p 176 Algorithm Workbench 1
 */
public class Pet {
    private String name;
    private String animal;
    private int age;

    public Pet(String newName, String newAnimal, int newAge) {
        name = newName;
        animal = newAnimal;
        age = newAge;
    }
    public void setName(String newName){ name = newName; }
    public void setAnimal(String newAnimal){ animal = newAnimal; }
    public void setAge(int newAge){ age = newAge; }
    public String getName(){ return name; }
    public String getAnimal(){ return animal; }
    public int getAge(){ return age; }
}
