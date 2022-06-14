package org.rest.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.rest.bean.Address;
import org.rest.bean.Student;

import java.io.File;

public class DemoApp {
    public static void main(String[] args) {
        try{

            //creating objectMapper
            ObjectMapper mapper = new ObjectMapper();

            //reading json file using mapper
            Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);

            //printing data
            System.out.println("First name = "+student.getFirstName());
            System.out.println("Last Name = "+student.getLastName());

            Address address = student.getAddress();
            System.out.println(" Street = "+ address.getStreet());
            System.out.println(" City = "+ address.getCity());
            System.out.println(" State = "+ address.getState());
            System.out.println(" Zip = "+ address.getZip());
            System.out.println(" Country = "+ address.getCountry());

            for (String language : student.getLanguages()){
                System.out.println("Language = "+language);
            }
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
