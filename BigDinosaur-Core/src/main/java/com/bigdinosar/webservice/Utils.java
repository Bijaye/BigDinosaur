/**
 *       Copyright 2010 Newcastle University
 *
 *          http://research.ncl.ac.uk/smart/
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bigdinosar.webservice;

import org.apache.oltu.oauth2.common.OAuthProviderType;

/**
 *
 *
 *
 */
public final class Utils {
    private Utils() {
    }

    public static final String REDIRECT_URI = "http://localhost:8080/Big-Dinosaur/api/redirect";
    public static final String DISCOVERY_URI = "http://localhost:8080";

    public static final String REG_TYPE_PULL = "pull";
    public static final String REG_TYPE_PUSH = "push";
    
    public static final String REQUEST_TYPE_QUERY= "queryParameter";
    public static final String REQUEST_TYPE_HEADER= "headerField";
    public static final String REQUEST_TYPE_BODY= "bodyParameter";

    public static final String GENERIC = "generic"; 
    
   


    
    public static final String BigDinosaur_AUTHZ = "http://localhost:8080/Big-Dinosaur/api/authz";
    public static final String BigDinosaur_TOKEN = "http://localhost:8080/Big-Dinosaur/api/token";
    public static final String BigDinosaur_REGISTER = "http://localhost:8080/Big-Dinosaur/api/register";
    public static final String BigDinosaur_AUTHZ_SPRING = "http://localhost:8090/BigDinosaur-Resource/springauthendpoint";
    public static final String BigDinosaur_AUTHZ_TOKEN_SPRING = "http://localhost:8090/BigDinosaur-Resource/springtokenendpoint";
    public static final String BigDinosaur_AUTHZ_TOKEN_SPRING_CODE ="http://localhost:8090/BigDinosaur-Resource/springcode";
   	public static final String BigDinosaur_AUTHZ_TOKEN_SPRING_CLIENTCRIDENTAILS ="http://localhost:8090/BigDinosaur-Resource/springclientcridentails";
   	public static final String BigDinosaur_AUTHZ_TOKEN_SPRINGIMPLICT ="http://localhost:8080/BigDinosaur-Resource/springimplict";
   	public static final String BigDinosaur_AUTHZ_TOKEN_REFRESHTOKEN = "http://localhost:8090/BigDinosaur-Resource/springrefreshtoken";
   	public static final String BigDinosaur_AUTHZ_TOKEN_CLIENTIDSECRET = "http://localhost:8090/BigDinosaur-Resource/springtokenclientid";
   	
   	public static final String BigDinosaur_AUTHZ_TOKEN_SPRINGIMPLICT_MyDIMPLE ="http://localhost:8090/BigDinosaur-Resource/springimplictmydimple"; 
    		  
    

   
}
