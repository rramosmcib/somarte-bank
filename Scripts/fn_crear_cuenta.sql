CREATE OR REPLACE FUNCTION fn_crear_cuenta(
	p_tdoc integer,
	p_ndoc character varying,
	p_mod integer,
	p_tope integer,
	p_sbop integer,
	p_mda integer,
	p_user character varying)
    RETURNS TABLE(v_ctaeq integer, v_codret integer, v_mensaje text) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
DECLARE
    v_stemp       INTEGER := 1;
    v_cta         INTEGER := 0;
    v_oper        INTEGER := 0;
    v_ctaeq_out   INTEGER := 0;
    v_codret_out  INTEGER := 99;
    v_mensaje_out TEXT    := '';
BEGIN
    -- Validar que cliente exista
    IF NOT EXISTS (
        SELECT 1
        FROM MST8
        WHERE STEMP  = v_stemp
          AND STTDOC = p_tdoc
          AND STNDOC = p_ndoc
    ) THEN
        v_ctaeq_out   := 0;
        v_codret_out  := 90;
        v_mensaje_out := 'LA PERSONA CONSULTADA NO ES CLIENTE';
        RETURN QUERY SELECT v_ctaeq_out, v_codret_out, v_mensaje_out;
        RETURN;
    END IF;

    -- Asignar número de operación
    SELECT COALESCE(MAX(STOPER) + 1, 250225)
    INTO v_oper
    FROM MST011;

    -- Crear cuenta equivalente
    SELECT COALESCE(MAX(ST111CTAEQ) + 1, 232)
    INTO v_ctaeq_out
    FROM MST111;

    -- Recuperar la cuenta del cliente
    SELECT STNCTA
    INTO v_cta
    FROM MST8
    WHERE STEMP  = v_stemp
      AND STTDOC = p_tdoc
      AND STNDOC = p_ndoc;

    -- Insertar en MST111
    BEGIN
        INSERT INTO MST111 (STEMP, ST111CTA, ST111OPER, ST111MOD, ST111TOPE, ST111SBOP, ST111CTAEQ)
        VALUES (v_stemp, v_cta, v_oper, p_mod, p_tope, p_sbop, v_ctaeq_out);
    EXCEPTION WHEN OTHERS THEN
        v_ctaeq_out := 0;
        v_codret_out := 99;
        v_mensaje_out := 'ERROR AL INGRESAR MST111: ' || SQLERRM;
        RETURN QUERY SELECT v_ctaeq_out, v_codret_out, v_mensaje_out;
        RETURN;  
    END;

    -- Insertar en MST011
    BEGIN
        INSERT INTO MST011 (STEMP, STCTA, STOPER, STMDA, STMOD, STTOPE, STSBOP, STFCRE, STSDO, STESTD, STUSER)
        VALUES (v_stemp, v_cta, v_oper, p_mda, p_mod, p_tope, p_sbop, CURRENT_DATE, 0, 0, p_user);
    EXCEPTION WHEN OTHERS THEN
        v_ctaeq_out := 0;
        v_codret_out := 99;
        v_mensaje_out := 'ERROR AL INGRESAR MST011: ' || SQLERRM;
        RETURN QUERY SELECT v_ctaeq_out, v_codret_out, v_mensaje_out;
        RETURN;  
    END;
    
    v_codret_out := 0;
    v_mensaje_out := 'OK';
    RETURN QUERY SELECT v_ctaeq_out, v_codret_out, v_mensaje_out;
END;
$BODY$;