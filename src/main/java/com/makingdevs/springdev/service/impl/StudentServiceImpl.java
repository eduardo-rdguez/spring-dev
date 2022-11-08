package com.makingdevs.springdev.service.impl;

import com.makingdevs.springdev.domain.courses.entity.Student;
import com.makingdevs.springdev.domain.courses.repository.StudentRepository;
import com.makingdevs.springdev.exception.NotFoundException;
import com.makingdevs.springdev.service.StudentService;
import com.makingdevs.springdev.service.dto.StudentDto;
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
  public List<StudentDto> findAllStudents() {
    List<Student> students = studentRepository.findAll();
    return StudentMapper.toDtoList(students);
  }

  @Override
  @Transactional(readOnly = true)
  public Student findStudentById(Long id) {
    Optional<Student> student = studentRepository.findById(id);

    if (student.isPresent()) {
      return student.get();
    }

    throw new NotFoundException(Student.class);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public StudentDto saveStudent(StudentRequest studentRequest) {
    Optional<Student> studentFound = findStudentByDni(
      studentRequest.getDni()
    );

    if (!studentFound.isPresent()) {
      Student student = StudentMapper.toEntity(studentRequest);
      return StudentMapper.toDetailedDto(studentRepository.save(student));
    }

    return StudentMapper.toDetailedDto(studentFound.get());
  }

  @Transactional(readOnly = true)
  private Optional<Student> findStudentByDni(String dni) {
    return studentRepository.findOneByDni(dni);
  }
}
