/**
 * @FileName: FTPLoginException.java
 * @Author Huang.Yong
 * @Description:
 * @Date 2016年10月13日 上午11:48:04
 * @CopyRight 
 */
package org.yong.common.ftp.exception.option;

import org.yong.common.ftp.exception.FTPOperationException;

/**
 * @Author Huang.Yong
 * @Description: FTP登录异常
 * @Date 2016年10月13日 上午11:48:04
 * @Version 0.1
 * @CopyRight
 */
public class FTPLoginException extends FTPOperationException {

    // @Fields serialVersionUID :
    private static final long serialVersionUID = -178602978452449877L;

    /**
     * @Title: FTPLoginException
     * @Description:
     */
    public FTPLoginException() {
        super();

    }

    /**
     * @Title: FTPLoginException
     * @Description:
     * @param message
     * @param cause
     */
    public FTPLoginException(String message, Throwable cause) {
        super(message, cause);

    }

    /**
     * @Title: FTPLoginException
     * @Description:
     * @param message
     */
    public FTPLoginException(String message) {
        super(message);

    }

    /**
     * @Title: FTPLoginException
     * @Description:
     * @param cause
     */
    public FTPLoginException(Throwable cause) {
        super(cause);

    }

}
