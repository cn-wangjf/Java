package cn.wangjf.java.jmx;

public class Controller implements ControllerMBean {

	public void setName(String name) {  
        this.name = name;  
    }  
  
    public String getName() {  
        return this.name;  
    }  
      
    private String name;  
  
    private int value;
    
    public String status() {  
        return "this is a Controller MBean,name is " + this.name;  
    }  
  
    public void start() {  
    }  
  
  
    public void stop() {  
    }  
    
    public int add(int a, int b) {
    	return a + b;
    }
    
    public void addAndSet(int a, int b) {
    	this.value = a + b;
    }

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
    
    
}
