package projectEdificio;

import java.io.Serializable;
import java.util.ArrayList;

public class Piso implements Serializable {
	private static final long serialVersionUID = 1L;
	private int planta;
	private char puerta;
    private double superficie;
    private String mobiliario;
    private double alquilerMensual;
    private ArrayList<Inquilino> inquilinos;
    //Constructor de los Pisos
    public Piso(int planta, char puerta, double superficie, String mobiliario, double alquilerMensual) {
        this.planta = planta;
        this.puerta = puerta;
        this.superficie = superficie;
        this.mobiliario = mobiliario;
        this.alquilerMensual = alquilerMensual;
        this.inquilinos = new ArrayList<>();//relación de inquilinos que habitan los pisos
    }
    public double getSuperficie() {
    	return superficie;
    }
    public String getMobiliario() {
    	return mobiliario;
    }
    public void setMobiliario(String mobiliario) {
    	this.mobiliario=mobiliario;
    }
    public double getAlquilerMensual() {
    	return alquilerMensual;
    }
    public void setAlquilerMensual(double alquilerMensual) {
    	this.alquilerMensual=alquilerMensual;
    }
   
    public int getPlanta() {
		return planta;
	}
	public char getPuerta() {
		return puerta;
	}
    //Muestra toda la informacion del Inquilino
    public ArrayList<Inquilino> getInquilinos() {
        return inquilinos;
    }
    public String getDatosInquilinos() {
    	String datosInquilinos="";
        for(Inquilino inqui:inquilinos) {
        	datosInquilinos+=inqui.toString();
        }
        if(datosInquilinos=="") {
        	return datosInquilinos="| Sin inquilinos                                                       |\n";
        }
    	return datosInquilinos;
    }
    public void addInquilino(Inquilino inquilino) {
        this.inquilinos.add(inquilino);
    }

    public void removeInquilino(Inquilino inquilino) {
        this.inquilinos.remove(inquilino);
    }
    //Muestra toda la informacion del Piso
    @Override
    public String toString() {
    	return String.format ("_----------------------------------------------------------------------_%n"
    						+ "|   %-1d %-10C %-11s Mobiliario: %-14s %-10s     |\n"
    						+ "|----------------------------------------------------------------------|%n"
    						+ "| INQUILINOS:        *Nombre*       *Apellido*         *DNI*           |%n"
    						+ "%s"
    						+ "|______________________________________________________________________|%n"
    						, planta, puerta, (superficie+"m²"),(mobiliario.replace(mobiliario.charAt(0), mobiliario.toUpperCase().charAt(0)))
    						, (alquilerMensual+"€"), getDatosInquilinos());
        
    }
}