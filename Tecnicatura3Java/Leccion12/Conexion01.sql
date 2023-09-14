
-- Comenzamos con CRUD create(insertar), read(leer), update(actualizar), delete(eliminar)
-- Listar los estudiantes (read)
SELECT * FROM estudiantes2022;
-- Insertar estudiante
INSERT INTO estudiantes2022 (nombre, apellido, telefono, email) VALUES ("Juan", "Perez","365241654","juan@mail.com");
-- update (modificar)
UPDATE estudiantes2022 SET nombre="Juan Carlos", apellido="Garcia" WHERE idestudiantes2022= 1;
-- Delete(eliminar)
DELETE FROM estudiantes2022 where idestudiantes2022=3;
-- Para modificar el idestudiantes 2022 y comience en 1
ALTER TABLE estudiantes2022 AUTO_INCREMENT = 1;