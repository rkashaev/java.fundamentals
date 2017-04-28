package courses.lesson9;

public class CloneableTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human human = new Human(10, "Richard");
        System.out.println(human);

        Human humanClone = human.clone();

        System.out.println(humanClone);

        System.out.println(human == humanClone);

        System.out.println(human.name == humanClone.name);
    }
}

class Human implements Cloneable {
    int age;
    String name;

    public Human(int age) {
        this.age = age;
    }

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Human clone() throws CloneNotSupportedException {
        Human clone = (Human) super.clone();
        clone.name = new String(clone.name);
        return clone;
    }
}