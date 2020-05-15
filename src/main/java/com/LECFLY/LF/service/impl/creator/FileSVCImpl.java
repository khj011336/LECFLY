package com.LECFLY.LF.service.impl.creator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegFormat;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
@Service
public class FileSVCImpl {
	public static final String DEF_DIR = "/LECFILE"; 
	public static final String DEF_DIR_IMG = "/Img"; 
	public static final String DEF_DIR_VIDEO = "/video"; 
	public static final String DEF_FILE_NAME = "/LF"; 
	private boolean check(Object args) {
		if( args == null ) {
			return false;
		}else {
			return true;
		}
	}
	private String fileNamingforImg(String oriFileName ,int id , String username) {
//		전체경로 + 이름  +id + 카테고리 + 파일이름 + 날자 + 확장자
		StringBuffer naming  = new StringBuffer();
		int lastExt = 0;
		String oriFile = null;
		String oriExt = null;
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyyMMddHHmm");
		if(check(oriFileName)) {
			lastExt =oriFileName.lastIndexOf('.');
			oriFile = oriFileName.substring(0,lastExt);
			oriExt = oriFileName.substring(lastExt+1).toLowerCase();
		}else {
			System.out.println("fileSVC fileNamingforImg() -han");
			return null;	
		}if(  check(id) &&check(username)) {
		naming.append(DEF_FILE_NAME+"_");
		naming.append(username+"_");
		naming.append(id+"_");
		naming.append(oriFile+"_");
		naming.append(sdf.format( new Date())+".");
		naming.append(oriExt);
		System.out.println(naming);
		return naming.toString();
		}else {
			System.out.println("fileSVC fileNamingforImg() null -han");
		}
		return null;
	}		
	public String fileNamingforVideo() {
//		전체경로 + 이름  +id + 카테고리 + 파일이름+duration + 날자 + 확장자
		return null;
	}
	public Map<String, String>writeFiles(Collection<MultipartFile> files,
			String path   ,int id ,String username) {
		Map<String, String> rmap = new HashMap<String, String>();
		if(check(files)) {
			for(MultipartFile file : files) {
				if(file != null && !file.isEmpty()) {
					String 	oriFileName = file.getOriginalFilename();
					String	storeFileName = fileNamingforImg(oriFileName , id , username);
					System.out.println(file.getSize()+"파일사이즈");
				String totalPath = path +  storeFileName;
				totalPath =  totalPath.replaceAll("\\\\", "/");
				File newFile = new File(totalPath);
				 try {
					 file.transferTo(newFile);
					rmap.put(oriFileName,storeFileName);
				} catch (IllegalStateException e) {
					System.out.println("fileSVC writeFiles -han");
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("fileSVC writeFiles -han");
					e.printStackTrace();
				}
			}
			return rmap;
		  }
		}
		return null;
	}
	public static String getPath(String username , int IorV) {
		Path relativePaht = Paths.get("LECFILE");
		String path = relativePaht.toAbsolutePath().toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String ImgorVideo = IorV ==1? DEF_DIR_IMG :DEF_DIR_VIDEO;
		return path += "/"+sdf.format(new Date())+"/"+username+ImgorVideo;
	}
	public boolean makeDir(String username) {
		Path relativePaht = Paths.get("LECFILE");
		String path = relativePaht.toAbsolutePath().toString();
 		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		
 		path += "/"+sdf.format(new Date())+"/"+username;
		File mk = new File(path);
		File mkimg = new File(path+"/"+"Img");
		File mkvideo = new File(path+"/"+"video");
		try{
		if(mk.isDirectory()) {
			System.out.println("초기 저장 폴더 이미 있음");
			return true;
		}else {
			  if( mk.mkdirs() &&
			  mkimg.mkdir()&&
			  mkvideo.mkdir()) {
				  System.out.println("초기 저장 폴더 생성완료");
				  return true;
			  }else {
				  System.out.println("초기 저장 폴더 생성실패");
				  return false;
			  }
		}
		} catch(SecurityException e) {
			System.out.println("fileSVC makeDIR() -han");
			return false;
		}
		
	}
	
		public File extractImage(File videoFile, int position,File creatingImageFile) {
			try {
				int seconds = position % 60;
				int minutes = (position - seconds) / 60;
				int hours = (position - minutes * 60 - seconds) / 60 / 60;

				String videoFilePath = videoFile.getAbsolutePath();
				String imageFilePath = creatingImageFile.getAbsolutePath();
				String[] commands = { "ffmpeg", "-ss",
						String.format("%02d:%02d:%02d", hours, minutes, seconds),
						"-i", videoFilePath, "-an", "-vframes", "1", "-y",
						imageFilePath };
				
				String[] commands2 = { "ffmpeg", "-i",videoFilePath,  "-vf","scale=500:-1",
						"-t","10","-r","10", 
						imageFilePath };
				
//				set 환경변수명 "경로" -m -> (ex: set SystemPath "c:\SystemPath" -m)
				String[] commands3 = { "setx", "",videoFilePath,  "-vf","scale=500:-1",
						"-t","10","-r","10", 
						imageFilePath };
				
				Process processor = Runtime.getRuntime().exec(commands);
				String line1 = null;
				BufferedReader error = new BufferedReader(new InputStreamReader(
						processor.getErrorStream()));
				while ((line1 = error.readLine()) != null) {
					System.out.println(line1);
				}
				processor.waitFor();
				int exitValue = processor.exitValue();
				if (exitValue != 0) {
					throw new RuntimeException("exit code is not 0 [" + exitValue
							+ "]");
				}
				return creatingImageFile;
			} catch (IOException e) {
				throw new RuntimeException(e);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		
	 
	public String media_player_time(String st) {
		System.out.println("@@ media_player_time start @@");
		String returnData = "0";
		try {
			FFprobe ffprobe = new FFprobe("C:\\ffmpeg-4.2.2-win64-static\\bin\\ffprobe.exe"); // window에 설치된  ffprobe.exe 경로
			FFmpegProbeResult probeResult = ffprobe.probe("C:\\fusion11\\jsp_ws\\LF\\WebContent\\resource\\video\\"+st); // 동영상 경로
			FFmpegFormat format = probeResult.getFormat();
			double second = format.duration; // 초단위
			returnData = second + "";
			System.out.println("second==" + second);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("@@ media_player_time end @@");
		}
		return returnData;
	}
	 
	public static void main(String[] args) {

String nullcheck =  " category=" + "null" + ", subTitle=" + "null" + ", title=" + "n" + ", TitleImg=" + "n"
+ ", infoImg=" + "null" + ", info=" + "n" + ", nickname=" + "null" + ", imgPath=" + "n";
for(int i =0; i< 8 ; i++) {
	String sep[] = nullcheck.split("=");
	String value = sep[i].split(",")[0];
	System.out.println(value);
	if(value.equals("null") || value.equals("0")) {
System.out.println("널");		
	}
}

		 
	}
	}
