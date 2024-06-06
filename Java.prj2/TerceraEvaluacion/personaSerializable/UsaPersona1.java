package personaSerializable;
//import personaSerializable.MiObjectOutputStream;
import java.io.*;
import java.util.Scanner;
//guardar bytes de una lista pasada en un fichero     
//**************************************** guardar enteros int 
public class UsaPersona1{
	private static boolean seguir = true;
	public static void cargaInicial() throws IOException
	{
		 	//1-creo un fichero (+ ruta) mediante clase File
		  File miFichero = new File("C:\\Users\\Mabu\\eclipse-workspace\\Java.prj\\TerceraEvaluacion\\personaSerializable\\Persona1.ser");
		  	//2- se lo pasamos a FileOutputStream para escribir
		  FileOutputStream fos = new FileOutputStream(miFichero);
		  //3- este a su vez a ObjetctOutputStream para que escriba objetos 
		  
		 ObjectOutputStream  oos=new ObjectOutputStream (fos);
		 //creamos 3 personas y las escribimos usando writeObject
		 oos.writeObject(new Persona1 ("Juan",40, "258741369Z"));
		 oos.writeObject(new Persona1 ("Luis",35, "234349069W"));
		 oos.writeObject(new Persona1 ("Maria",28, "343205353L"));
		 oos.writeObject(new Persona1 ("Paco",25, "563575353L"));
		 
		 System.out.println("Carga inicial completada");

		//cerramos
		 oos.close();	
		 
	}
	public static void listarPersonas() throws ClassNotFoundException,
	IOException {
		 	ObjectInputStream ois=null;
		 
		 try{					//1-creo un fichero (+ ruta) mediante clase File
		  File miFichero = new File("C:\\Users\\Mabu\\eclipse-workspace\\Java.prj\\TerceraEvaluacion\\personaSerializable\\Persona1.ser");
		  					//2- se lo pasamos a FileOutputStream para escribir
		  FileInputStream fis = new FileInputStream(miFichero);
		  		//3- este a su vez a ObjetctOutputStream para que escriba objetos 
		 ois=new ObjectInputStream (fis);
		 
		 while (ois!=null)
		 	{	//mientras halla datos leerlos y mostrarlos-> pasar a (Persona1)
			 Persona1 p=  (Persona1)  ois.readObject();
			 							//muestro los atributos de persona  p
		 	 System.out.println("Nombre: " + p.getNombre()+" DNI: "+p.getDNI()+" Edad: " + p.getEdad());	 	 
			 System.out.println("*************************");	 
		 	}//while
		 }catch (EOFException e1)
			{	     System.out.println ("Fin de fichero");	//comprobar que entra
			}
		 finally{
			 ois.close();								//cerramos flujo de objetos 
		 }
	}
	public static void añadirPersona() throws IOException{
	 	//1-creo un fichero (+ ruta) mediante clase File
		  File miFichero = new File("C:\\Users\\Mabu\\eclipse-workspace\\Java.prj\\TerceraEvaluacion\\personaSerializable\\Persona1.ser");
		  	//2- se lo pasamos a FileOutputStream para escribir
		  FileOutputStream fos = new FileOutputStream(miFichero);
		  //3- este a su vez a ObjetctOutputStream para que escriba objetos 
		  ObjectOutputStream  oos=new ObjectOutputStream (fos);
		  //creamos los diferentes Scanners
		  @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		  System.out.println("Introduce nombre:");
		  String nombre = sc.nextLine();
		  System.out.println("Introduce edad:");
		  int edad = sc.nextInt();
	      sc.nextLine(); 
		  System.out.println("Introduce dni:");
		  String dni = sc.nextLine();
		  
		 //creamos 1 persona y la escribimos usando writeObject
		 oos.writeObject(new Persona1 (nombre,edad,dni));
		 System.out.println("Carga completada");
		//cerramos
		
		 oos.close();
		 
	}
	public static void opcionesMenu(int opcion)throws IOException, ClassNotFoundException {
		switch(opcion){
			case 1:
				cargaInicial();
				break;
			case 2:
				listarPersonas();
				break;
			case 3:
				añadirPersona();
				break;
			case 4:
				seguir=false;
				break;
			default:
				System.out.println("¡--- Opcion Erronea ---!\n");
				main(null);
		}
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
			Scanner escaner = new Scanner(System.in);
			while(seguir) {
				System.out.println("*************************");
				System.out.println("          MENU\n");
				System.out.println("   1. Carga inicial");
				System.out.println("   2. Listar personas");
				System.out.println("   3. Añadir persona");
				System.out.println("   4. Salir");
				System.out.println("*************************\n");
			     int opcion = escaner.nextInt();
			     opcionesMenu(opcion);
			    
			}
			 escaner.close();
	  }
}
