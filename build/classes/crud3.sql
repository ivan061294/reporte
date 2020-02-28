DELIMITER $$
DROP PROCEDURE IF EXISTS eliminar_dispositivo;
CREATE PROCEDURE eliminar_dispositivo (
IN id_disp INT
)
BEGIN
DELETE FROM dispositivo WHERE id_dispositivo=id_disp;
END$$
DELIMITER ;
