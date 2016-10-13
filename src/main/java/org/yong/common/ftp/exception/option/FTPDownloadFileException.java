/**
 * @FileName: FTPDownloadException.java
 * @author Huang.Yong
 * @Description:
 * @Date 2016年10月13日 下午1:37:26
 *  
 */
package org.yong.common.ftp.exception.option;

import org.yong.common.ftp.exception.FTPOperationException;

/**
 * @author Huang.Yong
 * @Description: 文件下载异常
 * @Date 2016年10月13日 下午1:37:26
 * @Version 0.1
 * 
 */
public class FTPDownloadFileException extends FTPOperationException {

    // @Fields serialVersionUID :
    private static final long serialVersionUID = -8831082536122978930L;

    /**
     * 
     * @Description:
     */
    public FTPDownloadFileException() {
        super();
        // Auto-generated constructor stub
    }

    /**
     * 
     * @Description:
     * @param message
     * @param cause
     */
    public FTPDownloadFileException(String message, Throwable cause) {
        super(message, cause);
        // Auto-generated constructor stub
    }

    /**
     * 
     * @Description:
     * @param message
     */
    public FTPDownloadFileException(String message) {
        super(message);
        // Auto-generated constructor stub
    }

    /**
     * 
     * @Description:
     * @param cause
     */
    public FTPDownloadFileException(Throwable cause) {
        super(cause);
        // Auto-generated constructor stub
    }

}
