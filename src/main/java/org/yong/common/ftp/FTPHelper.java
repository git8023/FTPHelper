/**
 * @FileName: FTPHelper.java
 * @Author Huang.Yong
 * @Description:
 * @Date 2016年10月13日 上午11:15:42
 * @CopyRight 
 */
package org.yong.common.ftp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.yong.common.ftp.exception.FTPOperationException;
import org.yong.common.ftp.exception.option.FTPConnectException;
import org.yong.common.ftp.exception.option.FTPDownloadFileException;
import org.yong.common.ftp.exception.option.FTPLoginException;
import org.yong.common.ftp.exception.option.FTPLogoutException;
import org.yong.common.ftp.exception.option.FTPQueryException;
import org.yong.common.ftp.exception.option.FTPUploadFileException;
import org.yong.common.ftp.handler.ErrorHandler;

/**
 * @Author Huang.Yong
 * @Description: FTP工具, 依赖
 * <pre>
 *  &lt;dependency&gt;
 *    &lt;groupId&gt;commons-net&lt;/groupId&gt;
 *    &lt;artifactId&gt;commons-net&lt;/artifactId&gt;
 *    &lt;version&gt;3.3&lt;/version&gt;
 *  &lt;/dependency&gt;
 *
 *  &lt;dependency&gt;
 *      &lt;groupId&gt;commons-io&lt;/groupId&gt;
 *      &lt;artifactId&gt;commons-io&lt;/artifactId&gt;
 *      &lt;version&gt;2.4&lt;/version&gt;
 *  &lt;/dependency&gt;
 * </pre>
 * <pre>
 * // <b>示例代码</b>
 * Builder builder = FTPConfig.createBuilder();
 * builder
 *     .setAutoLogin(true)
 *     .setDefaultDirectory("/")
 *     .setHost("192.168.0.130")
 *     .setUserName("admin")
 *     .setPassword("admin")
 *     .setTimeout(60*100)
 *     .setDownloadDir("D:/ftpTest/");
 * FTPConfig ftpConfig = builder.build();
 * FTPHelper ftpHelper = new FTPHelper(ftpConfig);
 * ftpHelper.login();
 * List&lt;FtpFile&gt; list = ftpHelper.getFiles();
 * System.out.println(list);
 * ftpHelper.logout();
 * </pre>
 * @Date 2016年10月13日 上午11:15:42
 * @Version 0.1
 * @CopyRight
 * @throws FTPOperationException 所有API在操作失败时会抛出该异常或其子类
 */
public class FTPHelper {

    private FTPConfig conf;

    private String currentDir;

    private FTPClient ftpClient;

    private ErrorHandler errorHandler;

    /**
     * @Title: FTPHelper
     * @Description:
     * @param ftpConfig 配置对象
     */
    public FTPHelper(FTPConfig ftpConfig) {
        super();
        this.conf = ftpConfig;
        if (this.conf.isAutoLogin())
            login();
        this.currentDir = this.conf.getDefaultDirectory();
        this.errorHandler = this.conf.getErrorHandler();
    }

    /**
     * @Title: connect
     * @Description: FTP链接
     */
    private void connect() {
        if (null == this.ftpClient) {
            this.ftpClient = new FTPClient();
        }

        try {
            this.ftpClient.connect(this.conf.getHost(), this.conf.getPort());
        } catch (Exception e) {
            handleError(new FTPConnectException("FTP connect failed.", e));
        }
    }

    private void handleError(FTPOperationException e) {
        if (null != this.errorHandler) {
            this.errorHandler.handle(e);
        } else {
            throw e;
        }
    }

    /**
     * @Title: download
     * @Description: 文件(夹)下载
     * @param ftpFile FTP文件对象
     * @return File 本地文件对象
     */
    @Deprecated
    public File download(FtpFile ftpFile) {
        if (ftpFile.isDirectory())
            return downloadDir(ftpFile);
        return downloadFile(ftpFile);
    }

