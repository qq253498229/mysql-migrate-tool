SELECT SPECIFIC_NAME,
       ROUTINE_SCHEMA,
       ROUTINE_NAME,
       ROUTINE_TYPE,
       DATA_TYPE,
       CHARACTER_MAXIMUM_LENGTH,
       CHARACTER_OCTET_LENGTH,
       NUMERIC_PRECISION,
       NUMERIC_SCALE,
       DATETIME_PRECISION,
       CHARACTER_SET_NAME,
       COLLATION_NAME,
       DTD_IDENTIFIER,
       ROUTINE_BODY,
       ROUTINE_DEFINITION,
       EXTERNAL_NAME,
       EXTERNAL_LANGUAGE,
       PARAMETER_STYLE,
       IS_DETERMINISTIC,
       SQL_DATA_ACCESS,
       SQL_PATH,
       SECURITY_TYPE,
       CREATED,
       LAST_ALTERED,
       SQL_MODE,
       ROUTINE_COMMENT,
       DEFINER,
       CHARACTER_SET_CLIENT,
       COLLATION_CONNECTION,
       DATABASE_COLLATION
FROM information_schema.ROUTINES
WHERE ROUTINE_TYPE = 'FUNCTION'
  AND ROUTINE_SCHEMA = ?