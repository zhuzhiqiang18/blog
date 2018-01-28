package blog.zzq.action.view;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownloadAction extends ActionSupport {

	public String inputPath;
	
	public String filename;
    
	public InputStream inputStream;
	
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public InputStream getInputStream() throws IOException{
		String path = ServletActionContext.getServletContext().getRealPath("/userfiles/files");
		String filepath = path + "\\" + filename;
		System.out.println(filepath);
		File file = new File(filepath);
		return FileUtils.openInputStream(file);
	}
	
	public String getDownloadFileName(){
		String downloadFileName ="";
		try {
			downloadFileName = URLEncoder.encode(filename,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(downloadFileName);
		return downloadFileName;
	}
}
