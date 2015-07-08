package com.bigdinosar.security.filter;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

public class AuthResponseFilter implements ContainerResponseFilter {

	public ContainerResponse filter(ContainerRequest paramContainerRequest,
			ContainerResponse paramContainerResponse) {
		System.out.println("jersey response filter ");
		return paramContainerResponse;
	}

}
