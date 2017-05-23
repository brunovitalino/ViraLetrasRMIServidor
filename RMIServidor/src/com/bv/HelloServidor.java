package com.bv;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.lang.SecurityManager; // OBSOLETA =>java.RMI.RMISecurityManager
import java.rmi.server.UnicastRemoteObject;

/* 
	Classname: HelloServidor 
	Descricao: Servidor RMI. 
*/
public class HelloServidor extends UnicastRemoteObject implements Hello
{
	public HelloServidor() throws RemoteException
	{ 
		super(); 
	} 
	public String Saudacao() { 
		System.out.println("Metodo Saudacao invocado com sucesso!"); 
		return "Ola Mundo do servidor RMI!"; 
	} 
	public static void main(String args[])
	{
		String appName = "HelloWorld";
		String endereco = "127.0.0.1";
		int porta = 1099;
		
		try
		{
			// Cria um objeto da classe HelloServer. 
			HelloServidor obj = new HelloServidor(); 

			// REGISTRO
			
			//Forma 1 - NAO FUNCIONOU :(
			//Naming.rebind("rmi//"+endereco+":"+Integer.toString(porta)+"/"+appName, obj);	
			
			//Forma 2 - FUNCIONOU =D
			Registry registro = LocateRegistry.createRegistry(porta);
			// Vincula a instancia desse objeto ao nome do aplicativo ("appName"). 
			Naming.rebind("rmi:/"+endereco+"/"+appName, obj);			

			System.out.println("Servidor registrado! ONLINE!"); 
		} 
		catch (Exception e)
		{
			System.out.println("ERRO: " + e.getMessage()); 
			e.printStackTrace(); 
		}
	}
}
