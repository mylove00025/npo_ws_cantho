package com.osp.npo.core;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;


/**
 * <P>
 * BLOB basic class
 * </P>
 * 
 * @author HaiNT
 * @version $Revision: 17041 $
 */
public class BlobInfo {


    /** BLOB InputStream */
    private InputStream inputStream;


    /** BLOB BYTE array */
    private byte[] binary;


    /** DB BLOB */
    private Blob blob;


    /**
     * <P>
     * Default construction
     * </P>
     * 
     */
    public BlobInfo() {
    }


    /**
     * <P>
     * Construction
     * </P>
     * 
     * @param inputStream
     */
    public BlobInfo(InputStream inputStream) {

        this.inputStream = inputStream;
    }


    /**
     * <P>
     * Construction
     * </P>
     * 
     * @param blob
     */
    public BlobInfo(Blob blob) {

        this.blob = blob;
    }


    /**
     * <P>
     * Construction
     * </P>
     * 
     * @param binary
     */
    public BlobInfo(byte[] binary) {

        this.binary = binary;
        this.inputStream = new ByteArrayInputStream(binary);
    }


    /**
     * <P>
     * Get BYTE array
     * </P>
     * 
     * @return BLOB BYTE array
     */
    public byte[] getBinary() {

        return binary;
    }



    public void setBinary(byte[] binary) {

        this.binary = binary;
        this.inputStream = new ByteArrayInputStream(binary);
    }


    public Blob getBlob() {

        return blob;
    }



    public void setBlob(Blob blob) {

        this.blob = blob;
    }



    public InputStream getInputStream() {

        return inputStream;
    }



    public void setInputStream(InputStream inputStream) {

        this.inputStream = inputStream;
    }

}
