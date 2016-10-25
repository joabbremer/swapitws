package com.swapit.ws.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.BodyPart;
import org.glassfish.jersey.media.multipart.BodyPartEntity;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;

import com.swapit.ws.controller.PropositionImageController;
 
@Path("/propositionIMG")
public class PropositionIMGService {
 
    public static final String UPLOAD_FILE_SERVER = "D://SWAPITIMG/";
 
    @POST
    @Path("/download/{imageID}")
    @Produces({"image/png", "image/jpg", "image/gif"})
    public Response downloadOneImageFile(@PathParam("imageID") String imageID) {
 
        File file = new File("D://SWAPITIMG//"+ imageID +".jpg");
 
       // String extension = getFileExtension(file);
        
       // ResponseBuilder responseBuilder = Response.ok((Object) file);
       // responseBuilder.header("Content-Disposition", "attachment; filename=\"MyImageFile."+extension+"\"");
        return Response.ok(file).build();
    }


    @POST
    @Path("/upload")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
     public Response uploadMultipleFile(FormDataMultiPart multiform) {

    	PropositionImageController propIMGCtrl = new PropositionImageController();
    	List<String> fileName = new ArrayList<String>();
        BodyPartEntity bodyPartEntity;
        String uploadedFileLocation;
        for(BodyPart part: multiform.getBodyParts()){
            bodyPartEntity = (BodyPartEntity) part.getEntity();
            String name = propIMGCtrl.save();
            uploadedFileLocation = UPLOAD_FILE_SERVER + name + "." + getFileExtension(part.getContentDisposition().getFileName());
            try {
				saveToFile(bodyPartEntity.getInputStream(), uploadedFileLocation);
				fileName.add(name);
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        
        return Response.ok(fileName).build();
    }
 
    private void saveToFile(InputStream inputStream, String uploadedFileLocation) throws IOException {
    	 OutputStream outputStream = null;
         
  
         try {
             outputStream = new FileOutputStream(new File(uploadedFileLocation));
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
		
	}
    
    @SuppressWarnings("unused")
	private String getFileExtension(String file) {
        
        try {
            return file.substring(file.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }
}