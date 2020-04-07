package com.example.demohbase.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.data.hbase")
public class HBaseProperties {
    // Addresses of all registered ZK servers.
    private String zkQuorum;

    // Location of HBase home directory
    private String rootDir;

    // Root node of this cluster in ZK.
    private String zkBasePath;

    public String getZkQuorum() {
        return zkQuorum;
    }

    public void setZkQuorum(String zkQuorum) {
        this.zkQuorum = zkQuorum;
    }
// getters and setters...

    public String getRootDir() {
        return rootDir;
    }

    public String getZkBasePath() {
        return zkBasePath;
    }

    public void setZkBasePath(String zkBasePath) {
        this.zkBasePath = zkBasePath;
    }

    public void setRootDir(String rootDir) {
        this.rootDir = rootDir;
    }
}