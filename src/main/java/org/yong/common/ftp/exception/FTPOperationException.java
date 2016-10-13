/**
 * @FileName: FTPOperationException.java
 * @author Huang.Yong
 * 
 * @Date 2016年10月13日 下午2:24:18
 *  
 */
package org.yong.common.ftp.exception;

/**
 * FTP操作异常
 * 
 * @author Huang.Yong 2016年10月13日 下午2:24:18
 * @version 0.1
 * 
 */
public class FTPOperationException extends RuntimeException {

    // @Fields serialVersionUID :
    private static final long serialVersionUID = 3612575000270489055L;

    public FTPOperationException() {
        super();
        // Auto-generated constructor stub
    }

    /**
     * 
     * 
     * @param message
     * @param cause
     */
    public FTPOperationException(String message, Throwable cause) {
        super(message, cause);
        // Auto-generated constructor stub
    }

    /**
     * 
     * 
     * @param message
     */
    public FTPOperationException(String message) {
        super(message);
        // Auto-generated constructor stub
    }

    /**
     * 
     * 
     * @param cause
     */
    public FTPOperationException(Throwable cause) {
        super(cause);
        // Auto-generated constructor stub
    }

}
