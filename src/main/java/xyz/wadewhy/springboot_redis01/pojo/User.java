package xyz.wadewhy.springboot_redis01.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @PACKAGE_NAME: xyz.wadewhy.springboot_redis01.pojo
 * @NAME: User
 * @Author: 钟子豪
 * @DATE: 2020/3/26
 * @MONTH_NAME_FULL: 三月
 * @DAY: 26
 * @DAY_NAME_FULL: 星期四
 * @PROJECT_NAME: springboot_redis01
 **/
@Entity
@Table(name = "user")
@Data
public class User extends BaseEntity{
    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "age")
    private int age;
}

