package xyz.wadewhy.springboot_redis01.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @PACKAGE_NAME: xyz.wadewhy.springboot_redis01.pojo
 * @NAME: BaseEntity
 * @Author: 钟子豪
 * @DATE: 2020/3/26
 * @MONTH_NAME_FULL: 三月
 * @DAY: 26
 * @DAY_NAME_FULL: 星期四
 * @PROJECT_NAME: springboot_redis01
 **/
//数据库表中都需要id来表示编号，id是这些映射实体类的通用的属性，
// 交给jpa统一生成主键id编号，那么使用一个父类来封装这些通用属性，并用@MappedSuperclas标识
@MappedSuperclass
public class BaseEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    protected String id;

    @Column(name= "create_date") //创建时间
            Date createDate = new Date();

    @Column(name= "update_date")//修改时间
            Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
