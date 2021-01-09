# mouse
mouse 主工程

mouse-client 依赖类包

mouse-db 数据层包

mouse-restful controller层

集成
 springboot
 dubbo
 mybatis
 log4j
 trace链路
 
 UserModel（字段可扩展）
添加鉴权方式 isCheck 默认校验 false 不校验，CheckAuth注解添加需要再添加CurrentUserModel注解 对象为 UserModel

token获取，token解析
