/**
 * @FileName: FTPOperationException.java
 * @Author Huang.Yong
 * @Description:
 * @Date 2016年10月13日 下午2:24:18
 * @CopyRight 
 */
package org.yong.common.ftp.exception;

/**
 * @Author Huang.Yong
 * @Description: FTP操作异常
 * @Date 2016年10月13日 下午2:24:18
 * @Version 0.1
 * @CopyRight
 */
public class FTPOperationException extends RuntimeException {

    // @Fields serialVersionUID :
    private static final long serialVersionUID = 3612575000270489055L;

    /**
     * @Title: FTPOperationException
     * @Description:
     */
    public FTPOperationException() {
        super();
        // Auto-generated constructor stub
    }

    /**
     * @Title: FTPOperationException
     * @Description:
     * @param message
     * @param cause
     */
    public FTPOperationException(String message, Throwable cause) {
        super(message, cause);
        // Auto-generated constructor stub
    }

    /**
     * @Title: FTPOperationException
     * @Description:
     * @param message
     */
    public FTPOperationException(String message) {
        super(message);
        // Auto-generated constructor stub
    }

    /**
     * @Title: FTPOperationException
     * @Description:
     * @param cause
     */
    public FTPOperationException(Throwable cause) {
        super(cause);
        // Auto-generated constructor stub
    }

}
