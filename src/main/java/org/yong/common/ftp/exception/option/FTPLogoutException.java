/**
 * @FileName: FTPLogoutException.java
 * @Author Huang.Yong
 * @Description:
 * @Date 2016年10月13日 上午11:51:49
 * @CopyRight 
 */
package org.yong.common.ftp.exception.option;

import org.yong.common.ftp.exception.FTPOperationException;

/**
 * @Author Huang.Yong
 * @Description: FTP退出异常
 * @Date 2016年10月13日 上午11:51:49
 * @Version 0.1
 * @CopyRight
 */
public class FTPLogoutException extends FTPOperationException {

    // @Fields serialVersionUID :
    private static final long serialVersionUID = -5071447446849204587L;

    /**
     * @Title: FTPLogoutException
     * @Description:
     */
    public FTPLogoutException() {
        super();
        // Auto-generated constructor stub
    }

    /**
     * @Title: FTPLogoutException
     * @Description:
     * @param message
     * @param cause
     */
    public FTPLogoutException(String message, Throwable cause) {
        super(message, cause);
        // Auto-generated constructor stub
    }

    /**
     * @Title: FTPLogoutException
     * @Description:
     * @param message
     */
    public FTPLogoutException(String message) {
        super(message);
        // Auto-generated constructor stub
    }

    /**
     * @Title: FTPLogoutException
     * @Description:
     * @param cause
     */
    public FTPLogoutException(Throwable cause) {
        super(cause);
        // Auto-generated constructor stub
    }

}
