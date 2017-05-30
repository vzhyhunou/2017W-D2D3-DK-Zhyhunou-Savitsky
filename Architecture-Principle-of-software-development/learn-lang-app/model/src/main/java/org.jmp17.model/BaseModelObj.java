package org.jmp17.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by antonsavitsky on 2/11/17.
 */
@MappedSuperclass
public class BaseModelObj {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    public BaseModelObj(Integer id){
        this.id = id;
    }

    public BaseModelObj(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
