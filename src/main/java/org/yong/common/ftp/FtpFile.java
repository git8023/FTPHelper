/**
 * @FileName: FtpFile.java
 * @author Huang.Yong
 * 
 * @Date 2016年10月13日 下午1:13:16
 *  
 */
package org.yong.common.ftp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.net.ftp.FTPFile;

/**
 * @author Huang.Yong FTP文件对象
 * @Date 2016年10月13日 下午1:13:16
 * @version 0.1
 * 
 */
public class FtpFile {

    private FTPFile file;

    private String currentDir;

    /**
     * @param file 远程文件
     * @param currentDir 文件所属目录
     */
    private FtpFile(FTPFile file, String currentDir) {
        super();
        this.file = file;
        this.currentDir = currentDir;
    }

    /**
     * 
     * 远程文件数组转换为列表
     * 
     * @param ftpFiles 远程文件数组
     * @param currentDir 文件所属目录
     * @return Collection&lt;? extends FtpFile&gt; 远程文件列表
     */
    public static Collection<? extends FtpFile> asList(FTPFile[] ftpFiles, String currentDir) {
        List<FtpFile> list = new ArrayList<FtpFile>();
        if (null == ftpFiles)
            return list;
        for (FTPFile ftpFile : ftpFiles)
            list.add(new FtpFile(ftpFile, currentDir));
        return list;
    }

    /**
     * 
     * 获取文件名
     * 
     * @return String
     */
    public String getName() {
        return this.file.getName();
    }

    /**
     * 
     * 当前文件是否为文件夹
     * 
     * @return boolean true-文件夹, false-文件
     */
    public boolean isDirectory() {
        return this.file.isDirectory();
    }

    /**
     * 
     * 获取当前远程目录
     * 
     * @return String 当前文件所属远程目录路径
     */
    public String getCurrentDir() {
        return currentDir;
    }

    @Override
    public String toString() {
        return "FtpFile [file=" + file + ", currentDir=" + currentDir + "]";
    }

}
