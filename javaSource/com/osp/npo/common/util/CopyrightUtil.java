package com.osp.npo.common.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.osp.npo.common.exception.CopyrightException;

/**
 * Copyright util class
 * 
 * @author haint
 * @version $Revision: 18041 $
 */
public class CopyrightUtil {

	/**
	 * Authenticate Copyright with customer ID
	 * 
	 * @param customerID Customer ID
	 * @param key Copyright key
	 * @return Authentication status
	 * @throws UnknownHostException
	 * @throws SocketException
	 * @throws CopyrightException
	 */
	public static boolean authenticate(String customerID, String key) throws UnknownHostException, SocketException, CopyrightException {
		String inputString = customerID + getMACAddress();
		return Crypter.matches(key, inputString);
	}
	
	/**
	 * Get MAC address of localhost
	 * 
	 * @return MAC address
	 * @throws UnknownHostException
	 * @throws SocketException
	 * @throws CopyrightException
	 */
	private static String getMACAddress() throws UnknownHostException, SocketException, CopyrightException {
		
		String mac = "";
        String os = System.getProperty("os.name");
        
        System.out.println("OS: " + os);
        
        try {
            if (os.startsWith("Windows")) {
                mac = winMACAddress();
            } else if (os.startsWith("Linux")) {
                mac = linuxParseMacAddress(linuxRunIfConfigCommand());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        System.out.println("MAC: " + mac);
        
        return mac;
	}
	
	/**
	 * Get MAC address of localhost on Windows
	 * 
	 * @return MAC address
	 * @throws UnknownHostException
	 * @throws SocketException
	 * @throws CopyrightException
	 */
	private static String winMACAddress() throws UnknownHostException, SocketException, CopyrightException {
		
		String strMacAddress = "";
		
        InetAddress address = InetAddress.getLocalHost();

        /*
         * Get NetworkInterface for the current host and then read the
         * hardware address.
         */
        NetworkInterface ni = NetworkInterface.getByInetAddress(address);
        if (ni != null) {
            byte[] mac = ni.getHardwareAddress();
            if (mac != null) {
                /*
                 * Extract each array of mac address and convert it to hexa with the
                 * following format 08-00-27-DC-4A-9E.
                 */
                for (int i = 0; i < mac.length; i++) {
                	strMacAddress += String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
                }
            } else {
                throw new CopyrightException("Address doesn't exist or is not accessible.");
            }
        } else {
        	throw new CopyrightException("Network Interface for the specified address is not found.");
        }
            
        return strMacAddress;
	}
	
	/**
	 * Parse MAC address on Linux
	 * 
	 * @param ipConfigResponse
	 * @return MAC address
	 * @throws ParseException
	 */
	private static String linuxParseMacAddress(String ipConfigResponse) throws ParseException {
        String localHost = null;
        try {
            localHost = InetAddress.getLocalHost().getHostAddress();
        } catch (java.net.UnknownHostException ex) {
            ex.printStackTrace();
            throw new ParseException(ex.getMessage(), 0);
        }
        StringTokenizer tokenizer = new StringTokenizer(ipConfigResponse, "\n");
        String lastMacAddress = null;
        while (tokenizer.hasMoreTokens()) {
            String line = tokenizer.nextToken().trim();
            boolean containsLocalHost = line.indexOf(localHost) >= 0;
            if (containsLocalHost && lastMacAddress != null) {// see if line contains IP address
                return lastMacAddress;
            }
            int macAddressPosition = line.indexOf("HWaddr");// see if line contains MAC address
            if (macAddressPosition <= 0) {
                continue;
            }
            String macAddressCandidate = line.substring(macAddressPosition + 6).trim();
            if (linuxIsMacAddress(macAddressCandidate)) {
                lastMacAddress = macAddressCandidate;
                continue;
            }
        }
        ParseException ex = new ParseException("cannot read MAC address for " + localHost + " from [" + ipConfigResponse + "]", 0);
        ex.printStackTrace();
        throw ex;
    }

	/**
	 * Check is MAC address format
	 * 
	 * @param macAddressCandidate
	 * @return true if input string is MAC address
	 */
    private static boolean linuxIsMacAddress(String macAddressCandidate) {
        Pattern macPattern = Pattern.compile("[0-9a-fA-F]{2}[-:][0-9a-fA-F]{2}[-:][0-9a-fA-F]{2}[-:][0-9a-fA-F]{2}[-:][0 -9a-fA-F]{2}[-:][0-9a-fA-F]{2}");
        Matcher m = macPattern.matcher(macAddressCandidate);
        return m.matches();
    }
 
    /**
     * Run ifconfig command on linux
     * 
     * @return command response
     * @throws IOException
     */
    private static String linuxRunIfConfigCommand() throws IOException {
        Process p = Runtime.getRuntime().exec("/sbin/ifconfig");
        InputStream stdoutStream = new BufferedInputStream(p.getInputStream());
        StringBuilder buffer = new StringBuilder();
        for (;;) {
            int c = stdoutStream.read();
            if (c == -1) {
                break;
            }
            buffer.append((char) c);
        }
        String outputText = buffer.toString();
        stdoutStream.close();
        return outputText;
    }
}
