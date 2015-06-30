package cn.wangjf.java.jmx;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.swing.JDialog;

public class Main {

	public static void main(String[] args) throws InstanceAlreadyExistsException, MBeanRegistrationException,
			NotCompliantMBeanException, MalformedObjectNameException, NullPointerException {
		
		// 获得MBeanServer实例 可在jconsole中使用
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		// 创建MBean
		Controller controller = new Controller();
		// 将MBean注册到MBeanServer中
		mbs.registerMBean(controller, new ObjectName("MyappMBean:name=controller"));

		// 由于是为了演示保持程序处于运行状态，创建一个图形窗口
		javax.swing.JDialog dialog = new JDialog();
		dialog.setName("jmx test");
		dialog.setVisible(true);
	}
}
