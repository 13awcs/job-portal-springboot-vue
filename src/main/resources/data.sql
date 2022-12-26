insert into candidate(name,major,dob,phone,email,address,level,category,avatar,link_cv,gender)
values ('Tran Huy Nam','Dai hoc Bach Khoa HN','1999-06-06','012312321','nam@gmail.com','HN','Senior Java','Backend Developer','https://www.vnu.edu.vn/upload/2018/12/23326/image/Nguyen%20Van%20Anh.jpg' ||
 '','jhgh','Nam');
insert into candidate(name,major,dob,phone,email,address,level,category,avatar,link_cv,gender)
values ('Pham Huy Hung','Dai Hoc Cong Nghiep','2000-06-06','012312328','hung@gmail.com','HN','Fresher ReactJs','Frontend','https://www.vnu.edu.vn/upload/2018/12/23326/image/Tran%20Hong%20Linh.jpg','jhgh','Nam');
insert into candidate(name,major,dob,phone,email,address,level,category,avatar,link_cv,gender)
values ('Pham Quoc Bao','Dai Hoc Xay Dung','1999-06-06','012312321','bao@gmail.com','HN','Middle ReactJs','Frontend','https://www.vnu.edu.vn/upload/2018/12/23326/image/Vu%20Dinh%20Hoang.jpg','jhgh','Nam');

insert into recruiter(name,dob,address,phone,email,avatar,company_name,role,username,password,disable)
values ('Tran Van Duong','1999-10-25','HN','2342342342','test@gmail.com','http://hoisinhvien.com.vn/pic/New/images/637476860551085023.jpg.ashx','Viettel','recruiter','duong','$2a$10$1uH922s3hVjSw.q5QwvRouay4C3Z3kRrPFvkncvmkZIE/MUZigV.S','false');
insert into recruiter(name,dob,address,phone,email,avatar,company_name,role,username,password,disable)
values ('Nguyen Thuy Trang','1998-10-01','HN','2342342342','trang@gmail.com','https://www.vnu.edu.vn/upload/2018/12/23326/image/Dang%20Huyen%20Thu.jpg','Fsoft','recruiter','trang','$2a$10$1uH922s3hVjSw.q5QwvRouay4C3Z3kRrPFvkncvmkZIE/MUZigV.S','false');
insert into recruiter(name,dob,address,phone,email,avatar,company_name,role,username,password,disable)
values ('Phan Thi Giang','1997-01-13','HN','2342342342','giang@gmail.com','http://hoisinhvien.com.vn/pic/New/images/637476860554991319.jpg.ashx','VCCorp','recruiter','giang','$2a$10$1uH922s3hVjSw.q5QwvRouay4C3Z3kRrPFvkncvmkZIE/MUZigV.S','true');
insert into recruiter(name,dob,address,phone,email,avatar,company_name,role,username,password,disable)
values ('Admin','1999-06-02','','','admin@gmail.com','https://visualpharm.com/assets/314/Admin-595b40b65ba036ed117d36fe.svg','','admin','admin','$2a$10$1uH922s3hVjSw.q5QwvRouay4C3Z3kRrPFvkncvmkZIE/MUZigV.S','false');

insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Java BE','BE',3,'Remote','Senior','2022-10-10','Implement application development using Java (Spring Framework, Hibernate) and other technologies for wide range of Enterprise Applications such as Salesforce, ServiceNow, Dell Boomi','Viettel',2500,'Ha Noi','available','2022-10-05','true' ,1);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Frontend Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','Viettel',3000,'Hanoi','available','2022-10-01','true',1);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('DevOps','DevOps',3,'Remote','Junior','2022-10-10','Configuration of build/deployment pipelines to enable teams to do continuous integration and delivery','Fsoft',1000,'Hanoi','available','2022-10-01','true' ,2);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('ReactJs Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-10-01','',3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Angular Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-10-01','' ,3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Java BE','BE',3,'Remote','Senior','2022-10-10','Implement application development using Java (Spring Framework, Hibernate) and other technologies for wide range of Enterprise Applications such as Salesforce, ServiceNow, Dell Boomi','Viettel',2500,'Ha Noi','available','2022-10-05','true' ,1);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Frontend Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','Viettel',3000,'Hanoi','available','2022-10-01','true',1);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('DevOps','DevOps',3,'Remote','Junior','2022-10-10','Configuration of build/deployment pipelines to enable teams to do continuous integration and delivery','Fsoft',1000,'Hanoi','available','2022-10-01','true' ,2);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('ReactJs Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-02-01','true',3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Angular Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-02-01','true' ,3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Java BE','BE',3,'Remote','Senior','2022-10-10','Implement application development using Java (Spring Framework, Hibernate) and other technologies for wide range of Enterprise Applications such as Salesforce, ServiceNow, Dell Boomi','Viettel',2500,'Ha Noi','available','2022-10-05','true' ,1);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Frontend Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','Viettel',3000,'Hanoi','available','2022-10-01','true',1);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('DevOps','DevOps',3,'Remote','Junior','2022-10-10','Configuration of build/deployment pipelines to enable teams to do continuous integration and delivery','Fsoft',1000,'Hanoi','available','2022-10-01','true' ,2);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('ReactJs Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-06-01','true',3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Angular Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-06-01','true' ,3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Java BE','BE',3,'Remote','Senior','2022-10-10','Implement application development using Java (Spring Framework, Hibernate) and other technologies for wide range of Enterprise Applications such as Salesforce, ServiceNow, Dell Boomi','Viettel',2500,'Ha Noi','available','2022-10-05','true' ,1);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Frontend Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','Viettel',3000,'Hanoi','available','2022-11-01','true',1);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('DevOps','DevOps',3,'Remote','Junior','2022-10-10','Configuration of build/deployment pipelines to enable teams to do continuous integration and delivery','Fsoft',1000,'Hanoi','available','2022-10-01','true' ,2);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('ReactJs Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-11-01','true',3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Angular Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-11-01','true' ,3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Java BE','BE',3,'Remote','Senior','2022-10-10','Implement application development using Java (Spring Framework, Hibernate) and other technologies for wide range of Enterprise Applications such as Salesforce, ServiceNow, Dell Boomi','Viettel',2500,'Ha Noi','available','2022-08-05','true' ,1);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Frontend Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','Viettel',3000,'Hanoi','available','2022-10-01','true',1);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('DevOps','DevOps',3,'Remote','Junior','2022-10-10','Configuration of build/deployment pipelines to enable teams to do continuous integration and delivery','Fsoft',1000,'Hanoi','available','2022-10-01','true' ,2);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('ReactJs Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-06-01','true',3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Angular Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-05-01','true' ,3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Java BE','BE',3,'Remote','Senior','2022-10-10','Implement application development using Java (Spring Framework, Hibernate) and other technologies for wide range of Enterprise Applications such as Salesforce, ServiceNow, Dell Boomi','Viettel',2500,'Ha Noi','available','2022-04-05','true' ,1);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Frontend Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','Viettel',3000,'Hanoi','available','2022-03-01','true',1);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('DevOps','DevOps',3,'Remote','Junior','2022-10-10','Configuration of build/deployment pipelines to enable teams to do continuous integration and delivery','Fsoft',1000,'Hanoi','available','2022-04-01','true' ,2);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('ReactJs Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-03-01','true',3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Angular Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-03-01','true' ,3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Java BE','BE',3,'Remote','Senior','2022-10-10','Implement application development using Java (Spring Framework, Hibernate) and other technologies for wide range of Enterprise Applications such as Salesforce, ServiceNow, Dell Boomi','Viettel',2500,'Ha Noi','available','2022-01-05','true' ,1);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Frontend Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','Viettel',3000,'Hanoi','available','2022-01-01','true',1);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('DevOps','DevOps',3,'Remote','Junior','2022-10-10','Configuration of build/deployment pipelines to enable teams to do continuous integration and delivery','Fsoft',1000,'Hanoi','available','2022-12-01','true' ,2);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('ReactJs Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-11-01','true',3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Angular Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-07-01','true' ,3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Java BE','BE',3,'Remote','Senior','2022-10-10','Implement application development using Java (Spring Framework, Hibernate) and other technologies for wide range of Enterprise Applications such as Salesforce, ServiceNow, Dell Boomi','Viettel',2500,'Ha Noi','available','2022-10-05','true' ,1);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Frontend Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','Viettel',3000,'Hanoi','available','2022-05-01','true',1);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('DevOps','DevOps',3,'Remote','Junior','2022-10-10','Configuration of build/deployment pipelines to enable teams to do continuous integration and delivery','Fsoft',1000,'Hanoi','available','2022-07-01','true' ,2);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('ReactJs Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-05-01','true',3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Angular Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-05-01','true' ,3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Java BE','BE',3,'Remote','Senior','2022-10-10','Implement application development using Java (Spring Framework, Hibernate) and other technologies for wide range of Enterprise Applications such as Salesforce, ServiceNow, Dell Boomi','Viettel',2500,'Ha Noi','available','2022-10-05','true' ,1);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Frontend Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','Viettel',3000,'Hanoi','available','2022-09-01','true',1);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('DevOps','DevOps',3,'Remote','Junior','2022-10-10','Configuration of build/deployment pipelines to enable teams to do continuous integration and delivery','Fsoft',1000,'Hanoi','available','2022-10-01','true' ,2);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('ReactJs Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-09-01','true',3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Angular Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-09-01','true' ,3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('DevOps','DevOps',3,'Remote','Junior','2022-10-10','Configuration of build/deployment pipelines to enable teams to do continuous integration and delivery','Fsoft',1000,'Hanoi','available','2022-08-01','true' ,2);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('ReactJs Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-09-01','true',3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Angular Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-09-01','true' ,3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('ReactJs Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-09-01','true',3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Angular Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-09-01','true' ,3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('ReactJs Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-09-01','true',3);
insert into job(title,category,amount,type,level,deadline,description,company_name,salary,location,status,create_at,active,recruiter_id)
values ('Angular Dev','Front-end',3,'Hybrid','Senior','2022-10-10','Develop, maintain and release mobile apps for Android','VCCorp',3000,'Hanoi','available','2022-09-01','true' ,3);



insert into apply(candidate_id,job_id,status,apply_date)
values (1,1,'','2022-10-05');
insert into apply(candidate_id,job_id,status,apply_date)
values (1,2,'Accepted','2022-10-01');
insert into apply(candidate_id,job_id,status,apply_date)
values (2,1,'','2022-09-19');
insert into apply(candidate_id,job_id,status,apply_date)
values (2,2,'','2022-09-19');
insert into apply(candidate_id,job_id,status,apply_date)
values (3,2,'Accepted','2022-09-19');
insert into apply(candidate_id,job_id,status,apply_date)
values (1,4,'','2022-10-25');
insert into apply(candidate_id,job_id,status,apply_date)
values (3,4,'Rejected','2022-09-25');
insert into apply(candidate_id,job_id,status,apply_date)
values (3,3,'','2022-10-25');
insert into apply(candidate_id,job_id,status,apply_date)
values (1,1,'','2022-10-05');
insert into apply(candidate_id,job_id,status,apply_date)
values (1,2,'Accepted','2022-10-01');
insert into apply(candidate_id,job_id,status,apply_date)
values (2,1,'','2022-05-19');
insert into apply(candidate_id,job_id,status,apply_date)
values (2,2,'','2022-10-19');
insert into apply(candidate_id,job_id,status,apply_date)
values (3,4,'Rejected','2022-09-25');
insert into apply(candidate_id,job_id,status,apply_date)
values (1,1,'','2022-10-05');
insert into apply(candidate_id,job_id,status,apply_date)
values (1,2,'Accepted','2022-08-01');
insert into apply(candidate_id,job_id,status,apply_date)
values (2,1,'','2022-08-19');
insert into apply(candidate_id,job_id,status,apply_date)
values (2,2,'','2022-07-19');
insert into apply(candidate_id,job_id,status,apply_date)
values (3,2,'Accepted','2022-07-19');
insert into apply(candidate_id,job_id,status,apply_date)
values (1,4,'','2022-06-25');
insert into apply(candidate_id,job_id,status,apply_date)
values (3,4,'Rejected','2022-06-25');
insert into apply(candidate_id,job_id,status,apply_date)
values (3,3,'','2022-05-25');
insert into apply(candidate_id,job_id,status,apply_date)
values (1,1,'','2022-04-05');
insert into apply(candidate_id,job_id,status,apply_date)
values (1,2,'Accepted','2022-03-01');
insert into apply(candidate_id,job_id,status,apply_date)
values (2,1,'','2022-03-19');
insert into apply(candidate_id,job_id,status,apply_date)
values (2,2,'','2022-02-19');
insert into apply(candidate_id,job_id,status,apply_date)
values (3,2,'Accepted','2022-02-19');
insert into apply(candidate_id,job_id,status,apply_date)
values (1,4,'','2022-01-25');
insert into apply(candidate_id,job_id,status,apply_date)
values (3,4,'Rejected','2022-01-25');
insert into apply(candidate_id,job_id,status,apply_date)
values (3,3,'','2022-12-25');
insert into apply(candidate_id,job_id,status,apply_date)
values (1,1,'','2022-11-05');
insert into apply(candidate_id,job_id,status,apply_date)
values (1,2,'Accepted','2022-10-01');
insert into apply(candidate_id,job_id,status,apply_date)
values (2,1,'','2022-05-19');
insert into apply(candidate_id,job_id,status,apply_date)
values (2,2,'','2022-10-19');
insert into apply(candidate_id,job_id,status,apply_date)
values (3,2,'Accepted','2022-05-19');
insert into apply(candidate_id,job_id,status,apply_date)
values (1,4,'','2022-10-25');
insert into apply(candidate_id,job_id,status,apply_date)
values (3,3,'','2022-10-25');



