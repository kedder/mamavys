/*
 * Copyright 2008 Kindleit Technologies. All rights reserved. This file, all
 * proprietary knowledge and algorithms it details are the sole property of
 * Kindleit Technologies unless otherwise specified. The software this file
 * belong with is the confidential and proprietary information of Kindleit
 * Technologies. ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with Kindleit.
 */


package lt.sklandymas.mamavys.web;

import lt.sklandymas.mamavys.repository.PersonRepository;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.spring.injection.annot.SpringBean;


public class HomePage extends BasePage {	
	@SpringBean
	private PersonRepository personRepository;

	public HomePage() {
		personRepository.findAll();
		add(new Label("hello", "Hello World2"));
	}

}
