/**
 * @FileName: FtpFile.java
 * @Author Huang.Yong
 * @Description:
 * @Date 2016年10月13日 下午1:13:16
 * @CopyRight 
 */
package org.yong.common.ftp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.net.ftp.FTPFile;

/**
 * @Author Huang.Yong
 * @Description: FTP文件对象
 * @Date 2016年10月13日 下午1:13:16
 * @Version 0.1
 * @CopyRight
 */
public class FtpFile {

    private FTPFile file;

    private String currentDir;

    private FtpFile(FTPFile file, String currentDir) {
        super();
        this.file = file;
        this.currentDir = currentDir;
    }

    public static Collection<? extends FtpFile> asList(FTPFile[] ftpFiles, String currentDir) {
        List<FtpFile> list = new ArrayList<FtpFile>();
        if (null == ftpFiles)
            return list;
        for (FTPFile ftpFile : ftpFiles)
            list.add(new FtpFile(ftpFile, currentDir));
        return list;
    }

    /**
     * @Title: getName
     * @Description: 获取文件名
     * @return String
     */
    public String getName() {
        return this.file.getName();
    }

    @Override
    public String toString() {
        return "FtpFile [file=" + file + "]";
    }

    /**
     * @Title: isDirectory
     * @Description: 当前文件是否为文件夹
     * @return boolean true-文件夹, false-文件
     */
    public boolean isDirectory() {
        return this.file.isDirectory();
    }

    /**
     * @Title: getCurrentDir
     * @Description: 获取当前远程目录
     * @return String 当前文件所属远程目录路径
     */
    public String getCurrentDir() {
        return currentDir;
    }

}
