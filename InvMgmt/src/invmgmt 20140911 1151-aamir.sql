-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.23


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema invmgmt
--

CREATE DATABASE IF NOT EXISTS invmgmt;
USE invmgmt;

--
-- Definition of table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `type` int(10) unsigned NOT NULL,
  `address` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address2` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `postal` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `city` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `state` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `country` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `firstname` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastname` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone2` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fax` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `notes` text COLLATE utf8_unicode_ci,
  `visible` tinyint(1) DEFAULT NULL,
  `maxdebt` decimal(15,2) DEFAULT NULL,
  `curdebt` decimal(15,2) DEFAULT NULL,
  `image` blob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='system accounts : Customer or Supplier';

--
-- Dumping data for table `accounts`
--

/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` (`id`,`name`,`type`,`address`,`address2`,`postal`,`city`,`state`,`country`,`firstname`,`lastname`,`email`,`phone`,`phone2`,`fax`,`notes`,`visible`,`maxdebt`,`curdebt`,`image`) VALUES 
 (1,'Supplier1',1,'Add1','Add2','330001','Banglore','KA','indi','Supp','First','supp@inv.com','98989898','99966996','','',1,NULL,NULL,'');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;


--
-- Definition of table `acl`
--

DROP TABLE IF EXISTS `acl`;
CREATE TABLE `acl` (
  `aclid` varchar(255) NOT NULL,
  `aclmodule` varchar(255) NOT NULL,
  `parentaclid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aclid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `acl`
--

/*!40000 ALTER TABLE `acl` DISABLE KEYS */;
INSERT INTO `acl` (`aclid`,`aclmodule`,`parentaclid`) VALUES 
 ('account','Accounts',NULL),
 ('item','Item',NULL),
 ('itemcategory','Item Category',NULL),
 ('itemunit','Item unit',NULL),
 ('purchaseorder','Purchase Order',NULL),
 ('purchaserequisition','Purchase Requisition',NULL);
/*!40000 ALTER TABLE `acl` ENABLE KEYS */;


--
-- Definition of table `acl_entity`
--

DROP TABLE IF EXISTS `acl_entity`;
CREATE TABLE `acl_entity` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `aclid` varchar(255) NOT NULL,
  `entityid` int(10) unsigned NOT NULL,
  `entitytype` int(10) unsigned NOT NULL,
  `permissionlevel` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_index` (`aclid`,`entityid`,`entitytype`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `acl_entity`
--

/*!40000 ALTER TABLE `acl_entity` DISABLE KEYS */;
INSERT INTO `acl_entity` (`id`,`aclid`,`entityid`,`entitytype`,`permissionlevel`) VALUES 
 (6,'purchaseorder',1,2,7),
 (7,'itemcategory',1,2,7),
 (8,'itemunit',1,2,7),
 (9,'item',1,2,7),
 (10,'account',1,2,7),
 (11,'purchaserequisition',1,2,7);
/*!40000 ALTER TABLE `acl_entity` ENABLE KEYS */;


--
-- Definition of table `alarmevent`
--

DROP TABLE IF EXISTS `alarmevent`;
CREATE TABLE `alarmevent` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `alarmid` int(10) unsigned NOT NULL,
  `value` int(10) unsigned DEFAULT NULL,
  `description` text COLLATE utf8_unicode_ci,
  `attributes` blob,
  `expirydate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Alarm occurances';

--
-- Dumping data for table `alarmevent`
--

/*!40000 ALTER TABLE `alarmevent` DISABLE KEYS */;
/*!40000 ALTER TABLE `alarmevent` ENABLE KEYS */;


--
-- Definition of table `alarms`
--

