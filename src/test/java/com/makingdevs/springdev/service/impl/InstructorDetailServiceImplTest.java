package com.makingdevs.springdev.service.impl;

import com.makingdevs.springdev.domain.courses.InstructorDetail;
import com.makingdevs.springdev.model.enums.BloodType;
import com.makingdevs.springdev.model.request.InstructorRequest;
import com.makingdevs.springdev.service.InstructorDetailService;
import com.makingdevs.springdev.util.CustomDateUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("default")
@RunWith(SpringRunner.class)
class InstructorDetailServiceImplTest {

  @Autowired
  InstructorDetailService instructorDetailService;

  @Test
  @Transactional
  @Rollback()
  void saveInstructorDetail() {
    InstructorDetail instructorDetail = instructorDetailService.saveInstructorDetail(
      buildInstructorRequest()
    );

    Assertions.assertNotNull(instructorDetail);
    Assertions.assertNotNull(instructorDetail.getId());
    Assertions.assertEquals(instructorDetail.getBloodType(), BloodType.O);
  }

  InstructorRequest buildInstructorRequest() {
    InstructorRequest instructorRequest = new InstructorRequest();
    instructorRequest.setBirthdate(CustomDateUtil.stringToDate("1996-08-05"));
    instructorRequest.setBloodType(BloodType.O);

    return instructorRequest;
  }

}