package es.pro2fp.programacion.clases;

    public class Hoteles {

        private int id;
        private String direccion;
        private String nombre;


        public Hoteles(int id, String direccion, String nombre){
            this.id= id;
            this.direccion=direccion;
            this.nombre = nombre;

        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return "\nId: + this.getId());+" +
                        " \nDireccion:  "+this.getDireccion()+
                        "\nNombre: "+this.getNombre();
        }
    }


