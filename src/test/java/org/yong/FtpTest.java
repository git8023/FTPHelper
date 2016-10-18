/**
 * @FileName: FtpTest.java
 * @Author Huang.Yong
 * @Description:
 * @Date 2016年10月13日 上午9:42:48
 * @CopyRight 
 */
package org.yong;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.junit.Test;
import org.yong.common.ftp.FTPConfig;
import org.yong.common.ftp.FTPConfig.Builder;
import org.yong.common.ftp.FTPHelper;
import org.yong.common.ftp.FtpFile;
import org.yong.common.ftp.exception.FTPOperationException;
import org.yong.common.ftp.handler.ErrorHandler;

/**
 * @Author Huang.Yong
 * @Description: FTP测试
 * @Date 2016年10月13日 上午9:42:48
 * @Version 0.1
 * @CopyRight
 */
public class FtpTest {

    @Test
    public void test1() throws Exception {
        FTPClient ftpClient = new FTPClient();

        String hostname = "192.168.0.130";
        int port = 21;
        ftpClient.connect(hostname, port);

        String password = "admin";
        // String username = "admin";
        String username = "admin";
        boolean logined = ftpClient.login(username, password);
        System.out.println(logined);
        logined = ftpClient.login(username, password);
        System.out.println(logined);

        FTPFile[] files = ftpClient.listFiles();
        for (FTPFile ftpFile : files) {
            System.out.println(ftpFile);
        }
    }

    @Test
    public void testFtpHelper() throws Exception {
        Builder builder = FTPConfig.createBuilder();
        builder.setAutoLogin(true).setDefaultDirectory("/").setHost("192.168.0.130").setUserName("admin").setPassword("admin")
                .setTimeout(60 * 100).setDownloadDir("D:/");
        FTPConfig ftpConfig = builder.build();
        FTPHelper ftpHelper = new FTPHelper(ftpConfig);
        ftpHelper.login();

        List<FtpFile> list = ftpHelper.getFiles();
        File file = ftpHelper.downloadFile(list.get(1));
        System.out.println(file.getAbsolutePath() + "\t" + file.length());

        // change
        String txt = FileUtils.readFileToString(file);
        txt += (txt + "\n123456");
        FileUtils.write(file, txt);
        ftpHelper.upload(file);

        boolean success = ftpHelper.setWorkingDirectory("/dir/");
        System.out.println("setWorkingDirectory:" + success);

        String dir = ftpHelper.getWorkingDirectory();
        System.err.println(dir);

        ftpHelper.logout();
    }

    @Test
    public void testDownload() throws Exception {
        Builder builder = FTPConfig.createBuilder();
        builder
            .setAutoLogin(true)
            .setDefaultDirectory("/")
            .setHost("192.168.0.130")
            .setUserName("admin")
            .setPassword("123456")
            .setTimeout(60 * 100)
            .setDownloadDir("D:/")
            .setErrorHandler(new ErrorHandler() {
                public void handle(FTPOperationException e) {
                    System.err.println(e);
                }
            });
        FTPConfig ftpConfig = builder.build();
        FTPHelper ftpHelper = new FTPHelper(ftpConfig);
        ftpHelper.login();

        File file = ftpHelper.downloadFile("/dir/xxx.txt");
        System.out.println(file);
    }

    @Test
    public void testSetWorkingDir() throws Exception {
        Builder builder = FTPConfig.createBuilder();
        builder
            .setAutoLogin(true)
            .setDefaultDirectory("/")
            .setHost("192.168.0.130")
            .setUserName("admin")
            .setPassword("123456")
            .setTimeout(60 * 100)
            .setDownloadDir("D:/")
            .setErrorHandler(new ErrorHandler() {
                public void handle(FTPOperationException e) {
                    System.err.println(e);
                }
            });
        FTPHelper ftpHelper = new FTPHelper(builder.build());
        ftpHelper.login();
        boolean success = ftpHelper.setWorkingDirectory("/0008/", true);
        assertTrue(success);
    }
}
