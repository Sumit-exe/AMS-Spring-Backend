//package com.project.attendance.model;
//
//public class WorkDetails {
//
//	    private String date;
//	    private String workingWay;
//	    private String logginTime;
//	    private String logoutTime;
//	    private String workHours;
//		
//	    public WorkDetails() {
//			super();
//		}
//
//		public String getDate() {
//			return date;
//		}
//
//		public void setDate(String date) {
//			this.date = date;
//		}
//
//		public String getWorkingWay() {
//			return workingWay;
//		}
//
//		public void setWorkingWay(String workingWay) {
//			this.workingWay = workingWay;
//		}
//
//		public String getLogginTime() {
//			return logginTime;
//		}
//
//		public void setLogginTime(String logginTime) {
//			this.logginTime = logginTime;
//		}
//
//		public String getLogoutTime() {
//			return logoutTime;
//		}
//
//		public void setLogoutTime(String logoutTime) {
//			this.logoutTime = logoutTime;
//		}
//
//		public String getWorkHours() {
//			return workHours;
//		}
//
//		public void setWorkHours(String workHours) {
//			this.workHours = workHours;
//		}
//	    
//}


package com.project.attendance.model;

public class WorkDetails {

	private String date;
    private String workingWay;
    private String workHours;
    private String sessionTimeIn;
    private String sessionTimeOut;
    private boolean isWorkingRemotely;

    // Getters and Setters

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWorkingWay() {
        return workingWay;
    }

    public void setWorkingWay(String workingWay) {
        this.workingWay = workingWay;
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public String getSessionTimeIn() {
        return sessionTimeIn;
    }

    public void setSessionTimeIn(String sessionTimeIn) {
        this.sessionTimeIn = sessionTimeIn;
    }

    public String getSessionTimeOut() {
        return sessionTimeOut;
    }

    public void setSessionTimeOut(String sessionTimeOut) {
        this.sessionTimeOut = sessionTimeOut;
    }

    public boolean isWorkingRemotely() {
        return isWorkingRemotely;
    }

    public void setWorkingRemotely(boolean isWorkingRemotely) {
        this.isWorkingRemotely = isWorkingRemotely;
    }
		@Override
		public String toString() {
			return "WorkDetails [date=" + date + ", workingWay=" + workingWay + ", workHours=" + workHours
					+ ", sessionTimeIn=" + sessionTimeIn + ", sessionTimeOut=" + sessionTimeOut + ", isWorkingRemotely="
					+ isWorkingRemotely + "]";
		}
	  



	    


}
