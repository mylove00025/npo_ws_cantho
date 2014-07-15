package com.osp.npo.common.util;

import java.io.File;

/**
 *
 * File Utility
 *
 * @author GiangVT
 * @version $Revision: 18978 $
 */
public class FileUtil {

    private static final String SUFFIX = ".dat";

    /**
     *
     * Create new file
     *
     * @author GiangVT
     * @param directory
     *            for file directory
     * @param prefix
     *            for file prefix
     * @return file created or null if process exception
     * @throws Exception
     *             for exception
     */
    public static File createNewFile(String directory, String prefix) throws Exception {
        File dirs = new File(directory);
        if (!dirs.exists()) {
            dirs.mkdirs();
        }
        File file = File.createTempFile(prefix, SUFFIX, dirs);
        return file;
    }
}
