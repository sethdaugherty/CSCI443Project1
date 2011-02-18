package edu.mines.Schedule;

import java.util.ArrayList;

public class TeachingSessionManager {
	private static TeachingSessionManager theInstance = null;
	
	private ArrayList<TeachingSession> sessions;
	
	private TeachingSessionManager() {
		sessions = new ArrayList<TeachingSession>();
	}
	
	public static TeachingSessionManager getInstance() {
		if(theInstance == null ) {
			theInstance = new TeachingSessionManager();
		}
		return theInstance;
	}

	public void addSession(TeachingSession session) {
		sessions.add(session);
	}

	public ArrayList<TeachingSession> getSessions() {
		return sessions;
	}
}
