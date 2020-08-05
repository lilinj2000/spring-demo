package com.example.demohbase.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.security.User;
import org.apache.hadoop.security.UserGroupInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HBaseUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(HBaseUtil.class);

    private static final HBaseUtil INSTANCE = new HBaseUtil();

    private static volatile Connection conn = null;
    private static volatile Admin admin = null;
    private static User user = null;

    static {
        Configuration conf = HBaseConfiguration.create();
        conf.addResource(new Path(System.getenv("HBASE_CONF_DIR"), "hbase-site.xml"));
        conf.addResource(new Path(System.getenv("HBASE_CONF_DIR"), "core-site.xml"));

        try {
            UserGroupInformation.setConfiguration(conf);
//            UserGroupInformation.getUGIFromTicketCache("/tmp/krb5cc_0", "llj@TEST.COM");
//            UserGroupInformation.loginUserFromKeytab("hbase/_HOST@TEST.COM", "/etc/krb5.keytab");
//            UserGroupInformation loginUser = UserGroupInformation.getLoginUser();
//            user = User.create(loginUser);
//            conn = ConnectionFactory.createConnection(conf, user);
            conn = ConnectionFactory.createConnection(conf);
            admin = conn.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HBaseUtil() {
        LOGGER.info("HBaseUtil be created!");
    }

    public static HBaseUtil getInstance() {
        return INSTANCE;
    }

    /**
     * 关闭连接
     *
     * @throws IOException
     */
    public static void close() {
        try {
            conn.close();
        } catch (IOException e) {
            conn = null;
        } finally {
            conn = null;
        }
    }

    public boolean tableExists(String tableName) {
        LOGGER.info("tableExists be called");

        Table table = null;
        boolean tableExistsFlag = false;
        try {
            table = getConnection().getTable(TableName.valueOf(tableName));
            tableExistsFlag = getAdmin().tableExists(table.getName());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeTable(table);
        }
        return tableExistsFlag;
    }

    private void closeTable(Table table) {
        if (table != null) {
            try {
                table.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public Admin getAdmin() {
        return admin;
    }

}