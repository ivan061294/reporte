DELIMITER $$
DROP PROCEDURE IF EXISTS insertar_dispositivo;
CREATE PROCEDURE insertar_dispositivo (
IN id_disp INT,
IN nombre VARCHAR(30),
IN precio INT,
IN tipo varchar(30)
)
BEGIN
insert into dispositivo values(id_disp,nombre,precio,tipo);
END$$
DELIMITER ;

