package com.tss.ocean.pojo;
// Generated 4 Aug, 2014 6:30:10 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Employees generated by hbm2java
 */
public class Employees  implements java.io.Serializable {


     private Integer id;
     private Integer employeeCategoryId;
     private String employeeNumber;
     private Date joiningDate;
     private String firstName;
     private String middleName;
     private String lastName;
     private Boolean gender;
     private String jobTitle;
     private Integer employeePositionId;
     private Integer employeeDepartmentId;
     private Integer reportingManagerId;
     private Integer employeeGradeId;
     private String qualification;
     private String experienceDetail;
     private Integer experienceYear;
     private Integer experienceMonth;
     private Boolean status;
     private String statusDescription;
     private Date dateOfBirth;
     private String maritalStatus;
     private Integer childrenCount;
     private String fatherName;
     private String motherName;
     private String husbandName;
     private String bloodGroup;
     private Integer nationalityId;
     private String homeAddressLine1;
     private String homeAddressLine2;
     private String homeCity;
     private String homeState;
     private Integer homeCountryId;
     private String homePinCode;
     private String officeAddressLine1;
     private String officeAddressLine2;
     private String officeCity;
     private String officeState;
     private Integer officeCountryId;
     private String officePinCode;
     private String officePhone1;
     private String officePhone2;
     private String mobilePhone;
     private String homePhone;
     private String email;
     private String fax;
     private String photoFileName;
     private String photoContentType;
     private byte[] photoData;
     private Date createdAt;
     private Date updatedAt;
     private Integer photoFileSize;
     private Integer userId;

    public Employees() {
    }

    public Employees(Integer employeeCategoryId, String employeeNumber, Date joiningDate, String firstName, String middleName, String lastName, Boolean gender, String jobTitle, Integer employeePositionId, Integer employeeDepartmentId, Integer reportingManagerId, Integer employeeGradeId, String qualification, String experienceDetail, Integer experienceYear, Integer experienceMonth, Boolean status, String statusDescription, Date dateOfBirth, String maritalStatus, Integer childrenCount, String fatherName, String motherName, String husbandName, String bloodGroup, Integer nationalityId, String homeAddressLine1, String homeAddressLine2, String homeCity, String homeState, Integer homeCountryId, String homePinCode, String officeAddressLine1, String officeAddressLine2, String officeCity, String officeState, Integer officeCountryId, String officePinCode, String officePhone1, String officePhone2, String mobilePhone, String homePhone, String email, String fax, String photoFileName, String photoContentType, byte[] photoData, Date createdAt, Date updatedAt, Integer photoFileSize, Integer userId) {
       this.employeeCategoryId = employeeCategoryId;
       this.employeeNumber = employeeNumber;
       this.joiningDate = joiningDate;
       this.firstName = firstName;
       this.middleName = middleName;
       this.lastName = lastName;
       this.gender = gender;
       this.jobTitle = jobTitle;
       this.employeePositionId = employeePositionId;
       this.employeeDepartmentId = employeeDepartmentId;
       this.reportingManagerId = reportingManagerId;
       this.employeeGradeId = employeeGradeId;
       this.qualification = qualification;
       this.experienceDetail = experienceDetail;
       this.experienceYear = experienceYear;
       this.experienceMonth = experienceMonth;
       this.status = status;
       this.statusDescription = statusDescription;
       this.dateOfBirth = dateOfBirth;
       this.maritalStatus = maritalStatus;
       this.childrenCount = childrenCount;
       this.fatherName = fatherName;
       this.motherName = motherName;
       this.husbandName = husbandName;
       this.bloodGroup = bloodGroup;
       this.nationalityId = nationalityId;
       this.homeAddressLine1 = homeAddressLine1;
       this.homeAddressLine2 = homeAddressLine2;
       this.homeCity = homeCity;
       this.homeState = homeState;
       this.homeCountryId = homeCountryId;
       this.homePinCode = homePinCode;
       this.officeAddressLine1 = officeAddressLine1;
       this.officeAddressLine2 = officeAddressLine2;
       this.officeCity = officeCity;
       this.officeState = officeState;
       this.officeCountryId = officeCountryId;
       this.officePinCode = officePinCode;
       this.officePhone1 = officePhone1;
       this.officePhone2 = officePhone2;
       this.mobilePhone = mobilePhone;
       this.homePhone = homePhone;
       this.email = email;
       this.fax = fax;
       this.photoFileName = photoFileName;
       this.photoContentType = photoContentType;
       this.photoData = photoData;
       this.createdAt = createdAt;
       this.updatedAt = updatedAt;
       this.photoFileSize = photoFileSize;
       this.userId = userId;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getEmployeeCategoryId() {
        return this.employeeCategoryId;
    }
    
    public void setEmployeeCategoryId(Integer employeeCategoryId) {
        this.employeeCategoryId = employeeCategoryId;
    }
    public String getEmployeeNumber() {
        return this.employeeNumber;
    }
    
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
    public Date getJoiningDate() {
        return this.joiningDate;
    }
    
    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return this.middleName;
    }
    
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Boolean getGender() {
        return this.gender;
    }
    
    public void setGender(Boolean gender) {
        this.gender = gender;
    }
    public String getJobTitle() {
        return this.jobTitle;
    }
    
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public Integer getEmployeePositionId() {
        return this.employeePositionId;
    }
    
