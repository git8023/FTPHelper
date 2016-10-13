/**
 * @FileName: FTPConfig.java
 * @Author Huang.Yong
 * @Description:
 * @Date 2016年10月13日 上午11:17:52
 * @CopyRight 
 */
package org.yong.common.ftp;

import org.yong.common.ftp.handler.ErrorHandler;

/**
 * @Author Huang.Yong
 * @Description: FTP配置
 * @Date 2016年10月13日 上午11:17:52
 * @Version 0.1
 * @CopyRight
 */
public class FTPConfig {
    public static class Builder {

        private Builder() {
            super();
        }

        private FTPConfig conf = new FTPConfig();

        public Builder setAutoLogin(boolean autoLogin) {
            conf.autoLogin = autoLogin;
            return this;
        }

        public Builder setDefaultDirectory(String defaultDirectory) {
            conf.defaultDirectory = defaultDirectory;
            return this;
        }

        public Builder setHost(String host) {
            conf.host = host;
            return this;
        }

        public Builder setPassword(String password) {
            conf.password = password;
            return this;
        }

        public Builder setPort(int port) {
            conf.port = port;
            return this;
        }

        public Builder setTimeout(int timeout) {
            conf.timeout = timeout;
            return this;
        }

        public Builder setUserName(String userName) {
            conf.userName = userName;
            return this;
        }

        public Builder setDownloadDir(String downloadDir) {
            conf.downloadDir = downloadDir;
            return this;
        }

        public Builder setErrorHandler(ErrorHandler errorHandler) {
            conf.errorHandler = errorHandler;
            return this;
        }

        public FTPConfig build() {
            return this.conf;
        }
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    private static final String DEFAULT_DIRECTORY = "/";

    private static final int DEFAULT_PORT = 21;

    private ErrorHandler errorHandler;

    private boolean autoLogin = false;

    private String defaultDirectory = DEFAULT_DIRECTORY;

    private String host;

    private String password;

    private int port = DEFAULT_PORT;

    private int timeout = 5000;

    private String userName;

    private String downloadDir;

    public String getDefaultDirectory() {
        return defaultDirectory;
    }

    public String getHost() {
        return host;
    }

    public String getPassword() {
        return password;
    }

    public int getPort() {
        return port;
    }

    public int getTimeout() {
        return timeout;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isAutoLogin() {
        return autoLogin;
    }

    public void setAutoLogin(boolean autoLogin) {
        this.autoLogin = autoLogin;
    }

    public void setDefaultDirectory(String defaultDirectory) {
        this.defaultDirectory = defaultDirectory;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDownloadDir() {
        return downloadDir;
    }

    public void setDownloadDir(String downloadDir) {
        this.downloadDir = downloadDir;
    }

    public ErrorHandler getErrorHandler() {
        return errorHandler;
    }

    public void setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    @Override
    public String toString() {
        return "FTPConfig [autoLogin=" + autoLogin + ", defaultDirectory=" + defaultDirectory + ", host=" + host + ", password="
                + password + ", port=" + port + ", timeout=" + timeout + ", userName=" + userName + "]";
    }

}
