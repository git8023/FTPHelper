/**
 * @FileName: FTPLoginException.java
 * @author Huang.Yong
 * @Description:
 * @Date 2016年10月13日 上午11:48:04
 *  
 */
package org.yong.common.ftp.exception.option;

import org.yong.common.ftp.exception.FTPOperationException;

/**
 * @author Huang.Yong
 * @Description: FTP登录异常
 * @Date 2016年10月13日 上午11:48:04
 * @Version 0.1
 * 
 */
public class FTPLoginException extends FTPOperationException {

    // @Fields serialVersionUID :
    private static final long serialVersionUID = -178602978452449877L;

    /**
     * 
     * @Description:
     */
    public FTPLoginException() {
        super();

    }

    /**
     * 
     * @Description:
     * @param message
     * @param cause
     */
    public FTPLoginException(String message, Throwable cause) {
        super(message, cause);

    }

    /**
     * 
     * @Description:
     * @param message
     */
    public FTPLoginException(String message) {
        super(message);

    }

    /**
     * 
     * @Description:
     * @param cause
     */
    public FTPLoginException(Throwable cause) {
        super(cause);

    }

}
