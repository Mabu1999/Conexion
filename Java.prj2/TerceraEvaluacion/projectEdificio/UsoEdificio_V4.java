package projectEdificio;
//Creado por Francisco Pozo Romero
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
public class UsoEdificio_V4 {
	private static boolean seguir = true;
	private static boolean modificacion = false;
	private static double ajustePrecios = 0;
	private static ArrayList<Piso> edificio = new ArrayList<>();
	private static Scanner escaner = new Scanner(System.in);
	public static void restaurarCambios()  { 
		edificio.clear(); //Limpiamos el ArrayList y ...
		cargarEdificio(); //volvemos a cargar los datos previos a modificacion
	}
	public static void añadirPiso() { 
	//Es un metodo utilizado en la creacion del edificio (No es visible en el menu)
	/*Sera necesario reimplementarlo en el menu para crear los datos del edificio
	  en caso de perder el archivo con los datos basicos*/
		System.out.println("Introduce los datos del Piso");
		System.out.print("Planta:"); int planta=escaner.nextInt();
		System.out.print("Puerta:"); char puerta=escaner.next().charAt(0);
		System.out.print("Superficie:"); double superficie=escaner.nextDouble(); 
		escaner.nextLine();/*Fix del Scanner*/
		System.out.print("Mobiliario:"); String mobiliario=escaner.nextLine();
		System.out.print("Alquiler:"); double alquilerMensual=escaner.nextDouble();
		//Se escanean los diferentes datos del piso para añadirlo al ArrayList 
		edificio.add(new Piso(planta, puerta, superficie, mobiliario,alquilerMensual));
		modificacion=true;
		System.out.println("\nCarga completada\n");	
	}
	public static void añadirInquilino() {
		//Creamos un piso para que posteriormente haga referencia al piso elegido
		Piso pisoElegido = null;
		//Declaramos las variables necesarias para la validacion de los datos
		boolean datoCorrecto = false; //Se usa para introducir dato hasta cumplir validacion correspondiente
		int planta = 0;
		char puerta = 0;
		String nombre = "";
		String apellido = "";
		String dni = "";
		//Introducimos los datos del piso al que añadir el inquilino
		System.out.println("Introduce el piso");
		while(!datoCorrecto) {
			try {
				System.out.print("Planta: "); planta=escaner.nextInt();
				//Validacion de la planta
				if(planta== 1 || planta== 2 || planta== 3 || planta== 4) {
					datoCorrecto = true;
				}
				else {
					System.out.println("La planta debe ser un numero del 1 al 4.");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("La planta debe ser un numero");
				escaner.next();
			}
		}
		datoCorrecto = false; //Reestablecemos la bandera
		while (!datoCorrecto) {
			System.out.print("Puerta: ");
			String puertaInput = escaner.next().toLowerCase();
			escaner.nextLine(); //Fix del Scanner para escanear nombre posteriormente
			//Validacion de la puerta
			if (puertaInput.length() == 1 && Character.isLetter(puertaInput.charAt(0))) {
				puerta = puertaInput.charAt(0);
				datoCorrecto = true;
			} 
			else {
	               System.out.println("La puerta debe ser una única letra.");
			}
		 }
		datoCorrecto = false; //Reestablecemos la bandera
		//Recorremos los pisos hasta dar con el indicado y lo refereciamos en pisoElegido
		for(Piso piso:edificio) {
			if (planta == piso.getPlanta() && puerta == piso.getPuerta()) {	pisoElegido = piso; }
		} 
		//En caso de no encontrar ninguno lo indicamos y salimos del metodo
		if(pisoElegido==null) { System.out.println("El piso indicado no existe"); }
		else { //Introducimos los datos del inquilino para añadirlo
			System.out.println("Introduce los datos del Inquilino");
			while (!datoCorrecto) {
	            System.out.print("Nombre: ");
	            nombre = escaner.nextLine();
	            if (Pattern.matches("[a-zA-Z]{1,12}", nombre)) { //Validacion del nombre
	            	//Aseguramos primera letra del nombre en mayuscula
	            	nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length());
	                datoCorrecto = true;
	            } else {
	                System.out.println("El nombre debe contener solo letras y no exceder los 12 caracteres.");
	            }
	        }
			datoCorrecto = false; //Reestablecemos la bandera
	        while (!datoCorrecto) {
	            System.out.print("Apellido: ");
	            apellido = escaner.nextLine();
	            if (Pattern.matches("[a-zA-Z]{1,12}", apellido)) { //Validacion del apellido
	            	//Aseguramos primera letra del apellido en mayuscula
	            	apellido = apellido.toUpperCase().charAt(0) + apellido.substring(1, apellido.length());
	            	datoCorrecto = true;
	            } else {
	                System.out.println("El apellido debe contener solo letras y no exceder los 12 caracteres.");
	            }
	        }
	        datoCorrecto = false; //Reestablecemos la bandera
	        while (!datoCorrecto) {
	            System.out.print("DNI: ");
	            dni = escaner.nextLine();
	            if (Pattern.matches("\\d{8}[a-zA-Z]", dni)) { //Validacion del DNI
	            	//Aseguramos letra del dni en mayuscula
	            	dni = dni.substring(0, 8) + dni.toUpperCase().charAt(8);
	                datoCorrecto = true;
	            } else {
	                System.out.println("El DNI debe contener exactamente 8 números seguidos de una letra.");
	            }
	        }
			System.out.println("¿Esta seguro de añadir a "+nombre+" "+apellido+" al "+pisoElegido.getPlanta()+"º "+pisoElegido.getPuerta()
								+ " ? Si/No");
			String avanzar=escaner.nextLine();
			if (avanzar.equalsIgnoreCase("si") || avanzar.equalsIgnoreCase("s")) { //El usuario decide si agregar el inquilino al piso elegido 
				pisoElegido.addInquilino(new Inquilino(nombre, apellido, dni)); //Agregamos el inquilino al pisoElegido
				modificacion=true;
				System.out.println("\nEl inquilino ha sido añadido.\n");
			}
			else {
				System.out.println("\nVolviendo al menu sin agregar inquilino...\n");
			}	
		}
	}
	public static void modificarInquilino() {
		//Creamos un Inquilino para que posteriormente haga referencia al inquilino elegido
		Inquilino inquilinoElegido = null;
		boolean encontrado = false; //Se usa para determinar si el inquilino existe
		boolean datoCorrecto = false; //Se usa para introducir dato hasta cumplir validacion correspondiente
		//Declaramos las variables necesarias para la validacion de los datos
		String nombre = "";
		String apellido = "";
		String dni = "";
		System.out.println("Introduce el DNI del inquilino a modificar");
		/*Fix del Scanner*/escaner.nextLine();
		while (!datoCorrecto) {
            System.out.print("DNI: ");
            dni = escaner.nextLine();
            if (Pattern.matches("\\d{8}[a-zA-Z]", dni)) { //Validacion del DNI
            	//Aseguramos letra del dni en mayuscula
            	dni = dni.substring(0, 8) + dni.toUpperCase().charAt(8);
                datoCorrecto = true;
            } else {
                System.out.println("El DNI debe contener exactamente 8 números seguidos de una letra.");
            }
        }
		datoCorrecto = false; //Reestablecemos la bandera
		for(Piso piso:edificio) { //Recorremos los pisos y ...
			for(Inquilino inquilino: piso.getInquilinos()) { //recorremos los inquilinos del piso en el que nos encontramos
				if (dni.equals(inquilino.getDni())) { //En caso de coincidir DNI referenciamos al inquilino en inquilinoElegido
				inquilinoElegido=inquilino;
				encontrado=true;
				}
			}
		}
		//En caso de no encontrar ninguno lo indicamos y salimos del metodo
		if(encontrado==false) { System.out.println("\nEl inquilino indicado no existe\n"); }
		else {
			System.out.println("Introduce los nuevos datos del Inquilino");
			while (!datoCorrecto) {
	            System.out.print("Nombre: ");
	            nombre = escaner.nextLine();
	            if (Pattern.matches("[a-zA-Z]{1,12}", nombre)) { //Validacion del nombre
	            	//Aseguramos primera letra del nombre en mayuscula
	            	nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length());
	                datoCorrecto = true;
	            } else {
	                System.out.println("El nombre debe contener solo letras y no exceder los 12 caracteres.");
	            }
	        }
			datoCorrecto = false; //Reestablecemos la bandera
	        while (!datoCorrecto) {
	            System.out.print("Apellido: ");
	            apellido = escaner.nextLine();
	            if (Pattern.matches("[a-zA-Z]{1,12}", apellido)) { //Validacion del apellido
	            	//Aseguramos primera letra del apellido en mayuscula
	            	apellido = apellido.toUpperCase().charAt(0) + apellido.substring(1, apellido.length());
	            	datoCorrecto = true;
	            } else {
	                System.out.println("El apellido debe contener solo letras y no exceder los 12 caracteres.");
	            }
	        }
	        datoCorrecto = false; //Reestablecemos la bandera
	        while (!datoCorrecto) {
	            System.out.print("DNI: ");
	            dni = escaner.nextLine();
	            if (Pattern.matches("\\d{8}[a-zA-Z]", dni)) { //Validacion del DNI
	            	//Aseguramos letra del dni en mayuscula
	            	dni = dni.substring(0, 8) + dni.toUpperCase().charAt(8);
	                datoCorrecto = true;
	            } else {
	                System.out.println("El DNI debe contener exactamente 8 números seguidos de una letra.");
	            }
	        }
	        System.out.println("Datos actuales:\n Nombre:   "+inquilinoElegido.getNombre()+"\n Apellido: "+inquilinoElegido.getApellido()
	        					+"\n DNI:      "+inquilinoElegido.getDni());
	        System.out.println("Modificacion:\n Nombre:   "+nombre+"\n Apellido: "+apellido+"\n DNI:      "+dni);
			System.out.println("¿Deseas aplicar la modificacion? Si/No");
			String avanzar=escaner.nextLine();
			if (avanzar.equalsIgnoreCase("si") || avanzar.equalsIgnoreCase("s")) { //El usuario decide si modificar los datos del inquilino
				//Cambiamos los datos anteriores por los nuevos
				inquilinoElegido.setNombre(nombre);
				inquilinoElegido.setApellido(apellido);
				inquilinoElegido.setDni(dni);
				modificacion=true;
				System.out.println("\nEl inquilino ha sido modificado\n");
			}
			else {
				System.out.println("\nEl inquilino mantiene sus datos sin modificar.\n");
			}	
		}	
	}
	public static void eliminarInquilino() {
		//Creamos un Inquilino para que posteriormente haga referencia al inquilino elegido
		Inquilino inquilinoElegido = null;
		Piso pisoElegido = null;
		boolean encontrado = false; //Se usa para determinar si el inquilino existe
		boolean datoCorrecto = false; //Se usa para introducir dato hasta cumplir validacion correspondiente
		String dni = ""; //Declaramos la variable dni para su validacion
		System.out.println("Introduce el DNI del Inquilino a eliminar");
		/*Fix del Scanner*/escaner.nextLine();
	        while (!datoCorrecto) {
	            System.out.print("DNI: ");
	            dni = escaner.nextLine();
	            if (Pattern.matches("\\d{8}[a-zA-Z]", dni)) { //Validacion del DNI
	            	//Aseguramos letra del dni en mayuscula
	            	dni = dni.substring(0, 8) + dni.toUpperCase().charAt(8);
	                datoCorrecto = true;
	            } else {
	                System.out.println("El DNI debe contener exactamente 8 números seguidos de una letra.");
	            }
	        }
		for(Piso piso:edificio) { //Recorremos los pisos y ...
			for(Inquilino inquilino: piso.getInquilinos()) { //recorremos los inquilinos del piso en el que nos encontramos
				if (dni.equals(inquilino.getDni())) { //En caso de coincidir DNI referenciamos al inquilino en inquilinoElegido
				inquilinoElegido=inquilino;
				pisoElegido=piso;
				encontrado=true;
				}
			}
		}
		//En caso de no encontrar ninguno lo indicamos y salimos del metodo
		if(encontrado==false) { System.out.println("\nEl inquilino indicado no existe\n"); }
		else {
			System.out.println("¿Deseas eliminar a "+inquilinoElegido.getNombre()+" "+ inquilinoElegido.getApellido()
			+" con DNI: " + inquilinoElegido.getDni()+ " del piso "+pisoElegido.getPlanta()+"º "+pisoElegido.getPuerta()+"? Si/No");
			String avanzar=escaner.nextLine();
			if (avanzar.equalsIgnoreCase("si") || avanzar.equalsIgnoreCase("s")) { //El usuario decide si eliminar el inquilino indicado del piso elegido
				pisoElegido.removeInquilino(inquilinoElegido); //Eliminamos el inquilino al que hace referencia inquilinoElegido
				modificacion=true;
				System.out.println("\nEl inquilino ha sido eliminado\n");
			}
			else {
				System.out.println("\nEl inquilino "+inquilinoElegido.getNombre()+" "+ inquilinoElegido.getApellido()
				+"con DNI: " + inquilinoElegido.getDni()+ " se mantiene en el "+pisoElegido.getPlanta()+"º "+pisoElegido.getPuerta()+".\n");
			}	
		}
	}
	public static void modernizarPiso() {
		//Creamos un piso para que posteriormente haga referencia al piso elegido
		Piso pisoElegido = null;
		double precioModernizar = 0;
		boolean modernizable = false;
		String nuevoMobiliario = null;
		
		System.out.println("Introduce el piso que desea modernizar");
		System.out.print("Planta:"); int planta=escaner.nextInt();
		System.out.print("Puerta:"); char puerta=escaner.next().charAt(0);
		escaner.nextLine(); //Fix del Scanner para escanear nombre posteriormente
		for(Piso piso:edificio) {
			if (planta == piso.getPlanta() && puerta == piso.getPuerta()) {	pisoElegido = piso; }
		} //Recorremos los pisos hasta dar con el indicado y lo refereciamos en pisoElegido
		if(pisoElegido==null) { System.out.println("El piso indicado no existe"); }
		//En caso de no encontrar ninguno lo indicamos y salimos del metodo
		else { 
			//En funcion del mobiliario anterior se calcula el nuevo precio teniendo en cuenta el ajuste de precios actual
			if(pisoElegido.getMobiliario().equals("antiguo")) { 
				precioModernizar=((pisoElegido.getSuperficie() * 9) + ((pisoElegido.getAlquilerMensual() * ajustePrecios)/100)); 
				modernizable = true; 
				nuevoMobiliario="moderno"; }
			else if(pisoElegido.getMobiliario().equals("moderno")) { 
				precioModernizar=((pisoElegido.getSuperficie() * 14) + ((pisoElegido.getAlquilerMensual() * ajustePrecios)/100)); 
				modernizable = true; 
				nuevoMobiliario="vanguardia"; }
			else if(pisoElegido.getMobiliario().equals("vanguardia")) { System.out.println("\nEl estado actual del mobiliario es inmejorable\n"); }
			if(modernizable) {
				System.out.println("El mobiliario previo era " + pisoElegido.getMobiliario() + ", al modernizar a " + nuevoMobiliario + " el alquiler del piso");
				System.out.println("ha ascendido de " + pisoElegido.getAlquilerMensual() + "€ a " + precioModernizar + "€");
				System.out.println("¿Esta seguro de aplicar este cambio al piso "+pisoElegido.getPlanta()+"º "+pisoElegido.getPuerta()+"? Si/No");
				String avanzar=escaner.nextLine();
				if (avanzar.equalsIgnoreCase("si") || avanzar.equalsIgnoreCase("s")) {//El usuario decide si aplica la modernizacion del piso
					pisoElegido.setAlquilerMensual(precioModernizar); //Se cambia el precio por el del nuevo mobiliario
					pisoElegido.setMobiliario(nuevoMobiliario); //Se cambia al nuevo estado del mobiliario
					modificacion=true;
					System.out.println("\nMobiliario modernizado correctamente\n");
				}
				else {
					System.out.println("\nEl moviliario mantiene el estado "+pisoElegido.getMobiliario()+".\n");
				}	
			}
		}
	}
	public static void ajustarPrecios() {
		System.out.println("Introduce el nuevo porcentaje de impuestos al inmueble");
		double nuevoAjustePrecios=escaner.nextDouble();
		escaner.nextLine(); //Fix del Scanner para escanear condicion posterior
		System.out.println("El impuesto pasara del "+ajustePrecios+"% al "+ nuevoAjustePrecios+"%");
		System.out.println("¿Esta seguro de aplicar este cambio? Si/No");
		String avanzar=escaner.nextLine();
		if (avanzar.equalsIgnoreCase("si") || avanzar.equalsIgnoreCase("s")) { //El usuario si aplica el ajuste de precio
			for(Piso piso:edificio) {
				//Volvemos al precio base del los pisos
				piso.setAlquilerMensual(piso.getAlquilerMensual() / ((100 + ajustePrecios)/100));
				//Aplicamos el nuevo ajuste de precios a los pisos
				piso.setAlquilerMensual(piso.getAlquilerMensual() + ((piso.getAlquilerMensual() * nuevoAjustePrecios))/100);
			}
			ajustePrecios=nuevoAjustePrecios;
			modificacion=true;
			System.out.println("\nAjuste de precios realizado correctamente");
		}
		else {
			System.out.println("\nEl impuesto se mantiene en "+ajustePrecios+"%");
		}
	}
	public static void getEdificio(ArrayList<Piso> edificio) { //Recibe el ArrayList edificio
		if (!edificio.isEmpty()) {
			System.out.println("Infomación del edificio completo:");
		for(Piso piso:edificio) { //Recorre el edificio mostrando la informacion de todos los pisos
			System.out.println(piso);
			}
		}
    }
    public static void guardarDatos(ArrayList<Piso> edificio){
    	if(modificacion) { //En caso de que no existan modificaciones salimos directamente
    		escaner.nextLine(); //Fix del Scanner para escanear condicion posterior
	    	System.out.println("El edificio ha sido modificado ¿Desea guardar los cambios? Si/No");
			String avanzar=escaner.nextLine(); //El usuario decide si guardar las modificaciones
			if (avanzar.equalsIgnoreCase("si") || avanzar.equalsIgnoreCase("s")) {
				try { //Guardado del edificio en el archivo .ser con los cambios efectuados
		    		//1-creo dos ficheros (+ ruta) mediante clase File
				File miFicheroEdificio = new File("C:\\Users\\Mabu\\eclipse-workspace\\Java.prj\\TerceraEvaluacion\\projectEdificio\\Edificio.ser");
				File miFicheroAjuPrecEdificio = new File("C:\\Users\\Mabu\\eclipse-workspace\\Java.prj\\TerceraEvaluacion\\projectEdificio\\AjustePrecio.dat");
				//2- se los pasamos a FileOutputStream para escribir
				FileOutputStream fos = new FileOutputStream(miFicheroEdificio);
				FileOutputStream fos2 = new FileOutputStream(miFicheroAjuPrecEdificio);
				//3- estos a su vez a ObjetctOutputStream para que escriba objetos 
				ObjectOutputStream  oos=new ObjectOutputStream (fos);
				ObjectOutputStream  oos2=new ObjectOutputStream (fos2);
				//escribimos todo en los ficheros usando writeObject y writeDouble
				oos.writeObject(edificio);
				oos2.writeDouble(ajustePrecios);
				//cerramos
				oos.close();
				oos2.close();
				System.out.println("\nDatos Guardados \nFIN DE LA EJECUCIÓN");
		    	}
		    	catch (IOException e){
		    		System.out.println("\nFallos al guardar los datos\n");
		    	}
			}
			else {
			System.out.println("\nFIN DE LA EJECUCIÓN");
			}
    	}
    	else {
			System.out.println("\nFIN DE LA EJECUCIÓN");
    	}
	}
    public static void cargarEdificio() { 
    	try {
	        ObjectInputStream ois=null;
	        ObjectInputStream ois2=null;
	        boolean datosPrevios=false;
	        ArrayList<Piso> pisos = new ArrayList<>();
			try {
		    	//1-creo un fichero (+ ruta) mediante clase File
			    File miFichero = new File("C:\\Users\\Mabu\\eclipse-workspace\\Java.prj\\TerceraEvaluacion\\projectEdificio\\Edificio.ser");
				//2- se lo pasamos a FileInputputStream para leerlo
			    FileInputStream fis = new FileInputStream(miFichero);
				//3- este a su vez a ObjetImputStream para almacenar la lectura
			    ois=new ObjectInputStream (fis);
			
			    while (ois!=null) //Hasta que ObjetImputStream este vacio almacenamos los datos en ...
			 	{ //el ArrayList leidos para añadirlos al ArrayList pisos
				@SuppressWarnings("unchecked")
				ArrayList<Piso> leidos = (ArrayList<Piso>)ois.readObject();
				pisos.addAll(leidos);
			 	}
			}
			catch (EOFException e) { //Tratamos la excepcion de fin del fichero
					     System.out.println ("Carga de pisos completada.\n");
			}
			catch (FileNotFoundException e) { //Tratamos la excepcion en la que no se encuentra el fichero
				System.out.println("No se encuentra informacion previa del edificio\n");
			}
			finally{ //Si pisos no esta vacio cerramos el ObjectInputStream y añadimos el pisos al ArrayList edificio
				 if(pisos.isEmpty()==false) {
					 ois.close();
					 edificio.addAll(pisos);
				 }
			}
			try {
		    	//1-creo un fichero (+ ruta) mediante clase File
			    File miFicheroAjuPrecEdificio = new File("C:\\Users\\Mabu\\eclipse-workspace\\Java.prj\\TerceraEvaluacion\\projectEdificio\\AjustePrecio.dat");
				//2- se lo pasamos a FileInputputStream para leerlo
			    FileInputStream fis2 = new FileInputStream(miFicheroAjuPrecEdificio);
				//3- este a su vez a ObjetImputStream para almacenar la lectura
			    ois2=new ObjectInputStream (fis2);
			    while(ois2!=null) { //Hasta que ObjetImputStream este vacio almacenamos el ajuste de precios
				    ajustePrecios = ois2.readDouble();
				    datosPrevios=true;
			    }
			}
			catch (EOFException e) { //Tratamos la excepcion de fin del fichero
					     System.out.println ("Ajuste de precios actual: "+ajustePrecios+"%\n");
			}
			catch (FileNotFoundException e) { //Tratamos la excepcion en la que no se encuentra el fichero
				System.out.println("No se encuentra informacion previa ajuste de los precios.\n");
			}
			finally{ 
				 if(datosPrevios) { //Evitamos interrupcion del programa si no hay ajuste de precio previo
					 ois2.close();
				 }
			}
    	}
		catch( ClassNotFoundException|IOException e) {
			System.out.println("\nFallos al cargar los datos\n");
		}
    }
    public static void opcionesMenu(int opcion) {
		switch(opcion){ //Accedemos a los metodos segun nuestra eleccion en el main o salimos del programa
			case 1:
				getEdificio(edificio);
				break;
			case 2:
				añadirInquilino();
				break;
			case 3:
				eliminarInquilino();
				break;
			case 4:
				modificarInquilino();
				break;
			case 5:
				modernizarPiso();
				break;
			case 6:
				ajustarPrecios();
				break;
			case 7:
				restaurarCambios();
				break;
			case 8:
				seguir=false;
				break;
			default:
				System.out.println("¡--- Opcion Erronea ---!\n");
		}
    }
    public static void main(String[] args) {
    	//Carga automatica de los datos del Edificio (ArrayList edificio)
    	cargarEdificio();
    	getEdificio(edificio);
		while(seguir) { //mientras la variable de clase seguir sea TRUE nos mantenemos en el menu
			System.out.println("_-------------------------_");
			System.out.println("|          MENU           |");
			System.out.println("|-------------------------|");
			System.out.println("|  1. Mostrar Edificio    |");
			System.out.println("|  2. Añadir Inquilino    |");
			System.out.println("|  3. Eliminar Inquilino  |");
			System.out.println("|  4. Modificar Inquilino |");
			System.out.println("|  5. Modernizar Piso     |");
			System.out.println("|  6. Ajuste de Precios   |");
			System.out.println("|  7. Deshacer Cambios    |");
			System.out.println("|  8. Salir               |");
			System.out.println("|_________________________|\n");
		    int opcion = escaner.nextInt();
			opcionesMenu(opcion); //Accedemos a la opcion elegida del Switch
		}
		//Guardado automatico de los datos del Edificio (ArrayList edificio)
    	guardarDatos(edificio);
		escaner.close();//Cerramos el escaner de clase		
    }
}