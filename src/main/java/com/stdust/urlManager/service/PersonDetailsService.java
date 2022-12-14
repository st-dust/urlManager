package com.stdust.urlManager.service;

import com.stdust.urlManager.model.Person;
import com.stdust.urlManager.repositories.PeopleRepository;
import com.stdust.urlManager.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepository.findByUsername(username);

        if (person.isEmpty()) {
            throw new UsernameNotFoundException("User was not not found!");
        }

        return new PersonDetails(person.get());
    }

    public List<Person> findAll() {
        return peopleRepository.findByOrderByPersonIdAsc();
    }

    public Person findById(int id) {
        Optional<Person> foundTile = peopleRepository.findById(id);
        return foundTile.orElse(null);
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }

    @Transactional
    public void setAsAdmin(Person person) {
        person.setRole("ROLE_ADMIN");
        peopleRepository.save(person);
    }

    @Transactional
    public void setAsUser(Person person) {
        person.setRole("ROLE_USER");
        peopleRepository.save(person);
    }

    @Transactional
    public Person getPersonInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        return personDetails.getPerson();
    }
}
