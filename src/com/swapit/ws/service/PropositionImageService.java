package com.swapit.ws.service;

import com.sun.jersey.core.header.ContentDisposition;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.FormDataParam;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/files")
public class PropositionImageService {
//http://127.0.0.1:8080/jax_rs_jersey_file_upload_example/form.html
//http://127.0.0.1:8080/jax_rs_jersey_file_upload_example/multi.html

	
	@POST
	@Path("copy")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response copy(@FormDataParam("file") InputStream uploadedInputStream,
	            @FormDataParam("file") FormDataContentDisposition fileDetail) {
	return null;
}
	
    @POST
    @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("file") InputStream inputStream,
            @FormDataParam("file") FormDataContentDisposition formDataContentDisposition) {
        String fileName = formDataContentDisposition.getFileName();

        String filePath = saveFile(inputStream, fileName);

        String output = "File: " + filePath;

        return Response.status(Response.Status.CREATED).entity(output).build();
    }

    @POST
    @Path("/multi")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            FormDataMultiPart form) {
        FormDataBodyPart filePart = form.getField("file");

        ContentDisposition headerOfFilePart = filePart.getContentDisposition();

        InputStream inputStream = filePart.getValueAs(InputStream.class);

        String filePath = saveFile(inputStream, headerOfFilePart.getFileName());

        String output = "File: " + filePath;

        return Response.status(Response.Status.CREATED).entity(output).build();
    }

    private String saveFile(InputStream inputStream, String fileName) {
        try {
            File file = File.createTempFile("temp", ".txt");
            OutputStream outputStream = new FileOutputStream(file);
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            outputStream.flush();
            outputStream.close();
            return file.getAbsolutePath();
        } catch (Exception e) {

        }
        return "";
    }

}