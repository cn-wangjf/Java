package cn.wangjf.java.jmx;

public interface ControllerMBean {

	
	/*
	 * 管理构件(Managed Bean)，简称MBean。
	 * 
	 * 根据约定，MBean的命名必须以 MBean结尾
	 * 
	 */
	
	/*
	 * 定义属性
	 * 
	 * MBean中有getter和setter的就是属性，如果只有getter则表示该属性只读。
	 * 
	 */
	
	
	public void setName(String name);

	public String getName();
	
	public int getValue();
	

	/*
	 * 定义操作
	 * 
	 * 可以通过jconsole调用，用户清空缓存、重新加载配置文件等
	 * 	
	 */
	
	
	public String status();

	public void start();

	public void stop();
	
	public int add(int a, int b);
	
	public void addAndSet(int a, int b);
	

}
