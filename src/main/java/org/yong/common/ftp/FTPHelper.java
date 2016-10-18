/**
 * @FileName: FTPHelper.java
 * @author Huang.Yong
 * 
 * 2016年10月13日 上午11:15:42
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
 * FTP工具, 依赖
 * 
 * @author Huang.Yong
 * 
 *         <pre>
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
 * 
 *         <pre>
 * // &lt;b&gt;示例代码&lt;/b&gt;
 * Builder builder = FTPConfig.createBuilder();
 * builder.setAutoLogin(true).setDefaultDirectory(&quot;/&quot;).setHost(&quot;192.168.0.130&quot;).setUserName(&quot;admin&quot;).setPassword(&quot;admin&quot;)
 *         .setTimeout(60 * 100).setDownloadDir(&quot;D:/ftpTest/&quot;);
 * FTPConfig ftpConfig = builder.build();
 * FTPHelper ftpHelper = new FTPHelper(ftpConfig);
 * ftpHelper.login();
 * 
 * // 通过 FtpHelper API 操作
 * List&lt;FtpFile&gt; list = ftpHelper.getFiles();
 * System.out.println(list);
 * 
 * ftpHelper.logout();
 * </pre>
 * 
 *         2016年10月13日 上午11:15:42 <br>
 *         FTPOperationException 所有API在操作失败时会抛出该异常或其子类
 * @version 0.1
 */
public class FTPHelper {

    private FTPConfig conf;

    private String currentDir;

    private FTPClient ftpClient;

    private ErrorHandler errorHandler;

    /**
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
     * FTP链接
     */
    private void connect() {
        if (null == this.ftpClient) {
            this.ftpClient = new FTPClient();
            this.ftpClient.setConnectTimeout(this.conf.getTimeout());
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
     * 文件(夹)下载
     * 
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
     * 下载目录
     * 
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
     * 下载文件
     * 
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
     * 文件下载(目录由FTPConfig.setDownloadDir()指定)
     * 
     * @param ftpFile 远程文件
     * @return File 本地文件
     */
    public File downloadFile(FtpFile ftpFile) {
        return downloadFile(ftpFile.getName());
    }

    /**
     * 设置工作目录
     * 
     * @param dir 远程目录
     * @return boolean true-成功, false-失败
     */
    public boolean setWorkingDirectory(String dir) {
        return setWorkingDirectory(dir, false);
    }

    /**
     * 设置工作目录
     * 
     * @param dir 工作目录
     * @param ensureExist true-不存在时创建, false-不存在时不创建
     * @return boolean true-成功, false-失败
     */
    public boolean setWorkingDirectory(String dir, boolean ensureExist) {
        boolean success = false;
        try {
            success = this.ftpClient.changeWorkingDirectory(dir.trim());

            boolean notExist = !success;
            if (notExist && ensureExist)
                success = makeAndSetWorkingDir(dir);

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
     * 创建目录并设置为工作目录
     * 
     * @param dir 目录
     * @return true-执行成功, false-执行失败
     * @throws IOException
     */
    private boolean makeAndSetWorkingDir(String dir) throws IOException {
        boolean success = this.ftpClient.makeDirectory(dir);
        if (success)
            setWorkingDirectory(dir);
        return success;
    }

    /**
     * 获取当前工作目录
     * 
     * @return String 当前工作目录
     */
    public String getWorkingDirectory() {
        return this.currentDir;
    }

    /**
     * 获取当前目录文件(夹)列表
     * 
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
     * 登录
     * 
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
     * 退出登录
     * 
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
     * 文件上传(当前工作目录)
     * 
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
