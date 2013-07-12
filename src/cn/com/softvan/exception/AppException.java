/*
 * 应用程序异常类
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2013.11.09  wuxiaogang     
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2013 adsp System. - All Rights Reserved.
 *
 */
package cn.com.softvan.exception;

/**
 * <p>应用程序异常类<p>
 * @author wuxiaogang
 */
public class AppException extends Exception {

    /**
	 * 序列号
	 */
	private static final long serialVersionUID = 1205967598245394967L;

	/** 异常ID */
    private String errId;

    /** エラーフィールド */
    private String fieldName;

    /** 异常信息 */
    private String[] errMsgs;

    /**
     * <p>构造函数</p>
     */
    public AppException() {
        super();
    }
    /**
     * <p>构造函数</p>
     * @param e 异常
     */
    public AppException(Throwable e) {
        super(e);
    }
    /**
     * <p>构造函数</p>
     * @param errId 异常ID
     */
    public AppException(String errId) {
        super(errId);
        this.errId = errId;
    }
    /**
     * <p>构造函数</p>
     * @param errId 异常ID
     * @param e 异常
     */
    public AppException(String errId, Throwable e) {
        super(errId, e);
        this.errId = errId;
    }
    /**
     * <p>构造函数</p>
     * @param errId 异常ID
     * @param fieldname フィールド名
     */
    public AppException(String errId, String fieldname) {
        this.errId = errId;
        this.fieldName = fieldname;
    }
    /**
     * <p>构造函数</p>
     * @param errId 异常ID
     * @param fieldname フィールド名
     * @param e 异常
     */
    public AppException(String errId, String fieldname, Throwable e) {
        super(errId, e);
        this.errId = errId;
        this.fieldName = fieldname;
    }
    /**
     * <p>构造函数</p>
     * @param errId 异常ID
     * @param errMsgs 异常信息
     */
    public AppException(String errId, String[] errMsgs) {
        this(errId, errMsgs, null);
    }
    /**
     * <p>构造函数</p>
     * @param errId 异常ID
     * @param errMsgs 异常信息
     * @param e 异常
     */
    public AppException(String errId, String[] errMsgs, Throwable e) {
        super(errId, e);
        this.errId = errId;
        this.errMsgs = errMsgs;
    }
    /**
     * <p>构造函数</p>
     * @param errId 异常ID
     * @param fieldname フィールド名
     * @param errMsgs 异常信息
     */
    public AppException(String errId, String fieldname, String[] errMsgs) {
        this(errId, fieldname, errMsgs, null);
    }
    /**
     * <p>构造函数</p>
     * @param errId 异常ID
     * @param fieldname フィールド名
     * @param errMsgs 异常信息
     * @param e 异常
     */
    public AppException(String errId, String fieldname, String[] errMsgs, Throwable e) {
        super(errId, e);
        this.errId = errId;
        this.fieldName = fieldname;
        this.errMsgs = errMsgs;
    }
    /**
	 * 异常ID取得
	 * @return 异常ID
	 */
	public String getErrId() {
	    return errId;
	}
	/**
	 * 异常ID设定
	 * @param errId 异常ID
	 */
	public void setErrId(String errId) {
	    this.errId = errId;
	}
	/**
	 * エラーフィールド取得
	 * @return エラーフィールド
	 */
	public String getFieldName() {
	    return fieldName;
	}
	/**
	 * エラーフィールド设定
	 * @param fieldName エラーフィールド
	 */
	public void setFieldName(String fieldName) {
	    this.fieldName = fieldName;
	}
	/**
	 * 异常信息取得
	 * @return 异常信息
	 */
	public String[] getErrMsgs() {
	    return errMsgs;
	}
	/**
	 * 异常信息设定
	 * @param errMsgs 异常信息
	 */
	public void setErrMsgs(String[] errMsgs) {
	    this.errMsgs = errMsgs;
	}
}
