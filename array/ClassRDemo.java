class Person {
    private String name;
    private int age;
    private Car car;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return this.car;
    }

    /**
     * @return int return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println(this.name + ", " + this.age + this.car.getBand());
    }

}

class Car {
    private String band;
    private Person person;

    Car(String band) {
        this.band = band;
    }

    /**
     * @return String return the band
     */
    public String getBand() {
        return band;
    }

    /**
     * @param band the band to set
     */
    public void setBand(String band) {
        this.band = band;
    }

    /**
     * @return Person return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    public void show() {
        System.out.println(this.band + ", " + this.person.getName());
    }
}

public class ClassRDemo {
    public static void main(String[] args) {
        Person p = new Person("Json", 30);
        Car c = new Car("a car");
        p.setCar(c);
        c.setPerson(p);
        p.show();
        c.show();
    }
}
