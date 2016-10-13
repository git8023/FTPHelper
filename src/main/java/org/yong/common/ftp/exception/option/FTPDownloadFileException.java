/**
 * @FileName: FTPDownloadException.java
 * @Author Huang.Yong
 * @Description:
 * @Date 2016年10月13日 下午1:37:26
 * @CopyRight 
 */
package org.yong.common.ftp.exception.option;

import org.yong.common.ftp.exception.FTPOperationException;

/**
 * @Author Huang.Yong
 * @Description: 文件下载异常
 * @Date 2016年10月13日 下午1:37:26
 * @Version 0.1
 * @CopyRight
 */
public class FTPDownloadFileException extends FTPOperationException {

    // @Fields serialVersionUID :
    private static final long serialVersionUID = -8831082536122978930L;

    /**
     * @Title: FTPDownloadFileException
     * @Description:
     */
    public FTPDownloadFileException() {
        super();
        // Auto-generated constructor stub
    }

    /**
     * @Title: FTPDownloadFileException
     * @Description:
     * @param message
     * @param cause
     */
    public FTPDownloadFileException(String message, Throwable cause) {
        super(message, cause);
        // Auto-generated constructor stub
    }

    /**
     * @Title: FTPDownloadFileException
     * @Description:
     * @param message
     */
    public FTPDownloadFileException(String message) {
        super(message);
        // Auto-generated constructor stub
    }

    /**
     * @Title: FTPDownloadFileException
     * @Description:
     * @param cause
     */
    public FTPDownloadFileException(Throwable cause) {
        super(cause);
        // Auto-generated constructor stub
    }

}
