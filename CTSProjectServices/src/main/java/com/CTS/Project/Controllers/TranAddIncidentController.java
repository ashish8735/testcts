package com.CTS.Project.Controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.CTS.Project.Models.TranAddIncident;
import com.CTS.Project.Repository.MstPriorityRepository;
import com.CTS.Project.Services.TranAddIncidentService;

@RestController
@RequestMapping("/addIncident")
public class TranAddIncidentController {

	private static final String UPLOADED_FOLDER = "src/main/resources/uploads";

	Map<String, String> respMap = new HashMap<String, String>();
	
	@Autowired
	TranAddIncidentService tranadd;
	@Autowired
	MstPriorityRepository mstPriorityRepository;
	@PostMapping("/create")
	public Map<String, String> createtranaddincident(@RequestBody TranAddIncident tran,HttpServletRequest req)
	{		
		String fileurl=req.getHeader("fileUrl");
		System.out.println("fille-----------"+fileurl);
		System.out.println("in save-----"+req.getHeader("fileUrl"));
		if(tran.getTaiApplicationId().getAppId()!=0)
		{		
			long pid=6;
			mstPriorityRepository.findById(pid).map(data->{
			tran.setTaiPriorityId(data);
			tranadd.save(tran,fileurl);
			respMap.put("success", "1");
			respMap.put("msg", "Incident Added Successfully");
			return respMap;
			});	
			return respMap;
		}
		else
		{
			respMap.put("success", "0");
			respMap.put("msg", "Failed To Add Null Field");
			return respMap;
		}
	}
	
	
	@RequestMapping("api/upload/")
    public Map<String, String> uploadFile(@RequestPart("file") MultipartFile file) {
		System.out.println("uploadfile------------------"+file.getOriginalFilename());
		/*
		
        if (file.isEmpty()) {
        	respMap.put("success", "0");
			respMap.put("msg", "Failed To Add Null Field");
			return respMap;
        }
        else
        {*/
        try {
            saveUploadedFiles(Arrays.asList(file));
        } catch (IOException e) {
        	respMap.put("success", "0");
			respMap.put("msg", "Failed To Add Null Field");
			return respMap;
        }
        respMap.put("success", "1");
		respMap.put("msg", "Process Completed Successfully");
		respMap.put("uploadURL", file.getOriginalFilename());
		return respMap;
        
	}
	private void saveUploadedFiles(List<MultipartFile> files) throws IOException {
		System.out.println(files);
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                continue; //next pls
            }
            byte[] bytes = file.getBytes();
            //Path path = Paths.get(new File(UPLOADED_FOLDER).mkdir() + file.getOriginalFilename());
            Path path = Paths.get(UPLOADED_FOLDER+"/"+file.getOriginalFilename());
            Files.write(path, bytes);
                   }
		
    } 
}
