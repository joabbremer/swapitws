package com.swapit.ws.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
 
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.swapit.ws.controller.PropositionImageController;
 
@Path("/propositionIMG")
public class PropositionIMGService {
 
    public static final String UPLOAD_FILE_SERVER = "D://SWAPITIMG/";
 
    @GET
    @Path("/download")
    @Produces({"image/png", "image/jpg", "image/gif"})
    public Response downloadImageFile() {
 
        File file = new File("D://SWAPITIMG/teste.jpg");
 
       // String extension = getFileExtension(file);
        
       // ResponseBuilder responseBuilder = Response.ok((Object) file);
       // responseBuilder.header("Content-Disposition", "attachment; filename=\"MyImageFile."+extension+"\"");
        return Response.ok(file).build();
    }

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadImageFile(
            @FormDataParam("image") InputStream fileInputStream,
            @FormDataParam("image") FormDataContentDisposition fileFormDataContentDisposition) {
 
    	PropositionImageController propIMGCtrl = new PropositionImageController();
        String fileName = propIMGCtrl.save();
        String uploadFilePath = null;
 
        try {
            uploadFilePath = writeToFileServer(fileInputStream, fileName);
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        finally{
        }
        return Response.ok("File uploaded successfully at " + uploadFilePath).build();
    }
 
    private String writeToFileServer(InputStream inputStream, String fileName) throws IOException {
 
        OutputStream outputStream = null;
        String qualifiedUploadFilePath = UPLOAD_FILE_SERVER + fileName;
 
        try {
            outputStream = new FileOutputStream(new File(qualifiedUploadFilePath));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            outputStream.flush();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally{
            outputStream.close();
        }
        return qualifiedUploadFilePath;
    }
    
    private String getFileExtension(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }
}