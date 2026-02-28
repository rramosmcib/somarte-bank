CREATE OR REPLACE PROCEDURE sp_asigna_calificacion(
	IN p_tdoc integer,
	IN p_ndoc character varying)
LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
    V_EMP   INTEGER := 1;
    V_CAL   TEXT[] := ARRAY['NOR','DUD','DEF','CPP','PER'];
    V_RAND  TEXT;
    V_IDX   INT;
BEGIN
	DELETE FROM MST097
	WHERE STEMP = V_EMP AND ST97TDOC = P_TDOC AND ST97NDOC = P_NDOC;
    -- Genera índice aleatorio entre 1 y longitud del array
    V_IDX := floor(random() * array_length(V_CAL,1) + 1);
    V_RAND := V_CAL[V_IDX];

    -- Inserta registro en MST099
    INSERT INTO MST097 (STEMP, ST97TDOC, ST97NDOC, ST97CALI)
    VALUES (V_EMP, P_TDOC, P_NDOC, V_RAND);
END;
$BODY$;