package com.stdust.urlManager.service;

import com.stdust.urlManager.model.Person;
import com.stdust.urlManager.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    private final PeopleRepository peopleRepository;
//    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
//        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(Person person) {
//        person.setPassword(passwordEncoder.encode(person.getPassword()));
//        person.setRole("ROLE_USER");
        peopleRepository.save(person);
    }
}