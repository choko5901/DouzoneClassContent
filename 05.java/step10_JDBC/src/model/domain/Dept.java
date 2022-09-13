package model.domain;




public class Dept {
	private int deptno;
	private String dname;
	private String loc;

//	public Dept() {
//		super();
//	}

//	public Dept(int deptno, String dname, String loc) {
//		super();
//		this.deptno = deptno;
//		this.dname = dname;
//		this.loc = loc;
//	}
//
//	public int getDeptno() {
//		return deptno;
//	}
//
//	public void setDeptno(int deptno) {
//		this.deptno = deptno;
//	}
//
//	public String getDname() {
//		return dname;
//	}
//
//	public void setDname(String dname) {
//		this.dname = dname;
//	}
//
//	public String getLoc() {
//		return loc;
//	}
//
//	public void setLoc(String loc) {
//		this.loc = loc;
//	}
//
//	@Override
//	public String toString() {
//		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
//	}

	
	// 빌더 패턴 builder patter -> 나중에는 @Builder 라는 어노테이션 하나로 줄어 들꺼임
	
	/* 빌더 패턴
	 * - 장점
	 * 		1) 맴버 변수의 개수에 따른 사용자 정의 생성자를 많이 만들 필요가 없다
	 * 			-> 점층적 생성자 패턴보다 훨씬 직관이다.
	 * 		2) 계층적 클래스에 사용하기 좋다
	 * - 단점
	 * 		1) 빌더 객체 생성 비용이 클 수 도 있다
	 * 		2) 필드(맴버 변수)가 5개 이상인 경우에 경제적일 수 있다.
	 * 
	 * */
	
	
	public Dept(Builder builder) {
		this.deptno = builder.deptno;
		this.dname = builder.dname;
		this.loc = builder.loc;
		
		
		
	}
	
	public static class Builder {
		
		private int deptno;
		private String dname;
		private String loc;
		
		public Builder() {}
		
		public Builder deptno(int deptno) {
			this.deptno = deptno;
			
			return this;
		}
		public Builder dname(String dname) {
			this.dname = dname;
			
			return this;
		}
		public Builder loc(String loc) {
			this.loc = loc;
			
			return this;
		}
		
		//Dept 객체를 만드는 것이 궁극적인 목표!
		
		public Dept build() {
			return new Dept(this);
		}
		
	}
	
	

	
	
	
	
}

