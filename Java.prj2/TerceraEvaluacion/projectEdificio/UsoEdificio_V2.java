package projectEdificio;
// confirmacion del guardado y boolean guardado
import java.io.*;
import java.util.*;
public class UsoEdificio_V2 {
	private static boolean seguir = true;
	private static ArrayList<Piso> edificio = new ArrayList<>();
	private static Scanner escaner = new Scanner(System.in);

	public static void restaurarCambios() throws ClassNotFoundException, IOException { 
		edificio.clear(); //Limpiamos el ArrayList y ...
		cargarEdificio(); //volvemos a cargar los datos previos a modificacion
	}
	public static void añadirPiso() { 	
	//Es un metodo utilizado en la creacion del edificio (No es visible en el menu)
		System.out.println("Introduce los datos del Piso");
		System.out.print("Planta:"); int planta=escaner.nextInt();
		System.out.print("Puerta:"); char puerta=escaner.next().charAt(0);
		System.out.print("Superficie:"); double superficie=escaner.nextDouble(); /*Fix del Scanner*/escaner.nextLine();
		System.out.print("Mobiliario:"); String mobiliario=escaner.nextLine();
		System.out.print("Alquiler:"); double alquilerMensual=escaner.nextDouble();
		//Se escanean los diferentes datos del piso para añadirlo al ArrayList 
		edificio.add(new Piso(planta, puerta, superficie, mobiliario,alquilerMensual));
		System.out.println("Carga completada\n");	
	}
	public static void añadirInquilino() {
		//Creamos un piso para que posteriormente haga referencia al piso elegido
		Piso pisoElegido = null;
		System.out.println("Introduce el piso");
		System.out.print("Planta:"); int planta=escaner.nextInt();
		System.out.print("Puerta:"); char puerta=escaner.next().charAt(0);
		escaner.nextLine(); //Fix del Scanner para escanear nombre posteriormente
		for(Piso piso:edificio) {
			if (planta == piso.getPlanta() && puerta == piso.getPuerta()) {	pisoElegido = piso; }
		} //Recorremos los pisos hasta dar con el indicado y lo refereciamos en pisoElegido
		if(pisoElegido==null) { System.out.println("El piso indicado no existe"); }
		//En caso de no encontrar ninguno lo indicamos y salimos del metodo
		else { 
			System.out.println("Introduce los datos del Inquilino...");
			System.out.print("Nombre:"); String nombre=escaner.nextLine();
			System.out.print("Apellido:"); String apellido=escaner.nextLine();
			System.out.print("DNI:"); String dni=escaner.nextLine();
			//Se escanean los diferentes datos para añadir un inquilino al piso referenciado por pisoElegido
			pisoElegido.addInquilino(new Inquilino(nombre, apellido, dni));			
			System.out.println("Carga completada\n");
		}
	}
	public static void eliminarInquilino() {
		boolean encontrado = false;
		//Creamos un Inquilino para que posteriormente haga referencia al inquilino elegido
		Inquilino inquilinoElegido = null;
		System.out.println("Introduce el DNI del Inquilino");
		/*Fix del Scanner*/escaner.nextLine();
		System.out.print("DNI:"); String dni=escaner.nextLine();
		for(Piso piso:edificio) { //Recorremos los pisos y ...
			for(Inquilino inquilino: piso.getInquilinos()) { //recorremos los inquilinos del piso en el que nos encontramos
				if (dni.equals(inquilino.getDni())) { //En caso de coincidir DNI referenciamos al inquilino en inquilinoElegido
				inquilinoElegido=inquilino;
				encontrado=true;
				}
			}
			piso.removeInquilino(inquilinoElegido); //Eliminamos el inquilino al que hace referencia inquilinoElegido
		}
		//En caso de no encontrar ninguno lo indicamos y salimos del metodo
		if(encontrado==false) { System.out.println("\nEl inquilino indicado no existe\n"); }
		else {System.out.println("\nEl inquilino ha sido eliminado\n"); }
	}
	public static void getEdificio(ArrayList<Piso> edificio) { //Recibe el ArrayList edificio
		System.out.println("Infomación del edificio completo:");
		for(Piso piso:edificio) { //Recorre el edificio mostrando la informacion de todos los pisos
			System.out.println(piso+"\n");
			}
    }
    public static void guardarDatos(ArrayList<Piso> edificio) throws IOException{
    	//Guardado del edificio en el archivo .ser con los cambios efectuados
    	//1-creo un fichero (+ ruta) mediante clase File
		File miFichero = new File("C:\\Users\\Mabu\\eclipse-workspace\\Java.prj\\TerceraEvaluacion\\projectEdificio\\Edificio.ser");
		//2- se lo pasamos a FileOutputStream para escribir
		FileOutputStream fos = new FileOutputStream(miFichero);
		//3- este a su vez a ObjetctOutputStream para que escriba objetos 
		ObjectOutputStream  oos=new ObjectOutputStream (fos);
		//escribimos todo el ArrayList edificio al fichero usando writeObject
		oos.writeObject(edificio);
		//cerramos
		oos.close();
		System.out.println("\nDatos Guardados \nFIN DE LA EJECUCIÓN");
	}
    public static void cargarEdificio() throws ClassNotFoundException, IOException { 
        ObjectInputStream ois=null;
        ArrayList<Piso> pisos = new ArrayList<>();
		try{
	    	//1-creo un fichero (+ ruta) mediante clase File
		    File miFichero = new File("C:\\Users\\Mabu\\eclipse-workspace\\Java.prj\\TerceraEvaluacion\\projectEdificio\\Edificio.ser");
			//2- se lo pasamos a FileInputputStream para leerlo
		    FileInputStream fis = new FileInputStream(miFichero);
			//3- este a su vez a ObjetImputStream para almacenar la lectura
		    ois=new ObjectInputStream (fis);
		
		    while (ois!=null) //Si ObjetImputStream no esta vacio almacenamos los datos en ...
		 	{ //el ArrayList leidos para añadirlos al ArrayList pisos
			@SuppressWarnings("unchecked")
			ArrayList<Piso> leidos= (ArrayList<Piso>)ois.readObject();
			pisos.addAll(leidos);
		 	}
		}
		catch (EOFException e) //Tratamos la excepcion de fin del fichero
			{	     System.out.println ("Carga completada.\n");
			}
		catch (FileNotFoundException e) { //Tratamos la excepcion en la que no se encuentra el fichero
			System.out.println("No se encuentra informacion previa del edificio.\n");
		}
		finally{ //Si pisos no esta vacio cerramos el ObjectInputStream y añadimos el pisos al ArrayList edificio
			 if(pisos.isEmpty()==false) {
				 ois.close();
				 edificio.addAll(pisos);
			 }
		}
    }
    public static void opcionesMenu(int opcion)throws IOException, ClassNotFoundException {
		switch(opcion){ //Accedemos a los metodos segun nuestra eleccion en el main o salimos del programa
			case 1:
				añadirInquilino();
				break;
			case 2:
				eliminarInquilino();
				break;
			case 3:
				System.out.println("\"Modernizar Piso\" Esta en desarrollo");
				break;
			case 4:
				System.out.println("\"Ajuste de Precios\" Esta en desarrollo");
				break;
			
			case 5:
				getEdificio(edificio);
				break;
			case 6:
				restaurarCambios();
				break;
			case 7:
				seguir=false;
				break;
			default:
				System.out.println("¡--- Opcion Erronea ---!\n");
				main(null); //En caso de opcion no esperada lo indicamos y volvemos al main()
		}
    }
    public static void main(String[] args) throws ClassNotFoundException, IOException  {
    	//Carga automatica de los datos del Edificio (ArrayList edificio)
    	cargarEdificio();
		while(seguir) { //mientras la variable de clase seguir sea TRUE nos mantenemos en el menu
			System.out.println("*************************");
			System.out.println("          MENU\n");
			System.out.println("   1. Añadir Inquilino");
			System.out.println("   2. Eliminar Inquilino");
			System.out.println("   3. Modernizar Piso");
			System.out.println("   4. Ajuste de Precios");
			System.out.println("   5. Mostrar Edificio");
			System.out.println("   6. Deshacer Cambios");
			System.out.println("   7. Salir");
			System.out.println("*************************\n");
		    int opcion = escaner.nextInt();
			opcionesMenu(opcion); //Accedemos a la opcion elegida del Switch
		}
		 escaner.close();//Cerramos el escaner de clase
		//Guardado automatico de los datos del Edificio (ArrayList edificio)
    	guardarDatos(edificio);		
    }
}