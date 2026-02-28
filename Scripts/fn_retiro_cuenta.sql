CREATE OR REPLACE FUNCTION fn_retiro_cuenta(
	p_ctaeq integer,
	p_imp numeric,
	p_mon integer,
	p_user character varying)
    RETURNS TABLE(codret integer, mensaje text) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
DECLARE
    V_EMP   INTEGER := 1;
    V_CTA   INTEGER := 0;
    V_OPE   INTEGER := 0;
    V_MOD   INTEGER := 0;
    V_TOP   INTEGER := 0;
    V_SBO   INTEGER := 0;

    V_SDO   NUMERIC := 0;
    V_NREL  INTEGER := 0;
    V_STAT  INTEGER := 99;
BEGIN
    SELECT STEMP, ST111CTA, ST111OPER, ST111MOD, ST111TOPE, ST111SBOP
    INTO V_EMP, V_CTA, V_OPE, V_MOD, V_TOP, V_SBO
    FROM MST111
    WHERE ST111CTAEQ = p_ctaeq;

    SELECT COALESCE(MAX(STNREL) + 1, 1)
    INTO V_NREL
    FROM MST015
    WHERE STEMP = V_EMP AND STMOD = 50 AND STTRAN = 2;

    INSERT INTO MST015 (stemp, stmod, sttran, stnrel, st15fech, st15user, st15estd)
    VALUES (V_EMP, 50, 2, V_NREL, CURRENT_DATE, p_user, 'N');

    IF V_CTA IS NULL OR V_CTA = 0 THEN
        UPDATE MST015 SET st15estd = 'E'
        WHERE STEMP = V_EMP AND STMOD = 50 AND STTRAN = 2 AND STNREL = V_NREL;
        RETURN QUERY SELECT 99, 'CUENTA NO EXISTE';
    END IF;

    INSERT INTO MST016 (stemp, stmod, sttran, stnrel, STFECH, stord, stsbord, st16imp, ST16DBHB, st16cta, st16oper, st16fech, st16user)
    VALUES (V_EMP, 50, 2, V_NREL, CURRENT_DATE, 100, 1, 0, 2, V_CTA, V_OPE, CURRENT_DATE, p_user);

    SELECT STSDO, STESTD INTO V_SDO, V_STAT
    FROM MST011
    WHERE STEMP = V_EMP AND STCTA = V_CTA AND STOPER = V_OPE AND STMOD = V_MOD AND STTOPE = V_TOP AND STSBOP = V_SBO AND STMDA = p_mon;

    IF V_STAT IS NULL OR V_STAT = 9 THEN
        UPDATE MST015 SET st15estd = 'E'
        WHERE STEMP = V_EMP AND STMOD = 50 AND STTRAN = 2 AND STNREL = V_NREL;
        RETURN QUERY SELECT 99, 'CUENTA INACTIVA';
    END IF;

    IF V_SDO < p_imp OR p_imp <= 0 THEN
        UPDATE MST015 SET st15estd = 'E'
        WHERE STEMP = V_EMP AND STMOD = 50 AND STTRAN = 2 AND STNREL = V_NREL;
        RETURN QUERY SELECT 99, 'SALDO INSUFICIENTE O IMPORTE INVÁLIDO';
    END IF;

    INSERT INTO MST016 (stemp, stmod, sttran, stnrel, STFECH, stord, stsbord, st16imp, ST16DBHB, st16cta, st16oper, st16fech, st16user)
    VALUES (V_EMP, 50, 2, V_NREL, CURRENT_DATE, 100, 2, 0, 2, V_CTA, V_OPE, CURRENT_DATE, p_user);

    UPDATE MST011 SET STSDO = STSDO - p_imp
    WHERE STEMP = V_EMP AND STCTA = V_CTA AND STOPER = V_OPE AND STMOD = V_MOD AND STTOPE = V_TOP AND STSBOP = V_SBO AND STMDA = p_mon;

    INSERT INTO MST016 (stemp, stmod, sttran, stnrel, STFECH, stord, stsbord, st16imp, ST16DBHB, st16cta, st16oper, st16fech, st16user)
    VALUES (V_EMP, 50, 2, V_NREL, CURRENT_DATE, 100, 3, p_imp, 1, V_CTA, V_OPE, CURRENT_DATE, p_user);

    UPDATE MST015 SET st15estd = 'P'
    WHERE STEMP = V_EMP AND STMOD = 50 AND STTRAN = 2 AND STNREL = V_NREL;

    RETURN QUERY SELECT 0, 'RETIRO EXITOSO';

EXCEPTION
    WHEN OTHERS THEN
        BEGIN
            UPDATE MST015 SET st15estd = 'E'
            WHERE STEMP = V_EMP AND STMOD = 50 AND STTRAN = 2 AND STNREL = V_NREL;

            INSERT INTO MST015 (stemp, stmod, sttran, stnrel, st15fech, st15user, st15estd)
            VALUES (V_EMP, 50, 2, V_NREL, CURRENT_DATE, p_user, 'E');
        EXCEPTION WHEN OTHERS THEN
            NULL;
        END;
        RETURN QUERY SELECT 99, 'ERROR EN RETIRO';
END;
$BODY$;