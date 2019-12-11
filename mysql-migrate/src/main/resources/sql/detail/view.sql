SELECT TABLE_CATALOG,
       TABLE_SCHEMA,
       TABLE_NAME,
       VIEW_DEFINITION,
       CHECK_OPTION,
       IS_UPDATABLE,
       DEFINER,
       SECURITY_TYPE,
       CHARACTER_SET_CLIENT,
       COLLATION_CONNECTION
FROM information_schema.VIEWS
WHERE TABLE_SCHEMA = ?