DELIMITER $$
DROP PROCEDURE IF EXISTS actualizar_dispositivo;
CREATE PROCEDURE actualizar_dispositivo (
IN id_disp INT,
IN nombre VARCHAR(30),
IN precio INT,
IN tipo varchar(30)
)
BEGIN
update dispositivo set nombre=nombre,precio=precio,tipo=tipo where id_dispositivo=id_disp;
END$$
DELIMITER ;

