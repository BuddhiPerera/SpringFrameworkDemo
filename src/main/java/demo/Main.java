package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.print.Doc;

public class Main {
    public static void main(String[] args) {

//        // basic way of instantiating
//        Doctor doctor = new Doctor();

        // using xml configuration for dependency injection
        // provide the xml config file in the classpath
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        // getting the beans from spring.xml file
        Doctor doctor = applicationContext.getBean(Doctor.class);
        doctor.assist();

        Nurse nurse = applicationContext.getBean(Nurse.class);
        nurse.assist();

        // can also do it like this
        // has to cast it into the required type since it requesting for the object
        // provides --> class       cast --> object
        Nurse nurse1 = (Nurse) applicationContext.getBean("nurse");
        nurse1.assist();

        // using the interface
        Staff staff = applicationContext.getBean(Doctor.class);
        staff.assist();

    }
}
