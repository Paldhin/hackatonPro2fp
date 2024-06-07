package es.pro2fp.programacion.clases;

    public class Hotel {

        /**
         * Esta es la clase Hoteles, la cual tiene los siguientes atributos definidos y un unico constructor
         *
         * Sus atributos son los siguientes:
         * Identificador unico para relacionarlo con los usuarios
         * Direccion, que tendra solo una
         * Nombre del hotel
         *
         */

//Telefono, e-mail, web, nombre, direccion             
        private int telefono;
        private String email;
        private String web;
        private int id;
        private Direccion direccion;
        private String nombre;

/**
 * Constructor de la clase Direccion que recibe como parametros los siguientes atributos y posteriormente
 * los iguala a los atributos anteriormente mencionados.
 */
        public Hotel(int telefono, String email, String web, int id, Direccion direccion, String nombre){
            this.telefono = telefono;
            this.email = email;
            this.web = web;
            this.id= id;
            this.direccion=direccion;
            this.nombre = nombre;

        }
        /**
         * 
         * @return
         */
        public int getTelefono() {
            return telefono;
        }
        public void setTelefono (int telefono) {
            this.telefono = telefono;
        }
        /**
         * 
         * @return
         */
        public String getEmail() {
            return email;
        }
        /**
         * 
         * @param email
         */
        public void setEmail(String email) {
            this.email = email;
        }
        /**
         * 
         * @return
         */
        public String getWeb() {
            return web;
        }
        /**
         * 
         * @param web
         */
        public void setWeb(String web) {
            this.web = web;
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
            return "\n-------------------" + 
                    "\nHotel: " + 
                    "\n-------------------" + 
                    "\nNombre: " + this.getNombre() + 
                    "\nTeléfono: " + this.getTelefono() + 
                    "\nE-mail: " + this.getEmail() + 
                    "\nWeb: " + this.getWeb() + 
                    "\nDirección: " + this.getDireccion();
        }
    }


