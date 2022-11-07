package com.makingdevs.springdev.service.impl;

import com.makingdevs.springdev.domain.entity.Student;
import com.makingdevs.springdev.domain.repository.StudentRepository;
import com.makingdevs.springdev.service.StudentService;
import com.makingdevs.springdev.service.mapper.StudentMapper;
import com.makingdevs.springdev.web.model.StudentRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;

  public StudentServiceImpl(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public List<Student> findAllStudents() {
    return studentRepository.findAll();
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public Student saveStudent(StudentRequest studentRequest) {
    Optional<Student> studentFound = findStudentByDni(
      studentRequest.getDni()
    );

    if (!studentFound.isPresent()) {
      Student student = StudentMapper.toEntity(studentRequest);
      return studentRepository.save(student);
    }

    return studentFound.get();
  }

  @Transactional(readOnly = true)
  private Optional<Student> findStudentByDni(String dni) {
    return studentRepository.findOneByDni(dni);
  }
}
