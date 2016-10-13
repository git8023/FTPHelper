/**
 * @FileName: FTPQueryException.java
 * @Author Huang.Yong
 * @Description:
 * @Date 2016年10月13日 下午1:08:52
 * @CopyRight 
 */
package org.yong.common.ftp.exception.option;

import org.yong.common.ftp.exception.FTPOperationException;

/**
 * @Author Huang.Yong
 * @Description: FTP查询文件异常
 * @Date 2016年10月13日 下午1:08:52
 * @Version 0.1
 * @CopyRight
 */
public class FTPQueryException extends FTPOperationException {

    // @Fields serialVersionUID :
    private static final long serialVersionUID = -3217897495581361835L;

    /**
     * @Title: FTPQueryException
     * @Description:
     */
    public FTPQueryException() {
        super();
        // Auto-generated constructor stub
    }

    /**
     * @Title: FTPQueryException
     * @Description:
     * @param message
     * @param cause
     */
    public FTPQueryException(String message, Throwable cause) {
        super(message, cause);
        // Auto-generated constructor stub
    }

    /**
     * @Title: FTPQueryException
     * @Description:
     * @param message
     */
    public FTPQueryException(String message) {
        super(message);
        // Auto-generated constructor stub
    }

    /**
     * @Title: FTPQueryException
     * @Description:
     * @param cause
     */
    public FTPQueryException(Throwable cause) {
        super(cause);
        // Auto-generated constructor stub
    }

}
