/**
 * @FileName: FTPQueryException.java
 * @author Huang.Yong
 * @Description:
 * @Date 2016年10月13日 下午1:08:52
 *  
 */
package org.yong.common.ftp.exception.option;

import org.yong.common.ftp.exception.FTPOperationException;

/**
 * @author Huang.Yong
 * @Description: FTP查询文件异常
 * @Date 2016年10月13日 下午1:08:52
 * @Version 0.1
 * 
 */
public class FTPQueryException extends FTPOperationException {

    // @Fields serialVersionUID :
    private static final long serialVersionUID = -3217897495581361835L;

    /**
     * 
     * @Description:
     */
    public FTPQueryException() {
        super();
        // Auto-generated constructor stub
    }

    /**
     * 
     * @Description:
     * @param message
     * @param cause
     */
    public FTPQueryException(String message, Throwable cause) {
        super(message, cause);
        // Auto-generated constructor stub
    }

    /**
     * 
     * @Description:
     * @param message
     */
    public FTPQueryException(String message) {
        super(message);
        // Auto-generated constructor stub
    }

    /**
     * 
     * @Description:
     * @param cause
     */
    public FTPQueryException(Throwable cause) {
        super(cause);
        // Auto-generated constructor stub
    }

}
