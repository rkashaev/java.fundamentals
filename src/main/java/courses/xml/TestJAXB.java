package courses.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;

/**
 * Created by Zstudent on 6/6/2017.
 */
public class TestJAXB {
    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Food.class);
        Marshaller m = context.createMarshaller();

        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        Food food = new Food();
        food.setId(123);
        food.setName("nnn");
        food.setDescription("ddd");
        food.setCalories(234);
        food.setPrice("333");

        m.marshal(food, new FileOutputStream("stud.xml"));
        m.marshal(food, System.out);// на консоль
        System.out.println("XML-файл создан");

    }
}
