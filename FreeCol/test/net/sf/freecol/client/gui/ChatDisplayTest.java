package net.sf.freecol.client.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>ChatDisplayTest</code> contains tests for the class <code>{@link ChatDisplay}</code>.
 *
 * @generatedBy CodePro at 5/17/16 7:24 PM
 * @author user
 * @version $Revision: 1.0 $
 */
public class ChatDisplayTest {
	/**
	 * Run the ChatDisplay() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 7:24 PM
	 */
	@Test
	public void testChatDisplay_1()
		throws Exception {

		ChatDisplay result = new ChatDisplay();

		// add additional test code here
		assertNotNull(result);
		assertEquals(false, result.removeOldMessages());
	}

	/**
	 * Run the void addMessage(GUIMessage) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 7:24 PM
	 */
	@Test
	public void testAddMessage_1()
		throws Exception {
		ChatDisplay fixture = ChatDisplayFactory.createChatDisplay();
		GUIMessage message = new GUIMessage("", new Color(1));

		fixture.addMessage(message);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChatDisplayFactory
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
	}

	/**
	 * Run the void addMessage(GUIMessage) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 7:24 PM
	 */
	@Test
	public void testAddMessage_2()
		throws Exception {
		ChatDisplay fixture = ChatDisplayFactory.createChatDisplay();
		GUIMessage message = new GUIMessage("", new Color(1));

		fixture.addMessage(message);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChatDisplayFactory
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
	}

	/**
	 * Run the void display(Graphics2D,ImageLibrary,Dimension) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 7:24 PM
	 */
	@Test
	public void testDisplay_1()
		throws Exception {
		ChatDisplay fixture = ChatDisplayFactory.createChatDisplay();
		BufferedImage image = new BufferedImage(8, 8, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		ImageLibrary lib = new ImageLibrary(1.0f);
		Dimension size = new Dimension();
		size.height = 1;
		size.width = 1;

		fixture.display(g, lib, size);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChatDisplayFactory
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:550)
		//       at com.instantiations.eclipse.analysis.expression.model.ExpressionSequence.execute(ExpressionSequence.java:311)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
	}

	/**
	 * Run the void display(Graphics2D,ImageLibrary,Dimension) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 7:24 PM
	 */
	@Test
	public void testDisplay_2()
		throws Exception {
		ChatDisplay fixture = ChatDisplayFactory.createChatDisplay();
		BufferedImage image = new BufferedImage(8, 8, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		ImageLibrary lib = new ImageLibrary(1.0f);
		Dimension size = new Dimension();
		size.height = 1;
		size.width = 1;

		fixture.display(g, lib, size);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChatDisplayFactory
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:550)
		//       at com.instantiations.eclipse.analysis.expression.model.ExpressionSequence.execute(ExpressionSequence.java:311)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
	}

	/**
	 * Run the void display(Graphics2D,ImageLibrary,Dimension) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 7:24 PM
	 */
	@Test
	public void testDisplay_3()
		throws Exception {
		ChatDisplay fixture = ChatDisplayFactory.createChatDisplay();
		BufferedImage image = new BufferedImage(8, 8, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		ImageLibrary lib = new ImageLibrary(1.0f);
		Dimension size = new Dimension();
		size.height = 1;
		size.width = 0;

		fixture.display(g, lib, size);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChatDisplayFactory
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:550)
		//       at com.instantiations.eclipse.analysis.expression.model.ExpressionSequence.execute(ExpressionSequence.java:311)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
	}

	/**
	 * Run the void display(Graphics2D,ImageLibrary,Dimension) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 7:24 PM
	 */
	@Test
	public void testDisplay_4()
		throws Exception {
		ChatDisplay fixture = ChatDisplayFactory.createChatDisplay();
		BufferedImage image = new BufferedImage(8, 8, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		ImageLibrary lib = new ImageLibrary(1.0f);
		Dimension size = new Dimension();
		size.height = 1;
		size.width = 0;

		fixture.display(g, lib, size);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChatDisplayFactory
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:550)
		//       at com.instantiations.eclipse.analysis.expression.model.ExpressionSequence.execute(ExpressionSequence.java:311)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
	}

	/**
	 * Run the void display(Graphics2D,ImageLibrary,Dimension) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 7:24 PM
	 */
	@Test
	public void testDisplay_5()
		throws Exception {
		ChatDisplay fixture = ChatDisplayFactory.createChatDisplay();
		BufferedImage image = new BufferedImage(8, 8, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		ImageLibrary lib = new ImageLibrary();
		Dimension size = new Dimension();

		fixture.display(g, lib, size);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChatDisplayFactory
		//       at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
		//       at com.instantiations.assist.eclipse.junit.execution.core.UserDefinedClassLoader.loadClass(UserDefinedClassLoader.java:62)
		//       at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionContextImpl.getClass(ExecutionContextImpl.java:99)
		//       at com.instantiations.eclipse.analysis.expression.model.SimpleTypeExpression.execute(SimpleTypeExpression.java:205)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:544)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:550)
		//       at com.instantiations.eclipse.analysis.expression.model.ExpressionSequence.execute(ExpressionSequence.java:311)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
	}

	/**
	 * Run the boolean removeOldMessages() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 7:24 PM
	 */
	@Test
	public void testRemoveOldMessages_1()
		throws Exception {
		ChatDisplay fixture = ChatDisplayFactory.createChatDisplay();

		boolean result = fixture.removeOldMessages();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChatDisplayFactory
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
		assertTrue(result);
	}

	/**
	 * Run the boolean removeOldMessages() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 7:24 PM
	 */
	@Test
	public void testRemoveOldMessages_2()
		throws Exception {
		ChatDisplay fixture = ChatDisplayFactory.createChatDisplay();

		boolean result = fixture.removeOldMessages();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChatDisplayFactory
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
		assertTrue(result);
	}

	/**
	 * Run the boolean removeOldMessages() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 7:24 PM
	 */
	@Test
	public void testRemoveOldMessages_3()
		throws Exception {
		ChatDisplay fixture = ChatDisplayFactory.createChatDisplay();

		boolean result = fixture.removeOldMessages();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChatDisplayFactory
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
		assertTrue(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/17/16 7:24 PM
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
	 * @generatedBy CodePro at 5/17/16 7:24 PM
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
	 * @generatedBy CodePro at 5/17/16 7:24 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ChatDisplayTest.class);
	}
}