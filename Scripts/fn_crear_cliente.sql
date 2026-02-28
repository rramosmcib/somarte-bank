CREATE OR REPLACE FUNCTION fn_crear_cliente(
	p_tdoc integer,
	p_ndoc character varying,
	p_user character varying)
    RETURNS TABLE(v_cta integer, v_codret integer, v_mensaje text) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
DECLARE
    V_EMP INTEGER := 1;
BEGIN
    -- Validar si ya existe cliente
    SELECT STNCTA INTO V_CTA
    FROM MST8
    WHERE STEMP = V_EMP AND STTDOC = P_TDOC AND STNDOC = P_NDOC;

    IF V_CTA IS NOT NULL AND V_CTA > 0 THEN
        V_CODRET := 90;
        V_MENSAJE := 'CLIENTE YA CUENTA CON CUENTA';
        RETURN QUERY SELECT V_CTA, V_CODRET, V_MENSAJE;
        RETURN;
    END IF;

    -- Asignar nueva cuenta
    SELECT COALESCE(MAX(STNCTA) + 1, 230225)
    INTO V_CTA
    FROM MST8;

    INSERT INTO MST8 (STEMP, STTDOC, STNDOC, STNCTA, STUSER)
    VALUES(V_EMP, P_TDOC, P_NDOC, V_CTA, P_USER);

    V_CODRET := 0;
    V_MENSAJE := 'OK';
    RETURN QUERY SELECT V_CTA, V_CODRET, V_MENSAJE;
END;
$BODY$;