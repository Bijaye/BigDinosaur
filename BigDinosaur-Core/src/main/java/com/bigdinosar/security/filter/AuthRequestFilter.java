package com.bigdinosar.security.filter;


import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

public class AuthRequestFilter implements ContainerRequestFilter {

//    @Override
    public ContainerRequest filter(ContainerRequest arg0) {
    	System.out.println(" input of jersey filter");
       
        
        return arg0;
    }
}
