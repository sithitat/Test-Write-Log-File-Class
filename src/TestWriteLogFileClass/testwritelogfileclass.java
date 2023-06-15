/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestWriteLogFileClass;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bcc14
 */
public class testwritelogfileclass {
    public static final String formatDate = "yyyyMMdd";
    public static final String formatDateTime = "yyyyMMddHHmm";
    public static final String formatDateTimeSecond = "yyyyMMddHHmmss";
    public static final String formatDateTimeFull = "dd/MM/yyyy HH:mm:ss";
    public static final String formatDateTimeFullAll = "E dd/MM/yyyy HH:mm:ss";
    
    public void WriteErrorToFileByDateTime(String sPrmErrTitle, String sPrmErrDesc){
        String sFileDate, sErrDateTime, sFileName;
        String sPathFile = "";
        String sFolderDate;
        String sErrorDisplay = "";
        
        FileWriter fWriter = null;
        BufferedWriter bufWriter = null;
        PrintWriter pWriter = null;
        
        sFileDate = getSystemDate(formatDateTime);
        sErrDateTime = getSystemDate(formatDateTimeFull);
        sFileName = sFileDate.substring(0, 10) + ".log";
        sFolderDate = sFileDate.substring(0, 8);
        File currentDirectory = new File(new File(".").getAbsolutePath());
        try{
            sPathFile = currentDirectory.getCanonicalPath() + "\\Error\\" + sPrmErrTitle + "\\" + sFolderDate + "\\" + sFileName;
            
            Path pathToFile = Paths.get(sPathFile);
            if(!Files.exists(pathToFile.getParent())){
                Files.createDirectories(pathToFile.getParent());
                Files.createFile(pathToFile);         
            }
            
            fWriter = new FileWriter(sPathFile, true);
            bufWriter = new BufferedWriter(fWriter);
            pWriter = new PrintWriter(bufWriter, true);
            pWriter.println(sErrDateTime + ": ");
            pWriter.println(sPrmErrDesc);
        } 
        catch (IOException ex) {
            sErrorDisplay = DisplayLogMessage(ex);
            Logger.getLogger(testwritelogfileclass.class.getName()).log(Level.SEVERE, null, sErrorDisplay);
        }
        finally{
            try {
                if (fWriter != null) fWriter.close();
                if (bufWriter != null) bufWriter.close();
                if (pWriter != null) pWriter.close();
            } catch (IOException ex) {
                sErrorDisplay = DisplayLogMessage(ex);
                Logger.getLogger(testwritelogfileclass.class.getName()).log(Level.SEVERE, null, sErrorDisplay);
            }
        }
    }
    
    public void WriteErrorToFileByDateTimeHourMin(String sPrmErrTitle, String sPrmErrDesc){
        String sFileDate, sErrDateTime, sFileName;
        String sPathFile = "";
        String sFolderDate;
        String sErrorDisplay = "";
        
        FileWriter fWriter = null;
        BufferedWriter bufWriter = null;
        PrintWriter pWriter = null;
        
        sFileDate = getSystemDate(formatDateTime);
        sErrDateTime = getSystemDate(formatDateTimeFull);
        sFileName = sFileDate.substring(0, 11) + ".log";
        sFolderDate = sFileDate.substring(0, 8);
        File currentDirectory = new File(new File(".").getAbsolutePath());
        try {
            sPathFile = currentDirectory.getCanonicalPath() + "\\Error\\" + sPrmErrTitle + "\\" + sFolderDate + "\\" + sFileName;
            
            Path pathToFile = Paths.get(sPathFile);
            if(!Files.exists(pathToFile.getParent())){
                Files.createDirectories(pathToFile.getParent());
                Files.createFile(pathToFile);         
            }
            
            fWriter = new FileWriter(sPathFile, true);
            bufWriter = new BufferedWriter(fWriter);
            pWriter = new PrintWriter(bufWriter, true);
            pWriter.println(sErrDateTime + ": ");
            pWriter.println(sPrmErrDesc);
        } catch (IOException ex) {
            sErrorDisplay = DisplayLogMessage(ex);
            Logger.getLogger(testwritelogfileclass.class.getName()).log(Level.SEVERE, null, sErrorDisplay);
        }
        finally{
            try {
                if (fWriter != null) fWriter.close();
                if (bufWriter != null) bufWriter.close();
                if (pWriter != null) pWriter.close();
            } catch (IOException ex) {
                sErrorDisplay = DisplayLogMessage(ex);
                Logger.getLogger(testwritelogfileclass.class.getName()).log(Level.SEVERE, null, sErrorDisplay);
            }
        }
    }
    
