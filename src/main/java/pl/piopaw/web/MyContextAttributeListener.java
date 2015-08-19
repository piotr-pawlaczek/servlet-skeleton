package pl.piopaw.web;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyContextAttributeListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("Attribute added: " + event.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("Attribute removed: " + event.getValue());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("Attribute replaced: " + event.getValue());
		System.out.println("Current attribute: " + event.getServletContext().getAttribute(event.getName()));
	}

}
