
INSERT INTO categorias_empleados (monto_hora_extra, sueldo_fijo_mensual, tipo_categoria) VALUES (25000, 1700000, "A");
INSERT INTO categorias_empleados (monto_hora_extra, sueldo_fijo_mensual, tipo_categoria) VALUES (20000, 1200000, "B");
INSERT INTO categorias_empleados (monto_hora_extra, sueldo_fijo_mensual, tipo_categoria) VALUES (10000, 800000, "C");


INSERT INTO empleados (apellidos, fecha_ingreso,fecha_nacimiento,nombres,rut,id_categoria) VALUES ("Lucero Cordova","2010-01-01","1998-11-20","Gerardo Antonio","19919462-3",1);
INSERT INTO empleados (apellidos, fecha_ingreso,fecha_nacimiento,nombres,rut,id_categoria) VALUES ("Cordova Vidal","2010-01-01","1981-02-04","Lissette Margarita","14182037-0",2);
INSERT INTO empleados (apellidos, fecha_ingreso,fecha_nacimiento,nombres,rut,id_categoria) VALUES ("Lucero Lucero","2010-01-01","1978-06-08","Juan Andres","13487865-7",3);

INSERT INTO inasistencias (fecha,justificativo_aprobado, id_empleado) VALUES ("2012-01-01",true, 1);
INSERT INTO inasistencias (fecha,justificativo_aprobado, id_empleado) VALUES ("2013-01-01",true, 2);
INSERT INTO inasistencias (fecha,justificativo_aprobado, id_empleado) VALUES ("2014-01-01",true,2);
INSERT INTO inasistencias (fecha,justificativo_aprobado, id_empleado) VALUES ("2015-01-01",false,3);





