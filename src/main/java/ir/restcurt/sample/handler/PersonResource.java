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


package ir.restcurt.sample.handler;

import ir.restcurt.sample.exception.PersonNotFoundException;
import ir.restcurt.route.builder.ExceptionHandlerBuilder;
import ir.restcurt.route.builder.RouteBuilder;
import ir.restcurt.route.handler.AbstractRouteHandler;
import ir.restcurt.sample.repository.PersonRepository;

/**
 * @author Hamid Samani
 */
public class PersonResource extends AbstractRouteHandler {

    private PersonRepository repository = new PersonRepository();

    @Override
    public void route(RouteBuilder route) {
        route
                .get("/persons", (req, res) -> res.toJson(repository.findAll()))
                .get("/persons/:id", (req, res) -> res.toJson(repository.findOne(req.variable("id"))))
                .post("/persons", (req, res) -> res.toJson(repository.save(req.param("id"), req.param("name"))));
    }

    @Override
    public void exception(ExceptionHandlerBuilder exception) {
        exception
                .exception(PersonNotFoundException.class, (req, res) -> res.toJson("person not found!"));
    }
}