    public void WriteErrorToFile(String sPrmErrTitle, String sPrmErrDesc){
        String sFileDate, sErrDateTime, sFileName;
        String sPathFile = "";
        String sErrorDisplay = "";
        
        FileWriter fWriter = null;
        BufferedWriter bufWriter = null;
        PrintWriter pWriter = null;
        
        sFileDate = getSystemDate(formatDate);
        sErrDateTime = getSystemDate(formatDateTimeFull);
        sFileName = sFileDate + ".log";
        File currentDirectory = new File(new File(".").getAbsolutePath());
        try {
            sPathFile = currentDirectory.getCanonicalPath() + "\\Error\\" + sPrmErrTitle + "\\" + sFileName;
            
            Path pathToFile = Paths.get(sPathFile);
            if(!Files.exists(pathToFile.getParent())){
                Files.createDirectories(pathToFile.getParent());
                Files.createFile(pathToFile);         
            }
            
            fWriter = new FileWriter(sPathFile, true);
            bufWriter = new BufferedWriter(fWriter);
            pWriter = new PrintWriter(bufWriter, true);
            pWriter.println(sErrDateTime + ": ");
            pWriter.println(sPrmErrDesc);
        } catch (IOException ex) {
            sErrorDisplay = DisplayLogMessage(ex);
            Logger.getLogger(testwritelogfileclass.class.getName()).log(Level.SEVERE, null, sErrorDisplay);
        }
        finally{
            try {
                if (fWriter != null) fWriter.close();
                if (bufWriter != null) bufWriter.close();
                if (pWriter != null) pWriter.close();
            } catch (IOException ex) {
                sErrorDisplay = DisplayLogMessage(ex);
                Logger.getLogger(testwritelogfileclass.class.getName()).log(Level.SEVERE, null, sErrorDisplay);
            }
        }
    }
    
    public void WriteErrorToFile(String sPrmErrTitle, Exception e){
        String sFileDate, sErrDateTime, sFileName;
        String sPathFile = "";
        String sErrorDisplay = "";
        
        FileWriter fWriter = null;
        BufferedWriter bufWriter = null;
        PrintWriter pWriter = null;
        
        sFileDate = getSystemDate(formatDate);
        sErrDateTime = getSystemDate(formatDateTimeFull);
        sFileName = sFileDate + ".log";
        File currentDirectory = new File(new File(".").getAbsolutePath());
        try {
            sPathFile = currentDirectory.getCanonicalPath() + "\\Error\\" + sPrmErrTitle + "\\" + sFileName;
            
            Path pathToFile = Paths.get(sPathFile);
            if(!Files.exists(pathToFile.getParent())){
                Files.createDirectories(pathToFile.getParent());
                Files.createFile(pathToFile);         
            }
            fWriter = new FileWriter(sPathFile, true);
            bufWriter = new BufferedWriter(fWriter);
            pWriter = new PrintWriter(bufWriter, true);
            pWriter.println(sErrDateTime + ": ");
            // e.printStackTrace(pWriter);
            sErrorDisplay = DisplayLogMessage(e);
            pWriter.println(sErrorDisplay);
        } catch (IOException ex) {
            sErrorDisplay = DisplayLogMessage(ex);
            Logger.getLogger(testwritelogfileclass.class.getName()).log(Level.SEVERE, null, sErrorDisplay);
        }
        finally{
            try {
                if (fWriter != null) fWriter.close();
                if (bufWriter != null) bufWriter.close();
                if (pWriter != null) pWriter.close();
            } catch (IOException ex) {
                sErrorDisplay = DisplayLogMessage(ex);
                Logger.getLogger(testwritelogfileclass.class.getName()).log(Level.SEVERE, null, sErrorDisplay);
            }
        }
    }
    
    private String getSystemDate(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();
        return now.format(formatter);
    }
    
    private String DisplayLogMessage(Exception ex) {
        // Implement your logic to handle the exception and display an appropriate error message.
        return ex.getMessage();
    }
}
