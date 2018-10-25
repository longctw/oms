package info.ilong.file.service;

import java.util.List;

import info.ilong.oms.pojo.File;
import info.ilong.utils.OmsResult;

public interface FileService {

	public OmsResult uploadFile(File file);
	
	public List<File> getFiles(List<Integer> ids);
	
	public File getFileById(Integer fileId);
}
