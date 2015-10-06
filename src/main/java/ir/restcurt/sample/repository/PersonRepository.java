/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ir.restcurt.sample.repository;

import ir.restcurt.sample.domain.Person;
import ir.restcurt.sample.exception.PersonNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hamid Samani
 */
public class PersonRepository {
    private Map<String, Person> persons = new HashMap<>();

    public PersonRepository() {
        for (int i = 0; i <= 100; i++) {
            persons.put(String.valueOf(i), new Person(String.valueOf(i), "person " + i));
        }
    }

    public Person findOne(String id) {
        if (persons.get(id) != null) {
            return persons.get(id);
        }
        throw new PersonNotFoundException(String.format("person not found %s", id));
    }

    public Person save(String id, String name) {
        Person p = new Person(id, name);
        persons.put(id, p);
        return p;
    }

    public List<Person> findAll() {
        return new ArrayList<>(persons.values());
    }
}
