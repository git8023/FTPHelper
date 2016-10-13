/**
 * @FileName: ErrorHandler.java
 * @Author Huang.Yong
 * @Description:
 * @Date 2016年10月13日 下午3:12:09
 * @CopyRight 
 */
package org.yong.common.ftp.handler;

import org.yong.common.ftp.exception.FTPOperationException;

/**
 * @Author Huang.Yong
 * @Description: 统一异常处理器
 * @Date 2016年10月13日 下午3:12:09
 * @Version 0.1
 * @CopyRight
 */
public interface ErrorHandler {

    /**
     * @Title: handle
     * @Description: 处理异常
     * @param e 异常对象
     */
    public void handle(FTPOperationException e);

}
