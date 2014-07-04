package com.company.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.AttendenceDao;
import com.company.dao.BatchDao;
import com.company.dao.CollegeDao;
import com.company.dao.DiscussionDao;
import com.company.dao.FacultyDao;
import com.company.dao.FeesDao;
import com.company.dao.MaterialDao;
import com.company.dao.ScheduleDao;
import com.company.dao.StudentDao;
import com.company.entity.Attendence;
import com.company.entity.Batch;
import com.company.entity.Faculty;
import com.company.entity.Fees;
import com.company.entity.Material;
import com.company.entity.Schedule;
import com.company.entity.Student;
import com.company.mongo.entity.Discussion;
import com.company.mongo.entity.Reply;
import com.company.mongo.repositories.DiscussionForumRepository;
import com.company.util.CommonUtil;
import com.company.vo.AttendenceVO;
import com.company.vo.BatchVO;
import com.company.vo.CollegeVO;
import com.company.vo.DiscussionVO;
import com.company.vo.FacultyVO;
import com.company.vo.FeesVO;
import com.company.vo.MaterialVO;
import com.company.vo.ScheduleVO;
import com.company.vo.StudentVO;

@Service
@Transactional
public class CommonService {

	@Autowired
	private BatchDao batchDao;

	/*@Autowired
	private UserDao userDao;*/

	@Autowired
	private FacultyDao facultyDao;

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private FeesDao feesDao;

	@Autowired
	private ScheduleDao scheduleDao;

	@Autowired
	private AttendenceDao attendenceDao;

	@Autowired
	private MaterialDao materialDao;
	
	@Autowired
	private CollegeDao collegeDao;
	
	@Autowired
	private DiscussionForumRepository discussionForumRepository;
	
	@Autowired
	private DiscussionDao discussionDao;

	public void createBatch(BatchVO batchVO) throws Exception {
		batchDao.save(CommonUtil.getBatchFromVO(batchVO));
	}

	public void createSchedule(ScheduleVO scheduleVO, int batchId)
			throws Exception {
		Schedule schedule = CommonUtil.getScheduleFromVO(scheduleVO);
		schedule.setBatch(batchDao.findOne(batchId));
		scheduleDao.save(schedule);
	}

	public void createFaculty(FacultyVO vo) throws Exception {
		facultyDao.save(CommonUtil.getFacultyFromVO(vo));
	}
	
	public List<CollegeVO> getCollegeVOList(String query) throws Exception {
		return CommonUtil.getCollegeVOList(collegeDao.getCollegeList(query));
	}

	public void createStudent(StudentVO vo) throws Exception {
		studentDao.save(CommonUtil.getStudentFromVO(vo));
	}

	public void createMaterial(MaterialVO vo) throws Exception {
		Schedule schedule = scheduleDao.findOne(Integer.parseInt(vo
				.getScheduleId()));
		Material material = CommonUtil.createMaterial(vo);
		material.setSchedule(schedule);
		materialDao.save(material);
	}

	public void createFees(FeesVO vo) throws Exception {
		Batch batch = batchDao.findOne(Integer.parseInt(vo.getBatchId()));
		Student student = studentDao
				.findOne(Integer.parseInt(vo.getStudentId()));
		Fees fees = CommonUtil.getFeesVO(vo);
		fees.setBatch(batch);
		fees.setStudent(student);
		feesDao.save(fees);
	}

	public void createAttendence(AttendenceVO vo) throws Exception {
		Batch batch = batchDao.findOne(Integer.parseInt(vo.getBatchId()));
		Attendence attendence = CommonUtil.getAttendenceFromVO(vo);
		attendence.setBatch(batch);
		if (vo.getStudentId() != null && !vo.getStudentId().equals("NONE")) {
			Student student = studentDao.findOne(Integer.parseInt(vo
					.getStudentId()));
			attendence.setStudent(student);
		}
		if (vo.getFacultyId() != null && !vo.getFacultyId().equals("NONE")) {
			Faculty faculty = facultyDao.findOne(Integer.parseInt(vo
					.getFacultyId()));
			attendence.setFaculty(faculty);
		}
		attendenceDao.save(attendence);

	}

	public List<BatchVO> getBatchList() {
		return CommonUtil.getBatchVOList(batchDao.findAll());
	}

