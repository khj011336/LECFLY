package LECFLY.dao.impl;
import java.io.IOException;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegFormat;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;

public class VideoDuration {

	public static String media_player_time(String st) {
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

	public static void main(String[] args) throws IOException {

	}
}