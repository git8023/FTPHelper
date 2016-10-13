/**
 * @FileName: ErrorHandler.java
 * @author Huang.Yong
 * @Description:
 * @Date 2016年10月13日 下午3:12:09
 *  
 */
package org.yong.common.ftp.handler;

import org.yong.common.ftp.exception.FTPOperationException;

/**
 * 统一异常处理器
 * 
 * @author Huang.Yong 2016年10月13日 下午3:12:09
 * @version 0.1
 * 
 */
public interface ErrorHandler {

    /**
     * 处理异常
     * 
     * @param e 异常对象
     */
    public void handle(FTPOperationException e);

}