DROP TABLE IF EXISTS `alarms`;
CREATE TABLE `alarms` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Description` text COLLATE utf8_unicode_ci,
  `active` tinyint(1) DEFAULT NULL,
  `createdat` int(10) unsigned DEFAULT NULL,
  `updatedat` int(10) unsigned DEFAULT NULL,
  `createdby` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='no of Alarms for the system';

--
-- Dumping data for table `alarms`
--

/*!40000 ALTER TABLE `alarms` DISABLE KEYS */;
/*!40000 ALTER TABLE `alarms` ENABLE KEYS */;


--
-- Definition of table `apply_leaves`
--

DROP TABLE IF EXISTS `apply_leaves`;
CREATE TABLE `apply_leaves` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `employee_leave_types_id` int(11) DEFAULT NULL,
  `is_half_day` tinyint(1) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `reason` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `approved` tinyint(1) DEFAULT '0',
  `viewed_by_manager` tinyint(1) DEFAULT '0',
  `manager_remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `apply_leaves`
--

/*!40000 ALTER TABLE `apply_leaves` DISABLE KEYS */;
/*!40000 ALTER TABLE `apply_leaves` ENABLE KEYS */;


--
-- Definition of table `bank`
--

DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `address1` varchar(100) DEFAULT NULL,
  `address2` varchar(100) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `country_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bank`
--

/*!40000 ALTER TABLE `bank` DISABLE KEYS */;
INSERT INTO `bank` (`id`,`name`,`address1`,`address2`,`city`,`country_id`) VALUES 
 (1,'Bank1','Add','','C',NULL);
/*!40000 ALTER TABLE `bank` ENABLE KEYS */;


--
-- Definition of table `country`
--

DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `code` varchar(45) NOT NULL,
  `createdby` varchar(45) NOT NULL,
  `createdate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `country`
--

/*!40000 ALTER TABLE `country` DISABLE KEYS */;
/*!40000 ALTER TABLE `country` ENABLE KEYS */;


--
-- Definition of table `employee_attendances`
--

DROP TABLE IF EXISTS `employee_attendances`;
CREATE TABLE `employee_attendances` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attendance_date` date DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `employee_leave_type_id` int(11) DEFAULT NULL,
  `reason` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `is_half_day` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `employee_attendances`
--

/*!40000 ALTER TABLE `employee_attendances` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_attendances` ENABLE KEYS */;


--
-- Definition of table `employee_category`
--

DROP TABLE IF EXISTS `employee_category`;
CREATE TABLE `employee_category` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `category` varchar(100) NOT NULL,
  `prefix` varchar(45) NOT NULL,
  `isactive` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_category`
--

/*!40000 ALTER TABLE `employee_category` DISABLE KEYS */;
INSERT INTO `employee_category` (`id`,`category`,`prefix`,`isactive`) VALUES 
 (1,'admin','admin',0000000001);
/*!40000 ALTER TABLE `employee_category` ENABLE KEYS */;


--
-- Definition of table `employee_department`
--

DROP TABLE IF EXISTS `employee_department`;
CREATE TABLE `employee_department` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `department` varchar(100) NOT NULL,
  `code` varchar(45) NOT NULL,
  `isactive` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_department`
--

/*!40000 ALTER TABLE `employee_department` DISABLE KEYS */;
INSERT INTO `employee_department` (`id`,`department`,`code`,`isactive`) VALUES 
 (1,'Depqrtment12','d12',1);
/*!40000 ALTER TABLE `employee_department` ENABLE KEYS */;


--
-- Definition of table `employee_leave_types`
--

DROP TABLE IF EXISTS `employee_leave_types`;
CREATE TABLE `employee_leave_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `max_leave_count` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `carry_forward` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `employee_leave_types`
--

/*!40000 ALTER TABLE `employee_leave_types` DISABLE KEYS */;
INSERT INTO `employee_leave_types` (`id`,`name`,`code`,`status`,`max_leave_count`,`carry_forward`) VALUES 
 (1,'Sick leave1','SL',1,'10',1),
 (2,'Sick','00220',1,'5',1);
/*!40000 ALTER TABLE `employee_leave_types` ENABLE KEYS */;


--
-- Definition of table `employee_leaves`
--

DROP TABLE IF EXISTS `employee_leaves`;
CREATE TABLE `employee_leaves` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `employee_leave_type_id` int(11) DEFAULT NULL,
  `leave_count` decimal(5,1) DEFAULT '0.0',
  `leave_taken` decimal(5,1) DEFAULT '0.0',
  `reset_date` date DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `employee_leaves`
--

/*!40000 ALTER TABLE `employee_leaves` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_leaves` ENABLE KEYS */;


