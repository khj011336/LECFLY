package com.LECFLY.LF.service.impl.creator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.LECFLY.LF.model.vo.creator.VideoVO;
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
		if (args == null) {
			return false;
		} else {
			return true;
		}
	}
	private boolean checkString(String args) {
		if (args != null && !args.isEmpty() ) {
			return true;
		} else {
			return false;
		}
	}

	private String fileNamingforImg(String oriFileName, int id, String username) {
//		전체경로 + 이름  +id + 파일이름 + 날자 + 확장자
		StringBuffer naming = new StringBuffer();
		int lastExt = 0;
		String oriFile = null;
		String oriExt = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		if (check(oriFileName)) {
			lastExt = oriFileName.lastIndexOf('.');
			oriFile = oriFileName.substring(0, lastExt);
			oriExt = oriFileName.substring(lastExt + 1).toLowerCase();
		} else {
			System.out.println("fileSVC fileNamingforImg() -han");
			return null;
		}
		if (check(id) && check(username)) {
			naming.append(DEF_FILE_NAME + "_");
			naming.append(username + "_");
			naming.append(id + "_");
			naming.append(oriFile + "_");
			naming.append(sdf.format(new Date()) + ".");
			naming.append(oriExt);
			return naming.toString();
		} else {
			System.out.println("fileSVC fileNamingforImg() null -han");
		}
		return null;
	}

	public String fileNamingforVideo(String duration, String oriFileName, int id, String username) {
//		전체경로 + 이름  +id  + 파일이름+duration + 날자 + 확장자
		StringBuffer naming = new StringBuffer();
		int lastExt = 0;
		String oriFile = null;
		String oriExt = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		if (check(oriFileName)) {
			lastExt = oriFileName.lastIndexOf('.');
			oriFile = oriFileName.substring(0, lastExt);
			oriExt = oriFileName.substring(lastExt + 1).toLowerCase();
		} else {
			System.out.println("fileSVC fileNamingforImg() -han");
			return null;
		}
		if (check(id) && check(username)) {
			naming.append(DEF_FILE_NAME + "_");
			naming.append(username + "_");
			naming.append(id + "_");
			naming.append(oriFile + "_");
			naming.append(duration + "_");
			naming.append(sdf.format(new Date()) + ".");
			naming.append("mp4");
			return naming.toString();
		} else {
			System.out.println("fileSVC fileNamingforImg() null -han");
		}
		return null;
	}

	public Map<String, String> writeFiles(Collection<MultipartFile> files, String path, int id, String username) {
		Map<String, String> rmap = new HashMap<String, String>();
		if (check(files)) {
			for (MultipartFile file : files) {
				if (file != null && !file.isEmpty()) {
					String oriFileName = file.getOriginalFilename();
					String storeFileName = fileNamingforImg(oriFileName, id, username);
					System.out.println(file.getSize() + "파일사이즈");
					String totalPath = path + storeFileName;
					totalPath = totalPath.replaceAll("\\\\", "/");
					File newFile = new File(totalPath);
					try {
						file.transferTo(newFile);
						rmap.put(oriFileName, storeFileName);
						System.out.println("저장 파일 이름 ->" + newFile + "등록완료");
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
	public Map<String, String> writeFile(MultipartFile file, String path, int id, String username) {
		Map<String, String> rmap = new HashMap<String, String>();
				if (file != null && !file.isEmpty()) {
					String oriFileName = file.getOriginalFilename();
					String storeFileName = fileNamingforImg(oriFileName, id, username);
					System.out.println(file.getSize() + "파일사이즈");
					String totalPath = path + storeFileName;
					totalPath = totalPath.replaceAll("\\\\", "/");
					File newFile = new File(totalPath);
					try {
						file.transferTo(newFile);
						rmap.put("file", storeFileName);
						System.out.println("저장 파일 이름 ->" + newFile + "등록완료");
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

	public Map<String, String> writeFilesForvideo(MultipartFile file, int id, String username , VideoVO changevideo, HttpSession ses) {
		if(changevideo.getVideoPath() != null && !changevideo.getVideoPath().isEmpty()) {
			System.out.println("upload 비디오 변경 -");
			String totalImgpath = getPath(username, 1);
			String totalVideopath = getPath(username, 2);
			String imgpaths[] =changevideo.getImgPath().split("-");
			String gifPath = changevideo.getGifPath();
			String videoPath = changevideo.getVideoPath();
			 if(new File(totalImgpath+imgpaths[0]).delete()) {
				 System.out.println(imgpaths[0]+"[imgPathA]가삭제되었습니다");
			 }if(new File(totalImgpath+imgpaths[1]).delete()) {
				 System.out.println(imgpaths[0]+"[imgPathB]가삭제되었습니다");
			 }if(new File(totalImgpath+gifPath).delete()) {
				 System.out.println(gifPath+"[gifPath]가삭제되었습니다");
			 }if(new File(totalVideopath+videoPath).delete()) {
			System.out.println(videoPath+"[videoPath]가삭제되었습니다");
			 }
		}
		Map<String, String> rmap = new HashMap<String, String>();
		File newFile = null;
		String oriFileName = null;
		String storeFileName = null;
			if (file != null && !file.isEmpty()) {
				oriFileName = file.getOriginalFilename();
				storeFileName = fileNamingforImg(oriFileName, id, username);
				System.out.println(file.getSize() + "파일사이즈");
				// TODO 패스 설정 글로벌변경
				String totalPath = 	ses.getServletContext()
				.getRealPath("/videoTemp");
				totalPath += storeFileName;
				newFile = new File(totalPath);
				try {
					file.transferTo(newFile);
				} catch (IllegalStateException e) {
					System.out.println("fileSVC writeFiles -han");
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("fileSVC writeFiles -han");
					e.printStackTrace();
				}
				if (makeDir(username)) {
					if (newFile.isFile()) {
						String tempVideoPath = newFile.getAbsolutePath();
						String duration = media_player_time(tempVideoPath);
						String pngAB = extractImageAndVideo(username, storeFileName, tempVideoPath, duration, id, 1, 1);
						if(checkString(pngAB)) {
						String oriFile = pngAB; 
							pngAB=oriFile+"_01"+".png"+"-"+oriFile+"_02"+".png";
						}
						String gif = extractImageAndVideo(username, storeFileName, tempVideoPath, duration, id, 1, 2);
						String video = extractImageAndVideo(username, oriFileName, tempVideoPath, duration, id, 1, 3);
						if (newFile.delete()) {
							System.out.println("TEMPVIDEO 가 삭제되었습니다");
						}else {
							System.out.println("TEMPVIDEO  삭제실패");
						}
						
						if(checkString(pngAB)&& checkString(gif)&& checkString(video)) {
							rmap.put("png", pngAB);
							rmap.put("gif", gif);
							rmap.put("video", video);
							rmap.put("duration", duration);
						}
					}
				}
				return rmap;
			}else {
				System.out.println("비디오 파일객체가 없습니다 (통신 - 파일 확인바람)");
				return null;
			}
			
	}

	public static String getPath(String username, int IorV) {
		String path = "C:/fusion11/spring_ws/LECFILE";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String ImgorVideo = IorV == 1 ? DEF_DIR_IMG : DEF_DIR_VIDEO;
		return path += "/" + sdf.format(new Date()) + "/" + username + ImgorVideo;
	}

	public boolean makeDir(String username) {
		String path = "C:/fusion11/spring_ws/LECFILE";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		path += "/" + sdf.format(new Date()) + "/" + username;
		File mk = new File(path);
		File mkimg = new File(path + "/" + "Img");
		File mkvideo = new File(path + "/" + "video");
		try {
			if (mk.isDirectory()) {
				System.out.println("초기 저장 폴더 이미 있음");
				return true;
			} else {
				if (mk.mkdirs() && mkimg.mkdir() && mkvideo.mkdir()) {
					System.out.println("초기 저장 폴더 생성완료");
					return true;
				} else {
					System.out.println("초기 저장 폴더 생성실패");
					return false;
				}
			}
		} catch (SecurityException e) {
			System.out.println("fileSVC makeDIR() -han");
			return false;
		}

	}

	public String extractImageAndVideo(String name, String oriFile, String tempVideoPath, String duration, int id,
			int position, int syntax) {
		String returname = null;
		try {
			String imgpath = getPath(name, 1);
			String videopath = getPath(name, 2);
			String TempvideoFile = tempVideoPath;
			String[] commands = null;
			int seconds = position % 60;
			int minutes = (position - seconds) / 60;
			int hours = (position - minutes * 60 - seconds) / 60 / 60;
			String oriFileName = oriFile;
			int lastExt = oriFileName.lastIndexOf('.');
			String withoutExt = oriFileName.substring(0, lastExt);
			if (syntax == 1) {
				returname = withoutExt ;
				commands = new String[] { "ffmpeg", "-ss", String.format("%02d:%02d:%02d", hours, minutes, seconds),
						"-i", TempvideoFile, "-an", "-r", "0.2", "-vframes", "2", "-y", imgpath + returname+"_%2d.png" };
			} else if (syntax == 2) {
				returname = withoutExt + ".gif";
				commands = new String[] { "ffmpeg", "-i", TempvideoFile, "-vf", "scale=500:-1", "-t", "10", "-r", "10",
						imgpath + returname };
			} else if (syntax == 3) {
				returname = fileNamingforVideo(duration, oriFileName, id, name);
				commands = new String[] { "ffmpeg", "-i", TempvideoFile, "-ar", "44100", "-ab", "32", "-s", "800x600",
						"-b", "100k", "-r", "24", "-y", "-f", "mp4", videopath + returname };
//					-r 프레임 , -f변환 -b 비트프레임
			}
			Process processor = Runtime.getRuntime().exec(commands);
			String line1 = null;
			BufferedReader error = new BufferedReader(new InputStreamReader(processor.getErrorStream()));
			while ((line1 = error.readLine()) != null) {
				System.out.println(line1);
			}
			processor.waitFor();
			int exitValue = processor.exitValue();
			if (exitValue != 0) {
				throw new RuntimeException("exit code is not 0 [" + exitValue + "]");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return returname;
	}

	public static String media_player_time(String videoPath) {
		System.out.println("@@ media_player_time start @@");
		String returnData = "0";
		try {
			FFprobe ffprobe = new FFprobe("C:\\ffmpeg-4.2.2-win64-static\\bin\\ffprobe.exe");
			FFmpegProbeResult probeResult = ffprobe.probe(videoPath); // 동영상 경로
			FFmpegFormat format = probeResult.getFormat();
			double second = format.duration; 
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
		System.out.println(Double.parseDouble("0.26"));
		Path relativePaht = Paths.get("fusion11\\LECFLY\\src\\main\\webapp\\resources\\LECFILE");
		String path = relativePaht.toAbsolutePath().toString();
		System.out.println(path);
	}
}