    /**
     * @Title: downloadDir
     * @Description: 下载目录
     * @param ftpFile 远程目录
     * @return File 本地目录
     */
    @Deprecated
    public File downloadDir(FtpFile ftpFile) {
        // TODO Download directory is not currently supported.
        handleError(new FTPOperationException("Download directory is not currently supported."));
        return null;
    }

    /**
     * @Title: downloadFile
     * @Description: 下载文件
     * @param remoteFilePath 远程文件路径
     * @return File 本地文件
     */
    public File downloadFile(String remoteFilePath) {
        File file = new File(this.conf.getDownloadDir() + "/" + remoteFilePath.trim() + "/");
        File dir = file.getParentFile();
        if (!dir.exists())
            dir.mkdirs();

        boolean success = false;
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            success = this.ftpClient.retrieveFile(remoteFilePath, out);
        } catch (Exception e) {
            handleError(new FTPDownloadFileException("FTP download file failed", e));
        } finally {
            IOUtils.closeQuietly(out);
        }
        return success ? file : null;
    }

    /**
     * @Title: downloadFile
     * @Description: 文件下载(目录由FTPConfig.setDownloadDir()指定)
     * @param ftpFile 远程文件
     * @return File 本地文件
     */
    public File downloadFile(FtpFile ftpFile) {
        return downloadFile(ftpFile.getName());
    }

    /**
     * @Title: setWorkingDirectory
     * @Description: 设置工作目录
     * @param dir 远程目录
     * @return boolean true-成功, false-失败
     */
    public boolean setWorkingDirectory(String dir) {
        boolean success = false;
        try {
            success = this.ftpClient.changeWorkingDirectory(dir.trim());
            if (success)
                this.currentDir = dir;
            return success;
        } catch (IOException e) {
            handleError(new FTPQueryException("Set remote directory error", e));
            success = false;
        }
        return success;
    }

    /**
     * @Title: getWorkingDirectory
     * @Description: 获取当前工作目录
     * @return String 当前工作目录
     */
    public String getWorkingDirectory() {
        return this.currentDir;
    }

    /**
     * @Title: getFiles
     * @Description: 获取当前目录文件(夹)列表
     * @return List&lt;String&gt; 文件列表
     * @throws IOException
     */
    public List<FtpFile> getFiles() throws IOException {
        List<FtpFile> pathList = new ArrayList<FtpFile>();
        try {
            FTPFile[] ftpFiles = this.ftpClient.listFiles();
            if (null != ftpFiles)
                pathList.addAll(FtpFile.asList(ftpFiles, this.currentDir));
        } catch (Exception e) {
            handleError(new FTPQueryException("FTP query files failed", e));
        }
        return pathList;
    }

    /**
     * @Title: login
     * @Description: 登录
     * @return FTPClient
     */
    public boolean login() {
        boolean success = false;
        try {
            connect();
            success = this.ftpClient.login(this.conf.getUserName(), this.conf.getPassword());
            return success;
        } catch (IOException e) {
            handleError(new FTPLoginException("FTP login failed", e));
            success = false;
        }
        return success;
    }

    /**
     * @Title: logout
     * @Description: 退出登录
     * @return boolean
     */
    public boolean logout() {
        boolean success = false;
        try {
            connect();
            success = this.ftpClient.logout();
        } catch (Exception e) {
            handleError(new FTPLogoutException("FTP logout failed", e));
            success = false;
        }
        return success;
    }

    /**
     * @Title: upload
     * @Description: 文件上传(当前工作目录)
     * @param file 目标文件
     */
    public void upload(File file) {
        String remote = file.getName();
        OutputStream out = null;
        try {
            out = this.ftpClient.storeFileStream(remote);
            FileUtils.copyFile(file, out);
        } catch (Exception e) {
            handleError(new FTPUploadFileException("FTP upload file error.", e));
        } finally {
            IOUtils.closeQuietly(out);
        }
    }

}
