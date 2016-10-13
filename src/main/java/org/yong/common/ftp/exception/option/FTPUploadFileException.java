/**
 * @FileName: FTPUploadFileException.java
 * @Author Huang.Yong
 * @Description:
 * @Date 2016年10月13日 下午2:12:09
 * @CopyRight 
 */
package org.yong.common.ftp.exception.option;

import org.yong.common.ftp.exception.FTPOperationException;

/**
 * @Author Huang.Yong
 * @Description: 文件上传异常
 * @Date 2016年10月13日 下午2:12:09
 * @Version 0.1
 * @CopyRight
 */
public class FTPUploadFileException extends FTPOperationException {

    // @Fields serialVersionUID :
    private static final long serialVersionUID = -1634199319547590818L;

    /**
     * @Title: FTPUploadFileException
     * @Description:
     */
    public FTPUploadFileException() {
        super();
        // Auto-generated constructor stub
    }

    /**
     * @Title: FTPUploadFileException
     * @Description:
     * @param message
     * @param cause
     */
    public FTPUploadFileException(String message, Throwable cause) {
        super(message, cause);
        // Auto-generated constructor stub
    }

    /**
     * @Title: FTPUploadFileException
     * @Description:
     * @param message
     */
    public FTPUploadFileException(String message) {
        super(message);
        // Auto-generated constructor stub
    }

    /**
     * @Title: FTPUploadFileException
     * @Description:
     * @param cause
     */
    public FTPUploadFileException(Throwable cause) {
        super(cause);
        // Auto-generated constructor stub
    }

}
