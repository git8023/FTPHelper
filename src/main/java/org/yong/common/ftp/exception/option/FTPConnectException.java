/**
 * @FileName: FTPConnectException.java
 * @Author Huang.Yong
 * @Description:
 * @Date 2016年10月13日 上午11:43:26
 * @CopyRight 
 */
package org.yong.common.ftp.exception.option;

import org.yong.common.ftp.exception.FTPOperationException;

/**
 * @Author Huang.Yong
 * @Description: FTP 链接失败
 * @Date 2016年10月13日 上午11:43:26
 * @Version 0.1
 * @CopyRight
 */
public class FTPConnectException extends FTPOperationException {

    // @Fields serialVersionUID :
    private static final long serialVersionUID = 5189244114398250180L;

    /**
     * @Title: FTPConnectException
     * @Description:TODO
     */
    public FTPConnectException() {
        super();

    }

    /**
     * @Title: FTPConnectException
     * @Description:TODO
     * @param message
     * @param cause
     */
    public FTPConnectException(String message, Throwable cause) {
        super(message, cause);

    }

    /**
     * @Title: FTPConnectException
     * @Description:TODO
     * @param message
     */
    public FTPConnectException(String message) {
        super(message);

    }

    /**
     * @Title: FTPConnectException
     * @Description:TODO
     * @param cause
     */
    public FTPConnectException(Throwable cause) {
        super(cause);

    }

}
