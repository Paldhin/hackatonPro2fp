package es.pro2fp.programacion.clases;
import java.util.Date;
/**
 * Esta es la clase Reserva, clase que tiene unos atributos definidos y un unico constructor
 * 
 * Como atributos la clase tiene:
 * 
 * id_reserva que es un identificador unico para cada reserva de cada usuario.
 * habitacion que es la habitacion o habitaciones que quiere reservar un usuario.
 * fechaEntrada que es la fecha de entrada de dicha reserva.
 * fechaSalida que es la fecha de salida de dicha reserva.
 */
public class Reserva {
    
    private int id_reserva;
    private Habitacion habitacion;
    private Usuario cliente;
    private Date fechaEntrada;
    private Date fechaSalida;
/**
 * Constructor de la clase Reserva que recibe como parametros los siguientes atributos y posteriormente 
 * los iguala a los atributos anteriormente mencionados. 
 * 
 * Todos los parametros siguientes coinciden en nombre y definicion con los atributos de la definicion de la clase:
 * 
 * @param id_reserva
 * @param habitacion
 * @param cliente
 * @param fechaEntrada
 * @param fechaSalida
 */
    public Reserva (int id_reserva, Habitacion habitacion, Usuario cliente, Date fechaEntrada, Date fechaSalida) {
        this.id_reserva = id_reserva;
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }
    /**
     * Metodo getId_Reserva que devuelve un dato de tipo int 
     * 
     * @return id_reserva que es un atributo de la clase Reserva, identificador unico de cada reserva creada
     */
    public int getId_Reserva() {
        return id_reserva;
    }
    /**
     * Metodo que recibe como parametro un int y lo iguala al atributo id_reserva de la clase Reserva
     * 
     * @param id_reserva int que se iguala al atributo de la clase Reserva
     */
    public void setId_Reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }
    /**
     * Metodo getHabitacion que devuelve un dato de tipo Habitacion 
     * 
     * @return habitacion que es un atributo de la clase Reserva, es un objeto de tipo Habitacion
     */
    public Habitacion getHabitacion() {
        return habitacion;
    }
    /**
     * Metodo que recibe como parametro un tipo Habitacion y lo iguala al atributo habitacion de la clase Reserva
     * 
     * @param habitacion objeto de tipo Habitacion que se iguala al atributo de la clase Reserva
     */
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
    /**
     * Metodo getCliente que devuelve un dato de tipo Usuario 
     * 
     * @return cliente que es un atributo de la clase Reserva, objeto de tipo usuario
     */
    public Usuario getCliente() {
        return cliente;
    }
    /**
     * Metodo que recibe como parametro un tipo Usuario y lo iguala al atributo de la clase Reserva
     * 
     * @param cliente objeto de tipo Usuario que se iguala al atributo de la clase Reserva
     */
    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }
    /**
     * Metodo getFechaEntrada que devuelve un dato de tipo Date
     * 
     * @return fechaEntrada que es un atributo de la clase Reserva, objeto de tipo Date
     */
    public Date getFechaEntrada() {
        return fechaEntrada;
    }
    /**
     * Metodo que recibe como parametro un tipo Date y lo iguala al atributo de la clase Reserva
     * 
     * @param fechaEntrada objeto de tipo Date que se iguala al atributo de la clase Reserva
     */
    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
    /**
     * Metodo getFechaSalida que devuelve un dato de tipo Date
     * 
     * @return fechaSalida que es un atributo de la clase Reserva, objeto de tipo Date
     */
    public Date getFechaSalida() {
        return fechaSalida;
    }
    /**
     * Metodo que recibe como parametro un tipo Date y lo iguala al atributo de la clase Reserva
     * 
     * @param fechaSalida objeto de tipo Date que se iguala al atributo de la clase Reserva
     */
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    /**
     * Metodo toString de la clase Reserva
     * 
     * @return devuelve todo los atributos de la clase Reseva, en definitiva devuelve la reserva hecha por el usuario al completo.
     */
    @Override
    public String toString() {
        return "\n----------------------" +
                "\nReserva del cliente: " + this.getCliente() + 
                "\n----------------------" +
                "\nHabitación reservada: " + this.getHabitacion() + 
                "\nFecha de entrada: " + this.getFechaEntrada() + 
                "\nFecha de salida: " + this.getFechaSalida();
    }
}
