package net.sf.freecol.client.gui;

import javax.swing.ImageIcon;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>ChoiceItemTest</code> contains tests for the class <code>{@link ChoiceItem}</code>.
 *
 * @generatedBy CodePro at 5/17/16 8:23 PM
 * @author user
 * @version $Revision: 1.0 $
 */
public class ChoiceItemTest {
	/**
	 * Run the ChoiceItem(T) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testChoiceItem_1()
		throws Exception {

		ChoiceItem result = new ChoiceItem(null);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at net.sf.freecol.client.gui.ChoiceItem.<init>(ChoiceItem.java:79)
		assertNotNull(result);
	}

	/**
	 * Run the ChoiceItem(T) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testChoiceItem_2()
		throws Exception {

		ChoiceItem result = new ChoiceItem(null);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at net.sf.freecol.client.gui.ChoiceItem.<init>(ChoiceItem.java:79)
		assertNotNull(result);
	}

	/**
	 * Run the ChoiceItem(T) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testChoiceItem_3()
		throws Exception {

		ChoiceItem result = new ChoiceItem(null);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at net.sf.freecol.client.gui.ChoiceItem.<init>(ChoiceItem.java:79)
		assertNotNull(result);
	}

	/**
	 * Run the ChoiceItem(T) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testChoiceItem_4()
		throws Exception {

		ChoiceItem result = new ChoiceItem(null);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at net.sf.freecol.client.gui.ChoiceItem.<init>(ChoiceItem.java:79)
		assertNotNull(result);
	}

	/**
	 * Run the ChoiceItem(String,T) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testChoiceItem_5()
		throws Exception {
		String text = "";

		ChoiceItem result = new ChoiceItem(text, null);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getIcon());
		assertEquals(false, result.isOK());
		assertEquals(false, result.isCancel());
		assertEquals("", result.toString());
		assertEquals(null, result.getObject());
		assertEquals(true, result.isDefault());
		assertEquals(true, result.isEnabled());
	}

	/**
	 * Run the ChoiceItem(String,T,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testChoiceItem_6()
		throws Exception {
		String text = "";
		boolean enable = true;

		ChoiceItem result = new ChoiceItem(text, null, enable);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getIcon());
		assertEquals(false, result.isOK());
		assertEquals(false, result.isCancel());
		assertEquals("", result.toString());
		assertEquals(null, result.getObject());
		assertEquals(true, result.isDefault());
		assertEquals(true, result.isEnabled());
	}

	/**
	 * Run the ChoiceItem<Object> cancelOption() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testCancelOption_1()
		throws Exception {
		ChoiceItem fixture = ChoiceItemFactory.createChoiceItem();

		ChoiceItem<Object> result = fixture.cancelOption();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChoiceItemFactory
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
	 * Run the int compareTo(ChoiceItem<T>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testCompareTo_1()
		throws Exception {
		ChoiceItem fixture = ChoiceItemFactory.createChoiceItem();
		ChoiceItem<Object> other = ChoiceItemFactory.createChoiceItem();

		int result = fixture.compareTo(other);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChoiceItemFactory
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
		assertEquals(0, result);
	}

	/**
	 * Run the int compareTo(ChoiceItem<T>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testCompareTo_2()
		throws Exception {
		ChoiceItem fixture = ChoiceItemFactory.createChoiceItem();
		ChoiceItem<Object> other = ChoiceItemFactory.createChoiceItem();

		int result = fixture.compareTo(other);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChoiceItemFactory
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
		assertEquals(0, result);
	}

	/**
	 * Run the ChoiceItem<Object> defaultOption() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testDefaultOption_1()
		throws Exception {
		ChoiceItem fixture = ChoiceItemFactory.createChoiceItem();

		ChoiceItem<Object> result = fixture.defaultOption();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChoiceItemFactory
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
	 * Run the int getChoice() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testGetChoice_1()
		throws Exception {
		ChoiceItem fixture = ChoiceItemFactory.createChoiceItem();

		int result = fixture.getChoice();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChoiceItemFactory
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
		assertEquals(0, result);
	}

	/**
	 * Run the ImageIcon getIcon() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testGetIcon_1()
		throws Exception {
		ChoiceItem fixture = ChoiceItemFactory.createChoiceItem();

		ImageIcon result = fixture.getIcon();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChoiceItemFactory
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
	 * Run the Object getObject() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testGetObject_1()
		throws Exception {
		ChoiceItem fixture = ChoiceItemFactory.createChoiceItem();

		Object result = fixture.getObject();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChoiceItemFactory
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
	 * Run the boolean isCancel() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testIsCancel_1()
		throws Exception {
		ChoiceItem fixture = ChoiceItemFactory.createChoiceItem();

		boolean result = fixture.isCancel();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChoiceItemFactory
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
	 * Run the boolean isCancel() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testIsCancel_2()
		throws Exception {
		ChoiceItem fixture = ChoiceItemFactory.createChoiceItem();

		boolean result = fixture.isCancel();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChoiceItemFactory
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
	 * Run the boolean isDefault() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testIsDefault_1()
		throws Exception {
		ChoiceItem fixture = ChoiceItemFactory.createChoiceItem();

		boolean result = fixture.isDefault();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChoiceItemFactory
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
	 * Run the boolean isDefault() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testIsDefault_2()
		throws Exception {
		ChoiceItem fixture = ChoiceItemFactory.createChoiceItem();

		boolean result = fixture.isDefault();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChoiceItemFactory
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
	 * Run the boolean isEnabled() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testIsEnabled_1()
		throws Exception {
		ChoiceItem fixture = ChoiceItemFactory.createChoiceItem();

		boolean result = fixture.isEnabled();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChoiceItemFactory
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
	 * Run the boolean isEnabled() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testIsEnabled_2()
		throws Exception {
		ChoiceItem fixture = ChoiceItemFactory.createChoiceItem();

		boolean result = fixture.isEnabled();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChoiceItemFactory
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
	 * Run the boolean isOK() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testIsOK_1()
		throws Exception {
		ChoiceItem fixture = ChoiceItemFactory.createChoiceItem();

		boolean result = fixture.isOK();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChoiceItemFactory
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
	 * Run the boolean isOK() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testIsOK_2()
		throws Exception {
		ChoiceItem fixture = ChoiceItemFactory.createChoiceItem();

		boolean result = fixture.isOK();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChoiceItemFactory
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
	 * Run the ChoiceItem<Object> okOption() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testOkOption_1()
		throws Exception {
		ChoiceItem fixture = ChoiceItemFactory.createChoiceItem();

		ChoiceItem<Object> result = fixture.okOption();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChoiceItemFactory
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
	 * Run the ChoiceItem<Object> setIcon(ImageIcon) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testSetIcon_1()
		throws Exception {
		ChoiceItem fixture = ChoiceItemFactory.createChoiceItem();
		ImageIcon icon = new ImageIcon();

		ChoiceItem<Object> result = fixture.setIcon(icon);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChoiceItemFactory
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
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	@Test
	public void testToString_1()
		throws Exception {
		ChoiceItem fixture = ChoiceItemFactory.createChoiceItem();

		String result = fixture.toString();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassNotFoundException: net.sf.freecol.client.gui.ChoiceItemFactory
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
	 * @generatedBy CodePro at 5/17/16 8:23 PM
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
	 * @generatedBy CodePro at 5/17/16 8:23 PM
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
	 * @generatedBy CodePro at 5/17/16 8:23 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ChoiceItemTest.class);
	}
}