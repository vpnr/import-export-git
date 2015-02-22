package org.sculptor.example.ejb.helloworld.milkyway.serviceapi;

import static org.junit.Assert.assertEquals;

import javax.ejb.EJB;

import org.junit.Test;
import org.sculptor.example.ejb.helloworld.milkyway.serviceapi.PlanetFacade;
import org.sculptor.example.ejb.helloworld.milkyway.serviceapi.PlanetFacadeTestBase;
import org.sculptor.framework.test.AbstractOpenEJBDbUnitTest;

/**
 * JUnit test with OpenEJB support.
 */
public class PlanetFacadeTest extends AbstractOpenEJBDbUnitTest implements PlanetFacadeTestBase {

	@EJB
	private PlanetFacade planetFacadeRemote;

	@Test
	public void testSayHello() throws Exception {
		assertEquals("Hello", planetFacadeRemote.sayHello(getServiceContext()));
	}
}
