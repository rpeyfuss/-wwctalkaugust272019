package com.reginapeyfuss.services.faculty

import com.reginapeyfuss.services.utilities.FacultyUtilities.YYYYMM

/*
  This file will hold the domains for faculty e.g. Teachers, Administration, SupportStaff
*/

sealed trait FacultyType {
    def name: String
}
case object Administrator extends FacultyType {val name: String = "Administrator"}
case object Teacher extends FacultyType { val name: String = "Teacher"}
case object SupportStaff extends FacultyType { val name: String = "Support"}
case object Invalid extends FacultyType { val name: String = "Invalid Faculty Type"}


sealed trait Faculty {
    val facultyType: String
}

case class Teacher(
                   facultyId: String,
                   firstName: String,
                   lastName: String,
                   email: String,
                   yearMonthStarted: YYYYMM,
                   department: String,
                   title: String,
                   facultyType: String
                  ) extends Faculty

case class Administrator(
                    facultyId: String,
                    firstName: String,
                    lastName: String,
                    email: String,
                    yearMonthStarted: YYYYMM,
                    department: String,
                    title: String,
                    facultyType: String
                ) extends Faculty

case class SupportStaff(
                    facultyId: String,
                    firstName: String,
                    lastName: String,
                    email: String,
                    yearMonthStarted: YYYYMM,
                    department: String,
                    title: String,
                    facultyType: String
                ) extends Faculty