--
-- Definition of table `employee_position`
--

DROP TABLE IF EXISTS `employee_position`;
CREATE TABLE `employee_position` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `position` varchar(100) NOT NULL,
  `categoryid` int(10) unsigned NOT NULL,
  `isactive` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_position`
--

/*!40000 ALTER TABLE `employee_position` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_position` ENABLE KEYS */;


--
-- Definition of table `employees`
--

DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_category_id` int(11) DEFAULT NULL,
  `employee_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `joining_date` date DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `middle_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `job_title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `employee_position_id` int(11) DEFAULT NULL,
  `employee_department_id` int(11) DEFAULT NULL,
  `reporting_manager_id` int(11) DEFAULT NULL,
  `employee_grade_id` int(11) DEFAULT NULL,
  `qualification` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `experience_detail` text COLLATE utf8_unicode_ci,
  `experience_year` int(11) DEFAULT NULL,
  `experience_month` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `status_description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `marital_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `children_count` int(11) DEFAULT NULL,
  `father_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mother_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `husband_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `blood_group` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nationality_id` int(11) DEFAULT NULL,
  `home_address_line1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `home_address_line2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `home_city` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `home_state` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `home_country_id` int(11) DEFAULT NULL,
  `home_pin_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `office_address_line1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `office_address_line2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `office_city` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `office_state` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `office_country_id` int(11) DEFAULT NULL,
  `office_pin_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `office_phone1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `office_phone2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mobile_phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `home_phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fax` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `photo_file_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `photo_content_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `photo_data` mediumblob,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `photo_file_size` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `passport_number` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `passport_expiry_date` datetime DEFAULT NULL,
  `bank_id` int(10) unsigned DEFAULT NULL,
  `account_number` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `salary` int(10) unsigned DEFAULT NULL,
  `code_number` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_employees_on_employee_number` (`employee_number`(10))
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `employees`
--

/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` (`id`,`employee_category_id`,`employee_number`,`joining_date`,`first_name`,`middle_name`,`last_name`,`gender`,`job_title`,`employee_position_id`,`employee_department_id`,`reporting_manager_id`,`employee_grade_id`,`qualification`,`experience_detail`,`experience_year`,`experience_month`,`status`,`status_description`,`date_of_birth`,`marital_status`,`children_count`,`father_name`,`mother_name`,`husband_name`,`blood_group`,`nationality_id`,`home_address_line1`,`home_address_line2`,`home_city`,`home_state`,`home_country_id`,`home_pin_code`,`office_address_line1`,`office_address_line2`,`office_city`,`office_state`,`office_country_id`,`office_pin_code`,`office_phone1`,`office_phone2`,`mobile_phone`,`home_phone`,`email`,`fax`,`photo_file_name`,`photo_content_type`,`photo_data`,`created_at`,`updated_at`,`photo_file_size`,`user_id`,`passport_number`,`passport_expiry_date`,`bank_id`,`account_number`,`salary`,`code_number`) VALUES 
 (1,1,'001','2014-09-01','Admin','sys','1',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL),
 (8,1,'002','2014-09-01','Admin2','system','admin2',1,'',NULL,NULL,NULL,NULL,'','',NULL,NULL,NULL,NULL,NULL,'',NULL,'','','','',NULL,'','','','',NULL,'','','','','',NULL,'','','','','','','','','application/octet-stream','',NULL,NULL,0,NULL,'',NULL,NULL,'',NULL,'');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;


--
-- Definition of table `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `alias` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `categoryid` int(10) unsigned NOT NULL,
  `typeid` int(10) unsigned NOT NULL,
  `price` decimal(15,2) NOT NULL,
  `taxid` int(10) unsigned NOT NULL,
  `unitid` int(10) unsigned NOT NULL,
  `currstock` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `item`
--

/*!40000 ALTER TABLE `item` DISABLE KEYS */;
/*!40000 ALTER TABLE `item` ENABLE KEYS */;


--
-- Definition of table `itemtype`
--

