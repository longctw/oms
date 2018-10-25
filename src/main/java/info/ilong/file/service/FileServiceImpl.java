package info.ilong.file.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.ilong.oms.mapper.FileMapper;
import info.ilong.oms.pojo.File;
import info.ilong.utils.OmsResult;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileMapper fileMapper;
	
	@Override
	public OmsResult uploadFile(File file) {
		Date curDate = new Date();
		file.setCreated(curDate);
		file.setStatus(1);
		fileMapper.insert(file);
		return OmsResult.ok(file);
	}

	@Override
	public List<File> getFiles(List<Integer> ids) {
		List<File> files = new ArrayList<File>();
		
		for (Integer id : ids){
			File file = fileMapper.selectByPrimaryKey(id);
			files.add(file);
		}
		
		return files;
	}

	@Override
	public File getFileById(Integer fileId) {
		return fileMapper.selectByPrimaryKey(fileId);
	}

}
