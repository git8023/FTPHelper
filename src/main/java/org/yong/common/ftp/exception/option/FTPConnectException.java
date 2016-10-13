/**
 * @FileName: FTPConnectException.java
 * @author Huang.Yong
 * @Description:
 * @Date 2016年10月13日 上午11:43:26
 *  
 */
package org.yong.common.ftp.exception.option;

import org.yong.common.ftp.exception.FTPOperationException;

/**
 * FTP 链接失败
 * 
 * @author Huang.Yong
 * @Date 2016年10月13日 上午11:43:26
 * @Version 0.1
 * 
 */
public class FTPConnectException extends FTPOperationException {

    // @Fields serialVersionUID :
    private static final long serialVersionUID = 5189244114398250180L;

    /**
     * 
     * 
     */
    public FTPConnectException() {
        super();

    }

    /**
     * 
     * 
     * @param message
     * @param cause
     */
    public FTPConnectException(String message, Throwable cause) {
        super(message, cause);

    }

    /**
     * 
     * 
     * @param message
     */
    public FTPConnectException(String message) {
        super(message);

    }

    /**
     * 
     * 
     * @param cause
     */
    public FTPConnectException(Throwable cause) {
        super(cause);

    }

}
