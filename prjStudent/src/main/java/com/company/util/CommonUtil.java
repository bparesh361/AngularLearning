package com.company.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import com.company.entity.Attendence;
import com.company.entity.Batch;
import com.company.entity.College;
import com.company.entity.Faculty;
import com.company.entity.Fees;
import com.company.entity.Material;
import com.company.entity.Schedule;
import com.company.entity.Student;
import com.company.mongo.entity.Discussion;
import com.company.vo.AttendenceVO;
import com.company.vo.BatchVO;
import com.company.vo.CollegeVO;
import com.company.vo.DiscussionVO;
import com.company.vo.FacultyVO;
import com.company.vo.FeesVO;
import com.company.vo.MaterialVO;
import com.company.vo.ScheduleVO;
import com.company.vo.StudentVO;

public class CommonUtil {

	private static final SimpleDateFormat format = new SimpleDateFormat(
			"MM/dd/yyyy");

	public static Batch getBatchFromVO(BatchVO vo) throws Exception {
		Date startDate = format.parse(vo.getStartDate());		if (vo.getId() == null || vo.getId().isEmpty()) {
			return new Batch(vo.getBatchName(), startDate);
		} else {
			return new Batch(Integer.parseInt(vo.getId()), vo.getBatchName(),
					startDate);
		}
	}

	
	public static Schedule getScheduleFromVO(ScheduleVO vo) throws Exception {
		Date batchDate = format.parse(vo.getDate());		
		return new Schedule(vo.getStartTime(),vo.getEndTime(), batchDate, vo.getDescription() );
		
	}
	
	public static BatchVO getBatchVOFromEntity(Batch batch,
			List<Faculty> faculties, List<Student> students) throws Exception {
		String startDate = format.format(batch.getStartDate());
		BatchVO vo = new BatchVO(String.valueOf(batch.getId()),
				batch.getBatchName(), startDate);
		if (faculties != null && faculties.size() > 0) {
			for (Faculty faculty : faculties) {
				vo.getFaculties().add(getFacultyVOFromEntity(faculty));
			}
		}
		if (students != null && students.size() > 0) {
			for (Student student : students) {
				vo.getStudents().add(getStudentVOFromEntity(student));
			}
		}
		return vo;
	}

	public static FacultyVO getFacultyVOFromEntity(Faculty faculty) {
		if (faculty != null) {
			return new FacultyVO(String.valueOf(faculty.getId()),
					faculty.getFirstName(), faculty.getLastName());
		} else {
			return null;
		}
	}

	public static Attendence getAttendenceFromVO(AttendenceVO vo)
			throws Exception {
		Attendence attendence = new Attendence(format.parse(vo.getaDate()));
		return attendence;
	}

	public static StudentVO getStudentVOFromEntity(Student student) {
		String active="";
		if(student.isActive()){
			active="Active";
		} else {
			active="In-Active";
		}
		if (student != null) {
			return new StudentVO(String.valueOf(student.getId()),
					student.getFirstName(), student.getLastName(),student.getEmail(),active,student.getCollegeName());
		} 
		return null;
	}

	public static Faculty getFacultyFromVO(FacultyVO vo) throws Exception {
		if (vo.getId() == null || vo.getId().isEmpty()) {
			return new Faculty(vo.getFirstName(), vo.getLastName());
		} else {
			return new Faculty(Integer.parseInt(vo.getId()), vo.getFirstName(),
					vo.getLastName());
		}
	}

	public static Student getStudentFromVO(StudentVO vo) throws Exception {
		boolean active;
		if(vo.getActive().equals("true"))
			active=true;
		else
			active=false;
		if (vo.getId() == null || vo.getId().isEmpty()) {
			return new Student(vo.getFirstName(), vo.getLastName(),vo.getEmail(),active,vo.getCollegeName());
		} else {
			return new Student(Integer.parseInt(vo.getId()), vo.getFirstName(),
					vo.getLastName(),vo.getEmail(),active,vo.getCollegeName());
		}
	}

	public static Fees getFeesVO(FeesVO vo) throws Exception {
		if (vo.getId() == null || vo.getId().isEmpty()) {
			return new Fees(vo.getAmount(), format.parse(vo.getFeesDate()));
		} else {
			return new Fees(Integer.parseInt(vo.getId()), vo.getAmount(),
					format.parse(vo.getFeesDate()));
		}
	}

	public static List<BatchVO> getBatchVOList(List<Batch> list) {
		List<BatchVO> volist = new ArrayList<BatchVO>();
		for (Batch b : list) {
			volist.add(new BatchVO(String.valueOf(b.getId()), b.getBatchName(),
					format.format(b.getStartDate())));
		}
		return volist;
	}
	
	public static List<CollegeVO> getCollegeVOList(List<College> list){
		List<CollegeVO> volist = new ArrayList<CollegeVO>();
		for(College c : list){
			volist.add(new CollegeVO(String.valueOf(c.getId()),c.getCollegeName()));
		}
		return volist;
	}
	
