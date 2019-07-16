/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api.dao;

import com.mycompany.api.model.Topic;
import java.util.List;

/**
 *
 * @author chiraran
 */
public interface TopicDAO {
    public abstract Topic getTopic(int id);//GET
    public abstract void deleteTopic(int id);//DELETE
    public abstract void updateTopic(Topic topic);//PUT
    public abstract List<Topic> getTopics();//PUT
    public abstract void addTopic(Topic t);//POST   
}
