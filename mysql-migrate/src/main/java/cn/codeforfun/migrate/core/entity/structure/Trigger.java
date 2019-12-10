package cn.codeforfun.migrate.core.entity.structure;

import cn.codeforfun.migrate.core.diff.Difference;
import cn.codeforfun.migrate.core.entity.structure.annotations.DbUtilProperty;
import cn.codeforfun.migrate.core.utils.DbUtil;
import cn.codeforfun.migrate.core.utils.FileUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wangbin
 */
@Getter
@Setter
@Slf4j
public class Trigger implements Serializable, Difference {
    private static final long serialVersionUID = 8820673590063935538L;

    @DbUtilProperty("TRIGGER_SCHEMA")
    private String schema;
    @DbUtilProperty("TRIGGER_NAME")
    private String name;
    @DbUtilProperty("DEFINER")
    private String definer;
    @DbUtilProperty("ACTION_TIMING")
    private String actionTiming;
    @DbUtilProperty("EVENT_MANIPULATION")
    private String eventManipulation;
    @DbUtilProperty("EVENT_OBJECT_SCHEMA")
    private String objectSchema;
    @DbUtilProperty("EVENT_OBJECT_TABLE")
    private String objectTable;
    @DbUtilProperty("ACTION_ORIENTATION")
    private String actionOrientation;
    @DbUtilProperty("ACTION_STATEMENT")
    private String source;

    public static List<Trigger> configure(Connection connection, String databaseName) throws SQLException {
        return DbUtil.getBeanList(connection,
                FileUtil.getStringByClasspath("sql/detail/trigger.sql"),
                Trigger.class, databaseName);
    }

    @Override
    public String getCreateSql() {
        String[] split = this.definer.split("@");
        return "CREATE DEFINER =`" + split[0] + "`@`" + split[1] + "` " +
                "TRIGGER " + this.name + " " +
                this.actionTiming + " " + this.eventManipulation + " ON `" + this.objectSchema + "`.`" + this.objectTable + "` " +
                "FOR EACH " + this.actionOrientation + " " + this.source + ";";
    }

    @Override
    public String getUpdateSql() {
        return null;
    }

    @Override
    public String getDeleteSql() {
        return "DROP TRIGGER `" + this.name + "`;";
    }
}