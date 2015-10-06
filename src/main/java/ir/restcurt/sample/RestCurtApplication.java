package ir.restcurt.sample;/*
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

import ir.restcurt.sample.handler.PersonResource;
import ir.restcurt.RestCurt;

/**
 * @author Hamid Samani
 */
public class RestCurtApplication {
    public static void main(String[] args) {

        //just declare your resources as run method argument to RESTCurt creates your mappings.
        RestCurt.run(PersonResource.class);
    }
}
