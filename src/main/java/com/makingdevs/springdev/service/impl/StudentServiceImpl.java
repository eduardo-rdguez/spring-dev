package com.makingdevs.springdev.service.impl;

import com.makingdevs.springdev.domain.courses.Student;
import com.makingdevs.springdev.dto.PageDto;
import com.makingdevs.springdev.dto.StudentDto;
import com.makingdevs.springdev.exception.EntityNotFoundException;
import com.makingdevs.springdev.mapper.StudentMapper;
import com.makingdevs.springdev.model.request.StudentRequest;
import com.makingdevs.springdev.repository.courses.StudentRepository;
import com.makingdevs.springdev.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;

  @Override
  @Transactional(readOnly = true)
  public PageDto<StudentDto> findAllStudents(Pageable pageable) {
    log.info("Find all students");

    Page<Student> page = studentRepository.findAll(pageable);
    return StudentMapper.toPage(page);
  }

  @Override
  @Transactional(readOnly = true)
  public Student findStudentById(Long id) {
    log.info("Find student by id: " + id);

    Optional<Student> student = studentRepository.findById(id);

    if (student.isPresent()) {
      return student.get();
    }

    throw new EntityNotFoundException(Student.class);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public StudentDto saveStudent(StudentRequest studentRequest) {
    log.info("Save student by request: " + studentRequest);

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
    log.info("Find student by dni: " + dni);

    return studentRepository.findOneByDni(dni);
  }

}