	public List<ScheduleVO> getScheduleList() {
		return CommonUtil.getScheduleVOList(scheduleDao.findAll());
	}

	public List<AttendenceVO> getAttendenceList(int iDisplayStart,
			int iDisplayLength) {
		Pageable pageable = new PageRequest(iDisplayStart / iDisplayLength,
				iDisplayLength);
		return CommonUtil.getAttendenceVOList(attendenceDao.findAll(pageable)
				.getContent());
	}

	public Long getAttendenceCount() {
		return attendenceDao.count();
	}

	public List<FacultyVO> getFacultyList() {
		return CommonUtil.getFacultyVOList(facultyDao.findAll());
	}

	public List<StudentVO> getStudentList() {
		return CommonUtil.getStudentVOList(studentDao.findAll());
	}

	public List<FeesVO> getFeesList() {
		return CommonUtil.getFeesVOList(feesDao.findAll());
	}

	public List<MaterialVO> getMaterialList() throws Exception {
		List<Material> list = materialDao.findAll();
		return CommonUtil.getMaterialVOList(list);
	}

	public BatchVO getBatch(int id) throws Exception {
		Batch batch = batchDao.findOne(id);
		List<Faculty> faculties = batch.getFaculties();
		List<Student> students = batch.getStudents();
		return CommonUtil.getBatchVOFromEntity(batch, faculties, students);
	}

	public void allocateBatch(String batchid, String facultyid, boolean allocate) {
		Batch batch = batchDao.findOne(Integer.parseInt(batchid));
		Faculty faculty = facultyDao.findOne(Integer.parseInt(facultyid));
		if (allocate) {
			batch.getFaculties().add(faculty);
		} else {
			batch.getFaculties().remove(faculty);
		}
	}

	public void assignBatch(String batchid, String studentid, boolean allocate) {
		Batch batch = batchDao.findOne(Integer.parseInt(batchid));
		Student student = studentDao.findOne(Integer.parseInt(studentid));
		if (allocate) {
			batch.getStudents().add(student);
		} else {
			batch.getStudents().remove(student);
		}
	}

	public List<StudentVO> getStudentList(String batchId) {
		List<Batch> list = getBatchList(batchId);
		List<Student> slist = studentDao.findByBatchId(list);
		return CommonUtil.getStudentVOList(slist);
	}

	public List<ScheduleVO> getScheduleList(String batchId) {
		List<Batch> list = getBatchList(batchId);
		List<Schedule> slist = null;
		if (list != null && list.size() == 1) {
			slist = scheduleDao.findByBatchId(list.get(0));
		}
		return CommonUtil.getScheduleVOList(slist);
	}

	public List<FacultyVO> getFacultyList(String batchId) {
		List<Batch> list = getBatchList(batchId);
		List<Faculty> slist = facultyDao.findByBatchId(list);
		return CommonUtil.getFacultyVOList(slist);
	}

	private List<Batch> getBatchList(String batchId) {
		Batch batch = batchDao.findOne(Integer.parseInt(batchId));
		List<Batch> list = new ArrayList<Batch>(1);
		list.add(batch);
		return list;
	}

	public Material getMaterialContent(String materialId, String f) throws Exception {
		return materialDao.findOne(Integer.parseInt(materialId));		
		
	}
	
	public void createDiscussion(DiscussionVO vo) throws Exception {
		discussionForumRepository.save(CommonUtil.createDiscussion(vo));
	}
	
	public List<DiscussionVO> unAnsweredQuestions(){
		return CommonUtil.getDiscussionVOList(discussionDao.unansweredDiscussions());
	}
	
	public void createReply(DiscussionVO vo) throws Exception {
		Discussion discussion = discussionForumRepository.findOne(vo.getId());
		Reply reply = new Reply(vo.getReply());
		discussion.getReplies().add(reply);
		discussionForumRepository.save(discussion);
	}
	
	public List<String> findQuestions(String qText){
		List<Discussion> list = discussionDao.searchQuestionByText(qText);
		List<String> slist = new ArrayList<String>();
		for(Discussion d : list){
			slist.add(d.getDiscussionName());
		}
		return slist;
	}
	
	public List<Discussion> getDiscussionByQuestions(String qText){
		return discussionForumRepository.findDiscussionByDiscussionName(qText);
	}

}