	public static Material createMaterial(MaterialVO vo) throws Exception {
		Material material = new Material();
		if(vo.getFiles()!=null && vo.getFiles().size()>=1){
			material.setFile1ContentType(vo.getFiles().get(0).getContentType());
			material.setFile1Name(vo.getFiles().get(0).getOriginalFilename());
			byte[] content = vo.getFiles().get(0).getBytes();
			material.setFile1Data(new SerialBlob(content));
		}
		if(vo.getFiles()!=null && vo.getFiles().size()==2){
			material.setFile2ContentType(vo.getFiles().get(1).getContentType());
			material.setFile2Name(vo.getFiles().get(1).getOriginalFilename());
			byte[] content = vo.getFiles().get(1).getBytes();
			material.setFile2Data(new SerialBlob(content));
		}
		return material;
	}
	
	public static List<ScheduleVO> getScheduleVOList(List<Schedule> list) {
		List<ScheduleVO> volist = new ArrayList<ScheduleVO>();
		for (Schedule s : list) {
			volist.add(new ScheduleVO(String.valueOf(s.getId()),s.getBatch().getBatchName(),format.format(s.getbDate()),s.getDescription(),s.getStartTime(),s.getEndTime()));
		}
		return volist;
	}

	public static List<AttendenceVO> getAttendenceVOList(List<Attendence> list) {
		List<AttendenceVO> volist = new ArrayList<AttendenceVO>();
		for (Attendence a : list) {
			AttendenceVO vo = new AttendenceVO();
			vo.setId(String.valueOf(a.getId()));
			vo.setaDate(format.format(a.getAttendenceDate()));
			if (a.getStudent() != null) {
				vo.setStudentName(a.getStudent().getFirstName());
				vo.setStudentLastName(a.getStudent().getLastName());
			} else {
				vo.setStudentName("-");
				vo.setStudentLastName("-");
			}
			if(a.getBatch()!=null){
				vo.setBatchName(a.getBatch().getBatchName());
			}
			if(a.getFaculty()!=null){
				vo.setFacultyName(a.getFaculty().getFirstName());
			} else {
				vo.setFacultyName("-");
			}
			volist.add(vo);
		}
		return volist;
	}
	
	public static List<MaterialVO> getMaterialVOList(List<Material> list) throws Exception {
		List<MaterialVO> mlist = new ArrayList<MaterialVO>();
		for(Material m : list){
			MaterialVO vo = new MaterialVO(String.valueOf(m.getId()),m.getSchedule().getBatch().getBatchName(), format.format(m.getSchedule().getbDate()));
			int noFileUpload=0;
			if(m.getFile1Name()!=null && !(m.getFile1Name().isEmpty())){
				noFileUpload++;
			}
			if(m.getFile2Name()!=null && !(m.getFile2Name().isEmpty()) ){
				noFileUpload++;
			}
			vo.setNoFileUpload(noFileUpload);
			mlist.add(vo);
		}
		return mlist;		
	}
	
	

	public static List<FacultyVO> getFacultyVOList(List<Faculty> list) {
		List<FacultyVO> volist = new ArrayList<FacultyVO>();
		for (Faculty faculty : list) {
			volist.add(new FacultyVO(String.valueOf(faculty.getId()), faculty
					.getFirstName(), faculty.getLastName()));
		}
		return volist;
	}

	public static List<StudentVO> getStudentVOList(List<Student> list) {
		List<StudentVO> volist = new ArrayList<StudentVO>();
		String active="false";
		for (Student student : list) {
			if(student.isActive()){
				active="Active";
			} else {
				active="In-Active";
			}
			volist.add(new StudentVO(String.valueOf(student.getId()), student
					.getFirstName(), student.getLastName(), student.getEmail(),active, student.getCollegeName()));
		}
		return volist;
	}

	public static List<FeesVO> getFeesVOList(List<Fees> list) {
		List<FeesVO> volist = new ArrayList<FeesVO>();
		for (Fees fees : list) {
			FeesVO vo = new FeesVO();
			vo.setId(String.valueOf(fees.getId()));
			vo.setAmount(fees.getAmount());
			vo.setFeesDate(format.format(fees.getFeesDate()));
			vo.setStudentFirstName(fees.getStudent().getFirstName());
			vo.setStudentLastName(fees.getStudent().getLastName());			
			vo.setBatchName(fees.getBatch().getBatchName());
			vo.setStudentId(String.valueOf(fees.getStudent().getId()));
			vo.setBatchId(String.valueOf(fees.getStudent().getId()));
			volist.add(vo);
		}
		return volist;
	}
	
	public static Discussion createDiscussion(DiscussionVO vo){
		Discussion discussion = new Discussion(vo.getQuestion());
		return discussion;
	}
	
	public static List<DiscussionVO> getDiscussionVOList(List<Discussion> list){
		List<DiscussionVO> volist = new ArrayList<DiscussionVO>();
		for(Discussion discussion : list){
			volist.add(new DiscussionVO(discussion.getId(),discussion.getDiscussionName()));
		}		
		return volist;
	}

}
