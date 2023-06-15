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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
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
    
    public void WriteErrorToFileByDateTimeV2(String sPrmErrTitle, String sPrmErrDesc) {
        String sFileDate = getSystemDate(formatDate);
        String sFileName = sFileDate + ".log";
        String sPathFile = "";
        String sErrorDisplay = "";

        try {
            Path basePath = Paths.get(".").toAbsolutePath().normalize();
            sPathFile = basePath.resolve("Error").resolve(sPrmErrTitle).resolve(sFileName).toString();

            Path parentDir = Paths.get(sPathFile).getParent();
            if (!Files.exists(parentDir)) {
                Files.createDirectories(parentDir);
                Files.createFile(parentDir.resolve(sFileName));
            }

            try (PrintWriter pWriter = new PrintWriter(new BufferedWriter(new FileWriter(sPathFile, true)))) {
                pWriter.println(getSystemDate(formatDateTimeFull) + ": ");
                pWriter.println(sPrmErrDesc);
            }
        } catch (IOException ex) {
            sErrorDisplay = DisplayLogMessage(ex);
            Logger.getLogger(testwritelogfileclass.class.getName()).log(Level.SEVERE, null, sErrorDisplay);
        }
    }    
    
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
    
    public String getSystemDate(String format) {
        try{
            DateFormat dateFormat = new SimpleDateFormat(format,Locale.US);
            Date date = new Date();
            return dateFormat.format(date);
        }
        catch (Exception e){
            return null;
        }
    }    
    
    public String DisplayLogMessage(Exception PrmEx){
        String sReturnMessage;
        String sErrDateTime;
        String sErrString;
        String sErrFull;
        String sErrLine;
        
        StackTraceElement[] stackTrace = PrmEx.getStackTrace();
        sErrDateTime = getSystemDate(formatDateTimeFull);

        sErrString = PrmEx.getMessage();
        // sErrFull = PrmEx.getStackTrace()[0].getMethodName();
        sErrFull = stackTrace[0].getMethodName();
        // sErrLine = String.valueOf(PrmEx.getStackTrace()[1].getLineNumber());
        sErrLine = String.valueOf(stackTrace[1].getLineNumber());
        
        sErrString = sErrString + "[" + sErrFull + " - at Line No." + sErrLine + "]";
        // sErrFull = sErrDateTime + ":" + PrmEx.getStackTrace()[1].getFileName() + " --> " + PrmEx.getStackTrace()[1].getClassName() + " --> " + PrmEx.getStackTrace()[1].getMethodName();
        sErrFull = sErrDateTime + ":" + stackTrace[1].getFileName() + " --> " + stackTrace[1].getClassName() + " --> " + stackTrace[1].getMethodName();
        sErrString = sErrFull + " --> " + sErrString;
        
        sReturnMessage = sErrString;
        
        return sReturnMessage;
    }    
}
