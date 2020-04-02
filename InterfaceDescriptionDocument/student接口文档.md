# student接口文档

## 获取所有学生信息

#### 接口说明:
	
#### 接口URL:
	http://127.0.0.1:8080/emp/getAllEmp
#### 请求方式:
	GET
#### 接口参数：
    无

#### 接口参数说明:  
	无
	
#### 接口输出:  
	[
	  {
		"id": 1,
		"lastName": "dfsdsfsdsf",
		"gender": 12,
		"email": "ilove1123",
		"dId": 12
	  },
	  {
		"id": 5,
		"lastName": "ppp",
		"gender": 2,
		"email": "hdewu",
		"dId": 12
	  }
	]

## 新增学生信息

#### 接口说明:
	
#### 接口URL:
	http://127.0.0.1:8080/emp/saveEmp
#### 请求方式:
	POST
#### 接口参数：
    学生对象

#### 接口参数说明:  
		{
		"employeeLst":[{
				"lastName": "dfsdsfsdsf",
				"gender": 12,
				"email": "ilove1123",
				"dId": 12
				}]
		}
	
#### 接口输出:  
		{
		  "message": "保存成功",
		  "status": "200"     //200成功，其他失败
		}

## 删除学生信息

#### 接口说明:
	
#### 接口URL:
	http://127.0.0.1:8080/emp/delEmp/{ids}
#### 请求方式:
	DELETE
#### 接口参数：
    id以英文逗号分隔的字符串

#### 接口参数说明:  
	
	
#### 接口输出:  
	{
	  "message": "保存成功",
	  "status": "200"     //200成功，其他失败
	}
		
## 获取单个学生信息

#### 接口说明:
	
#### 接口URL:
	http://127.0.0.1:8080/emp/getEmp/{id}
#### 请求方式:
	GET
#### 接口参数：
    在连接最后跟上ID

#### 接口参数说明:  
	无
	
#### 接口输出:  
	{
	  "id": 5,
	  "lastName": "ppp",
	  "gender": 2,
	  "email": "hdewu",
	  "dId": 12
	}
	
## 更新单个学生信息

#### 接口说明:
	
#### 接口URL:
	http://127.0.0.1:8080/emp/updateEmp
#### 请求方式:
	PUT
#### 接口参数：
    学生对象

#### 接口参数说明:  
	{
	  "id": 5,
	  "lastName": "ppp",
	  "gender": 2,
	  "email": "hdewu",
	  "dId": 12
	}
	
#### 接口输出:  
	{
	  "message": "保存成功",
	  "status": "200"     //200成功，其他失败
	}

	
	
    