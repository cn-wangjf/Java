package cn.wangjf.java.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface PersonService extends Remote { //远程对象调用的接口，必须继承Remote类

	 public List<PersonEntity> GetList() throws RemoteException;  
}
