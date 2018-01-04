package com.david.study.InterfaceSample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.david.study.Interface.AuthCheckFactory;

@SpringBootApplication
public class InterfaceSampleApplication {

	private static String[] name = { "com.david.study.Factory.ExpireDateAuthCheckFactory",
			"com.david.study.Factory.PINAuthCheckFactory" };

	// private static final Map<String, Class<?>> test = new HashMap<String,
	// Class<?>>();
	public static AuthCheckFactory instance;
	// public static FactoryProxy factoryproxy = new FactoryProxy();

	public static void main(String[] args) {
		SpringApplication.run(InterfaceSampleApplication.class, args);

		ClassLoader classLoader = InterfaceSampleApplication.class.getClassLoader();

		System.out.println("------ Start --------");
		for (int i = 0; i < name.length; i++) {
			try {
				// System.out.println("FactoryClass:"+ name[i]);
				instance = (AuthCheckFactory) Class.forName(name[i], true, classLoader).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			instance.getAuthCheckItem().execute();
			System.out.println("");

		}
		System.out.println("------ End   --------");

		/*
		 * Animal cat = null;
		 * 
		 * try { cat = new Animal("MiaoMiao", -3); } catch (AnimalAgeException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */

	}

}


