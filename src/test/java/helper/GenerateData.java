package helper;

import net.datafaker.Faker;

public class GenerateData {
    private  Faker faker = new Faker();
    public GenerateData(){

    }
    public String fullName(){
        return faker.name().fullName();
    }
    public  String country(){
        return faker.country().name();
    }
    public  String city(){
        return faker.address().city();
    }
    public  String creditCard(){
        return faker.finance().creditCard();
    }

}
