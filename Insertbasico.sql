INSERT INTO `Gestor_hoteles`.`Direcciones` (`Calle`, `Numero`, `Municipio`, `Pais`, `Codigo_Postal`, `Puerta`, `Ciudad`) VALUES ('a', '1', 'a', 'a', '1', '1', 'a');
INSERT INTO `Gestor_hoteles`.`Hoteles` (`Direcciones_idDireccion`, `Nombre`, `Telefono_contacto`, `Email_contacto`, `Web`) VALUES ('1', 'a', '1', 'a@a.a', 'a.com');
INSERT INTO `Gestor_hoteles`.`Habitaciones` (`NumeroHabitacion`, `TipoHabitacion`, `Hoteles_idHotel`, `Disponible`, `Borrada`, `Fecha_inicio_vigencia`, `Precio_habitacion_euros`) VALUES ('1', 'a', '1', b'1', b'0', '2024-06-07 00:28:25', '1');
INSERT INTO `Gestor_hoteles`.`Usuario` (`Direcciones_idDireccion`, `Administrador`, `Nombre_usuario`, `Password`, `Nombre`, `Apellido1`, `Apellido2`, `email`, `telefono`) VALUES (1, 0, 'a', 'a', 'a', 'a', 'a', 'a@a.a', '1');
INSERT INTO `Gestor_hoteles`.`Reservas` (`Clientes_idCliente`, `Habitaciones_idHabitacion`, `Activa`, `Cancelada`, `Fecha_realizacion`, `Momento_entrada`, `Momento_salida`) VALUES (1, 1, b'1', b'0', '2024-06-07 00:42:55', '2024-06-08 00:42:55', '2024-06-09 00:42:55');