DROP TABLE IF EXISTS `itemtype`;
CREATE TABLE `itemtype` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `itemtype`
--

/*!40000 ALTER TABLE `itemtype` DISABLE KEYS */;
INSERT INTO `itemtype` (`id`,`name`,`description`) VALUES 
 (1,'Category1','category 1 description'),
 (2,'Category2','Item category Desc 2');
/*!40000 ALTER TABLE `itemtype` ENABLE KEYS */;


--
-- Definition of table `itemunit`
--

DROP TABLE IF EXISTS `itemunit`;
CREATE TABLE `itemunit` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `itemunit`
--

/*!40000 ALTER TABLE `itemunit` DISABLE KEYS */;
INSERT INTO `itemunit` (`id`,`name`,`description`) VALUES 
 (1,'KG','Kilogrram Unit.');
/*!40000 ALTER TABLE `itemunit` ENABLE KEYS */;


--
-- Definition of table `monthly_payslips`
--

DROP TABLE IF EXISTS `monthly_payslips`;
CREATE TABLE `monthly_payslips` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `salary_date` date DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `payroll_category_id` int(11) DEFAULT NULL,
  `amount` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `is_approved` tinyint(1) NOT NULL DEFAULT '0',
  `approver_id` int(11) DEFAULT NULL,
  `is_rejected` tinyint(1) NOT NULL DEFAULT '0',
  `rejector_id` int(11) DEFAULT NULL,
  `reason` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `monthly_payslips`
--

/*!40000 ALTER TABLE `monthly_payslips` DISABLE KEYS */;
INSERT INTO `monthly_payslips` (`id`,`salary_date`,`employee_id`,`payroll_category_id`,`amount`,`is_approved`,`approver_id`,`is_rejected`,`rejector_id`,`reason`,`remark`) VALUES 
 (1,'2014-09-02',1,1,'5000.0',0,NULL,0,NULL,NULL,NULL),
 (2,'2014-09-07',8,1,'4500.0',0,NULL,0,NULL,NULL,NULL);
/*!40000 ALTER TABLE `monthly_payslips` ENABLE KEYS */;


--
-- Definition of table `new table`
--

