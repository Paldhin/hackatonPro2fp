package es.pro2fp.programacion.clases;

    public class Hoteles {

        /**
         * Esta es la clase Hoteles, la cual tiene los siguientes atributos definidos y un unico constructor
         *
         * Sus atributos son los siguientes:
         * Identificador unico para relacionarlo con los usuarios
         * Direccion, que tendra solo una
         * Nombre del hotel
         *
         */
        private int id;
        private Direccion direccion;
        private String nombre;

/**
 * Constructor de la clase Direccion que recibe como parametros los siguientes atributos y posteriormente
 * los iguala a los atributos anteriormente mencionados.
 */
 public Hoteles(int id, Direccion direccion, String nombre){
            this.id= id;
            this.direccion=direccion;
            this.nombre = nombre;

        }

        /**
         *
         * @return getId
         */
        public int getId() {
            return id;
        }

        /**
         *
         * @param id
         */
        public void setId(int id) {
            this.id = id;
        }

        /**
         *
         * @return getDireccion
         */
        public Direccion getDireccion() {
            return direccion;
        }

        /**
         *
         * @param direccion
         */
        public void setDireccion(Direccion direccion) {
            this.direccion = direccion;
        }

        /**
         *
         * @return getNombre
         */
        public String getNombre() {
            return nombre;
        }

        /**
         *
         * @param nombre
         */
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        /**
         *
         * @return Id + Direccion + Nombre.
         */
        @Override
        public String toString() {
            return "\nId: + this.getId());+" +
                        " \nDireccion:  "+this.getDireccion()+
                        "\nNombre: "+this.getNombre();
        }
    }


