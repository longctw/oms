package info.ilong.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import info.ilong.utils.DateUtils;
import info.ilong.utils.IDUtils;
import info.ilong.utils.JsonUtils;

@Controller
public class FileController {

	@Value("${PIC_PATH}")
	private String PIC_PATH;

	@RequestMapping("/pic/upload")
	@ResponseBody
	public String fileUpload(MultipartFile uploadFile) {
		try {
			// 1、取文件的扩展名
			String originalFilename = uploadFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

			String imageName = IDUtils.genImageName() + "." + extName;
			String tempPath = DateUtils.getFormatString("yyyyMM");
			File dir = new File(PIC_PATH + tempPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}

			InputStream is = uploadFile.getInputStream();
			OutputStream os = new FileOutputStream(dir + "/" + imageName);
			byte buffer[] = new byte[1024];
			int cnt = 0;
			while ((cnt = is.read(buffer)) > 0) {
				os.write(buffer, 0, cnt);
			}
			os.close();
			is.close();

			// 5、返回map
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("error", 0);
			result.put("url", tempPath + "/" + imageName);
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

}