DROP TABLE IF EXISTS `new table`;
CREATE TABLE `new table` (
  `aclid` int(10) unsigned NOT NULL,
  `aclmodule` varchar(255) NOT NULL,
  `parentaclid` varchar(255) NOT NULL,
  PRIMARY KEY (`aclid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `new table`
--

/*!40000 ALTER TABLE `new table` DISABLE KEYS */;
/*!40000 ALTER TABLE `new table` ENABLE KEYS */;


--
-- Definition of table `payroll_categories`
--

DROP TABLE IF EXISTS `payroll_categories`;
CREATE TABLE `payroll_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `percentage` float DEFAULT NULL,
  `payroll_category_id` int(11) DEFAULT NULL,
  `is_deduction` tinyint(1) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `payroll_categories`
--

/*!40000 ALTER TABLE `payroll_categories` DISABLE KEYS */;
INSERT INTO `payroll_categories` (`id`,`name`,`percentage`,`payroll_category_id`,`is_deduction`,`status`) VALUES 
 (1,'Basic',20,NULL,0,1),
 (2,'HRA',10,NULL,0,1);
/*!40000 ALTER TABLE `payroll_categories` ENABLE KEYS */;


--
-- Definition of table `prstatus`
--

DROP TABLE IF EXISTS `prstatus`;
CREATE TABLE `prstatus` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `status` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci,
  `order` int(10) unsigned NOT NULL,
  `usertype` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Purchase requisition statuses';

--
-- Dumping data for table `prstatus`
--

/*!40000 ALTER TABLE `prstatus` DISABLE KEYS */;
INSERT INTO `prstatus` (`id`,`status`,`description`,`order`,`usertype`) VALUES 
 (1,'PR Init','Purchase Initiated',1,0),
 (2,'Supplier Bind','Supplier is binded with PR',2,0),
 (3,'supervisor Approved','PR approval with supervison',3,0),
 (4,'Fin Approved','Finance dept approval ',4,0);
/*!40000 ALTER TABLE `prstatus` ENABLE KEYS */;


--
-- Definition of table `purord_approvers`
--

DROP TABLE IF EXISTS `purord_approvers`;
CREATE TABLE `purord_approvers` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(10) unsigned NOT NULL,
  `level` int(10) unsigned NOT NULL,
  `createdby` int(10) unsigned NOT NULL,
  `createdat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_purord_approvers_1` (`userid`),
  CONSTRAINT `FK_purord_approvers_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Purchase order approvers';

--
-- Dumping data for table `purord_approvers`
--

/*!40000 ALTER TABLE `purord_approvers` DISABLE KEYS */;
/*!40000 ALTER TABLE `purord_approvers` ENABLE KEYS */;


--
-- Definition of table `purorder`
--

DROP TABLE IF EXISTS `purorder`;
CREATE TABLE `purorder` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `purrequisition` int(10) unsigned DEFAULT NULL,
  `supplier` int(10) unsigned DEFAULT NULL,
  `createdat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedat` datetime DEFAULT NULL,
  `createdby` int(10) unsigned DEFAULT NULL,
  `price` decimal(15,2) DEFAULT NULL,
  `updatedby` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Purchase Orders';

--
-- Dumping data for table `purorder`
--

/*!40000 ALTER TABLE `purorder` DISABLE KEYS */;
INSERT INTO `purorder` (`id`,`purrequisition`,`supplier`,`createdat`,`updatedat`,`createdby`,`price`,`updatedby`) VALUES 
 (1,1,1,'2014-09-02 00:00:00',NULL,1,'500.00',NULL);
/*!40000 ALTER TABLE `purorder` ENABLE KEYS */;


--
-- Definition of table `purorderdt`
--

DROP TABLE IF EXISTS `purorderdt`;
CREATE TABLE `purorderdt` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `purorderid` int(10) unsigned NOT NULL,
  `itemid` int(10) unsigned NOT NULL,
  `qty` int(10) unsigned NOT NULL,
  `price` decimal(15,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Purchase Order detail';

--
-- Dumping data for table `purorderdt`
--

/*!40000 ALTER TABLE `purorderdt` DISABLE KEYS */;
/*!40000 ALTER TABLE `purorderdt` ENABLE KEYS */;


--
-- Definition of table `purreq_item`
--

DROP TABLE IF EXISTS `purreq_item`;
CREATE TABLE `purreq_item` (
  `purrequisition_id` int(10) unsigned NOT NULL,
  `item_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`purrequisition_id`,`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purreq_item`
--

/*!40000 ALTER TABLE `purreq_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `purreq_item` ENABLE KEYS */;


--
-- Definition of table `purrequisition`
--

DROP TABLE IF EXISTS `purrequisition`;
CREATE TABLE `purrequisition` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `prno` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `suplierid` int(10) unsigned DEFAULT NULL,
  `status` int(10) unsigned DEFAULT NULL,
  `approvedby` int(10) unsigned DEFAULT NULL,
  `createdat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedat` datetime DEFAULT NULL,
  `isbilled` tinyint(1) DEFAULT NULL,
  `price` decimal(15,2) DEFAULT NULL,
  `createdby` int(10) unsigned DEFAULT NULL,
  `updatedby` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='purchase requisition ';

--
-- Dumping data for table `purrequisition`
--

/*!40000 ALTER TABLE `purrequisition` DISABLE KEYS */;
INSERT INTO `purrequisition` (`id`,`prno`,`suplierid`,`status`,`approvedby`,`createdat`,`updatedat`,`isbilled`,`price`,`createdby`,`updatedby`) VALUES 
 (1,'1009946660534726753949927870281738355832',1,1,NULL,'2014-09-03 00:00:00',NULL,0,'500.00',1,NULL);
/*!40000 ALTER TABLE `purrequisition` ENABLE KEYS */;


--
-- Definition of table `purrequisitiondt`
--

DROP TABLE IF EXISTS `purrequisitiondt`;
CREATE TABLE `purrequisitiondt` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `purreqid` int(10) unsigned NOT NULL,
  `itemid` int(10) unsigned NOT NULL,
  `qty` int(10) unsigned NOT NULL,
  `price` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Purchase Requisition Detail';

--
-- Dumping data for table `purrequisitiondt`
--

/*!40000 ALTER TABLE `purrequisitiondt` DISABLE KEYS */;
/*!40000 ALTER TABLE `purrequisitiondt` ENABLE KEYS */;


--
-- Definition of table `purrequisitiondtlog`
--

DROP TABLE IF EXISTS `purrequisitiondtlog`;
CREATE TABLE `purrequisitiondtlog` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `purreqid` int(10) unsigned NOT NULL,
  `itemid` int(10) unsigned NOT NULL,
  `qty` int(10) unsigned NOT NULL,
  `price` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Purchase Requisition Detail logs';

--
-- Dumping data for table `purrequisitiondtlog`
--

/*!40000 ALTER TABLE `purrequisitiondtlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `purrequisitiondtlog` ENABLE KEYS */;


--
-- Definition of table `purrequisitionlog`
--

DROP TABLE IF EXISTS `purrequisitionlog`;
CREATE TABLE `purrequisitionlog` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `prno` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `suplierid` int(10) unsigned DEFAULT NULL,
  `status` int(10) unsigned DEFAULT NULL,
  `approvedby` int(10) unsigned DEFAULT NULL,
  `createdat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedat` datetime DEFAULT NULL,
  `isbilled` tinyint(1) DEFAULT NULL,
  `price` decimal(15,2) DEFAULT NULL,
  `createdby` int(10) unsigned DEFAULT NULL,
  `updatedby` int(10) unsigned DEFAULT NULL,
  `comments` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='purchase requisition ';

--
-- Dumping data for table `purrequisitionlog`
--

/*!40000 ALTER TABLE `purrequisitionlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `purrequisitionlog` ENABLE KEYS */;


--
-- Definition of table `settings`
--

DROP TABLE IF EXISTS `settings`;
CREATE TABLE `settings` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `key` varchar(45) NOT NULL,
  `value` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Application Settings.';

--
-- Dumping data for table `settings`
--

/*!40000 ALTER TABLE `settings` DISABLE KEYS */;
INSERT INTO `settings` (`id`,`key`,`value`) VALUES 
 (1,'app.title','Inventory Management System');
/*!40000 ALTER TABLE `settings` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `usertypeid` int(10) unsigned DEFAULT NULL,
  `isactive` tinyint(1) DEFAULT NULL,
  `createdat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updateat` datetime DEFAULT NULL,
  `image` blob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`,`name`,`password`,`usertypeid`,`isactive`,`createdat`,`updateat`,`image`) VALUES 
 (1,'admin','admin',1,1,'2014-09-08 14:02:23',NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


--
-- Definition of table `usertype`
--

DROP TABLE IF EXISTS `usertype`;
CREATE TABLE `usertype` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `usertype` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci,
  `createdat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updateat` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='User type of the system';

--
-- Dumping data for table `usertype`
--

/*!40000 ALTER TABLE `usertype` DISABLE KEYS */;
/*!40000 ALTER TABLE `usertype` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

/*!change in employee_category table */;
ALTER TABLE `invmgmt`.`employee_category` MODIFY COLUMN `isactive` TINYINT UNSIGNED NOT NULL;
/*!change in employee_department table */;
ALTER TABLE `invmgmt`.`employee_department` MODIFY COLUMN `isactive` TINYINT UNSIGNED NOT NULL;

ALTER TABLE `invmgmt`.`employees` ADD COLUMN `username` VARCHAR(45) AFTER `employee_number`,
 ADD COLUMN `password` VARCHAR(45) AFTER `username`;
/*!New tables for finance module */;
CREATE TABLE `invmgmt`.`credit_debit` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `referencenumber` VARCHAR(45) NOT NULL,
  `creditdebit` VARCHAR(45) NOT NULL,
  `amount` NUMERIC NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB;

CREATE TABLE `invmgmt`.`receivable_order` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `billno` VARCHAR(45) NOT NULL,
  `amount` NUMERIC NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB;

