
INSERT INTO categorias_empleados (monto_hora_extra, sueldo_fijo_mensual, tipo_categoria) VALUES (25000, 1700000, "A");
INSERT INTO categorias_empleados (monto_hora_extra, sueldo_fijo_mensual, tipo_categoria) VALUES (20000, 1200000, "B");
INSERT INTO categorias_empleados (monto_hora_extra, sueldo_fijo_mensual, tipo_categoria) VALUES (10000, 800000, "C");


INSERT INTO empleados (apellidos, fecha_ingreso,fecha_nacimiento,nombres,rut,id_categoria) VALUES ("Lucero Cordova","2010-01-01","1998-11-20","Gerardo Antonio","19.919.462-3",1);
INSERT INTO empleados (apellidos, fecha_ingreso,fecha_nacimiento,nombres,rut,id_categoria) VALUES ("Cordova Vidal","2010-01-01","1981-02-04","Lissette Margarita","14.182.037-0",2);
INSERT INTO empleados (apellidos, fecha_ingreso,fecha_nacimiento,nombres,rut,id_categoria) VALUES ("Lucero Lucero","2010-01-01","1978-06-08","Juan Andres","13.487.865-7",3);

INSERT INTO inasistencias (fecha,justificativo_aprobado, id_empleado,rut_empleado) VALUES ("2012-01-01",true, 1, "19.919.462-3");
INSERT INTO inasistencias (fecha,justificativo_aprobado, id_empleado,rut_empleado) VALUES ("2013-01-01",true, 2, "14.182.037-0");
INSERT INTO inasistencias (fecha,justificativo_aprobado, id_empleado,rut_empleado) VALUES ("2014-01-01",true,2, "14.182.037-0");
INSERT INTO inasistencias (fecha,justificativo_aprobado, id_empleado,rut_empleado) VALUES ("2015-01-01",false,3, "13.487.865-7");





