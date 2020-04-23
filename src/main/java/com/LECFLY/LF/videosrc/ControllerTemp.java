package mvc;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerTemp extends HttpServlet{

	public Map<String, CommandHandler> commandHandlerMap = new HashMap<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
	public void init() throws ServletException{
		// xml 이나 어노테이션 에 get InitParameter param 을 confile 로  및 temp property 파일의 경로를 명시
		String configFile = getInitParameter("conFile");
		Properties prop = new Properties();
		// 파일의 값을 key - value 로 읽어오는 클래스
		String configFilePath = getServletContext().getRealPath(configFile);
		// 위 xml init 파라미터를 이용해 경로를 추출 
		try (InputStreamReader fs = new FileReader(configFilePath)) {
			// file 리더로  confile .property 을 읽어와 prop 클래스에 로드
			prop.load(fs);
		}catch(IOException e) {
			throw new ServletException(e);
		}
		Iterator keys = prop.keySet().iterator();
		while(keys.hasNext()) {
			String command = (String) keys.next();
			// 읽어온 prop key 를 이터레이터에 읽혀 읽혀온 수대로 저장 
			String handlerClassName = prop.getProperty(command);
			// 위의  key 값으로 value 인 파일 경로를 클래스네임 변수에 저장
			try {
				Class<?> handleClass = Class.forName(handlerClassName);
				// 클래스 파일의 경로를 클래스 클래스에 입력
				CommandHandler ClassInstance = (CommandHandler) handleClass.newInstance();
				// Commandhandler 인터페이스를 구현한 handlerClassName 클래스를 생성하여  classInstance에 초기화  
				commandHandlerMap.put(command,ClassInstance);
				// 이후 생성된 commandHandler를 구현한 임의이 클래스가 commandHandMap 저장
			} catch (ClassNotFoundException  | InstantiationException | IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
	}
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String command = req.getRequestURI();
		String viewPage = null;
//		command.substring("")
		CommandHandler handler = commandHandlerMap.get(command);
		// commandHandlerMap 은 xml init 설정으로 시작과동시에 프로퍼티 파일을 읽어와 생성하기에 널이아님 만약비어있으면 널
		if(handler ==null ) {
			handler = new nullHandler();
		}
		
		// 이후 및에는 기존의 서블릿 방식과 똑같음
		try {
		viewPage = handler.process();
		}catch(Exception e) {
			throw new ServletException(e);
		}
		if(viewPage != null) {
			RequestDispatcher dis = req.getRequestDispatcher(viewPage);
			dis.forward(req, resp);
		}else {
			resp.sendRedirect(viewPage);
		}
	}
}
