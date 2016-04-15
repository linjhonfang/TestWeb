package com.testweb.testDubbo;

import org.springframework.stereotype.Service;


@Service("testRegistryService1")
public class TestRegitstryServiceImpl implements TestRegitstryService{

	@Override
	  public String sayHello(String name) {
        return "Hello " + name;
    }
 

}
