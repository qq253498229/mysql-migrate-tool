SELECT CATALOG_NAME,
       DEFAULT_CHARACTER_SET_NAME,
       DEFAULT_COLLATION_NAME,
       SCHEMA_NAME,
       SQL_PATH
FROM information_schema.SCHEMATA
WHERE SCHEMA_NAME = ?