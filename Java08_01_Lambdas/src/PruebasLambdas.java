import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.swing.JButton;

public class PruebasLambdas {
	
	private static void insertar() {
		System.out.println("do nothing");
	}
	
	private static void insertar(String text) {
		System.out.println(text);
	}
	
	public static void main(String[] args) {
		
		//
		//Cases internas anónimas
		//
		
		JButton boton = new JButton("Dale");		
		
		//Definiendo el oyente con una clase interna anónima
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botón pulsado desde variable de clase anónima");
			}
		};
		boton.addActionListener(al);

		//Igual, pero sin usar una variable intermedia
		JButton boton2 = new JButton("Dale otra vez");
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botón pulsado desde clase anónima creada al vuelo");
			}
		});
		
		
		JButton boton3 = new JButton();
		// Referencia a método definido en la propia clase
		ActionListener oyenteBotonInsertar1 = (ActionEvent e) -> insertar(e.getActionCommand());
		// ActionListener oyenteBotonInsertar2 = (ActionEvent e) -> System.out.println(e.getActionCommand());
		boton3.addActionListener(oyenteBotonInsertar1);
		ActionListener oyenteBotonInsertar2 = e -> insertar();
		boton3.addActionListener(oyenteBotonInsertar2);
			
		//Mejor todavía (sin variable):
		boton3.addActionListener( e -> insertar() );
		
		
		
		//
		//Expresiones lambda
		//

		Consumer<String> lambdaConsumer = (String x) -> System.out.println(x);
		Consumer<String> lambdaConsumer2 = x -> { System.out.println(x); };
		
		Supplier<String> lambdaProveedor = () -> "Ejemplo de Proveedor";
		Supplier<String> lambdaProveedor1 = () -> { return "Ejemplo de Proveedor con llaves y return"; };
		Supplier<Integer> lambdaProveedor2 = () -> Integer.valueOf(1);
		IntSupplier lambdaProveedor3 = () -> Integer.valueOf(2);
		
		Function<String, String> lambdaFunction = (String x) -> x.toUpperCase();
		
		Function<String, Boolean> lambdaFunction2 = (String x) -> Objects.nonNull(x);
		
		Predicate<String> lambdaPredicate = (String x) -> Objects.nonNull(x);
//		
//		
//		
//		
//		
//		
//		//
//		//EXPRESIONES LAMBDA
//		//	
//		
//		//interface Reloj{
//		//	public void decirHora();
//		//}		
		System.out.println("========================");
		Reloj r1 = new Reloj() {
			public void decirHora() {
				System.out.println(new Date());
			}
		};
		r1.decirHora();
		
		//Cuando el método no recibe parámetros los parentesis son obligatorios
		//Cuando el metodo solo tiene una línea nos podemos ahorrar las llaves del método		
		Reloj r2 = () -> System.out.println(new Date());
		r2.decirHora();			

		//interface Saludador{
		//	public void saludar(String nombre);
		//}
		System.out.println("========================");
		Saludador s1 = new Saludador() {
			public void saludar(String nombre) {
				System.out.println("Hola "+nombre);
			}
		};		
		s1.saludar("Luis Ramón");
		
		//Cuando el método recibe un único parámetro se pueden quitar los parentesis
		Saludador s2 = nombre -> System.out.println("Hola "+nombre);
		s2.saludar("Luis Ramón");

		//interface Calculador{
		//	public void calcular(Double n1, Double n2);
		//}		
		System.out.println("========================");
		Calculador c1 = new Calculador() {
			public void calcular(Double n1, Double n2) {
				System.out.println(n1+n2);
			}
		};
		c1.calcular(25d, 500d);

		//Cuando se recibe más de un parámetro los parentesis vuelven a ser obligatorios
		Calculador c2 = (n1, n2) -> System.out.println(n1+n2);
		c2.calcular(25d, 500d);

		//interface Formateador{
		//	public String formatear(String dato1, String dato2);
		//}
		System.out.println("========================");
		Formateador f1 = new Formateador() {
			public String formatear(String dato1, String dato2) {
				return dato1+"+"+dato2;
			}
		};		
		System.out.println(f1.formatear("aaa", "bbb"));
		
		//Cuando quitamos las llaves del método el return es IMPLÍCITO
		Formateador f2 = (dato1, dato2) -> dato1+"+"+dato2;
		System.out.println(f2.formatear("AAA", "BBB"));
		
		//
		//¿Son closures las expresiones lambda de java?
		//
		//NO: solo pueden utilizar variables declaradas fuera de ellas si son finales o 'efectivamente finales'
		
		int m1=25;	
		Consumer<Integer> multiplicador25 = m2 -> {
			//m1++;
			System.out.println(m1*m2);
		};
		
		
		multiplicador25.accept(10);
		multiplicador25.accept(20);		
		
		//
		//Interfaces funcionales en el api de Java8
		//
		
		
		System.out.println("===========================================");
		//consumer: public void accept(T t)
		//biconsumer: public void accept(T t, J j)
		Consumer<String> c = txt -> System.out.println("Consumer:"+txt);
		c.accept("Descanso!");
		
		//predicate: public boolean test(T t)
		Predicate<String> filtro = txt -> txt.length()>10;
		
		boolean rs1 = filtro.test("HOLA");
		boolean rs2 = filtro.test("HOLA RADIOLA");
		System.out.println(rs1+","+rs2);

		//function
		//public Tipo1 apply(Tipo2 t)
		Function<String, String> transformacion = txt -> txt.toUpperCase();
		String txt = transformacion.apply("abcdefg");
		System.out.println(txt);
				
		//supplier
		//public T get()
		Supplier<Double> suplier = () -> Math.random();
		Double n = suplier.get();
		System.out.println(n);			
		
		
		
		
		
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

		System.out.println("Languages which starts with J :");
		languages.stream()
		.filter(str -> ((String) str).startsWith("J"))
		.forEach(name -> System.out.println(name + " "));
		
		String collectJoin = languages.stream()
		.filter(str -> ((String) str).startsWith("J"))
		.collect(Collectors.joining(", "));
		
		System.out.println(collectJoin);
		
		
		
		
		System.exit(0);
		
	}

}

//
//Interfaces funcionales: solo tienen un método
//

//
//La anotación @FunctionalInterface indica al compilador que debe comprobar que efectivamente se trata
//de una interfaz con un único método
//
@FunctionalInterface
interface Reloj{
	public void decirHora();
}

//Consumer
interface Saludador{
	public void saludar(String nombre);
}

interface Calculador{
	public void calcular(Double n1, Double n2);
}

interface Formateador{
	public String formatear(String dato1, String dato2);
}










