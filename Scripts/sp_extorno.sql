CREATE OR REPLACE PROCEDURE sp_extorno(
	IN p_mod integer,
	IN p_tra integer,
	IN p_nrel integer,
	IN p_user character varying)
LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
    V_EMP   INTEGER:= 1;
    V_CTA   INTEGER;
    V_OPE   INTEGER;
    V_IMP   NUMERIC;
    V_NREL  INTEGER;
	V_DBHB	INTEGER;
	V_XDBHB	INTEGER;
BEGIN
    -- Buscar cabecera original
    SELECT stemp INTO V_EMP
    FROM MST015
    WHERE STEMP = V_EMP AND stmod = P_MOD AND sttran = P_TRA AND stnrel = P_NREL AND st15estd = 'S';

    IF NOT FOUND THEN
        RAISE EXCEPTION 'No existe transacción contabilizada para extornar';
    END IF;

    -- Obtener importe, CUENTA Y OPERACION | DEBE/HABER
    SELECT st16imp, st16cta, st16oper, ST16DBHB
    INTO V_IMP, V_CTA, V_OPE, V_DBHB
    FROM MST016
    WHERE stmod = P_MOD AND sttran = P_TRA AND stnrel = P_NREL AND stsbord = 3;

    -- OBTIENE NUMERO RELACION
    SELECT COALESCE(MAX(stnrel)+1,1)
    INTO V_NREL
    FROM MST015
    WHERE stemp = V_EMP AND stmod = 52 AND sttran = 1;

	-- CREA CABECERA EXTORNO
    INSERT INTO MST015(stemp,stmod,sttran,stnrel,st15fech,st15user,st15estd)
    VALUES(V_EMP,52,1,V_NREL,CURRENT_DATE,P_USER,'N');

	IF V_DBHB = 1 THEN
	    V_XDBHB := 2;
	ELSIF V_DBHB = 2 THEN
	    V_XDBHB := 1;
	END IF;

    -- Actualizar saldo (restar)
	UPDATE MST011
	SET STSDO = STSDO + CASE 
	                       WHEN V_XDBHB = 2 THEN V_IMP  
	                       WHEN V_XDBHB = 1 THEN -V_IMP
	                    END
	WHERE stemp = V_EMP AND stcta = V_CTA AND stoper = V_OPE;

    -- ORD 102 SUBORD 
    INSERT INTO MST016(stemp,stmod,sttran,stnrel,stfech,stord,stsbord,st16imp,st16dbhb,st16cta,st16oper,st16fech,st16user)
    VALUES(V_EMP,52,1,V_NREL,CURRENT_DATE,102,1,V_IMP,V_XDBHB,V_CTA,V_OPE,CURRENT_DATE,P_USER);

    -- Marcar cabecera como pendiente
    UPDATE MST015 SET st15estd = 'P'
    WHERE stemp = V_EMP AND stmod = 52 AND sttran = 1 AND stnrel = V_NREL;

	-- CAMBIA EL ESTADO A 'X' OSEA EXTORNADO
    UPDATE MST015 SET st15estd = 'X'
    WHERE stemp = V_EMP AND stmod = P_MOD AND sttran = P_TRA AND stnrel = P_NREL;

EXCEPTION WHEN OTHERS THEN
    UPDATE MST015 SET st15estd = 'E'
    WHERE stemp = V_EMP AND stmod = 52 AND sttran = 1 AND stnrel = V_NREL;
    RAISE;
END;
$BODY$;