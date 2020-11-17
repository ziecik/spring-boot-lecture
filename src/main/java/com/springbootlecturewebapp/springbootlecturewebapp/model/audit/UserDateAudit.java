package com.springbootlecturewebapp.springbootlecturewebapp.model.audit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.User;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creatorUser", "modifierUser"})
public abstract class UserDateAudit extends DateAudit {

    @CreatedBy
    private String creatorUser;

    @LastModifiedBy
    private String modifierUser;

    public String getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(String creatorUser) {
        this.creatorUser = creatorUser;
    }

    public String getModifierUser() {
        return modifierUser;
    }

    public void setModifierUser(String modifierUser) {
        this.modifierUser = modifierUser;
    }
}
