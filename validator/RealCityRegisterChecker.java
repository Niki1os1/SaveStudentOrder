package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.exception.TransportException;
import edu.javacourse.studentorder.register.CityRegisterResponse;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.exception.CityRegisterException;

public class RealCityRegisterChecker implements CityRegisterChecker{
    public CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException, TransportException {

        return null;
    }
}
