/**
 * @FileName: FTPConfig.java
 * @author Huang.Yong
 * 
 * 2016年10月13日 上午11:17:52
 *  
 */
package org.yong.common.ftp;

import org.yong.common.ftp.handler.ErrorHandler;

/**
 * FTP配置
 * 
 * @author Huang.Yong 2016年10月13日 上午11:17:52
 * @version 0.1
 * 
 */
public class FTPConfig {

    /**
     * @author Huang.Yong FTP配置构建 2016年10月13日 下午4:38:34
     * @version 0.1
     * 
     */
    public static class Builder {

        private FTPConfig conf = new FTPConfig();

        private Builder() {
            super();
        }

        public FTPConfig build() {
            return this.conf;
        }

        public Builder setAutoLogin(boolean autoLogin) {
            conf.autoLogin = autoLogin;
            return this;
        }

        public Builder setDefaultDirectory(String defaultDirectory) {
            conf.defaultDirectory = defaultDirectory;
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
    }

    private static final String DEFAULT_DIRECTORY = "/";

    private static final int DEFAULT_PORT = 21;

    private static final int DEFAULT_TIME_OUT = 5 * 60 * 1000;

    public static Builder createBuilder() {
        return new Builder();
    }

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

    public String getDownloadDir() {
        return downloadDir;
    }

    public ErrorHandler getErrorHandler() {
        return errorHandler;
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
        return 0 >= timeout ? timeout : DEFAULT_TIME_OUT;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isAutoLogin() {
        return autoLogin;
    }

    /**
     * 
     * 设置自动登录
     * 
     * @param autoLogin true-自动登陆
     */
    public void setAutoLogin(boolean autoLogin) {
        this.autoLogin = autoLogin;
    }

    /**
     * 
     * 设置默认工作目录
     * 
     * @param defaultDirectory 工作目录
     */
    public void setDefaultDirectory(String defaultDirectory) {
        this.defaultDirectory = defaultDirectory;
    }

    /**
     * 
     * 设置本地下载目录
     * 
     * @param downloadDir 本地(绝对)目录
     */
    public void setDownloadDir(String downloadDir) {
        this.downloadDir = downloadDir;
    }

    /**
     * 
     * 设置统一异常处理器
     * 
     * @param errorHandler 异常处理器
     */
    public void setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    /**
     * 
     * 设置服务器域名或IP
     * 
     * @param host 服务器域名或IP
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * 
     * 设置登录密码
     * 
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     * 设置端口
     * 
     * @param port 端口号
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * 
     * 设置连接超时
     * 
     * @param timeout 超时时长
     */
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    /**
     * 
     * 设置登录用户
     * 
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "FTPConfig [autoLogin=" + autoLogin + ", defaultDirectory=" + defaultDirectory + ", host=" + host + ", password="
                + password + ", port=" + port + ", timeout=" + timeout + ", userName=" + userName + "]";
    }

}
