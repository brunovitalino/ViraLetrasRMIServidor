package com.bv;

import java.rmi.Remote;
import java.rmi.RemoteException;

/* 
	Classname: Hello 
	Descricao: Interface remota. 
*/
public interface Hello extends Remote
{
	String Saudacao() throws RemoteException; 
}