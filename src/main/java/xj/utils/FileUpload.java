/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xj.utils;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import net.sourceforge.stripes.action.FileBean;
import xj.core.session.XjSessionContext;

/**
 *
 * @author Hendranto Nugroho
 */
public class FileUpload {
    String resultUrl;
    String resultFile;
    
    protected XjSessionContext context;

    public FileUpload(XjSessionContext context) {
        this.context = context;
    }
    
    private static final Logger LOG = Logger.getLogger(FileUpload.class.getName());

    public String getUploadUrl() {
        return resultUrl;
    }

    public String getUploadFile() {
        return resultFile;
    }
    
    public boolean uploadDocument(FileBean file) {
        String uploadFolder = context.getSystemParameter("Xj-Upload-Folder");
        String uploadUrl = context.getSystemParameter("Xj-Upload-Url");
        
        if (uploadFolder == null || uploadUrl == null) {
            return false;
        }
        
        Date today = new Date();
        String subFolder = new SimpleDateFormat("yyyy/MM").format(today);
        String prefixName = new SimpleDateFormat("yyyyMMddHHmmss").format(today);

        // set target folder
        resultFile = uploadFolder + subFolder + "/" + prefixName + "_" + file.getFileName();
        File result;
        try {
            result = new File(resultFile);
            file.save(result);
        } catch(IOException e) {
            return false;
        }
        
        // set url
        resultUrl = uploadUrl + subFolder + "/" + prefixName + "_" + file.getFileName();
        
        return true;
    }
    
    
}
