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

        Doctor doctor = applicationContext.getBean(Doctor.class);
        doctor.assist();

        Nurse nurse = applicationContext.getBean(Nurse.class);
        nurse.assist();

        // can also do it like this
        // have to cast it into the required type since it requesting for the object
        // provides --> class       cast --> object
        Nurse nurse1 = (Nurse) applicationContext.getBean("nurse");
    }
}
