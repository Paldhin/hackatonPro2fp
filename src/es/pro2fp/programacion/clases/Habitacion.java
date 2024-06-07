package es.pro2fp.programacion.clases;

public class Habitacion {

    private int id_habitacion;
    private int numeroHabitacion;
    private String tipoHabitacion;
    private float precio_habitacion_euros;
    private int hoteles_idHotel;

    public Habitacion(int id_habitacion, int numeroHabitacion, String tipoHabitacion, float precio_habitacion_euros){
        this.id_habitacion = id_habitacion;
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.precio_habitacion_euros = precio_habitacion_euros;
    }

    /**
     *
     * @return getId_habitacion
     */
    public int getId_habitacion() {
        return id_habitacion;
    }

    /**
     *
     * @param id_habitacion
     */
    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    /**
     *
     * @return getNumeroHabitacion
     */
    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    /**
     *
     * @param numeroHabitacion
     */
    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    /**
     *
     * @return getTipoHabitacion
     */
    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    /**
     *
     * @param tipoHabitacion
     */
    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    /**
     *
     * @return getPrecio_habitacion_euros
     */
    public float getPrecio_habitacion_euros() {
        return precio_habitacion_euros;
    }

    /**
     *
     * @param precio_habitacion_euros
     */
    public void setPrecio_habitacion_euros(float precio_habitacion_euros) {
        this.precio_habitacion_euros = precio_habitacion_euros;
    }

    /**
     *
     * @return getHoteles_idHotel
     */
    public int getHoteles_idHotel() {
        return hoteles_idHotel;
    }

    /**
     *
     * @param hoteles_idHotel
     */
    public void setHoteles_idHotel(int hoteles_idHotel) {
        this.hoteles_idHotel = hoteles_idHotel;
    }

    /**
     *
     * @return toString de la clase Habitacion
     */
    @Override
    public String toString (){
        return "\n---------------------" +
                "\nNumero de la Habitación: " + this.getNumeroHabitacion() + "\nTipo de Habitación: " + this.getTipoHabitacion() + this.getPrecio_habitacion_euros() +
                "\n---------------------";
    }
}
