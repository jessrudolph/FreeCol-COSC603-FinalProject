package net.sf.freecol.client.gui;

import java.awt.Color;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>GUIMessageTest</code> contains tests for the class <code>{@link GUIMessage}</code>.
 *
 * @generatedBy CodePro at 5/17/16 8:57 PM
 * @author user
 * @version $Revision: 1.0 $
 */
public class GUIMessageTest {
	/**
	 * Run the GUIMessage(String,Color) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:57 PM
	 */
	@Test
	public void testGUIMessage_1()
		throws Exception {
		String message = "";
		Color color = new Color(1);

		GUIMessage result = new GUIMessage(message, color);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1463543870946L, result.getCreationTime());
		assertEquals("", result.getMessage());
	}

	/**
	 * Run the Color getColor() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:57 PM
	 */
	@Test
	public void testGetColor_1()
		throws Exception {
		GUIMessage fixture = GUIMessageFactory.createGUIMessage2();

		Color result = fixture.getColor();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.GUIMessageFactory
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:550)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Run the long getCreationTime() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:57 PM
	 */
	@Test
	public void testGetCreationTime_1()
		throws Exception {
		GUIMessage fixture = GUIMessageFactory.createGUIMessage();

		long result = fixture.getCreationTime();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.GUIMessageFactory
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:550)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertEquals(0L, result);
	}

	/**
	 * Run the String getMessage() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:57 PM
	 */
	@Test
	public void testGetMessage_1()
		throws Exception {
		GUIMessage fixture = GUIMessageFactory.createGUIMessage();

		String result = fixture.getMessage();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.GUIMessageFactory
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:550)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/17/16 8:57 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 5/17/16 8:57 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 5/17/16 8:57 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(GUIMessageTest.class);
	}
}