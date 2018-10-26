package info.ilong.file.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import info.ilong.file.service.FileService;
import info.ilong.utils.DateUtils;
import info.ilong.utils.IDUtils;
import info.ilong.utils.JsonUtils;
import info.ilong.utils.OmsResult;

@Controller
public class FileController {

	@Value("${PIC_PATH}")
	private String PIC_PATH;
	
	@Value("${PIC_URL}")
	private String PIC_URL;
	
	@Autowired
	private FileService fileService;

	@RequestMapping("/pic/upload")
	@ResponseBody
	public String fileUpload(MultipartFile uploadFile) {
		try {
			info.ilong.oms.pojo.File omsFile = new info.ilong.oms.pojo.File();
			// 1、取文件的扩展名
			String originalFilename = uploadFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			String imageName = IDUtils.genImageName() + "." + extName;
			String tempPath = DateUtils.getFormatString(DateUtils.YYYYMM);
			File dir = new File(PIC_PATH + tempPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			String filePath = dir + "/" + imageName;
			

			InputStream is = uploadFile.getInputStream();
			OutputStream os = new FileOutputStream(filePath);
			byte buffer[] = new byte[1024];
			int cnt = 0;
			while ((cnt = is.read(buffer)) > 0) {
				os.write(buffer, 0, cnt);
			}
			os.close();
			is.close();

			omsFile.setName(originalFilename);
			omsFile.setExtName(extName);
			omsFile.setMediaType(uploadFile.getContentType());
			omsFile.setPath(filePath);
			omsFile.setSize((int)uploadFile.getSize());
			
			OmsResult omsResult = fileService.uploadFile(omsFile);
			info.ilong.oms.pojo.File f = (info.ilong.oms.pojo.File) omsResult.getData();
			
			// 5、返回map
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("error", 0);
			result.put("url", PIC_URL + f.getId());
			String json = JsonUtils.objectToJson(result);
			return json;
		} catch (Exception e) {
			e.printStackTrace();

			// 5、返回map
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("error", 1);
			result.put("message", "图片上传失败");
			String json = JsonUtils.objectToJson(result);
			return json;
		}
	}
	
	@SuppressWarnings("resource")
	@RequestMapping("/pic/show/{filename}")
	public void showPic(@PathVariable String filename, HttpServletResponse response) throws IOException{
		int fileId = Integer.parseInt(filename);
		info.ilong.oms.pojo.File omsFile = fileService.getFileById(fileId);
		File file = new File(omsFile.getPath());
		
		FileImageInputStream inputStream = new FileImageInputStream(file);
		ServletOutputStream outputStream = response.getOutputStream();
		
		byte buffer[] = new byte[1024];
		int cnt = 0;
		while ((cnt = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, cnt);
		}
	}
}