    public void setEmployeePositionId(Integer employeePositionId) {
        this.employeePositionId = employeePositionId;
    }
    public Integer getEmployeeDepartmentId() {
        return this.employeeDepartmentId;
    }
    
    public void setEmployeeDepartmentId(Integer employeeDepartmentId) {
        this.employeeDepartmentId = employeeDepartmentId;
    }
    public Integer getReportingManagerId() {
        return this.reportingManagerId;
    }
    
    public void setReportingManagerId(Integer reportingManagerId) {
        this.reportingManagerId = reportingManagerId;
    }
    public Integer getEmployeeGradeId() {
        return this.employeeGradeId;
    }
    
    public void setEmployeeGradeId(Integer employeeGradeId) {
        this.employeeGradeId = employeeGradeId;
    }
    public String getQualification() {
        return this.qualification;
    }
    
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    public String getExperienceDetail() {
        return this.experienceDetail;
    }
    
    public void setExperienceDetail(String experienceDetail) {
        this.experienceDetail = experienceDetail;
    }
    public Integer getExperienceYear() {
        return this.experienceYear;
    }
    
    public void setExperienceYear(Integer experienceYear) {
        this.experienceYear = experienceYear;
    }
    public Integer getExperienceMonth() {
        return this.experienceMonth;
    }
    
    public void setExperienceMonth(Integer experienceMonth) {
        this.experienceMonth = experienceMonth;
    }
    public Boolean getStatus() {
        return this.status;
    }
    
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public String getStatusDescription() {
        return this.statusDescription;
    }
    
    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }
    
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getMaritalStatus() {
        return this.maritalStatus;
    }
    
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    public Integer getChildrenCount() {
        return this.childrenCount;
    }
    
    public void setChildrenCount(Integer childrenCount) {
        this.childrenCount = childrenCount;
    }
    public String getFatherName() {
        return this.fatherName;
    }
    
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
    public String getMotherName() {
        return this.motherName;
    }
    
    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }
    public String getHusbandName() {
        return this.husbandName;
    }
    
    public void setHusbandName(String husbandName) {
        this.husbandName = husbandName;
    }
    public String getBloodGroup() {
        return this.bloodGroup;
    }
    
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
    public Integer getNationalityId() {
        return this.nationalityId;
    }
    
    public void setNationalityId(Integer nationalityId) {
        this.nationalityId = nationalityId;
    }
    public String getHomeAddressLine1() {
        return this.homeAddressLine1;
    }
    
    public void setHomeAddressLine1(String homeAddressLine1) {
        this.homeAddressLine1 = homeAddressLine1;
    }
    public String getHomeAddressLine2() {
        return this.homeAddressLine2;
    }
    
    public void setHomeAddressLine2(String homeAddressLine2) {
        this.homeAddressLine2 = homeAddressLine2;
    }
    public String getHomeCity() {
        return this.homeCity;
    }
    
    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }
    public String getHomeState() {
        return this.homeState;
    }
    
    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }
    public Integer getHomeCountryId() {
        return this.homeCountryId;
    }
    
    public void setHomeCountryId(Integer homeCountryId) {
        this.homeCountryId = homeCountryId;
    }
    public String getHomePinCode() {
        return this.homePinCode;
    }
    
    public void setHomePinCode(String homePinCode) {
        this.homePinCode = homePinCode;
    }
    public String getOfficeAddressLine1() {
        return this.officeAddressLine1;
    }
    
    public void setOfficeAddressLine1(String officeAddressLine1) {
        this.officeAddressLine1 = officeAddressLine1;
    }
    public String getOfficeAddressLine2() {
        return this.officeAddressLine2;
    }
    
    public void setOfficeAddressLine2(String officeAddressLine2) {
        this.officeAddressLine2 = officeAddressLine2;
    }
    public String getOfficeCity() {
        return this.officeCity;
    }
    
    public void setOfficeCity(String officeCity) {
        this.officeCity = officeCity;
    }
    public String getOfficeState() {
        return this.officeState;
    }
    
    public void setOfficeState(String officeState) {
        this.officeState = officeState;
    }
    public Integer getOfficeCountryId() {
        return this.officeCountryId;
    }
    
    public void setOfficeCountryId(Integer officeCountryId) {
        this.officeCountryId = officeCountryId;
    }
    public String getOfficePinCode() {
        return this.officePinCode;
    }
    
    public void setOfficePinCode(String officePinCode) {
        this.officePinCode = officePinCode;
    }
    public String getOfficePhone1() {
        return this.officePhone1;
    }
    
    public void setOfficePhone1(String officePhone1) {
        this.officePhone1 = officePhone1;
    }
    public String getOfficePhone2() {
        return this.officePhone2;
    }
    
    public void setOfficePhone2(String officePhone2) {
        this.officePhone2 = officePhone2;
    }
    public String getMobilePhone() {
        return this.mobilePhone;
    }
    
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    public String getHomePhone() {
        return this.homePhone;
    }
    
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getPhotoFileName() {
        return this.photoFileName;
    }
    
    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }
    public String getPhotoContentType() {
        return this.photoContentType;
    }
    
    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }
    public byte[] getPhotoData() {
        return this.photoData;
    }
    
    public void setPhotoData(byte[] photoData) {
        this.photoData = photoData;
    }
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return this.updatedAt;
    }
    
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Integer getPhotoFileSize() {
        return this.photoFileSize;
    }
    
    public void setPhotoFileSize(Integer photoFileSize) {
        this.photoFileSize = photoFileSize;
    }
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }




}


